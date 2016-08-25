package com.haofeng.paln;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.haofeng.util.Const;
import com.haofeng.util.GameUtils;

public class GameSetting extends Frame implements ActionListener {

	JFrame f = null;
	Image bg = GameUtils.getImage("images/gsbg.jpg");
	JTextField tf;
	JTextField tf1;
	JTextField tf2;

	public GameSetting() {
		f = new JFrame("����֮��---�����Ʒ");
		f.setBounds(470, 250, 430, 340);

		myPanel panel = new myPanel();
		myPanel panel2 = new myPanel();

		tf1 = new JTextField("Ӣ�ۣ�����", 20);
		tf = new JTextField("�Ѷȣ���", 20);
		tf2 = new JTextField("������������", 20);

		setButton("�л�����", panel);
		setButton("�л�Ӣ��", panel);
		setButton("�����Ѷ�", panel);
		setButton("ĥ������", panel);

		panel.add(tf2);
		panel.add(tf);
		panel.add(tf1);

		f.add(panel);
		f.setVisible(true);
	}

	class myPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(bg, 0, 125, null);
			// g.fillRect(60, 40, 40, 20);
		}
	}

	public void setButton(String name, myPanel panel) {
		JButton bt = new JButton(name);
		bt.addActionListener(this);
		panel.add(bt);
	}

	public void setBackGround() {
	}

	public int setSpeed(int speed) {
		return speed;
	}

	public static void main(String[] args) {
		// new MyFrame().LaunchFrame();
		new GameSetting();

		// new PlanGameFrame().LaunchFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("ĥ������")) {
			new PlanGameFrame().LaunchFrame();
		} else if (cmd.equals("�л�����")) {
			tf2.setText("������ˮ��");
			Const.setBackgd("images/bg3.jpg");
		} else if (cmd.equals("�����Ѷ�")) {
			tf.setText("�Ѷȣ�����");
			Const.setBulletCount(50);
			Const.setSpeed(15);
		} else if (cmd.equals("�л�Ӣ��")) {
			tf1.setText("Ӣ�ۣ�����");
			Const.setHero("images/h3.jpg");
		}
	}
}
