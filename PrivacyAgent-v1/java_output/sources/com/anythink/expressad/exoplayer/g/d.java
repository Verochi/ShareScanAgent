package com.anythink.expressad.exoplayer.g;

/* loaded from: classes12.dex */
public interface d {
    public static final com.anythink.expressad.exoplayer.g.d a = new com.anythink.expressad.exoplayer.g.d.AnonymousClass1();

    /* renamed from: com.anythink.expressad.exoplayer.g.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.g.d {
        @Override // com.anythink.expressad.exoplayer.g.d
        public final boolean a(com.anythink.expressad.exoplayer.m mVar) {
            java.lang.String str = mVar.h;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        @Override // com.anythink.expressad.exoplayer.g.d
        public final com.anythink.expressad.exoplayer.g.b b(com.anythink.expressad.exoplayer.m mVar) {
            java.lang.String str = mVar.h;
            str.hashCode();
            switch (str) {
                case "application/id3":
                    return new com.anythink.expressad.exoplayer.g.b.g();
                case "application/x-emsg":
                    return new com.anythink.expressad.exoplayer.g.a.b();
                case "application/x-scte35":
                    return new com.anythink.expressad.exoplayer.g.c.c();
                default:
                    throw new java.lang.IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(com.anythink.expressad.exoplayer.m mVar);

    com.anythink.expressad.exoplayer.g.b b(com.anythink.expressad.exoplayer.m mVar);
}
