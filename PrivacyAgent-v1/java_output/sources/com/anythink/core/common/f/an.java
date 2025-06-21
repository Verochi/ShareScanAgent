package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class an {
    public int a;
    public java.lang.String b;
    public int c;
    public int d;
    public long e;
    public java.lang.String f;
    public java.lang.String g;
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.an.a> h;

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public int d;
        public int e;
        public long f;

        public final java.lang.String toString() {
            return "AdSourceImpressionInfo{unitId='" + this.a + "', hourTimeFormat='" + this.b + "', dateTimeFormat='" + this.c + "', dayShowCount=" + this.d + ", hourShowCount=" + this.e + ", showTime=" + this.f + '}';
        }
    }

    public final com.anythink.core.common.f.an.a a(java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.an.a> concurrentHashMap = this.h;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.common.f.an.a aVar) {
        if (this.h == null) {
            this.h = new java.util.concurrent.ConcurrentHashMap<>(3);
        }
        this.h.put(str, aVar);
    }

    public final java.lang.String toString() {
        return "PlacementImpressionInfo{format=" + this.a + ", placementId='" + this.b + "', dayShowCount=" + this.c + ", hourShowCount=" + this.d + ", showTime=" + this.e + ", hourTimeFormat='" + this.f + "', dateTimeFormat='" + this.g + "'}";
    }
}
