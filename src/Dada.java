import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Author: Andreas
 * Date  : 11/04/13
 * Time  : 2:40 PM
 */
public class Dada extends Applet {

    List list;
    String result = "Select something by double-clicking";
    int score = 0;


    public void init () {
        setLayout(new BorderLayout());

        list = new List(7);
        list.add("Dog");
        list.add("Bacon");
        list.add("Ice");
        list.add("Screens");
        list.add("Carpet");
        list.add("Lint");
        list.add("Hydrogen");
        list.add("Toast");
        list.add("Steel");
        list.add("Green");
        list.add("Forty Five");
        list.add("Jerky");
        list.add("Guanciale");
        list.add("Pancetta");
        list.add("Speck");
        list.add("Anti-Bacon");

        add(list, BorderLayout.SOUTH);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                result = bacon(list.getSelectedItem());
                repaint();



            }
        });
    }

    public String bacon (String a) {

        if(a.equals("Bacon") || a.contains("Guanciale") || a.contains("Jerky") || a.contains("Pancetta")) {
            result = a + " is bacon! Delicious!";
            score++;
        } else if (a.contains("Anti-Bacon")) {
            result = a + " is ANTI BACON. WHAT THE FUUUUUUUUUUU!";
            score = -9001;
        } else {
            result = a + " isn't bacon :[";
            score--;
        }

        return result;
    }

    public void paint(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);

        g.drawString(result, 5, 20);
        g.drawString("Score: " + String.valueOf(score), 5, 50);

        Image image = getImage(getDocumentBase(), "bacon.jpg");
        g.drawImage(image, 10, 10, this);
    }

}
