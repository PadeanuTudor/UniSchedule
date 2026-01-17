package com.example.unischedule.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter @Setter @NoArgsConstructor
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer yearNumber;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    @JsonIgnore
    private Specialty specialty;

    @OneToMany(mappedBy = "year", cascade = CascadeType.ALL)
    private List<ScheduleEntry> scheduleEntries;
}