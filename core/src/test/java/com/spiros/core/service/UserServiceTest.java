package com.spiros.core.service;

import com.spiros.common.model.User;
import com.spiros.persistance.entity.CityEntity;
import com.spiros.persistance.entity.UserEntity;
import com.spiros.persistance.repository.CityRepo;
import com.spiros.persistance.repository.UserRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CityRepo cityRepo;

    @Test
    void fetchById() {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName("Rome");
        cityEntity = cityRepo.save(cityEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setCity(cityEntity);
        userEntity.setFirstName("First");
        userEntity.setLastName("Last");
        userEntity.setUsername("User");
        userEntity.setCity(cityEntity);
        userEntity = userRepo.save(userEntity);

        final User user = userService.fetchById(userEntity.getId());

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