import com.engeto.hotel.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
   private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public double getAverageGuestPerBooking() {
       if (bookings.isEmpty()) {
           return 0.0; // Žiadne rezervácie, nemôžem počítať priemer
       }

       int totalGuests = 0;
       for (Booking booking : bookings) {
           totalGuests += booking.getGuestCount();
       }

       return (double) totalGuests / bookings.size();
   }


       public Booking getBooking(int index) {
       if (index >= 0 && index < bookings.size()) {
           return bookings.get(index);
       } else {
           return null; // alebo vyhodiť výnimku
       }
    }

    public List<Booking> getTopNHolidayBookings(int i) {
        return null;
    }

    public List<Booking> getBookings() {
       return new ArrayList<>(bookings); // Vraciam kópiu zoznamu, aby som zabránil modifikácií pôvodného zoznamu
    }

    public void clearBooking() {
       bookings.clear();
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    public List<Booking> getTopHolidayBookings(int count) {
        List<Booking> holidayBokings = new ArrayList<>();
        int foundBookings = 0;

        for (Booking booking : bookings) {
            if (booking.getVacationType().equals("rekreačný")) {
                holidayBokings.add(booking);
                foundBookings++;
                if (foundBookings == count) {
                    break; // Nájdený požadovaný počet rezervácií, ukončujem cyklus
                }
            }
        }

        return holidayBokings;
    }

    public void printGuestStatistic() {
       int oneGuestBookings = 0;
       int twoGuestsBookings = 0;
       int moreThanTwoGuestsBookings = 0;

       for (Booking booking : bookings) {
           int guestCount = booking.getGuestCount();
           if (guestCount == 1) {
               oneGuestBookings++;
           } else if (guestCount == 2) {
               twoGuestsBookings++;
           } else {
               moreThanTwoGuestsBookings++;
           }
       }
    }
}