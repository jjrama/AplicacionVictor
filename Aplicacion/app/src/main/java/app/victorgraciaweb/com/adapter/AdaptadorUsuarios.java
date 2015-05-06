package app.victorgraciaweb.com.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;

import java.util.List;

import app.victorgraciaweb.com.aplicacion.R;
import app.victorgraciaweb.com.bean.Usuario;

public class AdaptadorUsuarios extends ArrayAdapter
{
    // Atributos
    List<Usuario> items;

    public AdaptadorUsuarios(Context context, List<Usuario> listaUsuarios)
    {
        super(context,0);
        this.items = listaUsuarios;
    }

    @Override
    public int getCount()
    {
        return items != null ? items.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Referencia del view procesado
        View listItemView;

        //Comprobando si el View no existe
        listItemView = null == convertView ? layoutInflater.inflate(R.layout.list_item_usuario,parent,false) : convertView;

        // Obtener el item actual
        Usuario item = items.get(position);

        // Obtener Views
        TextView tvNombre = (TextView) listItemView.findViewById(R.id.tvNombre);
        TextView tvApellidos = (TextView) listItemView.findViewById(R.id.tvApellidos);

        // Actualizar los Views
        tvNombre.setText(item.getNombre());
        tvApellidos.setText(item.getApellidos());

        return listItemView;
    }
}