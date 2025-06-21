package com.hbzhou.open.flowcamera;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/hbzhou/open/flowcamera/CompareSizesByArea;", "Ljava/util/Comparator;", "Landroid/util/Size;", "Lkotlin/Comparator;", "()V", "compare", "", "lhs", "rhs", "MJCameraModule_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class CompareSizesByArea implements java.util.Comparator<android.util.Size> {
    @Override // java.util.Comparator
    public int compare(@org.jetbrains.annotations.NotNull android.util.Size lhs, @org.jetbrains.annotations.NotNull android.util.Size rhs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lhs, "lhs");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rhs, "rhs");
        return java.lang.Long.signum((lhs.getWidth() * lhs.getHeight()) - (rhs.getWidth() * rhs.getHeight()));
    }
}
