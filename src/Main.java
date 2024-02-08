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
        try {
            functions function = new functions();
            reader = new Scanner(System.in);

            PrintOptions();
            boolean inputExit = false;
            while (!inputExit) {
                switch (reader.nextInt()) {
                    case 1:
                        function.ViewContacts();
                        break;
                    case 2:
                      var addContact = function.AddContac();
                      if (addContact) {
                          System.out.println("Contacto añadido correctamente.");
                      }
                      else {
                          System.out.println("Error al guardar contacto.");
                      }
                        break;
                    case 3:
                        var deleteContact = function.DeleteContact();
                        if (deleteContact){
                            System.out.println("Contacto borrado correctamente");
                        }
                        else
                        {
                            ExecuteProccess();
                        }
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
    }
}