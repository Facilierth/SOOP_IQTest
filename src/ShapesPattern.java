import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class ShapesPattern extends JPanel {
    boolean square;
    boolean circle;
    boolean pacman;
    boolean squareUsed;
    boolean circleUsed;
    boolean pacmanUsed;

    boolean pacmanAnswer;
    boolean circleAnswer;
    boolean squareAnswer;

    boolean pacmanWrong1;
    boolean circleWrong1;
    boolean squareWrong1;
    boolean pacmanWrong2;
    boolean circleWrong2;
    boolean squareWrong2;


    double normalSizeX = 0.05 * PositionsOfShapes.frameSizeX;
    double normalSizeY = 0.05 * PositionsOfShapes.frameSizeY;

    double answerSizeX = 0.025 * PositionsOfShapes.frameSizeX;
    double answerSizeY = 0.025 * PositionsOfShapes.frameSizeY;


    public void paint(Graphics g) {
        super.paint(g);

        int objectCount = 0;

        g.setColor(new Color(162,225,165));
        g.fillRect(0,0, PositionsOfShapes.frameSizeX, PositionsOfShapes.frameSizeY);

//drawing 8 shapes in matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Painting.grayRectangleY = 0.03 * PositionsOfShapes.frameSizeY + 0.25 * PositionsOfShapes.frameSizeY * i;
                Painting.grayRectangleX = 0.075 * PositionsOfShapes.frameSizeX + 0.325 * PositionsOfShapes.frameSizeX * j;
                g.setColor(Color.lightGray);
                g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.2), (int) (PositionsOfShapes.frameSizeY * 0.2));

                if(j == 0) {
                    if (RandomArray.ranArrMatrix[i][j][0] > 0.66) {
                        circleUsed = true;
                        circle = true;
                    } else if (RandomArray.ranArrMatrix[i][j][0] < 0.33) {
                        pacmanUsed = true;
                        pacman = true;
                    } else {
                        squareUsed = true;
                        square = true;
                    }
                } else if(j == 1 && squareUsed){
                    if (RandomArray.ranArrMatrix[i][j][1] > 0.5) {
                        circleUsed = true;
                        circle = true;
                    } else {
                        pacmanUsed = true;
                        pacman = true;
                    }
                } else if(j == 1 && circleUsed){
                    if (RandomArray.ranArrMatrix[i][j][1] > 0.5) {
                        squareUsed = true;
                        square = true;
                    } else {
                        pacmanUsed = true;
                        pacman= true;
                    }
                } else if(j == 1 && pacmanUsed){
                    if (RandomArray.ranArrMatrix[i][j][1] > 0.5) {
                        circleUsed = true;
                        circle = true;
                    } else {
                        squareUsed = true;
                        square = true;
                    }
                } else if(j == 2 && circleUsed && pacmanUsed){
                    square = true;
                    if(i == 2){
                        squareAnswer = true;
                    }
                } else if(j == 2 && squareUsed && pacmanUsed){
                    circle = true;
                    if(i == 2){
                        circleAnswer = true;
                    }
                } else if(j == 2 && circleUsed && squareUsed){
                    pacman = true;
                    if(i == 2){
                        pacmanAnswer = true;
                    }
                }

                if(RandomArray.ranArrMatrix[i][j][2] > 0.66){
                    g.setColor(new Color(76, 243, 84));
                } else if (RandomArray.ranArrMatrix[i][j][2] < 0.33){
                    g.setColor(new Color(167, 99, 238));
                } else {
                    g.setColor(new Color(239, 83, 255, 255));
                }

