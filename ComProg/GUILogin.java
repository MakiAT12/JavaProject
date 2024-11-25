import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GUILogin implements ActionListener {

    private static JLabel user;
    private static JLabel pass;
    private static JLabel success;
    private static JTextField userText;
    private static JPasswordField passText;
    private static JButton button;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Haggai Bayot");
        JPanel panel = new JPanel();

        frame.setSize(300, 300);
        frame.setForeground(Color.RED);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);

        user = new JLabel("User");
        user.setBounds(10, 20, 80, 25);
        panel.add(user);

        userText = new JTextField();
        userText.setBounds(60, 20, 165, 25);
        panel.add(userText);
        frame.setVisible(true);

        pass = new JLabel("Pass");
        pass.setBounds(10, 60, 80, 25);
        panel.add(pass);

        passText = new JPasswordField();
        passText.setBounds(60, 60, 165, 25);
        panel.add(passText);

        button = new JButton("Login");
        button.setBounds(100, 100, 80, 25);
        button.addActionListener(new GUILogin());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(100, 140, 100, 40);
        panel.add(success);

        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        String user = userText.getText();
        String pass = passText.getText();
        System.out.println(user +", "+ pass);

        if(user.equals("Pinca") && pass.equals("bayot")){
            success.setText("Login successful!");
        }
    }
}