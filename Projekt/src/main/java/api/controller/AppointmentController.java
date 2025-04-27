package api.controller;

import api.model.Appointment;
import api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repo;

    @GetMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return repo.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable int id) {
        Appointment a = repo.findById(id).orElseThrow();
        a.setCanceled(true);
        repo.save(a);
    }
}
