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
	private JTextField keyNameTextField;//���ҹؼ���
	private JTextField dirTextField;	//����·��
	private JButton startButton;
	private JLabel fileNumLabel;
	private Vector<String> columnNames;
	private JTable table;
	private Vector<Vector<String>> info;
	private DefaultTableModel model;
	
	//���캯����ʼ���������Ĳ���
	public StartSearchListener(JFrame frame, JTextField dirTextField, JTextField keyNameTextField, JButton startButton, JLabel fileNumLabel, JTable table, Vector<Vector<String>> info){
		this.frame = frame;
		this.dirTextField = dirTextField;
		this.keyNameTextField = keyNameTextField;
		this.startButton = startButton;
		this.fileNumLabel = fileNumLabel;
		columnNames = new Vector<String>();
		columnNames.add("�ļ���");
		columnNames.add("·��");
		this.table = table;
		this.info = info;
		this.model = new DefaultTableModel(info,columnNames);		
	}
	
	//�����������
	public void fillTable(Vector<ResultTableType> resultVector){	
		int size = resultVector.size();
		fileNumLabel.setText("�ļ�����: " + size);
		for(int i = 0; i < size; i++){
			Vector<String> row = new Vector<String>();
			row.add(resultVector.get(i).getFileName());
			row.add(resultVector.get(i).getFilePath());			
			info.add(row);
			model = new DefaultTableModel(info, columnNames);
			table.setModel(model);			
		}
	}
	
	//�����ļ�
	public void mouseClicked(MouseEvent e){
		if(e.getSource().equals(startButton)){
			model.setRowCount(0);//���������
			FileSearch fs = new FileSearch();
			fs.search(keyNameTextField.getText(),dirTextField.getText());
			this.fillTable(fs.getResultLists());	
			System.out.println("�ļ��������!");
		}	
	}
}
