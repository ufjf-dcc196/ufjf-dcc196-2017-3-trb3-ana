package br.ufjf.dcc196.ana.taskapp.contract;

import android.provider.BaseColumns;

public class TarefaContract {
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String SEP = ",";

    public static final String SQL_CREATE_TAREFA = "CREATE TABLE " + Tarefa.TABLE_NAME + " (" +
            Tarefa._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Tarefa.COLUMN_NAME_TITULO + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_DESCRICAO + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_GRAU_DIFICULDADE + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_ESTADO + INT_TYPE + ")";

    public static final String SQL_CREATE_TAG = "CREATE TABLE " + Tag.TABLE_NAME + " (" +
            Tag._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Tag.COLUMN_NAME_NOME + TEXT_TYPE + ")";

    public static final String SQL_CREATE_TAREFA_TAG = "CREATE TABLE " + TarefaTag.TABLE_NAME + " (" +
            TarefaTag._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            TarefaTag.COLUMN_NAME_TAREFA + INT_TYPE + SEP +
            TarefaTag.COLUMN_NAME_TAG+ INT_TYPE + SEP +
            " FOREIGN KEY ("+ TarefaTag.COLUMN_NAME_TAREFA + ") REFERENCES "+
            Tarefa.TABLE_NAME + "(" + Tarefa._ID + ")" + SEP +
            " FOREIGN KEY ("+ TarefaTag.COLUMN_NAME_TAG + ") REFERENCES " +
            Tag.TABLE_NAME +"("+Tag._ID + "))";

    public static final String SQL_DROP_TAREFA = "DROP TABLE IF EXISTS " + Tarefa.TABLE_NAME;
    public static final String SQL_DROP_TAG = "DROP TABLE IF EXISTS " + Tag.TABLE_NAME;
    public static final String SQL_DROP_TAREFA_TAG = "DROP TABLE IF EXISTS " + TarefaTag.TABLE_NAME;

    public static final class Tarefa implements BaseColumns{
        public static final String TABLE_NAME = "tarefa";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_GRAU_DIFICULDADE = "grau_dificuldade";
        public static final String COLUMN_NAME_ESTADO = "estado";
        public static final String SQL_CONSULTA_TAREFA = "SELECT * FROM tarefa WHERE " + _ID + " = ?";
        public static final String SQL_CONSULTA_TAREFAS = "SELECT * FROM tarefa WHERE";
    }

    public static final class Tag implements BaseColumns{
        public static final String TABLE_NAME = "tag";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String SQL_CONSULTA_TAG = "SELECT * FROM tag WHERE " + _ID + " = ?";
        public static final String SQL_CONSULTA_TAGS = "SELECT * FROM tag WHERE";
    }

    public static final class TarefaTag implements BaseColumns{
        public static final String TABLE_NAME = "tarefa_tag";
        public static final String COLUMN_NAME_TAREFA = "tarefa_id";
        public static final String COLUMN_NAME_TAG = "tag_id";

        public static final String SQL_CONSULTA_TAREFA_TAGS = "SELECT tarefa._id, " +
                Tarefa.COLUMN_NAME_TITULO + SEP +
                Tarefa.COLUMN_NAME_GRAU_DIFICULDADE + SEP +
                Tarefa.COLUMN_NAME_ESTADO
                + " FROM " + TABLE_NAME +
                " INNER JOIN " + Tarefa.TABLE_NAME +
                " tarefa ON ("+ TarefaTag.COLUMN_NAME_TAREFA +"= tarefa."+ Tarefa._ID + ")"+
                " INNER JOIN "+Tag.TABLE_NAME+
                " tag ON ("+ TarefaTag.COLUMN_NAME_TAG +"= tag."+ Tag._ID + ")" +
                " WHERE " + COLUMN_NAME_TAG + " = ? ";
    }



    public TarefaContract() {
    }
}
