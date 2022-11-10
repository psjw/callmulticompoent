package com.multicomponent.callmulticomponent.controller;

// type -> cat -> CatService
// type -> dog -> DogService

// cat -> 냐옹
// dog -> 멍멍


import com.multicomponent.callmulticomponent.domain.AnimalType;
import com.multicomponent.callmulticomponent.service.AnimalService;
import com.multicomponent.callmulticomponent.service.CatService;
import com.multicomponent.callmulticomponent.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AnimalController {
    private final List<AnimalService> animalServices;

    public AnimalController(List<AnimalService> animalServices) {
        this.animalServices = animalServices;
    }

    @GetMapping("/sound")
    public String sound(@RequestParam String type) {
        log.info("animalServices={}",animalServices);

        AnimalService service = animalServices.stream()
//                .filter(animalService -> animalService.getType().name().equals(type))
                .filter(animalService -> animalService.getType() == AnimalType.valueOf(type))
                .findAny()
                .orElseThrow(RuntimeException::new);

        return service.getSound();
//        if (type.equals("CAT")) {
//            return new CatService().getSound();
//        } else if (type.equals("DOG")) {
//            return new DogService().getSound();
//        } else {
//            return "모르는 동물";
//        }
    }
}
