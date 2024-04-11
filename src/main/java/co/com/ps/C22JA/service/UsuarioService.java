package co.com.ps.C22JA.service;

import co.com.ps.C22JA.entity.Producto;
import co.com.ps.C22JA.entity.Usuario;
import co.com.ps.C22JA.repository.UsuarioReposity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService{

    private final UsuarioReposity usuarioReposity;

    @Override
    public Usuario getUsuario(Long id) {
        return usuarioReposity.getReferenceById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioReposity.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioReposity.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario u = usuarioReposity.getReferenceById(usuario.getId());
        u.setNombre(usuario.getNombre());
        u.setEmail(usuario.getEmail());
        u.setTelefono(usuario.getTelefono());

        if (u==null){
            return null;
        } else{
            return usuarioReposity.save(u);
        }
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioReposity.deleteById(id);
    }
}