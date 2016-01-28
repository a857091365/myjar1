package com.xjwww.www.myjar.widgets.dialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

public class BaseDialog extends Dialog {

	public BaseDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public BaseDialog(Context context, int theme) {
        super(context, theme);

    }



    public BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
	public void initSize(){
        Window dialogWindow= this.getWindow();
	    WindowManager.LayoutParams lp = dialogWindow.getAttributes();
	    dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER);
	    WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		 //lp.alpha = 0.7f; // 透明度
	    dialogWindow.setAttributes(lp);
	}
    public void initBottomSize(){
        Window dialogWindow= this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        // 设置显示动画
       // dialogWindow.setWindowAnimations(R.style.main_menu_animstyle);
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        dialogWindow.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        //lp.alpha = 0.7f; // 透明度
        dialogWindow.setAttributes(lp);
    }

	public void initFullSize(){
        Window dialogWindow= this.getWindow();
	    WindowManager.LayoutParams lp = dialogWindow.getAttributes();
	    dialogWindow.setGravity( Gravity.BOTTOM);
	    WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		lp.width = dm.widthPixels; // 宽度
		 //lp.alpha = 0.7f; // 透明度
	    dialogWindow.setAttributes(lp);

	}

	public void initSize(int width,int height){
        Window dialogWindow= this.getWindow();
	    WindowManager.LayoutParams lp = dialogWindow.getAttributes();
	    dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER);
	    WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		lp.width = dm.widthPixels-width*2; // 宽度
		lp.height=dm.heightPixels-height*2;
		 //lp.alpha = 0.7f; // 透明度
	    dialogWindow.setAttributes(lp);
	}

	public void initWidthSize(){
		 Window dialogWindow= this.getWindow();
		    WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		    dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER);
		    WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
			DisplayMetrics dm = new DisplayMetrics();
			wm.getDefaultDisplay().getMetrics(dm);
			lp.width = LayoutParams.WRAP_CONTENT; // 宽度
			 //lp.alpha = 0.7f; // 透明度
		    dialogWindow.setAttributes(lp);
	}
}
