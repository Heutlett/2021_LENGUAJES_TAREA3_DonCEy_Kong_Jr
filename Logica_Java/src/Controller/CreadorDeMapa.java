package Controller;

import Models.Entidades.Entidad;
import Models.Entidades.Estaticas.EntidadEstatica;
import Models.Entidades.Utils.PuntoMatriz;

public class CreadorDeMapa {

    private Entidad[][] matriz;
    private EntidadEstatica[] lianas;
    private EntidadEstatica[] plataformas;
    private EntidadEstatica[] agua;


    public CreadorDeMapa(Entidad[][] matriz, EntidadEstatica[] lianas, EntidadEstatica[] plataformas, EntidadEstatica[] agua) {
        this.matriz = matriz;
        this.lianas = lianas;
        this.plataformas = plataformas;
        this.agua = agua;
    }

    public void inicializarMapa(){
        crearPlataformaPrueba();
        crearPlataformas();
        crearLianaPrueba();
        crearLianas();
    }


    public void crearPlataformas(){
        for(int i = 0; i < plataformas.length; i++){
            if(plataformas[i] != null){
                for(int e = 0; e < plataformas[i].getArea().length; e++){
                    matriz[plataformas[i].getArea()[e].getFila()][plataformas[i].getArea()[e].getColumna()] = plataformas[i];
                }
            }
        }
    }

    public void crearLianas(){
        for(int i = 0; i < lianas.length; i++){
            if(lianas[i] != null){
                for(int e = 0; e < lianas[i].getArea().length; e++){
                    matriz[lianas[i].getArea()[e].getFila()][lianas[i].getArea()[e].getColumna()] = lianas[i];
                }
            }
        }
    }

