import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class ColoursPattern extends JPanel {
        boolean pinkUsed;
        boolean greenUsed;
        boolean purpleUsed;

        boolean purpleAnswer;
        boolean greenAnswer;
        boolean pinkAnswer;

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
                    for (int j = 0; j < 3; j++) {

                        Painting.grayRectangleY = 0.03 * PositionsOfShapes.frameSizeY + 0.25 * PositionsOfShapes.frameSizeY * i;
                        Painting.grayRectangleX = 0.075 * PositionsOfShapes.frameSizeX + 0.325 * PositionsOfShapes.frameSizeX * j;
                        g.setColor(Color.lightGray);
                        g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.2), (int) (PositionsOfShapes.frameSizeY * 0.2));

                    if(j == 0) {
                        if (RandomArray.ranArrMatrix[i][j][0] > 0.66) {
                        g.setColor(new Color(76, 243, 84));
                        greenUsed = true;
                    } else if (RandomArray.ranArrMatrix[i][j][0] < 0.33) {
                        g.setColor(new Color(167, 99, 238));
                        purpleUsed = true;
                    } else {
                        g.setColor(new Color(239, 83, 255, 255));
                        pinkUsed = true;
                    }
                    } else if(j == 1 && pinkUsed){
                        if (RandomArray.ranArrMatrix[i][j][4] > 0.5) {
                            g.setColor(new Color(76, 243, 84));
                            greenUsed = true;
                        } else {
                            g.setColor(new Color(167, 99, 238));
                            purpleUsed = true;
                        }
                    } else if(j == 1 && greenUsed){
                        if (RandomArray.ranArrMatrix[i][j][4] > 0.5) {
                            g.setColor(new Color(239, 83, 255, 255));
                            pinkUsed = true;
                        } else {
                            g.setColor(new Color(167, 99, 238));
                            purpleUsed = true;
                        }
                    } else if(j == 1 && purpleUsed){
                        if (RandomArray.ranArrMatrix[i][j][4] > 0.5) {
                            g.setColor(new Color(76, 243, 84));
                            greenUsed = true;
                        } else {
                            g.setColor(new Color(239, 83, 255, 255));
                            pinkUsed = true;
                        }
                    } else if(j == 2 && greenUsed && purpleUsed){
                        g.setColor(new Color(239, 83, 255, 255));
                        if(i == 2){
                            pinkAnswer = true;
                        }
                    } else if(j == 2 && pinkUsed && purpleUsed){
                        g.setColor(new Color(76, 243, 84));
                        if(i == 2){
                            greenAnswer = true;
                        }
                    } else if(j == 2 && greenUsed && pinkUsed){
                        g.setColor(new Color(167, 99, 238));
                        if(i == 2){
                            purpleAnswer = true;
                        }
                    }

                    //      drawing matrix
                            if (objectCount < 8) {
                                if (RandomArray.ranArrMatrix[i][j][2] > 0.75) {
                                    if (RandomArray.ranArrMatrix[i][j][3] > 0.66) {
                                        Painting.paintOneSquare(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else if (RandomArray.ranArrMatrix[i][j][3] < 0.33) {
                                        Painting.paintOneCircle(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else {
                                        Painting.paintOnePacman(g,0,(int) normalSizeX,(int) normalSizeY);
                                    }
                                } else if (RandomArray.ranArrMatrix[i][j][2] > 0.5 && RandomArray.ranArrMatrix[i][j][2] <= 0.75) {
                                    if (RandomArray.ranArrMatrix[i][j][3] > 0.66) {
                                        Painting.paintTwoSquare(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else if (RandomArray.ranArrMatrix[i][j][3] < 0.33) {
                                        Painting.paintTwoCircle(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else {
                                        Painting.paintTwoPacman(g,0,(int) normalSizeX,(int) normalSizeY);
                                    }
                                } else if (RandomArray.ranArrMatrix[i][j][2] > 0.25 && RandomArray.ranArrMatrix[i][j][2] <= 0.5) {
                                    if (RandomArray.ranArrMatrix[i][j][3] > 0.66) {
                                        Painting.paintThreeSquare(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else if (RandomArray.ranArrMatrix[i][j][3] < 0.33) {
                                        Painting.paintThreeCircle(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else{
                                        Painting.paintThreePacman(g,0,(int) normalSizeX,(int) normalSizeY);
                                    }
                                } else if (RandomArray.ranArrMatrix[i][j][2] <= 0.25) {
                                    if (RandomArray.ranArrMatrix[i][j][3] > 0.66) {
                                        Painting.paintFourSquare(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else if (RandomArray.ranArrMatrix[i][j][3] < 0.33) {
                                        Painting.paintFourCircle(g,0,(int) normalSizeX,(int) normalSizeY);
                                    } else{
                                        Painting.paintFourPacman(g,0,(int) normalSizeX,(int) normalSizeY);
                                    }
                                }
                                objectCount++;
                            }
                    }
                purpleUsed = false;
                pinkUsed = false;
                greenUsed = false;
            }

            //drawing answers
            if (objectCount == 8) {

                Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
                Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.answerPosition;
                g.setColor(Color.lightGray);
                g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

                if(purpleAnswer){
                    g.setColor(new Color(167, 99, 238));
                }else if(greenAnswer){
                    g.setColor(new Color(76, 243, 84));
                }else{
                    g.setColor(new Color(239, 83, 255, 255));
                }

                    if (RandomArray.ranArrMatrix[3][0][2] > 0.75) {
                        if (RandomArray.ranArrMatrix[3][0][3] > 0.66) {
                            Painting.paintOneSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[3][0][3] < 0.33){
                            Painting.paintOneCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintOnePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else if (RandomArray.ranArrMatrix[3][0][2] > 0.5) {
                        if (RandomArray.ranArrMatrix[3][0][3] > 0.66) {
                            Painting.paintTwoSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[3][0][3] < 0.33) {
                            Painting.paintTwoCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else{
                            Painting.paintTwoPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else if (RandomArray.ranArrMatrix[3][0][2] > 0.25) {
                        if (RandomArray.ranArrMatrix[3][0][3] > 0.66) {
                            Painting.paintThreeSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[3][0][3] < 0.33) {
                            Painting.paintThreeCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else{
                            Painting.paintThreePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else {
                        if (RandomArray.ranArrMatrix[3][0][3] > 0.66) {
                            Painting.paintFourSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[3][0][3] < 0.33) {
                            Painting.paintFourCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else{
                            Painting.paintFourPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    }
                    objectCount++;
            }

                if (objectCount == 9) {

                    Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
                    Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.wrongAnswerPosition1;
                    g.setColor(Color.lightGray);
                    g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

                    if(pinkAnswer && RandomArray.ranArrMatrix[3][0][4]>0.5){
                        g.setColor(new Color(167, 99, 238));
                        purpleAnswer = true;
                    }else if(pinkAnswer){
                        g.setColor(new Color(76, 243, 84));
                        greenAnswer = true;
                    }
                    else if(purpleAnswer && RandomArray.ranArrMatrix[3][0][4]>0.5){
                        g.setColor(new Color(239, 83, 255, 255));
                        pinkAnswer = true;
                    }else if(purpleAnswer){
                        g.setColor(new Color(76, 243, 84));
                        greenAnswer = true;
                    } else if(greenAnswer && RandomArray.ranArrMatrix[3][0][4]>0.5){
                        g.setColor(new Color(167, 99, 238));
                        purpleAnswer = true;
                    }else if(greenAnswer){
                        g.setColor(new Color(239, 83, 255, 255));
                        pinkAnswer = true;
                    }

                    if (RandomArray.ranArrMatrix[2][3][2] > 0.75) {
                        if (RandomArray.ranArrMatrix[2][3][3] > 0.66) {
                            Painting.paintOneSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else  if (RandomArray.ranArrMatrix[2][3][3] < 0.33) {
                            Painting.paintOneCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else{
                            Painting.paintOnePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else if (RandomArray.ranArrMatrix[2][3][2] > 0.5) {
                        if (RandomArray.ranArrMatrix[2][3][3] > 0.66) {
                            Painting.paintTwoSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[2][3][3] < 0.33) {
                            Painting.paintTwoCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintTwoPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else if (RandomArray.ranArrMatrix[2][3][2] > 0.25) {
                        if (RandomArray.ranArrMatrix[2][3][3] > 0.66) {
                            Painting.paintThreeSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[2][3][3] < 0.33) {
                            Painting.paintThreeCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintThreePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else {
                        if (RandomArray.ranArrMatrix[2][3][3] > 0.66) {
                            Painting.paintFourSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[2][3][3] < 0.33) {
                            Painting.paintFourCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintFourPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    }
                    objectCount++;
                }
                if (objectCount == 10) {

                    Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
                    Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.wrongAnswerPosition2;
                    g.setColor(Color.lightGray);
                    g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

                    if(pinkAnswer && greenAnswer){
                        g.setColor(new Color(167, 99, 238));
                    }else if(pinkAnswer && purpleAnswer){
                        g.setColor(new Color(76, 243, 84));
                    }else if (purpleAnswer && greenAnswer){
                        g.setColor(new Color(239, 83, 255, 255));
                    }

                    if (RandomArray.ranArrMatrix[2][4][2] > 0.75) {
                        if (RandomArray.ranArrMatrix[2][4][3] > 0.66) {
                            Painting.paintOneSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else  if (RandomArray.ranArrMatrix[2][4][3] < 0.33) {
                            Painting.paintOneCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else{
                            Painting.paintOnePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else if (RandomArray.ranArrMatrix[2][4][2] > 0.5) {
                        if (RandomArray.ranArrMatrix[2][4][3] > 0.66) {
                            Painting.paintTwoSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[2][4][3] < 0.33) {
                            Painting.paintTwoCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintTwoPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else if (RandomArray.ranArrMatrix[2][4][2] > 0.25) {
                        if (RandomArray.ranArrMatrix[2][4][3] > 0.66) {
                            Painting.paintThreeSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[2][4][3] < 0.33) {
                            Painting.paintThreeCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintThreePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    } else {
                        if (RandomArray.ranArrMatrix[2][4][3] > 0.66) {
                            Painting.paintFourSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else if (RandomArray.ranArrMatrix[2][4][3] < 0.33) {
                            Painting.paintFourCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                        } else {
                            Painting.paintFourPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                        }
                    }
                }
                pinkAnswer = false;
                purpleAnswer = false;
                greenAnswer = false;
        }
    }




