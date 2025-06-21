package com.anythink.expressad.foundation.g.i;

/* loaded from: classes12.dex */
public final class a {
    private java.lang.String b;
    private android.media.MediaPlayer c;
    private volatile boolean d;
    private volatile android.media.MediaPlayer.OnPreparedListener f;
    java.lang.Object a = new java.lang.Object();
    private volatile boolean e = false;

    /* renamed from: com.anythink.expressad.foundation.g.i.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.MediaPlayer.OnPreparedListener {
        public AnonymousClass1() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
            synchronized (com.anythink.expressad.foundation.g.i.a.this.a) {
                com.anythink.expressad.foundation.g.i.a.a(com.anythink.expressad.foundation.g.i.a.this);
                if (com.anythink.expressad.foundation.g.i.a.this.f != null) {
                    com.anythink.expressad.foundation.g.i.a.this.f.onPrepared(mediaPlayer);
                }
            }
        }
    }

    private void a(android.media.MediaPlayer.OnPreparedListener onPreparedListener) {
        synchronized (this.a) {
            this.f = onPreparedListener;
        }
    }

    private void a(android.media.MediaPlayer mediaPlayer, java.lang.String str) {
        this.c = mediaPlayer;
        this.b = str;
        this.d = true;
        this.c.setOnPreparedListener(new com.anythink.expressad.foundation.g.i.a.AnonymousClass1());
        try {
            this.c.prepareAsync();
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.foundation.g.i.a aVar) {
        aVar.e = true;
        return true;
    }

    private boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.e;
        }
        return z;
    }

    private java.lang.String c() {
        return this.b;
    }

    private android.media.MediaPlayer d() {
        return this.c;
    }
}
