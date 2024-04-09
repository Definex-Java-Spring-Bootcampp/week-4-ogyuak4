package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.repository.UserRepository;
import com.patika.kredinbizdeservice.producer.NotificationProducer;
import com.patika.kredinbizdeservice.producer.dto.NotificationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @InjectMocks
    private ApplicationService applicationService;

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private ApplicationConverter applicationConverter;

    @Mock
    private UserService userService;

    @Mock
    private AkbankServiceClient akbankServiceClient;

    @Test
    public void should_create_application_successfully() {

        ApplicationRequest request = prepareApplicationRequest();
        User user = prepareUser();

        Mockito.when(userService.getByEmail(request.getEmail())).thenReturn(user);
        Mockito.when(applicationConverter.toApplication(request, user)).thenReturn(prepareApplication());
        Mockito.when(applicationRepository.save(Mockito.any(Application.class))).thenReturn(prepareApplication());


        Application applicationResponse = applicationService.createApplication(request);
        assertThat(applicationResponse).isNotNull();


        verify(userService, times(1)).getByEmail(request.getEmail());
        verify(applicationConverter, times(1)).toApplication(request, user);
        verify(applicationRepository, times(1)).save(Mockito.any(Application.class));

    }

    @Test
    public void should_throw_kredinbizdeException_when_user_not_found() {

        ApplicationRequest request = prepareApplicationRequest();

        Mockito.when(userService.getByEmail(request.getEmail())).thenReturn(null);


        Throwable throwable = catchThrowable(() -> applicationService.createApplication(request));


        assertThat(throwable).isInstanceOf(KredinbizdeException.class);
        assertThat(throwable.getMessage()).isEqualTo("User not found");

        verify(userService, times(1)).getByEmail(request.getEmail());

    }
    @Test
    public void should_return_application_list_successfully() {

        Application application1 = prepareApplication();
        Application application2 = prepareApplication();
        Mockito.when(applicationRepository.findAll()).thenReturn(List.of(application1, application2));


        List<Application> applicationList = applicationService.getAll();


        assertThat(applicationList).isNotEmpty();
        assertThat(applicationList.size()).isEqualTo(2);


        verify(applicationRepository, times(1)).findAll();
        
    }

    private ApplicationRequest prepareApplicationRequest() {
        ApplicationRequest request = new ApplicationRequest();
        request.setEmail("test@example.com");
        return request;
    }

    private User prepareUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        return user;
    }

    private Application prepareApplication() {
        Application application = new Application();
        return application;
    }
}

