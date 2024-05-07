package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar {
    private No cabeca;

    public ListaLigada() {
          cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        if (cabeca == null) {
            return false;
        }
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        No atual = new No(valor);
        int minvalor = cabeca.getValor();
         int minIndex = 0;
        int atualIndex = 0; 
        while (atual != null) {
           if (atual.valor < minvalor) {
                minvalor = atual.valor;
                minIndex = atualIndex + 1;
            }  
           atual = atual.getProximo();
           atualIndex++;
        }
        return -1;
    }

    @Override
    public int minimo() {
       int minvalor = cabeca.getValor();
       No n = cabeca.getProximo();

       while (n != null) {
            if (n.getValor() < minvalor) {
                minvalor = n.getValor();

            }
            Object valor;
            n = n.getProximo(valor);
       }
       return minvalor;
    }

    @Override
    public int maximo() {
        No atual = new No(valor);
        int maxvalor = cabeca.getValor();
         int maxIndex = 0;
        int atualIndex = 0; 
        while (atual != null) {
            if (atual.valor > maxvalor) {
                maxvalor = atual.valor;
                maxIndex = atualIndex + 1;
            }
            atual = atual.getProximo();
            atualIndex++;
        }
    }

    @Override
    public int predecessor(int valor) {
        if (valor > 1 ) {
            int posicao = 1;
            for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
                if (posicao == valor) {
                    return atual.getValor();
                }
                posicao += 1;
            }
            return -1;
            
        
        } else {
            return -1;
        }
    }

    @Override
    public int sucessor(int valor) {
        int posicao = -1;
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            posicao += 1;
            if (posicao == valor) {
                if (atual.getProximo() != null) {
                    return atual.getProximo().getValor();
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
       
    

    @Override
    public void insereElemento(int valor) {
        No novo = new No(valor);
        if (cabeca == null) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            cabeca = new No(valor);
            cabeca.setProximo(atual);
        }
    }



    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No novo = new No(valor);
        if (cabeca == null) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            int idatual = 0;
            if (buscaIndice == 0) {
                novo.setProximo(cabeca);
                cabeca = novo;
            } else {
                while (atual.getProximo() != null) {
                    atual = atual.getProximo();
                    idatual += 1;
                    if (idatual == buscaIndice) {
                        novo.setProximo(atual);
                        atual.setProximo(novo);
                    }
                }
            }
        }
    }

    @Override
    public void insereInicio(int valor) {
       if (this.cabeca == null) {
        this.cabeca = new No(valor);
       }

    }

    @Override
    public void insereFim(int valor) {
        No atual = cabeca;
       while (atual.getProximo() != null) {
           atual = atual.getProximo();
       }
    }

    @Override
    public void remove(int valor) {
       
    }

    @Override
    public void removeIndice(int indice) {
        if (cabeca == null) {
            System.out.println("Lista ligada vazia. Não é possível remover.");
            return;
        }

        
        if (indice == 0) {
            cabeca = cabeca.getProximo();
            return;
        }

        No atual = cabeca;
        int contador = 0;

        
        while (contador < indice - 1 && atual != null) {
            atual = atual.getProximo();
            contador++;
        }

        
        if (atual == null || atual.getProximo() == null) {
            System.out.println("Índice inválido. Não é possível remover.");
            return;
        }

        
        atual = atual.getProximo().getProximo();
    }

    

    @Override
    public void removeInicio() {
        
    }

    @Override
    public void removeFim() {

    }
}