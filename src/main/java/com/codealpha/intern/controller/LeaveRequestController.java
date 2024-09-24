package com.codealpha.intern.controller;

import com.codealpha.intern.entity.LeaveRequest;
import com.codealpha.intern.service.LeaveRequestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/{employeeId}")
    public LeaveRequest createLeaveRequest(@PathVariable Long employeeId, @RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.createLeaveRequest(employeeId, leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @PutMapping("/{id}/approve")
    public String approveLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.approveLeaveRequest(id);
    }

    @PutMapping("/{id}/reject")
    public String rejectLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.rejectLeaveRequest(id);
    }
}
