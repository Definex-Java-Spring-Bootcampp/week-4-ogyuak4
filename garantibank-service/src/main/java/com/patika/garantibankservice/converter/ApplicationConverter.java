package com.patika.garantibankservice.converter;

import com.patika.garantibankservice.dto.request.ApplicationRequest;
import com.patika.garantibankservice.dto.response.ApplicationResponse;
import com.patika.garantibankservice.entity.Application;
import com.patika.garantibankservice.enums.ApplicationStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConverter {

    public Application toApplication(ApplicationRequest request) {
        // @formatter:off
        return Application.builder()
                .userId(request.getUserId())
                .createDate(LocalDateTime.now())
                .applicationStatus(ApplicationStatus.INITIAL)
                .build();
        // @formatter:on
    }

    public ApplicationResponse toResponse(Application application) {
        return ApplicationResponse.builder()
                .userId(application.getUserId())
                .createDate(application.getCreateDate())
                .applicationStatus(application.getApplicationStatus())
                .build();
    }

    public List<ApplicationResponse> toResponseList(List<Application> applications) {
        List<ApplicationResponse> applicationResponses = new ArrayList<>();

        applications.forEach(application -> {
            applicationResponses.add(toResponse(application));
        });

        return applicationResponses;
    }
}
