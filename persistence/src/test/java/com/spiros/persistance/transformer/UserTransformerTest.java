package com.spiros.persistance.transformer;

import com.spiros.common.model.City;
import com.spiros.common.model.User;
import com.spiros.persistance.entity.CityEntity;
import com.spiros.persistance.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class UserTransformerTest {

    @InjectMocks
    private UserTransformer userTransformer;

    @Mock
    private CityTransformer cityTransformer;

    @Test
    void fromEntityToTransfer() {
        final UserEntity userEntity = new UserEntity();
        userEntity.setId(5L);
        userEntity.setCreateDateTime(LocalDateTime.MIN);
        userEntity.setUpdateDateTime(LocalDateTime.MAX);
        userEntity.setFirstName("First");
        userEntity.setLastName("Second");
        userEntity.setUsername("Username");
        userEntity.setCity(null);

        final User user = userTransformer.fromEntityToTransfer(userEntity);

        assertEquals(5L, user.getId());
        assertEquals(LocalDateTime.MIN, user.getCreateDateTime());
        assertEquals(LocalDateTime.MAX, user.getUpdateDateTime());
        assertEquals("First", user.getFirstName());
        assertEquals("Second", user.getLastName());
        assertEquals("Username", user.getUsername());
        Mockito.verify(cityTransformer, Mockito.never()).fromEntityToTransfer(Mockito.any());

        userEntity.setCity(new CityEntity());
        userTransformer.fromEntityToTransfer(userEntity);
        Mockito.verify(cityTransformer, Mockito.times(1)).fromEntityToTransfer(userEntity.getCity());

    }

    @Test
    void fromTransferToEntity() {
        final User user = new User();
        user.setId(5L);
        user.setCreateDateTime(LocalDateTime.MIN);
        user.setUpdateDateTime(LocalDateTime.MAX);
        user.setFirstName("First");
        user.setLastName("Second");
        user.setUsername("Username");
        user.setCity(null);

        final UserEntity userEntity = userTransformer.fromTransferToEntity(user);

        assertEquals(5L, userEntity.getId());
        assertEquals(LocalDateTime.MIN, userEntity.getCreateDateTime());
        assertEquals(LocalDateTime.MAX, userEntity.getUpdateDateTime());
        assertEquals("First", userEntity.getFirstName());
        assertEquals("Second", userEntity.getLastName());
        assertEquals("Username", userEntity.getUsername());
        Mockito.verify(cityTransformer, Mockito.never()).fromTransferToEntity(Mockito.any());

        user.setCity(new City());
        userTransformer.fromTransferToEntity(user);
        Mockito.verify(cityTransformer, Mockito.times(1)).fromTransferToEntity(user.getCity());
    }
}