package com.group12.bookinghomestay.admin.model;

import com.group12.bookinghomestay.client.model.Image;
import com.group12.bookinghomestay.client.model.Place;
import com.group12.bookinghomestay.client.model.Review;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int ownerId;
    private int placeId;
    private String info;
    private String policy;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_hr", referencedColumnName = "id")
    private List<Room> rooms;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ho", referencedColumnName = "id")
    private Owner owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_hp", referencedColumnName = "id")
    private Place place;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_hi", referencedColumnName = "id")
    private List<Image> images;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_hrv", referencedColumnName = "id")
    private List<Review> reviews;
}
