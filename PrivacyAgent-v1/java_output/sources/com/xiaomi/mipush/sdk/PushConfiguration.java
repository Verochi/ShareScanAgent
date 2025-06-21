package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class PushConfiguration {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private com.xiaomi.push.service.a.a mRegion;

    public static class PushConfigurationBuilder {
        private boolean mGeoEnable;
        private boolean mOpenCOSPush;
        private boolean mOpenFCMPush;
        private boolean mOpenFTOSPush;
        private boolean mOpenHmsPush;
        private com.xiaomi.push.service.a.a mRegion;

        public com.xiaomi.mipush.sdk.PushConfiguration build() {
            return new com.xiaomi.mipush.sdk.PushConfiguration(this, null);
        }

        public com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder openCOSPush(boolean z) {
            this.mOpenCOSPush = z;
            return this;
        }

        public com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder openFCMPush(boolean z) {
            this.mOpenFCMPush = z;
            return this;
        }

        public com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder openFTOSPush(boolean z) {
            this.mOpenFTOSPush = z;
            return this;
        }

        public com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder openHmsPush(boolean z) {
            this.mOpenHmsPush = z;
            return this;
        }

        public com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder region(com.xiaomi.push.service.a.a aVar) {
            this.mRegion = aVar;
            return this;
        }
    }

    public PushConfiguration() {
        this.mRegion = com.xiaomi.push.service.a.a.China;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    private PushConfiguration(com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder pushConfigurationBuilder) {
        this.mRegion = pushConfigurationBuilder.mRegion == null ? com.xiaomi.push.service.a.a.China : pushConfigurationBuilder.mRegion;
        this.mOpenHmsPush = pushConfigurationBuilder.mOpenHmsPush;
        this.mOpenFCMPush = pushConfigurationBuilder.mOpenFCMPush;
        this.mOpenCOSPush = pushConfigurationBuilder.mOpenCOSPush;
        this.mOpenFTOSPush = pushConfigurationBuilder.mOpenFTOSPush;
    }

    public /* synthetic */ PushConfiguration(com.xiaomi.mipush.sdk.PushConfiguration.PushConfigurationBuilder pushConfigurationBuilder, com.xiaomi.mipush.sdk.ah ahVar) {
        this(pushConfigurationBuilder);
    }

    public boolean getOpenCOSPush() {
        return this.mOpenCOSPush;
    }

    public boolean getOpenFCMPush() {
        return this.mOpenFCMPush;
    }

    public boolean getOpenFTOSPush() {
        return this.mOpenFTOSPush;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public com.xiaomi.push.service.a.a getRegion() {
        return this.mRegion;
    }

    public void setOpenCOSPush(boolean z) {
        this.mOpenCOSPush = z;
    }

    public void setOpenFCMPush(boolean z) {
        this.mOpenFCMPush = z;
    }

    public void setOpenFTOSPush(boolean z) {
        this.mOpenFTOSPush = z;
    }

    public void setOpenHmsPush(boolean z) {
        this.mOpenHmsPush = z;
    }

    public void setRegion(com.xiaomi.push.service.a.a aVar) {
        this.mRegion = aVar;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        com.xiaomi.push.service.a.a aVar = this.mRegion;
        stringBuffer.append(aVar == null ? com.igexin.push.core.b.m : aVar.name());
        stringBuffer.append(",mOpenHmsPush:" + this.mOpenHmsPush);
        stringBuffer.append(",mOpenFCMPush:" + this.mOpenFCMPush);
        stringBuffer.append(",mOpenCOSPush:" + this.mOpenCOSPush);
        stringBuffer.append(",mOpenFTOSPush:" + this.mOpenFTOSPush);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
