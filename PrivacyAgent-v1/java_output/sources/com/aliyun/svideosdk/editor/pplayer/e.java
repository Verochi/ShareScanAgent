package com.aliyun.svideosdk.editor.pplayer;

/* loaded from: classes12.dex */
public class e {
    private final com.aliyun.svideosdk.player.NativePasterPlayer a;
    private final long b;

    public e() {
        com.aliyun.svideosdk.player.NativePasterPlayer nativePasterPlayer = new com.aliyun.svideosdk.player.NativePasterPlayer();
        this.a = nativePasterPlayer;
        this.b = nativePasterPlayer.initialize();
    }

    public void a() {
        this.a.release(this.b);
    }

    public void a(long j) {
        this.a.draw(this.b, j);
    }

    public void a(long j, int i) {
        this.a.addTimeIndex(this.b, j, i);
    }

    public void a(android.view.Surface surface) {
        this.a.setWindow(this.b, surface);
    }

    public void a(java.lang.String str) {
        this.a.setSource(this.b, str);
    }
}
