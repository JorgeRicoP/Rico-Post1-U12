package com.empresa.pedidos.aplicacion;

import com.empresa.pedidos.adaptadores.procesadores.ProcesadorPedidoEstandar;
import com.empresa.pedidos.adaptadores.procesadores.ProcesadorPedidoExpress;
import com.empresa.pedidos.adaptadores.procesadores.ProcesadorPedidoInternacional;
import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.ProcesadorPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorPedidoFactoryTest {

    private ProcesadorPedidoFactory factory;

    @BeforeEach
    void setUp() {
        List<ProcesadorPedido> procesadores = List.of(
                new ProcesadorPedidoEstandar(),
                new ProcesadorPedidoExpress(),
                new ProcesadorPedidoInternacional()
        );
        factory = new ProcesadorPedidoFactory(procesadores);
    }

    @Test
    void debeRetornarProcesadorEstandar() {
        ProcesadorPedido procesador = factory.obtener(TipoPedido.ESTANDAR);
        assertInstanceOf(ProcesadorPedidoEstandar.class, procesador);
    }

    @Test
    void debeRetornarProcesadorExpress() {
        ProcesadorPedido procesador = factory.obtener(TipoPedido.EXPRESS);
        assertInstanceOf(ProcesadorPedidoExpress.class, procesador);
    }

    @Test
    void debeRetornarProcesadorInternacional() {
        ProcesadorPedido procesador = factory.obtener(TipoPedido.INTERNACIONAL);
        assertInstanceOf(ProcesadorPedidoInternacional.class, procesador);
    }

    @Test
    void debeLanzarExcepcionSiTipoNoExiste() {
        // Creamos factory sin procesadores para forzar el error
        ProcesadorPedidoFactory factoryVacio = new ProcesadorPedidoFactory(List.of());
        assertThrows(IllegalArgumentException.class,
                () -> factoryVacio.obtener(TipoPedido.ESTANDAR));
    }
}