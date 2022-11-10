package com.multicomponent.callmulticomponent.service;

import com.multicomponent.callmulticomponent.domain.AnimalType;
import org.springframework.stereotype.Component;

@Component
public class CatService implements AnimalService{
    @Override
    public String getSound(){
        return "야옹";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.CAT;
    }
}
