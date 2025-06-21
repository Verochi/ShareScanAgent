package com.anythink.basead.e;

/* loaded from: classes12.dex */
public class b {
    public static final java.lang.String a = "b";
    private java.util.Map<java.lang.String, com.anythink.basead.e.b.InterfaceC0141b> b;

    public static class a {
        private static final com.anythink.basead.e.b a = new com.anythink.basead.e.b((byte) 0);

        private a() {
        }
    }

    /* renamed from: com.anythink.basead.e.b$b, reason: collision with other inner class name */
    public interface InterfaceC0141b extends java.io.Serializable {
        void a();

        void a(com.anythink.basead.c.e eVar);

        void a(com.anythink.basead.e.i iVar);

        void a(boolean z);

        void b();

        void b(com.anythink.basead.e.i iVar);

        void c();

        void d();
    }

    private b() {
        this.b = new java.util.HashMap(2);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.anythink.basead.e.b a() {
        return com.anythink.basead.e.b.a.a;
    }

    public final com.anythink.basead.e.b.InterfaceC0141b a(java.lang.String str) {
        return this.b.get(str);
    }

    public final void a(java.lang.String str, com.anythink.basead.e.b.InterfaceC0141b interfaceC0141b) {
        this.b.put(str, interfaceC0141b);
    }

    public final void b(java.lang.String str) {
        this.b.remove(str);
    }
}
