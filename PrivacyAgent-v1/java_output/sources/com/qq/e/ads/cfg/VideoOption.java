package com.qq.e.ads.cfg;

/* loaded from: classes19.dex */
public class VideoOption {
    private final boolean a;
    private final int b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {
        private boolean a = true;
        private int b = 1;
        private boolean c = true;
        private boolean d = true;
        private boolean e = true;
        private boolean f = false;
        private boolean g = false;
        private int h;
        private int i;

        public com.qq.e.ads.cfg.VideoOption build() {
            return new com.qq.e.ads.cfg.VideoOption(this, null);
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setAutoPlayMuted(boolean z) {
            this.a = z;
            return this;
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                com.qq.e.comm.util.GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
                i = 1;
            }
            this.b = i;
            return this;
        }

        @java.lang.Deprecated
        public com.qq.e.ads.cfg.VideoOption.Builder setDetailPageMuted(boolean z) {
            this.g = z;
            return this;
        }

        @java.lang.Deprecated
        public com.qq.e.ads.cfg.VideoOption.Builder setEnableDetailPage(boolean z) {
            this.e = z;
            return this;
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setEnableUserControl(boolean z) {
            this.f = z;
            return this;
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setMaxVideoDuration(int i) {
            this.h = i;
            return this;
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setMinVideoDuration(int i) {
            this.i = i;
            return this;
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setNeedCoverImage(boolean z) {
            this.d = z;
            return this;
        }

        public com.qq.e.ads.cfg.VideoOption.Builder setNeedProgressBar(boolean z) {
            this.c = z;
            return this;
        }
    }

    private VideoOption(com.qq.e.ads.cfg.VideoOption.Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    public /* synthetic */ VideoOption(com.qq.e.ads.cfg.VideoOption.Builder builder, com.qq.e.ads.cfg.VideoOption.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.a;
    }

    public int getAutoPlayPolicy() {
        return this.b;
    }

    public int getMaxVideoDuration() {
        return this.h;
    }

    public int getMinVideoDuration() {
        return this.i;
    }

    public org.json.JSONObject getOptions() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", java.lang.Boolean.valueOf(this.a));
            jSONObject.putOpt("autoPlayPolicy", java.lang.Integer.valueOf(this.b));
            jSONObject.putOpt("detailPageMuted", java.lang.Boolean.valueOf(this.g));
        } catch (java.lang.Exception e) {
            com.qq.e.comm.util.GDTLogger.d("Get video options error: " + e.getMessage());
        }
        return jSONObject;
    }

    @java.lang.Deprecated
    public boolean isDetailPageMuted() {
        return this.g;
    }

    @java.lang.Deprecated
    public boolean isEnableDetailPage() {
        return this.e;
    }

    public boolean isEnableUserControl() {
        return this.f;
    }

    public boolean isNeedCoverImage() {
        return this.d;
    }

    public boolean isNeedProgressBar() {
        return this.c;
    }
}
