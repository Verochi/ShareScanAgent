package com.chad.library.adapter.base;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/util/SparseArray;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class BaseProviderMultiAdapter$mItemProviders$2<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<android.util.SparseArray<com.chad.library.adapter.base.provider.BaseItemProvider<T>>> {
    public static final com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2 INSTANCE = new com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2();

    public BaseProviderMultiAdapter$mItemProviders$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final android.util.SparseArray<com.chad.library.adapter.base.provider.BaseItemProvider<T>> invoke() {
        return new android.util.SparseArray<>();
    }
}
