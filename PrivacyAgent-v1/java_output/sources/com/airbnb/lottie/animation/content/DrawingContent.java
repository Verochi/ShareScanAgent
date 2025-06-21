package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public interface DrawingContent extends com.airbnb.lottie.animation.content.Content {
    void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i);

    void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z);
}
