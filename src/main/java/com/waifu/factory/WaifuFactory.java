package com.waifu.factory;

import com.waifu.model.Element;
import com.waifu.model.Waifu;

public class WaifuFactory {
    private int nextId = 1;

    public Waifu create(String type) {
        return switch (type.toLowerCase()) {
            case "konomi" -> new Waifu(nextId++, "Konomi Tatara", "Mato Seihei no Slave", Element.WIND, 82, 45, 185);
            case "bell" -> new Waifu(nextId++, "Bell Tsukiyono", "Mato Seihei no Slave", Element.LIGHT, 78, 48, 190);
            case "yakumo" -> new Waifu(nextId++, "Yakumo Ezo", "Mato Seihei no Slave", Element.WIND, 88, 52, 195);
            case "tenka" -> new Waifu(nextId++, "Tenka Izumo", "Mato Seihei no Slave", Element.LIGHT, 84, 58, 205);
            case "kyouka" -> new Waifu(nextId++, "Kyouka Uzen", "Mato Seihei no Slave", Element.SHADOW, 86, 55, 210);
            case "varvara" -> new Waifu(nextId++, "Varvara Pilipenko", "Mato Seihei no Slave", Element.SHADOW, 80, 70, 220);
            case "fubuki" -> new Waifu(nextId++, "Fubuki Azuma", "Mato Seihei no Slave", Element.WATER, 79, 64, 215);
            case "ren" -> new Waifu(nextId++, "Ren Yamashiro", "Mato Seihei no Slave", Element.FIRE, 94, 68, 225);
            default -> throw new IllegalArgumentException("Capitana desconocida: " + type);
        };
    }
}
