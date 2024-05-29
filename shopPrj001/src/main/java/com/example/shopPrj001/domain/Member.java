package com.example.shopPrj001.domain;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String memid;
    @NotNull
    private String mempw;
    @NotNull
    private String memname;
    @NotNull
    private String memtel1;
    @NotNull
    private String memtel2;
    @NotNull
    private String mememail1;
    @NotNull
    private String mememail2;
    
    private String memtel;
    private String mememail;
    
    @ColumnDefault("'ROLE_MEMBER'")
    private String role;
}
