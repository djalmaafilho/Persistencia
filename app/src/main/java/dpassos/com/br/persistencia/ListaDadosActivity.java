package dpassos.com.br.persistencia;

import android.content.SyncStatusObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class ListaDadosActivity extends ActionBarActivity {

    DataBaseHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados);
        dbHelper = new DataBaseHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        db = dbHelper.getReadableDatabase();
        //exibirDadosRawQuery();
        //exebirDadosQuery();
        exibirDadosQueryBuilder();
    }

    @Override
    protected void onStop() {
        dbHelper.close();
        super.onStop();
    }

    private void exibirDadosRawQuery(){
        Cursor cursor =
        db.rawQuery("SELECT _id, nome, rg, idade FROM pessoa",null);
        exibirDados(cursor);
    }

    private void exibirDados(Cursor cursor){

        MeuCursorAdapter cursorAdapter = new MeuCursorAdapter(this, cursor, false);

        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(cursorAdapter);

//        cursor.moveToFirst();
//        for(int i = 0; i < cursor.getCount() ; i++){
//            System.out.println("Nome: "+cursor.getString(0)+
//            " Rg: "+cursor.getString(1)+" Idade: "+cursor.getInt(2));
//            cursor.moveToNext();
//        }
//
//        cursor.close();
    }

    //http://stackoverflow.com/questions/10600670/sqlitedatabase-query-method
    private void exebirDadosQuery(){
        Cursor cursor = db.query("pessoa", new String[]{"_id","nome","rg","idade"}, null, null, null, null, null);
        exibirDados(cursor);
    }

    private void exibirDadosQueryBuilder(){
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables("pessoa");
        Cursor cursor = builder.query(db, new String[]{"_id", "nome","rg","idade"}, null, null, null, null, null);
        exibirDados(cursor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_dados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}