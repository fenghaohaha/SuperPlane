package com.haofeng.util;

/**
 * ������ ����ͼƬ��ȡ��
 */
import java.awt.Image;
import java.awt.Toolkit;

public class GameUtils {

	private GameUtils() {
	};// ˽�л������� ��ֹ����

	// ͼƬ��ȡ
	public static Image getImage(String path) {
		/*URL u = GameUtils.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;*/
		return Toolkit.getDefaultToolkit().getImage(
				GameUtils.class.getClassLoader().getResource(path));
	}
}
