public class PositionsOfButtons {
    //    it is used for every pattern to randomize position of correct and wrong answer buttons
    static int answerPosition;
    static int wrongAnswerPosition1;
    static int wrongAnswerPosition2;
    static public void settingButtonPosition(){
        double randomAnswerPosition = Math.random();
        if(randomAnswerPosition>0.66){
            answerPosition = 0;
            wrongAnswerPosition1 = 1;
            wrongAnswerPosition2 = 2;
        } else if(randomAnswerPosition<0.33) {
            answerPosition = 1;
            wrongAnswerPosition1 = 0;
            wrongAnswerPosition2 = 2;
        } else {
            answerPosition = 2;
            wrongAnswerPosition1 = 0;
            wrongAnswerPosition2 = 1;
        }
    }
}
