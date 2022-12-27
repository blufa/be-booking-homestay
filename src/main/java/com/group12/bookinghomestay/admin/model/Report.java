package com.group12.bookinghomestay.admin.model;

import com.group12.bookinghomestay.admin.model.enums.DeleteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    private DeleteStatus status;
}
