package com.projettec.apiproject;

public class Production_companie {

    private String id;
    private String logo_path;
    private String name;
    private String origin_country;

    public Production_companie(String id, String logo_path, String name, String origin_country) {
        this.id = id;
        this.logo_path = logo_path;
        this.name = name;
        this.origin_country = origin_country;
    }

    public String getId() {
        return id;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public String getName() {
        return name;
    }

    public String getOrigin_country() {
        return origin_country;
    }
}
