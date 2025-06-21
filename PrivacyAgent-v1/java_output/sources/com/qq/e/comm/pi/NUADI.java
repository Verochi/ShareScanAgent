package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface NUADI {
    java.lang.String getAdNetWorkName();

    void loadData(int i);

    void loadData(int i, com.qq.e.comm.constants.LoadAdParams loadAdParams);

    void setCategories(java.util.List<java.lang.String> list);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVastClassName(java.lang.String str);
}
