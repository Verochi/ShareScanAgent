package com.aliyun.svideosdk.editor.e;

/* loaded from: classes12.dex */
class c {
    private com.aliyun.svideosdk.common.struct.project.Source c;
    private int a = -1;
    private int b = 0;
    private int d = 2;
    private int e = 80;

    @java.lang.Deprecated
    public java.lang.String a() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.c;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.c = source;
    }

    public com.aliyun.svideosdk.common.struct.project.Source b() {
        return this.c;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b;
    }

    public java.lang.String toString() {
        return "RollCaptionStyle{mTextColor=" + this.a + ", mTextStrokeColor=" + this.b + ", mFont='" + this.c + "', mTextSizeUnit=" + this.d + ", mTextSize=" + this.e + '}';
    }
}
