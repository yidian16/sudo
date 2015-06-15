package com.example.helloword;

public class GameData {
	
	
	private final String str ="800000000003600000070090200"
			+"050007000000045700000100030"
			+"001000068008500010090000400" ;
	//private String refreshStr =str;
	private int [] sudu =new int [9*9];
	private int [][][] UsedNum= new int[9][9][];
	//private int [] AllNum = new int [9*9];
	
	public  GameData(){	
		//System.out.println("GameData调用了无参的构造函数");  
		sudu = StrToNum(str);
		
		UsedNum = calusedAllNum();
		
		//AllNum =StrToNum
	}
	/*public int  GetStrlen(){
		return str.length();
	}*/
	public String GetStrFromStr(int x, int y){
		//char returnChar;
		//returnChar = str.charAt(y*9+x);
		int returnChar=sudu[y*9+x];
		if (returnChar == 0 )
				return " ";
		else
			return String.valueOf(returnChar);
	}
	// 转换字符串为数字
	protected int [] StrToNum(String stc){
		int [] Num =new int [stc.length()];
		for(int i=0;i<stc.length();i++){
			Num[i]=stc.charAt(i) - '0';
		}
			return Num ;
				
	}
	int getArrNum(int x,int y){
		
		return sudu[y*9+x];
	}
	
	int [][][] calusedAllNum(){
		int c[][][]=new int [9][9][];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				//if(getArrNum(i,j)!=0)
				//	continue;
				c[i][j]=CalusedNum(i,j);
			}
		return c;
	}
	int [] CalusedNum(int x ,int y){
		// 计算本行已经用过的数据
		int [] backNum =new int [9];
		for(int i=0;i<9;i++){
			if (i==y)
				continue;
		    int t = getArrNum(x,i);
		    if (t!=0)
		    	backNum[t-1]=t;
		}
		for(int i=0;i<9;i++){
			if(i==x)
				continue;
			int t = getArrNum(i,y);
			if (t!=0)
	    	 backNum[t-1]=t;
			
		}
		
		int tempX =(x/3)*3;
		int tempY =(y/3)*3;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				if( (x==(tempX+i)) && (y==(tempY+j)))
					continue;
		        int t = getArrNum(tempX+i,tempY+j);
		        if (t!=0)
			    	 backNum[t-1]=t;
			}
		int used=0;
		for(int t: backNum){
			if(t!=0)
				used++;
		}
		int [] BackNumTemp =new int [used];
		used =0;
		for(int t: backNum){
			if(t!=0)
				BackNumTemp[used++]=t;
		}
		
		
		
		
		return BackNumTemp ;
		
		
		
	}
	public int [] getUsedNum(int x ,int y){
		return UsedNum[x][y];
	}
	protected void setNum(int x, int y,int num){
		
		sudu[x+y*9]=num;
		
	}
	public boolean refreshStr(int x,int y,int num){
		
		 // int Index = x*9+y;
		 // str=str.replaceFirst(str.substring(Index,Index+1),num);
		 //sudu = StrToNum(str);
		 if(UsedNum[x][y].length == 0){
			 return false;
		 }
		 
		 for(int i=0;i<UsedNum[x][y].length;i++) {
			 if(UsedNum[x][y][i] == num)
				 return false;
		 }
		 
		 setNum(x,y,num);
		 UsedNum = calusedAllNum();
		 return true;
	}
	
}
