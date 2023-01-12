import java.awt.*;
public class Painting {
    //    functions that paint different shapes, different amount of them and in different sizes (size of answer shapes or size of shapes in matrix)
//    pos: use 0 if you want to paint shapes in matrix, use 1 to draw shapes in answers
    static double grayRectangleY;
    static double grayRectangleX;

    static public void paintOnePacman(Graphics g, int pos, int sizeX, int sizeY) {
        g.fillArc((int) (grayRectangleX + PositionsOfShapes.oneObjectX[pos][0]), (int) (grayRectangleY + PositionsOfShapes.oneObjectY[pos][0]), (sizeX), (sizeY), 40, 280);
    }
    static public void paintTwoPacman(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 2; m++) {
            g.fillArc((int) (grayRectangleX + PositionsOfShapes.twoObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.twoObjectsY[pos][m]), (sizeX), (sizeY), 40, 280);
        }
    }
    static public void paintThreePacman(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 3; m++) {
            g.fillArc((int) (grayRectangleX + PositionsOfShapes.threeObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.threeObjectsY[pos][m]), (sizeX), (sizeY), 40, 280);
        }
    }
    static public void paintFourPacman(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 4; m++) {
            g.fillArc((int) (grayRectangleX + PositionsOfShapes.fourObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.fourObjectsY[pos][m]),  (sizeX),  (sizeY), 40, 280);
        }
    }

    static public void paintOneSquare(Graphics g, int pos, int sizeX, int sizeY) {
        g.fillRect((int) (grayRectangleX + PositionsOfShapes.oneObjectX[pos][0]), (int) (grayRectangleY + PositionsOfShapes.oneObjectY[pos][0]), (sizeX),(sizeY));
    }
    static public void paintTwoSquare(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 2; m++) {
            g.fillRect((int) (grayRectangleX + PositionsOfShapes.twoObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.twoObjectsY[pos][m]), (sizeX), (sizeY));
        }
    }
    static public void paintThreeSquare(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 3; m++) {
            g.fillRect((int) (grayRectangleX + PositionsOfShapes.threeObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.threeObjectsY[pos][m]),  (sizeX),  (sizeY));
        }
    }
    static public void paintFourSquare(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 4; m++) {
            g.fillRect((int) (grayRectangleX + PositionsOfShapes.fourObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.fourObjectsY[pos][m]),  (sizeX),(sizeY));
        }
    }

    static public void paintOneCircle(Graphics g, int pos, int sizeX, int sizeY) {
        g.fillOval((int) (grayRectangleX + PositionsOfShapes.oneObjectX[pos][0]), (int) (grayRectangleY + PositionsOfShapes.oneObjectY[pos][0]),  (sizeX),  (sizeY));
    }
    static public void paintTwoCircle(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 2; m++) {
            g.fillOval((int) (grayRectangleX + PositionsOfShapes.twoObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.twoObjectsY[pos][m]),  (sizeX),  (sizeY));
        }
    }
    static public void paintThreeCircle(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 3; m++) {
            g.fillOval((int) (grayRectangleX + PositionsOfShapes.threeObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.threeObjectsY[pos][m]),  (sizeX), (sizeY));
        }
    }
    static public void paintFourCircle(Graphics g, int pos, int sizeX, int sizeY) {
        for (int m = 0; m < 4; m++) {
            g.fillOval((int) (grayRectangleX + PositionsOfShapes.fourObjectsX[pos][m]), (int) (grayRectangleY + PositionsOfShapes.fourObjectsY[pos][m]),  (sizeX),  (sizeY));
        }
    }
}
