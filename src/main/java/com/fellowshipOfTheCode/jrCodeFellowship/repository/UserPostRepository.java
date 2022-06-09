package com.fellowshipOfTheCode.jrCodeFellowship.repository;

import com.fellowshipOfTheCode.jrCodeFellowship.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.DateFormat;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {
    UserPost findByTimestamp(DateFormat timestamp);
}
