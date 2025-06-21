package com.otaliastudios.opengl.program;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/otaliastudios/opengl/program/GlFlatProgram;", "Lcom/otaliastudios/opengl/program/GlNativeFlatProgram;", "()V", "setColor", "", "color", "", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlFlatProgram extends com.otaliastudios.opengl.program.GlNativeFlatProgram {
    public final void setColor(@androidx.annotation.ColorInt int color) {
        setColor(new float[]{android.graphics.Color.red(color) / 255.0f, android.graphics.Color.green(color) / 255.0f, android.graphics.Color.blue(color) / 255.0f, android.graphics.Color.alpha(color) / 255.0f});
    }
}
