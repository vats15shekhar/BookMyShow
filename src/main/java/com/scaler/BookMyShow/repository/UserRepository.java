package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
