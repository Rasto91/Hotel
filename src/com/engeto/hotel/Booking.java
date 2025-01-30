package com.engeto.hotel;

import java.time.LocalDate;
import java.util.List;


public class Booking {
    public enum TypeOfVacation {
    RECREATIONAL, BUSINESS
    }
    private LocalDate startDate;
    private LocalDate endDate;
    private TypeOfVacation type;
    private List<Guest> guests;
    private Guest guest;
    private Room room;



    public Booking(LocalDate startDate, LocalDate endDate, TypeOfVacation type, List<Guest> guests, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.guests = guests;
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TypeOfVacation getType() {
        return type;
    }

    public void setType(TypeOfVacation type) {
        this.type = type;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}