public class Contact {
    private  int Identity;
    private String Name;
    private String PhoneNumber;

    public  Contact(String name, String phoneNumber, int identity){
        this.Name = name;
        this.PhoneNumber = phoneNumber;
        this.Identity = identity;
    }
    public Contact(){
    }

    public int getIdentity()
    {
        return this.Identity;
    }
    public void  setIdentity(int identity)
    {
        this.Identity = identity;
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String name)
    {
        this.Name = name;
    }
    public String getPhoneNumber()
    {
        return this.PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
      this.PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID: " + Identity + "\nNombre: " + Name + " Telefono: " + PhoneNumber;
    }
}
