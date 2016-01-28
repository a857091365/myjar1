package com.xjwww.www.myjar.widgets.dialog.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.xjwww.www.myjar.R;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by computer on 7/10/15.
 */
public class ComfirmDialog extends BaseDialog {

    @Bind(R.id.textView1)
    TextView txtOk;
    @Bind(R.id.mTextView4)
    TextView txtCancel;
    @Bind(R.id.mTextView1)
    TextView txtInfo;
    @Bind(R.id.mTextView2)
    TextView txtTitle;

    public ComfirmDialog(Context context) {
        super(context);
        init();
    }

    public ComfirmDialog(Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    protected ComfirmDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_comfirm);
        ButterKnife.bind(this);
        initSize();
    }

    public void setOkClick(View.OnClickListener listener) {
        txtOk.setOnClickListener(listener);
    }

    public void setCancelClick(View.OnClickListener listener) {
        txtCancel.setOnClickListener(listener);
    }

    public void setInfo(String str) {
        txtInfo.setText(str);
    }

    public void setTxtCancel(String str) {
        txtCancel.setText(str);
    }

    public void setTxtOk(String str) {
        txtOk.setText(str);
    }

    public void setTxtTitle(String str) {
        txtTitle.setText(str);
    }

}
