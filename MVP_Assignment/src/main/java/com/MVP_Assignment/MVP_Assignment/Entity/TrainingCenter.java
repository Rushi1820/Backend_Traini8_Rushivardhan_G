package com.MVP_Assignment.MVP_Assignment.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TrainingCenter")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40,unique = true)
    private String centerName;

    @Column(nullable = false, length = 12,unique = true)
    @Size(min = 12, max = 12, message = "CenterCode must be exactly 12 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "CenterCode must be alphanumeric")
    private String centerCode;

    @Embedded
    private Address address;

    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(nullable = false, updatable = false)
    private Date createdOn;

    @Column(nullable = true,unique = true)
    private String contactEmail;

    @Column(nullable = false,unique = true,length =10)
    private String contactPhone;

}

