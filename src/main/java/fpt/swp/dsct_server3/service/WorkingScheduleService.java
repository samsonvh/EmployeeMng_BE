package fpt.swp.dsct_server3.service;

import fpt.swp.dsct_server3.entity.WorkingSchedule;

import java.util.List;

public interface WorkingScheduleService {
    List<WorkingSchedule> findAllByEmployee(Long employeeId);
}
