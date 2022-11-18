import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame HELP = new JFrame("HELP");
		HELP.setSize(594, 829);
		HELP.setLocationRelativeTo(null);
		HELP.setResizable(false);
		HELP.add(new JLabel(new ImageIcon("D:\\BOBING-IMAGE\\²©±ý¹æÔò.PNG")));
		HELP.setVisible(true);//frame
		}
}
