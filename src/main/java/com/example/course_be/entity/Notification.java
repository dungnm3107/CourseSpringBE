package com.example.course_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "created_date", updatable = false, nullable = false)
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}