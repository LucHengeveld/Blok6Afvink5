// Alles importeren
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Afvink5Opdr1 extends JFrame implements ActionListener {
    // Variabelen aanmaken
    public JTextArea textarea1, textarea2, textarea3, textarea4;
    public JPanel panel;
    public JFrame frame;
    public JLabel label;
    public JButton bereken;
    public String[] dropdownkeuze = {"Overeenkomst alle 3", "Overeenkomst 1 & 2", "Overeenkomst 2 & 3", "Overeenkomst 1 & 3"};
    public static HashSet<String> hashtekstvak1 = new HashSet<>();
    public static HashSet<String> hashtekstvak2 = new HashSet<>();
    public static HashSet<String> hashtekstvak3 = new HashSet<>();
    public static JComboBox<String> dropdown;

    // Aanmaken frame en createGUI hieraan toevoegen en aanroepen
    public static void main(String[] args) {
        Afvink5Opdr1 frame = new Afvink5Opdr1();
        frame.createGUI();
    }

    // Maakt de GUI aan met de label, textarea's, dropdown menu en button.
    // Als er op calculate wordt geklikt, worden de gelecteerde textarea's met elkaar vergeleken.
    private void createGUI() {
        frame = new JFrame("Afvink 5 Opdracht 1 Luc Hengeveld");
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane();

        label = new JLabel("Voer de genen in om de overlap te berekenen");
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.insets = new Insets(0,0,10,0);
        panel.add(label, c);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        textarea1 = new JTextArea();
        textarea1.setWrapStyleWord(true);
        textarea1.setLineWrap(true);
        textarea1.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(
                10, 10, 10, 10)));
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(textarea1, c);

        textarea2 = new JTextArea();
        textarea2.setWrapStyleWord(true);
        textarea2.setLineWrap(true);
        textarea2.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(
                10, 10, 10, 10)));
        c.gridx = 1;
        panel.add(textarea2, c);

        textarea3 = new JTextArea();
        textarea3.setWrapStyleWord(true);
        textarea3.setLineWrap(true);
        textarea3.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(
                10, 10, 10, 10)));
        c.gridx = 2;
        panel.add(textarea3, c);

        dropdown = new JComboBox<>(dropdownkeuze);
        dropdown.setBackground(Color.WHITE);
        dropdown.addActionListener(this);
        c.insets = new Insets(10,0,0,0);
        c.gridwidth = 3;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(dropdown, c);

        bereken = new JButton();
        bereken.setText("Calculate");
        c.insets = new Insets(10,0,0,0);
        c.gridx = 0;
        c.gridy = 3;
        c.ipady = 13;
        bereken.addActionListener(this); //koppel actionlistener
        panel.add(bereken, c);

        textarea4 = new JTextArea();
        textarea4.setWrapStyleWord(true);
        textarea4.setLineWrap(true);
        textarea4.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(
                10, 10, 10, 10)));
        c.insets = new Insets(10,0,0,0);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        panel.add(textarea4, c);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(625, 450);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Haalt waarde van dropdown menu op
        String keuze = dropdown.getItemAt(dropdown.getSelectedIndex());

        // Als op calculate wordt geklikt word de informatie van de verschillende textarea's opgeslagen in HashSets.
        // Deze hashsets worden vervolgens vergeleken met elkaar en de overeenkomsten worden in een arraylist opgeslagen.
        // De overeenkomsten worden toegevoegd aan de textarea onderaan de GUI.
        if (e.getSource() == bereken) {
            textarea4.setText("");

            ArrayList<String> overeenkomst = new ArrayList<>();
            String[] tekstvak1 = textarea1.getText().split("\n");
            String[] tekstvak2 = textarea2.getText().split("\n");
            String[] tekstvak3 = textarea3.getText().split("\n");

            hashtekstvak1.addAll(Arrays.asList(tekstvak1));
            hashtekstvak2.addAll(Arrays.asList(tekstvak2));
            hashtekstvak3.addAll(Arrays.asList(tekstvak3));

            switch (keuze) {
                case "Overeenkomst alle 3":
                    for (String i : hashtekstvak1) {
                        if (hashtekstvak2.contains(i) & hashtekstvak3.contains(i)) {
                            overeenkomst.add(i);
                        }
                    }

                    break;
                case "Overeenkomst 1 & 2":
                    for (String i : hashtekstvak1) {
                        if (hashtekstvak2.contains(i)) {
                            overeenkomst.add(i);
                        }
                    }

                    break;
                case "Overeenkomst 2 & 3":
                    for (String i : hashtekstvak2) {
                        if (hashtekstvak3.contains(i)) {
                            overeenkomst.add(i);
                        }
                    }

                    break;
                case "Overeenkomst 1 & 3":
                    for (String i : hashtekstvak1) {
                        if (hashtekstvak3.contains(i)) {
                            overeenkomst.add(i);
                        }
                    }
                    break;
            }
            for (String s : overeenkomst) {
                textarea4.append(s + "\n");
            }
        }
    }
}