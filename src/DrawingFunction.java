import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DrawingFunction extends JFrame {
//here I was trying to create function displaying one test after another but something with buttons is wrong
    JFrame frame = new JFrame("Raven Matrix");
    JTextArea textArea = new JTextArea();
    IncreasingPattern increasing = new IncreasingPattern();

    public void creatingFrame (){

        PositionsOfButtons.settingButtonPosition();
        RandomArray.creatingRandomArrays();

        System.out.println(PositionsOfButtons.answerPosition);

        textArea.setBounds(400, 812, 138, 34);
        textArea.setBackground(new Color(162, 225, 165));
        textArea.setCaretColor(new Color(162, 225, 165));
        textArea.setFont(new Font("Comic Sans", Font.PLAIN, 25));

        frame.setResizable(false);
        frame.setSize(PositionsOfShapes.frameSizeX, PositionsOfShapes.frameSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(textArea);
        frame.add(increasing);

        JButton correctButton = new JButton();
        correctButton.setOpaque(false);
        correctButton.setContentAreaFilled(false);
        correctButton.setBorderPainted(false);
        correctButton.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.answerPosition], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.answerPosition], 117, 117);
        correctButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("correct!");
                creatingFrame();
            }
        });

        JButton wrongButton1 = new JButton();
        wrongButton1.setOpaque(false);
        wrongButton1.setContentAreaFilled(false);
        wrongButton1.setBorderPainted(false);
        wrongButton1.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.wrongAnswerPosition1], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.wrongAnswerPosition1], 117, 117);
        wrongButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("wrong!");
                creatingFrame();
            }
        });

        JButton wrongButton2 = new JButton();
        wrongButton2.setOpaque(false);
        wrongButton2.setContentAreaFilled(false);
        wrongButton2.setBorderPainted(false);
        wrongButton2.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.wrongAnswerPosition2], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.wrongAnswerPosition2], 117, 117);
        wrongButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("wrong!");
                creatingFrame();
            }
        });

        JButton nothingButton = new JButton();
        nothingButton.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.answerPosition], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.answerPosition], 117, 117);
        nothingButton.setOpaque(false);
        nothingButton.setContentAreaFilled(false);
        nothingButton.setBorderPainted(false);

        frame.add(correctButton);
        frame.add(wrongButton1);
        frame.add(wrongButton2);
        frame.add(nothingButton);
    }
}
