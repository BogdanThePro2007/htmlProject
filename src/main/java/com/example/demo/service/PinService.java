package com.example.demo.service;

import com.example.demo.dto.PinDTO;

import java.util.List;

public interface PinService {
    PinDTO getPin(Long pinId);
    PinDTO updatePin(PinDTO pinDTO);
    PinDTO savePin(PinDTO pinDTO);
    void deletePin(Long pinId);

    List<PinDTO> getAllPins();
    void markPin(Long pinId);
    List<PinDTO> getMarkedPins(Long userId);
}
