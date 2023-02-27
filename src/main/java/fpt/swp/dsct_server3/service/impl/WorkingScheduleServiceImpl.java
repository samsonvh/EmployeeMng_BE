package fpt.swp.dsct_server3.service.impl;

import fpt.swp.dsct_server3.entity.Contract;
import fpt.swp.dsct_server3.entity.WorkingSchedule;
import fpt.swp.dsct_server3.repository.ContractRepository;
import fpt.swp.dsct_server3.repository.WorkingScheduleRepository;
import fpt.swp.dsct_server3.service.WorkingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingScheduleServiceImpl implements WorkingScheduleService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private WorkingScheduleRepository workingScheduleRepository;

    @Override
    public List<WorkingSchedule> findAllByEmployee(Long employeeId) {
        System.out.println(employeeId);
        Contract contract = contractRepository.findByEmployeeId(employeeId).orElseThrow(() -> new RuntimeException());
        System.out.println(contract.getEmployee().getBankAccount());
        List<WorkingSchedule> workingSchedules = workingScheduleRepository.findAllByContract_Id(contract.getId());
        if (workingSchedules.isEmpty()) {
            return null;
        }
        return workingSchedules;
    }
}
