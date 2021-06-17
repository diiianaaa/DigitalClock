import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;
 
public class DigitalClock1 {
 
  public static void main(String[] arguments) {
 
    ClockLabel dateLable = new ClockLabel("date");
    ClockLabel timeLable = new ClockLabel("time");

    JFrame f = new JFrame("Digital Clock");
    f.setSize(250,150);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new GridLayout(3, 1));
 
    f.add(dateLable);
    f.add(timeLable);
    f.getContentPane().setBackground(Color.black);
    f.setVisible(true);
    
    JFrame.setDefaultLookAndFeelDecorated(true);
    
  }
}
 
class ClockLabel extends JLabel implements ActionListener {
 
  String type;
  SimpleDateFormat simpledt;
 
  public ClockLabel(String type) {
    this.type = type;
    setForeground(Color.white);
 
    switch (type) {
      case "date" : simpledt = new SimpleDateFormat("  MMMM dd yyyy");
                    setFont(new Font("sans-serif", Font.PLAIN, 12));
                    setHorizontalAlignment(SwingConstants.LEFT);
                    break;
                    
                    
	case "time" : simpledt = new SimpleDateFormat("hh:mm:ss a");
                    setFont(new Font("sans-serif", Font.PLAIN, 40));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    break;
     
    
    }
 
    Timer t = new Timer(1000, this);
    t.start();
  }
 
  public void actionPerformed(ActionEvent ae) {
    Date d = new Date();
    setText(simpledt.format(d));
  }
}