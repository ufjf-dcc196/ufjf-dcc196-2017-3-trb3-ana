package br.ufjf.dcc196.ana.taskapp.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.ufjf.dcc196.ana.taskapp.contract.TarefaContract;
import br.ufjf.dcc196.ana.taskapp.helper.TarefaDBHelper;
import br.ufjf.dcc196.ana.taskapp.model.Tarefa;

public class TarefaDAO extends TarefaDBHelper{

    public TarefaDAO(Context context) {
        super(context);
    }

    public void inserir(Tarefa tarefa){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TarefaContract.Tarefa.TABLE_NAME, null, setValues(tarefa));
        }catch (Exception e){
            Log.e("TAREFA INSERIR - ", e.getLocalizedMessage());
            Log.e("TAREFA INSERIR - ", e.getStackTrace().toString());
        }
    }

    public void alterar(Tarefa tarefa){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String[] args = {String.valueOf(tarefa.getId())};
            db.update(TarefaContract.Tarefa.TABLE_NAME, setValues(tarefa),TarefaContract.Tarefa._ID +" = ?", args );
        }catch (Exception e){
            Log.e("TAREFA ALTERAR - ", e.getLocalizedMessage());
            Log.e("TAREFA ALTERAR - ", e.getStackTrace().toString());
        }
    }

    public void excluir(int id){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String[] args = {String.valueOf(id)};
            db.delete(TarefaContract.Tarefa.TABLE_NAME, TarefaContract.Tarefa._ID +" = ?", args);
        }catch (Exception e){
            Log.e("TAREFA EXCLUIR - ", e.getLocalizedMessage());
            Log.e("TAREFA EXCLUIR - ", e.getStackTrace().toString());
        }
    }

    public Tarefa buscar(int id){
        try {
           SQLiteDatabase db = getReadableDatabase();
           String[] args = {String.valueOf(id)};
           Cursor cursor = db.rawQuery(TarefaContract.Tarefa.SQL_CONSULTA_TAREFA,  args);
           cursor.moveToFirst();
           return getValues(cursor);
        }catch (Exception e){
            Log.e("TAREFA BUSCAR - ", e.getLocalizedMessage());
            Log.e("TAREFA BUSCAR - ", e.getStackTrace().toString());
        }
        return null;
    }

    public ArrayList<Tarefa> listar(){
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(TarefaContract.Tarefa.SQL_CONSULTA_TAREFAS, null);
            ArrayList<Tarefa> lista = new ArrayList<>();
            while(cursor.moveToNext()){
                lista.add(getValues(cursor));
            }
            return lista;
        }catch (Exception e){
            Log.e("TAREFA LISTAR - ", e.getLocalizedMessage());
            Log.e("TAREFA LISTAR - ", e.getStackTrace().toString());
        }
        return null;
    }

    private ContentValues setValues(Tarefa tarefa){
        ContentValues values = new ContentValues();
        values.put(TarefaContract.Tarefa.COLUMN_NAME_TITULO, tarefa.getTitulo());
        values.put(TarefaContract.Tarefa.COLUMN_NAME_DESCRICAO, tarefa.getDescricao());
        values.put(TarefaContract.Tarefa.COLUMN_NAME_GRAU_DIFICULDADE, tarefa.getGrau_dificuldade());
        values.put(TarefaContract.Tarefa.COLUMN_NAME_ESTADO, tarefa.getEstado());
        return values;
    }

    private Tarefa getValues(Cursor cursor){
        Tarefa tarefa = new Tarefa();
        tarefa.setId(cursor.getInt(cursor.getColumnIndex(TarefaContract.Tarefa._ID)));
        tarefa.setTitulo(cursor.getString(cursor.getColumnIndex(TarefaContract.Tarefa.COLUMN_NAME_TITULO)));
        tarefa.setDescricao(cursor.getString(cursor.getColumnIndex(TarefaContract.Tarefa.COLUMN_NAME_DESCRICAO)));
        tarefa.setGrau_dificuldade(cursor.getInt(cursor.getColumnIndex(TarefaContract.Tarefa.COLUMN_NAME_GRAU_DIFICULDADE)));
        tarefa.setEstado(cursor.getInt(cursor.getColumnIndex(TarefaContract.Tarefa.COLUMN_NAME_ESTADO)));
        return tarefa;
    }
}
