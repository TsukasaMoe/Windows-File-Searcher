package listener;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class OpenFileListener extends MouseAdapter{
	private JTable table;
	
	public OpenFileListener(JTable table){
		this.table = table;
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			int row = ((JTable)e.getSource()).rowAtPoint(e.getPoint());
			//String fileName = table.getValueAt(row, 0).toString();
			String filePath = table.getValueAt(row, 1).toString();
			File file = new File(filePath);
			if(file.exists()){
				try {
					Desktop.getDesktop().open(file);
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "文件不存在");
			}
		}else if(e.getClickCount() == 1){
			table.setSelectionForeground(Color.RED);
			table.setSelectionBackground(Color.GREEN);
		}
	}
}
