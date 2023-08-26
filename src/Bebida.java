import java.time.LocalDate;

public class Bebida extends Producto implements AplicarDescuento,Comestibles{
    // Atributos
    private boolean alcoholica;
    private double graduacionAlcoholica;
    private boolean importado;
    private double porcentajeDescuento;
    private LocalDate fechaVencimiento;
    private double calorias;

    // Constructor
    public Bebida(String indentificador, String descripcion, int cantidadEnStock, double costoPorUnidad, boolean disponibleParaVenta, double porcentajeGanancia, boolean alcoholica, double graduacionAlcoholica, boolean importado) {
        super(indentificador, descripcion, cantidadEnStock, costoPorUnidad, disponibleParaVenta, porcentajeGanancia);
        this.alcoholica = alcoholica;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.importado = importado;
    }

    // getters y setters
    public boolean getAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(boolean alcoholica) {
        this.alcoholica = alcoholica;
    }

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public boolean getImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    // Métodos: de la interfaz AplicarDescuento
    @Override
    public double getDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public void setDescuento(double descuento) {
        if(descuento <= 15){
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

        return precioConDescuento;
    }

    @Override
    // Para aplicar porcetajeGanancia, considerado como comestible
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        if (porcentajeGanancia <= 20) {
            super.setPorcentajeGanancia(porcentajeGanancia);
        } else {
            System.out.println("El porcentaje de ganancia para bebidas no puede superar el 20%");
        }
    }

    // Método de la interfaz COMESTIBLES
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
