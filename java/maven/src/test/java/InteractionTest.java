import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by jason on 2/5/15.
 */
public class InteractionTest {

    @Test
    public void should_return_1A1B(){
        Printer printer = new Printer();
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        given(answerGenerator.generateNumber()).willReturn("1234");
        String inputStr = new UserInput().getInputStr();
        String anwserStr = answerGenerator.generateNumber();

        String result = new GuessNumber().GetTips(inputStr,anwserStr);

        assertThat(result).isEqualTo("4A0B");

        String str = printer.getSuccessfullStr();
        assertThat(str).isEqualTo("Congratulations!");
    }


}
