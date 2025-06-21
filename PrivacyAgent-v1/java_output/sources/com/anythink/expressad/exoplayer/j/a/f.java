package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public final class f {
    public static final int a = 131072;

    public static class a {
        public volatile long a;
        public volatile long b;
        public volatile long c = -1;

        private long a() {
            return this.a + this.b;
        }
    }

    private f() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long a(com.anythink.expressad.exoplayer.j.k kVar, long j, long j2, com.anythink.expressad.exoplayer.j.h hVar, byte[] bArr, com.anythink.expressad.exoplayer.k.v vVar, com.anythink.expressad.exoplayer.j.a.f.a aVar) {
        com.anythink.expressad.exoplayer.j.k kVar2 = kVar;
        while (true) {
            if (vVar != null) {
                vVar.b();
            }
            try {
                try {
                    if (java.lang.Thread.interrupted()) {
                        throw new java.lang.InterruptedException();
                    }
                    com.anythink.expressad.exoplayer.j.k kVar3 = new com.anythink.expressad.exoplayer.j.k(kVar2.c, kVar2.d, j, (kVar2.f + j) - kVar2.e, -1L, kVar2.h, kVar2.i | 2);
                    try {
                        long a2 = hVar.a(kVar3);
                        if (aVar.c == -1 && a2 != -1) {
                            aVar.c = kVar3.e + a2;
                        }
                        long j3 = 0;
                        while (true) {
                            if (j3 == j2) {
                                break;
                            }
                            if (java.lang.Thread.interrupted()) {
                                throw new java.lang.InterruptedException();
                            }
                            int a3 = hVar.a(bArr, 0, j2 != -1 ? (int) java.lang.Math.min(bArr.length, j2 - j3) : bArr.length);
                            if (a3 != -1) {
                                long j4 = a3;
                                j3 += j4;
                                aVar.b += j4;
                            } else if (aVar.c == -1) {
                                aVar.c = kVar3.e + j3;
                            }
                        }
                    } catch (com.anythink.expressad.exoplayer.k.v.a unused) {
                        kVar2 = kVar3;
                    }
                } catch (com.anythink.expressad.exoplayer.k.v.a unused2) {
                }
                com.anythink.expressad.exoplayer.k.af.a(hVar);
            } finally {
                com.anythink.expressad.exoplayer.k.af.a(hVar);
            }
        }
    }

    private static java.lang.String a(android.net.Uri uri) {
        return uri.toString();
    }

    public static java.lang.String a(com.anythink.expressad.exoplayer.j.k kVar) {
        java.lang.String str = kVar.h;
        return str != null ? str : kVar.c.toString();
    }

    private static void a(com.anythink.expressad.exoplayer.j.a.a aVar, java.lang.String str) {
        java.util.Iterator<com.anythink.expressad.exoplayer.j.a.e> it = aVar.a(str).iterator();
        while (it.hasNext()) {
            try {
                aVar.b(it.next());
            } catch (com.anythink.expressad.exoplayer.j.a.a.C0203a unused) {
            }
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.a.c cVar, byte[] bArr, com.anythink.expressad.exoplayer.k.v vVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.j.a.f.a aVar2, @androidx.annotation.Nullable java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
        com.anythink.expressad.exoplayer.j.a.f.a aVar3;
        java.lang.String str;
        long j;
        long j2;
        com.anythink.expressad.exoplayer.k.a.a(cVar);
        com.anythink.expressad.exoplayer.k.a.a(bArr);
        long j3 = 0;
        if (aVar2 != null) {
            java.lang.String a2 = a(kVar);
            long j4 = kVar.e;
            long j5 = kVar.g;
            if (j5 == -1) {
                j5 = aVar.b(a2);
            }
            aVar2.c = j5;
            aVar2.a = 0L;
            aVar2.b = 0L;
            long j6 = j4;
            long j7 = j5;
            while (j7 != 0) {
                long b = aVar.b(a2, j6, j7 != -1 ? j7 : Long.MAX_VALUE);
                if (b <= 0) {
                    b = -b;
                    if (b == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.a += b;
                }
                j6 += b;
                if (j7 == -1) {
                    b = 0;
                }
                j7 -= b;
            }
            aVar3 = aVar2;
        } else {
            aVar3 = new com.anythink.expressad.exoplayer.j.a.f.a();
        }
        java.lang.String a3 = a(kVar);
        long j8 = kVar.e;
        long j9 = kVar.g;
        if (j9 == -1) {
            j9 = aVar.b(a3);
        }
        long j10 = j8;
        long j11 = j9;
        while (j11 != j3) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new java.lang.InterruptedException();
            }
            long b2 = aVar.b(a3, j10, j11 != -1 ? j11 : Long.MAX_VALUE);
            if (b2 <= j3) {
                long j12 = -b2;
                str = a3;
                j = j3;
                if (a(kVar, j10, j12, cVar, bArr, vVar, aVar3) < j12) {
                    return;
                } else {
                    j2 = j12;
                }
            } else {
                str = a3;
                j = j3;
                j2 = b2;
            }
            j10 += j2;
            if (j11 == -1) {
                j2 = j;
            }
            j11 -= j2;
            a3 = str;
            j3 = j;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.a.f.a aVar2) {
        java.lang.String a2 = a(kVar);
        long j = kVar.e;
        long j2 = kVar.g;
        if (j2 == -1) {
            j2 = aVar.b(a2);
        }
        aVar2.c = j2;
        aVar2.a = 0L;
        aVar2.b = 0L;
        long j3 = j;
        long j4 = j2;
        while (j4 != 0) {
            long b = aVar.b(a2, j3, j4 != -1 ? j4 : Long.MAX_VALUE);
            if (b > 0) {
                aVar2.a += b;
            } else {
                b = -b;
                if (b == Long.MAX_VALUE) {
                    return;
                }
            }
            j3 += b;
            if (j4 == -1) {
                b = 0;
            }
            j4 -= b;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.j.a.f.a aVar2, @androidx.annotation.Nullable java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
        com.anythink.expressad.exoplayer.j.a.f.a aVar3;
        java.lang.String str;
        long j;
        long j2;
        com.anythink.expressad.exoplayer.j.a.c cVar = new com.anythink.expressad.exoplayer.j.a.c(aVar, hVar);
        byte[] bArr = new byte[131072];
        com.anythink.expressad.exoplayer.k.a.a(cVar);
        com.anythink.expressad.exoplayer.k.a.a(bArr);
        long j3 = 0;
        if (aVar2 != null) {
            java.lang.String a2 = a(kVar);
            long j4 = kVar.e;
            long j5 = kVar.g;
            if (j5 == -1) {
                j5 = aVar.b(a2);
            }
            aVar2.c = j5;
            aVar2.a = 0L;
            aVar2.b = 0L;
            long j6 = j4;
            long j7 = j5;
            while (j7 != 0) {
                java.lang.String str2 = a2;
                long b = aVar.b(a2, j6, j7 != -1 ? j7 : Long.MAX_VALUE);
                if (b <= 0) {
                    b = -b;
                    if (b == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.a += b;
                }
                j6 += b;
                if (j7 == -1) {
                    b = 0;
                }
                j7 -= b;
                a2 = str2;
            }
            aVar3 = aVar2;
        } else {
            aVar3 = new com.anythink.expressad.exoplayer.j.a.f.a();
        }
        java.lang.String a3 = a(kVar);
        long j8 = kVar.e;
        long j9 = kVar.g;
        if (j9 == -1) {
            j9 = aVar.b(a3);
        }
        long j10 = j8;
        long j11 = j9;
        while (j11 != j3) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new java.lang.InterruptedException();
            }
            long b2 = aVar.b(a3, j10, j11 != -1 ? j11 : Long.MAX_VALUE);
            if (b2 <= j3) {
                long j12 = -b2;
                str = a3;
                j = j3;
                if (a(kVar, j10, j12, cVar, bArr, (com.anythink.expressad.exoplayer.k.v) null, aVar3) < j12) {
                    return;
                } else {
                    j2 = j12;
                }
            } else {
                str = a3;
                j = j3;
                j2 = b2;
            }
            j10 += j2;
            if (j11 == -1) {
                j2 = j;
            }
            j11 -= j2;
            a3 = str;
            j3 = j;
        }
    }
}
