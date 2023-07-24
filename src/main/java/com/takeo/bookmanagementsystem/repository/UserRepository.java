package com.takeo.bookmanagementsystem.repository;

import com.takeo.bookmanagementsystem.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}

/*
JpaRepository
    - CrudRepository
    - PaginationAndSortingRepository
 */
