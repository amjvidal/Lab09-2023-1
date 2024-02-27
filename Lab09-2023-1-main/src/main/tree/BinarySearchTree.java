package tree;

import estrut.Tree;

class No {
    int item;
    No esquerda;
    No direita;
}

public class BinarySearchTree implements Tree{

    private No root;

    @Override
    public boolean buscaElemento(int valor) {
        if(root == null) return false;
        No atual = root;
        while(atual.item != valor){
            if(valor < atual.item ) atual = atual.esquerda;
            else atual = atual.direita;
            if (atual == null) return false;
        }
        return true;
    }

    @Override
    public int minimo() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esquerda;
        }
        return anterior.item;
    }
    private int minimo(No node) {
        if (node.esquerda == null)
            return node.item;
        return minimo(node.esquerda);
    }

    @Override
    public int maximo() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.direita;
        }
        return anterior.item;
    }

    @Override
    public void insereElemento(int valor) {
        No novo = new No();
        novo.item = valor;
        novo.esquerda = null;
        novo.direita = null;

        if(root == null){
            root = novo;
        }
        else{
            No atual = root;
            No anterior;
            while(true) {
                anterior = atual;
                if (valor <= atual.item) {
                atual = atual.esquerda;
                if (atual == null) {
                    anterior.esquerda = novo;
                    return;
                } 
                }  
                else { 
                atual = atual.direita;
                if (atual == null) {
                    anterior.direita = novo;
                    return;
                }
                } 
            }
        }

        return;
    }

    @Override
    public void remove(int valor) {
        
    }
    



    @Override
    public int[] preOrdem() {
        return preOrdem(root);
    }

    private int[] preOrdem(No no) {
        if (no == null)
            return new int[]{};
        int[] left = preOrdem(no.esquerda);
        int[] right = preOrdem(no.direita);
        int[] result = new int[left.length + right.length + 1];
        result[0] = no.item;
        System.arraycopy(left, 0, result, 1, left.length);
        System.arraycopy(right, 0, result, left.length + 1, right.length);
        return result;
    }

    @Override
    public int[] emOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] posOrdem() {
        return new int[]{1,2};
    }



    public No no_sucessor(No apaga) { 
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.direita; 
   
        while (atual != null) { 
          paidosucessor = sucessor;
          sucessor = atual;
          atual = atual.esquerda; 
        } 
        if (sucessor != apaga.direita) { 
          paidosucessor.esquerda = sucessor.direita; 
          sucessor.direita = apaga.direita;
        }
        return sucessor;
     }

}