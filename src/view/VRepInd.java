package view;

import control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("ALL")
//Instancia de la clase como un frame de la libreria java swing
public class VRepInd extends JFrame {

    private ListenerC listener;
    private Control control;
    private VPrincipal vPrincipal;

    private JLabel title;
    private JButton buttonCredits;

    private JLabel labelCode;
    private JTextField textCode;
    private JButton buttonBack;
    private JButton buttonCharge;
    private JLabel dataP;
    private JLabel data;

    private JPanel centerPanel;
    private JPanel upperPanel;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private Font googleFont;
    private Font googleFont2;

    public VRepInd(Control control, VPrincipal vPrincipal) {
        /* Inicialización de los componenetes que pasan como paramentro, ademas del action listener local que funciona
           como una clase interna
        */
        this.control = control;
        listener = new ListenerC();
        this.vPrincipal = vPrincipal;

        /* Configuración del jframe basicos, como nombre, tamaño, si es o no posible cambiar su tamaño una vez ejecutado
           el tipo de layout, el color de fondo y el tipo de letra a usar
        */
        setTitle("SAC - Reporte individual");
        setIconImage(new ImageIcon("img/logo_uptc.png").getImage());
        setSize(800, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        googleFont = new Font("Open Sans", Font.BOLD, 25);
        googleFont2 = new Font("Open Sans", Font.BOLD, 15);

        row1 = new JPanel();
        row1.setMaximumSize(new Dimension(800,30));
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.setBackground(Color.WHITE);

        row2 = new JPanel();
        row2.setMaximumSize(new Dimension(800,50));
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.setBackground(Color.WHITE);

        row3 = new JPanel();
        row3.setMaximumSize(new Dimension(800,50));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.setBackground(Color.WHITE);

        labelCode = new JLabel("Codigo:      ");
        labelCode.setFont(googleFont);

        data = new JLabel("");
        data.setFont(googleFont2);
        data.setPreferredSize(new Dimension(580,250));

        dataP = new JLabel("Datos: ");
        dataP.setFont(googleFont);
        dataP.setPreferredSize(new Dimension(100,250));

        textCode = new JTextField();
        textCode.setFont(googleFont2);
        textCode.setMaximumSize(new Dimension(250,100));

        row1.add(Box.createRigidArea(new Dimension(170, 0)));
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

        buttonCharge = new JButton("Cargar estudiante");
        buttonCharge.addActionListener(listener);
        buttonCharge.setActionCommand("cargar");
        buttonCharge.setHorizontalAlignment(JLabel.CENTER);
        buttonCharge.setAlignmentX(CENTER_ALIGNMENT);
        buttonCharge.setFont(googleFont);
        buttonCharge.setBackground(Color.ORANGE);

        row2.add(Box.createRigidArea(new Dimension(20, 0)));
        row2.add(buttonBack);
        row2.add(Box.createRigidArea(new Dimension(250, 0)));
        row2.add(buttonCharge);

        row3.add(Box.createRigidArea(new Dimension(170, 0)));
        row3.add(dataP);
        row3.add(Box.createRigidArea(new Dimension(100, 0)));
        row3.add(data);

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(800,100));

        title = new JLabel("                                                             Reportes Individuales");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(googleFont);

        upperPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        upperPanel.add(title);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(upperPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(row1);
        centerPanel.add(row3);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 250)));
        centerPanel.add(row2);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

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

    private void putData(String code){
        ArrayList<String> dat = (ArrayList<String>) control.getData(code);
        String totalBuy = control.getBuyCredEst(code);
        String totalConsume = control.getConsumeCredEst(code);
        data.setText("<html>Nombre: " + dat.get(1) + " " + dat.get(2) + "<br>" +
                "Cantidad Creditos: " + dat.get(3) + "<br>" + "Comprados total: " + totalBuy + "<br>" +
                "Consumos total: " + totalConsume + "</html>");
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
                putData(textCode.getText());
                //control.addCredits(textCode.getText(), "-1");
                //JOptionPane.showMessageDialog(null, control.getCredits(textCode.getText()));
            } else if (act.equals("actual")){
                JOptionPane.showMessageDialog(null, control.getCredits(textCode.getText()));
            }
        }
    }

    private void clean(){
        textCode.setText("");
    }

}
