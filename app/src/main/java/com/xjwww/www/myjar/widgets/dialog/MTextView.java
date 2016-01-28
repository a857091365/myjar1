package com.xjwww.www.myjar.widgets.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.xjwww.www.myjar.config.Config;


public class MTextView extends TextView {

	// 自定义组件实现的3个方法

	public MTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	public MTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public MTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		if (!isInEditMode()) {
			this.setTypeface(Config.typeface);
		}
	}
    /*
    @Override
    protected void onDraw(Canvas canvas) {
        int yOffset = getHeight() - getBaseline();
        canvas.translate(0, yOffset);
        super.onDraw(canvas);
    }
    */
}
