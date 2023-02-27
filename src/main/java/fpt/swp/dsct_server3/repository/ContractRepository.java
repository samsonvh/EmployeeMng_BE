package fpt.swp.dsct_server3.repository;

import fpt.swp.dsct_server3.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findByEmployeeId(Long employeeId);
}
