package socket;

import model.Fruit;
import model.Snapjaw;

import java.util.ArrayList;

public class Data {
    private String action,response = "";
    private String[] guess = {"",""};
//    private String matriz[][]=new String[50][50];
    private ArrayList<Snapjaw> snapjaws = new ArrayList<Snapjaw>();
    private ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String[] getGuess() {
        return guess;
    }

    public void setGuess(String[] guess) {
        this.guess = guess;
    }

    public ArrayList<Snapjaw> getSnapjaws() {
        return snapjaws;
    }

    public void setSnapjaws(ArrayList<Snapjaw> snapjaws) {
        this.snapjaws = snapjaws;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }
}
