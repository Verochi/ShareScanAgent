package com.aliyun.svideosdk.editor.e;

/* loaded from: classes12.dex */
class b {
    private long a;
    private java.lang.String b;
    private com.aliyun.svideosdk.editor.e.c c;

    public long a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(com.aliyun.svideosdk.editor.e.c cVar) {
        this.c = cVar;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String b() {
        return this.b;
    }

    public com.aliyun.svideosdk.editor.e.c c() {
        return this.c;
    }

    public java.lang.String toString() {
        return "RollCaptionInfo{mStartTs=" + this.a + ", mText='" + this.b + "'}";
    }
}
