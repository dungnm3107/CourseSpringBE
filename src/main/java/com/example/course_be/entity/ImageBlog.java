package com.example.course_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "image_blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageBlog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "name_image")
    private String nameImage;

    @Column(name = "url")
    private String image_url;


    @ManyToOne( cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "blog_id" , nullable = false)
    private Blog blog;


}