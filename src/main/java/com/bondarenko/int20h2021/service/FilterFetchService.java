package com.bondarenko.int20h2021.service;

import com.bondarenko.int20h2021.domain.json.Cities;
import com.bondarenko.int20h2021.domain.json.Pets;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterFetchService {
    public Cities getCities() {
        List<String> locations = new ArrayList<>();
        locations.add("Київ");
        locations.add("Харків");
        locations.add("Одеса");
        locations.add("Дніпро");
        locations.add("Донецьк");
        locations.add("Запоріжжя");
        locations.add("Львів");
        locations.add("Кривий Ріг");
        locations.add("Миколаїв");
        locations.add("Севастополь");
        locations.add("Маріуполь");
        locations.add("Луганськ");
        locations.add("Вінниця");
        locations.add("Маківка");
        locations.add("Херсон");
        locations.add("Чернігів");
        locations.add("Полтава");
        locations.add("Черкаси");
        locations.add("Житомир");
        locations.add("Хмельницький");
        locations.add("Чернівці");
        locations.add("Суми");
        locations.add("Ровно");
        locations.add("Горловка");
        locations.add("Івано-Франківськ");
        locations.add("Кам'янське");
        locations.add("Кропивницький");
        locations.add("Тернопіль");
        locations.add("Кременчуг");
        locations.add("Луцьк");
        locations.add("Біла Церква");
        locations.add("Краматорськ");
        locations.add("Мелітополь");
        locations.add("Керч");
        locations.add("Ужгород");
        locations.add("Бердянськ");
        locations.add("Нікополь");
        locations.add("Слов'янськ");
        locations.add("Євпаторія");
        locations.add("Бровари");
        locations.add("Алчевськ");
        locations.add("Павлоград");
        locations.add("Сєвєродонецьк");
        return new Cities(locations);
    }

    public Pets getPets() {
        List<String> animals = new ArrayList<>();
        animals.add("Кіт");
        animals.add("Собака");
        animals.add("Корова");
        animals.add("Бик");
        animals.add("Черепаха");
        animals.add("Змія");
        animals.add( "Тигр");
        animals.add("Папуга");
        return new Pets(animals);
    }
}
