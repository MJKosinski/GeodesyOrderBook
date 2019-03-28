package com.geohor.repository;

import com.geohor.entity.User;
import com.geohor.entity.Work;

import java.util.List;

public interface WorkRepositoryInterface {

    List<Work> getLast10byDeclarant(User declarant);

    List<Work> getLast10byGeodesy(User geodesy);

    List<Work> getLast10bySubconstr(User subcontractor);
}
