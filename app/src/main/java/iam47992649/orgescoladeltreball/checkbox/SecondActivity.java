package iam47992649.orgescoladeltreball.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text2 = (EditText) findViewById(R.id.editText2);

        String s = getIntent().getStringExtra("text");

        text2.setText(s);

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("text", text2.getText().toString());
        setResult(RESULT_OK,intent);
        super.finish();
    }
}
