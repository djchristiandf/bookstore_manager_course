package com.djchristiandf.bookstoremanager.service;

import com.djchristiandf.bookstoremanager.dto.BookDTO;
import com.djchristiandf.bookstoremanager.dto.MessageResponseDTO;
import com.djchristiandf.bookstoremanager.entity.Book;
import com.djchristiandf.bookstoremanager.mapper.BookMapper;
import com.djchristiandf.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){
        //transform bookDTO in Book entity
        Book bookToSave = bookMapper.toModel(bookDTO);
        Book saveBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder().message("Book created with ID " + saveBook.getId()).build();
    }

    public BookDTO findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDTO(optionalBook.get());
    }
}
