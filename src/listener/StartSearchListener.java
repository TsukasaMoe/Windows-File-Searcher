package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import searcher.FileSearch;
import util.ResultTableType;

public class StartSearchListener extends MouseAdapter{
	private JFrame frame;
	private JTextField keyNameTextField;//查找关键字
	private JTextField dirTextField;	//查找路径
	private JButton startButton;
	private JLabel fileNumLabel;
	private Vector<String> columnNames;
	private JTable table;
	private Vector<Vector<String>> info;
	private DefaultTableModel model;
	
	//构造函数初始化传过来的参数
	public StartSearchListener(JFrame frame, JTextField dirTextField, JTextField keyNameTextField, JButton startButton, JLabel fileNumLabel, JTable table, Vector<Vector<String>> info){
		this.frame = frame;
		this.dirTextField = dirTextField;
		this.keyNameTextField = keyNameTextField;
		this.startButton = startButton;
		this.fileNumLabel = fileNumLabel;
		columnNames = new Vector<String>();
		columnNames.add("文件名");
		columnNames.add("路径");
		this.table = table;
		this.info = info;
		this.model = new DefaultTableModel(info,columnNames);		
	}
	
	//将结果填进表格
	public void fillTable(Vector<ResultTableType> resultVector){	
		int size = resultVector.size();
		fileNumLabel.setText("文件数量: " + size);
		for(int i = 0; i < size; i++){
			Vector<String> row = new Vector<String>();
			row.add(resultVector.get(i).getFileName());
			row.add(resultVector.get(i).getFilePath());			
			info.add(row);
			model = new DefaultTableModel(info, columnNames);
			table.setModel(model);			
		}
	}
	
	//搜索文件
	public void mouseClicked(MouseEvent e){
		if(e.getSource().equals(startButton)){
			model.setRowCount(0);//清空所有行
			FileSearch fs = new FileSearch();
			fs.search(keyNameTextField.getText(),dirTextField.getText());
			this.fillTable(fs.getResultLists());	
			System.out.println("文件搜索完成!");
		}	
	}
}
