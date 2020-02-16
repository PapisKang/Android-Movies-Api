package com.projettec.apiproject;

public class Cast {

    private String cast_id;
    private String character;
    private String name;
    private String profile_path;

    public Cast(String cast_id, String character, String name, String profile_path) {
        this.cast_id = cast_id;
        this.character = character;
        this.name = name;
        this.profile_path = profile_path;
    }

    public String getCast_id() {
        return cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }

    public String getProfile_path() {
        return profile_path;
    }
}
