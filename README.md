# Exercício InterfaceJava Q1
Primeira questão de um exercício de implementação com Interface, proposto pelo professor Isaac Elgrably, de Programação Orientada a Objeto.

# Proposta e exigências da questão

Enunciado
Um campus precisa de um sistema para reservar salas de estudo, bicicletas e armários. 
Cada reserva deve identificar a pessoa responsável pelo recurso. 
A central deve cadastrar os recursos, encaminhar pedidos de reserva e liberação e apresentar a situação de cada um.
Cada recurso pode ter somente uma pessoa responsável por vez. 
A sala de estudo é reservada inteira; sua capacidade é apenas uma informação sobre o espaço, não uma quantidade de reservas permitidas.

Requisitos obrigatórios
Implemente as classes e a interface descritas a seguir. Mantenha os construtores e métodos públicos.
Nos atributos, use private; protected pode ser utilizado em vez de private.


1. Classe Pessoa

A classe Pessoa representa quem solicita uma reserva. Ela possui o atributo nome, do tipo String.
Implemente:
• Construtor: receber o nome da pessoa e guardar esse valor no atributo do objeto.
• getNome(): retornar o nome guardado, como String. Esse método permite que as outras classes consultem o nome da pessoa.

2. Interface Reservavel
   
SalaEstudo, Bicicleta e Armario são classes diferentes, mas compartilham a capacidade de serem reservadas.
Represente essa capacidade por uma interface chamada Reservavel, sem criar uma classe-pai para unir os três recursos.
Uma interface define quais operações suas implementações devem oferecer.
Neste exercício, declare nela os seguintes métodos, todos com retorno void:
• reservar(Pessoa pessoa): receber o objeto que representa quem solicita a reserva.
• liberar(): desfazer a reserva do recurso, sem receber parâmetros.
• exibirSituacao(): apresentar a identificação do recurso e informar se ele está disponível ou quem é o responsável pela reserva, sem receber parâmetros.
Declare esses métodos na interface sem corpo, terminando suas declarações com ponto e vírgula.
Nas três classes de recursos, use implements para indicar a implementação de Reservavel.
Escreva o corpo de cada método nessas classes, usando public e @Override e respeitando os parâmetros e o retorno definidos no contrato.

Associação com a pessoa responsável
Cada objeto de SalaEstudo, Bicicleta ou Armario possui um atributo responsavel, do tipo Pessoa.
Esse atributo começa com null, indicando que o objeto está disponível para reserva.
Quando uma reserva for aceita, o método reservar(Pessoa pessoa) deve guardar no atributo responsavel a referência à Pessoa recebida. Faça isso no próprio objeto que está sendo reservado, sem criar outra pessoa nem copiar apenas seu nome.
Para exibir o nome de quem reservou, primeiro verifique se responsavel não é null. Depois, consulte getNome() na Pessoa guardada nesse atributo.
Não mantenha um boolean separado para indicar a reserva. Em cada objeto, responsavel igual a null significa disponível; uma referência a Pessoa significa reservado para essa pessoa.

3. Classe SalaEstudo

SalaEstudo implementa Reservavel e possui os atributos nome, do tipo String, capacidade, do tipo int, e responsavel, do tipo Pessoa.
Implemente:
• Construtor: receber o nome e a capacidade da sala, guardar esses valores e iniciar
responsavel como null.
• getNome(): retornar o nome da sala, como String.
• getCapacidade(): retornar a capacidade da sala, como int.
• getResponsavel(): retornar a própria Pessoa associada à sala. Se não houver reserva, retornar null. O retorno é do tipo Pessoa, não String.
• isReservada(): retornar um boolean que indique se responsavel é diferente de null. Esse método apenas consulta a situação da sala; não cria nem cancela uma reserva.
• reservar(Pessoa pessoa): verificar primeiro se a pessoa recebida é null. Nesse caso, imprimir um aviso e encerrar o método sem alterar a sala. Se já houver responsável, avisar que a sala está reservada e manter pessoa que já estava associada. Caso contrário, guardar a Pessoa recebida em responsavel e imprimir o nome da sala e o nome de quem a reservou.
• liberar(): verificar se a sala tem responsável. Se não tiver, avisar que ela já está disponível. Se tiver, atribuir null a responsavel e informar qual sala foi liberada. Não alterar o nome nem a capacidade.
• exibirSituacao(): imprimir o nome e a capacidade da sala. Se responsavel for null, informar que ela está disponível; caso contrário, mostrar o nome da pessoa responsável pela reserva.

4. Classe Bicicleta

