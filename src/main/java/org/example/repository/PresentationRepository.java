package org.example.repository;

import org.example.model.Presentation;
import org.example.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long>
{
    boolean existsByTopic(Topic topic);
}