package com.geohor.service;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import com.geohor.myenum.UserType;
import com.geohor.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        if (logUser.getType() != UserType.SUBCONTRACTOR) {
            return workRepository.findAllByDeclarantOrGeodesyPerformerOrderByApplicationDate(logUser, logUser);
        } else {
            return workRepository.findAllBySubcontractorsOrderByApplicationDate(logUser);
        }

    }

    public List<Work> getAll(User logUser) {

        if (logUser.getType() != UserType.SUBCONTRACTOR) {
            return workRepository.findAll();
        } else {
            return workRepository.findAllBySubcontractorsOrderByApplicationDate(logUser);
        }

    }

    public List<Work> getLast10(User logUser) {
        if (logUser.getType() == UserType.GEODESY) {
            return workRepository.getLast10byGeodesy(logUser);
        } else if (logUser.getType() == UserType.GENERAL_CONTRACTOR) {
            return workRepository.getLast10byDeclarant(logUser);
        } else {
            return workRepository.getLast10bySubconstr(logUser);
        }
    }

    public List<Work> search(User logUser, String worksearch) {
        if (logUser.getType() != UserType.SUBCONTRACTOR) {

            return workRepository.findAllByDescriptionLikeOrObjectLike(worksearch);
        } else {
            return workRepository.getAllBySubconstrByPhrase(logUser,worksearch);
        }

    }
}
