import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by jason on 2/5/15.
 */
public class UserInput {

    private static int guessCount = 6;
    private static BufferedReader br;
    private String inputStr;

    public UserInput(){
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInputStrFromConsole() {
        try{
            inputStr = br.readLine();
        }catch(IOException e){
            fail("IO exception occurs");
        }
        return inputStr;
    }

    public String getInputStr(){
        return this.inputStr;
    }

    private boolean check_is_number_duplicated(String inputStr){
        for(int i = 0; i < inputStr.length(); i++){
           if(inputStr.indexOf(inputStr.charAt(i)) != inputStr.lastIndexOf(inputStr.charAt(i))){
                return true;
            }
        }

        return false;
    }


    public int getGuessCount() {
        return guessCount;
    }

    public void deduceGuessCount(){
        guessCount--;
    }
}
