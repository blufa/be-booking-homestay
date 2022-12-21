package com.group12.bookinghomestay.client.dto;

public class PropertyDto {
    private String nameProperty;
    private String infoProperty;
    private String policy;
    private String roomType;
    private int owner_id;
    private double price;
    private int numberAdult;
    private int numberChildren;
    private String address;
    private String district;
    private String province;
    private String country;
    private String propertyType;
    private String image;

    public PropertyDto(String nameProperty, String infoProperty, String policy, String roomType, int owner_id, double price, int numberAdult, int numberChildren, String address, String district, String province, String country, String propertyType, String image) {
        this.nameProperty = nameProperty;
        this.infoProperty = infoProperty;
        this.policy = policy;
        this.roomType = roomType;
        this.owner_id = owner_id;
        this.price = price;
        this.numberAdult = numberAdult;
        this.numberChildren = numberChildren;
        this.address = address;
        this.district = district;
        this.province = province;
        this.country = country;
        this.propertyType = propertyType;
        this.image = image;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty = nameProperty;
    }

    public String getInfoProperty() {
        return infoProperty;
    }

    public void setInfoProperty(String infoProperty) {
        this.infoProperty = infoProperty;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(int numberAdult) {
        this.numberAdult = numberAdult;
    }

    public int getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(int numberChildren) {
        this.numberChildren = numberChildren;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
