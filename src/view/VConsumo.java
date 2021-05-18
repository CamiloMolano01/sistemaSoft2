package view;

import control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("ALL")
public class VConsumo extends JFrame {

    private ListenerC listener;
    private Control control;
    private VPrincipal vPrincipal;

    private JLabel jtitle;
    private JLabel labelCode;
    private JTextField textCode;
    private JButton buttonBack;
    private JButton buttonActual;
    private JButton buttonConsume;
    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private Font googleFont;
    private Font googleFont2;

    public VConsumo(Control control, VPrincipal vPrincipal) {
        /* Inicialización de los componenetes que pasan como paramentro, ademas del action listener local que funciona
           como una clase interna
        */
        this.control = control;
        listener = new ListenerC();
        this.vPrincipal = vPrincipal;

        /* Configuración del jframe basicos, como nombre, tamaño, si es o no posible cambiar su tamaño una vez ejecutado
           el tipo de layout, el color de fondo y el tipo de letra a usar
        */
        setTitle("SAC - Consumo");
        setIconImage(new ImageIcon("img/logo_uptc.png").getImage());
        setSize(800, 600);
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

        row3 = new JPanel();
        row3.setMaximumSize(new Dimension(800,30));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.setBackground(Color.WHITE);

        labelCode = new JLabel("Codigo:      ");
        labelCode.setFont(googleFont);

        textCode = new JTextField();
        textCode.setFont(googleFont2);
        textCode.setMaximumSize(new Dimension(250,100));

        row1.add(Box.createRigidArea(new Dimension(100, 0)));
        row1.add(labelCode);
        row1.add(Box.createRigidArea(new Dimension(50, 0)));
        row1.add(textCode);

        buttonBack = new JButton("Atras");
        buttonBack.addActionListener(listener);
        buttonBack.setActionCommand("atras");
        buttonBack.setHorizontalAlignment(JLabel.CENTER);
        buttonBack.setAlignmentX(CENTER_ALIGNMENT);
        buttonBack.setFont(googleFont2);
        buttonBack.setBackground(Color.WHITE);

        buttonActual = new JButton("Actual");
        buttonActual.addActionListener(listener);
        buttonActual.setActionCommand("actual");
        buttonActual.setHorizontalAlignment(JLabel.CENTER);
        buttonActual.setAlignmentX(CENTER_ALIGNMENT);
        buttonActual.setFont(googleFont);
        buttonActual.setBackground(Color.ORANGE);

        buttonConsume = new JButton("Consumir");
        buttonConsume.addActionListener(listener);
        buttonConsume.setActionCommand("cargar");
        buttonConsume.setHorizontalAlignment(JLabel.CENTER);
        buttonConsume.setAlignmentX(CENTER_ALIGNMENT);
        buttonConsume.setFont(googleFont);
        buttonConsume.setBackground(Color.ORANGE);

        row3.add(Box.createRigidArea(new Dimension(20, 0)));
        row3.add(buttonBack);
        row3.add(Box.createRigidArea(new Dimension(170, 0)));
        row3.add(buttonActual);
        row3.add(Box.createRigidArea(new Dimension(50, 0)));
        row3.add(buttonConsume);

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(800,100));

        jtitle = new JLabel("Consumo");
        jtitle.setHorizontalAlignment(JLabel.CENTER);
        jtitle.setFont(googleFont);

        upperPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        upperPanel.add(jtitle);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(upperPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        centerPanel.add(row1);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(row2);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 300)));
        centerPanel.add(row3);

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
                clean();
                close();
            } else if (act.equals("cargar")){
                control.addCredits(textCode.getText(), "-1");
                control.createRegister(String.valueOf("1"), "1",
                        vPrincipal.getId_user(), textCode.getText());
                JOptionPane.showMessageDialog(null, control.getCredits(textCode.getText()));
                clean();
            } else if (act.equals("actual")){
                JOptionPane.showMessageDialog(null, control.getCredits(textCode.getText()));
            }
        }
    }

    private void clean(){
        textCode.setText("");
    }
}