//      drawing matrix
                if (objectCount < 8) {
                    if (pacman) {
                        if (RandomArray.ranArrMatrix[i][j][3] > 0.75) {
                            Painting.paintOnePacman(g, 0, (int) normalSizeX,(int) normalSizeY);
                        } else if (RandomArray.ranArrMatrix[i][j][3] > 0.5) {
                            Painting.paintTwoPacman(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else if (RandomArray.ranArrMatrix[i][j][3] > 0.25){
                            Painting.paintThreePacman(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else {
                            Painting.paintFourPacman(g, 0,(int) normalSizeX,(int) normalSizeY);
                        }
                    } else if (square) {
                        if (RandomArray.ranArrMatrix[i][j][3] > 0.75) {
                            Painting.paintOneSquare(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else if (RandomArray.ranArrMatrix[i][j][3] > 0.5) {
                            Painting.paintTwoSquare(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else if (RandomArray.ranArrMatrix[i][j][3] > 0.25) {
                            Painting.paintThreeSquare(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else {
                            Painting.paintFourSquare(g, 0,(int) normalSizeX,(int) normalSizeY);
                        }
                    } else if (circle) {
                        if (RandomArray.ranArrMatrix[i][j][3] > 0.75) {
                            Painting.paintOneCircle(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else if (RandomArray.ranArrMatrix[i][j][3] > 0.5) {
                            Painting.paintTwoCircle(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else if (RandomArray.ranArrMatrix[i][j][3] > 0.25){
                            Painting.paintThreeCircle(g, 0,(int) normalSizeX,(int) normalSizeY);
                        } else {
                            Painting.paintFourCircle(g, 0,(int) normalSizeX,(int) normalSizeY);
                        }
                    }
                    objectCount++;
                }
                pacman = false;
                circle = false;
                square = false;
            }
            pacmanUsed = false;
            squareUsed = false;
            circleUsed = false;
        }

        //drawing answers
        if (objectCount == 8) {

            Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
            Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.answerPosition;
            g.setColor(Color.lightGray);
            g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

            if(RandomArray.ranArrMatrix[3][0][4] > 0.66){
                g.setColor(new Color(76, 243, 84));
            } else if (RandomArray.ranArrMatrix[3][0][4] < 0.33){
                g.setColor(new Color(167, 99, 238));
            } else {
                g.setColor(new Color(239, 83, 255, 255));
            }

            if (pacmanAnswer) {
                if (RandomArray.ranArrMatrix[3][0][0] > 0.75) {
                    Painting.paintOnePacman(g, 1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][0] > 0.5) {
                    Painting.paintTwoPacman(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][0] > 0.25){
                    Painting.paintThreePacman(g,1,(int) answerSizeX,(int) answerSizeY);
                } else {
                    Painting.paintFourPacman(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            } else if (squareAnswer) {
                if (RandomArray.ranArrMatrix[3][0][0] > 0.75) {
                    Painting.paintOneSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][0] > 0.5) {
                    Painting.paintTwoSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][0] > 0.25) {
                    Painting.paintThreeSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                } else {
                    Painting.paintFourSquare(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            } else if (circleAnswer) {
                if (RandomArray.ranArrMatrix[3][0][0] > 0.75) {
                    Painting.paintOneCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][0] > 0.5) {
                    Painting.paintTwoCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][0] > 0.25){
                    Painting.paintThreeCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                } else {
                    Painting.paintFourCircle(g,1,(int) answerSizeX,(int) answerSizeY);
                }
            }
            objectCount++;
        }

        if (objectCount == 9) {

            Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
            Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.wrongAnswerPosition1;
            g.setColor(Color.lightGray);
            g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

            if(RandomArray.ranArrMatrix[3][0][5] > 0.66){
                g.setColor(new Color(76, 243, 84));
            } else if (RandomArray.ranArrMatrix[3][0][5] < 0.33){
                g.setColor(new Color(167, 99, 238));
            } else {
                g.setColor(new Color(239, 83, 255, 255));
            }

            if(squareAnswer && RandomArray.ranArrMatrix[3][0][1]>0.5){
                pacmanAnswer = true;
                pacmanWrong1 = true;
            }else if(squareAnswer){
                circleAnswer = true;
                circleWrong1 = true;
            }
            else if(pacmanAnswer && RandomArray.ranArrMatrix[3][0][1]>0.5){
                squareAnswer = true;
                squareWrong1 = true;
            }else if(pacmanAnswer){
                circleAnswer = true;
                circleWrong1 = true;
            } else if(circleAnswer && RandomArray.ranArrMatrix[3][0][1]>0.5){
                pacmanAnswer = true;
                pacmanWrong1 = true;
            }else if(circleAnswer){
                squareAnswer = true;
                squareWrong1 = true;
            }

            if (pacmanWrong1) {
                if (RandomArray.ranArrMatrix[3][0][2] > 0.75) {
                    Painting.paintOnePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][2] > 0.5) {
                    Painting.paintTwoPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][2] > 0.25){
                    Painting.paintThreePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (squareWrong1) {
                if (RandomArray.ranArrMatrix[3][0][2] > 0.75) {
                    Painting.paintOneSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][2] > 0.5) {
                    Painting.paintTwoSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][2] > 0.25) {
                    Painting.paintThreeSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (circleWrong1) {
                if (RandomArray.ranArrMatrix[3][0][2] > 0.75) {
                    Painting.paintOneCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][2] > 0.5) {
                    Painting.paintTwoCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][2] > 0.25){
                    Painting.paintThreeCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            }
            objectCount++;
        }
        if (objectCount == 10) {

            Painting.grayRectangleY = 0.77 * PositionsOfShapes.frameSizeY;
            Painting.grayRectangleX = 0.27 * PositionsOfShapes.frameSizeX + 0.165 * PositionsOfShapes.frameSizeX * PositionsOfButtons.wrongAnswerPosition2;
            g.setColor(Color.lightGray);
            g.fillRect((int) Painting.grayRectangleX, (int) Painting.grayRectangleY, (int) (PositionsOfShapes.frameSizeX * 0.13), (int) (PositionsOfShapes.frameSizeY * 0.13));

            if(RandomArray.ranArrMatrix[3][0][6] > 0.66){
                g.setColor(new Color(76, 243, 84));
            } else if (RandomArray.ranArrMatrix[3][0][6] < 0.33){
                g.setColor(new Color(167, 99, 238));
            } else {
                g.setColor(new Color(239, 83, 255, 255));
            }

            if(squareAnswer && circleAnswer){
                pacmanWrong2 = true;
            }else if(squareAnswer && pacmanAnswer){
                circleWrong2 = true;
            }else if (pacmanAnswer && circleAnswer){
                squareWrong2 = true;
            }

            if (pacmanWrong2) {
                if (RandomArray.ranArrMatrix[3][0][3] > 0.75) {
                    Painting.paintOnePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][3] > 0.5) {
                    Painting.paintTwoPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][3] > 0.25){
                    Painting.paintThreePacman(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourPacman(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (squareWrong2) {
                if (RandomArray.ranArrMatrix[3][0][3] > 0.75) {
                    Painting.paintOneSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][3] > 0.5) {
                    Painting.paintTwoSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][3] > 0.25) {
                    Painting.paintThreeSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourSquare(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            } else if (circleWrong2) {
                if (RandomArray.ranArrMatrix[3][0][3] > 0.75) {
                    Painting.paintOneCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][3] > 0.5) {
                    Painting.paintTwoCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else if (RandomArray.ranArrMatrix[3][0][3] > 0.25){
                    Painting.paintThreeCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                } else {
                    Painting.paintFourCircle(g,1, (int) answerSizeX, (int) answerSizeY);
                }
            }
        }
        squareAnswer = false;
        pacmanAnswer = false;
        circleAnswer = false;
        pacmanWrong1 = false;
        circleWrong1 = false;
        squareWrong1 = false;
        pacmanWrong2 = false;
        circleWrong2 = false;
        squareWrong2 = false;
    }
}






