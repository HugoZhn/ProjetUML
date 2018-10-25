package vue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.*;

import utilitaire.OldDataExtractor;
import utilitaire.Date;
import utilitaire.TimeParser;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import model.*;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.Icon;
import java.awt.Label;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.ScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueClassement {

    private JFrame frame;
    private JTable table;
    private JTextField txtHttpffragfrclassementdfinitifrallye;
    private JTextField txtSearch;
    private JTable table_1;
    private TableModel data;
    private TableColumnModel entetes;
    private JTable table_2;
    private Edition editionConcerne;

    public VueClassement(Edition[] classementEditions) {

        frame = new JFrame();
        frame.setBounds(100, 100, 971, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        txtHttpffragfrclassementdfinitifrallye = new JTextField();
        txtHttpffragfrclassementdfinitifrallye.setEditable(false);
        txtHttpffragfrclassementdfinitifrallye.setText("https://FFRAG.fr/classementDefinitifRallye.html");
        txtHttpffragfrclassementdfinitifrallye.setBounds(144, 34, 432, 20);
        frame.getContentPane().add(txtHttpffragfrclassementdfinitifrallye);
        txtHttpffragfrclassementdfinitifrallye.setColumns(10);

        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Cambria", Font.ITALIC, 12));
        txtSearch.setText("search");
        txtSearch.setBounds(624, 34, 61, 20);
        frame.getContentPane().add(txtSearch);
        txtSearch.setColumns(10);

        JLabel lblNewLabel = new JLabel(new ImageIcon(".\\img\\fd25.png"));
        lblNewLabel.setText("");
        lblNewLabel.setForeground(new Color(0, 0, 205));
        lblNewLabel.setBackground(new Color(199, 21, 133));
        lblNewLabel.setBounds(34, 34, 48, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel(new ImageIcon(".\\img\\fg25.png"));
        label.setText("");
        label.setForeground(new Color(0, 0, 205));
        label.setBackground(new Color(199, 21, 133));
        label.setBounds(0, 34, 48, 20);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(".\\img\\accueil50.png"));
        label_1.setBounds(77, 0, 57, 56);
        frame.getContentPane().add(label_1);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(".\\img\\chercher40.png"));
        lblNewLabel_1.setBounds(698, 24, 48, 40);
        frame.getContentPane().add(lblNewLabel_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(212, 135, 534, 255);
        frame.getContentPane().add(scrollPane_1);

        table_2 = new JTable();
        table_2.setColumnSelectionAllowed(true);
        table_2.setCellSelectionEnabled(true);
        table_2.setFont(new Font("Cambria", Font.PLAIN, 12));
        table_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table_2.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Position", "Participant", "Temps"
                }
        ));
        scrollPane_1.setViewportView(table_2);

        Label label_2 = new Label("Classement d\u00E9finitif");
        label_2.setBounds(341, 75, 221, 22);
        frame.getContentPane().add(label_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 167, 145, 83);
        frame.getContentPane().add(scrollPane);

        //Afficher le nom des rallyes dans une liste
        Object[] listeRallye = null;
        
        listeRallye = new Object[]{classementEditions[0].getEditionDe().getNomRallye(), classementEditions[1].getEditionDe().getNomRallye()};

        //Crꢴion de la liste
        JList list_1 = new JList(listeRallye);
        scrollPane.setViewportView(list_1);
        list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_1.setLayoutOrientation(JList.VERTICAL);

        JLabel lbl_2 = new JLabel();
        lbl_2.setBounds(341, 103, 130, 20);
        frame.getContentPane().add(lbl_2);

        //Rꤵp곥r la valeur sꭥctionnꥠdans la liste
        list_1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                lbl_2.setText((String) list_1.getSelectedValue()); //nomRallye    		 
            }
        });

        //Crꢴion du bouton classement
        JButton btnClassement = new JButton("Classement");
        btnClassement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i;
                Participant participant = null;
                double temps = 0;

                //Rꪮitialiser le tableau ࡳa valeur de d걡rt sur chaque clic
                table_2.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Position", "Participant", "Temps"}
                ));
                scrollPane_1.setViewportView(table_2);

                DefaultTableModel model = (DefaultTableModel) table_2.getModel();
                //Object[] edition = {list_1.getSelectedValue()} ;

                for (Edition ed : classementEditions) {
                    if (ed.getEditionDe().getNomRallye().equals(list_1.getSelectedValue())) {
                        for (i = 0; i < ed.getClassement().size(); i++) {
                            participant = ed.getClassement().get(i);
                            temps = ed.getClassement().get(i).getTempsFinal();
                            TimeParser joliTemps = new TimeParser(temps);
                            Object[] row = {i + 1, participant, joliTemps};
                            model.addRow(row);
                        }
                    }
                }
            }
        }
        );

        btnClassement.setBounds(437, 440, 139, 23);
        frame.getContentPane().add(btnClassement);
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
