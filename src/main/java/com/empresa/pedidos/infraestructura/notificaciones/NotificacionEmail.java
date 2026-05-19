package com.empresa.pedidos.infraestructura.notificaciones;

import com.empresa.pedidos.dominio.eventos.PedidoProcesadoEvent;
import com.empresa.pedidos.dominio.puertos.ServicioNotificacion;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Observer: listener que envía notificación por email cuando se procesa un pedido.
 */
@Component
public class NotificacionEmail implements ServicioNotificacion {

    @EventListener
    @Override
    public void notificar(PedidoProcesadoEvent evento) {
        // Simulación de envío de email (en producción usaría JavaMailSender)
        System.out.println("📧 Email enviado para pedido: "
                + evento.pedido().getId()
                + " | Cliente: " + evento.pedido().getCliente());
    }
}