package api.reservation.controller;

import api.reservation.entity.Reservation;
import api.reservation.repository.ReservationRepository;

import api.reservation.repository.RoomRepository;
import api.reservation.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ReservationController {
    private final ReservationRepository reservationRepository;
private final RoomRepository roomRepository;

    public ReservationController(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/form")
    public String userPanel(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("reservations", reservationRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());

        return "User/reservation-form";
    }
    @PostMapping("/reservations")
    public String save(@ModelAttribute Reservation reservation ,Model model) {
        boolean isConflict = reservationRepository.existsByRoomAndTimeOverlap(
                reservation.getRoom().getId(),
                reservation.getStartTime(),
                reservation.getEndTime()
        );

        if (isConflict) {
            model.addAttribute("errorMessage", "Wybrany pokój jest już zarezerwowany w tym terminie.");
            model.addAttribute("reservation", reservation);
            model.addAttribute("reservations", reservationRepository.findAll());
            model.addAttribute("rooms", roomRepository.findAll());
            return "User/reservation-form";
        }

        reservationRepository.save(reservation);
        return "redirect:/form";
    }


}
