import org.omg.CORBA.AnySeqHelper;

/**
 * Created by jason on 2/5/15.
 */
public class Printer {

    private AnswerGenerator answerGenerator;

    public Printer(AnswerGenerator answerGenerator){
        this.answerGenerator = answerGenerator;
    }

    private String getSucessfullStr() {
        return "Congratulations!";
    }


    public static String getWelcomeStr(int guessCount) {
        return "Welcome!\r\n\r\nPlease input your number(" + guessCount +"): ";
    }

    private String getDuplicateTipsStr() {
        return "Cannot input duplicate numbers!" ;
    }


    private boolean checkIsDuplicatedInput(String inputStr){
        for(int i = 0; i < inputStr.length(); i++){
            if(inputStr.indexOf(inputStr.charAt(i)) != inputStr.lastIndexOf(inputStr.charAt(i))){
                return true;
            }
        }

        return false;
    }

    private String getGameOverTipsStr(){
        return "Game Over";
    }

    private String getTryAgainTips(UserInput userInput, String answerTips){

        return answerTips + "\r\n\r\n" + "Please input your number("+ userInput.getGuessCount()+")" ;
    }

    public String getDisplayStrAccordingToInput(UserInput userInput) {
        String inputStr = userInput.getInputStr();

        if(userInput.getGuessCount() == 0){
            return getGameOverTipsStr();
        }
        if(checkIsDuplicatedInput(inputStr)){
            return getDuplicateTipsStr();
        }

        String answerStr = answerGenerator.generateNumber();
        String tips = new GuessNumber().GetTips(inputStr, answerStr);

        if(tips.equals("4A0B")){
            return getSucessfullStr();
        }else{
            userInput.deduceGuessCount();;
            return getTryAgainTips(userInput, tips);
        }
    }
}