/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin_14;

import javax.swing.JOptionPane;

/**
 *
 * @author jalvarezotero
 */
public class ConversorTemperaturas {

    //Atributos
    private final float TE = 80f;
    private float temperatura;

    //Excepcion DEfinida, introducimos la temperatura y si no es correcta lanzamos la excepcion TemperaturaErradaExcepcion.
    public void temperaturaExcepcionDefinida() throws TemperaturaErradaExcepcion {
        temperatura = Float.parseFloat(JOptionPane.showInputDialog("Introduce la temperatura en grados centígrados"));
        if (temperatura < 80f) {
            throw new TemperaturaErradaExcepcion("Temperatura inferior a 80 grados Celsius");
        }
    }

    //Metodo menu, dóndo uso el try/catch para tratar la excepcion, y en el que utilizo los métodos de conversión de temperaturas.
    public void menu() {
        int opt = 0;
        do {
            try {
                temperaturaExcepcionDefinida();
                opt = Integer.parseInt(JOptionPane.showInputDialog("1.Convertir Céntigrados a Fharenheit.\n2.Convertir centígrados a eeamur.\n3.Salir. "));
                switch (opt) {
                    case 1:
                        //Lanzamos el método de conversión a Farenheit, solo se ejecutará si no ha saltado la excepción.
                        System.out.println("Fharenheit = " + centigradosAFharenheit(temperatura));
                        break;
                    case 2:
                        //Lanzamos el método de conversión a Reamur, solo se ejecutará si no ha saltado la excepción.
                        System.out.println("Reamur = " + centígradosAReamur(temperatura));
                        break;
                    case 3:
                        //Salimos del programa.
                        System.out.println("Fin programa.");
                        break;
                    default:
                        System.out.println("Error");
                }
                //Si salta la excepcion se ejecutará esto, y al estar dentro del bucle , 
                //podremos seguir con el programa e introducir otra temperatura.
            } catch (TemperaturaErradaExcepcion e2) {
                System.out.println(e2.getMessage());
            }
        } while (opt != 3);
    }
//Método que recibe una temperatura en Centígrados y nos devuelve una en Fharenheit, las dos float.

    public float centigradosAFharenheit(float temp) {
        float temperaturaF = 9f / 5f * temp + 32.4f;
        return temperaturaF;
    }
//Método que recibe una temperatura en Centígrados y nos devuelve una en Reamur, las dos float.

    public float centígradosAReamur(float temp) {
        float temperaturaR = 4f / 5f * temp;
        return temperaturaR;
    }
}