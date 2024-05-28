package com.anke.Backend_Spring_Anke.impl;

import com.anke.Backend_Spring_Anke.entities.Anke;
import com.anke.Backend_Spring_Anke.repository.IRepository;
import com.anke.Backend_Spring_Anke.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This class is a service
public class ServiceImpl implements IService {

    private final IRepository repository;

    public ServiceImpl(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public Anke addAnke(Anke anke) {
        return null;
    }

    @Override
    public boolean deleteAnke(Long id) {
        return false;
    }

    @Override
    public Anke updateAnke(Anke anke) {
        return null;
    }

    @Override
    public Anke getAnke(Long id) {
        return null;
    }

    @Override
    public List<Anke> getAllAnke() {
        return List.of();
    }
}
