package Direct3;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t");

        Map<String, Livro> meusLivros = new HashMap<>() {{ // ordem aleatória usa o HashMap<>();
            put(" Hawking, Stephen", new Livro("Uma breve história no tempo", 256));
            put(" Duhing, Charles", new Livro("O poder do hábito", 408));
            put(" Harari,Youval Noah", new Livro("21 lições para o século 21", 432));

        }};
        for ( Map.Entry<String, Livro>  livro : meusLivros.entrySet())
            // vai ser aleatória, porém so vai retornar a chave e o nome
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem de Inserção\t"); // segue o exemplo anterior troca o HashMap, por LinkedHashMap
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put(" Hawking, Stephen", new Livro("Uma breve história no tempo", 256));
            put(" Duhing, Charles", new Livro("O poder do hábito", 408));
            put(" Harari,Youval Noah", new Livro("21 lições para o século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("--\tOrdem alfabética dos autores\t");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabética dos nomes dos livros\t");

        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome()); // retorna vazio pq só iniciei
        meusLivros3.addAll(meusLivros.entrySet()); // agora vai me dar o set
        // não precisa do "entrySet" pq ja ta pegando do Set<Map.Entry<String, Livro>> meusLivros3
        for(Map.Entry<String, Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        //System.out.println(meusLivros3.toString());


        //System.out.println("--\tOrdem Número de páginas\t");


    }
}
class Livro{ // criando a class livro
    private String nome;
    private Integer paginas;

    // criando o construtor
    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }
    // criando os gets
    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
// criando a class para comparar o Map.Entry<String, Livro>>
class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override // Impelentando o metodo
    public int compare(Map.Entry<String, Livro> L1, Map.Entry<String, Livro> L2) {
        return L1.getValue().getNome().compareToIgnoreCase(L2.getValue().getNome());
    }
}