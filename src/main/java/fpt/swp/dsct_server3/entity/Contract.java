package fpt.swp.dsct_server3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Contract")
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float dailyWorkingHours;
    private Float baseWage;
    private String currencyUnit;
    private Date signedDate;
    private Date startedDate;
    private Date endDate;
    private String jobType;
    private String status;
    @ManyToOne
    @JoinColumn(name = "Apartment_ID")
    @JsonBackReference
    private Apartment apartment;
    @ManyToOne
    @JoinColumn(name = "Department_ID")
    @JsonBackReference
    private Department department;
    @ManyToOne
    @JoinColumn(name = "JobPosition_ID")
    @JsonBackReference
    private JobPosition jobPosition;
    @ManyToOne
    @JoinColumn(name = "Employee_ID")
    @JsonBackReference
    private Employee employee;
    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private List<Wage> wages;
    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private List<WorkingSchedule> workingSchedules;
}
