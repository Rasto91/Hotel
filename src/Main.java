import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            // Vytvorenie hostí
            Guest adela = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
            Guest jan = new Guest("Ján", "Dvořáček", LocalDate.of(1995, 5, 5));
            Guest karolina = new Guest("Karolína", "Trnková", LocalDate.of(1965, 8, 5));

            // Zmena dátumu narodenia Jána
            jan.setBirthDate(LocalDate.of(1995, 4, 5));


            // Vytvorenie izieb
            Room room1 = new Room(1, 1, true, true, 1000);
            Room room2 = new Room(2, 1, true, true, 1000);
            Room room3 = new Room(3, 3, false, true, 2400);


            // Zoznam hostí
            List<Guest> adelaGuests = new ArrayList<>();
            adelaGuests.add(adela);

            // Vytvorenie rezervácie pre Adelu
            Booking adelaBooking = new Booking(LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), Booking.TypeOfVacation.RECREATIONAL, adelaGuests, room1);

            System.out.println(jan.getFirstname() + jan.getLastname() + "(" + jan.getBirthDate() + ").");

            // Vypíšeme informácie o rezervácii
            System.out.println("Rezervácia pre Adélu:");
            System.out.println("Izba: " + adelaBooking.getRoom().getNumber());
            System.out.println("Hostia:");
            for (Guest guest : adelaBooking.getGuests()) {
                System.out.println("  " + guest.getFirstname() + " " + guest.getLastname());
            }
            System.out.println("Od: " + adelaBooking.getStartDate());
            System.out.println("Do: " + adelaBooking.getEndDate());
            System.out.println("Typ pobytu: " + adelaBooking.getType());


            // Vytvorenie rezervácie pre Jána a Adelu
            List<Guest> guests = new ArrayList<>();
            guests.add(adela);
            guests.add(jan);
            guests.add(karolina);


            Booking booking1 = new Booking(LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), Booking.TypeOfVacation.RECREATIONAL, guests, room3);

            System.out.println(adela.getFirstname()+ adela.getLastname() + "(" + adela.getBirthDate() + ")");
            System.out.println(jan.getFirstname()+ jan.getLastname() + "(" + jan.getBirthDate() + ")");

            // Vypíšeme informácie o rezervácii
            System.out.println("Rezervácia:");
            System.out.println("Izba: " + booking1.getRoom().getNumber());
            System.out.println("Hostia:");
            for (Guest guest : booking1.getGuests()) {
                System.out.println("  " + guest.getFirstname() + " " + guest.getLastname());
            }
            System.out.println("Od: " + booking1.getStartDate());
            System.out.println("Do: " + booking1.getEndDate());
            System.out.println("Typ pobytu: " + booking1.getType());


            BookingManager bookingManager = new BookingManager();

            List<Guest> guests1 = new ArrayList<>();
            guests1.add(adela);
            guests1.add(jan);
            guests1.add(karolina);

            // Prvá rezervácia
            Booking booking2 = new Booking(LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), Booking.TypeOfVacation.RECREATIONAL, guests1, room2);
            bookingManager.addBooking(booking2);

            // Druhá rezervácia
            Booking booking3 = new Booking(LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), Booking.TypeOfVacation.RECREATIONAL, guests1, room1);
            bookingManager.addBooking(booking3);

            // Tretia rezervácia
            Booking booking4 = new Booking(LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), Booking.TypeOfVacation.BUSINESS, guests1, room3);
            bookingManager.addBooking(booking4);

            // Cyklus pre vytvorenie 10 dvojdenných rezervácií pre Karolínu
            for (int i = 1; i <= 10; i++) {
                LocalDate startDate = LocalDate.of(2023, 8, 1).plusDays(2 * (i - 1));
                LocalDate endDate = startDate.plusDays(1);
                Booking booking = new Booking(startDate, endDate, Booking.TypeOfVacation.RECREATIONAL, guests, room2);
                bookingManager.addBooking(booking);
            }

            // Získanie celkového počtu rezervací
            int totalBookings = bookingManager.getBookings().size();
            System.out.println("Celkový počet rezervácií je: " + totalBookings);

            // Výpis priemerného počtu hostí na rezerváciu
            double averageGuests = bookingManager.getAverageGuestPerBooking();
            System.out.println("Priemerný počet hostí na rezerváciu: " + averageGuests);


            // Výpis prvních 5 rekreačních rezervací
            List<Booking> firstSixHolidayBookings = bookingManager.getTopNHolidayBookings(6);
            System.out.println("Prvých 6 rekreačných rezervácií:");
            for (Booking booking : firstSixHolidayBookings) {
                System.out.println("Začiatok: " + booking.getStartDate() + ", Koniec: " + booking.getEndDate() + ", Cena: " + booking.getTotalPrice());
            }



            }
        }