package com.spiros.view.transformer;

import com.spiros.common.model.User;
import com.spiros.view.model.UserVo;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserVoTransformer implements VisualTransformer<UserVo, User> {

    @Autowired
    private CityVoTransformer cityVoTransformer;

    @Override
    public Optional<User> fromVisualToTransfer(@Nullable final UserVo visual) {
        if (visual != null) {
            final User user = new User();
            user.setId(visual.getId());
            user.setFirstName(visual.getFirstName());
            user.setLastName(visual.getLastName());
            user.setUsername(visual.getUsername());
            user.setCity(cityVoTransformer
                    .fromVisualToTransfer(visual.getCity())
                    .orElse(null));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserVo> fromTransferToVisual(@Nullable final User transfer) {
        if (transfer != null) {
            final UserVo userVo = new UserVo();
            userVo.setId(transfer.getId());
            userVo.setFirstName(transfer.getFirstName());
            userVo.setLastName(transfer.getLastName());
            userVo.setUsername(transfer.getUsername());
            userVo.setCity(cityVoTransformer
                    .fromTransferToVisual(transfer.getCity())
                    .orElse(null));
            return Optional.of(userVo);
        }
        return Optional.empty();
    }
}
