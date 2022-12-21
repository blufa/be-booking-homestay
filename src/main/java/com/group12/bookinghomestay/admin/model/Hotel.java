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
    private int owner_id;
    private int place_id;
    private String info;
    private String policy;
    private Date dateUpdate;
    private int statusData;
    /*@OneToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;
    */

  /*  @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Room> rooms;

   */
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private Collection<Image> images;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference(value="hotel-review")
    private Collection<Review> reviews;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Hotel(String name, int owner_id, int place_id, String info, String policy, Date dateUpdate, int statusData) {
        this.name = name;
        this.owner_id = owner_id;
        this.place_id = place_id;
        this.info = info;
        this.policy = policy;
        this.dateUpdate = dateUpdate;
        this.statusData = statusData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getStatusData() {
        return statusData;
    }

    public void setStatusData(int statusData) {
        this.statusData = statusData;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
}
