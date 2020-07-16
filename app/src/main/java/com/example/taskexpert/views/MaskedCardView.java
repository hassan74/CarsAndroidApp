package com.example.taskexpert.views;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.ShapeAppearancePathProvider;

import android.graphics.Canvas;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.card.MaterialCardView;
import android.annotation.SuppressLint;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

public class MaskedCardView extends MaterialCardView {
    private ShapeAppearancePathProvider pathProvider = new ShapeAppearancePathProvider();
    private Path path =new Path();
    private ShapeAppearanceModel shapeAppearance =new ShapeAppearanceModel();
    private RectF rectF = new RectF(0f, 0f, 0f, 0f);
    public MaskedCardView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        rectF.right = (float)w;
        rectF.bottom = (float) h;
        pathProvider.calculatePath(shapeAppearance, 1f, rectF, path);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public MaskedCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskedCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
