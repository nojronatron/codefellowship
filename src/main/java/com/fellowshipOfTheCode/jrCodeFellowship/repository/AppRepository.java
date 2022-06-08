package com.fellowshipOfTheCode.jrCodeFellowship.repository;

import com.fellowshipOfTheCode.jrCodeFellowship.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
