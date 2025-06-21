package com.bumptech.glide.load.engine.prefill;

/* loaded from: classes.dex */
public final class PreFillType {

    @androidx.annotation.VisibleForTesting
    static final android.graphics.Bitmap.Config DEFAULT_CONFIG = android.graphics.Bitmap.Config.RGB_565;
    private final android.graphics.Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private android.graphics.Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i) {
            this(i, i);
        }

        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("Width must be > 0");
            }
            if (i2 <= 0) {
                throw new java.lang.IllegalArgumentException("Height must be > 0");
            }
            this.width = i;
            this.height = i2;
        }

        public com.bumptech.glide.load.engine.prefill.PreFillType build() {
            return new com.bumptech.glide.load.engine.prefill.PreFillType(this.width, this.height, this.config, this.weight);
        }

        public android.graphics.Bitmap.Config getConfig() {
            return this.config;
        }

        public com.bumptech.glide.load.engine.prefill.PreFillType.Builder setConfig(@androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public com.bumptech.glide.load.engine.prefill.PreFillType.Builder setWeight(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("Weight must be > 0");
            }
            this.weight = i;
            return this;
        }
    }

    public PreFillType(int i, int i2, android.graphics.Bitmap.Config config, int i3) {
        this.config = (android.graphics.Bitmap.Config) com.bumptech.glide.util.Preconditions.checkNotNull(config, "Config must not be null");
        this.width = i;
        this.height = i2;
        this.weight = i3;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.load.engine.prefill.PreFillType)) {
            return false;
        }
        com.bumptech.glide.load.engine.prefill.PreFillType preFillType = (com.bumptech.glide.load.engine.prefill.PreFillType) obj;
        return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
    }

    public android.graphics.Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public java.lang.String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }
}
