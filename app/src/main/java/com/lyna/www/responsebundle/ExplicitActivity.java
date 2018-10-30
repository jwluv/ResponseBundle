package com.lyna.www.responsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitActivity extends AppCompatActivity {

    TextView textViewSinglename, textViewBundlename;
    EditText editTextResultvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        Bundle bundle = getIntent().getExtras();
        textViewSinglename = (TextView)findViewById(R.id.textViewSinglename);
        textViewBundlename = (TextView)findViewById(R.id.textViewBundlename);
        editTextResultvalue = (EditText)findViewById(R.id.editTextResultvalue);

        textViewSinglename.setText("SingleName: " + bundle.getString("SingleName", "No Data"));
        textViewBundlename.setText("BundleName: " + bundle.getString("BundleName", "No Data"));
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultValue", ((EditText)editTextResultvalue).getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
    }

}
