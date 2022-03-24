package Direct3;

import java.util.*;

import static javax.swing.UIManager.put;

public class ExemploMap {
    public static void main(String[] args) {


        System.out.println("Crie um dicionario que realione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4); // o "put" vai me dar a chave e o valor "Double"
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carrosPopulares.toString());  //  ou System.out.println(carrosPopulares)

        System.out.println("Substitua o consumo do gol por 15,2 km/l : ");
         carrosPopulares.put( "gol", 15.2); // se ja existe a chave "gol", vamos só sobrescrever o valor
        System.out.println(carrosPopulares.toString());

        System.out.println("Confira se o modelo tucson está no dicionario: " + carrosPopulares.containsKey("uno"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get( "uno"));

        //System.out.println("Exiba o terceiro modelo adicionado: "); // sem metodo para passar

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumo = carrosPopulares.values();// values que retorna Collection
        System.out.println(consumo);

        System.out.println("exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values()); // metodoque vai pegar o consumo e modelo
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();// me retorna o set e os elementos dentro desse set
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries ) {
            if(entry.getValue().equals(consumoMaisEficiente));
            modeloMaisEficiente = entry.getKey();
            System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);

        }
        System.out.println("Exiba o medelo menos eficiente e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values()); // seguindo o exemplo anterior
        String modeloMenosEficiente = "";
        for ( Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next(); // enquanto tiver proximo irá somar
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média dos consumos deste dicionario de carros: " + (soma/carrosPopulares.size()));

        System.out.println(carrosPopulares);
        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if ( iterator1.next().equals(15.6)) iterator1.remove();

        }
        System.out.println(carrosPopulares);


        System.out.println("exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4); // o "put" vai me dar a chave e o valor "Double"
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());  //  ou System.out.println(carrosPopulares)

        System.out.println("Exiba o dicionario ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o diconario de carros:  ");
        carrosPopulares.clear();
        //carrosPopulares1.clear();
        //carrosPopulares2.clear();

        System.out.println("Cofira se o dicinario  está vazio: " + carrosPopulares.isEmpty());
        System.out.println("Cofira se o dicinario 2 está vazio: " + carrosPopulares1.isEmpty());
        System.out.println("Cofira se o dicinario 3 está vazio: " + carrosPopulares2.isEmpty());
    }
}
