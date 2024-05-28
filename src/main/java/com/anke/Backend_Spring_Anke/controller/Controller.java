package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.entities.Anke;
import com.anke.Backend_Spring_Anke.impl.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class is a controller
@RequestMapping("/anke") // Path to the controller
public class Controller {

    private final ServiceImpl simpl;

    public Controller(ServiceImpl simpl) { // Constructor with dependency injection
        this.simpl = simpl;
    }

    @PostMapping("/add") // Path to the method
    public Anke addAnke(@RequestBody Anke anke) {
        return simpl.addAnke(anke);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAnke(@PathVariable Long id) {
        return simpl.deleteAnke(id);
    }

    @PatchMapping("/update")
    public Anke updateAnke(@RequestBody Anke anke) {
        return simpl.updateAnke(anke);
    }

    @GetMapping("/get/{id}")
    public Anke getAnke(@PathVariable Long id) {
        return simpl.getAnke(id);
    }

    @GetMapping("/getAll")
    public List<Anke> getAllAnke() {
        return simpl.getAllAnke();
    }
}
