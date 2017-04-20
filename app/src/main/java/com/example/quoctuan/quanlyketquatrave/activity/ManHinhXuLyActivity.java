package com.example.quoctuan.quanlyketquatrave.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quoctuan.quanlyketquatrave.R;

public class ManHinhXuLyActivity extends AppCompatActivity {

    TextView txtNhan;
    Button btnTinh;
    Intent intent;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_xu_ly);

        addControls();
        addEvents();
    }

    private void addControls() {

        txtNhan = (TextView) findViewById(R.id.txtNhan);
        btnTinh = (Button) findViewById(R.id.btnTinh);
//        Lấy dữ liệu ra
        intent = getIntent();
        a = intent.getIntExtra("a",-1);
        b = intent.getIntExtra("b",-1);
        txtNhan.setText("a = "+a+"b = "+b);

    }

    private void addEvents() {

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTinh();
            }
        });

    }

    private void xuLyTinh() {

        int min = Math.min(a,b);
        int uscln = 1;
        for (int i = min;i >= 1;i--){
            if (a%i == 0 && b%i == 0){
                uscln = 1;
                break;
            }
        }
//        thay đổi thông tin và gán vào intent
//        nên sử dụng lại intent (không cần tạo mới)
        intent.putExtra("uscln",uscln);
//        đánh dấu kết quả trả về (mã kết quả trả về,intent)
        setResult(33,intent);
//        phải đóng màn hình : để màn hình mainActivity trở thành foreground lifetime
//        vì nó chỉ tự động nhận kết quả trả về ở trong foreground lifetime
        finish();

    }


}
