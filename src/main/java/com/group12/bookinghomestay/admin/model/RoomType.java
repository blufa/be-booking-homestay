package com.group12.bookinghomestay.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String description;

}
