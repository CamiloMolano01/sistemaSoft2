package view;

import control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vPrincipal extends JFrame {

    private ListenerP listener;
    private Control control;
    private vLogin vLogin;

    private JLabel title;
    private JButton buttonCredits;
    private JButton buttonConsume;
    private JButton buttonGeneral;
    private JButton buttonIndividual;
    private JButton buttonMenu;
    private JButton buttonUsers;
    private JButton buttonExit;
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private Font googleFont;
    private Font googleFont2;

    public vPrincipal(Control control, vLogin vLogin){

        this.control = control;
        this.vLogin = vLogin;
        listener = new ListenerP();
        setTitle("Principal");
        setSize(700, 500);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        googleFont = new Font("Open Sans", Font.BOLD, 25);
        googleFont2 = new Font("Open Sans", Font.BOLD, 15);

        row1 = new JPanel();
        row1.setMaximumSize(new Dimension(700,30));
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.setBackground(Color.WHITE);


        row2 = new JPanel();
        row2.setMaximumSize(new Dimension(700,30));
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.setBackground(Color.WHITE);
        row2.setAlignmentX(CENTER_ALIGNMENT);

        row3 = new JPanel();
        row3.setMaximumSize(new Dimension(700,30));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.setBackground(Color.WHITE);
        row3.setAlignmentX(CENTER_ALIGNMENT);

        buttonCredits = new JButton("Creditos");
        buttonCredits.setActionCommand("creditos");
        buttonCredits.addActionListener(listener);
        buttonCredits.setFont(googleFont2);
        buttonCredits.setPreferredSize(new Dimension(180,30));
        buttonCredits.setMaximumSize(new Dimension(180,30));
        buttonCredits.setMinimumSize(new Dimension(180,30));
        buttonCredits.setBackground(Color.WHITE);

        buttonConsume = new JButton("Consumo");
        buttonConsume.setFont(googleFont2);
        buttonConsume.setPreferredSize(new Dimension(180,30));
        buttonConsume.setMaximumSize(new Dimension(180,30));
        buttonConsume.setMinimumSize(new Dimension(180,30));
        buttonConsume.setBackground(Color.WHITE);
        //buttonConsume.setMinimumSize(new Dimension(300,30));

        buttonGeneral = new JButton("Rep. General");
        buttonGeneral.setFont(googleFont2);
        buttonGeneral.setPreferredSize(new Dimension(180,30));
        buttonGeneral.setMaximumSize(new Dimension(180,30));
        buttonGeneral.setMinimumSize(new Dimension(180,30));
        buttonGeneral.setBackground(Color.WHITE);

        buttonIndividual = new JButton("Rep. Individual");
        buttonIndividual.setFont(googleFont2);
        buttonIndividual.setPreferredSize(new Dimension(180,30));
        buttonIndividual.setMaximumSize(new Dimension(180,30));
        buttonIndividual.setMinimumSize(new Dimension(180,30));
        buttonIndividual.setBackground(Color.WHITE);

        buttonMenu = new JButton("Menu");
        buttonMenu.setFont(googleFont2);
        buttonMenu.setPreferredSize(new Dimension(180,30));
        buttonMenu.setMaximumSize(new Dimension(180,30));
        buttonMenu.setMinimumSize(new Dimension(180,30));
        buttonMenu.setBackground(Color.WHITE);

        buttonUsers = new JButton("Usuarios");
        buttonUsers.setFont(googleFont2);
        buttonUsers.setPreferredSize(new Dimension(180,30));
        buttonUsers.setMaximumSize(new Dimension(180,30));
        buttonUsers.setMinimumSize(new Dimension(180,30));
        buttonUsers.setBackground(Color.WHITE);

        buttonExit = new JButton("Salir");
        buttonExit.setActionCommand("salir");
        buttonExit.addActionListener(listener);
        buttonExit.setFont(googleFont2);
        buttonExit.setAlignmentX(CENTER_ALIGNMENT);
        buttonExit.setBackground(Color.WHITE);

        row1.add(Box.createRigidArea(new Dimension(135, 0)));
        row1.add(buttonCredits);
        row1.add(Box.createRigidArea(new Dimension(70, 0)));
        row1.add(buttonConsume);

        row2.add(Box.createRigidArea(new Dimension(135, 0)));
        row2.add(buttonGeneral);
        row2.add(Box.createRigidArea(new Dimension(70, 0)));
        row2.add(buttonIndividual);

        row3.add(Box.createRigidArea(new Dimension(135, 0)));
        row3.add(buttonMenu);
        row3.add(Box.createRigidArea(new Dimension(70, 0)));
        row3.add(buttonUsers);

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(700,100));

        title = new JLabel("Página Principal");
        //title.setHorizontalAlignment(JLabel.RIGHT);
        //title.setAlignmentX(RIGHT_ALIGNMENT);
        title.setFont(googleFont);

        upperPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        upperPanel.add(title);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(upperPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(row1);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(row2);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(row3);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(buttonExit);

        add(centerPanel, BorderLayout.CENTER);
        //add(downPanel, BorderLayout.SOUTH);
        //add(panelsBar, BorderLayout.NORTH);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void close(){
        this.setVisible(false);
        vLogin.setVisible(true);
    }

    private void openCredits(){
        this.setVisible(false);
        new vCredits(control, this);
    }

    public class ListenerP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();

            //button.setActionCommand("createUser");
            //button.addActionListener(window.getEvents());
            if (act.equals("salir")) {
                close();
            } else if (act.equals("creditos")) {
                openCredits();

            }
        }
    }

}

