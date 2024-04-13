package com.patika.garantibankservice.entity;

import com.patika.garantibankservice.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
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
