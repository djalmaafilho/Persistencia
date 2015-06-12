package dpassos.com.br.persistencia;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by djalma on 10/06/2015.

 * https://www.sqlite.org/datatype3.html
 *
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static String NOME = "banco_de_dados";
    private static int VERSAO = 1;

    public DataBaseHelper(Context context) {
        super(context, NOME, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pessoa (_id INTEGER PRIMARY KEY," +
                " nome TEXT, idade INTEGER, " +
                "rg TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE pessoa ADD COLUMN sobrenome TEXT");
    }
}