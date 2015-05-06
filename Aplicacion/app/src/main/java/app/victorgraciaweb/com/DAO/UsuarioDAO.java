package app.victorgraciaweb.com.DAO;

import java.util.List;

import app.victorgraciaweb.com.bean.Usuario;

public interface UsuarioDAO
{
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuario(int idUsuario);
    public List<Usuario> loginUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(int idUsuario);
}
