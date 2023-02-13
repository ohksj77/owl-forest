package com.cbu.backend.bookborrow;

import com.cbu.backend.bookborrow.dto.BookBorrowRequest;
import com.cbu.backend.bookborrow.dto.BookBorrowResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("book-borrows")
public class BookBorrowController {
    private final BookBorrowService bookBorrowService;

    @PostMapping
    public ResponseEntity<BookBorrowResponse> save(@RequestBody @Valid BookBorrowRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookBorrowService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookBorrowResponse>> findAll(
            @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(bookBorrowService.findAll(pageable));
    }

    @GetMapping(params = "bookName")
    public ResponseEntity<List<BookBorrowResponse>> findAllByBookName(
            @RequestParam String bookName) {
        return ResponseEntity.ok(bookBorrowService.findAllByBookName(bookName));
    }
}
