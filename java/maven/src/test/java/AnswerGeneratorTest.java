/**
 * Created by jason on 2/2/15.
 */
import org.junit.Test;
import java.util.HashSet;
import java.util.Random;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AnswerGeneratorTest {

    @Test
    public void should_return_four_bit_number(){
        String result = new AnswerGenerator(new Random()).generateNumber();

        assertThat(result.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_number(){
        String result  = new AnswerGenerator(new Random()).generateNumber();

        try {
            Integer.parseInt(result);
        }catch(NumberFormatException exc){
            fail("result should be number");
        }
    }

    @Test
    public void should_generate_no_duplicate_number(){
        String result = new AnswerGenerator(new Random()).generateNumber();

        for(int i = 0; i < result.length(); i++){
            assertThat(result.indexOf(result.charAt(i))).isEqualTo(result.lastIndexOf((result.charAt(i))));
        }
    }


    @Test
    public void should_not_repeat_in_three_times(){

        Random random = mock(Random.class);
        HashSet<String> numberSet = new HashSet<String>();
        AnswerGenerator answerGenerator = new AnswerGenerator(random);

        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,5)
                .willReturn(3,4,5,6);

        numberSet.add(answerGenerator.generateNumber());
        numberSet.add(answerGenerator.generateNumber());
        numberSet.add(answerGenerator.generateNumber());


        assertThat(numberSet.size()).isEqualTo(3);

    }

    @Test
    public void should_result_repeatable_after_3_times(){
        Random random = mock(Random.class);
        HashSet<String> numberSet = new HashSet<String>();
        AnswerGenerator answerGenerator = new AnswerGenerator(random);

        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,2,5,6)
                .willReturn(2,3,4,5)
                .willReturn(1,2,3,4);

        numberSet.add(answerGenerator.generateNumber());
        numberSet.add(answerGenerator.generateNumber());
        numberSet.add(answerGenerator.generateNumber());
        numberSet.add(answerGenerator.generateNumber());

        assertThat(numberSet.size()).isEqualTo(3);
    }

}
