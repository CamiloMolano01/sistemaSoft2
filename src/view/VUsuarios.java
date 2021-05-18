package view;

import control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VUsuarios extends JFrame {

    private ListenerC listener;
    private Control control;
    private VPrincipal vPrincipal;

    private JLabel title;
    private JScrollPane scrollBar;
    private JTable tableUsers;

    private JButton buttonBack;

    private JPanel centerPanel;
    private JPanel upperPanel;
    private Font googleFont2;
    private JPanel row3;
    private Font googleFont;

    public VUsuarios(Control control, VPrincipal vPrincipal) {
        /* Inicialización de los componenetes que pasan como paramentro, ademas del action listener local que funciona
           como una clase interna*/
        this.control = control;
        listener = new ListenerC();
        this.vPrincipal = vPrincipal;

        /* Configuración del jframe basicos, como nombre, tamaño, si es o no posible cambiar su tamaño una vez ejecutado
           el tipo de layout, el color de fondo y el tipo de letra a usar*/
        setTitle("SAC - Usuarios");
        setIconImage(new ImageIcon("img/logo_uptc.png").getImage());
        setSize(800, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        String[][] datas = control.getUsers();
        String[] columnNames = { "ID", "Nombre Usuario", "Nombre", "Apellido", "Admin"};
        tableUsers = new JTable(datas, columnNames);
        tableUsers.setAlignmentX(CENTER_ALIGNMENT);
        tableUsers.setBackground(Color.WHITE);
        tableUsers.setMinimumSize(new Dimension(600, 700));
        tableUsers.setMaximumSize(new Dimension(600, 700));
        tableUsers.setPreferredSize(new Dimension(600, 700));

        scrollBar = new JScrollPane(tableUsers);
        scrollBar.setMinimumSize(new Dimension(600, 370));
        scrollBar.setMaximumSize(new Dimension(600, 370));
        scrollBar.setPreferredSize(new Dimension(600, 370));

        googleFont = new Font("Open Sans", Font.BOLD, 25);
        googleFont2 = new Font("Open Sans", Font.BOLD, 15);

        row3 = new JPanel();
        row3.setMaximumSize(new Dimension(800,30));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.setBackground(Color.WHITE);

        buttonBack = new JButton("Atras");
        buttonBack.addActionListener(listener);
        buttonBack.setActionCommand("atras");
        buttonBack.setHorizontalAlignment(JLabel.CENTER);
        buttonBack.setAlignmentX(CENTER_ALIGNMENT);
        buttonBack.setFont(googleFont2);
        buttonBack.setBackground(Color.WHITE);

        row3.add(Box.createRigidArea(new Dimension(20, 0)));
        row3.add(buttonBack);
        row3.add(Box.createRigidArea(new Dimension(500, 0)));

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(800, 100));

        title = new JLabel("Usuarios");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(googleFont);

        upperPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        upperPanel.add(title);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(upperPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(scrollBar);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(row3);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        add(centerPanel, BorderLayout.CENTER);

        /* Configuración de la posición del frame en la pantalla, ademas de su visibilidad, y la acción a ejercer al
           cerrar la ventana, que en este caso es parar la ejecución del programa.*/
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Permite cerrar la ventana y abrir la anterior principal
    private void close() {
        this.setVisible(false);
        vPrincipal.setVisible(true);
    }

    /* Clase interna que implementa el escucha de las acciones a ejecutar con los botones que se encuentran en la clase
    superior, por medio del uso de nombres para cada boton permite hacer una accion diferente*/
    public class ListenerC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();
            if (act.equals("atras")) {
                close();
            }
        }
    }
}
