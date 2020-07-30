package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText campoNome ;
    private EditText campoEmail;
    private TextView resultado;
    private TextView resultado2;

    private CheckBox checkVerde , checkVermelho, checkPreto;

    private RadioButton sexoMasculino , sexoFeminino ;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.nome);
        campoEmail = findViewById(R.id.email);
        resultado = findViewById(R.id.resultado);



        //checkbox
        checkVerde = findViewById(R.id.checkVerde);
        checkVermelho = findViewById(R.id.checkVermelho);
        checkPreto = findViewById(R.id.checkPreto);

        //radiobutton
        sexoMasculino = findViewById(R.id.radioButtonM);
        sexoFeminino = findViewById(R.id.radioButtonF);
        opcaoSexo = findViewById(R.id.radioGroupSexo);
        radionbutton();

        resultado = findViewById(R.id.resultado);
        resultado2 = findViewById(R.id.resultado2);

    }
    public void checkbox(){
        String texto = "";
        if (checkVerde.isChecked()){
            texto = texto + "Verde Selecionado -";
        }
        if(checkPreto.isChecked()){
            texto = texto + "Preto Selecionado -";
        }
        if (checkVermelho.isChecked()){
            texto = texto + "Vermelho Selecionado";
        }
        resultado.setText (texto);
    }
    public void radionbutton(){

        //muda automaticamente
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonF){
                    resultado.setText ("Feminino Selecionado");
                }else if (i == R.id.radioButtonM){
                    resultado.setText("Masculino Selecionado");
                }
            }
        });

        /*
        String texto2 = "";
        if (sexoMasculino.isChecked()){
            texto2 = "Masculino Selecionado";
        }
        if(sexoFeminino.isChecked()){
            texto2 = "Feminino Selecionado";
        }
        resultado.setText(texto2);*/
    }

    public void enviar(View view){
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        checkbox();
        resultado2.setText("nome: " + nome + " - e-mail: "+ email);
    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
    }
}
