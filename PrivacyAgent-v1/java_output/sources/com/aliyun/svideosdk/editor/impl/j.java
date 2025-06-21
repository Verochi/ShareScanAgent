package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class j implements com.aliyun.svideosdk.editor.AliyunIPaint {
    private float a = 10.0f;
    private int b = -1;
    private android.graphics.Paint c;

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public android.graphics.Paint getPaint() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.c = paint;
        paint.setColor(this.b);
        this.c.setStrokeWidth(this.a);
        return this.c;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public void setCurrentColor(int i) {
        this.b = i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public void setCurrentSize(float f) {
        this.a = f;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public void setPaint(android.graphics.Paint paint) {
        this.a = paint.getStrokeWidth();
        this.b = paint.getColor();
    }
}
