package br.com.marbook.marbook.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

import br.com.marbook.marbook.ModelLivro;



public class Presenter implements MVP.PresenterImpl {

    private MVP.ModelImpl model;
    private MVP.ViewImpl view;
    private ArrayList<ModelLivro> livros = new ArrayList<>();


    @Override
    public void setView(MVP.ViewImpl view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void retrieveLivros(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            livros = savedInstanceState.getParcelableArrayList(MVP.ViewImpl.LIVROS_KEY);
            return;
        }
        model.retrieveLivros();
    }

    @Override
    public void updateCompradoLivros(ModelLivro livro) {
        livro.getTitulo(!livro.isTitulo());
        model.updateCompradoLivro(livro);
    }


    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void showProgressBar(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showProgressBar(visibilidade);
    }

    @Override
    public void updateListaRecycler(ArrayList<ModelLivro> m) {
        livros.clear();
        livros.addAll(m);
        view.updateListaRecycler();
    }

    @Override
    public void updateItemRecycler(ModelLivro l) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == l.getId()) {
                livros.get(i).setTitulo(l.isTitulo());
                view.updateItemRecycler(i);
                break;
            }
        }
    }

    @Override
    public ArrayList<ModelLivro> getLivros() {
        return null;
    }

}