package com.anke.Backend_Spring_Anke.controller;

import com.anke.Backend_Spring_Anke.entities.Tutorial;
import com.anke.Backend_Spring_Anke.impl.TutorialServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/tutorial")
@Tag(name = "Tutorial Controller", description = "Tutorial Controller API")
public class TutorialController {

    private final TutorialServiceImpl tutorialServiceImpl;

    @Autowired
    public TutorialController(TutorialServiceImpl tutorialServiceImpl) {
        this.tutorialServiceImpl = tutorialServiceImpl;
    }

    @Operation(summary = "Get all tutorials", description = "Get all tutorials from the database")
    @GetMapping("/getAll")
    public List<Tutorial> getAllTutorial() {
        return tutorialServiceImpl.getAllTutorial();
    }

    @Operation(summary = "Get detail tutorial", description = "Get detail tutorial from the database")
    @GetMapping("/getDetail/{id}")
    public Tutorial getDetailTutorial(@PathVariable Long id) {
        return tutorialServiceImpl.getDetailTutorial(id);
    }

    @Operation(summary = "Save tutorial", description = "Save tutorial to the database")
    @PostMapping("/save")
    public Tutorial saveTutorial(@RequestBody Tutorial tutorial) {
        return tutorialServiceImpl.saveTutorial(tutorial);
    }

    @Operation(summary = "Update tutorial", description = "Update tutorial in the database")
    @PatchMapping("/update")
    public Tutorial updateTutorial(@RequestBody Tutorial tutorial) {
        return tutorialServiceImpl.updateTutorial(tutorial);
    }

    @Operation(summary = "Delete tutorial", description = "Delete tutorial from the database")
    @DeleteMapping("/delete/{id}")
    public String deleteTutorial(@PathVariable Long id) {
        if (tutorialServiceImpl.deleteTutorial(id)) {
            return "Tutorial deleted successfully";
        }
        return "Tutorial not found";

    }

    // http://localhost:8080/tutorial/modelAndView
    @GetMapping("/modelAndView")
    public ModelAndView modelAndView() {
        List<Tutorial> tutorialList = tutorialServiceImpl.getAllTutorial();
        ModelAndView modelAndView = new ModelAndView("tutorial");
        modelAndView.addObject("tutorials", tutorialList);
        return modelAndView;
    }


}
