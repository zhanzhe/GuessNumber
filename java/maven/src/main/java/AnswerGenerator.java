import java.util.Random;

/**
 * Created by jason on 2/2/15.
 */
public class AnswerGenerator {
    Random random;
    public AnswerGenerator(Random random) {
        this.random = random;
    }

    public int generateNumber(){
        Random random = new Random();
        int number = random.nextInt(10);
        number = ((number == 0)? 1:number);

        int[] numberArray = {0,0,0,0};
        numberArray[0] = number;
        int i = 1;
        while(i < 4){
            number = random.nextInt(10);
            int j = 0;
            for(; j<4; j++){
                if(numberArray[j] == number)
                   break;
            }
            if(j == 4){
                numberArray[i++] = number;
            }
        }
        return getNumberFromBitArray(numberArray);
    }

    private String generateNumberOnce(){
        StringBuffer sb  = new StringBuffer();

    }
    private int getNumberFromBitArray(int[] bitArray){
        int number = bitArray[0];
        for(int i=1; i<4; i++){
            number *= 10;
            number += bitArray[i];
        }

        return number;
    }
}
