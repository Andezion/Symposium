package org.example.contoller;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.example.model.*;
import org.example.service.SymposiumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/symposium")
public class SymposiumController {

    private final SymposiumService symposiumService;

    @Autowired
    public SymposiumController(SymposiumService symposiumService)
    {
        this.symposiumService = symposiumService;
    }


    @PostMapping("/participants")
    public ResponseEntity<Participant> createParticipant(@Valid @RequestBody Participant participant)
    {
        Participant createdParticipant = symposiumService.createParticipant(participant);
        return new ResponseEntity<>(createdParticipant, HttpStatus.CREATED);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room)
    {
        try
        {
            Room createdRoom = symposiumService.createRoom(room);
            return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
        }
        catch (ResponseStatusException e)
        {
            throw e;
        }
    }

    @PostMapping("/topics")
    public ResponseEntity<Topic> createTopic(@Valid @RequestBody Topic topic)
    {
        try
        {
            Topic createdTopic = symposiumService.createTopic(topic);
            return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
        }
        catch (ResponseStatusException e)
        {
            throw e;
        }
    }

    public static class CreatePresentationRequest
    {
        @NotNull(message = "Topic ID cannot be null")
        public Long topicId;
        @NotNull(message = "Presenter ID cannot be null")
        public Long presenterId;
        @NotNull(message = "Room ID cannot be null")
        public Long roomId;
        @NotNull(message = "Date and time cannot be null")
        @FutureOrPresent(message = "Date and time must be in the present or future")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        public LocalDateTime dateTime;
    }

    @PostMapping("/presentations")
    public ResponseEntity<Presentation> createPresentation(@Valid @RequestBody CreatePresentationRequest request)
    {
        try
        {
            Presentation createdPresentation = symposiumService.createPresentation(
                    request.topicId, request.presenterId, request.roomId, request.dateTime
            );
            return new ResponseEntity<>(createdPresentation, HttpStatus.CREATED);
        }
        catch (ResponseStatusException e)
        {
            throw e;
        }
    }

    @GetMapping("/participants")
    public ResponseEntity<List<Participant>> getAllParticipants()
    {
        List<Participant> participants = symposiumService.getAllParticipants();
        return ResponseEntity.ok(participants);
    }

    @GetMapping("/participants/by-type")
    public ResponseEntity<Map<ParticipantType, List<Participant>>> getParticipantsByType()
    {
        Map<ParticipantType, List<Participant>> participantsByType = symposiumService.getParticipantsGroupedByType();
        return ResponseEntity.ok(participantsByType);
    }

    @GetMapping("/participants/by-country")
    public ResponseEntity<Map<String, List<Participant>>> getParticipantsByCountry()
    {
        Map<String, List<Participant>> participantsByCountry = symposiumService.getParticipantsGroupedByCountry();
        return ResponseEntity.ok(participantsByCountry);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllPresentationTopics()
    {
        List<Topic> topics = symposiumService.getAllPresentationTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/presenters/most-presentations")
    public ResponseEntity<Participant> getPresenterWithMostPresentations()
    {
        Optional<Participant> presenter = symposiumService.getPresenterWithMostPresentations();
        return presenter.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/rooms/presentation-counts")
    public ResponseEntity<Map<String, Long>> getPresentationsCountPerRoom()
    {
        Map<String, Long> counts = symposiumService.getPresentationsCountPerRoom();
        return ResponseEntity.ok(counts);
    }
}