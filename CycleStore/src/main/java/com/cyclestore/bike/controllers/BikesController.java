package com.cyclestore.bike.controllers;

import com.cyclestore.bike.models.Bike;
import com.cyclestore.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    public BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list(){
        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike){
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") Long id){
        return bikeRepository.getOne(id);
    }
}
