package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class cd {
    public int a;
    public int b;
    public int c;
    private boolean d;

    public final void a() {
        int i = this.a;
        if (i >= 0) {
            android.opengl.GLES20.glDeleteProgram(i);
        }
        int i2 = this.b;
        if (i2 >= 0) {
            android.opengl.GLES20.glDeleteShader(i2);
        }
        int i3 = this.c;
        if (i3 >= 0) {
            android.opengl.GLES20.glDeleteShader(i3);
        }
        this.d = true;
    }
}
