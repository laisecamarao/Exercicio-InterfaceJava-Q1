public class Bicicleta implements Reservavel {
    private String codigo;
    private Pessoa responsavel;

    public Bicicleta(String codigo) {
        this.codigo = codigo;
        this.responsavel = null;
    }

    public String getCodigo() { return codigo; }
    public Pessoa getResponsavel() { return responsavel; }
    public boolean isDisponivel() { return responsavel == null; }

    @Override
    public void reservar(Pessoa pessoa) {
        if (pessoa == null) {
            System.out.println("não é possível reservar a bicicleta com uma pessoa nula.");
        } else if (responsavel != null) {
            System.out.println("a bicicleta " + codigo + " já está reservada.");
        } else {
            responsavel = pessoa;
            System.out.println("bicicleta " + codigo + " reservada por " + pessoa.getNome() + ".");
        }
    }

    @Override
    public void liberar() {
        if (responsavel == null) {
            System.out.println("a bicicleta " + codigo + " já está disponível.");
        } else {
            responsavel = null;
            System.out.println("bicicleta " + codigo + " liberada.");
        }
    }

    @Override
    public void exibirSituacao() {
        if (responsavel == null) System.out.println("bicicleta: " + codigo + " | disponível");
        else System.out.println("bicicleta: " + codigo + " | responsável: " + responsavel.getNome());
    }
}
