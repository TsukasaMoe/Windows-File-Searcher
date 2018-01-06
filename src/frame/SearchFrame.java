package frame;

import listener.OpenFileListener;
import listener.SelectDirListener;
import listener.StartSearchListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class SearchFrame extends JFrame{	
	//ѡ���ļ��ĸ���Ŀ¼
	public JLabel directoryLabel;
	public JButton selectDirButton;
	public JTextField dirTextField;
	
	//�ؼ��ֲ�����
	public JLabel keyNameLabel;
	public JButton startSearchButton;
	public JTextField searchDirTextField;
	
	//��ʾ���ҵ����ļ���Ŀ
	private JLabel fileNumLabel;
	//��֯���ȿؼ�
	private JPanel searchPanel;
	private JScrollPane resultScrollPanel;
	private JPanel labelPanel;

	public SearchFrame(){
		super("FileSearcher");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(570,420);
		this.setLocation(400,250);

		//���ø����ؼ�����
		searchPanel = new JPanel();	
		this.setLayout(null);
		searchPanel.setSize(570,60);
		this.add(searchPanel);
		searchPanel.setLayout(null);

		directoryLabel = new JLabel("����Ŀ¼:");
		directoryLabel.setFont(new Font("����",Font.PLAIN,12));
		directoryLabel.setBounds(10,10,70,15);
		searchPanel.add(directoryLabel);
		
		
		dirTextField = new JTextField();
		dirTextField.setFont(new Font("����",Font.PLAIN,12));
		dirTextField.setBounds(77,7,356,21);
		dirTextField.setColumns(10);
		searchPanel.add(dirTextField);
		
		
		selectDirButton = new JButton("ѡ��Ŀ¼");
		selectDirButton.setFont(new Font("����",Font.PLAIN,12));
		selectDirButton.setBounds(457,6,83,23);
		searchPanel.add(selectDirButton);
				
		keyNameLabel = new JLabel("�ؼ���:");
		keyNameLabel.setFont(new Font("����",Font.PLAIN,12));
		keyNameLabel.setBounds(10,35,70,15);
		searchPanel.add(keyNameLabel);
		
		searchDirTextField = new JTextField();
		searchDirTextField.setFont(new Font("����",Font.PLAIN,12));
		searchDirTextField.setBounds(77,35,356,21);
		searchPanel.add(searchDirTextField);
		
		startSearchButton = new JButton("��ʼ����");
		startSearchButton.setFont(new Font("����",Font.PLAIN,12));
		startSearchButton.setBounds(457,35,83,23);
		searchPanel.add(startSearchButton);
		//��С��ͼ��
		Image img = Toolkit.getDefaultToolkit().createImage("img.jpg");
		this.setIconImage(img);

		//������JTable������ʾ���ҽ��
		Vector<String> vNames = new Vector<String>();
		vNames.add("�ļ���");
		vNames.add("·��");
		
		Vector<Vector<String>> info = new Vector<Vector<String>>();
		
		JTable table = new JTable(info,vNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};				
		resultScrollPanel = new JScrollPane(table);

		resultScrollPanel.setLocation(45,70);
	  	resultScrollPanel.setSize(470,270);
	  	this.add(resultScrollPanel);
	  	
	  	labelPanel = new JPanel();
	  	fileNumLabel = new JLabel("�ļ�����: " + 0);
	  	fileNumLabel.setForeground(new Color(138,43,226));
	  	fileNumLabel.setLocation(100, 200);
	  	fileNumLabel.setFont(new Font("����",Font.PLAIN,12));
	  	labelPanel.add(fileNumLabel);
	  	labelPanel.setSize(570,30);
	  	labelPanel.setLocation(180,340);
	  	this.add(labelPanel);
	  	
	  	this.setVisible(true);
		
		selectDirButton.addMouseListener(new SelectDirListener(this,dirTextField));
		startSearchButton.addMouseListener(new StartSearchListener(this,dirTextField,searchDirTextField,startSearchButton,fileNumLabel,table,info));
		table.addMouseListener(new OpenFileListener(table));
	}
}
