package daysCL;

import java.text.SimpleDateFormat;

import java.util.Date;

public class daygoods {
	
      Date d=new Date();
      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
      public String changeDate()
      {
    	  return (df.format(new Date(d.getTime()+(long)30*24*60*60*1000)));
      }
      public long showlastday(Date d1, Date d2)
      {
    	  long d3 = d2.getTime() - d1.getTime();
    	  long days = d3 / (24 * 60 * 60 * 1000);
    	 return days;
      }
      
}
