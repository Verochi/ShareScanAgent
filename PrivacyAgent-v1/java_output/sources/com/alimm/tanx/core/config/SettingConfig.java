package com.alimm.tanx.core.config;

/* loaded from: classes.dex */
public class SettingConfig implements java.io.Serializable {

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    private static final int MAX_TITLE_SIZE = 28;

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    private static final int MIN_TITLE_SIZE = 5;
    private java.lang.String TAG = "SettingConfig";
    private boolean nightSwitch = false;
    private boolean customTitleSizeSwitch = false;
    private boolean customTextSizeDpSwitch = true;
    private int customTitleSize = -1;

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    public void clearTitleSize() {
        com.alimm.tanx.core.utils.LogUtils.d(this.TAG, "clearTitleSize：");
        this.customTitleSizeSwitch = false;
        this.customTextSizeDpSwitch = true;
        this.customTitleSize = -1;
    }

    public int getCustomTitleSize() {
        return this.customTitleSize;
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    @java.lang.Deprecated
    public com.alimm.tanx.core.config.SettingConfig getNightConfig() {
        return this;
    }

    public boolean isCustomTextSizeDpSwitch() {
        return this.customTextSizeDpSwitch;
    }

    public boolean isCustomTitleSizeSwitch() {
        com.alimm.tanx.core.utils.LogUtils.d(this.TAG, "isCustomTitleSizeSwitch：" + this.customTitleSizeSwitch);
        return this.customTitleSizeSwitch;
    }

    public boolean isNightSwitch() {
        return this.nightSwitch;
    }

    public void setCustomTextSizeDpSwitch(boolean z) {
        this.customTextSizeDpSwitch = z;
    }

    public void setCustomTitleSize(int i) {
        this.customTitleSize = i;
    }

    public void setCustomTitleSizeSwitch(boolean z) {
        this.customTitleSizeSwitch = z;
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    @java.lang.Deprecated
    public com.alimm.tanx.core.config.SettingConfig setDefaultConfig() {
        return setDefaultConfig("", "");
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    @java.lang.Deprecated
    public com.alimm.tanx.core.config.SettingConfig setDefaultConfig(java.lang.String str, java.lang.String str2) {
        return this;
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    @java.lang.Deprecated
    public com.alimm.tanx.core.config.SettingConfig setNightConfig() {
        return setNightConfig("", "");
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    @java.lang.Deprecated
    public com.alimm.tanx.core.config.SettingConfig setNightConfig(java.lang.String str, java.lang.String str2) {
        return this;
    }

    public void setNightSwitch(boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(this.TAG, "setNightSwitch：");
        this.nightSwitch = z;
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    public void setTitleSize(int i) {
        com.alimm.tanx.core.utils.LogUtils.d(this.TAG, "setTitleSize：" + i);
        this.customTitleSizeSwitch = true;
        this.customTextSizeDpSwitch = false;
        this.customTitleSize = i;
        if (i < 5) {
            this.customTitleSize = 5;
        } else if (i > 28) {
            this.customTitleSize = 28;
        }
    }

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    public void setTitleSizeDp(int i) {
        com.alimm.tanx.core.utils.LogUtils.d(this.TAG, "setTitleSizeDp：" + i);
        this.customTitleSizeSwitch = true;
        this.customTextSizeDpSwitch = true;
        this.customTitleSize = i;
        if (i < 5) {
            this.customTitleSize = 5;
        } else if (i > 28) {
            this.customTitleSize = 28;
        }
    }
}
