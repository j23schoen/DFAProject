package DFAProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * 
 */
/**
 *
 * @author j23schoen
 */
public class DFA {
    //inputString holds line 0

    private String[] inputString;
    //states holds line 1
    private String[] states;
    //inputAlphabet holds line 2
    private String[] inputAlphabet;
    //startState holds line 3
    private String startState;
    //acceptedStates holds line 4
    private String[] acceptedStates;
    //stateTransitions holds the remaining lines
    private String[] stateTransitions;
    //noSpaceTransitions holds the remaining lines with no spaces
    private String[] noSpaceTransitions;
    // text holds the no space transitions as one long string of states and inputs
    private String text;
    //count is used to go through the inputString array
    private int count;
    //dfaTransitions is a an array list of the class, DFATransitions. It holds all the transitions.
    private ArrayList<DFATransitions> dfaTransitions;
    //remembers the state that was transitioned to
    private String statePlaceHolder;
    //errorCounter counts the number of input errors
    private Boolean hasErrors;

    //constructor for DFA class. Loads input data as an array
    public DFA(String[] input){
        System.out.println("DFA");
        count = -1;
        text = "";
        stateTransitions = new String[input.length - 5];
        dfaTransitions = new ArrayList<>();
        statePlaceHolder = "";
        hasErrors = false;
        parseData(input);

    }

    // parseData() reads the data from the input parameter and puts the data into the proper arrays
    private void parseData(String[] input){
        System.out.println("parseData() called");

        checkForErrors(input);
        if (hasErrors == true) {
            System.out.println("There are errors with the input");
        } else {
            inputString = input[0].split("(?!^)");

            states = input[1].split(" ");

            inputAlphabet = input[2].split(" ");

            startState = input[3];

            acceptedStates = input[4].split(" ");

            for (int i = 5; i < input.length; i++) {
                stateTransitions[i - 5] = input[i];
            }

            parseStateTransitions(stateTransitions);
            
            
        }


    }

    // parseStateTransitions() accepts the transitions loaded in from the constructor.
    // It then parses them into a string, which then puts them back into an array.
    // Once in the array, they are put into an ArrayList of DFATransitions
    private void parseStateTransitions(String[] transitions) {
        System.out.println("parseStateTransitions");
        //assigning the array of transitions to a string to parse into separate parts
        for (int i = 0; i < transitions.length; i++) {//begin for loop setting the string to the array contents
            text += transitions[i];
        }

        //remove the spaces
        text = text.replaceAll("\n", "").replaceAll(" ", "");

        //set the contents to a new array
        noSpaceTransitions = text.split("(?!^)");
        for (int i = 0; i < noSpaceTransitions.length; i = i + 3) {//begin for loop setting the values for the state, input, and nextState arrayLists
            dfaTransitions.add(new DFATransitions(noSpaceTransitions[i], Integer.parseInt(noSpaceTransitions[i + 1]), noSpaceTransitions[i + 2]));
        }

    }

    // oneStep() does the processing for determining if an inputString is accepted or not.
    public String oneStep() {
        
        String temp = "";
        count++;
        if (hasErrors == true) {
            temp = "cannot perform any steps with incorrect data\n";
            System.out.println(temp);
        } else {
            System.out.println("oneStep()");
            if (count != 0 && count < inputString.length) {
                for (int i = 0; i < dfaTransitions.size(); i++) {
                    if (statePlaceHolder.equals(dfaTransitions.get(i).getState())) {
                        if (dfaTransitions.get(i).getInput() == Integer.parseInt(inputString[count])) {
                            temp = "delta(" + statePlaceHolder + ", " + dfaTransitions.get(i).getInput() + ") is "
                                    + dfaTransitions.get(i).getNextState() + "\n";
                            System.out.println(temp);
                            statePlaceHolder = dfaTransitions.get(i).getNextState();
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < acceptedStates.length; i++) {
                    if (statePlaceHolder.equals(acceptedStates[i])) {
                        temp = "intput string is accepted\n";
                        System.out.println(temp);
                        break;
                    } else {
                        temp = "input string is NOT accepted\n";
                        System.out.println(temp);
                    }
                }
            }

            if (count == 0) {
                for (int i = 0; i < dfaTransitions.size(); i++) {
                    if (startState.equals(dfaTransitions.get(i).getState())) {
                        if (dfaTransitions.get(i).getInput() == Integer.parseInt(inputString[count])) {
                            temp = "delta(" + dfaTransitions.get(i).getState() + ", " + dfaTransitions.get(i).getInput() + ") is "
                                    + dfaTransitions.get(i).getNextState() + "\n";
                            System.out.println(temp);
                            statePlaceHolder = dfaTransitions.get(i).getNextState();
                        }
                    }
                }
            }
        }


        return temp;
    }

    // allSteps() runs the oneStep() method in a while loop until it is complete.
    public String allSteps() {
        System.out.println("allSteps()");
        String temp = "";

        while (count <= inputString.length) {
            temp += oneStep();
            count++;
        }

        return temp;
    }

    public void checkForErrors(String[] input) {

        System.out.println("checkForErrors() called");
        
        String[] tempStates;
        tempStates = input[1].split(" ");
        String[] tempStartStates = new String[input.length-5];
        for (int i = 5; i < input.length; i++) {
                tempStartStates[i - 5] = input[i];
        }
        parseStateTransitions(tempStartStates);
        String[] tempTransitions = new String[dfaTransitions.size()];
        for( int i = 0; i < dfaTransitions.size(); i++){
            tempTransitions[i] = dfaTransitions.get(i).getState();
        }

       if(transitionsVsAlphabet(tempStates, tempTransitions)){
           System.out.println("no errors");
       }
       else{
           System.out.println("errors");
       }
        
        
        
        if (input[0].length() == 0) {
            hasErrors = true;
            System.out.println("the input string length cannot be less than 1.");
        } else {
            hasErrors = false;
        }
        
        String[] stateTemp = new String[input[1].split(" ").length];
        for(int i =0; i < input[1].length(); i++){
            stateTemp = input[1].split(" ");
        }
        for(int i =0; i < stateTemp.length; i++){
            for(int j = i +1; j < stateTemp.length; j++){
                if((j != i) && (stateTemp[j].equals(stateTemp[i]))){
                    System.out.println("duplicate states found");
                    hasErrors = true;
                }
            }
        }

        String[] acceptedStateTemp = new String[input[4].split(" ").length];
        for(int i = 0; i < input[4].length(); i++){
            acceptedStateTemp = input[4].split(" ");
        }
        for(int i =0; i < acceptedStateTemp.length; i++){
            for(int j =i + 1; j < acceptedStateTemp.length; j++){
                if(j != i && acceptedStateTemp[j].equals(acceptedStateTemp[i])){
                    System.out.println("duplicate accepted states found");
                    hasErrors = true;
                }
            }
        }
        
        if(input[3].length() < 1){
            System.out.println("there must be a start state.");
            hasErrors = true;
        }
    }
    
    public Boolean transitionsVsAlphabet(String[] firstArray, String[] secondArray ){      
        return Arrays.asList(secondArray).containsAll(Arrays.asList(firstArray));      
    }
}
