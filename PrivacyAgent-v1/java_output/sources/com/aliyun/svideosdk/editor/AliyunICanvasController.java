package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunICanvasController {
    int applyPaintCanvas();

    void cancel();

    void clear();

    void confirm();

    android.view.View getCanvas();

    boolean hasCanvasPath();

    void release();

    void removeCanvas();

    int resetPaintCanvas();

    void setCurrentColor(int i);

    void setCurrentSize(float f);

    void setPaint(android.graphics.Paint paint);

    void undo();
}
