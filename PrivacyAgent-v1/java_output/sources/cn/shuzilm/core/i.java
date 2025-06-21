package cn.shuzilm.core;

/* loaded from: classes.dex */
class i implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ cn.shuzilm.core.Listener b;

    public i(android.content.Context context, cn.shuzilm.core.Listener listener) {
        this.a = context;
        this.b = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.shuzilm.core.dl.ia(this.a);
        if (this.b != null) {
            java.lang.String c = cn.shuzilm.core.DUHelper.c(this.a, 301, (java.lang.String) null);
            if (c == null) {
                this.b.handler("");
            } else {
                try {
                    c = c.replace('+', '-').replace('/', '_').replace(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, "");
                } catch (java.lang.Exception unused) {
                }
                this.b.handler(c);
            }
        }
    }
}
