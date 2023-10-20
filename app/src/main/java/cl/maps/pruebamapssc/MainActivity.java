package cl.maps.pruebamapssc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Inicio de variables
    EditText direuna,diredos,diretres;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se le asigna a cada vaariable su valor a partir de la id de la interfaz
        direuna = findViewById(R.id.elong1);
        diredos = findViewById(R.id.elong2);
        diretres = findViewById(R.id.elong3);

        //Agregamos el boton
        agregar = findViewById(R.id.bagregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Mapa.class
                );
                //Calculo correspondiente
                String cadena1 = (direuna.getText().toString());
                String [] partesuno = cadena1.split(",");
                String partelongituduna = partesuno[0];
                String partelatituduna = partesuno[1];

                String cadena2 = (diredos.getText().toString());
                String [] partesdos = cadena2.split(",");
                String partelongituddos = partesdos[0];
                String partelatituddos = partesdos[1];

                String cadena3 = (diretres.getText().toString());
                String[] partestres = cadena3.split(",");
                String partelongitudtres = partestres[0];
                String partelatitudtres = partestres[1];

                //Se transforman los valores de String a int
                double primeralong = Double.parseDouble(partelongituduna.toString());
                double primeralati = Double.parseDouble(partelatituduna.toString());
                double segundalong = Double.parseDouble(partelongituddos.toString());
                double segundalati = Double.parseDouble(partelatituddos.toString());
                double terceralong = Double.parseDouble(partelongitudtres.toString());
                double terceralati = Double.parseDouble(partelatitudtres.toString());

                //Se envian datos a el Activity del Maps
                intent.putExtra("lo1",primeralong);
                intent.putExtra("la1",primeralati);
                intent.putExtra("lo2",segundalong);
                intent.putExtra("la2",segundalati);
                intent.putExtra("lo3",terceralong);
                intent.putExtra("la3",terceralati);

                startActivity(intent);
            }
        });
    }
}