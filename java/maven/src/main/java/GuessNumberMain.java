import java.util.Random;

/**
 * Created by jason on 2/5/15.
 */
public class GuessNumberMain {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
        Printer printer = new Printer();
        String answerStr = answerGenerator.generateNumber();

        System.out.print(printer.getWelcomeStr(userInput.getGuessCount()));

        while(userInput.getGuessCount() > 0){
            userInput.getInputStrFromConsole();
            System.out.print(printer.getDisplayStrAccordingToInput(userInput, answerStr));
        }
    }
}
