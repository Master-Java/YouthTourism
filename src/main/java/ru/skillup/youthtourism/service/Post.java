package ru.skillup.youthtourism.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {

    private int userId;
    private int id;
    private String title;
    private String body;
}