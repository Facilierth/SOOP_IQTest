import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel {

    static Color color =  (PositionsOfShapes.color);
    static AnswerButton[] buttons = new AnswerButton[3];
    static JTextField textFieldAnswer;
    static JTextField textFieldPoints;


    static  JFrame frame;

    static int playerPoints = 0;
    static int totalPoints = 0;

    static JPanel generatedPattern;
    static long last = 0;

    public static void main(String[] args) {

        // DrawingFunction drawing = new DrawingFunction();
        // drawing.creatingFrame();
        frame= new JFrame("Raven Matrix");

        //frame.getContentPane().setBackground(color);
        frame.setResizable(false);
        frame.setSize(PositionsOfShapes.frameSizeX, PositionsOfShapes.frameSizeY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       /* ImageIcon background = new ImageIcon(frame.getClass().getResource("windowsXP.jpg"));
        Image img = background.getImage();
        Image temp = img.getScaledInstance(PositionsOfShapes.frameSizeX,PositionsOfShapes.frameSizeY,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,PositionsOfShapes.frameSizeX,PositionsOfShapes.frameSizeY);


        frame.getContentPane().add(back);

        frame.getLayeredPane().setLayer(back, frame.getLayeredPane().lowestLayer());
*/

        JLabel title = new JLabel("Raven's Matrices");

        JLabel subtext = new JLabel("Click anywhere to continue");

        title.setBounds( 0, (int) (PositionsOfShapes.frameSizeY * 0.33), (int) (PositionsOfShapes.frameSizeX), (int) (PositionsOfShapes.frameSizeY*0.33));
        title.setText("Raven's Matrices");

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Calibre", Font.BOLD, 80));

        subtext.setFont(new Font("Calibre", Font.ITALIC, 15));
        subtext.setBounds(0, (int) (PositionsOfShapes.frameSizeY * 0.4),(int) (PositionsOfShapes.frameSizeX), (int) (PositionsOfShapes.frameSizeY*0.33));
        subtext.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.invalidate();
                SetUp();
            }

        });

        frame.getContentPane().add(subtext);
        frame.getContentPane().add(title);
        frame.getContentPane().add(button);

    }

    private static void SetUp(){
        PositionsOfButtons.settingButtonPosition();
        RandomArray.creatingRandomArrays();
        textFieldPoints = new JTextField();
        textFieldPoints.setBounds((int) (0.77 * PositionsOfShapes.frameSizeX), (int) (0.8 * PositionsOfShapes.frameSizeY), (int) (0.20 * PositionsOfShapes.frameSizeX), 70);
        textFieldPoints.setBackground(color);
        textFieldPoints.setCaretColor(color);
        textFieldPoints.setEditable(false);
        textFieldPoints.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textFieldPoints.setFont(new Font("Comic Sans", Font.PLAIN, 70));
        textFieldPoints.setText("0/0");


        textFieldAnswer = new JTextField();
        textFieldAnswer.setBounds((int) (0.455 * PositionsOfShapes.frameSizeX), (int) (0.9 * PositionsOfShapes.frameSizeY), (int) (0.33 * PositionsOfShapes.frameSizeX), 34);
        textFieldAnswer.setBackground(color);
        textFieldAnswer.setCaretColor(color);
        textFieldAnswer.setEditable(false);
        textFieldAnswer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textFieldAnswer.setFont(new Font("Comic Sans", Font.PLAIN, 25));

        generatedPattern = new ShapesPattern();

        frame.getContentPane().add(textFieldAnswer);
        frame.getContentPane().add(textFieldPoints);


        for(int i = 0; i < 3; i++) {
            buttons[i] = new AnswerButton();
            buttons[i].button.setBounds((int) PositionsOfShapes.buttonPositionX[i], (int) PositionsOfShapes.buttonPositionY[i], 117, 117);
            buttons[i].button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    last = e.getWhen();

                    boolean isRight = false;

                    JButton button = (JButton) e.getSource();
                    for(int i = 0; i < 3; i++)
                    {
                        if(buttons[i].button.equals(button))
                            isRight = (buttons[i].type == ButtonType.RIGHT);
                    }

                    if(isRight) {
                        textFieldAnswer.setText("correct!");
                        playerPoints++;
                        totalPoints++;
                        textFieldPoints.setText(String.valueOf(playerPoints + "/" + totalPoints));
                        GenerateBoard();

                    }else {
                        textFieldAnswer.setText("wrong!");
                        totalPoints++;
                        textFieldPoints.setText(String.valueOf(playerPoints + "/" + totalPoints));
                        GenerateBoard();
                    }
                }
            });

            frame.getContentPane().add(buttons[i].button);
        }

        //please don't touch it, I don't know why, but it works, it needs to be here
        JButton nothingButton = new JButton();
        nothingButton.setBounds((int) PositionsOfShapes.buttonPositionX[PositionsOfButtons.answerPosition], (int) PositionsOfShapes.buttonPositionY[PositionsOfButtons.answerPosition], 117, 117);
        nothingButton.setOpaque(false);
        nothingButton.setContentAreaFilled(false);
        nothingButton.setBorderPainted(false);

        frame.add(nothingButton);

        buttons[PositionsOfButtons.answerPosition].type = ButtonType.RIGHT;
        buttons[PositionsOfButtons.wrongAnswerPosition1].type = ButtonType.WRONG;
        buttons[PositionsOfButtons.wrongAnswerPosition2].type = ButtonType.WRONG;

        frame.getContentPane().add(generatedPattern);

        frame.revalidate();
    }

    private static void GenerateBoard() {

        PositionsOfButtons.settingButtonPosition();
        RandomArray.creatingRandomArrays();

        frame.remove(generatedPattern);

        Random random = new Random();
        int pattern = random.nextInt(0, 3);
        switch(pattern){
            case 0:
                generatedPattern = new IncreasingPattern();
                break;
            case 1:
                generatedPattern = new ColoursPattern();
                break;
            case 2:
                generatedPattern = new ShapesPattern();
                break;

        }
        frame.getContentPane().add(generatedPattern);

        buttons[PositionsOfButtons.answerPosition].type = ButtonType.RIGHT;
        buttons[PositionsOfButtons.wrongAnswerPosition1].type = ButtonType.WRONG;
        buttons[PositionsOfButtons.wrongAnswerPosition2].type = ButtonType.WRONG;

        frame.revalidate();
    }
}

