package com.codealpha.intern.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;
    
    @Enumerated(EnumType.STRING)
    private StatusLeave statusLeave; // Changed from leaveStatus to statusLeave

    private String reason;
}
