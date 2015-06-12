package dpassos.com.br.persistencia;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class PrefereciasActivity extends ActionBarActivity {

    private String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferecias);

        final SharedPreferences preferences =  getPreferences(MODE_PRIVATE);

        boolean opcao1 = preferences.getBoolean("opcao1", false);

        CheckBox cb = (CheckBox)findViewById(R.id.opcao_ativada);
        cb.setChecked(opcao1);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("opcao1",isChecked );
                    editor.commit();
            }
        });

        if(savedInstanceState!= null){
            mensagem = savedInstanceState.getString("mensagem");
            if(mensagem != null){
                Toast.makeText(getBaseContext(), "Existe Mensagem: "+mensagem, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("djps", "Salvando instancia");
        outState.putString("mensagem", "Instancia Salva "+(System.currentTimeMillis()));
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferecias, menu);
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
