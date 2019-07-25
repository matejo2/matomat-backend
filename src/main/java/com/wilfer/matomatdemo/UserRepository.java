package com.wilfer.matomatdemo;

import com.wilfer.matomatdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
