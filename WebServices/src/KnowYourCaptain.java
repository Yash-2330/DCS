
public class KnowYourCaptain {
	
	public String getCaptainName(String country_name)
	{
		String captain_name = "";
		if(country_name.equalsIgnoreCase("india"))
		{
			captain_name = "M.S. Dhoni";
		}
		else if(country_name.equalsIgnoreCase("Australia"))
		{
			captain_name = "Aaron Finch";
		}
		else if(country_name.equalsIgnoreCase("New Zealand"))
		{
			captain_name = "Ross Taylor";		
		}
		else if(country_name.equalsIgnoreCase("England"))
		{
			captain_name = "Ben Stokes";
		}
		else
		{
			captain_name = "No Idea, Please input relevant country";
		}
		return captain_name;
				
	}
}
