package com.example.classfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button sampleButton, customButton;
    private Button errorToast, successToast, infoToast, snackBar;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleButton = (Button)findViewById(R.id.sampleButonId);
        customButton = (Button)findViewById(R.id.customButonId);

        errorToast = (Button)findViewById(R.id.errorButonId);
        successToast = (Button)findViewById(R.id.successButonId);
        infoToast = (Button)findViewById(R.id.infoButonId);
        snackBar =(Button)findViewById(R.id.snackBarButtonId);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        snackBar.setOnClickListener(this);
        errorToast.setOnClickListener(this);
        successToast.setOnClickListener(this);
        infoToast.setOnClickListener(this);

        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Sample Toast", Toast.LENGTH_SHORT).show();
            }
        });

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customToast();

            }
        });

    }

    private void customToast() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customLayoutId));
        TextView textView = view.findViewById(R.id.customTextId);
        textView.setText("Login Success");
        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }

    @Override
    public void onClick(View view) {
                switch (view.getId()){
                    case R.id.errorButonId:
                        Toasty.error(MainActivity.this,"This is error", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.successButonId:
                        Toasty.success(MainActivity.this,"Success", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.infoButonId:
                        Toasty.info(MainActivity.this,"info", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.snackBarButtonId:
                        snackMethod();
                        break;

                }
    }

    private void snackMethod() {
        Snackbar.make(linearLayout,"this is snackbar", Snackbar.LENGTH_SHORT)
                .setAction("undo", new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(linearLayout,"Undo Success", Snackbar.LENGTH_SHORT).show();

            }
        }).show();


    }

}