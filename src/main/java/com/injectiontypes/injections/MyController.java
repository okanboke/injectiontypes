package com.injectiontypes.injections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    /*
    Injection Yöntemleri
    Field Injection
    Setter Injection
    Constructor Injection

     */

    @Autowired
    private FirstClass firstClass; //Field Injection!

    private SecondClass secondClass; //Setter Injection!

    private ThirdClass thirdClass; //Constructor Injection!

    public MyController(ThirdClass thirdClass) { //Constructor Injection!
        this.thirdClass = thirdClass;
    }

    @GetMapping("/names")
    public String getNameOfClasses() {
        return this.firstClass.getName() + "." + //Field Injection
                this.secondClass.getName() + "." + //Setter Injection
                this.thirdClass.getName();  //Constructor Injection
    }

    @Autowired
    public void setSecondClass(SecondClass secondClass){ //Setter Injection
        this.secondClass = secondClass;
    }
}
