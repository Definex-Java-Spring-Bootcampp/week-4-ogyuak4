package com.patika.garantibankservice.repository;

import com.patika.garantibankservice.dto.response.ApplicationResponse;
import com.patika.garantibankservice.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {


}
/*
public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();

    public Application save(Application application) {
        applicationList.add(application);
        return application;
    }

    public List<Application> getAll() {
        return applicationList;
    }
}

 */
