package com.bumptech.glide.request.target;

@java.lang.Deprecated
/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends com.bumptech.glide.request.target.BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        if (com.bumptech.glide.util.Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        throw new java.lang.IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
    }
}
