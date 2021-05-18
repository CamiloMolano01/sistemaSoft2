package view;

import com.toedter.calendar.JDateChooser;
import control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("ALL")
//Instancia de la clase como un frame de la libreria java swing
public class VRepGen extends JFrame {

    private ListenerC listener;
    private Control control;
    private VPrincipal vPrincipal;

    private JLabel title;
    private JButton buttonCredits;

    private JLabel labelStart;
    private JLabel labelEnd;
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
    private JPanel row4;
    private Font googleFont;
    private Font googleFont2;
    private JDateChooser dateChooser;
    private JDateChooser dateChooser2;
    private JScrollPane jp;

    public VRepGen(Control control, VPrincipal vPrincipal) {
        /* Inicialización de los componenetes que pasan como paramentro, ademas del action listener local que funciona
           como una clase interna
        */
        this.control = control;
        listener = new ListenerC();
        this.vPrincipal = vPrincipal;

        /* Configuración del jframe basicos, como nombre, tamaño, si es o no posible cambiar su tamaño una vez ejecutado
           el tipo de layout, el color de fondo y el tipo de letra a usar*/
        setTitle("SAC - Reporte General");
        setIconImage(new ImageIcon("img/logo_uptc.png").getImage());
        setSize(800, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        googleFont = new Font("Open Sans", Font.BOLD, 25);
        googleFont2 = new Font("Open Sans", Font.BOLD, 15);

        row1 = new JPanel();
        row1.setMaximumSize(new Dimension(800, 30));
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.setBackground(Color.WHITE);

        row2 = new JPanel();
        row2.setMaximumSize(new Dimension(800, 50));
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.setBackground(Color.WHITE);

        row3 = new JPanel();
        row3.setMaximumSize(new Dimension(800, 50));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.setBackground(Color.WHITE);

        row4 = new JPanel();
        row4.setMaximumSize(new Dimension(800, 50));
        row4.setLayout(new BoxLayout(row4, BoxLayout.X_AXIS));
        row4.setBackground(Color.WHITE);

        labelStart = new JLabel("Fecha Inicio:      ");
        labelStart.setFont(googleFont);

        labelEnd = new JLabel("Fecha Fin:          ");
        labelEnd.setFont(googleFont);

        dateChooser = new JDateChooser();
        dateChooser.setMaximumSize(new Dimension(250, 100));
        dateChooser.setMaxSelectableDate(new Date());

        dateChooser2 = new JDateChooser();
        dateChooser2.setMaximumSize(new Dimension(250, 100));
        dateChooser2.setMaxSelectableDate(new Date());

        data = new JLabel("");
        data.setFont(googleFont2);
        //data.setPreferredSize(new Dimension(300, 400));
        data.setBackground(Color.WHITE);
        data.setHorizontalAlignment(SwingConstants.CENTER);

        dataP = new JLabel("Datos: ");
        dataP.setFont(googleFont);
        dataP.setPreferredSize(new Dimension(100, 250));

        textCode = new JTextField();
        textCode.setFont(googleFont2);
        textCode.setMaximumSize(new Dimension(250, 100));

        buttonBack = new JButton("Atras");
        buttonBack.addActionListener(listener);
        buttonBack.setActionCommand("atras");
        buttonBack.setHorizontalAlignment(JLabel.CENTER);
        buttonBack.setAlignmentX(CENTER_ALIGNMENT);
        buttonBack.setFont(googleFont2);
        buttonBack.setBackground(Color.WHITE);

        buttonCharge = new JButton("Cargar Registros");
        buttonCharge.addActionListener(listener);
        buttonCharge.setActionCommand("cargar");
        buttonCharge.setHorizontalAlignment(JLabel.CENTER);
        buttonCharge.setAlignmentX(CENTER_ALIGNMENT);
        buttonCharge.setFont(googleFont);
        buttonCharge.setBackground(Color.ORANGE);

        row2.add(Box.createRigidArea(new Dimension(20, 0)));
        row2.add(buttonBack);
        row2.add(Box.createRigidArea(new Dimension(200, 0)));
        row2.add(buttonCharge);
        row2.add(Box.createRigidArea(new Dimension(100, 0)));


        jp = new JScrollPane(data);
        jp.setPreferredSize(new Dimension(350, 220));
        jp.setMaximumSize(new Dimension(350, 220));
        jp.setMinimumSize(new Dimension(350, 220));
        jp.setBackground(Color.WHITE);

        row3.add(Box.createRigidArea(new Dimension(160, 0)));
        row3.add(dataP);
        row3.add(Box.createRigidArea(new Dimension(10, 0)));
        row3.add(jp);

        row1.add(Box.createRigidArea(new Dimension(160, 0)));
        row1.add(labelStart);
        row1.add(Box.createRigidArea(new Dimension(10, 0)));
        row1.add(dateChooser);

        row4.add(Box.createRigidArea(new Dimension(160, 0)));
        row4.add(labelEnd);
        row4.add(Box.createRigidArea(new Dimension(8, 0)));
        row4.add(dateChooser2);
        //row4.add(Box.createRigidArea(new Dimension(313, 0)));
        //row4.add(dateChooser);

        upperPanel = new JPanel();
        upperPanel.setBackground(Color.orange);
        upperPanel.setMaximumSize(new Dimension(800, 100));

        title = new JLabel("Reportes Individuales");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(googleFont);

        upperPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        upperPanel.add(title);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setMaximumSize(new Dimension(800, 400));

        centerPanel.add(upperPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(row1);
        centerPanel.add(row4);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(row3);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 70)));
        centerPanel.add(row2);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

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
    private void close() {
        this.setVisible(false);
        vPrincipal.setVisible(true);
    }

    private void putData(String date, String date2) {
        /*Cantidad Consumidos Almuerzo
          Cantidad Consumidos Cena
          Cantidad Comprados
         */
        if (date2.isEmpty()) {
            String dat = control.getDataGeneralC(date, date);
            String dat2 = control.getDataGeneralV(date, date);
            data.setText("<html>Comprados total: " + dat2 + "<br>" +
                    "Consumos total: " + dat + "</html>");

        } else {
            String dat = control.getDataGeneralC(date, date2);
            String dat2 = control.getDataGeneralV(date, date2);
            data.setText("<html>Comprados total: " + dat2 + "<br>" +
                    "Consumos total: " + dat + "</html>");
        }
    }

    /* Clase interna que implementa el escucha de las acciones a ejecutar con los botones que se encuentran en la clase
    superior, por medio del uso de nombres para cada boton permite hacer una accion diferente*/
    public class ListenerC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();

            if (act.equals("atras")) {
                close();
            } else if (act.equals("cargar")) {

                if (dateChooser.getDate() != null) {
                    java.sql.Date date = new java.sql.Date(dateChooser.getDate().getTime());
                    if (dateChooser2.getDate() != null) {
                        java.sql.Date date2 = new java.sql.Date(dateChooser2.getDate().getTime());
                        putData(date.toString(), date2.toString());
                    } else {
                        putData(date.toString(), "");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione la primera fecha");
                }
                //control.addCredits(textCode.getText(), "-1");
                //JOptionPane.showMessageDialog(null, control.getCredits(textCode.getText()));
            } else if (act.equals("actual")) {
                JOptionPane.showMessageDialog(null, control.getCredits(textCode.getText()));
            }
        }
    }

    private void clean() {
        JOptionPane.showMessageDialog(null, "No hay registros");
        data.setText("");
        textCode.setText("");
    }

}
