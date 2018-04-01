/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler_utils;

import Pojos_BBDD1.Ciudad;
import Pojos_BBDD1.Pais;
import Pojos_BBDD1.Provincia;
import Pojos_BBDD2.ComunidadAutonoma;
import Pojos_BBDD2.Province;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Es la clase controladora
 *
 * @author Ali
 */
public class Operaciones {

    static final int COD_ESPANIA = 724;
    static final int COD_ANDALUCIA = 1;
    //DATOS:
    static Set<Ciudad> ciudades = new HashSet();
    static Set<Provincia> provincias = new HashSet();
    static Set<Province> provincias2 = new HashSet();

    static Set<Provincia> lista_provincias = new HashSet();
    static Set<Ciudad> lista_ciudades = new HashSet();
    static Set<ComunidadAutonoma> lista_comunidades = new HashSet();

    //Provincias
    static String[] prov = {"Málaga", "Granada", "Almeria", "Jaén", "Córdoba", "Sevilla", "Cádiz", "Huelva"};
    static int[] cod_prov = {29, 18, 4, 23, 14, 41, 11, 21};
    static String[] comunidades_Malaga = {"Málaga", "Cártama"};    //29:Malaga code prov
    static int[] cod_ciu_malaga = {672, 385};

    static String[] comunidades_Granada = {"Granada", "Gorafe"};       //18:Granada code prov
    static int[] cod_ciu_granada = {877, 861};

    static String[] comunidades_Almeria = {"Almería", "Arboleas"};       //04:Almeria code prov
    static int[] cod_ciu_almeria = {139, 176};

    static String[] comunidades_Jaen = {"Jaén", "Baeza"};       //23:Jaen code prov
    static int[] cod_ciu_jaen = {503, 98};

    static String[] comunidades_Cordoba = {"Córdoba", "Baena"};       //14:Cordoba code prov
    static int[] cod_ciu_cordoba = {214, 76};

    static String[] comunidades_Sevilla = {"Sevilla", "Pedrera"};       //41:Sevilla code prov
    static int[] cod_ciu_sevilla = {917, 726};

    static String[] comunidades_Cadiz = {"Cádiz", "Bornos"};       //11:Cadiz code prov
    static int[] cod_ciu_cadiz = {125, 103};

    static String[] comunidades_Huelva = {"Huelva", "Cartaya"};       //21:Jaen code prov
    static int[] cod_ciu_huelva = {412, 216};

    Pais pais1 = new Pais(1, "España");

    //INSERTS
    /**
     * Para insertar un ciudad
     *
     * @param ciudad
     */
    public static void altaCiudades(Ciudad ciudad) {

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(ciudad);
        tx.commit();
        session.close();
        System.out.println("Se ha insertado la ciudad en la BBDD satisfactoriamente");

    }

