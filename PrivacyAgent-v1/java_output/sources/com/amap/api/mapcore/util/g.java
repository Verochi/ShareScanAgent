package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class g {
    private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.amap.api.mapcore.util.g.a> a = new java.util.concurrent.ConcurrentHashMap<>();

    public class a<T> {
        public java.util.List<T> a = java.util.Collections.synchronizedList(new java.util.ArrayList());
        public T b = null;

        public a() {
        }
    }

    public final <T> java.util.List<T> a(int i) {
        try {
            com.amap.api.mapcore.util.g.a aVar = this.a.get(java.lang.Integer.valueOf(i));
            if (aVar != null) {
                return aVar.a;
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final <T> void a() {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.amap.api.mapcore.util.g.a> concurrentHashMap = this.a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, com.amap.api.mapcore.util.g.a>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                com.amap.api.mapcore.util.g.a value = it.next().getValue();
                value.a.clear();
                value.b = null;
            }
            this.a.clear();
        } catch (java.lang.Throwable unused) {
        }
    }

    public final <T> void a(int i, T t) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.amap.api.mapcore.util.g.a> concurrentHashMap = this.a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.g.a aVar = concurrentHashMap.get(java.lang.Integer.valueOf(i));
            if (aVar == null) {
                aVar = new com.amap.api.mapcore.util.g.a();
                this.a.putIfAbsent(java.lang.Integer.valueOf(i), aVar);
            }
            if (aVar.b == t) {
                return;
            }
            b(java.lang.Integer.valueOf(i), aVar.b);
            aVar.b = t;
            a(java.lang.Integer.valueOf(i), (java.lang.Integer) t);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final <T> void a(java.lang.Integer num) {
        com.amap.api.mapcore.util.g.a aVar;
        java.util.List<T> list;
        try {
            if (!this.a.containsKey(num) || (aVar = this.a.get(num)) == null || (list = aVar.a) == null) {
                return;
            }
            list.clear();
        } catch (java.lang.Throwable unused) {
        }
    }

    public final <T> void a(java.lang.Integer num, T t) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.amap.api.mapcore.util.g.a> concurrentHashMap;
        if (t == null || (concurrentHashMap = this.a) == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.g.a aVar = concurrentHashMap.get(num);
            if (aVar == null) {
                aVar = new com.amap.api.mapcore.util.g.a();
                this.a.putIfAbsent(num, aVar);
            }
            java.util.List<T> list = aVar.a;
            if (list == null || list.contains(t)) {
                return;
            }
            aVar.a.add(t);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final <T> void b(java.lang.Integer num, T t) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.amap.api.mapcore.util.g.a> concurrentHashMap;
        com.amap.api.mapcore.util.g.a aVar;
        java.util.List<T> list;
        if (t == null || (concurrentHashMap = this.a) == null) {
            return;
        }
        try {
            if (!concurrentHashMap.containsKey(num) || (aVar = this.a.get(num)) == null || (list = aVar.a) == null || !list.contains(t)) {
                return;
            }
            aVar.a.remove(t);
        } catch (java.lang.Throwable unused) {
        }
    }
}
