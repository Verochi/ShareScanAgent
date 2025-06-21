package com.aliyun.svideo.editor.guide.shapes;

/* loaded from: classes12.dex */
public interface Shape {
    void draw(android.graphics.Canvas canvas, android.content.Context context, android.graphics.PointF pointF, float f, com.aliyun.svideo.editor.guide.model.Target target, android.graphics.Paint paint);

    int getHeight();

    int getWidth();
}
