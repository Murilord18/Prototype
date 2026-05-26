package prototype;


public class ContaBancaria implements Cloneable {

    private String numeroConta;
    private String titular;
    private String tipoConta;
    private double saldo;
    private Agencia agencia;

    public ContaBancaria(String numeroConta, String titular, String tipoConta,
                         double saldo, Agencia agencia) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.agencia = agencia;
    }



    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }



    @Override
    public ContaBancaria clone() throws CloneNotSupportedException {
        ContaBancaria contaClone = (ContaBancaria) super.clone();
        // Deep copy: cria uma nova instância de Agencia para o clone
        contaClone.agencia = (Agencia) this.agencia.clone();
        return contaClone;
    }



    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numeroConta='" + numeroConta + '\'' +
                ", titular='" + titular + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                ", saldo=" + saldo +
                ", agencia=" + agencia +
                '}';
    }
}
