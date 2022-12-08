package com.consultcalhoun.interviewing;

import java.util.Stack;

/**
 *
 * @author eben
 */
public class BrowsingStateHistory {
    private String currentLocation = "https://amperity.com";
    
    private Stack<String> backwards = new Stack<String>();
    private Stack<String> forwards = new Stack<String>();

    public BrowsingStateHistory() {
        
    }
    
    // API team to get initial homepage / or if somehow need current location again?
    public String whereAmI() {
        return currentLocation;
    }
    
    // API team code calls this when browser is navigating to a new link or User types-in new URL and hits Enter.
    public void whereTo(String destination) {
        backwards.push(currentLocation);
        currentLocation = destination;
    }
    
    // API team code wants to move backwards in navigation path
    public String back() {
        forwards.push(currentLocation);
        currentLocation = backwards.pop();
        return currentLocation;
    }
    
    // API team wants to navigate fowards
    public String forwards() {
        backwards.push(currentLocation);
        currentLocation = forwards.pop();
        return currentLocation;
    }
    
}
