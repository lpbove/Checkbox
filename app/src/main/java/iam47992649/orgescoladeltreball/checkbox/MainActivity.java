package iam47992649.orgescoladeltreball.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private CheckBox c1,c2;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        text = (EditText) findViewById(R.id.editText);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String s = text.getText().toString();
                if(c1.isChecked()){
                    s = invert(s);
                }
                if(c2.isChecked()){
                    s = capitalize(s);
                }
                intent.putExtra("text",s);
                startActivityForResult(intent,1234);
            }
        };

        button.setOnClickListener(listener);
    }
    private String invert(String s){
      return new StringBuilder(s).reverse().toString();
    }
    private String capitalize(String s){
       return s.toUpperCase();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1234){
            switch(resultCode){
                case RESULT_OK:
                    text.setText(data.getCharSequenceExtra("text"));
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this,"fallo",Toast.LENGTH_LONG).show();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
