package random;

public class RandomNumber {
    public static int createRandomNumber(){
        int random = (int) ((Math.random())*90 + 10);
        return random;
    }
}
