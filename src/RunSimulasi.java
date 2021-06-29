import javax.swing.*;

public class RunSimulasi {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("APLIKASI SIMULASI");
        jframe.setContentPane(new SimulasiUAS().getRootP());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(450,400);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
