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

@RestController
@Slf4j
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalServiceFinder animalServiceFinder;

    @GetMapping("/sound")
    public String sound(@RequestParam String type) {
        AnimalService service = animalServiceFinder.find(type);
        return service.getSound();
    }
}
