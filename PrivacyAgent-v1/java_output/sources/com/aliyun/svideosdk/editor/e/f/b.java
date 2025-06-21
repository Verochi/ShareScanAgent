package com.aliyun.svideosdk.editor.e.f;

/* loaded from: classes12.dex */
public class b extends android.widget.TextView implements com.aliyun.svideosdk.editor.e.f.a.d {
    private com.aliyun.svideosdk.editor.e.f.a a;

    public b(android.content.Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.a = com.aliyun.svideosdk.editor.e.f.a.a(this, attributeSet, i).a((com.aliyun.svideosdk.editor.e.f.a.d) this);
    }

    @Override // com.aliyun.svideosdk.editor.e.f.a.d
    public void a(float f, float f2) {
    }

    public com.aliyun.svideosdk.editor.e.f.a getAutofitHelper() {
        return this.a;
    }

    public float getMaxTextSize() {
        return this.a.b();
    }

    public float getMinTextSize() {
        return this.a.c();
    }

    public float getPrecision() {
        return this.a.d();
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        com.aliyun.svideosdk.editor.e.f.a aVar = this.a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        com.aliyun.svideosdk.editor.e.f.a aVar = this.a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setMaxTextSize(float f) {
        this.a.a(f);
    }

    public void setMinTextSize(int i) {
        this.a.b(2, i);
    }

    public void setPrecision(float f) {
        this.a.b(f);
    }

    public void setSizeToFit(boolean z) {
        this.a.a(z);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        com.aliyun.svideosdk.editor.e.f.a aVar = this.a;
        if (aVar != null) {
            aVar.c(i, f);
        }
    }
}
