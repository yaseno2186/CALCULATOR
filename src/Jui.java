import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Jui extends JFrame {
    String s0, s1, s2;
    static JTextField num1Field = new JTextField();


    public Jui() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        s0 = s1 = s2 = "";

        JPanel panelText = new JPanel();
        panelText.setLayout(new GridLayout(1, 1, 1, 1));
        panelText.setBorder(new EmptyBorder(10, 10, 10, 10));


        Font font = new Font("Arial", Font.BOLD, 30);
        Font font1 = new Font("Arial", Font.PLAIN, 30);
        font1.isItalic();
        num1Field.setEditable(false);
        num1Field.setFont(font);
        num1Field.setBackground(Color.gray);
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        panelText.add(num1Field);


        JPanel panelNum = new JPanel();

        panelNum.setLayout(new GridLayout(4, 2, 0, 3));
        panelNum.setBorder(new EmptyBorder(0, 10, 5, 10));

        ArrayList<JButton> list = new ArrayList<>();



        JButton b1 = new JButton("1");
        list.add(b1);

        JButton b2 = new JButton("2");
        list.add(b2);

        JButton b3 = new JButton("3");
        list.add(b3);

        JButton bMinus = new JButton("-");
        list.add(bMinus);

        JButton b4 = new JButton("4");
        list.add(b4);

        JButton b5 = new JButton("5");
        list.add(b5);

        JButton b6 = new JButton("6");
        list.add(b6);

        JButton bPlus = new JButton("+");
        list.add(bPlus);

        JButton b7 = new JButton("7");
        list.add(b7);

        JButton b8 = new JButton("8");
        list.add(b8);

        JButton b9 = new JButton("9");
        list.add(b9);

        JButton bTimes = new JButton("x");
        list.add(bTimes);

        JButton bDelete = new JButton("C");
        list.add(bDelete);

        JButton b0 = new JButton("0");
        list.add(b0);

        JButton bEqual = new JButton("=");
        list.add(bEqual);

        JButton bDivid = new JButton("÷");
        list.add(bDivid);


        Color color = Color.white;

        for (JButton button : list) {
            button.setForeground(color);
            button.setBackground(Color.darkGray);
            button.setFont(font1);
            button.addActionListener(theAction);
            panelNum.add(button);

        }

        add(panelText, BorderLayout.NORTH);
        add(panelNum, BorderLayout.CENTER);

        pack();
        setSize(400, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Jui();
    }


    ActionListener theAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
                if (!s1.equals(""))
                    s2 = s2 + s;
                else
                    s0 = s0 + s;

                num1Field.setText(s0 + s1 + s2);
            } else if (s.charAt(0) == 'C') {
                // clear the one letter
                s0 = s1 = s2 = "";

                // set the value of text
                num1Field.setText(s0 + s1 + s2);
            } else if (s.charAt(0) == '=') {

                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("÷"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));


                // set the value of text
                num1Field.setText(s0 + s1 + s2 + "=" + te);

                // convert it to string
                s0 = Double.toString(te);

                s1 = s2 = "";
            } else {
                // if there was no operand
                if (s1.equals("") || s2.equals(""))
                    s1 = s;
                    // else evaluate
                else {
                    double te;

                    // store the value in 1st
                    if (s1.equals("+"))
                        te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                    else if ( s1.equals("-"))
                        te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                    else if (s1.equals("÷"))
                        te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                    else
                        te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                    // convert it to string
                    s0 = Double.toString(te);

                    // place the operator
                    s1 = s;

                    // make the operand blank
                    s2 = "";
                }

                // set the value of text
                num1Field.setText(s0 + s1 + s2);
            }


        }

    };

}
