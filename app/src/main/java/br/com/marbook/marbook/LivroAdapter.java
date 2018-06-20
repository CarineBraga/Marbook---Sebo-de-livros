package br.com.marbook.marbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder>{

    private Context nContext;
    private ArrayList<ModelLivro>mList;

    LivroAdapter(Context context, ArrayList<ModelLivro>list){
        nContext = context;
        mList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(nContext);

        View view;
        view = layoutInflater.inflate(R.layout.rv_livro_itens,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelLivro livroItem = mList.get(position);
        ImageView imagem = holder.item_imagem;
        TextView titulo, descricao, preco;

        titulo = holder.item_titulo;
        descricao = holder.item_descricao;
        preco = holder.item_preco;

        imagem.setImageResource(livroItem.getImagem());

        titulo.setText(livroItem.getTitulo());
        descricao.setText(livroItem.getDescricao());
        preco.setText(livroItem.getPreco());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_imagem;
        TextView item_titulo, item_descricao, item_preco;
        public ViewHolder(View itemView) {
            super(itemView);

            item_imagem = itemView.findViewById(R.id.item_imagem);

            item_titulo = itemView.findViewById(R.id.item_titulo);
            item_descricao = itemView.findViewById(R.id.item_descricao);
            item_preco = itemView.findViewById(R.id.item_preco);

        }
    }

}
