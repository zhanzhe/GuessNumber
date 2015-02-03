/**
 * Created by jason on 2/2/15.
 */
import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class AnswerGeneratorTest {

    @Test
    public void should_return_four_bit_number(){
        AnswerGenerator answerGenerator = new AnswerGenerator();

        int result = answerGenerator.generateNumber();
        System.out.println(result);
        int bitCount = 0;
        while (result != 0){
            result = result/10;
            bitCount++;
        }
        System.out.println(bitCount);

        assertThat(bitCount).isEqualTo(4);
    }

    @Test
    public void should_each_bit_different(){
        AnswerGenerator answerGerator = new AnswerGenerator();

        int number = answerGerator.generateNumber();
        System.out.print(number);
        int[] numberBytes = new int[4];

        while(number != 0 ){
            numberBytes[i] = number%10;
            number = number/10;
        }
        int result = 0;
        for(int i=0; i<4;i++)
            for(int j=0; j<4; j++) {
                if (numberBytes[i] == numberBytes[j])
                    result++;
            }
        assertThat(result).isEqualTo(4);
    }

    
}
