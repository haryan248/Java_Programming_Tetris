package Game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mode_Select extends JFrame {
	JFrame jf = new JFrame();

	public void Start() {
		jf.setTitle("Select mode");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton nomal = new JButton("NORMAL");
		nomal.setFont(new Font("Gothic", Font.BOLD, 17));
		nomal.setForeground(new Color(0, 0, 44));

		JButton time = new JButton("TIME ATTACK");
		time.setFont(new Font("Gothic", Font.BOLD, 17));
		time.setForeground(new Color(0, 0, 44));

		JButton quit = new JButton("QUIT");
		quit.setFont(new Font("Gothic", Font.BOLD, 17));
		quit.setForeground(new Color(0, 0, 44));

		nomal.setBackground(new Color(18, 102, 183));
		time.setBackground(new Color(18, 102, 183));
		quit.setBackground(new Color(18, 102, 183));

		nomal.addActionListener(new MyActionListener());
		time.addActionListener(new MyActionListener());
		quit.addActionListener(new MyActionListener());

		ImageIcon icon = new ImageIcon("Tetris.png");
		Image im = icon.getImage();
		Image im2 = im.getScaledInstance(322, 200, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(im2);
		JLabel lbImage1 = new JLabel(icon2);

		JPanel j = new JPanel();
		j.setLayout(null);
		j.add(lbImage1);
		lbImage1.setLocation(100, 100);
		lbImage1.setSize(322, 200);

		j.add(nomal);
		nomal.setSize(150, 40);
		nomal.setLocation(175, 350);
		nomal.setForeground(Color.white);

		j.add(time);
		time.setSize(150, 40);
		time.setLocation(175, 400);
		time.setForeground(Color.white);

		j.add(quit);
		quit.setSize(150, 40);
		quit.setLocation(175, 450);
		quit.setForeground(Color.white);
		j.setBackground(new Color(0, 0, 44));

		setLayout(new FlowLayout());
		jf.add(j);
		jf.setSize(19 * 26 + 17, 26 * 23 + 41);
		jf.setVisible(true);
	}


	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			GameStart game = new GameStart();
			JButton j = (JButton) e.getSource();

			if (j.getText().equals("NORMAL")) {
				jf.setVisible(false);
				game.normal_run();

			} else if (j.getText().equals("TIME ATTACK")) {
				jf.setVisible(false);
				game.time_run();
			} else if (j.getText().equals("QUIT")) {
				System.exit(0);
			}
		}
	}
}