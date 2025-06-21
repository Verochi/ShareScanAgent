package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.exoplayer.e.h {
    private static final java.lang.reflect.Constructor<? extends com.anythink.expressad.exoplayer.e.e> a;
    private int b;
    private int c;

    static {
        java.lang.reflect.Constructor<? extends com.anythink.expressad.exoplayer.e.e> constructor;
        try {
            constructor = java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.flac.FlacExtractor").asSubclass(com.anythink.expressad.exoplayer.e.e.class).getConstructor(new java.lang.Class[0]);
        } catch (java.lang.ClassNotFoundException unused) {
            constructor = null;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Error instantiating FLAC extension", e);
        }
        a = constructor;
    }

    private synchronized com.anythink.expressad.exoplayer.e.c a(int i) {
        this.b = i;
        return this;
    }

    private synchronized com.anythink.expressad.exoplayer.e.c b(int i) {
        this.c = i;
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.e.h
    public final synchronized com.anythink.expressad.exoplayer.e.e[] a() {
        com.anythink.expressad.exoplayer.e.e[] eVarArr;
        java.lang.reflect.Constructor<? extends com.anythink.expressad.exoplayer.e.e> constructor = a;
        eVarArr = new com.anythink.expressad.exoplayer.e.e[constructor == null ? 2 : 3];
        eVarArr[0] = new com.anythink.expressad.exoplayer.e.a.e(this.c);
        eVarArr[1] = new com.anythink.expressad.exoplayer.e.a.g(this.b);
        if (constructor != null) {
            try {
                eVarArr[2] = constructor.newInstance(new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                throw new java.lang.IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return eVarArr;
    }
}
