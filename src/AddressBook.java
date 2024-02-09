import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    Scanner reader = new Scanner(System.in);
    HashMap<String, String> Contacts = new HashMap<>();

    public AddressBook(){

    }

    public HashMap<String, String> list(){
        return Contacts;
    }

    public boolean Create()
    {
        try
        {
            reader = new Scanner(System.in);
            String name;
            String phoneNumber;

            System.out.println("Nombre: ");
            name = reader.nextLine();

            System.out.println("Número Telefónico: ");
            phoneNumber = reader.nextLine();

            Contacts.put(phoneNumber, name);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    private boolean DeleteConfirm(String phoneNumber){
        boolean result = false;
        try{
            reader = new Scanner(System.in);
            System.out.println("Ingresaste el número: " + phoneNumber );
            System.out.println("¿Deseas continuar?");
            System.out.println("\n1: SI\n2: NO");
            int response = reader.nextInt();
            if (response == 1){
                result = true;
            }
        }catch (Exception ex){
            System.out.println("escribe << 1 >> para confirmar ó  << 2 >> para salir");
            DeleteConfirm(phoneNumber);
        }

        return result;
    }
    public boolean Delete()
    {
        boolean result = false;
        try
        {
            reader = new Scanner(System.in);
            System.out.println("Ingresa el número que desas eliminar:");
            String phoneNumber = reader.nextLine();

            boolean responseRequest = DeleteConfirm(phoneNumber);

            if (responseRequest){

                String validateContact = Contacts.get(phoneNumber);
                if (validateContact == null || validateContact.isEmpty())
                {
                    System.out.println("no existe el número a aliminar");
                    return  false;
                }

                Contacts.remove(phoneNumber);

                result = true;
            }

            return result;
        }catch (Exception ex){
            System.out.println("ingresa un valor valido.");
            Delete();
        }

        return result;
    }

    public void load() {
        try {
            File file = new File("Addressbook.txt").getAbsoluteFile();
            if (file.exists()) {
                String line;
                BufferedReader bufferReader = new BufferedReader(new FileReader(file));
                    while ((line = bufferReader.readLine()) != null) {
                        if (!line.isEmpty()) {
                            String[] elements = line.split(":");
                            if (elements.length == 2) {
                                Contacts.put(elements[0].trim(), elements[1].trim());
                            }
                        }
                    }
                    bufferReader.close();
            }
            else {
                Contacts = new HashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Save() {
        boolean result = false;
        try {
            File file = new File("Addressbook.txt").getAbsoluteFile();
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Map.Entry<String, String> item : Contacts.entrySet()) {
                    writer.write(item.getKey() + " : " + item.getValue());
                    writer.newLine();
                }
                writer.close();
                result = true;
            } catch (IOException ex) {
                ex.printStackTrace();
                result = false;
            }
        }catch (IOException exception){
            System.out.println(exception.getMessage());
            result = false;
        }
        return  result;
    }
}
