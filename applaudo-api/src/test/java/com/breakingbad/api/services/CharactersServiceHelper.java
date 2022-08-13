package com.breakingbad.api.services;

import com.breakingbad.api.util.GenericUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CharactersServiceHelper {

    public static Response getAllCharacters() {
        return given().when().get(GenericUtils.baseURL + GenericUtils.prop.getProperty("getAllCharactersEndpoint"));
    }

    public static Response getSingleCharacters(String characterId) {
        return given().when().get(GenericUtils.baseURL + GenericUtils.prop.getProperty("getSingleCharacterEndpoint").replace("$characterId", characterId));
    }

    public static Response searchCharactersByName(String characterName) {
        return given().when().get(GenericUtils.baseURL + GenericUtils.prop.getProperty("searchCharacterByNameEndpoint").replace("$characterName", characterName));
    }


}
