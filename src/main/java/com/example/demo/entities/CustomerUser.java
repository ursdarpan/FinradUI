package com.example.demo.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(nullable = false,length = 30)
    private String userName;
    @Column(nullable = false,length = 30)
    private String firstName;
    @Column(nullable = false,length = 30)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String emailId;
    @Column(nullable = false)
    private String mobileNumber;
    @ManyToOne
    @JoinColumn(name="companyId",nullable = true)
    private Company company;
}
