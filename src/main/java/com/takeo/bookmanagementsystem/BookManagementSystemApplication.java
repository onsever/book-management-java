package com.takeo.bookmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManagementSystemApplication.class, args);
    }

}

/*
Book Management System API Requirements:
1. User and Registration Form
    -> Provide a data source to the Spring application to connect to the MySQL database. (also create book_db database in MySQL) X
    -> Create a User Entity X
    -> Create a Repository and Service for User Entity X
    -> Create a User Controller class for HTTP request mappings (Get user by id, Delete user by id, Update user) - RUD operations

2. Authentication
    -> Auth Controller class for handling the authentication.
        -> Register (creating a new user inside the database, validation logic)
        -> Login (we will send username and password as request, find the user with that username, we will send response about currently logged-in user)
    -> For now, simple - User (password) - Auth Controller (User Repository)

Front-end:
* Fetch the API Call
* username, password
 */
