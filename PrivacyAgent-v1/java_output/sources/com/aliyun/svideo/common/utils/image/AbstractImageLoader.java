package com.aliyun.svideo.common.utils.image;

/* loaded from: classes.dex */
public abstract class AbstractImageLoader {
    public abstract void clear(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.widget.ImageView imageView);

    public abstract <T> void into(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<T> abstractImageLoaderTarget);

    public abstract void into(@androidx.annotation.NonNull android.widget.ImageView imageView);

    public abstract <R> com.aliyun.svideo.common.utils.image.AbstractImageLoader listener(@androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.ImageLoaderRequestListener<R> imageLoaderRequestListener);

    public abstract com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull int i);

    public abstract com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable com.aliyun.svideo.common.utils.image.ImageLoaderOptions imageLoaderOptions);

    public abstract com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str);

    public abstract com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.ImageLoaderOptions imageLoaderOptions);
}
