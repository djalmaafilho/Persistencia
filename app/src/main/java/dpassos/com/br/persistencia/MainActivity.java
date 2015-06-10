package dpassos.com.br.persistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    DataBaseHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DataBaseHelper(this);
        Button bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(this);

        Button bt2 = (Button)findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =  new Intent(MainActivity.this, ListaDadosActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = dbHelper.getWritableDatabase();
    }

    @Override
    protected void onStop() {
        dbHelper.close();
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void salvarDados(){

        int id = (int)(Math.random() * Integer.MAX_VALUE);
        Pessoa p = new Pessoa("Nome_"+id, id, "Rg_"+id);

        ContentValues values = new ContentValues();
        values.put("nome", p.getNome());
        values.put("idade", p.getIdade());
        values.put("rg", p.getRg());

        long resultado = db.insert("pessoa", null, values);

        if(resultado != -1 ){
            Toast.makeText(this, "Salvo com sucesso",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Erro ao salvar",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        salvarDados();
    }
}