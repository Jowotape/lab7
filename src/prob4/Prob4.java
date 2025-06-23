package prob4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Prob4
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String[] nombreDeEstudiantes;
    private double[] notaFinalDeEstudiantes;

    // Revisa el nombre a agregar no este agregado, si es asi, obligarle a poner otro nombre
    private String revisarDuplicoNombre(String nombre)
    {
        for ( String nombreDeEstudiante : nombreDeEstudiantes )
        {
            if ( nombre.equals(nombreDeEstudiante) )
            {
                String nombreNuevo = nombre;
                System.out.println("Error, no se puede poner el mismo nombre dos veces");
                while (nombre.equals(nombreNuevo) ) // el nombre no sea diferente
                {
                    System.out.print("Por favor introduzca otro nombre que sea diferente: ");
                    try {
                        nombreNuevo = br.readLine();
                    } catch (IOException e) {
                        System.err.println("Hubo algun tipo de error al revisar la duplicidad del nombre dado");
                    }
                }
                return nombreNuevo;
            }
        }
        return nombre;
    }

    private String revisarNombreValido(String nombre)
    {
        while( !nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"))
        {
            System.out.println("El nombre introducido tiene caracters no válidos, solo se admiten letras y espacios");
            System.out.print("Nombre: ");
            try {
                nombre = br.readLine();
            } catch (IOException e) {
                System.err.println("Hubo algun tipo de error en la revision en la validez de nombre");
            }
        }
        return nombre;
    }

    public void registrarDatos()
    {
        System.out.println("Problema 4: Registrar una lista de estudiantes con su nota final y ordenar por nota (menor a mayor) o alfabeticamente");
        System.out.println("Inserte la cantidad de estudiantes a registrar:");
        int cantidad = 0;
        String entrada = "";

        while(true)
        {
            try {
                cantidad = Integer.parseInt(br.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("El valor introducido no es un número.");
                System.out.println("Por favor intente de nuevo poniendo un número:");
            } catch (Exception e) {
                System.err.println("Hubo algun tipo de error.");
            }
        }

        nombreDeEstudiantes = new String[cantidad];
        notaFinalDeEstudiantes = new double[cantidad];

        for (int i = 0; i < cantidad; i++)
        {
            try {
                System.out.println("Usuario " + (i+1) + ":");
                System.out.print("Nombre: ");
                entrada = br.readLine();
                nombreDeEstudiantes[i] = revisarDuplicoNombre( revisarNombreValido(entrada) );
            } catch (Exception e) {
                System.err.println("Hubo algun tipo de error");
            }

            while(true)
            {
                try {
                    System.out.print("Nota final: ");
                    notaFinalDeEstudiantes[i] = Integer.parseInt(br.readLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("El valor introducido no es un número.");
                    System.out.println("Por favor intente de nuevo poniendo un número:");
                } catch (Exception e) {
                    System.err.println("Hubo algun tipo de error.");
                }
            }
        }
    }

    public void ordenarPorNotas()
    {
        // Se hace lo mismo que en ordenarAlfabeticamente
        // Se usa string[] ya que puede haber varias personas con la misma nota, entonces se guarda en un array y ya
        HashMap<Double, String[]> hashMap = new HashMap<>();
        for(int i = 0; i < notaFinalDeEstudiantes.length; i++)
        {
            if (!hashMap.containsKey(notaFinalDeEstudiantes[i]))
            {
                hashMap.put(notaFinalDeEstudiantes[i], new String[] {nombreDeEstudiantes[i]});
            }
            else
            {
                String[] viejoString = hashMap.get(notaFinalDeEstudiantes[i]);
                String[] nuevoString = new String[viejoString.length + 1];
                System.arraycopy(viejoString, 0, nuevoString, 0, viejoString.length);
                nuevoString[nuevoString.length-1] = nombreDeEstudiantes[i];
                hashMap.replace(notaFinalDeEstudiantes[i], nuevoString);
            }
        }

        Arrays.sort(notaFinalDeEstudiantes);

        for(int i = 0; i < notaFinalDeEstudiantes.length; i++)
        {
            String[] listaDeEstudiantesConLaMismaNota = hashMap.get(notaFinalDeEstudiantes[i]);
            System.arraycopy(listaDeEstudiantesConLaMismaNota, 0, nombreDeEstudiantes, i, listaDeEstudiantesConLaMismaNota.length);
            i += listaDeEstudiantesConLaMismaNota.length - 1;
        }
    }


    public void ordenarAlfabetico()
    {
        // Este es facil, se hace los siguientes pasos:
        // 1. Crear un hashmap que enlace el nombre con su nota
        // 2. Ordenas el arreglo de nombreDeEstudiantes alfabeticamente con Array.Sort()
        // 3. Reemplazas ahora en el arreglo de notasFinalDeEstudiantes con la nota correspondiente de cada estudiantes por el hashmap
        //    3.1 Es decir, digamos "Lucas" estaba en indice 10 y ahora esta en el 8 de nombreDeEstudiantes, tambien la nota de Lucas tendra que estar en indice 8 de notas
        // 4. Profit!!, lo completaste

        HashMap<String, Double> hashmap = new HashMap<>();
        for(int i = 0; i < nombreDeEstudiantes.length; i++)
        {
            hashmap.put(nombreDeEstudiantes[i], notaFinalDeEstudiantes[i]);
        }
        Arrays.sort(nombreDeEstudiantes);
        for(int i = 0; i < nombreDeEstudiantes.length; i++)
        {
            notaFinalDeEstudiantes[i] = hashmap.get(nombreDeEstudiantes[i]);
        }
    }

    public void imprimirDatos()
    {
        System.out.println("### Imprimiendo la lista de estudiantes con sus notas ###");
        for (int i = 0; i < nombreDeEstudiantes.length; i++)
        {
            System.out.println(nombreDeEstudiantes[i] + " " + notaFinalDeEstudiantes[i]);
        }
    }

    public void seleccionarOrdenacion()
    {
        System.out.println("Por favor seleccione el tipo de ordenacion que desea:");
        System.out.println("1. Ordenar por notas (de menor a mayor).");
        System.out.println("2. Ordenar por el nombre de los estudiantes, alfabeticamente.");
        int opcion = 0;

        while(true) {
            try {
                opcion = Integer.parseInt(br.readLine());
                if (opcion >= 1 && opcion <= 2) {
                    break;
                } else {
                    System.out.println("La opcion introducido no esta disponible, por favor intente poner otra");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("El valor introducido no es un número.");
                System.out.println("Por favor intente de nuevo poniendo un número:");
            } catch (Exception e) {
                System.err.println("Hubo algun tipo de error.");
            }
        }

        switch (opcion)
        {
            case 1:
                ordenarPorNotas();
                System.out.println("Se ordeno por orden de notas de menor a mayor.");
                break;
            case 2:
                ordenarAlfabetico();
                System.out.println("Se ordeno de manera alfabetica.");
                break;
            default:
                System.out.println("La opcion elegida no es valida.");
                break;
        }
    }
}