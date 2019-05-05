package Calculator;

import javax.swing.*;
import java.awt.event.KeyEvent;

class CalculatorFrame extends JFrame {





    public CalculatorFrame() {

        setTitle("Calculator");


        JMenu menu = new JMenu("Command");
        menu.setMnemonic(KeyEvent.VK_C);

        JMenuBar mb= new JMenuBar();
        mb.add(menu);
        setJMenuBar(mb);

        JCheckBoxMenuItem resizebilites;
        resizebilites = new JCheckBoxMenuItem(("Allow resize"));
        menu.add(resizebilites);
        resizebilites.setSelected(true);
        resizebilites.addActionListener(e -> setResizable(!isResizable()));

        JMenuItem mi = new JMenuItem("Exit");
        menu.add(mi);
        mi.addActionListener(e -> dispose());


        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();

    }
}