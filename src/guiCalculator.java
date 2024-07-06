import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class guiCalculator extends JFrame {
    String FirstNumber, theRule, SecondNumber;
    static JTextField NumberField = new JTextField();


    public guiCalculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FirstNumber = theRule = SecondNumber = "";

        JPanel PanelForField = new JPanel();
        PanelForField.setLayout(new GridLayout(1, 1, 1, 1));
        PanelForField.setBorder(new EmptyBorder(10, 10, 10, 10));


        Font FieldFont = new Font("Arial", Font.BOLD, 30);
        Font ButtonsFont = new Font("Montserrat", Font.PLAIN, 40);
        ButtonsFont.isItalic();
        NumberField.setEditable(false);
        NumberField.setFont(FieldFont);
        NumberField.setBackground(Color.gray);
        NumberField.setHorizontalAlignment(JTextField.CENTER);
        PanelForField.add(NumberField);


        JPanel PanelForButtons = new JPanel();

        PanelForButtons.setLayout(new GridLayout(3, 2, 0, 3));
        PanelForButtons.setBorder(new EmptyBorder(0, 10, 5, 10));

        ArrayList<JButton> ListOfButtons = new ArrayList<>();

        JButton b2 = new JButton("2");
        JButton b1 = new JButton("1");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bMinus = new JButton("-");
        JButton bPlus = new JButton("+");
        JButton bTimes = new JButton("x");
        JButton bDivid = new JButton("÷");
        JButton bDelete = new JButton("C");
        JButton bPoint = new JButton(".");
        JButton bDel = new JButton("⌫");
        JButton bEqual = new JButton("=");


        // Add all buttons to the list at once
        Collections.addAll(ListOfButtons,
                b1, b2, b3, bMinus, bPlus,bEqual,
                b4, b5, b6, bTimes, bDivid,bDel,
                b7, b8, b9,b0,bPoint,bDelete);


        Color color = Color.white;
        for (JButton button : ListOfButtons) {
            button.setForeground(color);
            button.setBackground(Color.darkGray);
            button.setFont(ButtonsFont);
            button.addActionListener(theAction);
            PanelForButtons.add(button);

        }

        add(PanelForField, BorderLayout.NORTH);
        add(PanelForButtons, BorderLayout.CENTER);

        pack();
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new guiCalculator();
    }


    ActionListener theAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String Input = e.getActionCommand();


            if ((Input.charAt(0) >= '0' && Input.charAt(0) <= '9') || Input.charAt(0) == '.') {
                if (!theRule.equals(""))
                    SecondNumber = SecondNumber + Input;
                else
                    FirstNumber = FirstNumber + Input;

                NumberField.setText(FirstNumber + theRule + SecondNumber);
            } else if (Input.charAt(0) == 'C') {
                // clear the one letter
                FirstNumber = theRule = SecondNumber = "";

                // set the value of text
                NumberField.setText(FirstNumber + theRule + SecondNumber);
            } else if (Input.charAt(0) == '⌫') {
                if (theRule.isEmpty() && SecondNumber.isEmpty()) {
                    FirstNumber = FirstNumber.replaceAll(".$", "");
                } else if (!FirstNumber.isEmpty() && SecondNumber.isEmpty()) {
                    theRule = theRule.replaceAll(".$", "");
                } else {
                    SecondNumber = SecondNumber.replaceAll(".$", "");
                }
                // set the value of text
                NumberField.setText(FirstNumber + theRule + SecondNumber);

            } else if (Input.charAt(0) == '=') {

                double te;

                // store the value in 1st
                if (theRule.equals("+"))
                    te = (Double.parseDouble(FirstNumber) + Double.parseDouble(SecondNumber));
                else if (theRule.equals("-"))
                    te = (Double.parseDouble(FirstNumber) - Double.parseDouble(SecondNumber));
                else if (theRule.equals("÷"))
                    te = (Double.parseDouble(FirstNumber) / Double.parseDouble(SecondNumber));
                else
                    te = (Double.parseDouble(FirstNumber) * Double.parseDouble(SecondNumber));


                // set the value of text
                NumberField.setText(FirstNumber + theRule + SecondNumber + "=" + te);

                // convert it to string
                FirstNumber = Double.toString(te);

                theRule = SecondNumber = "";
            } else {
                // if there was no operand
                if (theRule.equals("") || SecondNumber.equals(""))
                    theRule = Input;
                    // else evaluate
                else {
                    double te;

                    // store the value in 1st
                    if (theRule.equals("+"))
                        te = (Double.parseDouble(FirstNumber) + Double.parseDouble(SecondNumber));
                    else if (theRule.equals("-"))
                        te = (Double.parseDouble(FirstNumber) - Double.parseDouble(SecondNumber));
                    else if (theRule.equals("÷"))
                        te = (Double.parseDouble(FirstNumber) / Double.parseDouble(SecondNumber));
                    else
                        te = (Double.parseDouble(FirstNumber) * Double.parseDouble(SecondNumber));

                    // convert it to string
                    FirstNumber = Double.toString(te);

                    // place the operator
                    theRule = Input;

                    // make the operand blank
                    SecondNumber = "";
                }

                // set the value of text
                NumberField.setText(FirstNumber + theRule + SecondNumber);
            }
        }

    };
}
