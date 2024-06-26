package com.example.demo.dto.planner;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TripPatchDTO {
    private String tripName;
    private String tripArea;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long budget;
    private List<String> participantIds; // 참여자 id
}
