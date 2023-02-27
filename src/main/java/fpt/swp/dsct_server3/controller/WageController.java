package fpt.swp.dsct_server3.controller;

import fpt.swp.dsct_server3.constant.URLConstant;
import fpt.swp.dsct_server3.entity.Wage;
import fpt.swp.dsct_server3.service.WageService;
import fpt.swp.dsct_server3.service.WorkingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class WageController {
    @Autowired
    private WageService wageService;

    @PostMapping(URLConstant.WAGE_CALCUlATE)
    public ResponseEntity<Wage> calculateWage(@RequestParam Long employeeId){
        return new ResponseEntity<>(wageService.calculateWage(employeeId), HttpStatus.OK);
    }

}
