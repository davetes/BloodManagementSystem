package bloodbankmanagementsystems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Donor extends JFrame {
    FileWriter file;
    BufferedWriter buffer;
    String gdr[] = { "female", "male", "customer" };
    String bloodgroup[] = { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
    JLabel info;
    JLabel name;
    JLabel health;
    JLabel weight;
    JLabel age;
      JLabel blood;
    JLabel gen;
    JComboBox<String> bloodtype;
    JComboBox<String> gender;
    JTextField namTextField;
    JTextField healthfield;
    JTextField weightfield;
    JTextField agefield;
    JButton save;
    JButton reset;
    Font font1;
    Font font2;
    GridBagLayout grid;
    GridBagConstraints contstraint;
    Dimension dimension;

    public Donor() {
        Font amharicFont = new Font("Nyala", Font.PLAIN, 20);
        setTitle("donor information");
        dimension = new Dimension(210, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        font1 = new Font("arial", Font.BOLD, 29);
       font2 = new Font("arial", Font.PLAIN, 20);

        getContentPane().setBackground(new Color(173, 216, 230));
        info = new JLabel("INFROMATION OF A DONOR");
        info.setFont(font1);
        info.setForeground(Color.red);
        name = new JLabel("<html><body>username<br>ስም<body><html>");
        name.setFont(amharicFont);
        health = new JLabel("<html><body>health<br>ጤና<body><html>");
        health.setFont(amharicFont);
        weight = new JLabel("<html>weight<body><br>ክብድት<body><html>");
        weight.setFont(amharicFont);
        weightfield = new JTextField();
        weightfield.setFont(font2);
        weightfield.setPreferredSize(dimension);
        age = new JLabel("<html><body>age<br>እድሜ<body><html>");
        age.setFont(amharicFont);
        namTextField = new JTextField();
        namTextField.setFont(font2);
        namTextField.setPreferredSize(dimension);
        healthfield = new JTextField();
        healthfield.setFont(font2);
        healthfield.setPreferredSize(dimension);
        bloodtype = new JComboBox<>(bloodgroup);

        gender = new JComboBox<>(gdr);
        gender.setFont(font2);
        blood = new JLabel("<html><body>bloodType<br>የደም አይነት<body><html>");
        blood.setFont(amharicFont);
        grid = new GridBagLayout();
        gen = new JLabel("<html><body>gender<br>ጾታ<body>");
        gen.setFont(amharicFont);
        agefield = new JTextField();
        agefield.setFont(font2);
        agefield.setPreferredSize(dimension);
        save = new JButton("save");
        save.setFont(font2);
        reset = new JButton("reset");
        reset.addActionListener(new resetListner());
        reset.setFont(font2);

        try {
            file = new FileWriter("donors.csv", true);
            buffer = new BufferedWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        save.addActionListener(new namesaver());

        setLayout(grid);
        contstraint = new GridBagConstraints();
        contstraint.gridx = 0;
        contstraint.gridy = 0;
        contstraint.gridwidth = 10;
        contstraint.insets = new Insets(10, 10, 10, 10);
        add(info, contstraint);

        contstraint.gridx = 0;
        contstraint.gridy = 1;
        contstraint.gridwidth = 1;
        add(name, contstraint);

        contstraint.gridx = 0;
        contstraint.gridy = 2;
        add(health, contstraint);
        contstraint.gridx = 0;
        contstraint.gridy = 3;
        add(weight, contstraint);

        contstraint.gridx = 0;
        contstraint.gridy = 4;
        add(age, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 1;
        add(namTextField, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 2;
        add(healthfield, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 3;
        add(weightfield, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 4;
        add(agefield, contstraint);

        contstraint.gridx = 0;
        contstraint.gridy = 5;
        add(gen, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 5;
        add(gender, contstraint);

        contstraint.gridx = 0;
        contstraint.gridy = 6;
        add(blood, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 6;
        add(bloodtype, contstraint);

        Dimension comboBoxSize = new Dimension(210, 30);
        bloodtype.setPreferredSize(comboBoxSize);
        gender.setPreferredSize(comboBoxSize);
        contstraint.gridx = 0;
        contstraint.gridy = 7;
        contstraint.insets = new Insets(10, 40, 10, 30);
        add(save, contstraint);

        contstraint.gridx = 1;
        contstraint.gridy = 7;
        add(reset, contstraint);

        setSize(450, 550);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Donor();
    }

    private class namesaver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = namTextField.getText();
            String healthtext = healthfield.getText();
            String weights = weightfield.getText();
            String ff = agefield.getText();
            String genderText = (String) gender.getSelectedItem();
            String bloodTypeText = (String) bloodtype.getSelectedItem();

            if (healthtext.isEmpty() || weights.isEmpty() || ff.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "fill all neccesary info");
                return;
            }

            try {
                double pound = Double.parseDouble(weights);
                double ages = Double.parseDouble(ff);
                if ((pound > 50) && (ages > 18)) {
                    buffer.write(name + "," + healthtext + "," + weights + "," + ff + "," + genderText + ","
                            + bloodTypeText + "\n");
                    buffer.flush();
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "the file loaded successfully!");

                }
                else{
                    JOptionPane.showMessageDialog(null, "this person not eligible to donate blood");


                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "file not found", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException r) {
                JOptionPane.showMessageDialog(null, "Invalid input ");

            }
        }
    }

    private class resetListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            namTextField.setText("");
            healthfield.setText("");
            weightfield.setText("");
            agefield.setText("");
        }

    }
}
