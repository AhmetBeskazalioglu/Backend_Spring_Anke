package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.entities.Anke;
import com.anke.Backend_Spring_Anke.impl.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class is a controller
@RequestMapping("/anke") // Path to the controller
public class Controller {

    private final ServiceImpl simpl;

    public Controller(ServiceImpl simpl) {
        this.simpl = simpl;
    }

    @PostMapping("/add")
    public Anke addAnke(Anke anke) {
        return simpl.addAnke(anke);
    }

    @DeleteMapping("/delete")
    public boolean deleteAnke(Long id) {
        return simpl.deleteAnke(id);
    }

    @PatchMapping("/update")
    public Anke updateAnke(Anke anke) {
        return simpl.updateAnke(anke);
    }

    @GetMapping("/get")
    public Anke getAnke(Long id) {
        return simpl.getAnke(id);
    }

    @GetMapping("/getAll")
    public List<Anke> getAllAnke() {
        return simpl.getAllAnke();
    }
}
