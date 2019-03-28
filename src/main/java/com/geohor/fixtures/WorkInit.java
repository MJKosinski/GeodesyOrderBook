package com.geohor.fixtures;

import com.geohor.entity.Work;
import com.geohor.myenum.CatalogType;
import com.geohor.myenum.StatusType;
import com.geohor.myenum.WorkType;
import com.geohor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
@Transactional
public class WorkInit {

    @Autowired
    UserRepository userRepository;

    public List<Work> createWorks(){
        List<Work> works = new ArrayList<>();
        Work work1 = new Work();
        work1.setDeclarant(userRepository.findOne(2L));
        work1.setSubcontractors(Arrays.asList(userRepository.findOne(3L),userRepository.findOne(4L)));
        work1.setApplicationDate(LocalDateTime.parse("2018-07-23T10:00:00"));
        work1.setWorkDate(LocalDate.parse("2018-07-25"));
        work1.setCatalog(CatalogType.ROADS);
        work1.setTrade("Podbudowa");
        work1.setObject("Trasa Główna");
        work1.setWorkType(WorkType.STEAKOUT);
        work1.setMileageStart("10+100");
        work1.setMileageEnd("10+250");
        work1.setDescription("Tyczenie podbudowy pomocniczej");
        work1.setStatus(StatusType.COMPLETED);
        work1.setDeclarantComment("Wykonać przed godziną 15.00");
        work1.setGeodesyPerformer(userRepository.findOne(1L));
        works.add(work1);

        Work work2 = new Work();
        work2.setDeclarant(userRepository.findOne(2L));
        work2.setSubcontractors(Arrays.asList(userRepository.findOne(4L)));
        work2.setApplicationDate(LocalDateTime.parse("2019-02-23T10:00:00"));
        work2.setWorkDate(LocalDate.parse("2019-02-25"));
        work2.setCatalog(CatalogType.PIPES);
        work2.setTrade("WODA");
        work2.setObject("Kolizja W01");
        work2.setWorkType(WorkType.MEASURMENT);
        work2.setMileageStart("7+300");
        work2.setMileageEnd("");
        work2.setDescription("Pomiar kolizji wodociągowej");
        work2.setStatus(StatusType.REJECTED);
        work2.setConstructFieldRaport("Obiekt zasypany");
        works.add(work2);


        Work work3 = new Work();
        work3.setDeclarant(userRepository.findOne(2L));
        work3.setSubcontractors(Arrays.asList(userRepository.findOne(3L)));
        work3.setApplicationDate(LocalDateTime.parse("2019-01-15T10:00:00"));
        work3.setWorkDate(LocalDate.parse("2019-01-18"));
        work3.setCatalog(CatalogType.PIPES);
        work3.setTrade("KANALIZACJA");
        work3.setObject("Kolizja K03.2");
        work3.setWorkType(WorkType.STEAKOUT);
        work3.setMileageStart("9+300");
        work3.setMileageEnd("9+350");
        work3.setDescription("Tyczenie studni");
        work3.setStatus(StatusType.IN_PROGRESS);
        works.add(work3);

        Work work4 = new Work();
        work4.setDeclarant(userRepository.findOne(2L));
        work4.setSubcontractors(Arrays.asList(userRepository.findOne(3L),userRepository.findOne(4L)));
        work4.setApplicationDate(LocalDateTime.parse("2019-01-15T08:00:00"));
        work4.setWorkDate(LocalDate.parse("2019-01-19"));
        work4.setCatalog(CatalogType.ROADS);
        work4.setTrade("KRZ");
        work4.setObject("DD-12");
        work4.setWorkType(WorkType.CALCULATION);
        work4.setMileageStart("0+000");
        work4.setMileageEnd("0+320");
        work4.setDescription("Opracowanie modelu KRZ");
        work4.setStatus(StatusType.COMPLETED);
        work4.setSubmissionDate(LocalDate.parse("2019-01-15"));
        work4.setDeclarantComment("system Trimble - przesłać do podsykonawcy-1");
        work4.setGeodesyPerformer(userRepository.findOne(1L));
        works.add(work4);



        return works;
    }


}
