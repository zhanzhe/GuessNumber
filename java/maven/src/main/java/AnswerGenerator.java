import java.util.*;

/**
 * Created by jason on 2/2/15.
 */
public class AnswerGenerator {
    private final List<String> historyGeneratedStrings;
    private Random random;

    public AnswerGenerator(Random random) {
        this.random = random;
        this.historyGeneratedStrings = new ArrayList<String>();
    }

    public String generateNumber(){
        String result = generateNumberOnce();

        while(historyGeneratedStrings.contains(result)){
            result = generateNumberOnce();
        }

        if(historyGeneratedStrings.size() == 2){
            historyGeneratedStrings.remove(0);
        }

        historyGeneratedStrings.add(result);

        return result;

    }

    private String generateNumberOnce(){
        StringBuilder result = new StringBuilder();
        while(result.length() < 4){
            String digit = String.valueOf(random.nextInt(10));
            if(result.indexOf(digit) == -1){
                result.append(digit);
            }
        }

        return result.toString();
    }

}
