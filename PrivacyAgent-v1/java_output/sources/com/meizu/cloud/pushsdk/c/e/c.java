package com.meizu.cloud.pushsdk.c.e;

/* loaded from: classes23.dex */
public final class c {
    public static <T> com.meizu.cloud.pushsdk.c.a.c<T> a(com.meizu.cloud.pushsdk.c.a.b bVar) {
        int g = bVar.g();
        return g != 0 ? g != 1 ? g != 2 ? new com.meizu.cloud.pushsdk.c.a.c<>(new com.meizu.cloud.pushsdk.c.b.a()) : d(bVar) : c(bVar) : b(bVar);
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> b(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            try {
                com.meizu.cloud.pushsdk.c.c.k a = com.meizu.cloud.pushsdk.c.e.a.a(bVar);
                if (a == null) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return cVar;
                }
                if (bVar.f() == com.meizu.cloud.pushsdk.c.a.e.OK_HTTP_RESPONSE) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(a);
                    cVar2.a(a);
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return cVar2;
                }
                if (a.a() >= 400) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(a), bVar, a.a()));
                    cVar3.a(a);
                    com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                    return cVar3;
                }
                com.meizu.cloud.pushsdk.c.a.c<T> a2 = bVar.a(a);
                a2.a(a);
                com.meizu.cloud.pushsdk.c.h.a.a(a, bVar);
                return a2;
            } catch (com.meizu.cloud.pushsdk.c.b.a e) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(e)));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar4;
            } catch (java.lang.Exception e2) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar5;
            }
        } catch (java.lang.Throwable th) {
            com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
            throw th;
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> c(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            com.meizu.cloud.pushsdk.c.c.k b = com.meizu.cloud.pushsdk.c.e.a.b(bVar);
            if (b == null) {
                return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
            }
            if (b.a() >= 400) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(b), bVar, b.a()));
                cVar.a(b);
                return cVar;
            }
            com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>("success");
            cVar2.a(b);
            return cVar2;
        } catch (com.meizu.cloud.pushsdk.c.b.a e) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(e)));
        } catch (java.lang.Exception e2) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> d(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            try {
                com.meizu.cloud.pushsdk.c.c.k c = com.meizu.cloud.pushsdk.c.e.a.c(bVar);
                if (c == null) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
                    com.meizu.cloud.pushsdk.c.h.a.a(c, bVar);
                    return cVar;
                }
                if (bVar.f() == com.meizu.cloud.pushsdk.c.a.e.OK_HTTP_RESPONSE) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(c);
                    cVar2.a(c);
                    com.meizu.cloud.pushsdk.c.h.a.a(c, bVar);
                    return cVar2;
                }
                if (c.a() >= 400) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(c), bVar, c.a()));
                    cVar3.a(c);
                    com.meizu.cloud.pushsdk.c.h.a.a(c, bVar);
                    return cVar3;
                }
                com.meizu.cloud.pushsdk.c.a.c<T> a = bVar.a(c);
                a.a(c);
                com.meizu.cloud.pushsdk.c.h.a.a(c, bVar);
                return a;
            } catch (com.meizu.cloud.pushsdk.c.b.a e) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar4;
            } catch (java.lang.Exception e2) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar5;
            }
        } catch (java.lang.Throwable th) {
            com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
            throw th;
        }
    }
}
