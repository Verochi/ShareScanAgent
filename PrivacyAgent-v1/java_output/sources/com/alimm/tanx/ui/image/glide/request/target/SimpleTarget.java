package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends com.alimm.tanx.ui.image.glide.request.target.BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public final void getSize(com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        if (com.alimm.tanx.ui.image.glide.util.Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        tanxu_do2.append(this.width);
        tanxu_do2.append(" and height: ");
        tanxu_do2.append(this.height);
        tanxu_do2.append(", either provide dimensions in the constructor");
        tanxu_do2.append(" or call override()");
        throw new java.lang.IllegalArgumentException(tanxu_do2.toString());
    }
}
