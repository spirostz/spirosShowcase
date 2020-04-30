package com.spiros.persistance.transformer;


import com.spiros.common.model.User;
import com.spiros.persistance.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer implements EntityTransformer<UserEntity, User> {

    @Autowired
    private CityTransformer cityTransformer;

    @Override
    public User fromEntityToTransfer(final UserEntity entity) {
        final User user = new User();
        user.setId(entity.getId());
        user.setCreateDateTime(entity.getCreateDateTime());
        user.setUpdateDateTime(entity.getUpdateDateTime());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setUsername(entity.getUsername());
        if (entity.getCity() != null) {
            user.setCity(cityTransformer.fromEntityToTransfer(entity.getCity()));
        }
        return user;
    }

    @Override
    public UserEntity fromTransferToEntity(final User transfer) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setId(transfer.getId());
        userEntity.setCreateDateTime(transfer.getCreateDateTime());
        userEntity.setUpdateDateTime(transfer.getUpdateDateTime());
        userEntity.setFirstName(transfer.getFirstName());
        userEntity.setLastName(transfer.getLastName());
        userEntity.setUsername(transfer.getUsername());
        if (transfer.getCity() != null) {
            userEntity.setCity(cityTransformer.fromTransferToEntity(transfer.getCity()));
        }
        return userEntity;
    }
}
