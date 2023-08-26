import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Intanciamos la tienda, con los argumentos necesarios
        Tienda tienda = new Tienda("Lexar", 500, 5000);
        System.out.println("¡Bienvenido al superMercado "+tienda.getNombre()+"!  " + "Saldo: $"+tienda.getSaldoEnCaja()+"\n");

        // Creacion de productos
        Bebida gaseosa = new Bebida("AC010",
                "CocaCola", 100,
                10.0, true, 20,
                false, 0, true
        );
        // Calculo el precio de venta con el porcentaje ganancia
        double precioVentaGaseosa= gaseosa.calcularPrecioVenta();
        double porcentajeGanaciaGaseosa = gaseosa.getPorcentajeGanancia();
        System.out.println("Precio venta Gaseosas: $" +porcentajeGanaciaGaseosa + " | Ganancias de: " +precioVentaGaseosa+"%");
        // Seteo la fehca de vencimientos y las calorias para este producto
        gaseosa.setFechaVencimiento(LocalDate.of(2024,5,10));
        gaseosa.setCalorias(180);
        // Aplico un porcentaje de descuento, a la bebida
        gaseosa.setDescuento(30);
        // Agregó el producto a la tienda
        tienda.agregarProducto(gaseosa);


        Envasado yogures = new Envasado(
                "AB020", "Yogur Danonino", 20,
                8, true,
                8.0, "Plastico",false
        );
        // Calculo el precio de venta con el porcentaje ganancia
        double precioVentaYogures = yogures.calcularPrecioVenta();
        double porcentajeGanaciaYogures = yogures.getPorcentajeGanancia();
        System.out.println("Precio venta Yogures: $" +precioVentaYogures+ " | Ganancias de: " +porcentajeGanaciaYogures+"%");
        // Seteo la fehca de vencimientos y las calorias para este producto
        yogures.setFechaVencimiento(LocalDate.of(2023,12,8));
        yogures.setCalorias(45);
        // Aplico un porcentaje de descuento, al Envasado
        yogures.setDescuento(2);
        // llamó al metodo para calcular el precio de venta con descuento
        double precioFinalProducto = yogures.getPrecioVentaConDescuento();
        System.out.println("Precio final con descuento más, impuesto de importación: $" + String.format("%.2f", precioFinalProducto) +"\n");
        // Agregó el producto a la tienda
        tienda.agregarProducto(yogures);


        Limpieza jabonEnPolvo = new Limpieza(
                "AZ030","Ala Matic", 8
                ,8,true,15,
                "Ropa"
        );
        // Calculo el precio de venta con el porcentaje ganancia
        double precioVentaJabon = jabonEnPolvo.calcularPrecioVenta();
        double porcentajeGanaciaJabon = jabonEnPolvo.getPorcentajeGanancia();
        System.out.println("Precio venta Jabón: $" +precioVentaJabon+ " | Ganancias de: " +porcentajeGanaciaJabon+"%");
        // Agregó el producto a la tienda
        tienda.agregarProducto(jabonEnPolvo);


        // Creo un arrayList con los productos que voy a vender
        List<Producto> productosVenta = new ArrayList<>();
        // Agregó cada uno de los productos
        productosVenta.add(gaseosa);
        productosVenta.add(yogures);
        productosVenta.add(jabonEnPolvo);
        // Realizo la venta
        tienda.realizarVenta(productosVenta);

        // Imprimir datos de stock y saldo que queda en la tienda + las ganancias realizadas a partir de la venta
        System.out.printf("\n_ Saldo en la caja: $%.2f%n", tienda.getSaldoEnCaja());
        tienda.mostrarProductosEnStock("Bebida");
        tienda.mostrarProductosEnStock("Envasado");
        tienda.mostrarProductosEnStock("Limpieza");
    }
}