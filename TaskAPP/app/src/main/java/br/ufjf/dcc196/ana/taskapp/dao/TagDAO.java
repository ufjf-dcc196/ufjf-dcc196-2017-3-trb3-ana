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

public class TagDAO extends TarefaDBHelper {
    private TagDAO(Context context) {
        super(context);
    }

    public void inserir(Tag tag){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TarefaContract.Tag.TABLE_NAME, null, setValues(tag));
        }catch (Exception e){
            Log.e("TAG INSERIR - ", e.getLocalizedMessage());
            Log.e("TAG INSERIR - ", e.getStackTrace().toString());
        }
    }

    public void alterar(Tag tag){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String[] args = {String.valueOf(tag.getId())};
            db.update(TarefaContract.Tarefa.TABLE_NAME, setValues(tag),TarefaContract.Tag._ID +" = ?", args );
        }catch (Exception e){
            Log.e("TAG ALTERAR - ", e.getLocalizedMessage());
            Log.e("TAG ALTERAR - ", e.getStackTrace().toString());
        }
    }

    public Tag buscar(int id){
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] args = {String.valueOf(id)};
            Cursor cursor = db.rawQuery(TarefaContract.Tag.SQL_CONSULTA_TAG,  args);
            cursor.moveToFirst();
            return getValues(cursor);
        }catch (Exception e){
            Log.e("TAG BUSCAR - ", e.getLocalizedMessage());
            Log.e("TAG BUSCAR - ", e.getStackTrace().toString());
        }
        return null;
    }

    public ArrayList<Tag> listar(){
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(TarefaContract.Tag.SQL_CONSULTA_TAGS, null);
            ArrayList<Tag> lista = new ArrayList<>();
            while(cursor.moveToNext()){
                lista.add(getValues(cursor));
            }
            return lista;
        }catch (Exception e){
            Log.e("TAG LISTAR - ", e.getLocalizedMessage());
            Log.e("TAG LISTAR - ", e.getStackTrace().toString());
        }
        return null;
    }

    private ContentValues setValues(Tag tag){
        ContentValues values = new ContentValues();
        values.put(TarefaContract.Tag.COLUMN_NAME_NOME, tag.getNome());
        return values;
    }

    private Tag getValues(Cursor cursor){
        Tag tag = new Tag();
        tag.setId(cursor.getInt(cursor.getColumnIndex(TarefaContract.Tag._ID)));
        tag.setNome(cursor.getString(cursor.getColumnIndex(TarefaContract.Tag.COLUMN_NAME_NOME)));
        return tag;
    }
}
