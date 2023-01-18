import javax.swing.*;

enum ButtonType{
    WRONG,
    RIGHT
}

public class AnswerButton {
    JButton button;

    ButtonType type = ButtonType.WRONG;

    AnswerButton(ButtonType type){
        this.type = type;
        button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
