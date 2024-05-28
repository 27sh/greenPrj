package com.example.shopPrj001.domain;

import org.hibernate.annotations.ColumnDefault;

import io.micrometer.common.lang.NonNull;
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
public class Member {
    @Id
    private String memid;
    @NonNull
    private String mempw;
    @NonNull
    private String memname;
    @NonNull
    private String memtel1;
    @NonNull
    private String memtel2;
    @NonNull
    private String mememail1;
    @NonNull
    private String mememail2;
    
    private String memtel;
    private String mememail;
    
    @ColumnDefault("'ROLE_MEMBER'")
    private String role;
}
