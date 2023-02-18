package ru.skillup.youthtourism.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private long id;
    private String phone;
    private String city;
    private String university;
    private String interests;
}
