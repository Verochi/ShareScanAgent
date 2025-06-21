package com.amap.api.col.s;

/* loaded from: classes12.dex */
abstract class as<T, V> extends com.amap.api.col.s.b<T, V> {
    public as(android.content.Context context, T t) {
        super(context, t);
    }

    public final T c_() {
        return this.b;
    }

    @Override // com.amap.api.col.s.dd
    public java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/weather/weatherInfo?";
    }
}
