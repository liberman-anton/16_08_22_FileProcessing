import java.io.*;

public class FileProcessingTestAppl {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		if(args.length > 0){
			
//			file.mkdirs();
			if(!file.exists())
				file.createNewFile();
			System.out.println(file.exists());
		}
		displayDirectoryContent(file);
	}
	/**
	 * displaying content of directory related with the parameter file
	 * in the form <name> dir | file 
	 * @param file
	 */
	private static void displayDirectoryContent(File file) {
		if (file.isDirectory()) {
					dysplayRecursive(file,0);
		} 
	}
	
	private static void dysplayRecursive(File file, int counter) {
		System.out.println(level(counter) + file.getName() + ":");
		counter++;
		File[] nodes = file.listFiles();
		for (File node : nodes) {
			if (node.isDirectory()) {
				dysplayRecursive(node, counter);
			} else
				System.out.println(level(counter) + node.getName());
		} 
	}
	private static String level(int counter) {
		String res = new String();
		for(int i = 0; i < counter; i++){
			res+="\t";
		}
		return res;
	}

}
