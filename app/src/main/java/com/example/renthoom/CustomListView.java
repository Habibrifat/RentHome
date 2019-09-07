package com.example.renthoom;

public class CustomListView {

    String address;
    String amount;
    String bookingCheck;
    String catagorymonth;
    String description;
    String location;
    String phoneno;

    public CustomListView(String address, String amount, String bookingCheck,
                          String catagorymonth, String description,
                          String location, String phoneno) {
        this.address = address;
        this.amount = amount;
        this.bookingCheck = bookingCheck;
        this.catagorymonth = catagorymonth;
        this.description = description;
        this.location = location;
        this.phoneno = phoneno;
    }

    public CustomListView() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getAmount() {
        return amount;
    }

    public String getBookingCheck() {
        return bookingCheck;
    }

    public String getCatagorymonth() {
        return catagorymonth;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setBookingCheck(String bookingCheck) {
        this.bookingCheck = bookingCheck;
    }

    public void setCatagorymonth(String catagorymonth) {
        this.catagorymonth = catagorymonth;
    }

    public void setDescription(String descrption) {
        this.description = descrption;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
