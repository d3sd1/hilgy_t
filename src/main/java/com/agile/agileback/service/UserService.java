package com.agile.agileback.service;

import com.agile.agileback.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository bookRepository;

    public UserService(UserRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private void checkoutBook() {

    }

    private void returnBook() {

    }
}
