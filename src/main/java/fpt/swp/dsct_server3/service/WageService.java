package fpt.swp.dsct_server3.service;

import fpt.swp.dsct_server3.entity.Wage;

public interface WageService {
    Wage calculateWage(Long employeeId);
}
