package cn.org.prism.insurancemodule.widget;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.org.prism.insurancemodule.R;


/**
 * Created by Qiuyue on 2017/9/20.
 */


public class RouteManDialog extends Dialog {

    public RouteManDialog(Context context) {
        super(context);
    }

    public RouteManDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RouteManDialog(Context context, boolean cancelable,
                             OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public enum DialogTheme {
        THEME_INSURANCE_PAY_SUCCESS,
        THEME_INSURANCE_SUBMIT_SUCCESS,
    }

    public static class Builder {
        private Context context;
        private String positiveButtonText;
        private View view;
        private OnClickListener positiveButtonClickListener;
        private DialogTheme theme;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setPositiveButton(String positiveButtonText,
                                         OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public View getView() {
            return view;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public Builder setTheme(DialogTheme theme) {
            this.theme = theme;
            return this;
        }

        public RouteManDialog create() {
            //todo create viewHolder to modify layout

            View layout = null;
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final RouteManDialog dialog = new RouteManDialog(context, R.style.DialogTheme);
            switch (theme) {
                case THEME_INSURANCE_PAY_SUCCESS:
                    layout = inflater.inflate(R.layout.layout_insurance_alreadybuy__dialog, null);
                    break;
                case THEME_INSURANCE_SUBMIT_SUCCESS:
                    layout = inflater.inflate(R.layout.layout_insurance_alreadybuy__dialog, null);
                    break;
            }
            dialog.addContentView(layout, new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            if (positiveButtonText != null) {
                ((Button) layout.findViewById(R.id.btn_dialog_ok))
                        .setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.btn_dialog_ok))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    positiveButtonClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_NEGATIVE);
                                }
                            });
                }
            } else {
                layout.findViewById(R.id.btn_dialog_ok).setVisibility(
                        View.GONE);
            }

            dialog.setContentView(layout);

            return dialog;

        }
    }
}
