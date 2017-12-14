package br.ufjf.dcc196.ana.taskapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.ufjf.dcc196.ana.taskapp.contract.TarefaContract;

public class TarefaDBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "task.db";


    public TarefaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(TarefaContract.SQL_CREATE_TAREFA);
            sqLiteDatabase.execSQL(TarefaContract.SQL_CREATE_TAG);
            sqLiteDatabase.execSQL(TarefaContract.SQL_CREATE_TAREFA_TAG);
            Log.i("TAREFA DB", "Tabelas criadas com sucesso.");
        }catch (Exception e) {
            Log.e("TAREFA DB", "Criação de tabelas");
            Log.e("TAREFA DB", e.getLocalizedMessage());
            Log.e("TAREFA DB", e.getStackTrace().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(TarefaContract.SQL_DROP_TAREFA);
        sqLiteDatabase.execSQL(TarefaContract.SQL_DROP_TAG);
        sqLiteDatabase.execSQL(TarefaContract.SQL_DROP_TAREFA_TAG);
        Log.i("TAREFA DB", "Atualização do banco. Versão:" + oldVersion + " => " + newVersion);
    }

    @Override
    public  void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        onUpgrade(sqLiteDatabase,oldVersion,newVersion);
    }
}
