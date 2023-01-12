public class RandomArray {
    static double[][][] ranArrMatrix = new double[4][5][9];
    static double[][] ranArrAnswers = new double[4][4];
    static public void creatingRandomArrays(){

        for (int j = 0; j < 4; j++){
            for (int k = 0; k < 4; k++) {
                ranArrAnswers[j][k] = Math.random();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++){
                for (int k = 0; k < 9; k++) {
                    ranArrMatrix[i][j][k] = Math.random();
                }
            }
        }
    }
}
