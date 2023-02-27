package fpt.swp.dsct_server3.controller;

import fpt.swp.dsct_server3.constant.URLConstant;
import fpt.swp.dsct_server3.entity.WorkingSchedule;
import fpt.swp.dsct_server3.service.WorkingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WorkingScheduleController {
    @Autowired
    private WorkingScheduleService workingScheduleService;

    @GetMapping(URLConstant.WORKING_SCHEDULE_OF_EMPLOYEE)
    public ResponseEntity<Iterable> findAllByEmployee(@PathVariable("id") Long employeeId) {
        List<WorkingSchedule> workingSchedules = workingScheduleService.findAllByEmployee(employeeId);
        return new ResponseEntity<>(workingSchedules, HttpStatus.OK);
    }
}
