package fpt.swp.dsct_server3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "WorkingSchedule")
public class WorkingSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startingDate;
    private Date endDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "Contract_ID")
    @JsonBackReference
    private Contract contract;
}
