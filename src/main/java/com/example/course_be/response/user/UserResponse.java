package com.example.course_be.response.user;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponse {

    private Long id;

    private String userName;

    private String fullName;

    private String email;

    private String avatar;

    private String gender;

    private String phone;

    private Boolean isDeleted;

}
