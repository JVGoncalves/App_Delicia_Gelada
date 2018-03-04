package br.com.deliciagelada.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FaleConosco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fale_conosco);
    }

    public void nossosProdutos(View view) {
        Intent intent = new Intent(this, InserirProduto.class);
        startActivity(intent);
    }

    public void faleConosco(View view) {
        Intent intent = new Intent(this, FaleConosco.class);
        startActivity(intent);
    }

    // onCLICK DO BOTÃO LIGAR
    public void telefonar(View view) {
        Uri uri = Uri.parse("tel:"+"011 1234-5678");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }
}
