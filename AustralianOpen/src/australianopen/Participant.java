package australianopen;

public class Participant 
{
    private String name;
    private int age;
    private char gender;
    String country;
    
    
    public Participant()
    {
    
    }
    
    public Participant(String name, int age, char gender, String country)
    {
        name = "Name";
        age = 0;
        gender = 'M';
        country = "Australia";
                
    }
    
    
    public String getName()
    {
        return name;
    }
    
        public String getCountry()
    {
        return country;
    }
    
}




