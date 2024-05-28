package com.example.shopPrj001.domain;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    private String adid;
    private String adpw;

    @ColumnDefault("'ROLE_ADMIN'")
    private String role;
}
