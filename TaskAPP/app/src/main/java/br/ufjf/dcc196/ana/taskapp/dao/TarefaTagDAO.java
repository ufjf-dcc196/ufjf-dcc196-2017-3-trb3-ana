package br.ufjf.dcc196.ana.taskapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.ufjf.dcc196.ana.taskapp.contract.TarefaContract;
import br.ufjf.dcc196.ana.taskapp.helper.TarefaDBHelper;
import br.ufjf.dcc196.ana.taskapp.model.Tag;
import br.ufjf.dcc196.ana.taskapp.model.Tarefa;

public class TarefaTagDAO extends TarefaDBHelper {
    public TarefaTagDAO(Context context) {
        super(context);
    }

    public void inserir(Tarefa tarefa, Tag tag){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TarefaContract.Tarefa.TABLE_NAME, null, setValues(tarefa, tag));
        }catch (Exception e){
            Log.e("TAREFA_TAG INSERIR - ", e.getLocalizedMessage());
            Log.e("TAREFA_TAG INSERIR - ", e.getStackTrace().toString());
        }
    }

    public ArrayList<Tarefa> listar(int tag_id){
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] args = {String.valueOf(tag_id)};
            Cursor cursor = db.rawQuery(TarefaContract.TarefaTag.SQL_CONSULTA_TAREFA_TAGS, args);
            ArrayList<Tarefa> lista = new ArrayList<>();
            while(cursor.moveToNext()){
                lista.add(getValues(cursor));
            }
            return lista;
        }catch (Exception e){
            Log.e("TAREFA_TAG LISTAR - ", e.getLocalizedMessage());
            Log.e("TAREFA_TAG LISTAR - ", e.getStackTrace().toString());
        }
        return null;
    }

    private ContentValues setValues(Tarefa tarefa, Tag tag){
        ContentValues values = new ContentValues();
        values.put(TarefaContract.TarefaTag.COLUMN_NAME_TAREFA, tarefa.getId());
        values.put(TarefaContract.TarefaTag.COLUMN_NAME_TAG, tag.getId());
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
