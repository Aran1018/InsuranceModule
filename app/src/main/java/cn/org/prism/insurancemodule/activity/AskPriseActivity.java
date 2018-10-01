package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.os.Bundle;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;

public class AskPriseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        //1
        //2
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askprise);
        initView();
    }

    private void initView() {
        initTitle();
    }

    private void initTitle() {
        Title title = findViewById(R.id.title);
        title.setTitleNameStr("一键询价");
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, R.mipmap.navigationbar_back,null);
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT2, R.mipmap.myinsurance_title_phone, null);
        title.mSetButtonInfo(buttonLeft);
        title.mSetButtonInfo(buttonRight);
    }
}
