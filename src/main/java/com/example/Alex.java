package com.example;

import java.util.List;

public class Alex extends Lion {
    //Алекс самец и хищник
    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    //Список друзей Алекса
    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    //Место, где живет Алекс
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    //У Алекса нет львят
    @Override
    public int getKittens() {
        return 0;
    }
}
