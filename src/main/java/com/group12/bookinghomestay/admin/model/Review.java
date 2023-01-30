package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference(value = "hotel-review")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "username")
    @JsonBackReference(value = "user-review")
    private User user;
    private double rate;
    private String content;
}
