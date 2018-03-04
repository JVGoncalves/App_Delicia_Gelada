package br.com.deliciagelada.app;

public class Produto {

    private int idProduto;
    private String imagem;
    private String nomeProduto;
    private String descricao;
    private String preco;

    public static Produto create(int idProduto, String imagem, String nomeProduto, String descricao, String preco){

        Produto produto = new Produto();

        produto.setIdProduto(idProduto);
        produto.setImagem(imagem);
        produto.setNomeProduto(nomeProduto);
        produto.setDescricao(descricao);
        produto.setPreco(preco);

        return produto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
