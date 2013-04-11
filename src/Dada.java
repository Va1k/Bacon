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
    String result = "";


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

        add(list,BorderLayout.SOUTH);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                result = bacon(list.getSelectedItem());
                repaint();



            }
        });
    }

    public String bacon (String a) {

        if(a.contains("Bacon")) {
            result = a + " is bacon! Delicious!";
        } else {
            result = a + " isn't bacon :[";
        }

        return result;
    }

    public void paint(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);

        g.drawString(result, 5, 20);

        Image image = getImage(getDocumentBase(), "bacon.jpg");
        g.drawImage(image, 10, 10, this);
    }

}
