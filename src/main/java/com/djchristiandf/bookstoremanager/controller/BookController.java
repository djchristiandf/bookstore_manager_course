package com.djchristiandf.bookstoremanager.controller;

import com.djchristiandf.bookstoremanager.dto.BookDTO;
import com.djchristiandf.bookstoremanager.dto.MessageResponseDTO;
import com.djchristiandf.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO book){
        return bookService.create(book);
    }
}
