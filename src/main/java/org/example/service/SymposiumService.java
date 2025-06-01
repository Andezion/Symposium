package org.example.service;

import org.example.model.*;
import org.example.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SymposiumService
{
    private final ParticipantRepository participantRepository;
    private final RoomRepository roomRepository;
    private final TopicRepository topicRepository;
    private final PresentationRepository presentationRepository;

    @Autowired
    public SymposiumService(ParticipantRepository participantRepository,
                            RoomRepository roomRepository,
                            TopicRepository topicRepository,
                            PresentationRepository presentationRepository)
    {
        this.participantRepository = participantRepository;
        this.roomRepository = roomRepository;
        this.topicRepository = topicRepository;
        this.presentationRepository = presentationRepository;
    }

    @Transactional
    public Participant createParticipant(Participant participant)
    {
        return participantRepository.save(participant);
    }

    @Transactional
    public Room createRoom(Room room)
    {
        if (roomRepository.existsByName(room.getName()))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room with name '" + room.getName() + "' already exists.");
        }
        return roomRepository.save(room);
    }

    @Transactional
    public Topic createTopic(Topic topic)
    {
        if (topicRepository.existsByName(topic.getName()))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Topic with name '" + topic.getName() + "' already exists.");
        }
        return topicRepository.save(topic);
    }

    @Transactional
    public Presentation createPresentation(Long topicId, Long presenterId, Long roomId, LocalDateTime dateTime)
    {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found with ID: " + topicId));
        Participant presenter = participantRepository.findById(presenterId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Presenter not found with ID: " + presenterId));
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found with ID: " + roomId));

        if (presentationRepository.existsByTopic(topic))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Topic '" + topic.getName() + "' has already been presented.");
        }

        Presentation presentation = new Presentation(null, topic, presenter, room, dateTime);
        return presentationRepository.save(presentation);
    }


    public List<Participant> getAllParticipants()
    {
        return participantRepository.findAll();
    }

    public Map<ParticipantType, List<Participant>> getParticipantsGroupedByType()
    {
        return participantRepository.findAll().stream()
                .collect(Collectors.groupingBy(Participant::getType));
    }

    public Map<String, List<Participant>> getParticipantsGroupedByCountry()
    {
        return participantRepository.findAll().stream()
                .collect(Collectors.groupingBy(Participant::getCountryOfOrigin));
    }

    public List<Topic> getAllPresentationTopics()
    {
        return topicRepository.findAll();
    }

    public Optional<Participant> getPresenterWithMostPresentations()
    {
        return presentationRepository.findAll().stream()
                .collect(Collectors.groupingBy(Presentation::getPresenter, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Map<String, Long> getPresentationsCountPerRoom()
    {
        return presentationRepository.findAll().stream()
                .collect(Collectors.groupingBy(p -> p.getRoom().getName(), Collectors.counting()));
    }
}