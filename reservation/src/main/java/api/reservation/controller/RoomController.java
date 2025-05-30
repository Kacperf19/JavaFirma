package api.reservation.controller;

import api.reservation.entity.Reservation;

import api.reservation.entity.Room;
import api.reservation.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {
    private final RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/addRoomFrom")
    public String room(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("rooms", roomRepository.findAll());
    return "Admin/addRoomForm";
}
    @PostMapping("/addRooms")
    public String addRoom(@ModelAttribute Room room, Model model) {
        roomRepository.save(room);
        model.addAttribute("rooms", roomRepository.findAll());
        return "redirect:/addRoomFrom";
    }
    @PostMapping("/deleteRoom")
    public String deleteRoom(@RequestParam Long id) {
        roomRepository.deleteById(id);
        return "redirect:/addRoomFrom";
    }



}
