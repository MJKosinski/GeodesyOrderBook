package com.geohor.repository;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long>, WorkRepositoryInterface  {

    List<Work> findAllByDeclarantOrGeodesyPerformerOrderByApplicationDate(User declarant, User geodesy);

    List<Work> findAllBySubcontractorsOrderByApplicationDate(User subcontractor);

    @Query("SELECT w FROM Work w WHERE w.description LIKE %:phrase% OR w.object LIKE %:phrase% ORDER BY w.applicationDate DESC")
    List<Work> findAllByDescriptionLikeOrObjectLike(@Param("phrase") String phrase);



}
