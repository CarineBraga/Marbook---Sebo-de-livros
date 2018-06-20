package br.com.marbook.marbook.mvp;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;

import br.com.marbook.marbook.ModelLivro;



public interface MVP {
    interface ModelImpl{
        public void retrieveLivros();
        public void updateEhFavoritoLivro(ModelLivro livro);
    }

    interface PresenterImpl{
        public void retrieveLivros(Bundle savedInstanceState);
        public void showToast(String mensagem);
        public void showProgressBar(boolean status);
        public void setView(ViewImpl view);
        public Context getContext();
        public void updateListaRecycler(ArrayList<ModelLivro> m);
        public void updateItemRecycler(ModelLivro l);
        public ArrayList<ModelLivro> getLivros();

        void updateCompradoLivros(ModelLivro livro);
    }

    interface ViewImpl{
        String LIVROS_KEY = "livros";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void updateListaRecycler();
        public void updateItemRecycler(int posicao);
    }
}
