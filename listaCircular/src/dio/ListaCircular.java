package dio;

public class ListaCircular<T> {

    private No<T> cabeca; // último nó da lista
    private No<T> cauda;  // primeiro nó da lista
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){  // apenas adicionando apenas à cauda
        No<T> novoNo = new No<>(conteudo);
        if(this.tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        } else {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index){
        if (index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista.");
        No<T> noAuxiliar = this.cauda;
        if(index == 0){ // se retirarmos a cauda (indice 0)
            this.cauda = this.cauda.getNoProximo();  // a cauda passa a ser o proximoNo
            this.cabeca.setNoProximo(this.cauda);   // e a cabeça que estava apontando para a antiga cauda, agora aponta para nova cauda
        } else if(index == 1) { // para retirar o indice1
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo()); // fazemos a cauda indice0 setar como noProximo o indice2 então o indice1 é automaticamente excluido pela JVM
        } else {
            for(int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }

    public T get(int index){ // pega o conteúdo de um nó indicado
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){ // processo interno por isso private, usuário não fará nada
        if(this.isEmpty())   // verifica se lista está vazia
            throw new IndexOutOfBoundsException("A lista está vazia");
        if(index == 0) {  // se o índice é 0 significa que estamos na cauda
            return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;  // ref temporária de nó
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo(); // enquanto o noAuxiliar não chegar no desejado, se move para o próximo
        }
        return noAuxiliar; // quando chega ao nó desejado
    }
    
    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {   // facilita a visualização do que tem dentro da lista
        String strRetorno = "";

        No<T> noAuxiliar = this.cauda;
        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += this.size() != 0 ? "(Retorna ao início)" : "[]";
        return strRetorno;

    }
}
