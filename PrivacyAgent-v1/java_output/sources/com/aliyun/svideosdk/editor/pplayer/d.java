package com.aliyun.svideosdk.editor.pplayer;

/* loaded from: classes12.dex */
public class d implements com.aliyun.svideosdk.editor.pplayer.c {
    private long a;

    @Override // com.aliyun.svideosdk.editor.pplayer.c
    public long a() {
        return android.os.SystemClock.uptimeMillis() - this.a;
    }

    @Override // com.aliyun.svideosdk.editor.pplayer.c
    public long b() {
        return android.os.SystemClock.uptimeMillis();
    }

    @Override // com.aliyun.svideosdk.editor.pplayer.c
    public void reset() {
        this.a = android.os.SystemClock.uptimeMillis();
    }
}
