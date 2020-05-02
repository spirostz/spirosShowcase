package com.spiros.persistance.transformer;


import com.spiros.common.model.User;
import com.spiros.persistance.entity.UserEntity;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserTransformer implements EntityTransformer<UserEntity, User> {

    @Autowired
    private CityTransformer cityTransformer;

    @Override
    public Optional<User> fromEntityToTransfer(@Nullable final UserEntity entity) {
        if (entity != null) {
            final User user = new User();
            user.setId(entity.getId());
            user.setCreateDateTime(entity.getCreateDateTime());
            user.setUpdateDateTime(entity.getUpdateDateTime());
            user.setFirstName(entity.getFirstName());
            user.setLastName(entity.getLastName());
            user.setUsername(entity.getUsername());
            user.setCity(cityTransformer
                    .fromEntityToTransfer(entity.getCity())
                    .orElse(null));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserEntity> fromTransferToEntity(@Nullable final User transfer) {
        if (transfer != null) {

            final UserEntity userEntity = new UserEntity();
            userEntity.setId(transfer.getId());
            userEntity.setCreateDateTime(transfer.getCreateDateTime());
            userEntity.setUpdateDateTime(transfer.getUpdateDateTime());
            userEntity.setFirstName(transfer.getFirstName());
            userEntity.setLastName(transfer.getLastName());
            userEntity.setUsername(transfer.getUsername());
            userEntity.setCity(cityTransformer
                    .fromTransferToEntity(transfer.getCity())
                    .orElse(null));
            return Optional.of(userEntity);
        }
        return Optional.empty();
    }

}
