import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FileDemoLoad extends JFrame implements ActionListener {
    private TextArea inputTextArea = new TextArea();
    private JButton loadButton = new JButton("Load");
    private JTextField txtFileName = new JTextField(20);


    public static void main(String[] args) {
        new FileDemoLoad();
    }


    public FileDemoLoad() {
        setSize(500, 500);
        setLayout(new BorderLayout());
        setTitle("File Input Demo");
        add("Center", inputTextArea);
        JPanel bottom = new JPanel();
        bottom.add(txtFileName);
        bottom.add(loadButton);

        add("South", bottom);
        loadButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (var inFile = new BufferedReader(new FileReader(txtFileName.getText()))) {
            inputTextArea.setText("");
            String line;
            while ((line = inFile.readLine()) != null) {
                inputTextArea.append(line + "\n");

            }

        } catch (IOException ex) {
            Helper.message("File cannot be found");

        } catch (Exception ex) {
            Helper.message(ex.getMessage());


        }

    }

}
