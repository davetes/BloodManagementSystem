
package bloodbankmanagementsystems;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVViewer extends JPanel {
    private JTable table;

    public CSVViewer() {
       /*  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CSV Viewer"); */
       
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
       loadCSV("donors.csv");
        //setSize(400, 300);
        /* setLocationRelativeTo(null);
        setVisible(true); */
    }

    public void loadCSV(String filePath) {
        DefaultTableModel model = new DefaultTableModel();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (isFirstLine) {
                    model.setColumnIdentifiers(data);
                    isFirstLine = false;
                } else {
                    model.addRow(data);
                }
            }
            table.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CSVViewer viewer = new CSVViewer();
        viewer.loadCSV("donors.csv");
       // SwingUtilities.invokeLater(() -> viewer.setVisible(true));
    }
}