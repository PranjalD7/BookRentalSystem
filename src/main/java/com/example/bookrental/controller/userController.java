package com.example.bookrental.controller;


import com.example.bookrental.Entities.Books;
import com.example.bookrental.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

     @Autowired
     BookService bs;
    @GetMapping(value = "/viewBooks")
    public List<Books> AllBooks() {
        return bs.findAll();
    }

    @GetMapping(value = "/viewBooksByCategory/{category}")
    public List<Books> BooksByCategory(@PathVariable String category)
    {
        return bs.findBooksByCategory(category);
    }
    @GetMapping(value = "/viewBooksByName/{name}")
    public List<Books> BooksByName(@PathVariable String name)
    {
        return bs.findBooksByName(name);
    }

    @PutMapping(value = "/Reservations/{id}")
    public String bookReservation(@PathVariable long  id,@RequestParam("pickupDate") String pickupDate,@RequestParam("returnDate") String returnDate)
    {

        Books bk = bs.findById(id).get();
        bk.setPickupDate(LocalDate.parse(pickupDate));
        bk.setReturnDate(LocalDate.parse(returnDate));
        bs.save(bk);
        return "Book has been reserved";

    }



}
