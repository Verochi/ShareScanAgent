package com.efs.sdk.base.core.config;

/* loaded from: classes22.dex */
public class GlobalEnvStruct {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String i;
    public android.content.Context mAppContext;
    private com.efs.sdk.base.processor.action.ILogEncryptAction q;
    private boolean c = true;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private java.lang.Boolean g = null;
    private boolean h = false;
    private java.lang.String j = "";
    private java.lang.String k = "";
    private boolean l = false;
    private boolean m = false;
    public long configRefreshDelayMills = 5000;
    private long n = 10000;
    private long o = 10000;
    private java.util.Map<java.lang.String, java.lang.String> p = new java.util.HashMap(5);
    private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.util.List<android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>>>> r = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: s, reason: collision with root package name */
    private java.util.List<com.efs.sdk.base.observer.IEfsReporterObserver> f304s = new java.util.ArrayList(5);

    public void addConfigObserver(com.efs.sdk.base.observer.IEfsReporterObserver iEfsReporterObserver) {
        if (this.f304s.contains(iEfsReporterObserver)) {
            return;
        }
        this.f304s.add(iEfsReporterObserver);
    }

    public void addPublicParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap(this.p);
        hashMap.putAll(map);
        this.p = hashMap;
    }

    public java.lang.String getAppid() {
        return this.a;
    }

    public java.util.List<android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>>> getCallback(int i) {
        return (!this.r.containsKey(java.lang.Integer.valueOf(i)) || this.r.get(java.lang.Integer.valueOf(i)) == null) ? java.util.Collections.emptyList() : this.r.get(java.lang.Integer.valueOf(i));
    }

    public java.util.List<com.efs.sdk.base.observer.IEfsReporterObserver> getEfsReporterObservers() {
        return this.f304s;
    }

    public java.lang.String getLogDid() {
        return this.k;
    }

    public com.efs.sdk.base.processor.action.ILogEncryptAction getLogEncryptAction() {
        return this.q;
    }

    public long getLogSendDelayMills() {
        return this.n;
    }

    public long getLogSendIntervalMills() {
        return this.o;
    }

    public java.lang.String getLogUid() {
        return this.j;
    }

    public java.util.Map<java.lang.String, java.lang.String> getPublicParamMap() {
        java.util.Map<java.lang.String, java.lang.String> map = this.p;
        return map == null ? java.util.Collections.emptyMap() : map;
    }

    public java.lang.String getSecret() {
        return this.b;
    }

    public java.lang.String getUid() {
        return this.i;
    }

    public boolean isDebug() {
        return this.f;
    }

    public boolean isEnablePaBackup() {
        return this.d;
    }

    public boolean isEnableSendLog() {
        return this.e;
    }

    public boolean isEnableWaStat() {
        return this.c;
    }

    public boolean isIntl() {
        return this.m;
    }

    public boolean isOpenCodeLog() {
        return this.l;
    }

    public boolean isPrintLogDetail() {
        return this.h;
    }

    public void registerCallback(int i, android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        java.util.List<android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>>> list = this.r.get(java.lang.Integer.valueOf(i));
        if (list == null) {
            list = new java.util.LinkedList<>();
            this.r.putIfAbsent(java.lang.Integer.valueOf(i), list);
        }
        list.add(valueCallback);
    }

    public void setAppid(java.lang.String str) {
        this.a = str;
    }

    public void setDebug(boolean z) {
        this.f = z;
    }

    public void setEnablePaBackup(boolean z) {
        this.d = z;
    }

    public void setEnableSendLog(boolean z) {
        this.e = z;
    }

    public void setEnableWaStat(boolean z) {
        this.c = z;
    }

    public void setIsIntl(boolean z) {
        this.m = z;
    }

    public void setLogDid(java.lang.String str) {
        this.k = str;
    }

    public void setLogEncryptAction(com.efs.sdk.base.processor.action.ILogEncryptAction iLogEncryptAction) {
        this.q = iLogEncryptAction;
    }

    public void setLogUid(java.lang.String str) {
        this.j = str;
    }

    public void setOpenCodeLog(boolean z) {
        this.l = z;
    }

    public void setPrintLogDetail(boolean z) {
        this.h = z;
    }

    public void setSecret(java.lang.String str) {
        this.b = str;
    }

    public void setUid(java.lang.String str) {
        this.i = str;
    }
}