Bicicleta implementa Reservavel e possui os atributos codigo, do tipo String, e responsavel, do tipo Pessoa.
Implemente:
• Construtor: receber e guardar o código da bicicleta e iniciar responsavel como null.
• getCodigo(): retornar o código da bicicleta, como String.
• getResponsavel(): retornar a própria Pessoa associada à bicicleta ou null, caso não haja reserva.
• isDisponivel(): retornar um boolean que indique se responsavel é null. Uma bicicleta sem responsável está disponível; uma bicicleta com responsável está reservada.
• reservar(Pessoa pessoa): recusar a operação com um aviso se a pessoa recebida for null. Se a bicicleta já tiver responsável, avisar que ela está reservada e não substituir essa pessoa. Se estiver disponível, guardar a Pessoa recebida em responsavel e imprimir o código da bicicleta e o nome de quem a reservou.
• liberar(): se não houver responsável, informar que a bicicleta já está disponível. Caso contrário, atribuir null a responsavel e informar qual bicicleta foi liberada. O código deve permanecer igual.
• exibirSituacao(): imprimir o código da bicicleta e informar que ela está disponível, se responsavel for null, ou mostrar o nome de quem a reservou.
5. Classe Armario
Armario implementa Reservavel e possui os atributos numero, do tipo int, e responsavel, do tipo Pessoa.
Implemente:
• Construtor: receber e guardar o número do armário e iniciar responsavel como null.
• getNumero(): retornar o número do armário, como int.
• getResponsavel(): retornar a própria Pessoa associada ao armário ou null, caso não haja reserva.
• isReservado(): retornar um boolean que indique se responsavel é diferente de null.
• reservar(Pessoa pessoa): se a pessoa recebida for null, imprimir um aviso e não alterar o armário. Se já houver responsável, avisar que o armário está reservado e manter a reserva existente. Caso contrário, guardar a Pessoa recebida em responsavel e imprimir o número do armário e o nome de quem o reservou.
• liberar(): se não houver responsável, informar que o armário já está disponível. Se houver, atribuir null a responsavel e informar qual armário foi liberado, sem alterar seu número.
• exibirSituacao(): imprimir o número do armário e informar que ele está disponível, se responsavel for null, ou mostrar o nome da pessoa responsável pela reserva.

6. Classe CentralReservas

A central possui o atributo recursos, do tipo ArrayList&lt;Reservavel&gt;. A lista pertence à central e guarda os recursos cadastrados, tanto os disponíveis quanto os reservados.
Use a importação java.util.ArrayList no arquivo da classe. Como o tipo dos elementos é Reservavel, a mesma lista pode guardar objetos de SalaEstudo, Bicicleta e Armario.
Implemente um construtor sem parâmetros que inicialize recursos com uma lista vazia, usando new ArrayList&lt;&gt;(). Os métodos descritos abaixo não retornam um valor: todos devem ter retorno void.
cadastrarRecurso(Reservavel recurso)
Receba o recurso que será cadastrado. Se ele for null, imprima um aviso e encerre o método.
Verifique também, com contains, se o mesmo objeto já está na lista; nesse caso, avise e não faça outro cadastro. 
Caso contrário, use add para guardar a própria referência recebida na lista recursos.
reservarRecurso(Reservavel recurso, Pessoa pessoa)
Receba o recurso desejado e a pessoa que solicita a reserva. Consulte a lista com contains para verificar se o recurso está cadastrado. Se não estiver, imprima um aviso e encerre o método sem encaminhar a solicitação.
Se estiver cadastrado, chame reservar(pessoa) no recurso recebido. Passe o mesmo objeto Pessoa que chegou ao método. A verificação de pessoa nula e de reserva existente deve ocorrer no próprio recurso, conforme descrito em cada classe; a central apenas verifica o cadastro e encaminha a solicitação.
liberarRecurso(Reservavel recurso)
Receba o recurso que será liberado e confira, com contains, se ele está cadastrado. Se não estiver, imprima um aviso e encerre o método. Caso contrário, chame liberar() no próprio recurso.
Não remova o recurso da lista: liberar uma reserva desfaz a associação com a pessoa, mas mantém o recurso cadastrado e disponível para outra reserva.
listarRecursos()
Esse método não recebe parâmetros. Primeiro, confira com isEmpty se a lista está vazia. Se estiver, informe que não há recursos cadastrados e encerre o método.
Se houver recursos, faça um laço para percorrer a lista. Em cada passagem, trabalhe com o objeto pelo tipo Reservavel e chame seu método exibirSituacao(). A própria sala, bicicleta ou armário deve apresentar suas informações; a central não deve montar uma sequência de instanceof para escolher o que imprimir.
Essa chamada pela interface é polimorfismo: o método solicitado é o mesmo, mas a implementação executada pertence ao objeto encontrado na lista.

App

Crie uma CentralReservas e chame listarRecursos antes dos cadastros: ela deve informar que a lista está vazia. Crie as pessoas Isa e Kali, uma SalaEstudo chamada Sala Azul com capacidade para quatro pessoas, uma Bicicleta de código B12 e um Armario de número 7. 
Cadastre cada recurso na central. Inicialmente, os três estão sem responsável e a listagem deve mostrá-los disponíveis.
Reserve a sala para Ana, a bicicleta para Bruno e o armário para Ana, usando reservarRecurso. Liste os recursos: cada um deve mostrar sua identificação e o respectivo responsável. 
Confira pelos getters que a sala e o armário guardam a própria Ana e que a bicicleta guarda o próprio Bruno.
Tente reservar a sala para Bruno: a operação deve ser recusada e Ana deve permanecer como responsável. 
Tente cadastrar a mesma bicicleta outra vez: ela não deve aparecer duas vezes na lista.
Libere a bicicleta pela central e confira que seu responsável é null e que isDisponivel() retorna true.
Tente reservá-la passando null no lugar da pessoa: a reserva deve ser recusada e a bicicleta deve permanecer disponível. Libere a sala e o armário e liste os recursos: todos devem estar cadastrados e sem reserva.
