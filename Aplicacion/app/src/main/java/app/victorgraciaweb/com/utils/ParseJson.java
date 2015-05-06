package app.victorgraciaweb.com.utils;

import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.victorgraciaweb.com.aplicacion.ListadoUsuariosActivity;
import app.victorgraciaweb.com.aplicacion.LoginActivity;
import app.victorgraciaweb.com.bean.Usuario;

public class ParseJson
{
    public static List<Usuario> usuarios(JSONArray response)
    {
        // Variables locales
        List<Usuario> listaUsuarios = new ArrayList<>();

        for(int i=0; i<response.length(); i++)
        {
            try {
                JSONObject objeto= response.getJSONObject(i);

                Usuario usuario = new Usuario();
                //usuario.setIdUsuario(objeto.getInt("idUsuario"));
                //usuario.setNombre(objeto.getString("nombre"));
                //usuario.setApellidos(objeto.getString("apellidos"));
                usuario.setEmail(objeto.getString("email"));
                usuario.setPassword(objeto.getString("password"));
                listaUsuarios.add(usuario);

            } catch (JSONException e) {
                Log.e("Error", "Error de parsing: " + e.getMessage());
            }
        }

        return listaUsuarios;
    }
}
