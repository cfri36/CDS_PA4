package PruebasUnitaria;

import Modelo.PedidosDao;

public class PruebaDetallesPedidos {

    public static void main(String[] args) {
        
        PedidosDao detPed = new PedidosDao();
        detPed.ListarDetallePedidos();

    }

}
