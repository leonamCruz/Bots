package br.com.leonam.bot;

import javax.swing.*;

public class View {
    private JTextField user;
    private JPasswordField senha;
    private JButton vejaAMagicaAcontecerButton;
    private JPanel root;

    public View() {
        vejaAMagicaAcontecerButton.addActionListener(e -> {
            VisualizarStories();
        });
    }

    private void VisualizarStories() {
        var bot = new Bot();
        try {
            bot.login(user.getText(), senha.getPassword().toString());
            bot.verTodosOsStories();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public JPanel getRoot() {
        return root;
    }

    public static void main(String[] args) {
        var jFrame = new JFrame("Visualizar Stories");
        jFrame.setContentPane(new View().getRoot());
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
