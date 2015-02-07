import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by jason on 2/5/15.
 */
public class UserInput {

    private int guessCount;
    private static BufferedReader br;
    private String inputStr;

    public UserInput(){
        br=new BufferedReader(new InputStreamReader(System.in));
        this.guessCount = 6;
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


    public int getGuessCount() {
        return guessCount;
    }

    public void deduceGuessCount(){
        guessCount--;
    }
}
