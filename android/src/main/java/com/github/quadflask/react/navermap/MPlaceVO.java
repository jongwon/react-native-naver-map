package com.github.quadflask.react.navermap;

public class MPlaceVO {

    private String id;
    private Long companyId;
    private String name;
    private String address;
    private Integer bookingTimeCount;
    private Long coast;
    private Integer lanes;
    private String favorites;
    private String distance;
    private String franchisee;
    private double lat;
    private double lng;
    private int parking; // 주차 가능 대수

    public MPlaceVO() {
    }

    public MPlaceVO(String id, Long companyId, String name, String address, Integer bookingTimeCount, Long coast, Integer lanes, String favorites, String distance, String franchisee, double lat, double lng, int parking) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.bookingTimeCount = bookingTimeCount;
        this.coast = coast;
        this.lanes = lanes;
        this.favorites = favorites;
        this.distance = distance;
        this.franchisee = franchisee;
        this.lat = lat;
        this.lng = lng;
        this.parking = parking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBookingTimeCount() {
        return bookingTimeCount;
    }

    public void setBookingTimeCount(Integer bookingTimeCount) {
        this.bookingTimeCount = bookingTimeCount;
    }

    public Long getCoast() {
        return coast;
    }

    public void setCoast(Long coast) {
        this.coast = coast;
    }

    public Integer getLanes() {
        return lanes;
    }

    public void setLanes(Integer lanes) {
        this.lanes = lanes;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFranchisee() {
        return franchisee;
    }

    public void setFranchisee(String franchisee) {
        this.franchisee = franchisee;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }
}
