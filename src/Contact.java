public class Contact {
    //private  int Identity;
    private String Name;
    private String PhoneNumber;

    public  Contact(String name, String phoneNumber){
        Name = name;
        PhoneNumber = phoneNumber;
        //Identity = identity;
    }
    public Contact(){
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String name)
    {
        Name = name;
    }
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  PhoneNumber + " : " + Name;
    }
}
