package com.patika.garantibankservice.dto.response;

import com.patika.garantibankservice.enums.ApplicationStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApplicationResponse {

    private Long userId;
    private LocalDateTime createDate;
    private ApplicationStatus applicationStatus;
}
