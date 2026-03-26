package com.daonq1408.springbootsetup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String brandCode;

    @Column(name = "description")
    private String description;

    @Column(name = "is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;
}
