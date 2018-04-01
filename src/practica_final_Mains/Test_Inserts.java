/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_final_Mains;

import controler_utils.Operaciones;

/**
 *Mapear los datos y luego proceder a insertarlos 
 * en las dos bases de datos
 * @author Ali
 */
public class Test_Inserts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Insercion datos en las 2 BBDD's
         */
        Operaciones.rellenarDatosBBDD();
        System.out.println("Datos rellenados correctamente y objetos listos");

        try {
            System.out.println("En proceso para insertar los datos en BBDD Ciudades...");
            Operaciones.insertarDatosBBDD1();
            System.out.println("En proceso para insertar los datos en BBDD Comunidades...");
            Operaciones.insertarDatosBBDD2();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
