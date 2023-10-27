import javax.swing.*;

public class Helper {
    private Helper() {

    }

    public static void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);

    }
    public static void message(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
}
