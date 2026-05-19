package com.empresa.pedidos.dominio.puertos;

import com.empresa.pedidos.dominio.eventos.PedidoProcesadoEvent;

/**
 * Puerto de dominio para el servicio de notificaciones (Observer).
 */
public interface ServicioNotificacion {
    void notificar(PedidoProcesadoEvent evento);
}