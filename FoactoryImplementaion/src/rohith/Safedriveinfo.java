package rohith;

public class Safedriveinfo {
	private Safedriveinfo()
	{
		
	}
	
	public static Car getsafedriveinfo(String carname){
		if(carname.equalsIgnoreCase("benz")){
	         return new Benz();
	}
		else if(carname.equalsIgnoreCase("audi")){
			 return new Audi();
		}
		
		else if (carname.equalsIgnoreCase("bmw")){
			 return new BMW();
		}
		return null;
	        
		
}
}
