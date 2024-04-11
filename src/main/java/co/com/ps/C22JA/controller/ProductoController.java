package co.com.ps.C22JA.controller;

import co.com.ps.C22JA.entity.Producto;
import co.com.ps.C22JA.service.IProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;

    @Operation(summary = "Aplicacion que trae un producto por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro un Producto",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),
            @ApiResponse(responseCode = "400", description = "No encontro un Producto",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),
    })
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.getProducto(id);
        //   .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id))
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.getAllProductos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@RequestBody Producto productoActualizado) {
        return productoService.updateProducto(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }

}