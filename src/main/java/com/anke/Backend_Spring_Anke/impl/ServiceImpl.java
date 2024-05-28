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
        try {
            return repository.save(anke);
        } catch (Exception e) {
            System.out.println("Error: addAnke() - "+e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteAnke(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Error: deleteAnke() - "+e.getMessage());
            return false;
        }
    }

    @Override
    public Anke updateAnke(Anke anke) {
        try {
            if (repository.existsById(anke.getId())) {
                Anke updatedAnke = repository.getReferenceById(anke.getId());
                updatedAnke.setName(anke.getName());
                updatedAnke.setSurname(anke.getSurname());
                updatedAnke.setAge(anke.getAge());
                return repository.save(updatedAnke);
            } else {
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("Error: updateAnke() - "+e.getMessage());
            return null;
        }
    }

    @Override
    public Anke getAnke(Long id) {
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error: getAnke() - "+e.getMessage());
            return null;
        }
    }

    @Override
    public List<Anke> getAllAnke() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println("Error: getAllAnke() - "+e.getMessage());
            return null;
        }
    }
}
