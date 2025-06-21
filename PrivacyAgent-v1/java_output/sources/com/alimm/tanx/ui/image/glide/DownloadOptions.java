package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
interface DownloadOptions {
    com.alimm.tanx.ui.image.glide.request.FutureTarget<java.io.File> downloadOnly(int i, int i2);

    <Y extends com.alimm.tanx.ui.image.glide.request.target.Target<java.io.File>> Y downloadOnly(Y y);
}
