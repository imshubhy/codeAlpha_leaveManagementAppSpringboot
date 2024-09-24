package com.codealpha.intern.service;

import com.codealpha.intern.entity.Employee;
import com.codealpha.intern.entity.LeaveRequest;
import com.codealpha.intern.entity.StatusLeave;
import com.codealpha.intern.repository.LeaveRequestRepository;
import com.codealpha.intern.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public LeaveRequest createLeaveRequest(Long employeeId, LeaveRequest leaveRequest) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null && employee.getLeaveBalance() > 0) {
            leaveRequest.setEmployee(employee);
            leaveRequest.setStatusLeave(StatusLeave.PENDING); // Changed to statusLeave
            leaveRequestRepository.save(leaveRequest);
            employee.setLeaveBalance(employee.getLeaveBalance() - 1); // Decrement leave balance
            employeeRepository.save(employee);
            return leaveRequest;
        }
        return null; // Handle insufficient leave balance
    }


    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public String approveLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setStatusLeave(StatusLeave.APPROVED);
            leaveRequestRepository.save(leaveRequest);
            return "Leave request for employee ID " + leaveRequest.getEmployee().getId() + " has been approved.";
        } else {
            return "Leave request with ID " + id + " not found.";
        }
    }

    public String rejectLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setStatusLeave(StatusLeave.REJECTED);
            leaveRequestRepository.save(leaveRequest);
            return "Leave request for employee ID " + leaveRequest.getEmployee().getId() + " has been rejected.";
        } else {
            return "Leave request with ID " + id + " not found.";
        }
    }
}
