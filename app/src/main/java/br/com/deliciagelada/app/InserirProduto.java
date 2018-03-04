package br.com.deliciagelada.app;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.BitSet;

public class InserirProduto extends AppCompatActivity{

    ListView listaProdutos;
    ProdutosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.produtos);

        listaProdutos = (ListView) findViewById(R.id.listaProdutos);

        adapter = new ProdutosAdapter(this, new ArrayList<Produto>());
        listaProdutos.setAdapter(adapter);

        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(InserirProduto.this,InserirProduto.class);
                startActivity(intent);
            }
        });

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {

                // CAMINHO DA API QUE FAZ O SELECT NA tbl_produto
                String retornoJson = Http.get("http://10.0.2.2/INF3M/ProjetoWEB/API/select_produtos.php");
                Log.d("TAG",retornoJson);

                try {
                    JSONArray jsonArray = new JSONArray(retornoJson);

                    for (int i=0 ; i<jsonArray.length(); i++){
                        JSONObject item = jsonArray.getJSONObject(i);

                        adapter.add(Produto.create(
                                item.getInt("idProduto"),
                                item.getString("imagem"),
                                item.getString("nomeProduto"),
                                item.getString("descricao"),
                                item.getString("preco")));
                    }

                } catch (Exception ex) {
                    Log.e("ERRO",ex.getMessage());
                }

                return null;
            }
        }.execute();
    }

    public void nossosProdutos(View view) {
        Intent intent = new Intent(this, InserirProduto.class);
        startActivity(intent);
    }

    public void faleConosco(View view) {
        Intent intent = new Intent(this, FaleConosco.class);
        startActivity(intent);
    }
}