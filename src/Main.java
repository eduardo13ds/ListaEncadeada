import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        // Fase 1 - criar a lista
        System.out.println("Digite os itens da lista (digite '0' para parar):");
        while (true) {
            int item = scanner.nextInt();
            if (item == 0) {
                lista.imprime();
                break;
            }
            lista.inserir(item);


        }

        // Fase 2 - Inserir o item sempre na primeira posição
//
//        System.out.println("Digite o valor que vai ser inserido:");
//        int info = scanner.nextInt();
//        lista.inserePrimeiro(3);

        // Fase 3 - Inserir depois de uma posição
//        System.out.println("Digite em que posicao voce quer inserir depois o nó:");
//        int posicao = scanner.nextInt();
//        System.out.println("Digite o valor que vai ser inserido:");
//        int newItem = scanner.nextInt();
//        lista.insereDepois(posicao, newItem);

         //Fase 4 - Inserir ordenado
        System.out.println("Digite o valor que vai ser inserido:");
        int i = scanner.nextInt();

        lista.insereOrdenado(i);

        // Fase 5 - Remove o primeiro da lista
//        lista.removePrimeiro();

        // Fase 6 - Remove o último da lista
//        lista.removeUltimo();

        // Fase 7 - Remove de acordo com o índice
//        lista.remove(1);
        // Exibir lista final
        System.out.println("Lista Encadeada:");
        lista.imprime();
    }
}
