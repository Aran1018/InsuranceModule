package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.RouteManDialog;
import cn.org.prism.insurancemodule.widget.Title;

public class MyInsuranceActivity extends Activity {

    private LinearLayout ll_myinsurance_buynow;
    private LinearLayout ll_myinsurance_callme;
    private LinearLayout ll_myinsurance_editdata;
    private Button bt_buynow;
    private Button bt_continuebuy;
    private Button bt_editdata;
    private Button bt_askprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinsurance);
        setTitle();
        initView();
        setOnClickListener();
    }

    private void initView() {
        ll_myinsurance_buynow = (LinearLayout) findViewById(R.id.ll_myinsurance_buynow);
        ll_myinsurance_callme = (LinearLayout) findViewById(R.id.ll_myinsurance_callme);
        ll_myinsurance_editdata = (LinearLayout) findViewById(R.id.ll_myinsurance_editdata);
        bt_buynow = (Button) findViewById(R.id.bt_buynow);
        bt_editdata = (Button) findViewById(R.id.bt_editdata);
        bt_askprise = (Button) findViewById(R.id.bt_askprise);
        bt_continuebuy = (Button) findViewById(R.id.bt_continuebuy);
    }

    private void setOnClickListener() {
        ll_myinsurance_buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInsuranceActivity.this, MyReportActivity.class);
                startActivity(intent);
            }
        });
        bt_buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInsuranceActivity.this, MyReportActivity.class);
                startActivity(intent);
            }
        });
        ll_myinsurance_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInsuranceActivity.this, EditPersonalDataActivity.class);
                startActivity(intent);
            }
        });
        bt_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInsuranceActivity.this, EditPersonalDataActivity.class);
                startActivity(intent);
            }
        });
        bt_continuebuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RouteManDialog.Builder(MyInsuranceActivity.this)
                        .setTheme(RouteManDialog.DialogTheme.THEME_INSURANCE_SUBMIT_SUCCESS)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });
        bt_askprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInsuranceActivity.this, AskPriseActivity.class);
                startActivity(intent);
            }
        });
        ll_myinsurance_callme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RouteManDialog.Builder(MyInsuranceActivity.this)
                        .setTheme(RouteManDialog.DialogTheme.THEME_INSURANCE_PAY_SUCCESS)
                        .setPositiveButton("查看维修基金", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

    private void setTitle() {
        Title title = findViewById(R.id.title);
        title.setTitleNameStr("我的保险");
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, R.mipmap.navigationbar_back,null);
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT2, 0, "历史保单");
        title.setButtonInfo(buttonLeft);
        title.setButtonInfo(buttonRight);
    }
}
