package Direct3;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        //Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], resolva:

        //Set notas = new HashSet(); // antes do java 5
        //HashSet<Double> notas = new HashSet<>();
        //Set<Double> notas = new HashSet<>();  // Generics(jdk5) - Diamont Operador (jdk 7)
        //Set<Double> notas = Set.of(7d, 8.5, 5d, 7d, 0d, 3.6);
        //notas.add(1d);
        //notas.remove(5);
        //System.out.println(notas);

        System.out.println("crie um conjunto e adicione as notas: ");
        HashSet<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        //set de notas criado, implementado com o HashSet<>(), passando todas as notas dentro do argumento
        System.out.println(notas.toString());

        //System.out.println("Exibindo a posição da nota 5:");
        //como ela fica de forma aleatoria posso usar o metodo indexOf();

        //System.out.println("Adicionando na lista a nota 8.0 na posição 4: ");
        // imposivel trabalhar com posição

        //System.out.println("Subistituindo a nota 5.0 , pela nota 6.0: ");
        // não se pode subistituir com o set, só se fosse uma List

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
        // aqui eu consigo, pq eu tenho o metodo "contains" na interface Set irá retornar true se eu tiver, e false se eu não tiver

        //System.out.println("exiba a terceira nota adicionada: ");
        // não consigo pq não tenho o metodo get pra passar o indíce pra assim ele me retornar a nota

        System.out.println("exiba a menor nota:" + Collections.min(notas)); // recebe um set, que é um collection

        System.out.println("exiba a maior nota:" + Collections.max(notas)); // recebe um set, que é um collection

        //System.out.println("exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();// usando o iterator
        double soma = 0.0;
        while (iterator.hasNext()) { // verificando se tem proximo
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("exiba a soma dos valores:" + soma);

        System.out.println("exiba a media das notas: " + (soma/ notas.size())); // pra saber a quantidade o metodo é notas.size()

        System.out.println("remova a nota 0: ");
        notas.remove(0d);  // removendo pq é em double, se fosse int, não iria fazer a manipulação pq n tem indice
        System.out.println(notas);

        //System.out.println("remova a nota 0 da posição 0: "); // com eu disse anteriormente, não possui indice

        System.out.println("remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator(); // criando a variavel
        while (iterator1.hasNext()) { // enquanto tiver proximo
            Double next = iterator1.next(); // crinado a variavel para o proximo elemento
            if (next < 7) iterator1.remove(); // perguntando e removendo se for menor que 7
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exiba as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("apague todo o conjunto:");
        notas.clear();

        System.out.println("verificando se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("verificando se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("verificando se o conjunto 3 está vazio: " + notas3.isEmpty());

    }
}
