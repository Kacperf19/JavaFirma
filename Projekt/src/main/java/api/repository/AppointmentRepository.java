package api.repository;

import api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    public List<Appointment> findBySpecialistIdAndCanceledFalseAndDateTimeBetween(Integer specialistId, LocalDateTime start , LocalDateTime end);
}
