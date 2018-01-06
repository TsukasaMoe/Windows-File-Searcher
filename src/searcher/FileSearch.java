package searcher;

import java.io.File;

import java.util.Stack;
import java.util.Vector;
import util.ResultTableType;


public class FileSearch {
	private String fileName;	//文件名
	private String filePath;	//文件路径
	private Vector<ResultTableType> resultsVector = new Vector<ResultTableType>();//保存匹配成功的结果

	//寻找到文件的路径
	public void search(String strName, String directory){
		Stack<String> folderStack = new Stack<String>();
		File[] files;
		folderStack.push(directory);
		while(!folderStack.isEmpty()){
			files = new File(folderStack.pop()).listFiles();
			if(files == null) continue;
			
			for(File f : files){			
				//比较是否匹配
				fileName = f.getName().toLowerCase();
				if(fileName.contains(strName.toLowerCase())){
					//模糊匹配成功,生成list添加到表resultLists中					
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
	//返回匹配成功的文件集合
	public Vector<ResultTableType> getResultLists(){
		return resultsVector;
	}
}
