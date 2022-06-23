package br.com.senac.projetoapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declarar as variaveis globais
    ListView lstFilmes;

    //Criando os dados para a lista


    String titulo[] = {"Wrath Of Man", "Moonfall", "Mebeforeyou", "shrek2", "Ghostbusters:Afterlife", "Tom Clancy's Without Remorse", "Jumanji: The Next Level", "Shrek"};
    String ano[] = {"2021", "2022", "2016", "2004", "2021", "2021", "2020", "2001", "2019"};
    String classificação[] = {"18 anos ou mais", "13 anos ou mais", "13 anos ou mais", "7 anos ou mais", "13 anos ou mais", "16 anos ou mais", "13 anos ou mais", "7 anos ou mais", "13 anos ou mais"};
    int[] imgFilmes = {R.drawable.filme2, R.drawable.filme3, R.drawable.filme4, R.drawable.filme5, R.drawable.filme6, R.drawable.filme7, R.drawable.filme8, R.drawable.filme9, R.drawable.filme10};
    String notas[] = {"846", "420", "754", "1.527", "845", "2.165", "9.273", "1.527", "43"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAdapter adapter = new MyAdapter();
        lstFilmes.setAdapter(adapter);
        lstFilmes = findViewById(R.id.Listafilmes);
        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MostrarFilmesActivity.class);
                intent.putExtra("titulo", titulo[position]);
                intent.putExtra("ano", ano[position]);
                intent.putExtra("classificacao", classificação[position]);
                intent.putExtra("notas", notas[position]);
                intent.putExtra("imagemFilme", imgFilmes[position]);
                startActivity(intent);
            }
        });

    }

    //criando uma classe interna inner class

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgFilmes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageFilmes;
            TextView txtTitulo, txtANo, txtClassificação, txtNotas;

            View view = getLayoutInflater().inflate(R.layout.modelo_filmes, null);
            txtTitulo = view.findViewById(R.id.txtmodeloTitulo);
            txtANo = view.findViewById(R.id.txtmodeloAno);
            txtClassificação = view.findViewById(R.id.txtmodeloAnoclassifiação);
            txtNotas = view.findViewById(R.id.txtmodeloAno);
            imageFilmes = view.findViewById(R.id.imgmodeloFilme);

            txtTitulo.setText(titulo[position]);
            txtANo.setText(ano[position]);
            txtClassificação.setText(classificação[position]);
            txtNotas.setText(notas[position]);
            return view;
        }
    }

}