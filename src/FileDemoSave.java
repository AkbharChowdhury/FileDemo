import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.StringTemplate.STR;

public class FileDemoSave extends JFrame implements ActionListener {
    private String fileName = "file.txt";
    private TextArea inputTextArea = new TextArea();
    private JButton saveButton = new JButton("Save");

    public FileDemoSave() {
        setSize(300, 300);
        setTitle("File Output Demo");
        add("Center", inputTextArea);
        JPanel bottom = new JPanel();
        bottom.add(saveButton);
        add("South", bottom);
        saveButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new FileDemoSave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inputTextArea.getText().isBlank()) {
            Helper.errorMessage("Field cannot be blank");
            return;
        }
        try (var outFile = new FileWriter(fileName, true)) {

            outFile.write(inputTextArea.getText());
            Helper.message(STR. "your file has been saved as \{ fileName }" );
        } catch (IOException io) {
            Helper.errorMessage("there was an error saving the file");


        }

    }
}
