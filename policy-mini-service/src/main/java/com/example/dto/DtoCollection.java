package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCollection {

    private Integer collectionId;

    private Long policyId;

    private Long tutar;

    private boolean odenmeDurumu = false;

    private Date collectionDate;

}
