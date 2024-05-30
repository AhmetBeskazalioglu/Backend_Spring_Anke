package com.anke.Backend_Spring_Anke.service;


import com.anke.Backend_Spring_Anke.entities.Tutorial;

import java.util.List;

public interface TutorialService {
	
	List<Tutorial> getAllTutorial();

	Tutorial getDetailTutorial(Long id);

	Tutorial saveTutorial(Tutorial tutorial);

	Tutorial updateTutorial(Tutorial tutorial);
	
	boolean deleteTutorial(Long id);

}
