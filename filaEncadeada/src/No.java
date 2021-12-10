public class No<T> {

    private T conteudo;
    private No proximoNo;

    public No() { // construtor em que every proximoNo é null
        this.proximoNo = null;
    }

    public No(T conteudo) {
        this.proximoNo = null;
        this.conteudo = conteudo;
    }

    public No(T conteudo, No proximoNo) {
        this.conteudo = conteudo;
        this.proximoNo = proximoNo;
    }

    public T getConteudo() { //getters and setters
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override // toString
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringEncadeado(){  // toString personalizado
        String str = "No{" +
                "conteudo=" + conteudo +
                '}';
        if(proximoNo != null){
            str += "->" + proximoNo.toString();
        } else {
            str += "->null";
        }
        return str;
    }
}
