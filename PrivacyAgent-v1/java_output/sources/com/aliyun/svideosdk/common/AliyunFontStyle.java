package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunFontStyle extends com.aliyun.svideosdk.common.AliyunObject {
    private java.lang.String mFontPath;
    private float mFontSize;
    private com.aliyun.svideosdk.common.ISource mFontSource;
    private com.aliyun.svideosdk.common.AliyunTypeface mTypeface;

    public class a implements com.aliyun.svideosdk.common.ISource {
        final /* synthetic */ java.lang.String a;

        public a(java.lang.String str) {
            this.a = str;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getId() {
            return null;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getPath() {
            return this.a;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getURL() {
            return null;
        }
    }

    public class b implements com.aliyun.svideosdk.common.ISource {
        public b() {
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getId() {
            return null;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getPath() {
            return com.aliyun.svideosdk.common.AliyunFontStyle.this.mFontPath;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getURL() {
            return null;
        }
    }

    public class c implements com.aliyun.svideosdk.common.ISource {
        public c() {
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getId() {
            return null;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getPath() {
            return com.aliyun.svideosdk.common.AliyunFontStyle.this.mFontPath;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public java.lang.String getURL() {
            return null;
        }
    }

    public AliyunFontStyle(com.aliyun.svideosdk.common.ISource iSource) {
        this(iSource, 128.0f, com.aliyun.svideosdk.common.AliyunTypeface.NORMAL);
    }

    public AliyunFontStyle(com.aliyun.svideosdk.common.ISource iSource, float f, com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface) {
        this.mFontPath = iSource.getPath();
        this.mFontSource = iSource;
        this.mFontSize = f;
        this.mTypeface = aliyunTypeface;
    }

    public AliyunFontStyle(java.lang.String str, float f, com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface) {
        this(new com.aliyun.svideosdk.common.AliyunFontStyle.a(str), f, aliyunTypeface);
    }

    public java.lang.String getFontPath() {
        return this.mFontPath;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public com.aliyun.svideosdk.common.ISource getFontSource() {
        return (this.mFontSource != null || com.aliyun.common.utils.StringUtils.isEmpty(this.mFontPath)) ? this.mFontSource : new com.aliyun.svideosdk.common.AliyunFontStyle.c();
    }

    public com.aliyun.svideosdk.common.AliyunTypeface getTypeface() {
        return this.mTypeface;
    }

    public void setFontPath(java.lang.String str) {
        this.mFontPath = str;
        this.mFontSource = !com.aliyun.common.utils.StringUtils.isEmpty(str) ? new com.aliyun.svideosdk.common.AliyunFontStyle.b() : null;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public void setFontSource(com.aliyun.svideosdk.common.ISource iSource) {
        if (iSource == null || com.aliyun.common.utils.StringUtils.isEmpty(iSource.getPath())) {
            this.mFontPath = "";
            iSource = null;
        } else {
            this.mFontPath = iSource.getPath();
        }
        this.mFontSource = iSource;
    }

    public void setTypeface(com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface) {
        this.mTypeface = aliyunTypeface;
    }
}
