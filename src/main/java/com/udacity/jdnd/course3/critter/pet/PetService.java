package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PetRepository petRepository;

    public Pet savePet(Pet pet, long ownerId) {
        Customer owner = customerRepository.findById(ownerId).orElseThrow();
        pet.setOwner(owner);
        Pet savedPet = petRepository.save(pet);
        owner.getPets().add(savedPet);
        customerRepository.save(owner);
        return savedPet;
    }

    public Pet getPetById(long petId){
        return petRepository.findById(petId).orElseThrow();
    }
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }
    public List<Pet> getPetsByOwner(long ownerId){
        return petRepository.findByOwnerId(ownerId);
    }
}
