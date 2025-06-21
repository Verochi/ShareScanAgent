package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class ATInitConfig {
    protected com.anythink.core.api.ATInitMediation initMediation;
    protected java.util.Map<java.lang.String, java.lang.Object> paramMap = new java.util.HashMap(4);

    public final com.anythink.core.api.ATInitMediation getInitMediation() {
        return this.initMediation;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> getRequestParamMap() {
        return this.paramMap;
    }
}
