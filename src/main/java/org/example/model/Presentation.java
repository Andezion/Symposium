package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity
@Table(name = "presentations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Presentation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Topic cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Topic topic;

    @NotNull(message = "Presenter cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presenter_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Participant presenter;

    @NotNull(message = "Room cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Room room;

    @NotNull(message = "Date and time cannot be null")
    @FutureOrPresent(message = "Date and time must be in the present or future")
    private LocalDateTime dateTime;
}