package com.multicomponent.callmulticomponent.controller;

// type -> cat -> CatService
// type -> dog -> DogService

// cat -> 냐옹
// dog -> 멍멍


import com.multicomponent.callmulticomponent.service.CatService;
import com.multicomponent.callmulticomponent.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AnimalController {

    @GetMapping("/sound")
    public String sound(@RequestParam String type) {
        if (type.equals("CAT")) {
            return new CatService().getSound();
        } else if (type.equals("DOG")) {
            return new DogService().getSound();
        } else {
            return "모르는 동물";
        }
    }
}
