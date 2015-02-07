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
        Printer printer = new Printer();
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");

        UserInput userInput = mock(UserInput.class);
        given(userInput.getInputStr())
                .willReturn("2367")
                .willReturn("2345")
                .willReturn("3467")
                .willReturn("3456")
                .willReturn("6789")
                .willReturn("6534");

        String answerStr = answerGenerator.generateNumber();
        printer.getDisplayStrAccordingToInput(userInput,answerStr);
        printer.getDisplayStrAccordingToInput(userInput,answerStr);
        printer.getDisplayStrAccordingToInput(userInput,answerStr);
        printer.getDisplayStrAccordingToInput(userInput,answerStr);
        printer.getDisplayStrAccordingToInput(userInput,answerStr);

        String result= printer.getDisplayStrAccordingToInput(userInput, answerStr);
        assertThat(result).isEqualTo("Game Over");

    }

    @Test
    public void should_return_success(){
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");
        Printer printer = new Printer();

        UserInput userInput = mock(UserInput.class);
        given(userInput.getInputStr()).willReturn("1234");

        String str = printer.getDisplayStrAccordingToInput(userInput,answerGenerator.generateNumber());

        assertThat(str).isEqualTo("Congratulations!");
    }

    @Test
    public void should_return_number_is_duplicate_tips(){
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");
        Printer printer = new Printer();
        UserInput userInput = mock(UserInput.class);
        given(userInput.getInputStr()).willReturn("1134");

        String str = printer.getDisplayStrAccordingToInput(userInput,answerGenerator.generateNumber());
        assertThat(str).isEqualTo("Cannot input duplicate numbers!");
    }

    @Test
    public void should_return_try_Again_tips(){
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");
        Printer printer = new Printer();

        UserInput userInput = mock(UserInput.class);
        given(userInput.getInputStr())
                .willReturn("2345");
        given(userInput.getGuessCount()).willReturn(5);

        String result = printer.getDisplayStrAccordingToInput(userInput,answerGenerator.generateNumber());
        assertThat(result).isEqualTo("0A3B\r\n\r\n" + "Please input your number(5):");
    }


}
