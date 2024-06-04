package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.entities.Anke;
import com.anke.Backend_Spring_Anke.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller /*Swagger will detect this class as a controller
Spring Framework'te RESTful API'ler oluşturmak için kullanılır.
Bu annotation, @Controller ve @ResponseBody annotationlarını bir araya getirir.
*
*Fakat JSP ile çalışılacaksa @Controller kullanılır.
*
*/
//@RequestMapping("/anke") // Path to the controller
@Tag(name = "Anke Controller", description = "Anke Controller API")
public class AnkeController {


    private final ServiceImpl simpl;

    @Autowired
    public AnkeController(ServiceImpl simpl) { // Constructor with dependency injection
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
        // Thymeleaf için kullanılır
        //ModelAndView model = new ModelAndView("anke"); // anke.html
        // jstl için kullanılır
        ModelAndView modelAndView = new ModelAndView("ankesjsp");
        modelAndView.addObject("ankeList", ankeList);
        return modelAndView;
    }

    @RequestMapping(value = "/editanke/{id}")
    @Operation(summary = "Anke'i döndürür", description = "Anke'i döndürür açıklaması.")
    public String editAnke(@PathVariable Long id, Model model) {
        Anke anke = simpl.getAnke(id);
        model.addAttribute("command", anke);
        return "editanke";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    @Operation(summary = "Anke'i günceller", description = "Anke'i günceller açıklaması.")
    public String editAnke(@ModelAttribute("anke") Anke anke) {
        simpl.updateAnke(anke);
        return "redirect:/modelAndView";
    }

    @RequestMapping(value = "/deleteanke/{id}")
    @Operation(summary = "Anke'i siler", description = "Anke'i siler açıklaması.")
    public String deleteeAnke(@PathVariable Long id) {
        simpl.deleteAnke(id);
        return "redirect:/modelAndView";
    }

    @RequestMapping(value = "/addnewanke")
    @Operation(summary = "Anke ekler", description = "Anke ekler açıklaması.")
    public ModelAndView addNewAnke(@ModelAttribute("anke") Anke anke) {
        simpl.addAnke(anke);
        return new ModelAndView("redirect:/modelAndView");
    }

    @RequestMapping("/newanke")
    public ModelAndView showForm() {
        return new ModelAndView("newanke", "command", new Anke());
    }


}
