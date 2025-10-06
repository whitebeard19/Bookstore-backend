package com.bookstorelite.backend.service;

import com.bookstorelite.backend.dto.BookRequest;
import com.bookstorelite.backend.dto.BookResponse;
import com.bookstorelite.backend.entity.Book;
import com.bookstorelite.backend.exception.ResourceNotFoundException;
import com.bookstorelite.backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    private BookResponse toDto(Book book){
        BookResponse dto = new BookResponse();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        dto.setStock(book.getStock());
        return dto;
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BookResponse getBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id" + id));
        return toDto(book);
    }

    public BookResponse createBook(BookRequest req){
        Book book = new Book();
        book.setTitle(req.getTitle());
        book.setAuthor(req.getAuthor());
        book.setPrice(req.getPrice());
        book.setStock(req.getStock());

        return toDto(bookRepository.save(book));
    }

    public BookResponse updateBook(Long id, BookRequest req){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id" + id));

        book.setTitle(req.getTitle());
        book.setAuthor(req.getAuthor());
        book.setPrice(req.getPrice());
        book.setStock(req.getStock());

        return toDto(bookRepository.save(book));
    }

    public void deleteBook(Long id){
        if (!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Book not found with id" + id);
        }
        bookRepository.deleteById(id);
    }
}
