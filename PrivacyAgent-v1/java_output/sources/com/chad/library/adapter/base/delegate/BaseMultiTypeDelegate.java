package com.chad.library.adapter.base.delegate;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\b\u0001\u0010\u000b\u001a\u00020\n\"\u00020\u0005J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "data", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "getItemType", "viewType", "getLayoutId", "", "layoutResIds", "addItemTypeAutoIncrease", "type", "layoutResId", "addItemType", "", "b", "", "mode", "a", "Landroid/util/SparseIntArray;", "Landroid/util/SparseIntArray;", "layouts", "Z", "autoMode", "c", "selfMode", "<init>", "(Landroid/util/SparseIntArray;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseMultiTypeDelegate<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public android.util.SparseIntArray layouts;

    /* renamed from: b, reason: from kotlin metadata */
    public boolean autoMode;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean selfMode;

    public BaseMultiTypeDelegate() {
        this(null, 1, null);
    }

    public BaseMultiTypeDelegate(@org.jetbrains.annotations.NotNull android.util.SparseIntArray layouts) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(layouts, "layouts");
        this.layouts = layouts;
    }

    public /* synthetic */ BaseMultiTypeDelegate(android.util.SparseIntArray sparseIntArray, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new android.util.SparseIntArray() : sparseIntArray);
    }

    public final void a(boolean mode) {
        if (!(!mode)) {
            throw new java.lang.IllegalArgumentException("Don't mess two register mode".toString());
        }
    }

    @org.jetbrains.annotations.NotNull
    public final com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> addItemType(int type, @androidx.annotation.LayoutRes int layoutResId) {
        this.selfMode = true;
        a(this.autoMode);
        b(type, layoutResId);
        return this;
    }

    @org.jetbrains.annotations.NotNull
    public final com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate<T> addItemTypeAutoIncrease(@androidx.annotation.LayoutRes @org.jetbrains.annotations.NotNull int... layoutResIds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(layoutResIds, "layoutResIds");
        this.autoMode = true;
        a(this.selfMode);
        int length = layoutResIds.length;
        for (int i = 0; i < length; i++) {
            b(i, layoutResIds[i]);
        }
        return this;
    }

    public final void b(int type, @androidx.annotation.LayoutRes int layoutResId) {
        this.layouts.put(type, layoutResId);
    }

    public abstract int getItemType(@org.jetbrains.annotations.NotNull java.util.List<? extends T> data, int position);

    public final int getLayoutId(int viewType) {
        int i = this.layouts.get(viewType);
        if (i != 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(("ViewType: " + viewType + " found layoutResId，please use registerItemType() first!").toString());
    }
}
