import java.awt.GridLayout;

import javax.swing.JFrame;

public class HelloWorld {

	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(640,480);
		frame.setLayout(new GridLayout(4,1));
		frame.setVisible(true);
	}

}
