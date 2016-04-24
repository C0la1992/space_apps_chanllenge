import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class tpanel extends JPanel {
	private JPanel menu;
	
	tpanel() {
		this.setBounds(0, 0, 50, 50);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		menu = new JPanel();
		menu.setBounds(50, 0, 50, 100);
		this.add(menu);
		menu.setBackground(Color.red);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				change();
			}
		});
	}

	public void change() {
		this.setSize(100, 100);
	}
}