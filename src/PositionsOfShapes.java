import java.awt.*;

public class PositionsOfShapes {
//positions of shapes used in drawing
    static int frameSizeX = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 100;
    static int frameSizeY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 100;
    static int frameCenterX = frameSizeX/2;
    static int frameCenterY = frameSizeY/2;

    static double[] buttonPositionX = {frameCenterX - 0.230*frameSizeX,frameCenterX - 0.065*frameSizeX,frameCenterX + 0.1*frameSizeX};
    static double[] buttonPositionY = {frameCenterY + 0.27*frameSizeY,frameCenterY + 0.27*frameSizeY,frameCenterY + 0.27*frameSizeY};

    static double[][] oneObjectX = {{0.073 * frameSizeX}, //matrix tiles position
            {0.055 * frameSizeX}};                        //answer tiles position

    static double[][] oneObjectY = {{0.073 * frameSizeY}, //matrix tiles position
            {0.053 * frameSizeY}};                        //answer tiles position

    static double[][] twoObjectsX = {{0.025 * frameSizeX, 0.115 * frameSizeX},
            {0.025 * frameSizeX, 0.08 * frameSizeX}};

    static double[][] twoObjectsY = {{0.07 * frameSizeY, 0.07 * frameSizeY},
            {0.05 * frameSizeY, 0.05 * frameSizeY }};

    static double[][] threeObjectsX = {{0.027 * frameSizeX, 0.117 * frameSizeX, 0.072 * frameSizeX},
            {0.025 * frameSizeX, 0.08* frameSizeX, 0.052 * frameSizeX }};

    static double[][] threeObjectsY = {{0.03 * frameSizeY, 0.03 * frameSizeY, 0.12 * frameSizeY},
            {0.03 * frameSizeY, 0.03 * frameSizeY, 0.08 * frameSizeY }};

    static double[][] fourObjectsX = {{0.025 * frameSizeX, 0.115 * frameSizeX,0.025 * frameSizeX, 0.115 * frameSizeX},
            {0.025 * frameSizeX, 0.08 * frameSizeX,0.025 * frameSizeX, 0.08 * frameSizeX }};

    static double[][] fourObjectsY = {{0.03 * frameSizeY, 0.03 * frameSizeY, 0.12 * frameSizeY, 0.12 * frameSizeY},
            {0.03 * frameSizeY, 0.03 * frameSizeY, 0.08 * frameSizeY, 0.08 * frameSizeY }};

    static Color color =  (new Color(192, 192, 192));

    static Color secondColor = new Color(152, 55, 255);
    static Color thirdColor = new Color(211, 24, 155);
    static Color backgroundColor = new Color(211, 211, 211);

    public PositionsOfShapes() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
         frameSizeY = (int)size.getHeight();
         frameSizeX = frameSizeY;
    }
}
