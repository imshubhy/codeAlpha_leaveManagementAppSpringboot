package com.codealpha.intern.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.codealpha.intern.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}
