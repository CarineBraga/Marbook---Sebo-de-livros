package br.com.marbook.marbook.mvp;

import br.com.marbook.marbook.ModelLivro;



public abstract class Model implements MVP.ModelImpl {
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private MVP.PresenterImpl presenter;

    public Model( MVP.PresenterImpl presenter ){
        this.presenter = presenter;
    }

    @Override
    public void retrieveMotos() {
        RequestParams requestParams = new RequestParams(JsonHttpRequest.METODO_KEY, "get-livros");
        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequest.URI,
                requestParams,
                new JsonHttpRequest( presenter ));
    }

    @Override
    public void updateEhFavoritoMoto(ModelLivro livro) {
        RequestParams requestParams = new RequestParams();
        requestParams.put( JsonHttpRequest.METODO_KEY, "update-favorito-livro" );
        requestParams.put( ModelLivro.ID_KEY,livro.getId() );
        requestParams.put( ModelLivro.COMPRADO_KEY, livro.isComprado() );

        asyncHttpClient.post( presenter.getContext(),
                JsonHttpRequest.URI,
                requestParams,
                new JsonHttpRequest( presenter ));
    }


    @Override
    public void updateCompradoLivro(ModelLivro livro) {
        presenter.updateCompradoLivros( livro );
    }

}
