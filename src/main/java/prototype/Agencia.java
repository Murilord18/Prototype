package prototype;


public class Agencia implements Cloneable {

    private String codigo;
    private String nome;
    private String cidade;

    public Agencia(String codigo, String nome, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Agencia clone() throws CloneNotSupportedException {
        return (Agencia) super.clone();
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
