package api.reservation.service;

import api.reservation.entity.Reservation;
import api.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ReservationService {
private  ReservationRepository reservationRepository;



    public Reservation addReservatrion(String title, LocalDate start , LocalDate end) {
        Reservation reservation = new Reservation();
        reservation.setTitle(title);
        reservation.setStartTime(start);
        reservation.setEndTime(end);

        return reservationRepository.save(reservation);
    }
}

