package com.wikiDocs.DoctorService.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    private String specialty;
    private int experience;
    private String degree;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
}
