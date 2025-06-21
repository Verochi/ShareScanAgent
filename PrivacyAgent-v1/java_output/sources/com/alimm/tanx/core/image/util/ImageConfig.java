package com.alimm.tanx.core.image.util;

/* loaded from: classes.dex */
public class ImageConfig implements com.alimm.tanx.core.utils.NotConfused {
    private final android.content.Context context;
    private int errorId;
    private android.graphics.drawable.Drawable errorPlaceholder;
    private com.alimm.tanx.core.image.util.tanxc_do imageConfig;
    private android.graphics.drawable.Drawable placeHolderDrawable;
    private int placeholderId;
    private final int resId;
    private java.lang.String url;

    public static class Builder implements com.alimm.tanx.core.utils.NotConfused {
        private final android.content.Context context;
        private int errorId;
        private android.graphics.drawable.Drawable errorPlaceholder;
        private android.graphics.drawable.Drawable placeHolderDrawable;
        private int placeHolderResId;
        private int radius;
        private int resId;
        private com.alimm.tanx.core.image.util.ScaleMode scaleMode = com.alimm.tanx.core.image.util.ScaleMode.FIT_CENTER;
        private com.alimm.tanx.core.image.util.ShapeMode shapeMode = com.alimm.tanx.core.image.util.ShapeMode.RECT;
        private java.lang.String url;

        public Builder(android.content.Context context) {
            this.context = context;
        }

        public com.alimm.tanx.core.image.util.ImageConfig build() {
            return new com.alimm.tanx.core.image.util.ImageConfig(this);
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder error(int i) {
            this.errorId = i;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder error(android.graphics.drawable.Drawable drawable) {
            this.errorPlaceholder = drawable;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder placeHolder(int i) {
            this.placeHolderResId = i;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder placeHolderDrawable(android.graphics.drawable.Drawable drawable) {
            this.placeHolderDrawable = drawable;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder radius(int i) {
            this.radius = i;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder res(int i) {
            this.resId = i;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder scaleMode(com.alimm.tanx.core.image.util.ScaleMode scaleMode) {
            this.scaleMode = scaleMode;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder shapeMode(com.alimm.tanx.core.image.util.ShapeMode shapeMode) {
            this.shapeMode = shapeMode;
            return this;
        }

        public com.alimm.tanx.core.image.util.ImageConfig.Builder url(java.lang.String str) {
            this.url = str;
            return this;
        }
    }

    public interface GifCallback {
        void onFailure(java.lang.String str);

        void onSuccess();
    }

    public interface ImageBitmapCallback {
        void onFailure(java.lang.String str);

        void onSuccess(android.graphics.Bitmap bitmap);
    }

    public ImageConfig(com.alimm.tanx.core.image.util.ImageConfig.Builder builder) {
        this.context = builder.context;
        this.url = builder.url;
        this.resId = builder.resId;
        this.placeholderId = builder.placeHolderResId;
        this.placeHolderDrawable = builder.placeHolderDrawable;
        this.errorId = builder.errorId;
        this.errorPlaceholder = builder.errorPlaceholder;
        this.imageConfig = new com.alimm.tanx.core.image.util.tanxc_do(builder.scaleMode, builder.shapeMode, builder.radius);
    }

    public void error(int i) {
        this.errorId = i;
    }

    public void error(android.graphics.drawable.Drawable drawable) {
        this.errorPlaceholder = drawable;
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public int getErrorId() {
        return this.errorId;
    }

    public android.graphics.drawable.Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public com.alimm.tanx.core.image.util.tanxc_do getImageConfig() {
        return this.imageConfig;
    }

    public android.graphics.drawable.Drawable getPlaceHolderDrawable() {
        return this.placeHolderDrawable;
    }

    public int getPlaceHolderId() {
        return this.placeholderId;
    }

    public int getResId() {
        return this.resId;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setImageConfig(com.alimm.tanx.core.image.util.tanxc_do tanxc_doVar) {
        this.imageConfig = tanxc_doVar;
    }

    public void setPlaceHolder(int i) {
        this.placeholderId = i;
    }

    public void setPlaceHolder(android.graphics.drawable.Drawable drawable) {
        this.placeHolderDrawable = drawable;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }
}
