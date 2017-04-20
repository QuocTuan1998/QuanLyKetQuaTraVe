package com.example.quoctuan.quanlyketquatrave.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quoctuan.quanlyketquatrave.R;

public class MainActivity extends AppCompatActivity {

    EditText editA,editB;
    Button btnXuLy;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }

    private void addControls() {

        editA = (EditText) findViewById(R.id.editA);
        editB = (EditText) findViewById(R.id.editB);

        btnXuLy = (Button) findViewById(R.id.btnxuLy);

        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
    }

    private void addEvents() {

        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLayUSCLN();
            }
        });

    }

    private void xuLyLayUSCLN() {
//        khởi tạo intent
        Intent intent = new Intent(MainActivity.this,ManHinhXuLyActivity.class);
//        truyền a,b qua
        intent.putExtra("a",Integer.parseInt(editA.getText().toString()));
        intent.putExtra("b",Integer.parseInt(editB.getText().toString()));
//      phải goi startActivityForResult ( intent muốn gọi,Mã yêu cầu(k đc trùng))
        startActivityForResult(intent,99);

    }
//      override onActivityResult : tự động lấy kết quả trả về từ màn hình khác
//      với điều kiện nó phải nằm trong foreground lifetime
//      requestCode : Mã yêu cầu mà mình gửi đi
//      resultCode : Mã KQ trả về
//      data : kết quả trả về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//      khi lấy kết quả luôn phải bỏ trong if
        if (requestCode == 99 && resultCode == 33){

            int uscln = data.getIntExtra("uscln",1);
            txtKetQua.setText("USCLN = "+uscln);
        }

    }
}
