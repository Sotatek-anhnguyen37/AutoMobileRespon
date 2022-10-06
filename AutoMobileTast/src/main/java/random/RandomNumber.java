package random;

public class RandomNumber {
    public static int randomNumber(){
        int x = (int) ((Math.random())*9 + 1);
        return x;
    }
}
