import java.util.ArrayList;

public class CentralReservas {
    private ArrayList<Reservavel> recursos;

    public CentralReservas() {
        recursos = new ArrayList<>();
    }

    public void cadastrarRecurso(Reservavel recurso) {
        if (recurso == null) {
            System.out.println("não é possível cadastrar um recurso nulo.");
        } else if (recursos.contains(recurso)) {
            System.out.println("esse recurso já está cadastrado.");
        } else {
            recursos.add(recurso);
            System.out.println("recurso cadastrado.");
        }
    }

    public void reservarRecurso(Reservavel recurso, Pessoa pessoa) {
        if (!recursos.contains(recurso)) {
            System.out.println("recurso não cadastrado.");
            return;
        }
        recurso.reservar(pessoa);
    }

    public void liberarRecurso(Reservavel recurso) {
        if (!recursos.contains(recurso)) {
            System.out.println("recurso não cadastrado.");
            return;
        }
        recurso.liberar();
    }

    public void listarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("não há recursos cadastrados.");
            return;
        }
        for (Reservavel recurso : recursos) {
            recurso.exibirSituacao();
        }
    }
}
