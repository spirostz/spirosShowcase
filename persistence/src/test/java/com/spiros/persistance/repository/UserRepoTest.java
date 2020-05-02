package com.spiros.persistance.repository;

import com.spiros.persistance.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    void findByUsername() {
        final UserEntity userEntity = new UserEntity();
        userEntity.setUsername("user");
        userEntity.setFirstName("first");
        userEntity.setLastName("last");
        userRepo.save(userEntity);

        assertTrue(userRepo.findByUsername("user").isPresent());
        assertFalse(userRepo.findByUsername("other").isPresent());
        assertFalse(userRepo.findByUsername(null).isPresent());

    }
}