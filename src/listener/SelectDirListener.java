package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SelectDirListener extends MouseAdapter{
	private JFrame frame;	
	private JTextField dirField;
	private String searchRootDir;
	
	public SelectDirListener(JFrame frame,JTextField dirField) {
		this.frame = frame;
		this.dirField = dirField;
	}
	
	public void mouseClicked(MouseEvent e){
		super.mouseClicked(e);
		JFileChooser fileChooser = new JFileChooser();
		try {
			
		    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Exception ex2) {
		    ex2.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(fileChooser);
		
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showOpenDialog(frame);
		try{
			searchRootDir = fileChooser.getSelectedFile().toString();
			dirField.setText(searchRootDir);

		}catch(Exception ex1){
			System.out.println("没有选定目录");
		}
		
		
	}
}
