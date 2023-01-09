package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int companyId;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String companyAddress;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<CustomerUser> customerUserList;
}
