package com.example.bookrental.controller;
import com.example.bookrental.Entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.bookrental.service.BookService;

import javax.persistence.PostRemove;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value="/admin")
public class adminController {

    @Autowired
    private BookService bs;

    @GetMapping
    public String adminHome()
    {
        return "adminHome";
    }
    @ResponseBody
    @GetMapping(value = "/viewBooks")
    public List<Books> AllBooks() {

        return bs.findAll();
    }
    @ResponseBody
    @PostMapping(value = "/addBooks")
    public Books addNewBook(@RequestParam("bookName") String bookName, @RequestParam("units") int units, @RequestParam("category") String category) {
        Books addNew = new Books(bookName, category, units);
        bs.save(addNew);
        return addNew;
    }
    @ResponseBody
    @RequestMapping(value = "/editBooks")
    public String editBook(@RequestParam long  id, @RequestParam("bookName") String bookName, @RequestParam("units") int units, @RequestParam("category") String category, @RequestParam("pickupDate") String pickupDate, @RequestParam("returnDate") String returnDate) {

        Books bk = bs.findById(id).get();
        bk.setBookName(bookName);
        bk.setUnits(units);
        bk.setCategory(category);
        bk.setPickupDate(LocalDate.parse(pickupDate));
        bk.setReturnDate(LocalDate.parse(returnDate));
        bs.save(bk);
        return "book data updated";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBook")
    public String deleteBook(@RequestParam long  id)
    {
        bs.deleteBook(id);
        return "Book Deleted";
    }








}
