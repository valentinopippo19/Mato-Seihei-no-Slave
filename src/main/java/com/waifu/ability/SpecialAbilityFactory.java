package com.waifu.ability;

/** Factory dedicada a asociar una habilidad única con cada capitana. */
public final class SpecialAbilityFactory {
    private SpecialAbilityFactory() {}

    public static SpecialAbility forWaifu(String name) {
        return switch (name.toLowerCase()) {
            case "konomi tatara" -> new BeastPowerAbility();
            case "bell tsukiyono" -> new CanopusAbility();
            case "yakumo ezo" -> new NightStormAbility();
            case "tenka izumo" -> new AmeNoMitoriAbility();
            case "kyouka uzen" -> new SlaveAbility();
            case "varvara pilipenko" -> new PantheonAbility();
            case "fubuki azuma" -> new SunsetAbility();
            case "ren yamashiro" -> new AllEncompassingAbility();
            default -> throw new IllegalArgumentException("Capitana desconocida: " + name);
        };
    }
}
