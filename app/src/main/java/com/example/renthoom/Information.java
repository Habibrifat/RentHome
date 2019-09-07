package com.example.renthoom;

public class Information {


    private String address;
    private String amount;
    private String phoneno;
    private String description;
    private String catagorymonth;
    private String location;
    private String bookingCheck;


    public Information()
    {

    }

    public Information(String address, String amount, String phoneno, String description, String catagorymonth, String location, String  bookingCheck ) {
        this.address = address;
        this.amount = amount;
        this.phoneno = phoneno;
        this.description = description;
        this.catagorymonth = catagorymonth;
        this.location = location;
        this.bookingCheck = bookingCheck;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagorymonth() {
        return catagorymonth;
    }

    public void setCatagorymonth(String catagorymonth) {
        this.catagorymonth = catagorymonth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBookingCheck(String bookingCheck) {
        this.bookingCheck = bookingCheck;
    }

    public String getBookingCheck() {
        return bookingCheck;
    }
}
