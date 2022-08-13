package com.breakingbad.api.tests;

import com.breakingbad.api.model.Characters;
import com.breakingbad.api.services.CharactersServiceHelper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllCharactersTest {

    @Test(enabled = true)
    public static void getAllCharactersAndPrint() {
        
        Response getallCharactersResponse = CharactersServiceHelper.getAllCharacters();
        ResponseBody responseBody = getallCharactersResponse.getBody();
        List<Characters> charactersList = getCharacters(responseBody);
        printCharacters(charactersList);
    }

    @Test(enabled = true)
    public static void getCharactersInformation() {

        Response getCharactersResponse = CharactersServiceHelper.searchCharactersByName("Walter White");
        ResponseBody responseBody = getCharactersResponse.getBody();
        printCharacterinfo(responseBody);
    }

    private static List<Characters> getCharacters(ResponseBody responseBody) {

        List<String> jsonResponse = responseBody.jsonPath().getList("$");
        List<Characters> charactersList = new ArrayList<>();

        for (int i = 0; i< jsonResponse.size(); i++) {
            Characters characters = new Characters();
            characters.setName(responseBody.jsonPath().getList("char_id").get(i).toString());
            characters.setName(responseBody.jsonPath().getList("name").get(i).toString());
            characters.setPortrayed(responseBody.jsonPath().getList("birthday").get(i).toString());
            characters.setPortrayed(responseBody.jsonPath().getList("portrayed").get(i).toString());
            charactersList.add(characters);
        }
        return charactersList;
    }

    private static void printCharacters(List<Characters> charactersList) {
        for (Characters characters : charactersList) {
            System.out.println("Character name: \"" + characters.getName() + "\"\n");
            System.out.println("Portrayed: \"" + characters.getPortrayed() + "\"\n");
            System.out.println("------------------------------------------------------");
        }
    }

    private static void printCharacterinfo(ResponseBody responseBody) {
        System.out.println("Birthday Information for Walter White : " +
                responseBody.jsonPath().getList("birthday").get(0).toString());
    }

}
