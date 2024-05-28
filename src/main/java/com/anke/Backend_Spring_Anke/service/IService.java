package com.anke.Backend_Spring_Anke.service;

import com.anke.Backend_Spring_Anke.entities.Anke;

import java.util.List;

public interface IService {
     Anke addAnke(Anke anke);
     boolean deleteAnke(Long id);
     Anke updateAnke(Anke anke);
     Anke getAnke(Long id);
     List<Anke> getAllAnke();
}
