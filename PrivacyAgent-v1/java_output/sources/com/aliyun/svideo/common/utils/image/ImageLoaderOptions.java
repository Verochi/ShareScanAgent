package com.aliyun.svideo.common.utils.image;

/* loaded from: classes.dex */
public class ImageLoaderOptions {
    private int mErrorDrawableId;
    private android.graphics.drawable.Drawable mHolderDrawable;
    private int mHolderDrawableId;
    private boolean mIsAsBitmap;
    private boolean mIsCenterCrop;
    private boolean mIsCircle;
    private boolean mIsCrossFade;
    private boolean mIsRoundCorner;
    private boolean mIsSkipDiskCacheCache;
    private boolean mIsSkipMemoryCache;
    private android.graphics.Point mOverridePoint;
    private float mThumbnail;

    public static final class Builder {
        private final com.aliyun.svideo.common.utils.image.ImageLoaderOptions mLoaderOptions = new com.aliyun.svideo.common.utils.image.ImageLoaderOptions(null);

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder asBitmap() {
            this.mLoaderOptions.mIsAsBitmap = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions build() {
            return this.mLoaderOptions;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder centerCrop() {
            this.mLoaderOptions.mIsCenterCrop = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder circle() {
            this.mLoaderOptions.mIsCircle = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder crossFade() {
            this.mLoaderOptions.mIsCrossFade = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder error(@androidx.annotation.DrawableRes int i) {
            this.mLoaderOptions.mErrorDrawableId = i;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder override(int i, int i2) {
            this.mLoaderOptions.mOverridePoint.x = i;
            this.mLoaderOptions.mOverridePoint.y = i2;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder placeholder(@androidx.annotation.DrawableRes int i) {
            this.mLoaderOptions.mHolderDrawableId = i;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder placeholder(android.graphics.drawable.Drawable drawable) {
            this.mLoaderOptions.mHolderDrawable = drawable;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder roundCorner() {
            this.mLoaderOptions.mIsRoundCorner = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder skipDiskCacheCache() {
            this.mLoaderOptions.mIsSkipDiskCacheCache = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder skipMemoryCache() {
            this.mLoaderOptions.mIsSkipMemoryCache = true;
            return this;
        }

        public com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder thumbnail(float f) {
            this.mLoaderOptions.mThumbnail = f;
            return this;
        }
    }

    private ImageLoaderOptions() {
        this.mHolderDrawableId = -1;
        this.mErrorDrawableId = -1;
        this.mIsAsBitmap = false;
        this.mIsCrossFade = false;
        this.mThumbnail = 1.0f;
        this.mIsCenterCrop = false;
        this.mIsSkipMemoryCache = false;
        this.mIsSkipDiskCacheCache = false;
        this.mIsCircle = false;
        this.mOverridePoint = new android.graphics.Point();
        this.mIsRoundCorner = false;
    }

    public /* synthetic */ ImageLoaderOptions(defpackage.nr0 nr0Var) {
        this();
    }

    public int getErrorDrawableId() {
        return this.mErrorDrawableId;
    }

    public android.graphics.drawable.Drawable getHolderDrawable() {
        return this.mHolderDrawable;
    }

    public int getHolderDrawableId() {
        return this.mHolderDrawableId;
    }

    public android.graphics.Point getOverridePoint() {
        return this.mOverridePoint;
    }

    public float getThumbnail() {
        return this.mThumbnail;
    }

    public boolean isAsBitmap() {
        return this.mIsAsBitmap;
    }

    public boolean isCenterCrop() {
        return this.mIsCenterCrop;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public boolean isCrossFade() {
        return this.mIsCrossFade;
    }

    public boolean isRoundCorner() {
        return this.mIsRoundCorner;
    }

    public boolean isSkipDiskCacheCache() {
        return this.mIsSkipDiskCacheCache;
    }

    public boolean isSkipMemoryCache() {
        return this.mIsSkipMemoryCache;
    }
}
