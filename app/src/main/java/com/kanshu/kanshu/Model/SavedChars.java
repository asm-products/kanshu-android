package com.kanshu.kanshu.model;

import com.kanshu.kanshu.ApiHandler;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by alouanemed on 06-02-2015.
 */
public class SavedChars {
    //the Chinese character
    private String Char;
    private String Chardescription;
    private int wordID;
    private String translation;
    private String pronunciation;

    public SavedChars(){}

    public String getChar() {
        return Char;
    }

    public void setChar(String aChar) {
        Char = aChar;
    }

    public String getChardescription() {
        return Chardescription;
    }

    public void setChardescription(String chardescription) {
        Chardescription = chardescription;
    }

    public int getWordID (){return wordID;}

    public void setWordID(int id){wordID = id;}

    public String getTranslation(){ return translation; }

    public void setTranslation(String translatedTo){translation = translatedTo;}

    public String getPronunciation(){return pronunciation;}

    public void setPronunciation(String charsPronouncedAs){ pronunciation = charsPronouncedAs;}

    public void save(String id)
    {
        ApiHandler.kanshuApi.saveWord(id,new WordPacket(wordID),new Callback<String>(){
            @Override
            public void success(String s, Response response) {
            }
            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public void delete(String id)
    {
        ApiHandler.kanshuApi.deleteWord(id, new WordPacket(wordID), new Callback<String>() {
            @Override
            public void success(String s, Response response) {
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public class WordPacket{
        String wordId;
        public WordPacket(int id){wordId = String.valueOf(id);}
    }

}
