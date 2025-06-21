package com.meizu.cloud.pushsdk.d.c;

/* loaded from: classes23.dex */
public class a {
    private final java.util.List<com.meizu.cloud.pushsdk.d.a.b> a;
    private final long b;
    private final java.lang.String c;

    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0425a<T extends com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a<T>> {
        private java.util.List<com.meizu.cloud.pushsdk.d.a.b> a = new java.util.LinkedList();
        private long b = java.lang.System.currentTimeMillis();
        private java.lang.String c = com.meizu.cloud.pushsdk.d.f.e.b();

        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    public a(com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a<?> abstractC0425a) {
        com.meizu.cloud.pushsdk.d.f.d.a(((com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a) abstractC0425a).a);
        com.meizu.cloud.pushsdk.d.f.d.a(((com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a) abstractC0425a).c);
        com.meizu.cloud.pushsdk.d.f.d.a(!((com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a) abstractC0425a).c.isEmpty(), "eventId cannot be empty");
        this.a = ((com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a) abstractC0425a).a;
        this.b = ((com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a) abstractC0425a).b;
        this.c = ((com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a) abstractC0425a).c;
    }

    public com.meizu.cloud.pushsdk.d.a.c a(com.meizu.cloud.pushsdk.d.a.c cVar) {
        cVar.a(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", java.lang.Long.toString(b()));
        return cVar;
    }

    public java.util.List<com.meizu.cloud.pushsdk.d.a.b> a() {
        return new java.util.ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public java.lang.String c() {
        return this.c;
    }
}
