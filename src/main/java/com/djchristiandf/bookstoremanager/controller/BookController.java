package com.djchristiandf.bookstoremanager.controller;

import com.djchristiandf.bookstoremanager.dto.BookDTO;
import com.djchristiandf.bookstoremanager.dto.MessageResponseDTO;
import com.djchristiandf.bookstoremanager.exception.BookNotFoundException;
import com.djchristiandf.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }
}
