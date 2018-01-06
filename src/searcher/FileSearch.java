package searcher;

import java.io.File;

import java.util.Stack;
import java.util.Vector;
import util.ResultTableType;


public class FileSearch {
	private String fileName;	//�ļ���
	private String filePath;	//�ļ�·��
	private Vector<ResultTableType> resultsVector = new Vector<ResultTableType>();//����ƥ��ɹ��Ľ��

	//Ѱ�ҵ��ļ���·��
	public void search(String strName, String directory){
		Stack<String> folderStack = new Stack<String>();
		File[] files;
		folderStack.push(directory);
		while(!folderStack.isEmpty()){
			files = new File(folderStack.pop()).listFiles();
			if(files == null) continue;
			
			for(File f : files){			
				//�Ƚ��Ƿ�ƥ��
				fileName = f.getName().toLowerCase();
				if(fileName.contains(strName.toLowerCase())){
					//ģ��ƥ��ɹ�,����list��ӵ���resultLists��					
					filePath = f.getAbsolutePath();
					resultsVector.add(new ResultTableType(fileName, filePath));
					//System.out.println(f.getPath());
				}
				if(f.isDirectory()){
					folderStack.push(f.getAbsolutePath());
				}
			}
		}
	}
	//����ƥ��ɹ����ļ�����
	public Vector<ResultTableType> getResultLists(){
		return resultsVector;
	}
}
