package com.spiros.core.service;

import com.spiros.common.model.User;
import com.spiros.persistance.entity.CityEntity;
import com.spiros.persistance.entity.UserEntity;
import com.spiros.persistance.repository.CityRepo;
import com.spiros.persistance.repository.UserRepo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CityRepo cityRepo;

    private CityEntity cityEntity;
    private UserEntity userEntity;

    @BeforeAll
    public void beforeAll() {
        cityEntity = new CityEntity();
        cityEntity.setName("Rome");
        cityEntity = cityRepo.save(cityEntity);

        userEntity = new UserEntity();
        userEntity.setCity(cityEntity);
        userEntity.setFirstName("First");
        userEntity.setLastName("Last");
        userEntity.setUsername("User");
        userEntity.setCity(cityEntity);
        userRepo.save(userEntity);
    }

    @Test
    void fetchById() {

        final User user = userService.fetchById(userEntity.getId()).get();

        assertEquals(userEntity.getId(), user.getId());
        assertNotNull(user.getCreateDateTime());
        assertNotNull(user.getUpdateDateTime());
        assertEquals("First", user.getFirstName());
        assertEquals("Last", user.getLastName());
        assertEquals("User", user.getUsername());

        assertEquals(cityEntity.getId(), user.getCity().getId());
        assertEquals("Rome", user.getCity().getName());
        assertNotNull(user.getCity().getCreateDateTime());
        assertNotNull(user.getCity().getUpdateDateTime());
    }

    @Test
    void fetchByUsername() {

        final User user = userService.fetchByUsername("User").get();

        assertEquals(userEntity.getId(), user.getId());
        assertNotNull(user.getCreateDateTime());
        assertNotNull(user.getUpdateDateTime());
        assertEquals("First", user.getFirstName());
        assertEquals("Last", user.getLastName());
        assertEquals("User", user.getUsername());

        assertEquals(cityEntity.getId(), user.getCity().getId());
        assertEquals("Rome", user.getCity().getName());
        assertNotNull(user.getCity().getCreateDateTime());
        assertNotNull(user.getCity().getUpdateDateTime());
    }
}