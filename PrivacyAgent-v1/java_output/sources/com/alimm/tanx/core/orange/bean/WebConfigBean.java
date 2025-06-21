package com.alimm.tanx.core.orange.bean;

/* loaded from: classes.dex */
public class WebConfigBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public java.lang.String key;
    public boolean closeInitWebPreload = false;
    public boolean closeNextWebPreload = false;
    public long sdkInitWebViewPreloadDelayed = 0;

    public java.lang.String toString() {
        return "WebConfigBean{key='" + this.key + "', closeInitWebPreload=" + this.closeInitWebPreload + ", closeNextWebPreload=" + this.closeNextWebPreload + ", sdkInitWebViewPreloadDelayed=" + this.sdkInitWebViewPreloadDelayed + "} ";
    }
}
