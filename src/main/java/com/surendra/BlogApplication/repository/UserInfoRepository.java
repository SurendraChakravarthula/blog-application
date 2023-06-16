package com.surendra.BlogApplication.repository;

import com.surendra.BlogApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
}
