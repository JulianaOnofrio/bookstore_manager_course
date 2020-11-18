package com.julianaonofrio.bookstoremanager.repository;

import com.julianaonofrio.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
