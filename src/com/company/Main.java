package com.company;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        List<Persona> personaList = new ArrayList<Persona>();
        File fileTxt = new File("src/com/company/archivoPersonas.txt");
        BufferedReader bR;
        String filaTexto;
        Persona person;

        try {
            bR = new BufferedReader(new FileReader(fileTxt));
            while((filaTexto = bR.readLine()) != null){
                person = new Persona();
                String[] tokens = filaTexto.split(":");
                person.setNombre(tokens[0]);
                if(!(tokens.length<3)) {
                    if (tokens[1] == "" || tokens[1] == null) {
                        person.setPoblacion("Desconocida ,");
                    } else {
                        person.setPoblacion(tokens[1]);
                    }
                }else{
                    person.setPoblacion("Desconocida ,");
                }

                if(!(tokens.length<3)) {
                    if (tokens[2] == "" || tokens[2] == null) {
                        person.setEdad(0+"");
                    } else {
                        person.setEdad(tokens[2]);
                    }
                }else{
                    person.setEdad(0+"");
                }
                personaList.add(person);
                // System.out.println(personaList.get(0).toString());
            }

            //Contenido de la lista con los datos del archivo txt
            //System.out.println(personaList);

            //menores de 25 años
            ArrayList resultado = (ArrayList) personaList.stream()
                    .filter(persona -> Integer.parseInt(persona.getEdad()) < 25)
                    .filter(persona -> Integer.parseInt(persona.getEdad()) > 0)
                    .collect(Collectors.toList());
            resultado.forEach(persona -> System.out.println(persona.toString()));

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
