package com.group12.bookinghomestay.admin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group12.bookinghomestay.admin.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String info;
    private String policy;
    private Date dateUpdate;
    private int statusData;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Image> images;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "hotel-review")
    private Collection<Review> reviews;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
