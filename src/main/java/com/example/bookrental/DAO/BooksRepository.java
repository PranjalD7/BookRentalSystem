package com.example.bookrental.DAO;

import com.example.bookrental.Entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    public List<Books> findBooksByCategory(String category);
    public List<Books>  findBooksBybookName(String name);

}