package br.com.jvcm.comparadordecombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtEthanol;
    private EditText edtGasoline;
    private Button btnCompare;
    private View containerFragment;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEthanol = findViewById(R.id.edt_ethanol);
        edtGasoline = findViewById(R.id.edt_gasoline);
        btnCompare = findViewById(R.id.btn_compare);
        containerFragment = findViewById(R.id.layout_container);
        btnCompare.setOnClickListener(this::onClickComparar);
    }

    public String getResult(){
        return result;
    }

    private boolean getValue(View view){
        float value =0;
        int multi = 100;
        try {
            if(view == btnCompare){
                value = (Float.parseFloat(edtEthanol.getText().toString()) * multi ) /
                        Float.parseFloat(edtGasoline.getText().toString());
            }
           result = String.valueOf(value);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Falha ao comparar valores", Toast.LENGTH_LONG).show();
        }

        return getValue(view);
    }

    public void onClickComparar(View view){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.layout_container, FragmentResult.newInstance(String.valueOf(getValue(view))))
                .commit();
    }
}
