package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.entities.Anke;
import com.anke.Backend_Spring_Anke.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController // This class is a controller
@RequestMapping("/anke") // Path to the controller
@Tag(name = "Anke Controller", description = "Anke Controller API")
public class Controller {

    private final ServiceImpl simpl;

    public Controller(ServiceImpl simpl) { // Constructor with dependency injection
        this.simpl = simpl;
    }

    @Operation(summary = "Add Anke", description = "Add anke")
    @PostMapping("/add") // Path to the method
    public Anke addAnke(@RequestBody Anke anke) {
        return simpl.addAnke(anke);
    }

    @Operation(summary = "Delete Anke", description = "Delete anke")
    @DeleteMapping("/delete/{id}")
    public boolean deleteAnke(@PathVariable Long id) {
        return simpl.deleteAnke(id);
    }

    @Operation(summary = "Update Anke", description = "Update anke")
    @PatchMapping("/update")
    public Anke updateAnke(@RequestBody Anke anke) {
        return simpl.updateAnke(anke);
    }

    @Operation(summary = "Get Anke", description = "Get anke")
    @GetMapping("/get/{id}")
    public Anke getAnke(@PathVariable Long id) {
        return simpl.getAnke(id);
    }

    @Operation(summary = "Get All Anke", description = "Get all anke")
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
