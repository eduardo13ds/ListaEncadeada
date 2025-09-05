import java.util.Scanner;
public class ListaEncadeada {
    private Node Lista;
    public ListaEncadeada(){
        this.Lista = null;
    }
    //Inserindo elementos
    public void inserir (int informacao){
    //Declarando nosso novo nó
        Node no = new Node();
        no.setInformacao(informacao);
        if(Lista == null){
            Lista=no;
        }
        else{
    //Aqui se cria um apontador para a lista.
            Node atual =Lista;
            while(atual.getProximo()!=null){
                atual = atual.getProximo();
            }
            atual.setProximo(no);
            System.out.println("Nó atual no endereço" + atual);
        }
    }

   public void inserePrimeiro(int informacao){
        Node novoPrimeiro = new Node();
        novoPrimeiro.setInformacao(informacao);

        if (Lista == null){
            Lista=novoPrimeiro;
        }
        else{
            // guardado o valor do primeiro item da lista
            Node primeiro = Lista;
            //apontando o novoPrimeiro para o atualPrimeiro
            novoPrimeiro.setProximo(primeiro);
            //Atualizando a referência da lista
            Lista = novoPrimeiro;
        }
    }

    public void insereDepois(int posicao, int informacao) {
        Node no = new Node();
        int contador = 0;
        Node atual = Lista;
        while (contador < posicao && atual != null) {
            atual = atual.getProximo();
            ++contador;
        }

        if (atual == null) {
            throw new IllegalArgumentException("Posição " + posicao + " é inválida ou não existe na lista.");
        }

        no.setProximo(atual.getProximo());
        no.setInformacao(informacao);
        atual.setProximo(no);
    }


    public void insereOrdenado(int info) {
        Node no = new Node();
        Node atual = Lista;
        int contador = 1;
        while (atual.getProximo() != null && atual.getProximo().getInformacao() < info) {
            atual = atual.getProximo();
        }
        if (atual == Lista && info < atual.getInformacao()) {
            no.setProximo(Lista);
            Lista = no;
        } else {
            no.setProximo(atual.getProximo());
            atual.setProximo(no);
        }
        no.setInformacao(info);
    }




    public void removePrimeiro(){
        if (Lista == null){
            System.out.println("A lista está vazia");
        }
        else{
            //Pega o proximo nó
            Node proximo = Lista.getProximo();
            System.out.println("Valor removido: " + Lista.getInformacao());
            //Remove o primeiro
            Lista = proximo;
        }
    }
    public void removeUltimo(){
        if (Lista == null){
            System.out.println("A lista está vazia");
        }

        else{
            Node atual = Lista;

            while (atual != null){

                //caso 1: se a lista somente ter um nó
                if (atual.getProximo() == null){
                    System.out.println("Valor removido: " + Lista.getInformacao());
                    Lista = null;
                    break;
                }
                //caso 2: se a lista ter mais de um nó
                if (atual.getProximo() != null && atual.getProximo().getProximo() == null){
                    System.out.println("Valor removido: " + atual.getProximo().getInformacao());
                    atual.setProximo(null);
                    break;
                }
                atual = atual.getProximo();
            }
        }
    }

    public void remove(int indice){
        if (Lista == null){
            System.out.println("Lista vazia");
        }
        else{
            Node atual = Lista;
            Node anterior = null;
            boolean removido = false;
            int aux = 0;

            while (atual != null){
                //caso 1: se somente tiver um nó na lista
                if (indice == 0 && atual.getProximo() == null){
                    System.out.println("Node removido no indíce: 0");
                    Lista = null;
                    removido = true;
                    break;
                }

                //caso 2: para remover o primeiro caso o indice == 0
                if (indice == 0 && atual.getProximo() != null){
                    System.out.println("Node removido no indíce: 0");
                    Node proximo = atual.getProximo();
                    Lista = proximo;
                    removido = true;
                    break;

                }

                //caso 3: para mais de um nó na lista
                if (aux == indice){
                    System.out.println("Node removido no indíce: " + indice);
                    Node proximo = atual.getProximo();
                    anterior.setProximo(proximo);
                    removido = true;
                    break;
                }


                anterior = atual;
                atual = atual.getProximo();
                aux++;
            }

            if (!removido){
                System.out.println("Índice inválido");
            }
        }
    }
    //Imprimindo elementos
    public void imprime(){
        Node atual = Lista;
        while (atual != null) {
            System.out.print(atual.getInformacao()+ " -> ");
            atual= atual.getProximo();
        }
        System.out.println("Null");
    }

}