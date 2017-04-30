package One;

public class Check {
	
	int Check(String xVal)
	{
	 try
	  { 
	     return Integer.parseInt(xVal);
	  }
	 catch(Exception ex) 
	  {
	     return 0; 
	  }
	}

}
