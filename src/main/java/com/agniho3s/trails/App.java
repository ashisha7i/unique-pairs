package com.agniho3s.trails;

import com.agniho3s.trails.model.Presenter;
import com.agniho3s.trails.utils.Generator;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Presenter> allPresenters = Generator.getPresentersList(); // Gets you the list of presenters
        printPresenters(allPresenters);
        // Your code below (You can uncomment the 'printPresenters' method call above if you want. It's just a helper method to print the presenters list)
        // Problem statement
        // - Each 'Presenter' belongs to a team
        // - Each 'Presenter' has a 'hasPresented' flag
        // - Each 'Presenter' has a 'isPaired' flag
        // - Each 'Presenter' can only be paired with another 'Presenter' from a different team
        // - Each 'Presenter' can only be paired with another 'Presenter' who has not presented yet
        // - Each 'Presenter' can only be paired with another 'Presenter' who has not been paired yet
        // - Once a 'Presenter' has been paired, the 'isPaired' flag should be set to true (and should not be paired again)

        // - Output: Print a list of paired presenters
        // - Output: Print a list of 'Presenter's who could not be paired

    }

    // Helper method to print the presenters list (*You should not need to modify this method* but feel free to if you want)
    private static void printPresenters(List<Presenter> presenters) {
        presenters.forEach(presenter -> {
            System.out.println(presenter);
        });
    }
}
