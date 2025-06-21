package com.alimm.tanx.ui.image.glide.load.resource.drawable;

/* loaded from: classes.dex */
public abstract class GlideDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;

    public abstract boolean isAnimated();

    public abstract void setLoopCount(int i);
}
