package com.spiros.view.transformer;

import com.spiros.common.model.City;
import com.spiros.view.model.CityVo;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CityVoTransformer implements VisualTransformer<CityVo, City> {

    @Override
    public Optional<City> fromVisualToTransfer(@Nullable final CityVo visual) {
        if (visual != null) {
            final City city = new City();
            city.setId(visual.getId());
            city.setName(visual.getName());
            return Optional.of(city);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CityVo> fromTransferToVisual(@Nullable final City transfer) {
        if (transfer != null) {
            final CityVo cityVo = new CityVo();
            cityVo.setId(transfer.getId());
            cityVo.setName(transfer.getName());
            return Optional.of(cityVo);
        }
        return Optional.empty();
    }
}
