package DFAProject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j23schoen
 */
public class DFATransitions {
    
    private String state, nextState;
    private int input;
    
    public DFATransitions(String state, int input, String nextState){
        this.state = state;
        this.input = input;
        this.nextState = nextState;
    }
    
    public String getState(){
        return state;
    }
    public int getInput(){
        return input;
    }
    public String getNextState(){
        return nextState;
    }
    
    public String toString(){
        String temp = "";
        temp = state + " " + input + " " + nextState;
        
        return temp;
    }
}
