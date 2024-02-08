import java.util.ArrayList;
import java.util.Scanner;

public class functions {
    Scanner reader = new Scanner(System.in);
    ArrayList<Contact> contacts;

    public functions(){
        contacts = new ArrayList<>();
    }

    public void NewContactList()
    {
        contacts = new ArrayList<>();
    }

    public ArrayList<Contact> getContacts()
    {
        return contacts;
    }
    public boolean AddContac()
    {
        try
        {
            Contact contact = null;
            String name;
            String phoneNumber;
            int identity = 1;

            if (!contacts.isEmpty()){
                identity = contacts.getLast().getIdentity()+1;
            }

            contact = new Contact();
            System.out.println("Nombre: ");
            name = reader.nextLine();
            contact.setName(name);

            System.out.println("Número Telefónico: ");
            phoneNumber = reader.nextLine();
            contact.setPhoneNumber(phoneNumber);

            contact.setIdentity(identity);

            contacts.add(contact);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public boolean DeleteContact(){
        reader = new Scanner(System.in);
        boolean result = false;
        int identity;
        ViewContacts();
        try {
            if (!contacts.isEmpty()) {
                System.out.println("Qué número desas eliminar? ingresa el id del contacto");
                identity = reader.nextInt();

                reader = new Scanner(System.in);

                System.out.println("Selecionaste el Id: " + identity + "\n¿Deseas continuar? \n 1: SI \n 2: NO");
                var questionRequest = reader.nextInt();
                if (questionRequest == 1) {
                    for (Contact contact : contacts) {
                        if (contact.getIdentity() == identity) {
                            contacts.remove(contact);
                            result = true;
                        }
                    }
                }
            }
        }catch (Exception ex){
            System.out.println("Ingresa una opcion valida.");
            DeleteContact();
        }



        return result;
    }

    public void ViewContacts()
    {
        if (contacts.isEmpty()){
            System.out.println("No hay informacion para mostrar");
        }
        else {
            for (Contact contact : contacts){
                System.out.println(contact);
            }
        }
    }
}
