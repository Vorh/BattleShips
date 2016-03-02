package model;


public class AiEpid {

    public int randomNumber(int i, int j){
        int randomNumber = i+ (int) (Math.random() * (j-i));
        return randomNumber;
    }

}
