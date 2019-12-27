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

public class GameOver extends JFrame {

	JFrame jf = new JFrame();
	JLabel Score;
	JLabel HighScore;
	JLabel Time;
	JLabel Least_time;

	public void label(int mode, int high_Score, int score, int count, int least_time) {

		jf.setTitle("Game Over");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HighScore = new JLabel("HIGH SCORE : 0");
		Score = new JLabel("SCORE : 0");
		Time = new JLabel("TIME : 0");
		Least_time = new JLabel("RECORD : 0");
		HighScore.setText("HIGH SCORE : " + high_Score);
		Score.setText("SCORE : " + score);
		Time.setText("TIME : " + count);

		if (least_time == 100000000)
			Least_time.setText("RECORD : -");
		else
			Least_time.setText("RECORD : " + least_time);

		JButton restart = new JButton("RESTART");
		restart.setFont(new Font("Gothic", Font.BOLD, 20));
		restart.addActionListener(new MyActionListener2());
		restart.setBackground(new Color(18, 102, 183));
		restart.setForeground(Color.white);

		ImageIcon icon = new ImageIcon("gameover.png");
		Image im = icon.getImage();
		Image im2 = im.getScaledInstance(390, 300, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(im2);
		JLabel lbImage1 = new JLabel(icon2);

		JPanel j = new JPanel();
		j.setLayout(null);
		j.add(lbImage1);
		lbImage1.setLocation(45, 40);
		lbImage1.setSize(420, 100);
		j.setBackground(new Color(0, 0, 44));
		j.add(restart);
		restart.setSize(170, 40);
		restart.setLocation(165, 450);

		if (mode == 0) {
			j.add(Score);
			j.add(HighScore);
			HighScore.setSize(400, 40);
			HighScore.setLocation(140, 260);
			HighScore.setFont(new Font("Gothic", Font.BOLD, 30));
			HighScore.setForeground(Color.white);
			Score.setSize(500, 40);
			Score.setLocation(180, 300);
			Score.setFont(new Font("Gothic", Font.BOLD, 30));
			Score.setForeground(Color.white);
		}
		if (mode == 1) {

			j.add(Least_time);
			j.add(Time);
			Time.setSize(500, 40);
			Least_time.setSize(500, 40);
			Time.setLocation(193, 340);
			Least_time.setLocation(175, 290);
			Time.setFont(new Font("Gothic", Font.BOLD, 30));
			Least_time.setFont(new Font("Gothic", Font.BOLD, 30));
			Time.setForeground(Color.white);
			Least_time.setForeground(Color.white);
		}
		setLayout(new FlowLayout());
		jf.add(Score);
		jf.add(j);
		jf.setSize(19 * 26 + 17, 26 * 23 + 41);
		jf.setVisible(true);

	}

	class MyActionListener2 implements ActionListener {

		Mode_Select modeselect = new Mode_Select();

		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			if (j.getText().equals("RESTART")) {
				jf.setVisible(false);
				modeselect.Start();
			}

		}
	}
}
