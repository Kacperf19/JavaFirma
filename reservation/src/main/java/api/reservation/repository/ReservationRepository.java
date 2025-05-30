package api.reservation.repository;

import api.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
            "FROM Reservation r " +
            "WHERE r.room.id = :roomId " +
            "AND r.endTime > :startTime " +
            "AND r.startTime < :endTime")
    boolean existsByRoomAndTimeOverlap(@Param("roomId") Long roomId,
                                       @Param("startTime") LocalDate startTime,
                                       @Param("endTime") LocalDate endTime);

}
