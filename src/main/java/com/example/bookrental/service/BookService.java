package com.example.bookrental.service;

import com.example.bookrental.DAO.BooksRepository;
import com.example.bookrental.Entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

  @Autowired
    BooksRepository bRep;

    public void save(Books book) {
        bRep.save(book);
    }

    public List<Books> findAll()
    {
        return bRep.findAll();

    }

    public Optional<Books> findById(long  id)
    {
        return bRep.findById(id);
    }


    public List<Books> findBooksByCategory(String category) {
        return bRep.findBooksByCategory(category);
    }

    public List<Books> findBooksByName(String name) {
        return bRep.findBooksBybookName(name);
    }

    public String deleteBook(long id)
    {
        bRep.delete(bRep.findById(id).get());
        return "DELETED BOOK";

    }

}
