package fpt.swp.dsct_server3.service.impl;

import fpt.swp.dsct_server3.entity.Contract;
import fpt.swp.dsct_server3.repository.ContractRepository;
import fpt.swp.dsct_server3.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Contract findByEmployeeId(Long employeeId) {
        return contractRepository.findByEmployeeId(employeeId).get();
    }
}
