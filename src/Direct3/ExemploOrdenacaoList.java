package Direct3;

 // Ordenando as seguintes informações dos meus gatos, criando uma lista
// Ordenando a lista exibindo : (nome - idade - cor)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
gato 1 = nome: theo, idade: 18, cor: branco
gato 2 = nome: akira, idade: 16, cor: malahado
gato 3 = nome: preto, idade: 10, cor: preto

 */
public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        // Criando a lista
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("theo",18, "branco"));
            add(new Gato("akira",16, "malhado"));
            add(new Gato("preto",10, "branco"));
        }};
        //System.out.println(meusGatos);
        System.out.println("--\tOrdem de inserção\t--");
        System.out.println(meusGatos);

        System.out.println("--\tOrdem aleatória\t--");
        Collections.shuffle(meusGatos); // Usando o collections.shuffle passando a minha lista aleatória dentro da mesma
        System.out.println(meusGatos);

        System.out.println("--\tOrdem natural(nome)\t--");
         Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem idade\t--");
        Collections.sort(meusGatos, new comparatorIdade());
       // meusGatos.sort( new comparatorIdade());
        System.out.println(meusGatos);


        System.out.println("--\tOrdem cor\t--");
        //Collections.sort(meusGatos, new comparatorIdade());
        meusGatos.sort(new comparatorCor() );
        System.out.println(meusGatos);

        System.out.println("--\tOrdem nome/cor/idade\t--");
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        //meusGatos.sort(new comparatorNomeCorIdade());
        System.out.println(meusGatos);

    }

}
class Gato implements Comparable<Gato> {    // criando a class gato
    private String nome;
    private Integer idade;
    private String cor;

    // Utilizando o construtor
    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    //
    @Override
    public String toString() {
        return "gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }


    @Override
    public int compareTo(Gato gato) {   // Interface compareto, irá retornar int, esse int irá ser organizado na ordem
        return this.getNome().compareToIgnoreCase(gato.getNome()); // se retornar 0, é porque os gatos são iguais
    }
}
class comparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}
class comparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}
class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int  cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}