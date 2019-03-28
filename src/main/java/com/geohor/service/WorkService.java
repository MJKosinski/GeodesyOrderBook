package com.geohor.service;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import com.geohor.myenum.UserType;
import com.geohor.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkService {

    @Autowired
    WorkRepository workRepository;


    public void save(Work work, User logUser) {

        work.setApplicationDate(LocalDateTime.now());

        if (logUser.getType() != UserType.SUBCONTRACTOR) {

            work.setDeclarant(logUser);
            workRepository.save(work);


        }
    }

    public List<Work> getMyWorks(User logUser) {

        return workRepository.findAllByDeclarantAndAndGeodesyPerformerOrderByApplicationDate(logUser,logUser);

    }

    public List<Work> getAll(User logUser) {

        if(logUser.getType() != UserType.SUBCONTRACTOR) {
            return workRepository.findAll();
        } else {
            return workRepository.findAllByDeclarantAndAndGeodesyPerformerOrderByApplicationDate(logUser,logUser);
        }

    }
}
