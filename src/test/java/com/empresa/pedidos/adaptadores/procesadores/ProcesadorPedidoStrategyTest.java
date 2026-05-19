package com.empresa.pedidos.adaptadores.procesadores;

import com.empresa.pedidos.dominio.EstadoPedido;
import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.TipoPedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorPedidoStrategyTest {

    @Test
    void procesadorEstandarCalculaCostoCorrectamente() {
        Pedido pedido = new Pedido();
        pedido.setSubtotal(100.0);

        new ProcesadorPedidoEstandar().procesar(pedido);

        assertEquals(110.0, pedido.getCosto(), 0.01);
        assertEquals(EstadoPedido.PROCESADO, pedido.getEstado());
        assertEquals(TipoPedido.ESTANDAR, new ProcesadorPedidoEstandar().getTipo());
    }

    @Test
    void procesadorExpressCalculaCostoCorrectamente() {
        Pedido pedido = new Pedido();
        pedido.setSubtotal(100.0);

        new ProcesadorPedidoExpress().procesar(pedido);

        assertEquals(130.0, pedido.getCosto(), 0.01);
        assertEquals(EstadoPedido.PROCESADO, pedido.getEstado());
    }

    @Test
    void procesadorInternacionalCalculaCostoCorrectamente() {
        Pedido pedido = new Pedido();
        pedido.setSubtotal(100.0);

        new ProcesadorPedidoInternacional().procesar(pedido);

        assertEquals(175.0, pedido.getCosto(), 0.01); // 100 * 1.5 + 25
        assertEquals(EstadoPedido.PROCESADO, pedido.getEstado());
    }
}