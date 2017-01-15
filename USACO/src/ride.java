
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
ID: mesuper1
LANG: JAVA
TASK: ride
*/

/**
 * 
 * @author:Mary Jiang
 * @Date:Jan 14, 2017
 * @Email: mesuper222@gmail.com
 *
 */

public class ride {

	 public static void main (String [] args) throws IOException {
		try{
		 // Use BufferedReader rather than RandomAccessFile; it's much faster
	    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
	    
	    String line="";
	    int cnt=1;
	    String cometName="";
	    String groupName="";
	    while((line= f.readLine())!=null){
	    	if(cnt==1){
	    		cometName=line;	    		
	    	}else if(cnt==2){
	    		groupName=line;
	    	}
	    cnt++;
	    }
	   	    
	    char[] cometNameCharArray=cometName.toCharArray();
	    int cometNameNum=1;
	    for(char charC:cometNameCharArray){
	    	cometNameNum=cometNameNum*getIndex(charC);
	    }
	    
	    char[] groupNameCharArray=groupName.toCharArray();
	    int groupNameNum=1;
	    for(char charG:groupNameCharArray){
	    	groupNameNum=groupNameNum*getIndex(charG);
	    }
	    
	    int cometMod = cometNameNum%47;
	    int groupMod = groupNameNum%47;
	    
	    FileWriter writer = new FileWriter("ride.out");
	    
	    if(cometMod==groupMod){
	    	writer.write("GO\n");
	    	System.out.println("GO");
	    } else{
	    	writer.write("STAY\n");
	    	System.out.println("STAY");
	    }
	    
	    writer.close();
	    f.close();
	    //out.close();                                  // close the output file
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int getIndex(char c){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alpArray=alphabet.toCharArray();
		
		for(int i=0;i<alpArray.length;i++){
			if(alpArray[i]==c){
				return i+1;				
			}
		}
		return 0;
	}

}
