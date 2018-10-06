package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.RouteManDialog;
import cn.org.prism.insurancemodule.widget.Title;

public class AskPriseActivity extends Activity {

    private LinearLayout ll_choosekind;
    private Button bt_toaskprise;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askprise);
        initTitle();
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        ll_choosekind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskPriseActivity.this, PickInsuranceKindActivity.class);
                startActivity(intent);
            }
        });
        bt_toaskprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RouteManDialog.Builder(AskPriseActivity.this)
                        .setTheme(RouteManDialog.DialogTheme.THEME_INSURANCE_SUBMIT_SUCCESS)
                        .setPositiveButton(getString(R.string.button_ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(AskPriseActivity.this, MyReportActivity.class);
                                startActivity(intent);
                                finish();
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

    private void initView() {
        ll_choosekind = (LinearLayout) findViewById(R.id.ll_choosekind);
        bt_toaskprise = (Button) findViewById(R.id.bt_toaskprise);
    }

    private void initTitle() {
        Title title = findViewById(R.id.title);
        title.setTitleNameStr(getString(R.string.myinsurance_button_queryprise));
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, R.mipmap.navigationbar_back,null);
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT2, R.mipmap.myinsurance_title_phone, null);
        title.setButtonInfo(buttonLeft);
        title.setButtonInfo(buttonRight);
    }
}
