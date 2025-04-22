package com.wikiDocs.DoctorService.controller;


import com.netflix.discovery.converters.Auto;
import com.wikiDocs.DoctorService.model.Doctor;
import com.wikiDocs.DoctorService.service.DoctorService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/doctor-service")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    Environment environment;


    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        try{
            System.out.println(environment.getProperty("local.server.port"));
            return doctorService.getAllDoctors();
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id){
        try{
            return doctorService.getDoctorById(id);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createDoctor")
    public ResponseEntity<Doctor> createDoctorDetails(@RequestPart Doctor doctor,@RequestPart MultipartFile image){
        try{
            return doctorService.createDoctorDetails(doctor,image);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
