import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
ID: mesuper1
LANG: JAVA
TASK: gift1
*/

/**
 * 
 * @author:Mary Jiang
 * @Date:Jan 14, 2017
 * @Email: mesuper222@gmail.com
 *
 */

public class gift1 {

	public static void main(String[] args) throws IOException{
		// read in file and print out
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		String x="";
		int cnt=0;
		int playerNum=0;
		String playerName=null;
		String[] orderPlayerName=null;
		Map<String, String> players = new HashMap<String, String>();
		boolean gamebegin=false;
		int giftMoney=0;
		int giftreceiverNum=0;
		int receiverNameBeginLineNum=0;
		int receivedMoney = 0;
		int leftForSelf=0;
	    FileWriter writer = new FileWriter("gift1.out");
		while((x= f.readLine())!=null){
			//System.out.println(x);
			if(cnt==0) {
				playerNum=Integer.parseInt(x);
				orderPlayerName = new String[playerNum];
			}
			if(cnt>0 && cnt<playerNum+1) {
				//System.out.println(x);
				players.put(x, "0");
				orderPlayerName[cnt-1]=x;
			}
			
			if(cnt==playerNum+1) {
				gamebegin=true;
				
			}
			
			if (gamebegin) {
				if(playerName==null) {
					playerName=x;
					cnt++;
					continue;
				}
				
				if(giftMoney==0 && giftreceiverNum==0) {
					String[] moneyInfo = x.split(" ");
					giftMoney=Integer.parseInt(moneyInfo[0]);
					giftreceiverNum = Integer.parseInt(moneyInfo[1]);
					
					if(giftMoney==0&& giftreceiverNum==0) {
						playerName=null;
						cnt++;
						continue;
					}
					
					leftForSelf = giftMoney%giftreceiverNum-giftMoney;
					
					
					int saving = Integer.parseInt(players.get(playerName))+leftForSelf;
					players.put(playerName, String.valueOf(saving));
					
					receiverNameBeginLineNum =cnt;
					
					
					receivedMoney=(giftMoney/giftreceiverNum);
					
					
					
				}
				if(cnt>receiverNameBeginLineNum && cnt<receiverNameBeginLineNum+giftreceiverNum+1) {
					
					int totalAmount = Integer.parseInt(players.get(x))+receivedMoney;
					players.put(x, String.valueOf(totalAmount));
					
				}else if(cnt==receiverNameBeginLineNum+giftreceiverNum+1) {
					giftreceiverNum=0;
					giftMoney=0;
					playerName=x;
				}
				
			}
			
			cnt++;
	    	}
		   
			/*for (Map.Entry<String, String> entry : players.entrySet()) {
				writer.write(entry.getKey() + " " + entry.getValue()+"\n");
				System.out.println(entry.getKey() + " " + entry.getValue());
			}*/
		
		     for(int i=0;i<orderPlayerName.length;i++) {
		    	 writer.write(orderPlayerName[i]+" "+players.get(orderPlayerName[i])+"\n");
		    	 System.out.print(orderPlayerName[i]+" "+players.get(orderPlayerName[i])+"\n");
		     }
			
			f.close();
			writer.close();

	    }

	}


