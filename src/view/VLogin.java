package view;

import control.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("ALL")
public class VLogin extends JFrame {

    private ListenerLogin listener;
    private Control control;
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

    public VLogin(Control control){

        /* Inicialización de los componenetes que pasan como paramentro, ademas del action listener local que funciona
           como una clase interna
        */
        this.control = control;
        listener = new ListenerLogin();

        /* Configuración del jframe basicos, como nombre, tamaño, si es o no posible cambiar su tamaño una vez ejecutado
           el tipo de layout, el color de fondo y el tipo de letra a usar
        */
        setTitle("SAC - Inicio Sesion");
        setIconImage(new ImageIcon("img/logo_uptc.png").getImage());
        setSize(800, 600);
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
        user.setFont(googleFont);

        userfield = new JTextField();
        userfield.setFont(googleFont2);
        userfield.setMaximumSize(new Dimension(250,100));

        row1.add(Box.createRigidArea(new Dimension(100, 0)));
        row1.add(user);
        row1.add(Box.createRigidArea(new Dimension(50, 0)));
        row1.add(userfield);

        pass = new JLabel("Contraseña:");
        pass.setFont(googleFont);

        passfield = new JPasswordField();
        passfield.setFont(googleFont);
        passfield.setMaximumSize(new Dimension(250,50));

        row2.add(Box.createRigidArea(new Dimension(100, 0)));
        row2.add(pass);
        row2.add(Box.createRigidArea(new Dimension(50, 0)));
        row2.add(passfield);

        login = new JButton("Iniciar sesión");
        login.addActionListener(listener);
        login.setHorizontalAlignment(JLabel.CENTER);
        login.setAlignmentX(CENTER_ALIGNMENT);
        login.setFont(googleFont);
        login.setBackground(Color.ORANGE);


        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(800,100));

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

        /* Configuración de la posición del frame en la pantalla, ademas de su visibilidad, y la acción a ejercer al
           cerrar la ventana, que en este caso es parar la ejecución del programa.
         */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Permite cerrar la ventana y abrir la anterior principal
    private void close(){
        userfield.setText("");
        passfield.setText("");
        new VPrincipal(control, this);
        setVisible(false);
    }

    // Clase interna que implementa el escucha de las acciones a ejecutar con el boton que se encuentra en la clase
    public class ListenerLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(control.login(userfield.getText(), String.valueOf(passfield.getPassword()))){
                close();
            }
        }
    }

}
