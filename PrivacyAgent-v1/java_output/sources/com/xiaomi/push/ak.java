package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ak {
    private java.util.LinkedList<com.xiaomi.push.ak.a> a = new java.util.LinkedList<>();

    public static class a {
        private static final com.xiaomi.push.ak d = new com.xiaomi.push.ak();
        public int a = 0;
        public java.lang.String b;
        public java.lang.Object c;

        public a(java.lang.Object obj) {
            this.c = obj;
        }
    }

    public final synchronized int a() {
        return this.a.size();
    }

    public final synchronized void a(java.lang.Object obj) {
        this.a.add(new com.xiaomi.push.ak.a(obj));
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    public final synchronized java.util.LinkedList<com.xiaomi.push.ak.a> b() {
        java.util.LinkedList<com.xiaomi.push.ak.a> linkedList;
        linkedList = this.a;
        this.a = new java.util.LinkedList<>();
        return linkedList;
    }
}
