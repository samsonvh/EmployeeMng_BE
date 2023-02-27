package fpt.swp.dsct_server3.repository;

import fpt.swp.dsct_server3.entity.WorkingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule, Long> {
    List<WorkingSchedule> findAllByContract_Id(Long contractId);
}
