import java.util.Scanner;

public class Main {
    static Scanner reader;


    public static void main(String[] args) {

        ExecuteProccess();
    }
    private static void PrintOptions()
    {
        System.out.println("********************************************");
        System.out.println("1: VER CONTACTOS");
        System.out.println("2: NUEVO CONTACTO");
        System.out.println("3: ELIMINAR CONTACTO");
        System.out.println("4: SALIR");
        System.out.println("********************************************");
    }

    private static void ExecuteProccess()
    {
        AddressBook addressBook = new AddressBook();
        try {

            reader = new Scanner(System.in);

            addressBook.load();

            PrintOptions();
            boolean inputExit = false;
            while (!inputExit) {
                switch (reader.nextInt()) {
                    case 1:
                        var contacts = addressBook.list();
                        if (!contacts.isEmpty()) {
                          for (String contact : contacts.keySet()) {
                              System.out.println("> " + contact + " : " + contacts.get(contact));
                           }
                        }
                        else {
                            System.out.println("No hay contactos disponibles para mostrar.");
                        }
                        PrintOptions();
                        break;
                    case 2:
                        var createContact = addressBook.Create();
                        if (createContact)
                        {
                            System.out.println("Contacto agregado correctamente");
                        }
                        else {
                            System.out.println("No se agregó el contacto.");
                        }
                        PrintOptions();
                        break;
                    case 3:
                            boolean deleteContact = addressBook.Delete();
                            if (deleteContact){
                                System.out.println("Contacto Eliminado correctament.");
                            }
                            else
                            {
                                System.out.println("No se eliminó el contacto.");
                            }
                            PrintOptions();
                        break;
                    case 4:
                        inputExit = true;
                        break;
                    default:
                        System.out.println("Opción NO valida.");
                        PrintOptions();
                        break;
                }
            }
        }catch (Exception ex){
            System.out.println("Ingresa un valor númerico.");
            ExecuteProccess();
        }
        finally {
           boolean result = addressBook.Save();
           if (result) {
               System.out.println("Contactos guardados en archivo correctamente");
           }
        }
    }
}