package game;
	
import javax.swing.*;


public class game {

	public static void main(String[] args) {
		String res = JOptionPane.showInputDialog(null, "Введите сложность игры от 1 до 7:", "Сложность игры", 1);
		int slogn = res.charAt(0)-'0';
		if((slogn >= 1) && (slogn <= 7)) {
			okno window = new okno(slogn);
		}
			
	}
	
}
