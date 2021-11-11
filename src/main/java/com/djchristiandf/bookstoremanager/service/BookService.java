package com.djchristiandf.bookstoremanager.service;

import com.djchristiandf.bookstoremanager.dto.MessageResponseDTO;
import com.djchristiandf.bookstoremanager.entity.Book;
import com.djchristiandf.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book){
        Book saveBook = bookRepository.save(book);
        return MessageResponseDTO.builder().message("Book created with ID " + saveBook.getId()).build();
    }
}
