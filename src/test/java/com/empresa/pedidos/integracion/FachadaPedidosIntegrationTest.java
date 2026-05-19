package com.empresa.pedidos.integracion;

import com.empresa.pedidos.adaptadores.facade.FachadaPedidos;
import com.empresa.pedidos.dominio.EstadoPedido;
import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.TipoPedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FachadaPedidosIntegrationTest {

    @Autowired
    private FachadaPedidos fachada;

    @Test
    void flujoCompleto_PedidoEstandar() {
        Pedido pedido = new Pedido();
        pedido.setCliente("Ana García");
        pedido.setSubtotal(200.0);
        pedido.setTipo(TipoPedido.ESTANDAR);

        Pedido resultado = fachada.crearPedido(pedido);

        assertNotNull(resultado.getId());
        assertEquals(EstadoPedido.PROCESADO, resultado.getEstado());
        assertEquals(220.0, resultado.getCosto(), 0.01);
    }

    @Test
    void flujoCompleto_PedidoExpress() {
        Pedido pedido = new Pedido();
        pedido.setCliente("Carlos López");
        pedido.setSubtotal(100.0);
        pedido.setTipo(TipoPedido.EXPRESS);

        Pedido resultado = fachada.crearPedido(pedido);

        assertNotNull(resultado.getId());
        assertEquals(EstadoPedido.PROCESADO, resultado.getEstado());
        assertEquals(130.0, resultado.getCosto(), 0.01);
    }

    @Test
    void flujoCompleto_PedidoInternacional() {
        Pedido pedido = new Pedido();
        pedido.setCliente("María Torres");
        pedido.setSubtotal(100.0);
        pedido.setTipo(TipoPedido.INTERNACIONAL);

        Pedido resultado = fachada.crearPedido(pedido);

        assertNotNull(resultado.getId());
        assertEquals(EstadoPedido.PROCESADO, resultado.getEstado());
        assertEquals(175.0, resultado.getCosto(), 0.01);
    }

    @Test
    void buscarPedidoPorId_DebeRetornarPedidoGuardado() {
        Pedido pedido = new Pedido();
        pedido.setCliente("Luis Martínez");
        pedido.setSubtotal(50.0);
        pedido.setTipo(TipoPedido.ESTANDAR);

        Pedido guardado = fachada.crearPedido(pedido);
        var encontrado = fachada.buscarPorId(guardado.getId());

        assertTrue(encontrado.isPresent());
        assertEquals(guardado.getId(), encontrado.get().getId());
    }
}