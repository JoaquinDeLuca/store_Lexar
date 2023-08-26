import java.time.LocalDate;

public interface Comestibles {

    // Metodos: Obtener fecha de vencimiento y setear fechaVencimiento
    LocalDate getFechaVencimiento();
    void setFechaVencimiento(LocalDate fechaVencimiento);

    // Metodos: Obtener calorias y setear calorias
    double getCalorias();
    void  setCalorias(double calorias);

}


