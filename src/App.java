import control.ControlApp;
import view.BorderPanel;
import model.Device;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private JTextArea displayArea;

    public App() {
        setTitle("Measuring Device");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Заголовок
        JLabel titleLabel = new JLabel("Демонстрація класу Device", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));
        add(titleLabel, BorderLayout.NORTH);

        // Текстова область для виведення
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        displayArea.setBackground(new Color(240, 248, 255));
        displayArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Панель з кнопками
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btn1 = new JButton("Паяльник (Soldering Iron)");
        JButton btn2 = new JButton("Фен (Hairdryer)");
        JButton clearBtn = new JButton("Очистити");

        btn1.setBackground(new Color(0, 153, 76));
        btn1.setForeground(Color.BLACK);
        btn2.setBackground(new Color(204, 51, 0));
        btn2.setForeground(Color.BLACK);

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(clearBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Обробники подій
        btn1.addActionListener(e -> showSolderingIron());
        btn2.addActionListener(e -> showHairdryer());
        clearBtn.addActionListener(e -> displayArea.setText(""));

        // Початкове повідомлення
        displayArea.setText("Натисніть кнопку, щоб переглянути пристрій...");
    }

    private void showSolderingIron() {
        Device gauge = new Device();
        gauge.setName("Soldering Iron");
        gauge.setHeight(3.0);
        gauge.setLength(12.0);
        gauge.setWidth(3.0);
        gauge.setWeight(150.0);
        gauge.setVoltage(12.0);
        gauge.setCurrent(5.0);
        gauge.setFrequency(50.0);
        gauge.setConditionOnOff(true);
        if (gauge.isConditionOnOff()) {
            gauge.setConditionWorking(true);
        }

        displayArea.setText("ПРИСТРІЙ 1 (встановлено через сеттери)\n");
        displayArea.append("=" .repeat(50) + "\n");
        displayArea.append(gauge.toString());
    }

    private void showHairdryer() {
        Device thermometer = new Device("Hairdryer", 7.0, 25.0, 10.0, 450.0,
                220, 5.91, 50, false, false);

        displayArea.setText("ПРИСТРІЙ 2 (через конструктор)\n");
        displayArea.append("=" .repeat(50) + "\n");
        displayArea.append(thermometer.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new App().setVisible(true);
        });
    }
}
