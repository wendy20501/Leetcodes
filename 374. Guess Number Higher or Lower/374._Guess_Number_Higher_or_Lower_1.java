/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return myGuess(1, n);
    }
    
    private int myGuess(int start, int end) {
        //System.out.println("start = " + start + " end = " + end);
        int myAns = start + (end - start) / 2;
        switch(guess(myAns)) {
            case 0:
                return myAns;
            case 1:
                return myGuess(myAns + 1, end);
            case -1:
                return myGuess(start, myAns - 1);
            default:
                return myAns;
        }
    }
}