package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoPolicyUI {

    private Long policyId;

    private int musteriId;

    private Integer urunId;

    private Date policyDate;

}
