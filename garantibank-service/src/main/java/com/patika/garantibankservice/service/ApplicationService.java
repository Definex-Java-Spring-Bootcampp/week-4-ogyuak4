package com.patika.garantibankservice.service;

import com.patika.garantibankservice.converter.ApplicationConverter;
import com.patika.garantibankservice.dto.request.ApplicationRequest;
import com.patika.garantibankservice.dto.response.ApplicationResponse;
import com.patika.garantibankservice.entity.Application;
import com.patika.garantibankservice.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationConverter applicationConverter;

    @Transactional
    public ApplicationResponse createApplication(ApplicationRequest request) {
        Application application = applicationConverter.toApplication(request);
        return applicationConverter.toResponse(applicationRepository.save(application));
    }

    @Transactional
    public List<ApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();
        return applicationConverter.toResponseList(applications);
    }


}
