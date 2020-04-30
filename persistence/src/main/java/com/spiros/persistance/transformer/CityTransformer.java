package com.spiros.persistance.transformer;


import com.spiros.common.model.City;
import com.spiros.persistance.entity.CityEntity;

import org.springframework.stereotype.Component;

@Component
public class CityTransformer implements EntityTransformer<CityEntity, City> {

    @Override
    public City fromEntityToTransfer(final CityEntity entity) {
        final City city = new City();
        city.setId(entity.getId());
        city.setCreateDateTime(entity.getCreateDateTime());
        city.setUpdateDateTime(entity.getUpdateDateTime());
        city.setName(entity.getName());
        return city;
    }

    @Override
    public CityEntity fromTransferToEntity(final City transfer) {
        final CityEntity cityEntity = new CityEntity();
        cityEntity.setId(transfer.getId());
        cityEntity.setCreateDateTime(transfer.getCreateDateTime());
        cityEntity.setUpdateDateTime(transfer.getUpdateDateTime());
        cityEntity.setName(transfer.getName());
        return cityEntity;
    }


}
