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
@Table(name = "Wage")
public class Wage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float totalWorkingDays;
    private Float amount;
    private String currencyUnit;
    private Date fromDate;
    private Date toDate;
    private Date createdDate;
    private Date paidDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "Contract_ID")
    @JsonBackReference
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "Approver_ID")
    @JsonBackReference
    private Employee employee;
}
