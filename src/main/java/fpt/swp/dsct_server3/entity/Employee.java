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
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String identificationId;
    private Date dateOfBirth;
    private String bankAccount;
    private String bankBrand;
    private String avatarUrl;
    private Date joinedDate;
    private String status;
    @OneToOne
    @JoinColumn(name = "Account_ID")
    @JsonBackReference
    private Account account;
    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Contract> contracts;
    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Wage> wages;
}
