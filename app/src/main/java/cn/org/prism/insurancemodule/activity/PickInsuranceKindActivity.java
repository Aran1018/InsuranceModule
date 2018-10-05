package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.os.Bundle;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;

public class PickInsuranceKindActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickinsurancekind);
        setTitle();
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
