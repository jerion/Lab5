package com.example.user.lab5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MA1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma1);



        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dio = new AlertDialog.Builder(MA1.this);
                dio.setTitle("請選擇功能");
                dio.setMessage("請根據下方按鈕，選擇顯示物件");

                dio.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MA1.this, "Dialog關閉", Toast.LENGTH_SHORT).show();
                    }
                });

                dio.setNegativeButton("自定義Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast();
                    }
                });

                dio.setPositiveButton("顯示List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showListDialog();
                    }
                });

                dio.show();
            }
        });
    }

    private void showToast(){
        Toast toast = new Toast(MA1.this);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.cus_toa,
                (ViewGroup) findViewById(R.id.c_t_r));
        toast.setView(layout);
        toast.show();
    }

    private void showListDialog() {
        final String[] list_item = {"message1", "message2", "message3", "message4", "message5"};
        AlertDialog.Builder dio_list = new AlertDialog.Builder(MA1.this);
        dio_list.setTitle("使用List呈現");
        dio_list.setItems(list_item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MA1.this, "你選的是"+list_item[which], Toast.LENGTH_SHORT).show();
            }
        });
        dio_list.show();
    }
}
