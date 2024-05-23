public class ParkingException extends Exception {
    private String matricula;

    public ParkingException(String mensaje, String matricula) {
        super(mensaje);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
