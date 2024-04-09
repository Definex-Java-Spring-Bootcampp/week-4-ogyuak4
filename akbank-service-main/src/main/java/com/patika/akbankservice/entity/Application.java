package com.patika.akbankservice.entity;

import com.patika.akbankservice.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private LocalDateTime createDate;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
}
