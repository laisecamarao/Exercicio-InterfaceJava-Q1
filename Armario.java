public class Armario implements Reservavel {
    private int numero;
    private Pessoa responsavel;

    public Armario(int numero) {
        this.numero = numero;
        this.responsavel = null;
    }

    public int getNumero() { return numero; }
    public Pessoa getResponsavel() { return responsavel; }
    public boolean isReservado() { return responsavel != null; }

    @Override
    public void reservar(Pessoa pessoa) {
        if (pessoa == null) {
            System.out.println("não é possível reservar o armário com uma pessoa nula.");
        } else if (responsavel != null) {
            System.out.println("o armário " + numero + " já está reservado.");
        } else {
            responsavel = pessoa;
            System.out.println("armário " + numero + " reservado por " + pessoa.getNome() + ".");
        }
    }

    @Override
    public void liberar() {
        if (responsavel == null) {
            System.out.println("o armário " + numero + " já está disponível.");
        } else {
            responsavel = null;
            System.out.println("armário " + numero + " liberado.");
        }
    }

    @Override
    public void exibirSituacao() {
        if (responsavel == null) System.out.println("armário: " + numero + " | disponível");
        else System.out.println("armário: " + numero + " | responsável: " + responsavel.getNome());
    }
}
