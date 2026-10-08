package br.dev.jenny.controle_veiculos;
import java.util.Objects;

/**
 *
 * @author sesi2dia
 */

class Veiculo {

    private String placa;

    private String marca;

    private String modelo;

    private StatusVeiculo status;

    private String motorista;

    public Veiculo(String placa, String marca, String modelo) {
        this.setPlaca(placa);
        this.marca = marca;
        this.modelo = modelo;
        this.motorista = "";
        this.status = StatusVeiculo.PATIO;

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public StatusVeiculo getStatus() {
        //public int getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public void setPlaca(String placa) {
        if (placa.length() == 7) {
            this.placa = placa;
        } else {
            throw new UnsupportedOperationException("Placa Invalida");
        }
    }

    public String getPlaca() {

        String aux = this.placa.substring(0, 3);    // AAA1234   AAA-1234
        aux += "-";
        aux += this.placa.substring(3, 7);

        return aux;
    }

    @Override
    public String toString() {
        return String.format("%-12s %-15s %-15s %-18s %-10s",
                this.getPlaca(),
                this.getModelo(),
                this.getMarca(),
                this.getMotorista().isEmpty() ? "-" : this.getMotorista(),
                this.getStatus().name());
    }

    public void sairComVeiculo(String motorista) {
        this.motorista = motorista;

        this.status = StatusVeiculo.RUA;

    }

    public void entrarComVeiculo() {

        this.status = StatusVeiculo.PATIO;
        this.motorista = "";

    }

}
