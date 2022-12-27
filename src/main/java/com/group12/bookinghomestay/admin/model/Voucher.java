package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private double rate;
    private String description;
    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expiredDate;
    private double minimumSpending;

}
