package com.bumptech.glide;

/* loaded from: classes.dex */
interface ModelTypes<T> {
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable android.graphics.Bitmap bitmap);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable android.net.Uri uri);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable java.io.File file);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable @androidx.annotation.DrawableRes @androidx.annotation.RawRes java.lang.Integer num);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable java.lang.Object obj);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable java.lang.String str);

    @androidx.annotation.CheckResult
    @java.lang.Deprecated
    T load(@androidx.annotation.Nullable java.net.URL url);

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    T load(@androidx.annotation.Nullable byte[] bArr);
}
