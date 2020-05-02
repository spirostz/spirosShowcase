package com.spiros.view.transformer;

import com.spiros.common.model.City;
import com.spiros.common.model.User;
import com.spiros.view.model.CityVo;
import com.spiros.view.model.UserVo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ActiveProfiles("test")
class UserVoTransformerTest {

    @InjectMocks
    private UserVoTransformer userVoTransformer;

    @Mock
    private CityVoTransformer cityVoTransformer;

    @Test
    void fromVisualToTransfer() {
        final UserVo userVo = new UserVo();
        userVo.setId(5L);
        userVo.setFirstName("First");
        userVo.setLastName("Second");
        userVo.setUsername("Username");
        userVo.setCity(null);

        final User user = userVoTransformer.fromVisualToTransfer(userVo).get();

        assertEquals(5L, user.getId());
        assertEquals("First", user.getFirstName());
        assertEquals("Second", user.getLastName());
        assertEquals("Username", user.getUsername());
        assertNull(user.getCreateDateTime());
        assertNull(user.getUpdateDateTime());
        Mockito.verify(cityVoTransformer, Mockito.times(1))
                .fromVisualToTransfer(null);

        userVo.setCity(new CityVo());
        userVoTransformer.fromVisualToTransfer(userVo);
        Mockito.verify(cityVoTransformer, Mockito.times(1))
                .fromVisualToTransfer(userVo.getCity());
    }

    @Test
    void fromTransferToVisual() {
        final User user = new User();
        user.setId(5L);
        user.setFirstName("First");
        user.setLastName("Second");
        user.setUsername("Username");
        user.setCity(null);

        final UserVo userVo = userVoTransformer.fromTransferToVisual(user).get();

        assertEquals(5L, userVo.getId());
        assertEquals("First", userVo.getFirstName());
        assertEquals("Second", userVo.getLastName());
        assertEquals("Username", userVo.getUsername());
        Mockito.verify(cityVoTransformer, Mockito.times(1))
                .fromTransferToVisual(null);

        user.setCity(new City());
        userVoTransformer.fromTransferToVisual(user);
        Mockito.verify(cityVoTransformer, Mockito.times(1))
                .fromTransferToVisual(user.getCity());
    }
}