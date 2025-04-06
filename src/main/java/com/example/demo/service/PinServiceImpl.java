package com.example.demo.service;

import com.example.demo.dto.PinDTO;
import com.example.demo.model.Pin;
import com.example.demo.repository.PinRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PinServiceImpl implements PinService {

    private final PinRepository repository;

    public PinServiceImpl(PinRepository repository) {
        this.repository = repository;
    }

    @Override
    public PinDTO getPin(Long pinId) {
        Pin pin = repository.findById(pinId).get();

        return PinDTO.builder()
                .id(pin.getId())
                .pinUrl(pin.getPinUrl())
                .name(pin.getName())
                .axisX(pin.getAxisX())
                .axisY(pin.getAxisY())
                .type(pin.getType())
                .description(pin.getDescription())
                .imageUrl(pin.getImageUrl())
                .isMarked(pin.isMarked())
                .userId(pin.getUserId())
                .build();
    }

    @Override
    public PinDTO updatePin(PinDTO pinDTO) {
        boolean isPinExisting = repository.existsById(pinDTO.getId());
        if (isPinExisting) {
            Pin pin = Pin.builder()
                    .id(pinDTO.getId())
                    .pinUrl(pinDTO.getPinUrl())
                    .name(pinDTO.getName())
                    .axisX(pinDTO.getAxisX())
                    .axisY(pinDTO.getAxisY())
                    .type(pinDTO.getType())
                    .description(pinDTO.getDescription())
                    .imageUrl(pinDTO.getImageUrl())
                    .isMarked(pinDTO.isMarked())
                    .userId(pinDTO.getUserId())
                    .build();

            Pin updatedPin = repository.save(pin);

            return PinDTO.builder()
                    .id(updatedPin.getId())
                    .pinUrl(updatedPin.getPinUrl())
                    .name(updatedPin.getName())
                    .axisX(updatedPin.getAxisX())
                    .axisY(updatedPin.getAxisY())
                    .type(updatedPin.getType())
                    .description(updatedPin.getDescription())
                    .imageUrl(updatedPin.getImageUrl())
                    .isMarked(updatedPin.isMarked())
                    .userId(updatedPin.getUserId())
                    .build();
        }
        else throw new RuntimeException("Метка не найдена");
    }

    @Override
    public PinDTO savePin(PinDTO pinDTO) {
        Pin newPin = Pin.builder()
                .id(pinDTO.getId())
                .pinUrl(pinDTO.getPinUrl())
                .name(pinDTO.getName())
                .axisX(pinDTO.getAxisX())
                .axisY(pinDTO.getAxisY())
                .type(pinDTO.getType())
                .description(pinDTO.getDescription())
                .imageUrl(pinDTO.getImageUrl())
                .isMarked(pinDTO.isMarked())
                .userId(pinDTO.getUserId())
                .build();
        System.out.println("Маппинг в метку " + newPin);
        Pin savedPin = repository.save(newPin);

        return PinDTO.builder()
                .id(savedPin.getId())
                .pinUrl(savedPin.getPinUrl())
                .name(savedPin.getName())
                .axisX(savedPin.getAxisX())
                .axisY(savedPin.getAxisY())
                .type(savedPin.getType())
                .description(savedPin.getDescription())
                .imageUrl(savedPin.getImageUrl())
                .isMarked(savedPin.isMarked())
                .userId(savedPin.getUserId())
                .build();
    }

    @Override
    public void deletePin(Long pinId) {
        boolean isPinExisting = repository.existsById(pinId);
        if (isPinExisting) {
            repository.deleteById(pinId);
        }
    }

    @Override
    public List<PinDTO> getAllPins() {
        List<Pin> pins = repository.findAll();
        List<PinDTO> pinDTOs = new ArrayList<>();
        for (Pin pin : pins) {
            PinDTO pinDTO = PinDTO.builder()
                    .id(pin.getId())
                    .pinUrl(pin.getPinUrl())
                    .name(pin.getName())
                    .axisX(pin.getAxisX())
                    .axisY(pin.getAxisY())
                    .type(pin.getType())
                    .description(pin.getDescription())
                    .imageUrl(pin.getImageUrl())
                    .isMarked(pin.isMarked())
                    .userId(pin.getUserId())
                    .build();
            pinDTOs.add(pinDTO);
        }
        return pinDTOs;
    }

    @Override
    public void markPin(Long pinId) {
        boolean isPinExisting = repository.existsById(pinId);
        if (isPinExisting) {
            Pin pin = repository.findById(pinId).get();
            pin.setMarked(true);
            repository.save(pin);
        }
        else throw new RuntimeException("Метка не найдена");
    }

    @Override
    public List<PinDTO> getMarkedPins(Long userId) {
        List<Pin> markedPins = repository.findByIsMarkedTrueAndUserId(userId);
        List<PinDTO> markedPinDTOs = new ArrayList<>();
        for (Pin pin : markedPins) {
            PinDTO pinDTO = PinDTO.builder()
                    .id(pin.getId())
                    .pinUrl(pin.getPinUrl())
                    .name(pin.getName())
                    .axisX(pin.getAxisX())
                    .axisY(pin.getAxisY())
                    .type(pin.getType())
                    .description(pin.getDescription())
                    .imageUrl(pin.getImageUrl())
                    .isMarked(pin.isMarked())
                    .userId(pin.getUserId())
                    .build();
            markedPinDTOs.add(pinDTO);
        }
        return markedPinDTOs;
    }
}
