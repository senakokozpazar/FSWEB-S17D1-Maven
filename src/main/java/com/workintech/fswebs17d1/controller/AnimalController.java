package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;


    @Value("${project.developer.fullname}")
    private String developerFullName;

    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAnimals() {
        return animals.values().stream().toList();

    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;

    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, new Animal(id, animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id) {
        Animal animal = animals.get(id);
        animals.remove(animal);
        return animal;
    }

}
