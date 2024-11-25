package com.epam.mentoring.task2;

public class BookingId {
    private  int bookingid;
    private Booking booking;

    public BookingId(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Bookingid{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
