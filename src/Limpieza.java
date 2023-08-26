public class Limpieza extends Producto implements AplicarDescuento{
    // Atributos
    private String tipoDeAplicacion;
    private double porcentajeDescuento;


    // Constructor
    public Limpieza(String indentificador, String descripcion, int cantidadEnStock, double costoPorUnidad, boolean disponibleParaVenta, double porcentajeGanancia, String tipoDeAplicacion) {
        super(indentificador, descripcion, cantidadEnStock, costoPorUnidad, disponibleParaVenta, porcentajeGanancia);
        this.tipoDeAplicacion = tipoDeAplicacion;
    }

    // getter y setter
    public String getTipoDeAplicacion() {
        return tipoDeAplicacion;
    }

    public void setTipoDeAplicacion(String tipoDeAplicacion) {
        this.tipoDeAplicacion = tipoDeAplicacion;
    }

    // Métodos de la interfaz AplicarDescuento
    @Override
    public double getDescuento() {
        return porcentajeDescuento;
    }
    @Override
    public void setDescuento(double descuento) {
        if(descuento <= 25){
            this.porcentajeDescuento = descuento;
        } else {
            System.out.println("El descuento registrado para el producto " + super.getIndentificador() + " no pudo ser aplicado");
        }
    }
    @Override
    public double getPrecioVentaConDescuento() {
        double precioVentaBase = calcularPrecioVenta();

        return precioVentaBase * (1 - (porcentajeDescuento / 100));
    }

    // Para aplicar porcetajeGanancia, considerado como limpieza
    @Override
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        if (porcentajeGanancia >= 10 && porcentajeGanancia <= 25) {
            super.setPorcentajeGanancia(porcentajeGanancia);
        } else {
            System.out.println("El porcentaje de ganancia para productos de limpieza debe estar entre el 10% y el 25%");
        }
    }
}
