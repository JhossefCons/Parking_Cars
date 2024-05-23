import java.util.ArrayList;

public class Parking {
    private ArrayList<String> matriculas;
    private String nombre;

    public Parking(String nombre, int numPlazas) {
        this.nombre = nombre;
        this.matriculas = new ArrayList<>(numPlazas);
        for (int i = 0; i < numPlazas; i++) {
            matriculas.add(null);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int plaza) throws ParkingException {
        if (matricula == null || matricula.length() < 4) {
            throw new ParkingException("Matrícula incorrecta", matricula);
        }
        if (plaza < 0 || plaza >= matriculas.size() || matriculas.get(plaza) != null) {
            throw new ParkingException("Plaza ocupada", matricula);
        }
        if (matriculas.contains(matricula)) {
            throw new ParkingException("Matrícula repetida", matricula);
        }
        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws ParkingException {
        int plaza = matriculas.indexOf(matricula);
        if (plaza == -1) {
            throw new ParkingException("Matrícula no existente", matricula);
        }
        matriculas.set(plaza, null);
        return plaza;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int ocupadas = 0;
        for (String matricula : matriculas) {
            if (matricula != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getPlazasLibres() {
        return getPlazasTotales() - getPlazasOcupadas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n----------------\n");
        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("Plaza ").append(i).append(": ");
            sb.append(matriculas.get(i) == null ? "(vacía)" : matriculas.get(i)).append("\n");
        }
        return sb.toString();
    }
}
