package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public interface cc<T extends com.umeng.analytics.pro.cc<?, ?>, F extends com.umeng.analytics.pro.cj> extends java.io.Serializable {
    void clear();

    com.umeng.analytics.pro.cc<T, F> deepCopy();

    F fieldForId(int i);

    void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci;

    void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci;
}
