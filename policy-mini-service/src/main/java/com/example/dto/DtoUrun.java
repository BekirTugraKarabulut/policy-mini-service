package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoUrun {

    private Integer urunId;

    private String urunAdi;

    private Integer urunFiyat;

}
