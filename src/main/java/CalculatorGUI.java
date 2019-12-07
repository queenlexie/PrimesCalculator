import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements
class CalculatorGUI extends JFrame implements ActionListener {


    static JFrame f;
    static JLabel labelText;
    static JLabel labelHello;
    static JLabel labelMR;
    static JLabel labelFermat;
    static JLabel labelSS;
    static JLabel labelInstructions;
    static JTextField l;
    static JTextField lF;
    static JTextField lMR;
    static JTextField lSS;
    static JTextField lAKS;
    static JLabel spacer;

    int flag=0;
    public static int valueMR;
    public static int valueFermat;
    public static int valueSS;
    String s0;
    String s1, s2;
    CalculatorGUI()
    {
        s0 = s1 = s2 = "";
    }


        public static void Action(){

        //<editor-fold desc="panels">
        f = new JFrame("PrimesCalculator");
        JPanel p1 = new JPanel(new BorderLayout());
        p1.setLayout(new GridLayout(4, 3));
        JPanel pNumber = new JPanel(new BorderLayout());
        //pNumber.setLayout(new FlowLayout(FlowLayout.CENTER));
        pNumber.setPreferredSize(new Dimension(280, 23));
        pNumber.setLayout(new BoxLayout(pNumber, BoxLayout.X_AXIS));
        JPanel pFermat = new JPanel(new BorderLayout());
        pFermat.setLayout(new GridLayout(1, 1));
        pFermat.setPreferredSize(new Dimension(280, 23));
        JPanel pSS = new JPanel(new BorderLayout());
        pSS.setLayout(new GridLayout(1, 1));
        pSS.setPreferredSize(new Dimension(280, 23));
        JPanel pAKS = new JPanel(new BorderLayout());
        pAKS.setLayout(new GridLayout(1, 1));
        pAKS.setPreferredSize(new Dimension(280, 23));
        JPanel pMR = new JPanel(new BorderLayout());
        pMR.setLayout(new GridLayout(1, 1));
        pMR.setPreferredSize(new Dimension(280, 23));
        JPanel panelSpinnerMR = new JPanel(new BorderLayout());
        panelSpinnerMR.setPreferredSize(new Dimension(100, 23));
        JPanel panelSpinnerFermat = new JPanel(new BorderLayout());
        panelSpinnerFermat.setPreferredSize(new Dimension(100, 23));
        JPanel panelSpinnerSS = new JPanel(new BorderLayout());
        panelSpinnerSS.setPreferredSize(new Dimension(100, 23));
            //</editor-fold>

         //<editor-fold desc="labels">
        labelText = new JLabel("We do not know anything yet :)  ");
        labelHello=new JLabel("Provide a number to check its primality");
        labelMR=new JLabel("Choose a random number between 2 and your number - 2:");
        labelFermat=new JLabel("Choose a number of iterations for this test:");
        labelSS=new JLabel("Choose a number of iterations for this test:");
        labelInstructions=new JLabel("Choosing higher value increases probability of correctness");
            //</editor-fold>

         //<editor-fold desc="spinners">
        SpinnerModel smMR = new SpinnerNumberModel(2, 2, 10000, 1);
        JSpinner sMR = new JSpinner(smMR);
        SpinnerModel smSS = new SpinnerNumberModel(2, 2, 10000, 1);
        JSpinner sSS = new JSpinner(smSS);
        SpinnerModel smFermat = new SpinnerNumberModel(2, 2, 10000, 1);
        JSpinner sFermat = new JSpinner(smFermat);
        sMR.addChangeListener(e -> {
            valueMR = (Integer) ((JSpinner)e.getSource()).getValue();
            //s.setBounds(2, 2, value -2 , 1);
        });
        sFermat.addChangeListener(e -> {
                valueFermat = (Integer) ((JSpinner)e.getSource()).getValue();
            });
        sSS.addChangeListener(e -> {
                valueSS = (Integer) ((JSpinner)e.getSource()).getValue();
            });
            //</editor-fold>

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        CalculatorGUI c = new CalculatorGUI();

        //<editor-fold desc="Text Fields">
        l = new JTextField(10);
        lF = new JTextField(10);
        lF.setPreferredSize(new Dimension(200, 10));
        lMR = new JTextField(10);
        lAKS = new JTextField(10);
        lSS = new JTextField(10);
        l.setEditable(false);
        lF.setEditable(false);
        lMR.setEditable(false);
        lSS.setEditable(false);
        lAKS.setEditable(false);
        lF.setBounds(100, 100, 130, 30);
            //</editor-fold>

            //<editor-fold desc="buttons">
        JButton bF, bAKS, bMR, bSS;
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, beq, beq1;
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        beq1 = new JButton("<");
        beq = new JButton("C");

        bF = new JButton("Fermat Test");
        bMR = new JButton("Miller-Rabin Test");
        bSS = new JButton("Solovay-Strassen Test");
        bAKS = new JButton("AKS Test");
            //</editor-fold>

       GradientPanel p = new GradientPanel();
       //p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

            //<editor-fold desc=" Action Listeners">
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        bF.addActionListener(c);
        bAKS.addActionListener(c);
        bMR.addActionListener(c);
        bSS.addActionListener(c);
            //</editor-fold>

            //<editor-fold desc="Adding to panels">
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(beq);
        p1.add(b0);
        p1.add(beq1);

        pNumber.add(l);
        pFermat.add(bF);
        pFermat.add(lF);
        pSS.add(bSS);
        pSS.add(lSS);
        pAKS.add(bAKS);
        pAKS.add(lAKS);
        pMR.add(bMR);
        pMR.add(lMR);
        panelSpinnerMR.add(sMR);
        panelSpinnerFermat.add(sFermat);
        panelSpinnerSS.add(sSS);
            //</editor-fold>

            //<editor-fold desc="Adding other panels to main panel ">
        p.add(labelHello);
        //p.add(new JSeparator(SwingConstants.Y_AXIS));
        p.add(p1);
        p.add(spacer = new JLabel(" "),"span, grow");
        p.add(new JSeparator(SwingConstants.HORIZONTAL));
        p.add(pNumber);
        //p.add(spacer = new JLabel(" "),"span, grow");
        p.add(new JSeparator(SwingConstants.HORIZONTAL));
        //p.add(panelSpinner);
        p.add(labelInstructions);
        p.add(pAKS);
        p.add(new JSeparator(SwingConstants.HORIZONTAL));
        p.add(labelFermat);
        p.add(panelSpinnerFermat);
        p.add(pFermat);
        p.add(spacer = new JLabel(" "),"span, grow");
        p.add(new JSeparator(SwingConstants.HORIZONTAL));
        //p.add(s);
        p.add(labelSS);
        p.add(panelSpinnerSS);
        p.add(pSS);
        p.add(new JSeparator(SwingConstants.HORIZONTAL));
        p.add(labelMR);
        p.add(panelSpinnerMR);
        p.add(pMR);
        p.add(new JSeparator());
        p.add(labelText);
            //</editor-fold>

            //<editor-fold desc="Frame">
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
/*
            Container contentPane = f.getContentPane();
            SpringLayout layout=new SpringLayout();
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,  f, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
            contentPane.setLayout(layout);

 */
        f.setVisible(true);
        f.add(p);
        f.setSize(363, 530);
        f.show();
            //</editor-fold>
    }
    public void actionPerformed(ActionEvent e)
    {
        String whatWeGot = e.getActionCommand();
        //Integer.parseInt( s.getSpinner().getValue().toString())
        String output;
        boolean b = false;

        try {
            // if the value is a number
            if ((whatWeGot.charAt(0) >= '0' && whatWeGot.charAt(0) <= '9')) {
                // if operand is present then add to second no
                if (!s1.equals(""))
                    s2 = s2 + whatWeGot;
                else {
                    s0 = s0 + whatWeGot;
                }

                // set the value of text
                l.setText(s0 + s1 + s2);
                flag = 0;
            } else if (whatWeGot.charAt(0) == 'C') {
                s0 = s1 = s2 = "";
                // set the value of text
                l.setText(s0 + s1 + s2);
                lMR.setText("");
                lF.setText("");
                lSS.setText("");
                lAKS.setText("");
                labelText.setText("");
                flag = 0;
            } else if (whatWeGot.charAt(0) == '<') {
                s0 = s0.substring(0, s0.length() - 1);
                l.setText(s0);
                flag = 0;
            }

            //String output;
            //boolean b = false;
            //int flag = 0;
            // store the value in 1st
            else if (whatWeGot.equals("Fermat Test")) {
                b = FermatTest.isPrime(Integer.parseInt(s0), valueFermat);
                if (b == true) {
                    output = "Is a Prime Number";
                    flag++;
                    // p.revalidate();

                } else
                    output = "Is Not a Prime Number";
                lF.setText(output);
                flagChecker(flag);
            } else if (whatWeGot.equals("Miller-Rabin Test")) {

                b = MillerRabinTest.isPrime(Integer.parseInt(s0), valueMR);
                if (b == true) {
                    flag++;
                    output = "Is a Prime Number";
                } else
                    output = "Is Not a Prime Number";
                lMR.setText(output);
                flagChecker(flag);

            } else if (whatWeGot.equals("Solovay-Strassen Test")) {
                b = SolovayStrassenTest.SSIsPrime(Integer.parseInt(s0), valueSS);
                if (b == true) {
                    output = "Is a Prime Number";
                    flag++;
                } else
                    output = "Is Not a Prime Number";
                lSS.setText(output);
                flagChecker(flag);
            } else {
                b = AKSTest.isPrime(Integer.parseInt(s0));
                if (b == true) {
                    output = " Is a Prime Number";
                    flag++;
                } else
                    output = "Is Not a Prime Number";
                lAKS.setText(output);
                flagChecker(flag);
            }
        } catch (Exception nullException) {
            labelText.setText("You need to provide a valid number first");
        }

            // set the value of text
            //lF.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            //s0 = Double.toString(output);
            whatWeGot = s1 = s2 = "";
        }
        public void flagChecker(int flag){
            if (flag == 0)
                labelText.setText("Your number probably is a composite number");
            else if (flag == 1)
                labelText.setText("Your number maybe is a prime number");
            else if (flag == 2)
                labelText.setText("It is hard to say whether your number is prime or not");
            else if (flag == 3)
                labelText.setText("Your number probably is a prime number");
            else if (flag == 4)
                labelText.setText("Your number is a prime number");
            else
                labelText.setText("ERROR");
        }
    public static void main(String args[]) {
        Action();
    }

    }
