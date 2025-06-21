package com.alimm.tanx.core.net.callback;

/* loaded from: classes.dex */
public interface NetWorkCallBack<T> {
    void error(int i, java.lang.String str, java.lang.String str2);

    void succ(T t);
}
