import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JPanel {
    static double random = Math.random();

    public static void main(String[] args) {

        // DrawingFunction drawing = new DrawingFunction();
        // drawing.creatingFrame();

        PositionsOfButtons.settingButtonPosition();
        RandomArray.creatingRandomArrays();

        IncreasingPattern increasing = new IncreasingPattern();
        ColoursPattern colours = new ColoursPattern();
        ShapesPattern shapes = new ShapesPattern();

        JTextArea textArea = new JTextArea();
        textArea.setBounds(400, 812, 178, 34);
        textArea.setBackground(new Color(162, 225, 165));
        textArea.setCaretColor(new Color(162, 225, 165));
        textArea.setFont(new Font("Comic Sans", Font.PLAIN, 25));

        JFrame frame = new JFrame("Raven Matrix");
        frame.setResizable(false);
        frame.setSize(PositionsOfShapes.frameSizeX, PositionsOfShapes.frameSizeY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textArea);

        if (random > 0.66) {
            frame.add(increasing);
        } else if (random < 0.33){
            frame.add(colours);
        } else {
            frame.add(shapes);
        }

            AnswerButton correctButton = new AnswerButton(ButtonType.RIGHT);
            correctButton.button.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.answerPosition], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.answerPosition], 117, 117);
            correctButton.button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    textArea.setText("correct!");

                }
            });


            JButton wrongButton1 = new JButton();
            wrongButton1.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.wrongAnswerPosition1], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.wrongAnswerPosition1], 117, 117);
            wrongButton1.setOpaque(false);
            wrongButton1.setContentAreaFilled(false);
            wrongButton1.setBorderPainted(false);
            wrongButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("wrong!");
                }

            });
            frame.add(wrongButton1);

            JButton wrongButton2 = new JButton();
            wrongButton2.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.wrongAnswerPosition2], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.wrongAnswerPosition2], 117, 117);
            wrongButton2.setOpaque(false);
            wrongButton2.setContentAreaFilled(false);
            wrongButton2.setBorderPainted(false);
            wrongButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    textArea.setText("wrong!");
                }
            });
            frame.add(wrongButton2);
            frame.add(correctButton.button);
    }
}

