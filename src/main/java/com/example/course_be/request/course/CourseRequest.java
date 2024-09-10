package com.example.course_be.request.course;

import com.example.course_be.enums.CourseType;
import com.example.course_be.infrastructure.constant.EntityProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {

    private Long idCourse;

    @NotNull(message = "Id user create is not empty")
    private Long idUserCreate;

    @Size(min = EntityProperties.MAX_LENGTH_5, max = EntityProperties.MAX_LENGTH_50, message = "Title must be between 5 and 50 characters")
    @NotBlank(message = "Title is not empty")
    private String title;

    @Size(min = EntityProperties.MAX_LENGTH_10, max = EntityProperties.MAX_LENGTH_225, message = "Description must be between 10 and 255 characters")
    @NotBlank(message = "Description is not empty")
    private String description;

    @PositiveOrZero(message = "Price must be non-negative")
    private BigDecimal coursePrice;

    private String cover;

    private CourseType courseType;

    private Boolean deleted;


}
