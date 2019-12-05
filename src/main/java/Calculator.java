import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements
class Calculator extends JFrame implements ActionListener {

    static JFrame f;
    static JTextField l;
    String s0, s1, s2;
    Calculator()
    {
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {
        f = new JFrame("PrimesCalculator");
        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Calculator c = new Calculator();
        l = new JTextField(4);
        l.setEditable(false);
        JButton bF, bAKS, bMR, bSS;
        bF = new JButton("Fermat Test");
        bMR = new JButton("Miller-Rabin Test");
        bSS = new JButton("Solovay-Strassen Test");
        bAKS = new JButton("AKS Test");

        JPanel p = new JPanel();

        bF.addActionListener(c);
        bAKS.addActionListener(c);
        bMR.addActionListener(c);
        bSS.addActionListener(c);

        p.add(l);
        p.add(bF);
        p.add(bSS);
        p.add(bAKS);
        p.add(bMR);

        p.setBackground(Color.green);
        f.add(p);
        f.setSize(400, 440);
        f.show();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
/*
        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            l.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
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
            l.setText(s0 + s1 + s2);
}

 */




        /*
        private JButton button1;
        private JButton button2;
        private JButton button3;
        private JButton button4;
        private JTextField textField1;
        // f = new JFrame("Primes calculator");

         */
    }
}
