import java.time.LocalDate;

public class Envasado extends Producto implements Comestibles,AplicarDescuento{
    // Atributos
    private String tipoEnvase;
    private boolean importado;
    private double porcentajeDescuento;
    private LocalDate fechaVencimiento;
    private double calorias;

    // Constructor
    public Envasado(String indentificador, String descripcion, int cantidadEnStock, double costoPorUnidad, boolean disponibleParaVenta, double porcentajeGanancia, String tipoEnvase, boolean importado) {
        super(indentificador, descripcion, cantidadEnStock, costoPorUnidad, disponibleParaVenta, porcentajeGanancia);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
    }

    // getters y setters
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean getImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    // Métodos de la interfaz AplicarDescuento
    @Override
    public double getDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public void setDescuento(double descuento) {
        if(descuento <= 20){
            this.porcentajeDescuento = descuento;
            System.out.println(super.getDescripcion() + " - " + super.getIndentificador() + " descuento de: " + String.format("%.0f", descuento)+"%");
        } else {
            System.out.println("El descuento para el producto: " + super.getDescripcion() + " - " + super.getIndentificador() + " no pudo ser aplicado");
        }
    }

    @Override
    public double getPrecioVentaConDescuento() {
        double precioVentaBase = getPrecioPorUnidad();
        double precioConDescuento = precioVentaBase * (1 - (porcentajeDescuento / 100));

        if (importado) {
            precioConDescuento += precioConDescuento * 0.10; // Aplica impuesto del 10%
            return precioConDescuento;
        }

//        System.out.println("Precio final con descuento: $"+precioConDescuento);
        return precioConDescuento;
    }

    // Para aplicar porcetajeGanancia, considerado como comestible
    @Override
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        if (porcentajeGanancia <= 20) {
            super.setPorcentajeGanancia(porcentajeGanancia);
        } else {
            System.out.println("El porcentaje de ganancia para productos envasados no puede superar el 20%");
        }
    }

    // Metodos de la interfaz Comestibles
    @Override
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public double getCalorias() {
        return calorias;
    }

    @Override
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

}
