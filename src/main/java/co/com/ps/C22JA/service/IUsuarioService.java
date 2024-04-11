package co.com.ps.C22JA.service;

import co.com.ps.C22JA.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario getUsuario(Long id);
    public List<Usuario> getAllUsuarios();
    public Usuario saveUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public void deleteUsuario(Long id);
}