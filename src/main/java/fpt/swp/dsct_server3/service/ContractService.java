package fpt.swp.dsct_server3.service;

import fpt.swp.dsct_server3.entity.Contract;

public interface ContractService {
    Contract findByEmployeeId(Long employeeId);
}
