package com.bytedance.sdk.openadsdk;

/* loaded from: classes31.dex */
public class CSJConfig implements com.bytedance.sdk.openadsdk.AdConfig {
    private boolean bt;
    private int cp;
    private int d;
    private boolean es;
    private int kz;
    private boolean o;
    private boolean t;
    private int u;
    private java.lang.String v;
    private com.bytedance.sdk.openadsdk.TTCustomController vl;
    private java.lang.String vw;
    private java.lang.String wg;
    private int[] x;
    private java.lang.String yl;
    private java.util.Map<java.lang.String, java.lang.Object> z;

    /* loaded from: classes22.dex */
    public static class vw {
        private java.lang.String v;
        private int vl;
        private java.lang.String vw;
        private java.lang.String wg;
        private int[] x;
        private java.lang.String yl;
        private com.bytedance.sdk.openadsdk.TTCustomController z;
        private boolean t = false;
        private int kz = 0;
        private boolean bt = true;
        private boolean o = false;
        private boolean es = false;
        private int u = 2;
        private int cp = 0;
        private java.util.Map<java.lang.String, java.lang.Object> d = null;

        public com.bytedance.sdk.openadsdk.CSJConfig.vw t(int i) {
            this.u = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw t(java.lang.String str) {
            this.v = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw t(boolean z) {
            this.o = z;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw v(int i) {
            this.cp = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw v(java.lang.String str) {
            this.yl = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw v(boolean z) {
            this.es = z;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw vw(int i) {
            this.kz = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw vw(com.bytedance.sdk.openadsdk.TTCustomController tTCustomController) {
            this.z = tTCustomController;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw vw(java.lang.String str) {
            this.vw = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw vw(java.lang.String str, java.lang.Object obj) {
            if (this.d == null) {
                this.d = new java.util.HashMap();
            }
            this.d.put(str, obj);
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw vw(boolean z) {
            this.t = z;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw vw(int... iArr) {
            this.x = iArr;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw wg(int i) {
            this.vl = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw wg(java.lang.String str) {
            this.wg = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.CSJConfig.vw wg(boolean z) {
            this.bt = z;
            return this;
        }
    }

    public CSJConfig(com.bytedance.sdk.openadsdk.CSJConfig.vw vwVar) {
        this.t = false;
        this.kz = 0;
        this.bt = true;
        this.o = false;
        this.es = false;
        this.vw = vwVar.vw;
        this.wg = vwVar.wg;
        this.t = vwVar.t;
        this.v = vwVar.v;
        this.yl = vwVar.yl;
        this.kz = vwVar.kz;
        this.bt = vwVar.bt;
        this.o = vwVar.o;
        this.x = vwVar.x;
        this.es = vwVar.es;
        this.vl = vwVar.z;
        this.u = vwVar.vl;
        this.d = vwVar.cp;
        this.cp = vwVar.u;
        this.z = vwVar.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public java.lang.String getAppId() {
        return this.vw;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public java.lang.String getAppName() {
        return this.wg;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public com.bytedance.sdk.openadsdk.TTCustomController getCustomController() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public java.lang.String getData() {
        return this.yl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public java.lang.Object getExtra(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Object> map = this.z;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public java.util.Map<java.lang.String, java.lang.Object> getInitExtra() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public java.lang.String getKeywords() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.cp;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.kz;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.bt;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.es;
    }

    public void setAgeGroup(int i) {
        this.d = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.bt = z;
    }

    public void setAppId(java.lang.String str) {
        this.vw = str;
    }

    public void setAppName(java.lang.String str) {
        this.wg = str;
    }

    public void setCustomController(com.bytedance.sdk.openadsdk.TTCustomController tTCustomController) {
        this.vl = tTCustomController;
    }

    public void setData(java.lang.String str) {
        this.yl = str;
    }

    public void setDebug(boolean z) {
        this.o = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.x = iArr;
    }

    public void setKeywords(java.lang.String str) {
        this.v = str;
    }

    public void setPaid(boolean z) {
        this.t = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.es = z;
    }

    public void setThemeStatus(int i) {
        this.u = i;
    }

    public void setTitleBarTheme(int i) {
        this.kz = i;
    }
}
