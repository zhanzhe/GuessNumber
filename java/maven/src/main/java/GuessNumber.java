/**
 * Created by jason on 2/2/15.
 */
public class GuessNumber {


    public String GetTips(String inputStr, String anwserStr) {
        int equalCount = 0;
        int containCount  = 0;

        for(int i=0; i<inputStr.length(); i++){
            if(inputStr.charAt(i) == anwserStr.charAt(i)){
                equalCount++;
            }else if(inputStr.contains(String.valueOf(anwserStr.charAt(i)))){
                containCount++;
            }
        }

        return equalCount+"A"+containCount+"B";

    }
}
