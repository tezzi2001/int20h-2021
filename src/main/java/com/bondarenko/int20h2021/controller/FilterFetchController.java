package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.Cities;
import com.bondarenko.int20h2021.domain.json.City;
import com.bondarenko.int20h2021.domain.json.Pet;
import com.bondarenko.int20h2021.domain.json.Pets;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilterFetchController {

    @GetMapping("/cities")
    public Cities getLocations() {
        List<City>locations = new ArrayList<>();
        locations.add(new City(1, "Київ"));
        locations.add(new City(2, "Харків"));
        locations.add(new City(3, "Одеса"));
        locations.add(new City(4, "Дніпро"));
        locations.add(new City(5, "Донецьк"));
        locations.add(new City(6, "Запоріжжя"));
        locations.add(new City(7, "Львів"));
        locations.add(new City(8, "Кривий Ріг"));
        locations.add(new City(9, "Миколаїв"));
        locations.add(new City(10, "Севастополь"));
        locations.add(new City(11, "Маріуполь"));
        locations.add(new City(12, "Луганськ"));
        locations.add(new City(13, "Вінниця"));
        locations.add(new City(14, "Сімферополь"));
        locations.add(new City(15, "Маківка"));
        locations.add(new City(16, "Херсон"));
        locations.add(new City(17, "Чернігів"));
        locations.add(new City(18, "Полтава"));
        locations.add(new City(19, "Черкаси"));
        locations.add(new City(20, "Житомир"));
        locations.add(new City(21, "Хмельницький"));
        locations.add(new City(22, "Чернівці"));
        locations.add(new City(23, "Суми"));
        locations.add(new City(24, "Ровно"));
        locations.add(new City(25, "Горловка"));
        locations.add(new City(26, "Івано-Франківськ"));
        locations.add(new City(27, "Кам'янське"));
        locations.add(new City(28, "Кропивницький"));
        locations.add(new City(29, "Тернопіль"));
        locations.add(new City(30, "Кременчуг"));
        locations.add(new City(31, "Луцьк"));
        locations.add(new City(32, "Біла Церква"));
        locations.add(new City(33, "Краматорськ"));
        locations.add(new City(34, "Мелітополь"));
        locations.add(new City(35, "Керч"));
        locations.add(new City(36, "Ужгород"));
        locations.add(new City(37, "Бердянськ"));
        locations.add(new City(38, "Нікополь"));
        locations.add(new City(39, "Слов'янськ"));
        locations.add(new City(40, "Євпаторія"));
        locations.add(new City(41, "Бровари"));
        locations.add(new City(42, "Алчевськ"));
        locations.add(new City(43, "Павлоград"));
        locations.add(new City(44, "Сєвєродонецьк"));
        return new Cities(locations);
    }

    @GetMapping("/pets")
    public Pets getPets() {
        List<Pet> animals = new ArrayList<>();
        animals.add(new Pet(1, "Кіт"));
        animals.add(new Pet(2, "Собака"));
        animals.add(new Pet(3, "Корова"));
        animals.add(new Pet(4, "Бик"));
        animals.add(new Pet(5, "Черепаха"));
        animals.add(new Pet(6, "Змія"));
        animals.add(new Pet(7, "Тигр"));
        animals.add(new Pet(8, "Папуга"));

//        animals.add(new Pet(9, "Миколаїв"));
//        animals.add(new Pet(10, "Севастополь"));
//        animals.add(new Pet(11, "Маріуполь"));
//        animals.add(new Pet(12, "Луганськ"));
//        animals.add(new Pet(13, "Вінниця"));
//        animals.add(new Pet(14, "Сімферополь"));
//        animals.add(new Pet(15, "Маківка"));
//        animals.add(new Pet(16, "Херсон"));
//        animals.add(new Pet(17, "Чернігів"));
//        animals.add(new Pet(18, "Полтава"));
//        animals.add(new Pet(19, "Черкаси"));
//        animals.add(new Pet(20, "Житомир"));
//        animals.add(new Pet(21, "Хмельницький"));
//        animals.add(new Pet(22, "Чернівці"));
//        animals.add(new Pet(23, "Суми"));
//        animals.add(new Pet(24, "Ровно"));
//        animals.add(new Pet(25, "Горловка"));
//        animals.add(new Pet(26, "Івано-Франківськ"));
//        animals.add(new Pet(27, "Кам'янське"));
//        animals.add(new Pet(28, "Кропивницький"));
//        animals.add(new Pet(29, "Тернопіль"));
//        animals.add(new Pet(30, "Кременчуг"));
//        animals.add(new Pet(31, "Луцьк"));
//        animals.add(new Pet(32, "Біла Церква"));
//        animals.add(new Pet(33, "Краматорськ"));
//        animals.add(new Pet(34, "Мелітополь"));
//        animals.add(new Pet(35, "Керч"));
//        animals.add(new Pet(36, "Ужгород"));
//        animals.add(new Pet(37, "Бердянськ"));
//        animals.add(new Pet(38, "Нікополь"));
//        animals.add(new Pet(39, "Слов'янськ"));
//        animals.add(new Pet(40, "Євпаторія"));
//        animals.add(new Pet(41, "Бровари"));
//        animals.add(new Pet(42, "Алчевськ"));
//        animals.add(new Pet(43, "Павлоград"));
//        animals.add(new Pet(44, "Сєвєродонецьк"));
        return new Pets(animals);
    }
}
