package fpt.swp.dsct_server3.repository;

import fpt.swp.dsct_server3.entity.Wage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WageRepository extends JpaRepository<Wage, Long> {
}
