package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.mapping.Join;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@ToString
public class Trip {

    @Id
    @Column(length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @Column(length = 20)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 50)
    private String tripName;

    @Column(length = 50)
    private String tripArea;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = true)
    private Long budget;

    private Long roomId;

}