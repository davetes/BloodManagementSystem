package bloodbankmanagementsystems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class home extends JFrame {
    JMenuBar menuBar;
    JMenu donor;
    JMenu exit;
    JMenuItem add_new;
    JMenuItem donor_details;
    JMenuItem exit_item;
    JMenuItem logout;
    JPanel panel;
    JPanel ceterPanel;
    JLabel welcome;
    JLabel label;
    public home() {
        panel=new JPanel();
        ceterPanel=new JPanel();
        panel.setBackground(Color.RED);
       
        String description = "Objective for Blood Donation:\n\n"
        + "- Save lives by providing a vital resource to those in need.\n"
        + "- Help patients who require blood transfusions due to medical treatments, surgeries, or emergencies.\n"
        + "- Support medical research and advancements in blood-related conditions and diseases.\n"
        + "- Contribute to a cause that directly impacts the well-being of individuals and communities.";
        
 label = new JLabel("<html><h2><pre>" + description + "</pre></h2></html>");
 label.setFont(new Font("arial",Font.PLAIN,14));
        /* view = new CSVViewer();
        add(view); */
        welcome=new JLabel("Welcome to Blood Bank Managemt System");
        welcome.setFont((new Font("arial",Font.BOLD,45)));
       ceterPanel.add(label);
       add(ceterPanel);
     panel.add(welcome);
     add(panel,BorderLayout.NORTH);
        menuBar = new JMenuBar();
        donor = new JMenu("Donor");
        Font font= donor.getFont();
        donor.setFont(font.deriveFont(font.getSize()+5f));
        exit = new JMenu("Exit");
        exit.setFont(font.deriveFont(font.getSize() + 5f));
        add_new = new JMenuItem("add new");
     
        donor_details = new JMenuItem("all donors details");
        
        exit_item = new JMenuItem("exit");
        logout = new JMenuItem("logout");
        exit_item.addActionListener(new exitLisiner());
        logout.addActionListener(new logoutclass());
        add_new.addActionListener(new NewItem());

        donor_details.addActionListener(new detailsListener());
        donor.add(add_new);
       
        donor.add(donor_details);
        
        exit.add(exit_item);
        exit.add(logout);
        menuBar.add(donor);
        menuBar.add(exit);
        setJMenuBar(menuBar);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            home frame = new home();
            frame.setVisible(true);
        });
    }

    private class logoutclass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                setVisible(false);
                new login().setVisible(true);
            }
        }

    }

    private class exitLisiner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Select", JOptionPane.YES_NO_OPTION);

            if (a == 0)
                System.exit(0);
        }

    }

    private class NewItem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Donor();

        }

    }

    private class detailsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ceterPanel.removeAll();
            CSVViewer  view=new CSVViewer();
            ceterPanel.add(view);
            ceterPanel.revalidate();
            ceterPanel.repaint();
            JLabel label=new JLabel("list of blood donors and bloodtype");
            panel.removeAll();
            panel.add(label);
        panel.setBackground(Color.YELLOW);
            panel.revalidate();
            panel.repaint();
       
           

        }

    }
}
