import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class Interface extends JFrame
{
    Kryptograph krypto = new Kryptograph();
    
    JCheckBox vig;
    JCheckBox cae;
    JCheckBox fak;
    JLabel lfak;
    JLabel lKlar;
    JLabel lGeheim;
    JTextField klar;
    JTextField geheim;
    JButton translate;
    
    public Interface()
    {
        setTitle("Verschlüssle deine Nachrichten");
        setBounds(300,200,600,600);
        setLayout(null);
        
        JLabel warn = new JLabel("Achtung, die Verfahren sind hier auf Großbuchstaben optimiert!", SwingConstants.CENTER);
        warn.setBounds(0, 20, 600, 30);
        warn.setForeground(Color.red);
        add(warn);
        
        lKlar = new JLabel("Klartext", SwingConstants.CENTER);
        lKlar.setBounds(200, 60, 200, 30);
        add(lKlar);
        
        klar = new JTextField();
        klar.setBounds(200, 100, 200, 30);
        add(klar);
        
        lGeheim = new JLabel("Geheimtext", SwingConstants.CENTER);
        lGeheim.setBounds(200, 200, 200, 30);
        add(lGeheim);
        
        geheim = new JTextField("");
        geheim.setBounds(200, 250, 200, 30);
        geheim.setEditable(false);
        add(geheim);
        
        translate = new JButton("Verschlüsseln");
        translate.setBounds(240, 150, 120, 30);
        translate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cae.isSelected()) {
                    geheim.setText(krypto.caeser(klar.getText()));
                } else if (vig.isSelected()) {
                    geheim.setText(krypto.vigenere(klar.getText()));
                }
                if (fak.isSelected()) {
                    lfak.setText(String.valueOf(krypto.getFak()));
                } else {
                    lfak.setText("-");
                }
            }
        });
        add(translate);
        
        JButton res = new JButton("Reset"); //Existierte zur Fehlersuche
        res.setBounds(240, 300, 120, 30);
        res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                geheim.setText("");
            }
        });
        add(res);
        
        fak = new JCheckBox("Schlüssel anzeigen: ");       
        fak.setBounds(230, 350, 150, 30);
        add(fak);
        
        lfak = new JLabel("-", SwingConstants.CENTER);
        lfak.setBounds(200, 380, 200, 30);
        lfak.setFont(new Font("Arial", Font.BOLD, 15));
        add(lfak);
        
        cae = new JCheckBox("Mit Caeser verschlüsseln");
        cae.setBounds(50, 420, 180, 30);
        cae.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vig.setSelected(false);
            }
        });
        add(cae);
        
        vig = new JCheckBox("Mit Vigenére verschlüsseln");
        vig.setBounds(370, 420, 180, 30);
        vig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cae.setSelected(false);
            }
        });
        add(vig);
        
        setVisible(true);
    }
    
}
