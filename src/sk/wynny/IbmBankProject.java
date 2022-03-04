package sk.wynny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class IbmBankProject extends JFrame implements ActionListener {
    int accountBalancel = 1436;

    JButton button;
    JTextField text;
    JButton password;
    JPasswordField passwordField;
    JButton withdraw;
    JTextField withdrawCash;
    JButton withdrawCashInput;
    JTextField insertCash;
    JButton insertCashInput;
    JButton insert;
    JButton back;
    JLayeredPane layered;
    JLabel label;

    ImageIcon background = new ImageIcon("ibm.png");


    public void run() throws InterruptedException {
        label = new JLabel();
        label.setIcon(background);
        label.setVisible(true);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,70));
        passwordField.setBorder(BorderFactory.createRaisedBevelBorder());
        passwordField.setFont(new Font("ARIAL",Font.PLAIN,50));
        passwordField.setVisible(false);
        passwordField.addActionListener(this);

        password = new JButton("SUBMIT");
        password.setBorder(BorderFactory.createRaisedBevelBorder());
        password.setPreferredSize(new Dimension(80,70));
        password.setVisible(false);
        password.addActionListener(this);

        //button insert the card
        button = new JButton("INSERT THE CARD");
        button.setFont(new Font("ARIAL",Font.BOLD,25));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addActionListener(this);
        button.setVisible(true);
        button.setPreferredSize(new Dimension(300,150));

        //withdraw button+input
        withdraw = new JButton("WITHDRAW CASH");
        withdraw.setPreferredSize(new Dimension(150,70));
        withdraw.setVisible(false);
        withdraw.setLocation(100,100);
        withdraw.setBorder(BorderFactory.createRaisedBevelBorder());
        withdraw.addActionListener(this);


        withdrawCash = new JTextField();
        withdrawCash.setPreferredSize(new Dimension(200,70));
        withdrawCash.setVisible(false);
        withdrawCash.setFont(new Font("ARIAL",Font.PLAIN,50));
        withdrawCash.setBorder(BorderFactory.createRaisedBevelBorder());
        withdrawCash.addActionListener(this);

        withdrawCashInput = new JButton("WITHDRAW CASH");
        withdrawCashInput.setPreferredSize(new Dimension(200,70));
        withdrawCashInput.setVisible(false);
        withdrawCashInput.setBorder(BorderFactory.createRaisedBevelBorder());
        withdrawCashInput.addActionListener(this);
        //withdrawCashInput.setFont(new Font("ARIAL",Font.PLAIN,50));

        //insert button +input
        insert = new JButton("INSERT CASH");
        insert.setPreferredSize(new Dimension(150,70));
        insert.setBorder(BorderFactory.createRaisedBevelBorder());
        insert.setVisible(false);
        insert.addActionListener(this);

        insertCash = new JTextField();
        insertCash.setPreferredSize(new Dimension(200,70));
        insertCash.setVisible(false);
        insertCash.setBorder(BorderFactory.createRaisedBevelBorder());
        insertCash.setFont(new Font("ARIAL",Font.PLAIN,50));
        insertCash.addActionListener(this);

        insertCashInput = new JButton("INSERT CASH");
        insertCashInput.setPreferredSize(new Dimension(200,70));
        insertCashInput.setVisible(false);
        insertCashInput.setBorder(BorderFactory.createRaisedBevelBorder());
        //insertCashInput.setFont(new Font("ARIAL",Font.PLAIN,50));
        insertCashInput.addActionListener(this);


        back = new JButton("STEP BACK");
        back.setPreferredSize(new Dimension(150,70));
        back.setBorder(BorderFactory.createRaisedBevelBorder());
        back.setVisible(false);
        back.addActionListener(this);

        //frame
        this.setSize(935,665);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(label);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,250));

        this.add(button);
        this.add(passwordField);
        this.add(password);
        this.add(withdraw);
        this.add(insert);
        this.add(insertCashInput);
        this.add(withdrawCashInput);
        this.add(insertCash);
        this.add(withdrawCash);
        this.add(back);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==button){

            button.setVisible(false);
            password.setVisible(true);
            passwordField.setVisible(true);

        }
        if(passwordField.getPassword().length >0){
            password.setVisible(false);
            passwordField.setVisible(false);
            if(e.getSource() == password){

                //withdrawCash.setVisible(true);
                insert.setVisible(true);
                withdraw.setVisible(true);
            }if(e.getSource()== insert){
                insertCash.setVisible(true);
                insert.setVisible(false);
                insertCashInput.setVisible(true);
                withdraw.setVisible(false);
                back.setVisible(true);

            }if(e.getSource() == withdraw){
                withdrawCash.setVisible(true);
                withdraw.setVisible(false);
                withdrawCashInput.setVisible(true);
                insert.setVisible(false);
                back.setVisible(true);
            }
        }
        if(e.getSource() == back){
            withdrawCash.setVisible(false);
            insertCash.setVisible(false);
            withdraw.setVisible(true);
            insert.setVisible(true);
            back.setVisible(false);
            insertCashInput.setVisible(false);
            withdrawCashInput.setVisible(false);



        }

        try {


            if (e.getSource() == withdrawCashInput && withdrawCash.getText().length() > 0) {
                String cislo = withdrawCash.getText();
                int number = Integer.parseInt(cislo);
                accountBalancel = accountBalancel - number;

                JOptionPane.showMessageDialog(null,accountBalancel+"$","AccountBalance",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"You can write only numbers!","ERROR",JOptionPane.ERROR_MESSAGE);

        }
        try{
            if(e.getSource() == insertCashInput && insertCash.getText().length() >0) {
                String cislo = insertCash.getText();
                int number = Integer.parseInt(cislo);
                accountBalancel = accountBalancel + number;



                JOptionPane.showMessageDialog(null,accountBalancel+"$","AccountBalance",JOptionPane.INFORMATION_MESSAGE);


            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"You can write only numbers!","ERROR",JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void main(String[] args) throws InterruptedException {
        IbmBankProject ibm = new IbmBankProject();
        ibm.run();
    }


}

