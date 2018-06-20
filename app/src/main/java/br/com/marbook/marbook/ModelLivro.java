package br.com.marbook.marbook;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelLivro implements Parcelable {
    public static final String ID_KEY = "id";
    public static final String EH_FAVORITO_KEY = "Comprado";
    private int id;
    private int imagem;
    private String titulo, descricao, preco;

    public ModelLivro(int imagem, String titulo, String descricao, String preco) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
    }

    protected ModelLivro(Parcel in) {
        imagem = in.readInt();
        titulo = in.readString();
        descricao = in.readString();
        preco = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(titulo);
        dest.writeString(descricao);
        dest.writeString(preco);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelLivro> CREATOR = new Creator<ModelLivro>() {
        @Override
        public ModelLivro createFromParcel(Parcel in) {
            return new ModelLivro(in);
        }

        @Override
        public ModelLivro[] newArray(int size) {
            return new ModelLivro[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

}

