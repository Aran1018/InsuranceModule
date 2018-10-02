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

    //test1111111

    public RouteManDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public enum DialogTheme {
        THEME_INSURANCE
    }

    public static class Builder {
        private Context context;
        private String title;
        private String message;
        private String messagetwo;
        private String positiveButtonText;
        private View view;
        private OnClickListener positiveButtonClickListener;
        private DialogTheme theme;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessagetwo(String message) {
            this.messagetwo = message;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
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
                case THEME_INSURANCE:
                    layout = inflater.inflate(R.layout.layout_insurance_dialog, null);
                    break;
            }
            dialog.addContentView(layout, new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            if (title != null) {
                ((TextView) layout.findViewById(R.id.dialog_title)).setText(title);
            }
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
            //添加单纯文字
            if (message != null) {
                ((TextView) layout.findViewById(R.id.messageone)).setText(message);
            }

            if (messagetwo != null) {
                ((TextView) layout.findViewById(R.id.messagetwo)).setText(messagetwo);
            }

            dialog.setContentView(layout);

            return dialog;

        }
    }
}