    /**
     * Para insertar un pais
     *
     * @param pais
     */
    public static void altaPaises(Pais pais) {

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pais);
        tx.commit();
        session.close();
        System.out.println("Se ha insertado el pais en la BBDD satisfactoriamente");

    }

    /**
     * Para insertar una provincia en la BBDD1
     *
     * @param provincia
     */
    public static void altaProvincias(Provincia provincia) {

        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();

        System.out.println("Empezando transaccion de provinicia, mi país es: " + provincia.getPais().getNombrePais());
        System.out.println("Y mis ciudades son: " + provincia.getCiudads().size());

        Iterator<Ciudad> it = provincia.getCiudads().iterator();
        while (it.hasNext()) {
            Ciudad c = it.next();
            System.out.println(c.getNombre());
        }
        Transaction tx = session.beginTransaction();
        session.save(provincia);
        tx.commit();
        session.close();
        System.out.println("Se ha insertado la provincia " + provincia.getNombre() + " en la BBDD1 satisfactoriamente");
    }

    /**
     * Pasra insertar una provincia de la BBDD2
     *
     * @param provincia
     */
    public static void altaProvincias2(Province provincia) {
        SessionFactory sesion2 = NewHibernateUtil1.getSessionFactory();
        Session session2;
        session2 = sesion2.openSession();

        System.out.println("Empezando transaccion de provincia, mi comunidad autónoma es: " + provincia.getComunidadAutonoma());
        System.out.println("Y el nombre de la provincia es: " + provincia.getNombreProv());

        Transaction tx2 = session2.beginTransaction();
        session2.save(provincia);
        tx2.commit();
        session2.close();
        System.out.println("Se ha insertado la provincia " + provincia.getNombreProv() + " en la BBDD2");

    }

    /**
     * Pra insertar la comunidad autonoma en la BBDD2
     *
     * @param comunidad
     */
    public static void altaComunidadAutonoma(ComunidadAutonoma comunidad) {

        SessionFactory sesion2 = NewHibernateUtil1.getSessionFactory();
        Session session2;
        session2 = sesion2.openSession();
        System.out.println("Codigo comunidad es: " + comunidad.getCodCom());
        System.out.println("Empezando transaccion de comunidad autonoma...");

        Transaction tx2 = session2.beginTransaction();

        if (comunidad != null) {
            session2.save(comunidad);
        } else {
            System.out.println("La comunidad supuestamente es nula");
        }

        tx2.commit();
        session2.close();
        System.out.println("Se ha insertado la comunidad autonoma en la BBDD2 satisfactoriamente");

    }

    //SELECTS
    /**
     *
     * @param nombre
     * @return PROVINCIA SEGUN EL NOMBRE
     */
    public Provincia buscarProvincia(String nombre) {
        Provincia prov;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        prov = (Provincia) session.get(Provincia.class, nombre);
        tx.commit();
        session.close();
        return prov;
    }

    /**
     * Ç
     *
     * @param nombre
     * @return CIUDAD SEGUN EL NOMBRE
     */
    public Ciudad buscarCiudad(String nombre) {
        Ciudad ciud;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        ciud = (Ciudad) session.get(Ciudad.class, nombre);
        tx.commit();
        session.close();
        return ciud;
    }

    /**
     *
     * @param nombre
     * @return PAIS SEGUN EL NOMBRE
     */
    public Pais buscarPais(String nombre) {
        Pais pais;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        pais = (Pais) session.get(Pais.class, nombre);
        tx.commit();
        session.close();
        return pais;
    }

    /**
     *
     * @param nombre
     * @return COMUNIDAD AUTONOMA SEGUN EL NOMBRE
     */
    public ComunidadAutonoma buscarComunidadAutonoma(String nombre) {
        ComunidadAutonoma com;
        SessionFactory sesion2 = NewHibernateUtil.getSessionFactory();
        Session session2;
        session2 = sesion2.openSession();
        Transaction tx2 = session2.beginTransaction();
        com = (ComunidadAutonoma) session2.get(ComunidadAutonoma.class, nombre);
        tx2.commit();
        session2.close();
        return com;
    }

    //LISTAS
    /**
     *
     * @return ciudades desde la BBDD
     */
    public static List listaCiudades() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("SELECT c FROM Cuidad c ");
        List ciudades = q.list();
        tx.commit();
        session.close();
        return ciudades;
    }

    /**
     * Metodo principal para devolver toda la informacion desde las 2 BBDD's
     */
    public static void listaInfoQuery() {
        String info = "";
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Pojos_BBDD1.Ciudad ");
        List<Ciudad> ciudades = q.list();
        for (Ciudad c : ciudades) {
            info = "Ciudad: " + c.getNombre() + " - Provicia: " + c.getProvincia().getNombre() + " - Comunidad autónoma: " + getCom(c) + " - País: " + c.getProvincia().getPais().getNombrePais();
            System.out.println(info);
        }
        tx.commit();
        session.close();
        System.exit(0);

    }

    /**
     *
     * @param c Traido desde la BBDD1
     * @return String que se va a juntar con info para determinar la comunidad
     * autonoma
     */
    public static String getCom(Ciudad c) {
        String adicional = "";
        SessionFactory sesion = NewHibernateUtil1.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Pojos_BBDD2.ComunidadAutonoma ");
        List<ComunidadAutonoma> comunidades = q.list();
        Set<Province> setProv;
        for (ComunidadAutonoma com : comunidades) {       //Comunidades traidas desde la BBDD2
            setProv = com.getProvinces();
            for (Province p : setProv) {
                if (p.getCodProv() == c.getProvincia().getCodProv()) {
                    adicional = com.getNombreCom();
                }
            }
        }
        tx.commit();
        session.close();
        return adicional;
    }

    /**
     *
     * @return provincias de la BBDD2
     */
    public static List listaComunidades() {
        SessionFactory sesion = NewHibernateUtil1.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from comunidad_autonoma");
        List provincias = q.list();
        tx.commit();
        session.close();
        return provincias;
    }

    /**
     * Metodo para mapear los datos
     */
    public static void rellenarDatosBBDD() {
        /**
         * Insertamos la comunidad autonoma de Andalucía
         */
        ComunidadAutonoma com = new ComunidadAutonoma();
        com.setCodCom(COD_ANDALUCIA);
        com.setNombreCom("Andalucía");

        //Creamos las provincias primero con el nombre y el codigo correspondiente
        for (int i = 0; i < prov.length; i++) {
            Provincia provincia = new Provincia();
            Province provincia2 = new Province();
            provincia.setNombre(prov[i]);
            provincia2.setNombreProv(prov[i]);
            provincia.setCodProv(cod_prov[i]);
            provincia2.setCodProv(cod_prov[i]);
            provincia2.setComunidadAutonoma(com);

            provincias.add(provincia);
            provincias2.add(provincia2);

            if (provincia.getNombre().equals("Málaga")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Malaga.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Malaga[j]);
                    ciud.setCodCiudad(cod_ciu_malaga[j]);
                    ciud.setProvincia(provincia);   //Aki
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Granada")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Granada.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Granada[j]);
                    ciud.setCodCiudad(cod_ciu_granada[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Almeria")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Almeria.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Almeria[j]);
                    ciud.setCodCiudad(cod_ciu_almeria[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Jaén")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Jaen.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Jaen[j]);
                    ciud.setCodCiudad(cod_ciu_jaen[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Córdoba")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Cordoba.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Cordoba[j]);
                    ciud.setCodCiudad(cod_ciu_cordoba[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Sevilla")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Sevilla.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Sevilla[j]);
                    ciud.setCodCiudad(cod_ciu_sevilla[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Cádiz")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Cadiz.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Cadiz[j]);
                    ciud.setCodCiudad(cod_ciu_cadiz[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);

            }

            if (provincia.getNombre().equals("Huelva")) {
                Set cities = new HashSet();
                for (int j = 0; j < comunidades_Huelva.length; j++) {
                    Ciudad ciud = new Ciudad();
                    ciud.setNombre(comunidades_Huelva[j]);
                    ciud.setCodCiudad(cod_ciu_huelva[j]);
                    ciud.setProvincia(provincia);
                    ciudades.add(ciud);
                    cities.add(ciud);
                }
                provincia.setCiudads(cities);
            }
        }
        Pais espania = new Pais(COD_ESPANIA, "España");
        System.out.println("Las provincias de la primera BBDD es: ");
        for (Provincia p : provincias) {
            p.setPais(espania);
            System.out.println(p);
        }

        //Ingresamos todas las provincias al pais España
        espania.setProvincias(provincias);

        //com.setProvinces(provincias2);                //******************
        System.out.println("Las provincias de la segunda BBDD es: ");
        for (Province p2 : provincias2) {

            System.out.println(p2);
        }

        System.out.println("El tamaño del set es: " + provincias.size());

        System.out.println("Se han insertado los datos en los objetos satisfactoriamente!");

    }

    /**
     * Metodo para insertar los datos en la BBDD1
     */
    public static void insertarDatosBBDD1() {

        altaPaises(new Pais(COD_ESPANIA, "España"));
        System.out.println("provincias: " + provincias.size());
        for (Provincia p : provincias) {
            System.out.println("Voy a insertar la provincia " + p.getNombre());
            altaProvincias(p);
        }
        System.out.println("Se han insertado las provincias satisfactoriamente!");

        for (Ciudad c : ciudades) {
            System.out.println(c);
            altaCiudades(c);
        }
        System.out.println("Se han insertado las ciudades satisfactoriamente!");

    }

    /**
     * Metodo para insertar los datos en la BBDD2
     */
    public static void insertarDatosBBDD2() {
        //Insertamos en la BBDD2 la comunidad autonoma
        ComunidadAutonoma com = new ComunidadAutonoma();
        com.setCodCom(COD_ANDALUCIA);
        com.setNombreCom("Andalucía");
        //com.setProvinces(provincias2);

        System.out.println("El set de las provincias 2 es:");
        System.out.println(provincias2);

        System.out.println("La comunidad autonoma declarada es: " + com.getNombreCom());
        System.out.println("Procedemos a dar de alta a la com");    //********
        try {
            altaComunidadAutonoma(com);
        } catch (MappingException e) {
            e.printStackTrace();
        }
        System.out.println("Se han insertado la comunidad autónoma satisfactoriamente!");

        System.out.println("Tamaño set provincias BBDD2: " + provincias2.size());
        /*for (Province p2 : provincias2) {
            System.out.println("Voy a insertar la provincia " + p2.getNombreProv()+" cuya com auton es: "+p2.getComunidadAutonoma().getNombreCom());
            p2.setComunidadAutonoma(com);
            altaProvincias2(p2);
        }*/
        Iterator<Province> it = provincias2.iterator();
        while (it.hasNext()) {
            Province p = it.next();
            //p.setComunidadAutonoma(com);
            altaProvincias2(p);
        }
        System.out.println("Se han insertado las provincias satisfactoriamente en la BBDD2!");
    }
}
