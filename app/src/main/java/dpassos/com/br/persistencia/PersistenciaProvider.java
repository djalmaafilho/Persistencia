package dpassos.com.br.persistencia;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

//http://developer.android.com/guide/topics/providers/content-provider-creating.html
//http://celeiroandroid.blogspot.com.br/2011/04/content-providers-parte-01.html
public class PersistenciaProvider extends ContentProvider {

    static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    DataBaseHelper dbHelper;
    SQLiteDatabase db;
    static {
        matcher.addURI("dpassos.com.br.persistencia", "pessoa", 1);
    }

    public PersistenciaProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        int codigo = matcher.match(uri);
        if(codigo == 1){
            //vnd.android.cursor.item
            return "vnd.android.cursor.dir/vnd.dpassos.com.br.persistencia.pessoa";
        }else{
            throw  new IllegalArgumentException("Uri não suportada");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DataBaseHelper(getContext());
        db = dbHelper.getReadableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int codigo = matcher.match(uri);

        if(codigo == 1){
            return db.query("pessoa", projection,
                    selection, selectionArgs, null, null, sortOrder);
        }else{
            throw  new IllegalArgumentException("Uri não suportada");
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}