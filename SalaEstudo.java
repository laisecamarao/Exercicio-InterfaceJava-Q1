public class SalaEstudo implements Reservavel {
    private String nome;
    private int capacidade;
    private Pessoa responsavel;

    public SalaEstudo(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.responsavel = null;
    }

    public String getNome() { return nome; }
    public int getCapacidade() { return capacidade; }
    public Pessoa getResponsavel() { return responsavel; }
    public boolean isReservada() { return responsavel != null; }

    @Override
    public void reservar(Pessoa pessoa) {
        if (pessoa == null) {
            System.out.println("não é possível reservar a sala com uma pessoa nula.");
        } else if (responsavel != null) {
            System.out.println("a sala " + nome + " já está reservada.");
        } else {
            responsavel = pessoa;
            System.out.println("sala " + nome + " reservada por " + pessoa.getNome() + ".");
        }
    }

    @Override
    public void liberar() {
        if (responsavel == null) {
            System.out.println("a sala " + nome + " já está disponível.");
        } else {
            responsavel = null;
            System.out.println("sala " + nome + " liberada.");
        }
    }

    @Override
    public void exibirSituacao() {
        System.out.print("sala: " + nome + " | capacidade: " + capacidade);
        if (responsavel == null) System.out.println(" | disponível");
        else System.out.println(" | responsável: " + responsavel.getNome());
    }
}
