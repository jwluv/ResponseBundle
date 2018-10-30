package com.lyna.www.responsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonExplicitActivity;
    TextView textViewMainResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonExplicitActivity = (Button)findViewById(R.id.buttonExplicitActivity);
        buttonExplicitActivity.setOnClickListener(this);

        textViewMainResult = (TextView)findViewById(R.id.textViewMainResult);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, ExplicitActivity.class);
        String text = "Explicit intent Response";
        bundle.putString("SingleName", text);
        bundle.putString("BundleName", bundle.toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Bundle bundle = data.getExtras();
        String str = "Result value: " + bundle.getString("resultValue", "No Data");
        textViewMainResult.setText(str);

        super.onActivityResult(requestCode, resultCode, data);
    }

}
