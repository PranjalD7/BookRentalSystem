package com.example.bookrental.DAO;

import com.example.bookrental.Entities.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBook, Long> {
    UserBook findByUsername(String userName);
}