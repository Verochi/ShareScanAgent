package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectBase {
    private static java.lang.Integer BASE_EFFECT_ID = 8192;
    protected com.aliyun.svideosdk.common.struct.project.Source mSource;
    protected int resId;
    protected int viewId = 0;

    public EffectBase() {
        synchronized (BASE_EFFECT_ID) {
            java.lang.Integer valueOf = java.lang.Integer.valueOf(BASE_EFFECT_ID.intValue() + 1);
            BASE_EFFECT_ID = valueOf;
            this.resId = valueOf.intValue();
        }
    }

    public boolean checkIsInvalid() {
        return false;
    }

    public void copy(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (getSource() != null) {
            com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source();
            source.setId(getSource().getId());
            source.setPath(getSource().getPath());
            source.setURL(getSource().getURL());
            effectBase.mSource = source;
        }
        effectBase.resId = this.resId;
        effectBase.viewId = this.viewId;
    }

    @java.lang.Deprecated
    public java.lang.String getPath() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.mSource;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public int getResId() {
        return this.resId;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public int getViewId() {
        return this.viewId;
    }

    public java.lang.String readString(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("");
        try {
            java.io.FileReader fileReader = new java.io.FileReader(new java.io.File(str));
            while (true) {
                int read = fileReader.read();
                if (read == -1) {
                    break;
                }
                stringBuffer.append((char) read);
            }
            fileReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    @java.lang.Deprecated
    public void setPath(java.lang.String str) {
        this.mSource = new com.aliyun.svideosdk.common.struct.project.Source(str);
    }

    @java.lang.Deprecated
    public void setResId(int i) {
        this.resId = i;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }

    public java.lang.String toString() {
        return "EffectBase{resId=" + this.resId + ", path='" + this.mSource + "', viewId=" + this.viewId + '}';
    }
}
