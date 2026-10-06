package com.waifu.external;

public class FakeAnimeApi implements ExternalAnimeApi {
    public ExternalCharacter fetchCharacter(String alias) {
        return new ExternalCharacter(alias, "Mato Seihei no Slave", "LIGHT", 80, 55, 205);
    }
}
