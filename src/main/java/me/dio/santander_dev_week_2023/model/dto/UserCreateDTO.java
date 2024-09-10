package me.dio.santander_dev_week_2023.model.dto;

import me.dio.santander_dev_week_2023.model.*;

import java.util.List;

public record UserCreateDTO(String name,
                            Account account,
                            Card card,
                            List<Feature> features,
                            List<News> news) {

    public UserCreateDTO(User user) {
        this(user.getName(), user.getAccount(), user.getCard(), user.getFeatures(), user.getNews());
    }
}
