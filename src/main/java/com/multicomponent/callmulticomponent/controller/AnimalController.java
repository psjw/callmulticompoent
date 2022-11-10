package com.multicomponent.callmulticomponent.controller;

// type -> cat -> CatService
// type -> dog -> DogService

// cat -> 냐옹
// dog -> 멍멍


import com.multicomponent.callmulticomponent.domain.AnimalType;
import com.multicomponent.callmulticomponent.service.AnimalService;
import com.multicomponent.callmulticomponent.service.AnimalServiceFinder;
import com.multicomponent.callmulticomponent.service.CatService;
import com.multicomponent.callmulticomponent.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Map;

// 1. component list 주입
// 2. map (key: beanName, value : service)
// 3. enum

@RestController
@Slf4j
@RequiredArgsConstructor
public class AnimalController {
//    private final AnimalServiceFinder animalServiceFinder;

    private final Map<String, AnimalService> animalServices;

    @GetMapping("/sound")
    public String sound(@RequestParam String type) {
        log.info("animalService={}, keys={}",animalServices, animalServices.keySet());
        AnimalType animalType = AnimalType.valueOf(type);
        AnimalService animalService = animalType.create();
        return animalService.getSound();
    }
}
