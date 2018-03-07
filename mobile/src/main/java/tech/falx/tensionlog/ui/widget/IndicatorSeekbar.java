/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.widget;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class IndicatorSeekbar extends android.support.v7.widget.AppCompatSeekBar {
    public IndicatorSeekbar(Context context) {
        super(context);
    }

    public IndicatorSeekbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public IndicatorSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        float thumb_x = (float) this.getWidth() * 0.48f;
        float middle = (float) (this.getHeight()) * 0.8f;

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(53);
        c.drawText("" + this.getProgress(), thumb_x, middle, paint);
    }
}
