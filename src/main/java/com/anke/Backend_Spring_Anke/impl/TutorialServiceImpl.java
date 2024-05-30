package com.anke.Backend_Spring_Anke.impl;

import com.anke.Backend_Spring_Anke.entities.Tutorial;
import com.anke.Backend_Spring_Anke.repository.TutorialRepository;
import com.anke.Backend_Spring_Anke.service.TutorialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public List<Tutorial> getAllTutorial() {
        try {
            return tutorialRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error getAllTutorial(): " + e.getMessage());
            return null;
        }
    }

    @Override
    public Tutorial getDetailTutorial(Long id) {
        try {
            return tutorialRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error getDetailTutorial(): " + e.getMessage());
            return null;
        }
    }

    @Override
    public Tutorial saveTutorial(Tutorial tutorial) {
        try {
            return tutorialRepository.save(tutorial);
        } catch (Exception e) {
            System.out.println("Error saveTutorial(): " + e.getMessage());
            return null;
        }
    }

    @Override
    public Tutorial updateTutorial(Tutorial tutorial) {
        try {
            if (tutorialRepository.existsById(tutorial.getId())) {
                Tutorial updatedTutorials = tutorialRepository.getReferenceById(tutorial.getId());
                if (tutorial.getTitle() != null)
                    updatedTutorials.setTitle(tutorial.getTitle());
                if (tutorial.getDescription() != null)
                    updatedTutorials.setDescription(tutorial.getDescription());
                return tutorialRepository.save(updatedTutorials);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error updateTutorial(): " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTutorial(Long id) {

        try {
            if (tutorialRepository.existsById(id)) {
                tutorialRepository.deleteById(id);
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println("Error deleteTutorial(): " + e.getMessage());
            return false;
        }
    }
}
