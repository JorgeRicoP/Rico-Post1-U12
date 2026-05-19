package com.empresa.pedidos.dominio.puertos;

import com.empresa.pedidos.dominio.Pedido;
import java.util.Optional;

/**
 * Puerto de dominio para la persistencia de pedidos.
 */
public interface RepositorioPedidos {
    Pedido guardar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long id);
}