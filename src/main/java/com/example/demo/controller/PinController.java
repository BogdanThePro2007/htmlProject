package com.example.demo.controller;

import com.example.demo.dto.PinDTO;
import com.example.demo.service.PinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pins")
public class PinController {

    //localhost:8080/api/pins - createPin(@RequestBody PinDTO pinDTO),
    //updatePin(@RequestBody PinDTO pinDTO)
    //getAllPins()

    //localhost:8080/api/pins/какой-то ид
    //getPin(@PathVariable Long id)
    //deletePin(@PathVariable Long id)

    private final PinService pinService;

    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    @PostMapping
    public ResponseEntity<PinDTO> createPin(@RequestBody PinDTO pinDTO) {
        System.out.println("Метод контроллера createPin получает pinDTO: " + pinDTO);
        PinDTO createdPin = pinService.savePin(pinDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PinDTO> getPin(@PathVariable Long id) {
        System.out.println("Метод контроллера getPin получает id: " + id);
        PinDTO pin = pinService.getPin(id);
        return ResponseEntity.ok(pin);
    }

    @PutMapping
    public ResponseEntity<PinDTO> updatePin(@RequestBody PinDTO pinDTO) {
        System.out.println("Метод контроллера updatePin получает pinDTO: " + pinDTO);
        PinDTO updatedPin = pinService.updatePin(pinDTO);
        return ResponseEntity.ok(updatedPin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable Long id) {
        System.out.println("Метод контроллера deletePin получает id: " + id);
        pinService.deletePin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PinDTO>> getAllPins(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            return ResponseEntity.ok(pinService.getMarkedPins(userId));
        } else return ResponseEntity.ok(pinService.getAllPins());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> markPin(@PathVariable Long id) {
        System.out.println("Метод контроллера markPin получает id: " + id);
        pinService.markPin(id);
        return ResponseEntity.noContent().build();
    }
}
