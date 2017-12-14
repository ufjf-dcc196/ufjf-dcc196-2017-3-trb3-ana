package br.ufjf.dcc196.ana.taskapp.model;

import java.util.ArrayList;

public class Estado {
    public static int FAZER = 1;
    public static int FAZENDO = 2;
    public static int BLOQUEADO = 3;
    public static int FEITO = 4;

    public static String get(int estado){
        switch (estado){
            case 1:
                return "Fazer";
            case 2:
                return "Fazendo";
            case 3:
                return "Bloqueado";
            case 4:
                return "Feito";
            default:
                return "Fazer";
        }
    }
}
