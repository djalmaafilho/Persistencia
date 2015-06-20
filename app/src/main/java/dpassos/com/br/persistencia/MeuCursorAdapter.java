package dpassos.com.br.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by djalma on 20/06/2015.
 */
public class MeuCursorAdapter extends CursorAdapter {

    public MeuCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    public MeuCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                inflate(R.layout.linha_adapter, null);
    }

    @Override
    public void bindView(View view, final Context context,Cursor cursor) {
        final String aux = cursor.getString(1);
        TextView txt = ((TextView)view.findViewById(R.id.txtLinha));
        txt.setText(cursor.getString(1));
        txt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, aux, Toast.LENGTH_SHORT).show();
            }
        });
    }
}