package view;

import javax.swing.*;
import java.awt.*;

public class vLogin extends JFrame {

    private JLabel title;
    private JLabel welcome;
    private JLabel user;
    private JLabel pass;
    private JTextField userfield;
    private JPasswordField passfield;
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel row1;
    private JPanel row2;
    private JButton login;
    private Font googleFont;
    private Font googleFont2;

    public vLogin(){
        setTitle("Inicio Sesion");
        setSize(700, 500);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        googleFont = new Font("Open Sans", Font.BOLD, 25);
        googleFont2 = new Font("Open Sans", Font.BOLD, 15);

        welcome = new JLabel("Bienvenido");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setAlignmentX(CENTER_ALIGNMENT);
        welcome.setFont(googleFont);

        row1 = new JPanel();
        row1.setMaximumSize(new Dimension(700,30));
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.setBackground(Color.WHITE);

        row2 = new JPanel();
        row2.setMaximumSize(new Dimension(700,30));
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.setBackground(Color.WHITE);

        user = new JLabel("Usuario:      ");
        //user.setHorizontalAlignment(JLabel.CENTER);
        user.setFont(googleFont);

        userfield = new JTextField();
        //userfield.setHorizontalAlignment(JTextField.CENTER);
        userfield.setFont(googleFont2);
        userfield.setMaximumSize(new Dimension(250,100));

        row1.add(Box.createRigidArea(new Dimension(100, 0)));
        row1.add(user);
        row1.add(Box.createRigidArea(new Dimension(50, 0)));
        row1.add(userfield);

        pass = new JLabel("Contraseña:");
        //pass.setHorizontalAlignment(JLabel.CENTER);
        pass.setFont(googleFont);

        passfield = new JPasswordField();
        //passfield.setHorizontalAlignment(JPasswordField.CENTER);
        passfield.setFont(googleFont);
        passfield.setMaximumSize(new Dimension(250,50));

        row2.add(Box.createRigidArea(new Dimension(100, 0)));
        row2.add(pass);
        row2.add(Box.createRigidArea(new Dimension(50, 0)));
        row2.add(passfield);

        login = new JButton("Iniciar sesión");
        login.setHorizontalAlignment(JLabel.CENTER);
        login.setAlignmentX(CENTER_ALIGNMENT);
        login.setFont(googleFont);
        login.setBackground(Color.ORANGE);


        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(700,100));

        title = new JLabel("Sistema de Administración de Creditos - SAC");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(googleFont);

        upperPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        upperPanel.add(title);



        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(upperPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(welcome);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(row1);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(row2);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(login);

        add(centerPanel, BorderLayout.CENTER);
        //add(downPanel, BorderLayout.SOUTH);
        //add(panelsBar, BorderLayout.NORTH);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



}
