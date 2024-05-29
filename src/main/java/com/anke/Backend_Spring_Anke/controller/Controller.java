package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.entities.Anke;
import com.anke.Backend_Spring_Anke.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController // Swagger will detect this class as a controller
@RequestMapping("/anke") // Path to the controller
public class Controller {

    private final ServiceImpl simpl;

    public Controller(ServiceImpl simpl) { // Constructor with dependency injection
        this.simpl = simpl;
    }

    @Operation(summary = "Add an anke", description = "Add an anke to the database")
    @PostMapping("/add") // Path to the method
    public Anke addAnke(@RequestBody Anke anke) {
        return simpl.addAnke(anke);
    }

    @Operation(summary = "Delete an anke", description = "Delete an anke from the database")
    @DeleteMapping("/delete/{id}")
    public boolean deleteAnke(@PathVariable Long id) {
        return simpl.deleteAnke(id);
    }

    @Operation(summary = "Update an anke", description = "Update an anke in the database")
    @PatchMapping("/update")
    public Anke updateAnke(@RequestBody Anke anke) {
        return simpl.updateAnke(anke);
    }

    @Operation(summary = "Get an anke", description = "Get an anke from the database")
    @GetMapping("/get/{id}")
    public Anke getAnke(@PathVariable Long id) {
        return simpl.getAnke(id);
    }

    @Operation(summary = "Get all ankes", description = "Get all ankes from the database")
    @GetMapping("/getAll")
    public List<Anke> getAllAnke() {
        return simpl.getAllAnke();
    }

    @GetMapping("/modelAndView")
    public ModelAndView modelAndView() {
        List<Anke> ankeList = simpl.getAllAnke();
        ModelAndView modelAndView = new ModelAndView("ornek");
        modelAndView.addObject("ankes", ankeList);
        return modelAndView;
    }
}
