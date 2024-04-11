package co.com.ps.C22JA.controller;

import co.com.ps.C22JA.entity.Producto;
import co.com.ps.C22JA.entity.Usuario;
import co.com.ps.C22JA.service.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Operation(summary = "Aplicacion que trae un usuario por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro un Usuario",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class)) }),
            @ApiResponse(responseCode = "400", description = "No encontro un Usuario",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class)) }),
    })
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id){
        return usuarioService.getUsuario(id);
        //   .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id))
    }

    @Operation(summary = "Aplicacion que trae todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro los Usuarios completos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Usuario.class))) }),
            @ApiResponse(responseCode = "400", description = "No encontro los Usuarios completos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Usuario.class))) }),
    })
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizado){
        return usuarioService.updateUsuario(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

}