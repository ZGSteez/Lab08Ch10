package Files;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenInfo {
	
	private JButton button;
	private JLabel label;
	private boolean reset;
	
	ScreenInfo() {
		label = new JLabel("O's turn");
		label.setBounds(350, 10, 120, 20);;
		reset = false;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public void updateLabel(TurnManager turn) {
		if (turn.getTurn())
			label.setText("O's turn");
		if (!turn.getTurn())
			label.setText("X's turn");
	}
	
	public void createButton(TurnManager.Item [][]token) {
		button = new JButton("Reset");

		// check for clicks on button
		class Listener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				reset = true;
				
				updateLabel("O's turn");
				getButton().setVisible(false);
			}
		}
		ActionListener listener = new Listener();
		button.addActionListener(listener);
	}
	
	public void updateLabel(String message) {
		label.setText(message);
	}
	
	public void setReset(boolean reset) {
		this.reset = reset;
	}
	
	public boolean getReset() {
		return reset;
	}
}
