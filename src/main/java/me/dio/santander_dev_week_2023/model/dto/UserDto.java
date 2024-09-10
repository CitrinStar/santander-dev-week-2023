package me.dio.santander_dev_week_2023.model.dto;

import me.dio.santander_dev_week_2023.model.*;

import java.util.List;

public record UserDto(Long id,
                      String name,
                      Account account,
                      Card card,
                      List<Feature> features,
                      List<News> news) {

    public UserDto(User user) {
        this(user.getId(), user.getName(), user.getAccount(), user.getCard(), user.getFeatures(), user.getNews());
    }
}
