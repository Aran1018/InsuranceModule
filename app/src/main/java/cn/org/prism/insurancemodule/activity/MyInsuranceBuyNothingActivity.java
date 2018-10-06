package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;

public class MyInsuranceBuyNothingActivity extends Activity {

    private Button bt_askprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinsurance_buynothing);
        setTitle();
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        bt_askprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInsuranceBuyNothingActivity.this, AskPriseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        bt_askprise = (Button) findViewById(R.id.bt_askprise);
    }

    private void setTitle() {
        Title title = findViewById(R.id.title);
        title.setTitleNameStr(getString(R.string.myinsurance));
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, R.mipmap.navigationbar_back,null);
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT2, R.mipmap.myinsurance_title_phone, null);
        title.setButtonInfo(buttonLeft);
        title.setButtonInfo(buttonRight);
    }
}
