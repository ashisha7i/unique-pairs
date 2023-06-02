package com.agniho3s.trails.model;

public class Presenter {
    private String name;
    private String team;
    private Boolean hasPresented;
    private Boolean isPaired;

    public Presenter() {
        super();
    }

    public Presenter(String name, String team, Boolean hasPresented, Boolean isPaired) {
        this.name = name;
        this.team = team;
        this.hasPresented = hasPresented;
        this.isPaired = isPaired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Boolean getHasPresented() {
        return hasPresented;
    }

    public void setHasPresented(Boolean hasPresented) {
        this.hasPresented = hasPresented;
    }

    public Boolean getIsPaired() {
        return isPaired;
    }

    public void setIsPaired(Boolean isPaired) {
        this.isPaired = isPaired;
    }

    @Override
    public String toString() {
        return "Presenter{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", hasPresented=" + hasPresented +
                ", isPaired=" + isPaired +
                '}';
    }
}
