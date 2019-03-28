package com.geohor.repository;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {

    List<Work> findAllByDeclarantAndAndGeodesyPerformerOrderByApplicationDate(User declarant, User geodesy);



}
