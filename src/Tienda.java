import java.util.*;

public class Tienda {
    private String nombre;
    private int nroMaxProductosEnStock;
    private double saldoEnCaja;
    private Map<String, List<Producto>> productosEnStock;

    // Constructor
    public Tienda(String nombre, int nroMaxProductosEnStock, double saldoEnCaja) {
        this.nombre = nombre;
        this.nroMaxProductosEnStock = nroMaxProductosEnStock;
        this.saldoEnCaja = saldoEnCaja;
        this.productosEnStock = new HashMap<>();
        productosEnStock.put("Envasado", new ArrayList<>());
        productosEnStock.put("Bebida", new ArrayList<>());
        productosEnStock.put("Limpieza", new ArrayList<>());
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroMaxProductosEnStock() {
        return nroMaxProductosEnStock;
    }

    public void setNroMaxProductosEnStock(int nroMaxProductosEnStock) {
        this.nroMaxProductosEnStock = nroMaxProductosEnStock;
    }

    public double getSaldoEnCaja() {
        return saldoEnCaja;
    }

    public void setSaldoEnCaja(double saldoEnCaja) {
        this.saldoEnCaja = saldoEnCaja;
    }

    public Map<String, List<Producto>> getProductosEnStock() {
        return productosEnStock;
    }

    public void setProductosEnStock(Map<String, List<Producto>> productosEnStock) {
        this.productosEnStock = productosEnStock;
    }


    // Compra De Producto
    // Metedo: para agregar productos a la tienda
    public void agregarProducto(Producto producto){
        String tipo = getTipoDeProducto(producto);
        // getOrDefault: permite obtener el valor asociado a una clave en un diccionario (mapa)
        List<Producto> tipoProdcutos = productosEnStock.getOrDefault(tipo, null);

        if (tipoProdcutos == null) {
            System.out.println("El tipo de producto '" + tipo + "' no está habilitado en la tienda");
            return;
        }


        double precioTotalProducto = producto.getPrecioPorUnidad() * producto.getCantidadEnStock();
        if(saldoEnCaja < precioTotalProducto){
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja");
        }

        if (tipoProdcutos.size() > nroMaxProductosEnStock) {
            System.out.println("El producto no podrá ser agregado a la tienda por alcanzar el máximo de stock");
            return;
        }

        // Acá agrego el producto y descuento el saldoEnCaja
        tipoProdcutos.add(producto);
        productosEnStock.put(tipo,tipoProdcutos);
        saldoEnCaja -= precioTotalProducto;
        System.out.println(
                "_Producto Agregado a la tienda\ntipo: " + tipo
                        + "\ndescripción: " + producto.getDescripcion() +
                        "\nstock: " + producto.getCantidadEnStock() +
                        "\nsaldo en caja: $" + String.format("%.2f", saldoEnCaja) + "\n"
        );

    }
    // Metedo: para obtener el tipo de producto
    public String getTipoDeProducto(Producto producto){
        // si no le llega un producto retorno un msj expresando eso
        if (producto == null) {
            return "producto es null";
        }

        String nombreClass = producto.getClass().getSimpleName();

        switch (nombreClass){
                case "Bebida":
                    return "Bebida";
                case "Envasado":
                    return "Envasado";
                case "Limpieza":
                    return "Limpieza";
                default:
                    return "Producto desconocido";
        }

    }

    // Venta De Producto
    public void realizarVenta(List<Producto> productos){
        System.out.println("___Ticket de venta___\n");
        if(productos.size() > 3){
            System.out.println("No se pueden incluir más de 3 tipos de productos en una venta");
            return;
        }

        double totalVenta = 0;
        boolean stockInsuficiente = false;

        for(Producto producto: productos){
            if (!producto.getDisponibleParaVenta()) {
                System.out.println("El producto " + producto.getIndentificador() + " " + producto.getDescripcion() + " no se encuentra disponible");
                continue; // Salta a la siguiente iteración del ciclo si el producto no está disponible
            }

            // Se venderán hasta 10 unidades o las disponibles en stock
            int unidadesAVender = Math.min(producto.getCantidadEnStock(),10);

            // Acá empiezo a hacer la suma total
            totalVenta += producto.getPrecioPorUnidad() * unidadesAVender;

            // Verificar si hay suficientes unidades en stock para la venta
            if (producto.getCantidadEnStock() < unidadesAVender) {
                stockInsuficiente = true;
            }

            // Voy a setear una nueva cantaidad de stock descontando las unidades vendidas
            producto.setCantidadEnStock(producto.getCantidadEnStock() - unidadesAVender);

            System.out.println(
                    "* " + producto.getIndentificador() + " " +
                    producto.getDescripcion().toUpperCase() + " " +
                    unidadesAVender + " x "
                    + "$" +producto.getPrecioPorUnidad() + " c/u"
            );
        }
            if (stockInsuficiente) {
                System.out.println("Hay productos con stock disponible menor al solicitado");
            }
            saldoEnCaja += totalVenta;
            System.out.println("\nTOTAL VENTA: $" +  totalVenta);
    }

    // metodo para mostrar productos en stock
    public void mostrarProductosEnStock(String tipo) {
        System.out.println("_ Productos de tipo " + tipo + " en stock:");
        List<Producto> productos = productosEnStock.getOrDefault(tipo, new ArrayList<>());

        for (Producto producto : productos) {
            System.out.println("   " + producto.getIndentificador() + " - " + producto.getDescripcion() + ": " + producto.getCantidadEnStock() + " unidades");
        }
    }

}
