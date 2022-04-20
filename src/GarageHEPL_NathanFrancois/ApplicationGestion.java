package GarageHEPL_NathanFrancois;

import People.Customer;
import Vehicle.Car;
import Vehicle.CarType;
import javafx.scene.input.Mnemonic;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.PanelUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Hashtable;


import java.awt.*;


//extends javax.swing.JFrame
public class ApplicationGestion extends JDialog {
    private JTextField TF_Pont1;
    private JTextField TF_Pont2;
    private JTextField TF_Pont3;
    private JTextField TF_Sol;
    private JTextField TF_Divers;
    private JTextPane TP_Image;
    private JTextField TF_BureauClient;
    private JTextField TF_BureauCompta;
    private JCheckBox CB_Patron;
    private JRadioButton RB_Absent;
    private JCheckBox CB_Pause;
    private JRadioButton RB_Present;
    private JLabel Atelier;
    private JPanel applicationGestionPanel;
    private JTextField TF_Date;
    private JMenuBar MenuBar;

    static Authentification AuthentificationWindow;
    private boolean _visibility = false;
    public void setVisibility(boolean visible)
    {
        _visibility = visible;
    }
    public boolean getVisibility()
    {
        return _visibility;
    }
    private String _user;
    public void setUser(String user)
    {
        _user= user;
        this.setTitle("Garage HEPL - Authentification d'un utilisateur : "+ user);
    }

    public String getUser()
    {
        return _user;
    }

    Hashtable listCar;
    About AboutWindows;

    public ApplicationGestion(JFrame parent, boolean modal)
    {
        // ---------- //
        super(parent, modal);
        setTitle("Garage HEPL - Authentification d'un utilisateur");
        setContentPane(applicationGestionPanel);
        setMinimumSize(new Dimension(700, 400));
        setModal(modal);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // ---------- //

        //AboutWindows = (About)parent;

        JMenu M_Atelier = new JMenu("Atelier");
        JMenu M_Materiel = new JMenu("Materiel");
        JMenu M_Clients = new JMenu("Clients");
        JMenu M_Factures = new JMenu("Factures");
        JMenu M_Paramètres = new JMenu("Paramètres");
        JMenu M_Aide = new JMenu("Aide");

        JMenuItem MI_Prevoir = new JMenuItem("Prévoir");
        JMenuItem MI_PriseCharge = new JMenuItem("Prise En Charge");
        JMenuItem MI_Termine = new JMenuItem("Terminé");
        JMenuItem MI_Listes = new JMenuItem("Listes");
        JMenuItem MI_Infos = new JMenuItem("Infos Système");
        JMenuItem MI_Debuter = new JMenuItem("Pour Débuter");
        JMenuItem MI_APropos = new JMenuItem("A Propos");

        MI_Prevoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO OPEN WINDOW NewWork;
            }
        });

        MI_PriseCharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO OPEN WINDOW PriseEnChargeTravail;
            }
        });

        MI_APropos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO OPEN WINDOW About;
                AboutWindows.setVisible(true);
            }
        });

        M_Atelier.add(MI_Prevoir);
        M_Atelier.add(MI_PriseCharge);
        M_Atelier.add(MI_Termine);
        M_Atelier.add(MI_Listes);

        M_Paramètres.add(MI_Infos);

        M_Aide.add(MI_Debuter);
        M_Aide.add(MI_APropos);

        MenuBar.add(M_Atelier);
        MenuBar.add(M_Materiel);
        MenuBar.add(M_Clients);
        MenuBar.add(M_Factures);
        MenuBar.add(Box.createHorizontalGlue());
        MenuBar.add(M_Paramètres);
        MenuBar.add(M_Aide);


        Date today = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        TF_Date.setText(shortDateFormat.format(today));

        listCar = new Hashtable();

        CarType carType;
        Customer priorityCustomer;

        carType = new CarType("Ford", "Fiesta", 5);
        priorityCustomer = new Customer("Jean", "045655", 1);
        Car FordFiesta = new Car("FF", true, carType, priorityCustomer);

        carType = new CarType("Nissan", "Quashqai", 5);
        priorityCustomer = new Customer("Mich", "044255", 2);
        Car NissanQuashqai = new Car("NQ", false,  carType, priorityCustomer);

        listCar.put(FordFiesta.getRegistration(), FordFiesta);
        listCar.put(NissanQuashqai.getRegistration(), NissanQuashqai);

    }

    public ApplicationGestion()
    {
        listCar = new Hashtable();

        CarType carType;
        Customer priorityCustomer;

        carType = new CarType("Ford", "Fiesta", 5);
        priorityCustomer = new Customer("Jean", "045655", 1);
        Car FordFiesta = new Car("FF", true, carType, priorityCustomer);

        carType = new CarType("Nissan", "Quashqai", 5);
        priorityCustomer = new Customer("Mich", "044255", 2);
        Car NissanQuashqai = new Car("NQ", false,  carType, priorityCustomer);

        listCar.put(FordFiesta.getRegistration(), FordFiesta);
        listCar.put(NissanQuashqai.getRegistration(), NissanQuashqai);

    }




    // USE WITH extends javax.swing.JFrame
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable()
//        {
//            public void run()
//            {
//                ApplicationGestion MainWindow = new ApplicationGestion();
//
//                AuthentificationWindow = new Authentification(MainWindow,true);
//                AuthentificationWindow.setVisible(true);
//            }
//        });
//
//    }


    // Use for display solo
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationGestion dialog = new ApplicationGestion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                ApplicationGestion MainWindow = new ApplicationGestion();

//                AuthentificationWindow = new Authentification(MainWindow,true);
//                AuthentificationWindow.setVisible(true);
            }
        });
        ApplicationGestion applicationGestion = new ApplicationGestion(null, true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
