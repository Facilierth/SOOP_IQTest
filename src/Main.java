import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel {

    static Color color =  (PositionsOfShapes.color);
    static AnswerButton[] buttons = new AnswerButton[3];
    static JTextArea textArea;

    static  JFrame frame;

    static int points = 0;

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
        title.setFont(new Font("Calibri", Font.BOLD, 80));

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

        textArea = new JTextArea();
        textArea.setBounds((int) (0.33 * PositionsOfShapes.frameSizeX), (int) (0.9 * PositionsOfShapes.frameSizeY), (int) (0.33 * PositionsOfShapes.frameSizeX), 34);

        textArea.setBackground(color);
        textArea.setCaretColor(color);
        textArea.setFont(new Font("Comic Sans", Font.PLAIN, 25));

        generatedPattern = new ShapesPattern();

        frame.getContentPane().add(textArea);


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
                        points++;
                        textArea.setText("right!");
                        GenerateBoard();
                    }else {
                        textArea.setText("wrong!");
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
        System.out.println(points);

    }
}

