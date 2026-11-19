public class App {
    public static void main(String[] args) {
        CentralReservas central = new CentralReservas();
        central.listarRecursos();

        Pessoa kali = new Pessoa("kali");
        Pessoa isa = new Pessoa("isa");

        SalaEstudo sala = new SalaEstudo("sala Azul", 4);
        Bicicleta bicicleta = new Bicicleta("B12");
        Armario armario = new Armario(7);

        central.cadastrarRecurso(sala);
        central.cadastrarRecurso(bicicleta);
        central.cadastrarRecurso(armario);
        central.listarRecursos();

        central.reservarRecurso(sala, kali);
        central.reservarRecurso(bicicleta, isa);
        central.reservarRecurso(armario, kali);
        central.listarRecursos();

        System.out.println("sala guarda kali? " + (sala.getResponsavel() == kali));
        System.out.println("bicicleta guarda isa? " + (bicicleta.getResponsavel() == isa));
        System.out.println("armário guarda kali? " + (armario.getResponsavel() == kali));

        central.reservarRecurso(sala, isa);
        central.cadastrarRecurso(bicicleta);

        central.liberarRecurso(bicicleta);
        System.out.println("responsável da bicicleta: " + bicicleta.getResponsavel());
        System.out.println("bicicleta disponível? " + bicicleta.isDisponivel());

        central.reservarRecurso(bicicleta, null);
        central.liberarRecurso(sala);
        central.liberarRecurso(armario);
        central.listarRecursos();
    }
}
