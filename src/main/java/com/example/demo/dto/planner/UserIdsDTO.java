package com.example.demo.dto.planner;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserIdsDTO {
    private List<String> userGoogleIds;
}
