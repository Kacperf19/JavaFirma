package api.controller;

import api.model.Appointment;
import api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @GetMapping
    public List<LocalDateTime> getAvailability(
            @RequestParam Integer specialistId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();

        List<Appointment> booked = appointmentRepo
                .findBySpecialistIdAndCanceledFalseAndDateTimeBetween(specialistId, start, end);

        Set<LocalDateTime> taken = booked.stream()
                .map(Appointment::getDateTime)
                .collect(Collectors.toSet());

        List<LocalDateTime> available = new ArrayList<>();
        for (int hour = 9; hour < 17; hour++) {
            LocalDateTime slot = date.atTime(hour, 0);
            if (!taken.contains(slot)) {
                available.add(slot);
            }
        }

        return available;
    }
}
