package com.projettec.apiproject;

import java.util.List;

public class CastList {

    private List<Cast> cast;

    public CastList(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
}
