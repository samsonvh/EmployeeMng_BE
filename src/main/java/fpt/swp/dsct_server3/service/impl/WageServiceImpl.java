package fpt.swp.dsct_server3.service.impl;

import fpt.swp.dsct_server3.entity.Contract;
import fpt.swp.dsct_server3.entity.Wage;
import fpt.swp.dsct_server3.entity.WorkingSchedule;
import fpt.swp.dsct_server3.repository.ContractRepository;
import fpt.swp.dsct_server3.repository.WageRepository;
import fpt.swp.dsct_server3.repository.WorkingScheduleRepository;
import fpt.swp.dsct_server3.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class WageServiceImpl implements WageService {
    @Autowired
    private WageRepository wageRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private WorkingScheduleRepository workingScheduleRepository;


    @Override
    public Wage calculateWage(Long employeeId) {
        Wage wage = new Wage();
        System.out.println(employeeId);
        Contract contract = contractRepository.findByEmployeeId(employeeId).orElseThrow(() -> new RuntimeException());
        wage.setContract(contract);
        wage.setEmployee(contract.getEmployee());
        wage.setCreatedDate(new Date(new java.util.Date().getTime()));
        wage.setCurrencyUnit("vnd");
        System.out.println(contract.getEmployee().getBankAccount());
        List<WorkingSchedule> workingSchedules = workingScheduleRepository.findAllByContract_Id(contract.getId());
        wage.setTotalWorkingDays((float) workingSchedules.size());
        if (workingSchedules.isEmpty()) {
            wage.setAmount(0f);
            wage.setStatus("Not Paid");
        }
        else {
            switch (contract.getJobType()){
                case "fulltime":
                    wage.setAmount(contract.getBaseWage());
                    break;
                default:
                    wage.setAmount(contract.getBaseWage() * workingSchedules.size());
            }
            wage.setToDate(workingSchedules.get(workingSchedules.size()-1).getEndDate());
            wage.setFromDate(workingSchedules.get(0).getEndDate());
            wage.setStatus("Not Paid");
        }
        wageRepository.save(wage);
        return wage;
    }
}
