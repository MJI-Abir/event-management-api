package com.example.event_management_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.event_management_api.model.Event;
import com.example.event_management_api.model.Registration;
import com.example.event_management_api.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Page<Registration> findByUser(User user, Pageable pageable);
    Page<Registration> findByEvent(Event event, Pageable pageable);
    Optional<Registration> findByUserAndEvent(User user, Event event);
    boolean existsByUserAndEvent(User user, Event event);

    // @Query("SELECT COUNT(r) FROM Registration r WHERE r.event = :event")
    Long countByEventId(Long eventId);
    
}
