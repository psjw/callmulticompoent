package com.multicomponent.callmulticomponent.domain;

import com.multicomponent.callmulticomponent.service.AnimalService;
import com.multicomponent.callmulticomponent.service.CatService;
import com.multicomponent.callmulticomponent.service.DogService;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationTargetException;

@RequiredArgsConstructor
public enum AnimalType {
    DOG(DogService.class),
    CAT(CatService.class);

    private final Class<? extends AnimalService> animalService;

    public AnimalService create(){
        try {
            return animalService.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

}
