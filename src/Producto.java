public class  Producto {
    private String indentificador;
    private String descripcion;
    private int cantidadEnStock;
    private double precioPorUnidad;
    private double costoPorUnidad;
    private boolean disponibleParaVenta;
    private double porcentajeGanancia;

    // Constructor
    public Producto(String indentificador, String descripcion, int cantidadEnStock, double costoPorUnidad, boolean disponibleParaVenta, double porcentajeGanancia) {
        this.indentificador = indentificador;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.costoPorUnidad = costoPorUnidad;
        this.disponibleParaVenta = disponibleParaVenta;
        this.porcentajeGanancia = porcentajeGanancia;
    }

    // getters y setters
    public String getIndentificador() {
        return indentificador;
    }

    public void setIndentificador(String indentificador) {
        this.indentificador = indentificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public double getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(double costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }

    public boolean getDisponibleParaVenta() {
        return disponibleParaVenta;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }

    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public double calcularPrecioVenta() {
        // se utilizan para convertir los porcentajes en factores de multiplicación,
        // que se aplican al costo o precio base de venta
        double precioVentaBase = costoPorUnidad * (1 + (porcentajeGanancia / 100));

        setPrecioPorUnidad(precioVentaBase);

        return precioVentaBase;
    }
}
