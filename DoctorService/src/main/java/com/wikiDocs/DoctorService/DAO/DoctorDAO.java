package com.wikiDocs.DoctorService.DAO;

import com.wikiDocs.DoctorService.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorDAO extends JpaRepository<Doctor,Integer> {

}
