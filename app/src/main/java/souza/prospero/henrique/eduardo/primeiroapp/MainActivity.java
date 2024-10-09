package souza.prospero.henrique.eduardo.primeiroapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//      Declarando e instanciando variáveis relacionadas aos componentes
//      de botão e texto editavel. O método findViewById busca a view pelo ID.
        Button btnSend = this.findViewById(R.id.btnSend);
        EditText etText = this.findViewById(R.id.etText);

//      Utilizando evento de OnClick no componente de botão
        btnSend.setOnClickListener(new View.OnClickListener() {
//          Função que sobrescreve o evento de OnClick e  faz ...
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
                String text = etText.getText().toString();
                
                Intent i = new Intent(MainActivity.this, NextActivity.class);
                i.putExtra("text", text);
                startActivity(i);
            }
        });
    }
}