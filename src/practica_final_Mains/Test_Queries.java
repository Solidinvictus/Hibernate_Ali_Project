/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_final_Mains;

import controler_utils.NewHibernateUtil;
import controler_utils.Operaciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *Main para hacer las consultas a las bases de datos
 * Listar ciudadades con sus provincias correpondientes,
 *comunidad autonoma y el país a las que pertenecen.
 * @author Ali
 */
public class Test_Queries {
    
    public static void main(String[] args){
        /**
         * Listar ciudadades con sus provincias correpondientes,
         * comunidad autonoma y el país a las que pertenecen.
         */
        Operaciones.listaInfoQuery();
        
    }
    
}
