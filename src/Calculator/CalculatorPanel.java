package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.util.Scanner;

public class CalculatorPanel extends JPanel {

    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;





    public CalculatorPanel() {
        setLayout(new BorderLayout());


        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(new Font("TimesRoman", Font.BOLD, 50));
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        newButton("7", insert);
        newButton("8", insert);
        newButton("9", insert);
        newButton("+", command);

        newButton("4", insert);
        newButton("5", insert);
        newButton("6", insert);
        newButton("-", command);

        newButton("1", insert);
        newButton("2", insert);
        newButton("3", insert);
        newButton("*", command);

        newButton("CE", command);
        newButton("0", insert);
        newButton(".", insert);
        newButton("/", command);

        add(panel, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        newButton("=", command);
        panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        panel.setPreferredSize(new Dimension(50, 50));
        add(panel, BorderLayout.SOUTH);

    }

    private void newButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(new Font("TimesRoman", Font.BOLD, 30));
        button.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        button.addActionListener(listener);
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                String keyinput = e.getKeyText(e.getKeyCode());


                if(keyinput.matches("^-?\\d+$")) {
                    if (start) {
                        display.setText("");
                        start = false;
                    }

                    display.setText(display.getText()+keyinput);
                }

                else {

                    switch (keyinput){
                        case "Minus" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "-";
                            start = true;
                            break;
                        case "Equals" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "+";
                            start = true;
                            break;
                        case "NumPad -" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "-";
                            start = true;
                            break;
                        case "NumPad +" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "+";
                            start = true;
                            break;
                        case "NumPad /" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "/";
                            start = true;
                            break;
                        case "NumPad *" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "*";
                            start = true;
                            break;
                        case "Enter" : calculate(Double.parseDouble(display.getText()));
                            lastCommand = "=";
                            start = true;
                            break;
                        case "NumPad-1" :  display.setText(display.getText()+"1"); break;
                        case "NumPad-2" :  display.setText(display.getText()+"2"); break;
                        case "NumPad-3" :  display.setText(display.getText()+"3"); break;
                        case "NumPad-4" :  display.setText(display.getText()+"4"); break;
                        case "NumPad-5" :  display.setText(display.getText()+"5"); break;
                        case "NumPad-6" :  display.setText(display.getText()+"6"); break;
                        case "NumPad-7" :  display.setText(display.getText()+"7"); break;
                        case "NumPad-8" :  display.setText(display.getText()+"8"); break;
                        case "NumPad-9" :  display.setText(display.getText()+"9"); break;
                        case "NumPad-0" :  display.setText(display.getText()+"0"); break;



                    }






                }

                String myString = Double.toString(result);
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);

            }

        });
        panel.add(button);
    }


    private class InsertAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();


            if (start) {
                display.setText("");
                start = false;
            }

            display.setText(display.getText() + input);

        }
    }


    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();


            if (start) {
                if (command.equals("CE")) {
                    display.setText("0");
                    result = 0;
                    start = false;
                } else lastCommand = command;
            } else {
                if (command.equals("CE")) {
                    display.setText("0");
                    result = 0;
                    start = false;
                } else {
                    calculate(Double.parseDouble(display.getText()));
                    lastCommand = command;
                    start = true;

                    String myString = Double.toString(result);
                    StringSelection stringSelection = new StringSelection(myString);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);


                }
            }
        }
    }


    public void calculate(double x) {

        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                result /= x;
                break;
            case "=":
                result = x;
                                break;

        }


        display.setText(Double.toString(result));
    }

}