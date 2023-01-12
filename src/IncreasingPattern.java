import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class IncreasingPattern extends JPanel {

    boolean fourObjInAnswer;
    boolean threeObjInAnswer;

    double normalSizeX = 0.05 * PositionsOfShapes.frameSizeX;
    double normalSizeY = 0.05 * PositionsOfShapes.frameSizeY;
    double answerSizeX = 0.025 * PositionsOfShapes.frameSizeX;
    double answerSizeY = 0.025 * PositionsOfShapes.frameSizeY;


    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(162,225,165));
        g.fillRect(0,0, PositionsOfShapes.frameSizeX, PositionsOfShapes.frameSizeY);

        int objectCount = 0;

        //drawing 8 shapes in matrix
        for (int i = 0; i < 3; i++) {

//choosing starting from one shape or two shapes
            if ( RandomArray.ranArrMatrix[i][1][0] > 0.5) {
                for (int j = 0; j < 3; j++) {

                    Painting.grayRectangleY = 0.03 * PositionsOfShapes.frameSizeY + 0.25 * PositionsOfShapes.frameSizeY * i;
                    Painting.grayRectangleX = 0.075 * PositionsOfShapes.frameSizeX + 0.325 * PositionsOfShapes.frameSizeX * j;
                    g.setColor(Color.lightGray);
                    g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.2), (int) (PositionsOfShapes.frameSizeY * 0.2));

                    if(RandomArray.ranArrMatrix[i][j][1]>0.66){
                        g.setColor(new Color(76, 243, 84));
                    } else if(RandomArray.ranArrMatrix[i][j][1]<0.33) {
                        g.setColor(new Color(167, 99, 238));
                    } else{
                        g.setColor(new Color(239, 83, 255, 255));
                    }

                    if(j == 0){
                        if (RandomArray.ranArrMatrix[i][j][2] > 0.66 ) {
                            Painting.paintOneSquare(g,0, (int) normalSizeX, (int) normalSizeY);
                        } else if(RandomArray.ranArrMatrix[i][j][2] < 0.33 ) {
                            Painting.paintOneCircle(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else {
                            Painting.paintOnePacman(g,0, (int) normalSizeX, (int) normalSizeY);
                        }
                        objectCount++;
                    } else if (j == 1){
                        if (RandomArray.ranArrMatrix[i][j][3] > 0.66) {
                            Painting.paintTwoSquare(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else if(RandomArray.ranArrMatrix[i][j][3] < 0.33){
                            Painting.paintTwoCircle(g,0, (int) normalSizeX, (int) normalSizeY);
                        } else {
                            Painting.paintTwoPacman(g,0, (int) normalSizeX, (int) normalSizeY);
                        }
                        if(i == 2){
                            threeObjInAnswer = true;
                        }
                        objectCount++;
                    } else if(objectCount < 8) {
                        if (RandomArray.ranArrMatrix[i][j][4] > 0.66) {
                            Painting.paintThreeSquare(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else if(RandomArray.ranArrMatrix[i][j][4] < 0.33) {
                            Painting.paintThreeCircle(g,0, (int) normalSizeX, (int) normalSizeY);
                        } else {
                            Painting.paintThreePacman(g,0, (int) normalSizeX, (int) normalSizeY);
                        }
                        objectCount++;
                    }
                }
            } else {
                for (int j = 0; j < 3; j++) {

                    Painting.grayRectangleY = 0.03 * PositionsOfShapes.frameSizeY + 0.25 * PositionsOfShapes.frameSizeY * i;
                    Painting.grayRectangleX = 0.075 * PositionsOfShapes.frameSizeX + 0.325 * PositionsOfShapes.frameSizeX * j;
                    g.setColor(Color.lightGray);
                    g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.2), (int) (PositionsOfShapes.frameSizeY * 0.2));

                    if(RandomArray.ranArrMatrix[i][j][5]>0.66){
                        g.setColor(new Color(76, 243, 84));
                    } else if(RandomArray.ranArrMatrix[i][j][5]<0.33) {
                        g.setColor(new Color(167, 99, 238));
                    } else{
                        g.setColor(new Color(239, 83, 255, 255));
                    }
                    if(j == 0){
                        if (RandomArray.ranArrMatrix[i][j][6] > 0.66) {
                            Painting.paintTwoSquare(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else if ( RandomArray.ranArrMatrix[i][j][6] < 0.33) {
                            Painting.paintTwoCircle(g,0, (int) normalSizeX, (int) normalSizeY);
                        } else {
                            Painting.paintTwoPacman(g,0, (int) normalSizeX, (int) normalSizeY);
                        }
                        objectCount++;
                    } else if (j == 1){
                        if (RandomArray.ranArrMatrix[i][j][7] > 0.66) {
                            Painting.paintThreeSquare(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else if (RandomArray.ranArrMatrix[i][j][7] < 0.33){
                            Painting.paintThreeCircle(g,0, (int) normalSizeX, (int) normalSizeY);
                        } else {
                            Painting.paintThreePacman(g,0, (int) normalSizeX, (int) normalSizeY);
                        }
                        if(i == 2){
                            fourObjInAnswer = true;
                        }
                        objectCount++;
                    } else if(objectCount < 8){
                        if (RandomArray.ranArrMatrix[i][j][8] > 0.66) {
                            Painting.paintFourSquare(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else if(RandomArray.ranArrMatrix[i][j][8] < 0.33){
                            Painting.paintFourCircle(g,0, (int) normalSizeX, (int) normalSizeY);
                        }else {
                            Painting.paintFourPacman(g,0, (int) normalSizeX, (int) normalSizeY);
                        }
                        objectCount++;
                    }
                }
            }
        }
//drawing answers

            Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
            Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.answerPosition;
            g.setColor(Color.lightGray);
            g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

            if (RandomArray.ranArrAnswers[0][0] > 0.66) {
                g.setColor(new Color(76, 243, 84));
            } else if (RandomArray.ranArrAnswers[0][0] < 0.33) {
                g.setColor(new Color(167, 99, 238));
            } else {
                g.setColor(new Color(239, 83, 255, 255));
            }
            if(threeObjInAnswer){
                if (RandomArray.ranArrAnswers[0][1] > 0.66) {
                    Painting.paintThreeSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[0][1] < 0.33) {
                    Painting.paintThreeCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintThreePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            }else {
                if (RandomArray.ranArrAnswers[0][1] > 0.66) {
                    Painting.paintFourSquare(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[0][1] < 0.33) {
                    Painting.paintFourCircle(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourPacman(g, 1, (int) answerSizeX, (int) answerSizeY);
                }
            }


            Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
            Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.wrongAnswerPosition1;
            g.setColor(Color.lightGray);
            g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

            if (RandomArray.ranArrAnswers[1][0] > 0.66) {
                g.setColor(new Color(76, 243, 84));
            } else if (RandomArray.ranArrAnswers[1][0] < 0.33) {
                g.setColor(new Color(167, 99, 238));
            } else {
                g.setColor(new Color(239, 83, 255, 255));
            }

            if (RandomArray.ranArrAnswers[1][1] > 0.66) {
                if (RandomArray.ranArrAnswers[1][2] > 0.66) {
                    Painting.paintOneSquare(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[1][2] < 0.33) {
                    Painting.paintOneCircle(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintOnePacman(g, 1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (RandomArray.ranArrAnswers[1][1] < 0.33) {
                if (RandomArray.ranArrAnswers[1][2] > 0.66) {
                    Painting.paintTwoSquare(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[1][2] < 0.33) {
                    Painting.paintTwoCircle(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintTwoPacman(g, 1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (fourObjInAnswer) {
                if (RandomArray.ranArrAnswers[1][2] > 0.66) {
                    Painting.paintThreeSquare(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[1][2] < 0.33) {
                    Painting.paintThreeCircle(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintThreePacman(g, 1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (threeObjInAnswer) {
                if (RandomArray.ranArrAnswers[1][2] > 0.66) {
                    Painting.paintFourSquare(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[1][2] < 0.33) {
                    Painting.paintFourCircle(g, 1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourPacman(g, 1, (int) answerSizeX, (int) answerSizeY);
                }
            }

            Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
            Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.wrongAnswerPosition2;
            g.setColor(Color.lightGray);
            g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

            if (RandomArray.ranArrAnswers[2][0] > 0.66) {
                g.setColor(new Color(76, 243, 84));
            } else if (RandomArray.ranArrAnswers[2][0] < 0.33) {
                g.setColor(new Color(167, 99, 238));
            } else {
                g.setColor(new Color(239, 83, 255, 255));
            }

            if (RandomArray.ranArrAnswers[2][1] > 0.66) {
                if (RandomArray.ranArrAnswers[2][2] > 0.66) {
                    Painting.paintOneSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[2][2] < 0.33) {
                    Painting.paintOneCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else {
                    Painting.paintOnePacman(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            } else if (RandomArray.ranArrAnswers[2][1] < 0.33) {
                if (RandomArray.ranArrAnswers[2][2] > 0.66) {
                    Painting.paintTwoSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[2][2] < 0.33) {
                    Painting.paintTwoCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else {
                    Painting.paintTwoPacman(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            } else if (fourObjInAnswer) {
                if (RandomArray.ranArrAnswers[2][2] > 0.66) {
                    Painting.paintThreeSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[2][2] < 0.33) {
                    Painting.paintThreeCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else{
                    Painting.paintThreePacman(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            } else if (threeObjInAnswer) {
                if (RandomArray.ranArrAnswers[2][2] > 0.66) {
                    Painting.paintFourSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrAnswers[2][2] < 0.33) {
                    Painting.paintFourCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else{
                    Painting.paintFourPacman(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            }
            fourObjInAnswer = false;
            threeObjInAnswer = false;
    }
}


