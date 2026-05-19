package com.empresa.pedidos.dominio.eventos;

import com.empresa.pedidos.dominio.Pedido;

/**
 * Evento de dominio publicado cuando un pedido es procesado (Observer).
 */
public record PedidoProcesadoEvent(Pedido pedido) {}