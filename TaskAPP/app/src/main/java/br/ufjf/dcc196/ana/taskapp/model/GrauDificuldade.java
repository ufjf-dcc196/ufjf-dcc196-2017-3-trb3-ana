package br.ufjf.dcc196.ana.taskapp.model;


public class GrauDificuldade {
    public static int MUITO_FACIL = 1;
    public static int FACIL =2;
    public static int MEDIO = 3;
    public static int DIFICIL = 4;
    public static int MUITO_DIFICIL = 5;

    public static String get(int grau){
        switch (grau){
            case 1:
                return "Muito Fácil";
            case 2:
                return "Fácil";
            case 3:
                return "Médio";
            case 4:
                return "Difícil";
            case 5:
                return "Muito Difícil";
            default:
                return "";
        }
    }
}
