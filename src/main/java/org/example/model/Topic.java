package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "topics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Topic name cannot be empty")
    @Size(min = 3, max = 255, message = "Topic name must be between 3 and 255 characters")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;
}