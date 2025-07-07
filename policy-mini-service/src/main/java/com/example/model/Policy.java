package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "policy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;

    @Column(name = "musteri_id")
    private int musteriId;

    @Column(name = "urun_id")
    private Integer urunId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "policy_date")
    private Date policyDate;

}
