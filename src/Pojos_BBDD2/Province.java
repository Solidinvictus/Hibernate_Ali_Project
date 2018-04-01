package Pojos_BBDD2;
// Generated 27-feb-2018 13:22:57 by Hibernate Tools 4.3.1




/**
 * Province generated by hbm2java
 */

public class Province  implements java.io.Serializable {


     
     private int codProv;
    
     private ComunidadAutonoma comunidadAutonoma;
     
     private String nombreProv;

    public Province() {
    }

	
    public Province(int codProv, ComunidadAutonoma comunidadAutonoma) {
        this.codProv = codProv;
        this.comunidadAutonoma = comunidadAutonoma;
    }
    public Province(int codProv, ComunidadAutonoma comunidadAutonoma, String nombreProv) {
       this.codProv = codProv;
       this.comunidadAutonoma = comunidadAutonoma;
       this.nombreProv = nombreProv;
    }
   
    public int getCodProv() {
        return this.codProv;
    }
    
    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }
    public ComunidadAutonoma getComunidadAutonoma() {
        return this.comunidadAutonoma;
    }
    
    public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }
    public String getNombreProv() {
        return this.nombreProv;
    }
    
    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }
    
     //To String
    public String toString(){
        return "Nombre Provincia: "+this.getNombreProv()+", Codigo: "+this.getCodProv()+"\n"
        + "Comunidad autónoma: "+this.getComunidadAutonoma().getNombreCom();
    }




}