    private void crearPlataformaPrueba(){

        EntidadEstatica plataforma = new EntidadEstatica(null, null, null, null);
        plataforma.setId("plataforma0");
        plataforma.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma.setArea(new PuntoMatriz[36]);
        int contador = 0;
        for(int i = 29; i < 38; i++){
            plataforma.getArea()[contador] = new PuntoMatriz(9, i);
            contador++;
            plataforma.getArea()[contador] = new PuntoMatriz(10, i);
            contador++;
            plataforma.getArea()[contador] = new PuntoMatriz(11, i);
            contador++;
            plataforma.getArea()[contador] = new PuntoMatriz(12, i);
            contador++;
        }

        plataformas[0] = plataforma;

        EntidadEstatica plataforma1 = new EntidadEstatica(null, null, null, null);
        plataforma1.setId("plataforma1");
        plataforma1.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma1.setArea(new PuntoMatriz[236]);
        contador = 0;
        for(int i = 0; i < 59; i++){
            plataforma1.getArea()[contador] = new PuntoMatriz(20, i);
            contador++;
            plataforma1.getArea()[contador] = new PuntoMatriz(21, i);
            contador++;
            plataforma1.getArea()[contador] = new PuntoMatriz(22, i);
            contador++;
            plataforma1.getArea()[contador] = new PuntoMatriz(23, i);
            contador++;
        }

        plataformas[1] = plataforma1;

        EntidadEstatica plataforma2 = new EntidadEstatica(null, null, null, null);
        plataforma2.setId("plataforma2");
        plataforma2.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma2.setArea(new PuntoMatriz[96]);
        contador = 0;
        for(int i = 55; i < 79; i++){
            plataforma2.getArea()[contador] = new PuntoMatriz(24, i);
            contador++;
            plataforma2.getArea()[contador] = new PuntoMatriz(25, i);
            contador++;
            plataforma2.getArea()[contador] = new PuntoMatriz(26, i);
            contador++;
            plataforma2.getArea()[contador] = new PuntoMatriz(27, i);
            contador++;
        }

        plataformas[2] = plataforma2;




        EntidadEstatica plataforma3 = new EntidadEstatica(null, null, null, null);
        plataforma3.setId("plataforma3");
        plataforma3.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma3.setArea(new PuntoMatriz[48]);
        contador = 0;
        for(int i = 19; i < 31; i++){
            plataforma3.getArea()[contador] = new PuntoMatriz(43, i);
            contador++;
            plataforma3.getArea()[contador] = new PuntoMatriz(44, i);
            contador++;
            plataforma3.getArea()[contador] = new PuntoMatriz(45, i);
            contador++;
            plataforma3.getArea()[contador] = new PuntoMatriz(46, i);
            contador++;
        }

        plataformas[3] = plataforma3;

        EntidadEstatica plataforma4 = new EntidadEstatica(null, null, null, null);
        plataforma4.setId("plataforma4");
        plataforma4.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma4.setArea(new PuntoMatriz[104]);
        contador = 0;
        for(int i = 74; i <= 99; i++){
            plataforma4.getArea()[contador] = new PuntoMatriz(54, i);
            contador++;
            plataforma4.getArea()[contador] = new PuntoMatriz(55, i);
            contador++;
            plataforma4.getArea()[contador] = new PuntoMatriz(56, i);
            contador++;
            plataforma4.getArea()[contador] = new PuntoMatriz(57, i);
            contador++;
        }

        plataformas[4] = plataforma4;

        EntidadEstatica plataforma5 = new EntidadEstatica(null, null, null, null);
        plataforma5.setId("plataforma5");
        plataforma5.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma5.setArea(new PuntoMatriz[76]);
        contador = 0;
        for(int i = 19; i < 38; i++){
            plataforma5.getArea()[contador] = new PuntoMatriz(62, i);
            contador++;
            plataforma5.getArea()[contador] = new PuntoMatriz(63, i);
            contador++;
            plataforma5.getArea()[contador] = new PuntoMatriz(64, i);
            contador++;
            plataforma5.getArea()[contador] = new PuntoMatriz(65, i);
            contador++;
        }

        plataformas[5] = plataforma5;

        EntidadEstatica plataforma6 = new EntidadEstatica(null, null, null, null);
        plataforma6.setId("plataforma6");
        plataforma6.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma6.setArea(new PuntoMatriz[112]);
        contador = 0;
        for(int i = 0; i < 28; i++){
            plataforma6.getArea()[contador] = new PuntoMatriz(92, i);
            contador++;
            plataforma6.getArea()[contador] = new PuntoMatriz(93, i);
            contador++;
            plataforma6.getArea()[contador] = new PuntoMatriz(94, i);
            contador++;
            plataforma6.getArea()[contador] = new PuntoMatriz(95, i);
            contador++;
        }

        plataformas[6] = plataforma6;


        EntidadEstatica plataforma7 = new EntidadEstatica(null, null, null, null);
        plataforma7.setId("plataforma7");
        plataforma7.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma7.setArea(new PuntoMatriz[79]);
        contador = 0;
        for(int i = 38; i < 49; i++){
            plataforma7.getArea()[contador] = new PuntoMatriz(84, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(85, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(86, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(87, i);
            contador++;
        }
        for(int i = 41; i < 46; i++){
            plataforma7.getArea()[contador] = new PuntoMatriz(88, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(89, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(90, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(91, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(92, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(93, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(94, i);
            contador++;
        }

        plataformas[7] = plataforma7;



    }

    private void crearLianaPrueba(){

        EntidadEstatica liana = new EntidadEstatica(null, null, null, null);
        liana.setId("liana1");
        liana.setPosicion(new PuntoMatriz(0,23));
        liana.setUltimaPosicion(new PuntoMatriz(20,23));
        liana.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana.setArea(new PuntoMatriz[20]);
        for(int i = 0; i < 20; i++){
            liana.getArea()[i] = new PuntoMatriz(i, 23);
        }

        lianas[0] = liana;

        EntidadEstatica liana2 = new EntidadEstatica(null, null, null, null);
        liana2.setId("liana2");
        liana2.setPosicion(new PuntoMatriz(0,30));
        liana2.setUltimaPosicion(new PuntoMatriz(20,30));
        liana2.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana2.setArea(new PuntoMatriz[20]);
        for(int i = 0; i < 20; i++){
            liana2.getArea()[i] = new PuntoMatriz(i, 30);
        }

        lianas[1] = liana2;

    }

}
