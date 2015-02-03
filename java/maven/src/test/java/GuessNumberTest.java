import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by jason on 2/2/15.
 */
public class GuessNumberTest {
    @Test
    public void should_return_4A0B_when_input_like_1234_anwser_like_1234() {
        GuessNumber guessNumber = new GuessNumber();
        String inputStr = "1234";
        String anwserStr = "1234";
        String result = guessNumber.GetTips(inputStr, anwserStr);

        assertThat(result).isEqualTo("4A0B");
    }


    @Test
    public void should_return_0A4B_when_input_like_1234_answer_like_4321(){
        GuessNumber guessNumber = new GuessNumber();
        String inputStr = "1234";
        String anwserStr = "4321";
        String result = guessNumber.GetTips(inputStr, anwserStr);

        assertThat(result).isEqualTo("0A4B");
    }

    @Test
    public void should_return_0A0B_when_input_like_1234_anwser_like_5678(){
        GuessNumber guessNumber = new GuessNumber();
        String inputStr = "1234";
        String anwserStr = "5678";
        String result = guessNumber.GetTips(inputStr, anwserStr);

        assertThat(result).isEqualTo("0A0B");
    }

    @Test
    public void should_return_2A2B_when_input_like_1234_anwser_like_1256(){
        GuessNumber guessNumber = new GuessNumber();
        String inputStr = "1234";
        String anwserStr = "1243";
        String result = guessNumber.GetTips(inputStr, anwserStr);

        assertThat(result).isEqualTo("2A2B");
    }
}
