package api.controller;

import api.model.Specialist;
import api.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialists")
public class SpecialistController {

    @Autowired
    private SpecialistRepository repo;

    @GetMapping
    public List<Specialist> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Specialist create(@RequestBody Specialist specialist) {
        return repo.save(specialist);
    }
}
