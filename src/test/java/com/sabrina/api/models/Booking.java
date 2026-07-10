package com.sabrina.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("totalprice")
    private int totalprice;

    @JsonProperty("depositpaid")
    private boolean depositpaid;

    @JsonProperty("bookingdates")
    private BookingDates bookingdates;

    @JsonProperty("additionalneeds")
    private String additionalneeds;

    // Constructor
    public Booking(String firstname, String lastname, int totalprice,
                   boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    // Getters
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public int getTotalprice() { return totalprice; }
    public boolean isDepositpaid() { return depositpaid; }
    public BookingDates getBookingdates() { return bookingdates; }
    public String getAdditionalneeds() { return additionalneeds; }
}