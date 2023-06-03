package com.agniho3s.trails;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.agniho3s.trails.model.Presenter;

public class Solution {
    public static Map<Presenter, Presenter> pairedPresenters(List<Presenter> presenters) {
        // Get all teams and presenters map
        Map<String, List<Presenter>> teamsAndPresenters = presenters.stream()
            .collect(Collectors.groupingBy(Presenter::getTeam));

        // Get the count of teams
        // int teamsCount = teamsAndPresenters.size();

        // Select the team with the highest number of presenters
        // List<Presenter> teamWithMostPresenters = teamsAndPresenters.values().stream()
        //    .max((team1, team2) -> team1.size() - team2.size())
        //    .orElse(null);
        
        // System.out.println("Team with most presenters: " + teamWithMostPresenters);

        // Get a random presenter to begin
        // Random random = new Random();
        Presenter presenter = getUnpairedPresenter(presenters);

        for(Presenter paired = getPresenter(presenters, presenter); paired != null; paired = getPresenter(presenters, presenter)) {
            presenter.setIsPaired(true);
            paired.setIsPaired(true);
            System.out.printf("%-25s  %-18s  %-25s  %-18s%n",presenter.getName(), presenter.getTeam(), paired.getName(), paired.getTeam());
            presenter = getUnpairedPresenter(presenters);
            if(presenter == null) {
                break;
            }
        }

        System.out.println("\nUNPAIRED PRESENTERS:");
        // Print unpaired presenters
        
        presenters.stream()
            .filter(p -> !p.isPaired() && !p.hasPresented())
            .forEach(p -> System.out.println("Unpaired: " + p));

        // Print presenters who have presented
        System.out.println("\nPRESENTED PRESENTERS:");
        presenters.stream()
            .filter(Presenter::hasPresented)
            .forEach(p -> System.out.println("Presented: " + p));

        return null;
    }

    private static Presenter getUnpairedPresenter(List<Presenter> presenters) {
        return presenters.stream()
            .filter(p -> !p.isPaired() && !p.hasPresented())
            .findAny()
            .orElse(null);
    }

    private static Presenter getPresenter(List<Presenter> presentersList, Presenter presenter) {
        return presentersList.stream()
            .sorted(Comparator.comparing(Presenter::getTeam))
            .filter(p -> !p.equals(presenter) && !p.isPaired() && !p.hasPresented() && !p.getTeam().equals(presenter.getTeam()))
            .findAny()
            .orElse(null);
    }
}
