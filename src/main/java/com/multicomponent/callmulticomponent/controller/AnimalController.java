package com.multicomponent.callmulticomponent.controller;

// type -> cat -> CatService
// type -> dog -> DogService

// cat -> 냐옹
// dog -> 멍멍


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AnimalController {

    @GetMapping("/sound")
    public String sound(@RequestParam String type){
        if(type.equals("CAT")) {
            return "야옹";
        } else if (type.equals("DOG")){
            return "멍멍";
        }else{
            return "모르는 동물";
        }
    }
}
