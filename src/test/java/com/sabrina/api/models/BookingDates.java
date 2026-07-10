package com.sabrina.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

    @JsonProperty("checkin")
    private String checkin;

    @JsonProperty("checkout")
    private String checkout;

    // Constructor
    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // Getters
    public String getCheckin() { return checkin; }
    public String getCheckout() { return checkout; }
}