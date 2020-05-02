package com.spiros.persistance.transformer;


import com.spiros.common.model.City;
import com.spiros.persistance.entity.CityEntity;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CityTransformer implements EntityTransformer<CityEntity, City> {

    @Override
    public Optional<City> fromEntityToTransfer(@Nullable final CityEntity entity) {
        if (entity != null) {
            final City city = new City();
            city.setId(entity.getId());
            city.setCreateDateTime(entity.getCreateDateTime());
            city.setUpdateDateTime(entity.getUpdateDateTime());
            city.setName(entity.getName());
            return Optional.of(city);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CityEntity> fromTransferToEntity(@Nullable final City transfer) {
        if (transfer != null) {

            final CityEntity cityEntity = new CityEntity();
            cityEntity.setId(transfer.getId());
            cityEntity.setCreateDateTime(transfer.getCreateDateTime());
            cityEntity.setUpdateDateTime(transfer.getUpdateDateTime());
            cityEntity.setName(transfer.getName());
            return Optional.of(cityEntity);
        }
        return Optional.empty();
    }


}
