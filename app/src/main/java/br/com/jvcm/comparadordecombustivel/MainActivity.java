package br.com.jvcm.comparadordecombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtEthanol;
    private EditText edtGasoline;
    private Button btnCompare;
    private View containerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEthanol = findViewById(R.id.edt_ethanol);
        edtGasoline = findViewById(R.id.edt_gasoline);
        btnCompare = findViewById(R.id.btn_compare);
        containerFragment = findViewById(R.id.layout_container);
    }
}
