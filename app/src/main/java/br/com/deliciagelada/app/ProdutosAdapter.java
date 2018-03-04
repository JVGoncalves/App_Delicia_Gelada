package br.com.deliciagelada.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProdutosAdapter extends ArrayAdapter<Produto> {

    public ProdutosAdapter(Context context, ArrayList<Produto> objects){
        super(context,0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.lista_produtos, null);
        }

        Produto item = getItem(position);

        ImageView imagem = (ImageView) v.findViewById(R.id.imagem);
        TextView txtNome = (TextView) v.findViewById(R.id.txtNome);
        TextView txtDescricao = (TextView) v.findViewById(R.id.txtDescricao);
        TextView txtPreco = (TextView) v.findViewById(R.id.txtPreco);

        txtNome.setText(item.getNomeProduto());
        txtDescricao.setText(item.getDescricao());
        txtPreco.setText(item.getPreco());

        String link ="http://10.0.2.2/INF3M/ProjetoWEB/CMS/" + item.getImagem();
        Log.d("link", link);

        Picasso.with(getContext())
                .load(link)
                .into(imagem);

        return v;
    }
}