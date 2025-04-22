package com.wikiDocs.DoctorService.service;


import com.wikiDocs.DoctorService.DAO.DoctorDAO;
import com.wikiDocs.DoctorService.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorDAO doctorDAO;

    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(doctorDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Doctor> getDoctorById(Integer id) {
        return new ResponseEntity<>(doctorDAO.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<Doctor> createDoctorDetails(Doctor doctor, MultipartFile image) throws IOException {
        doctor.setImageName(image.getOriginalFilename());
        doctor.setImageType(image.getContentType());
        doctor.setImageData(image.getBytes());
        return new ResponseEntity<>(doctorDAO.save(doctor),HttpStatus.OK);

    }
}
