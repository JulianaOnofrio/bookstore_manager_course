package com.julianaonofrio.bookstoremanager.service;

import com.julianaonofrio.bookstoremanager.dto.BookDTO;
import com.julianaonofrio.bookstoremanager.entity.Book;
import com.julianaonofrio.bookstoremanager.exception.BookNotFoundException;
import com.julianaonofrio.bookstoremanager.repository.BookRepository;
import com.julianaonofrio.bookstoremanager.utils.BookUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    public static final com.julianaonofrio.bookstoremanager.entity.Book FAKE_BOOK = BookUtils.createFakeBook();
    @Mock
    private BookRepository bookRepository;
    
    @InjectMocks
    private BookService bookService;

    @Test
    void whenGivenExistingIdThenReturnThisBook() throws BookNotFoundException {
        Book expectedFoundBook = BookUtils.createFakeBook();
        when(bookRepository.findById(expectedFoundBook.getId())).thenReturn(Optional.of(expectedFoundBook));

        BookDTO bookDTO = bookService.findById(expectedFoundBook.getId());

        assertEquals(expectedFoundBook.getName(), bookDTO.getName());
        assertEquals(expectedFoundBook.getIsbn(), bookDTO.getIsbn());
        assertEquals(expectedFoundBook.getPublisherName(), bookDTO.getPublisherName());
    }

}
