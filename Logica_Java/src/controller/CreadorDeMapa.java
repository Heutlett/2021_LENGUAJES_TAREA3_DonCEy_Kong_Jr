package controller;

import models.entidades.Entidad;
import models.entidades.estaticas.EntidadEstatica;
import models.entidades.utils.PuntoMatriz;

public class CreadorDeMapa {

    private Entidad[][] matriz;
    private EntidadEstatica[] lianas;
    private EntidadEstatica[] plataformas;
    private EntidadEstatica[] agua;
    private EntidadEstatica trofeo;

    public CreadorDeMapa(Entidad[][] matriz, EntidadEstatica[] lianas, EntidadEstatica[] plataformas, EntidadEstatica[]
            agua, EntidadEstatica trofeo) {
        this.matriz = matriz;
        this.lianas = lianas;
        this.plataformas = plataformas;
        this.agua = agua;
        this.trofeo = trofeo;
    }

    public void inicializarMapa(){
        crearPlataformaPrueba();
        crearPlataformas();
        crearLianaPrueba();
        crearLianas();
        crearAguaPrueba();
        crearAgua();
        crearTrofeo();
    }

    public void crearTrofeo(){
        EntidadEstatica trofeo = new EntidadEstatica(null, null, null, null);
        trofeo.setId("trofeo");
        trofeo.setTipoEntidad(Entidad.TipoEntidad.TROFEO);
        trofeo.setArea(new PuntoMatriz[40]);
        int contador = 0;
        for(int i = 45; i < 50; i++){
            trofeo.getArea()[contador] = new PuntoMatriz(5, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(6, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(7, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(8, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(9, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(10, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(11, i);
            contador++;
            trofeo.getArea()[contador] = new PuntoMatriz(12, i);
            contador++;
        }

        for(int e = 0; e < trofeo.getArea().length; e++){
            matriz[ trofeo.getArea()[e].getFila()][trofeo.getArea()[e].getColumna()] = trofeo;
        }
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

    public void crearAgua(){
        for(int i = 0; i < agua.length; i++){
            if(agua[i] != null){
                for(int e = 0; e < agua[i].getArea().length; e++){
                    matriz[agua[i].getArea()[e].getFila()][agua[i].getArea()[e].getColumna()] = agua[i];
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
        plataforma6.setArea(new PuntoMatriz[116]);
        contador = 0;
        for(int i = 0; i < 29; i++){
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
            plataforma7.getArea()[contador] = new PuntoMatriz(85, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(86, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(87, i);
            contador++;
            plataforma7.getArea()[contador] = new PuntoMatriz(88, i);
            contador++;
        }
        for(int i = 41; i < 46; i++){
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
            plataforma7.getArea()[contador] = new PuntoMatriz(95, i);
            contador++;
        }
        plataformas[7] = plataforma7;

        EntidadEstatica plataforma8 = new EntidadEstatica(null, null, null, null);
        plataforma8.setId("plataforma8");
        plataforma8.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma8.setArea(new PuntoMatriz[39]);
        contador = 0;
        for(int i = 53; i < 62; i++){
            plataforma8.getArea()[contador] = new PuntoMatriz(91, i);
            contador++;
            plataforma8.getArea()[contador] = new PuntoMatriz(90, i);
            contador++;
            plataforma8.getArea()[contador] = new PuntoMatriz(89, i);
            contador++;
        }
        for(int i = 56; i < 59; i++){
            plataforma8.getArea()[contador] = new PuntoMatriz(95, i);
            contador++;
            plataforma8.getArea()[contador] = new PuntoMatriz(94, i);
            contador++;
            plataforma8.getArea()[contador] = new PuntoMatriz(93, i);
            contador++;
            plataforma8.getArea()[contador] = new PuntoMatriz(92, i);
            contador++;
        }

        plataformas[8] = plataforma8;

        EntidadEstatica plataforma9 = new EntidadEstatica(null, null, null, null);
        plataforma9.setId("plataforma9");
        plataforma9.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma9.setArea(new PuntoMatriz[84]);
        contador = 0;
        for(int i = 69; i < 74; i++){
            plataforma9.getArea()[contador] = new PuntoMatriz(88, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(89, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(90, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(91, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(92, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(93, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(94, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(95, i);
            contador++;
        }
        for(int i = 66; i < 77; i++){
            plataforma9.getArea()[contador] = new PuntoMatriz(84, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(85, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(86, i);
            contador++;
            plataforma9.getArea()[contador] = new PuntoMatriz(87, i);
            contador++;
        }

        plataformas[9] = plataforma9;

        EntidadEstatica plataforma10 = new EntidadEstatica(null, null, null, null);
        plataforma10.setId("plataforma10");
        plataforma10.setTipoEntidad(Entidad.TipoEntidad.PLATAFORMA);
        plataforma10.setArea(new PuntoMatriz[99]);
        contador = 0;
        for(int i = 84; i < 89; i++){
            plataforma10.getArea()[contador] = new PuntoMatriz(85, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(86, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(87, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(88, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(89, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(90, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(91, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(92, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(93, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(94, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(95, i);
            contador++;

        }
        for(int i = 81; i < 92; i++){
            plataforma10.getArea()[contador] = new PuntoMatriz(84, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(83, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(82, i);
            contador++;
            plataforma10.getArea()[contador] = new PuntoMatriz(81, i);
            contador++;
        }
        plataformas[10] = plataforma10;
    }

    private void crearLianaPrueba(){

        EntidadEstatica liana = new EntidadEstatica(null, null, null, null);
        liana.setId("liana0");
        liana.setPosicion(new PuntoMatriz(24,8));
        liana.setUltimaPosicion(new PuntoMatriz(84,8));
        liana.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana.setArea(new PuntoMatriz[60]);
        int contador = 0;
        for(int i = 24; i < 84; i++){
            liana.getArea()[contador] = new PuntoMatriz(i, 8);
            contador++;
        }

        lianas[0] = liana;

        EntidadEstatica liana1 = new EntidadEstatica(null, null, null, null);
        liana1.setId("liana1");
        liana1.setPosicion(new PuntoMatriz(24,17));
        liana1.setUltimaPosicion(new PuntoMatriz(80,17));
        liana1.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana1.setArea(new PuntoMatriz[57]);
        contador = 0;
        for(int i = 24; i <= 80; i++){
            liana1.getArea()[contador] = new PuntoMatriz(i, 17);
            contador++;
        }

        lianas[1] = liana1;

        EntidadEstatica liana2 = new EntidadEstatica(null, null, null, null);
        liana2.setId("liana2");
        liana2.setPosicion(new PuntoMatriz(47,26));
        liana2.setUltimaPosicion(new PuntoMatriz(61,26));
        liana2.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana2.setArea(new PuntoMatriz[15]);
        contador = 0;
        for(int i = 47; i <= 61; i++){
            liana2.getArea()[contador] = new PuntoMatriz(i, 26);
            contador++;
        }

        lianas[2] = liana2;

        EntidadEstatica liana3 = new EntidadEstatica(null, null, null, null);
        liana3.setId("liana3");
        liana3.setPosicion(new PuntoMatriz(66,26));
        liana3.setUltimaPosicion(new PuntoMatriz(84,26));
        liana3.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana3.setArea(new PuntoMatriz[19]);
        contador = 0;
        for(int i = 66; i <= 84; i++){
            liana3.getArea()[contador] = new PuntoMatriz(i, 26);
            contador++;
        }

        lianas[3] = liana3;

        EntidadEstatica liana4 = new EntidadEstatica(null, null, null, null);
        liana4.setId("liana4");
        liana4.setPosicion(new PuntoMatriz(24,41));
        liana4.setUltimaPosicion(new PuntoMatriz(72,41));
        liana4.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana4.setArea(new PuntoMatriz[49]);
        contador = 0;
        for(int i = 24; i <= 72; i++){
            liana4.getArea()[contador] = new PuntoMatriz(i, 41);
            contador++;
        }

        lianas[4] = liana4;

        EntidadEstatica liana5 = new EntidadEstatica(null, null, null, null);
        liana5.setId("liana5");
        liana5.setPosicion(new PuntoMatriz(24,52));
        liana5.setUltimaPosicion(new PuntoMatriz(57,52));
        liana5.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana5.setArea(new PuntoMatriz[34]);
        contador = 0;
        for(int i = 24; i <= 57; i++){
            liana5.getArea()[contador] = new PuntoMatriz(i, 52);
            contador++;
        }

        lianas[5] = liana5;

        EntidadEstatica liana6 = new EntidadEstatica(null, null, null, null);
        liana6.setId("liana6");
        liana6.setPosicion(new PuntoMatriz(28,63));
        liana6.setUltimaPosicion(new PuntoMatriz(72,63));
        liana6.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana6.setArea(new PuntoMatriz[45]);
        contador = 0;
        for(int i = 28; i <= 72; i++){
            liana6.getArea()[contador] = new PuntoMatriz(i, 63);
            contador++;
        }

        lianas[6] = liana6;

        EntidadEstatica liana7 = new EntidadEstatica(null, null, null, null);
        liana7.setId("liana7");
        liana7.setPosicion(new PuntoMatriz(28,72));
        liana7.setUltimaPosicion(new PuntoMatriz(65,72));
        liana7.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana7.setArea(new PuntoMatriz[38]);
        contador = 0;
        for(int i = 28; i <= 65; i++){
            liana7.getArea()[contador] = new PuntoMatriz(i, 72);
            contador++;
        }

        lianas[7] = liana7;

        EntidadEstatica liana8 = new EntidadEstatica(null, null, null, null);
        liana8.setId("liana8");
        liana8.setPosicion(new PuntoMatriz(58,81));
        liana8.setUltimaPosicion(new PuntoMatriz(73,81));
        liana8.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana8.setArea(new PuntoMatriz[16]);
        contador = 0;
        for(int i = 58; i <= 73; i++){
            liana8.getArea()[contador] = new PuntoMatriz(i, 81);
            contador++;
        }

        lianas[8] = liana8;

        EntidadEstatica liana9 = new EntidadEstatica(null, null, null, null);
        liana9.setId("liana9");
        liana9.setPosicion(new PuntoMatriz(58,91));
        liana9.setUltimaPosicion(new PuntoMatriz(73,91));
        liana9.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana9.setArea(new PuntoMatriz[16]);
        contador = 0;
        for(int i = 58; i <= 73; i++){
            liana9.getArea()[contador] = new PuntoMatriz(i, 91);
            contador++;
        }

        lianas[9] = liana9;

        EntidadEstatica liana10 = new EntidadEstatica(null, null, null, null);
        liana10.setId("liana10");
        liana10.setPosicion(new PuntoMatriz(13,81));
        liana10.setUltimaPosicion(new PuntoMatriz(53,81));
        liana10.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana10.setArea(new PuntoMatriz[41]);
        contador = 0;
        for(int i = 13; i <= 53; i++){
            liana10.getArea()[contador] = new PuntoMatriz(i, 81);
            contador++;
        }

        lianas[10] = liana10;

        EntidadEstatica liana11 = new EntidadEstatica(null, null, null, null);
        liana11.setId("liana11");
        liana11.setPosicion(new PuntoMatriz(13,91));
        liana11.setUltimaPosicion(new PuntoMatriz(53,91));
        liana11.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana11.setArea(new PuntoMatriz[41]);
        contador = 0;
        for(int i = 13; i <= 53; i++){
            liana11.getArea()[contador] = new PuntoMatriz(i, 91);
            contador++;
        }

        lianas[11] = liana11;

        EntidadEstatica liana12 = new EntidadEstatica(null, null, null, null);
        liana12.setId("liana12");
        liana12.setPosicion(new PuntoMatriz(5,60));
        liana12.setUltimaPosicion(new PuntoMatriz(9,60));
        liana12.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana12.setArea(new PuntoMatriz[5]);
        contador = 0;
        for(int i = 5; i <= 9; i++){
            liana12.getArea()[contador] = new PuntoMatriz(i, 60);
            contador++;
        }

        lianas[12] = liana12;

        EntidadEstatica liana13 = new EntidadEstatica(null, null, null, null);
        liana13.setId("liana13");
        liana13.setPosicion(new PuntoMatriz(5,42));
        liana13.setUltimaPosicion(new PuntoMatriz(12,42));
        liana13.setTipoEntidad(Entidad.TipoEntidad.LIANA);
        liana13.setArea(new PuntoMatriz[8]);
        contador = 0;
        for(int i = 5; i <= 12; i++){
            liana13.getArea()[contador] = new PuntoMatriz(i, 42);
            contador++;
        }
        lianas[13] = liana13;
    }

    private void crearAguaPrueba(){

        EntidadEstatica aguaNueva = new EntidadEstatica(null, null, null, null);
        aguaNueva.setId("agua");
        aguaNueva.setPosicion(new PuntoMatriz(0,0));
        aguaNueva.setUltimaPosicion(new PuntoMatriz(0,0));
        aguaNueva.setTipoEntidad(Entidad.TipoEntidad.AGUA);
        aguaNueva.setArea(new PuntoMatriz[400]);
        int contador = 0;
        for(int i = 0; i <= 99; i++){
            aguaNueva.getArea()[contador] = new PuntoMatriz(99, i);
            contador++;
            aguaNueva.getArea()[contador] = new PuntoMatriz(98, i);
            contador++;
            aguaNueva.getArea()[contador] = new PuntoMatriz(97, i);
            contador++;
            aguaNueva.getArea()[contador] = new PuntoMatriz(96, i);
            contador++;
        }
        agua[0] = aguaNueva;
    }
}
