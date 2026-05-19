package com.empresa.pedidos.dominio.puertos;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.TipoPedido;

/**
 * Puerto de dominio (Strategy interface) para el procesamiento de pedidos.
 */
public interface ProcesadorPedido {
    TipoPedido getTipo();
    void procesar(Pedido pedido);
}