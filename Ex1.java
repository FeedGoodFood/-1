import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Ex1 extends JFrame {
    int u = 0, i = 60;
    String g = "", h = g + u, h1 = g + i;
    JLabel ex,ex1,ex2,ex3,ex4;
    JRadioButton speed1,speed2,speed3;
    JToggleButton button1;
    JButton button;
    public Ex1()
    {

        super("Спортивный тренажер");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        // Устанавливаем последовательное расположение
        Container container = getContentPane();
        container.setLayout(null);

        //первый текст
        ex = new JLabel( " Время (сек)" );
        ex.setBounds(55, 15, 100, 30);
        container.add(ex);

        //второй текст
        ex2 = new JLabel(h);
        ex2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.gray, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        ex2.setBounds(55, 40, 100, 30);
        container.add(ex2);

        //третий текст
        ex1 = new JLabel(" Скорость ");
        ex1.setBounds(175, 15, 100, 30);
        container.add(ex1);

        //четвертый текст
        ex3 = new JLabel(h1);
        ex3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.gray, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        ex3.setBounds(175, 40, 100, 30);
        container.add(ex3);

        //пятый текст
        ex4 = new JLabel(" Переключатель скорости ");
        ex4.setBounds(295, 15, 180, 30);
        container.add(ex4);

        // Первая кнопка
        button = new JButton("время +1 минута");
        button.setBounds(25, 100, 150, 30);
        button.addActionListener(new time_plus());
        button.setFocusPainted(false);
        container.add(button);

        //Вторая кнопка
        button1 = new JToggleButton("режим бег/ходьба", false);
        button1.setBounds(195, 100, 150, 30);
        button1.addActionListener(new running_walking());
        button1.setFocusPainted(false);
        container.add(button1);
        button1.setEnabled(false);

        ButtonGroup bg1 = new ButtonGroup();


        speed1 = new JRadioButton("120", true);
        speed1.setBounds(295, 40, 20, 30);
        speed1.addActionListener(new running_walking());
        container.add(speed1);
        speed1.setEnabled(false);

        speed2 = new JRadioButton("180");
        speed2.setBounds(315, 40, 20, 30);
        speed2.addActionListener(new running_walking());
        container.add(speed2);
        speed2.setEnabled(false);

        speed3 = new JRadioButton("240");
        speed3.setBounds(335, 40, 20, 30);
        speed3.addActionListener(new running_walking());
        container.add(speed3);
        speed3.setEnabled(false);

        bg1.add(speed1);
        bg1.add(speed2);
        bg1.add(speed3);

        //--------------------------------------------------------------------------
        // выводим окно на экран
        setSize (new Dimension (500, 200));

        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize (),

                fSize = getSize ();

        if (fSize.height > sSize.height) {fSize.height = sSize.height;}

        if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}

        setLocation ((sSize.width - fSize.width)/2,

                (sSize.height - fSize.height)/2);

        setDefaultCloseOperation (EXIT_ON_CLOSE);

        setVisible (true);
        // само окно
        //------------------------------------------------------------------------------
    }
    class time_plus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            u += 60;
            h = g + u;
            ex2.setText(h);
            button1.setEnabled(!button.isSelected());
        }
    }

    class running_walking implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            speed1.setEnabled(button1.isSelected());
            speed2.setEnabled(button1.isSelected());
            speed3.setEnabled(button1.isSelected());

            if (speed1.isSelected()){
                h1 = g + i*2;
                ex3.setText(h1);
            }
            if (speed2.isSelected()){
                h1 = g + i*3;
                ex3.setText(h1);
            }
            if (speed3.isSelected()){
                h1 = g + i*4;
                ex3.setText(h1);
            }
            if (!button1.isSelected()) {
                h1 = g + i;
                ex3.setText(h1);
            }
        }
    }

    public static void main(String[] args) {
        new Ex1();
    }
}
