package com.anythink.basead.a.b;

/* loaded from: classes12.dex */
class d {
    public static final java.lang.String a = "d";
    private static volatile com.anythink.basead.a.b.d b;
    private java.util.List<com.anythink.basead.a.b.d.a> c = new java.util.concurrent.CopyOnWriteArrayList();

    public interface a {
        void a(java.lang.String str, int i);

        void a(java.lang.String str, com.anythink.basead.c.e eVar);
    }

    private d() {
    }

    public static com.anythink.basead.a.b.d a() {
        if (b == null) {
            synchronized (com.anythink.basead.a.b.d.class) {
                if (b == null) {
                    b = new com.anythink.basead.a.b.d();
                }
            }
        }
        return b;
    }

    public final synchronized void a(com.anythink.basead.a.b.d.a aVar) {
        this.c.add(aVar);
    }

    public final void a(java.lang.String str, int i) {
        java.util.List<com.anythink.basead.a.b.d.a> list = this.c;
        if (list != null) {
            java.util.Iterator<com.anythink.basead.a.b.d.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(str, i);
            }
        }
    }

    public final void a(java.lang.String str, com.anythink.basead.c.e eVar) {
        java.util.List<com.anythink.basead.a.b.d.a> list = this.c;
        if (list != null) {
            java.util.Iterator<com.anythink.basead.a.b.d.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(str, eVar);
            }
        }
    }

    public final synchronized void b(com.anythink.basead.a.b.d.a aVar) {
        int size = this.c.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (aVar == this.c.get(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.c.remove(i);
        }
    }
}
