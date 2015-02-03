import java.util.Random;

/**
 * Created by jason on 2/2/15.
 */
public class AnswerGenerator {

    public int generateNumber(){
        Random random = new Random();

        int number = random.nextInt(10000);

        return number;
    }
}
