package com.tixon.notificationtextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tikhon.osipov on 20.07.2016
 */
public class NotificationTextView extends TextView {
    Paint backgroundPaint;
    RectF rectFLeft, rectFRight;

    public NotificationTextView(Context context) {
        super(context);
        init();
    }

    public NotificationTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NotificationTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NotificationTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        super.onDraw(canvas);
    }

    private void drawBackground(Canvas canvas) {
        //left arc
        canvas.drawArc(new RectF(0, 0, getHeight(), getHeight()), 90, 180, false, backgroundPaint);
        //right arc
        canvas.drawArc(new RectF(getWidth() - getHeight(), 0, getWidth(), getHeight()), -90, 180, false, backgroundPaint);
        //middle rect
        if(getWidth() > getHeight()) {
            canvas.drawRect(new RectF(getHeight()/2, 0, getWidth() - getHeight()/2, getHeight()), backgroundPaint);
        }
    }

    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setColor(Color.parseColor("#2196f3"));

        rectFLeft = new RectF(0, 0, getHeight()/2, getHeight());
        rectFRight = new RectF(getWidth() - getHeight()/2, 0, getWidth(), getHeight());
    }
}
