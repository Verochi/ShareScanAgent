package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public enum l {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD(com.umeng.analytics.pro.bo.aC, 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);

    java.lang.String j;
    int k;

    l(java.lang.String str, int i) {
        this.j = str;
        this.k = i;
    }

    public static com.baidu.mobads.sdk.internal.l b(java.lang.String str) {
        for (com.baidu.mobads.sdk.internal.l lVar : values()) {
            if (lVar != null && android.text.TextUtils.isEmpty(lVar.j) && lVar.j.equals(str)) {
                return lVar;
            }
        }
        return null;
    }

    public java.lang.String b() {
        return this.j;
    }

    public int c() {
        return this.k;
    }
}
