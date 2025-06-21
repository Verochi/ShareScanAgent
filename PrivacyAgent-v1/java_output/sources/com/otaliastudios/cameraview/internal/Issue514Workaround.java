package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class Issue514Workaround {
    public final int a;

    public Issue514Workaround(int i) {
        this.a = i;
    }

    public final void a(int i) {
        android.opengl.GLES20.glBindTexture(36197, i);
    }

    public void beforeOverlayUpdateTexImage() {
        a(this.a);
    }

    public void end() {
        a(0);
    }
}
