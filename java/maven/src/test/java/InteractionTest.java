import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by jason on 2/5/15.
 */
public class InteractionTest {

    @Test
    public void should_print_welcome_when_game_begins(){
        UserInput userInput = new UserInput();
        String result = Printer.getWelcomeStr(userInput.getGuessCount());

        assertThat(result).isEqualTo("Welcome!\r\n\r\nPlease input your number(6): ");
    }

    @Test
    public void should_print_game_over(){
        UserInput userInput = new UserInput();
        Printer printer = new Printer(new AnswerGenerator(new Random()));

        userInput.deduceGuessCount();
        userInput.deduceGuessCount();
        userInput.deduceGuessCount();
        userInput.deduceGuessCount();
        userInput.deduceGuessCount();
        userInput.deduceGuessCount();

        String result= printer.getDisplayStrAccordingToInput(userInput);

        assertThat(result).isEqualTo("Game Over");

    }

    @Test
    public void should_return_success(){
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");
        Printer printer = new Printer(answerGenerator);

        UserInput userInput = mock(UserInput.class);
        given(userInput.getInputStr()).willReturn("1234");

        String str = printer.getDisplayStrAccordingToInput(userInput);

        assertThat(str).isEqualTo("Congratulations!");
    }


    @Test
    public void should_return_number_is_duplicate_tips(){
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");
        Printer printer = new Printer(answerGenerator);
        UserInput userInput = mock(UserInput.class);
        given(userInput.getInputStr()).willReturn("1134");

        String str = printer.getDisplayStrAccordingToInput(userInput);
        assertThat(str).isEqualTo("Cannot input duplicate numbers!");
    }


}
