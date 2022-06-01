package com.example.bookrental.Entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Entity;


@Entity
public class Books {
    @Id
    @Column(name="bookId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookId;
    private String bookName;
    private String category;
    private int units;
    private LocalDate pickupDate=null;
    private LocalDate returnDate=null;
    public Books( String bookName, String category, int units) {
        this.bookName = bookName;
        this.category = category;
        this.units = units;
    }
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private UserBook reservedByUser;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private UserBook theUser;

    public UserBook getReservedByUser() {
        return reservedByUser;
    }

    public void setReservedByUser(UserBook reservedByUser) {
        this.reservedByUser = reservedByUser;
    }

    public UserBook getTheUser() {
        return theUser;
    }

    public void setTheUser(UserBook theUser) {
        this.theUser = theUser;
    }

    public Books()
    {

    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

