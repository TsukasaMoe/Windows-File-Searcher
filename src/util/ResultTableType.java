package util;

public class ResultTableType {
	private String fileName;
	private String filePath;
	
	public ResultTableType(String fileName, String filePath){
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
	public String getFileName(){
		return fileName;
	}
		
	public String getFilePath(){
		return filePath;
	}
}
