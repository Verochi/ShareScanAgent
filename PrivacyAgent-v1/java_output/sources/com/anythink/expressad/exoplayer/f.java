package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public final class f implements com.anythink.expressad.exoplayer.ab {
    public static final long a = 5000;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    protected static final int e = 50;
    private static final java.lang.String f = "DefaultRenderersFactory";
    private final android.content.Context g;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> h;
    private final int i;
    private final long j;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public f(android.content.Context context) {
        this(context, 0);
    }

    public f(android.content.Context context, int i) {
        this(context, null, i, 5000L);
    }

    public f(android.content.Context context, int i, long j) {
        this(context, null, i, j);
    }

    @java.lang.Deprecated
    private f(android.content.Context context, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(context, gVar, (byte) 0);
    }

    @java.lang.Deprecated
    private f(android.content.Context context, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, byte b2) {
        this(context, gVar, 0, 5000L);
    }

    @java.lang.Deprecated
    private f(android.content.Context context, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, int i, long j) {
        this.g = context;
        this.i = i;
        this.j = j;
        this.h = gVar;
    }

    private static void a() {
    }

    private static void a(android.content.Context context, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, long j, android.os.Handler handler, com.anythink.expressad.exoplayer.l.h hVar, int i, java.util.ArrayList<com.anythink.expressad.exoplayer.y> arrayList) {
        arrayList.add(new com.anythink.expressad.exoplayer.l.e(context, com.anythink.expressad.exoplayer.f.c.a, j, gVar, handler, hVar, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            arrayList.add(size, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.vp9.LibvpxVideoRenderer").getConstructor(java.lang.Boolean.TYPE, java.lang.Long.TYPE, android.os.Handler.class, com.anythink.expressad.exoplayer.l.h.class, java.lang.Integer.TYPE).newInstance(java.lang.Boolean.TRUE, java.lang.Long.valueOf(j), handler, hVar, 50));
        } catch (java.lang.ClassNotFoundException unused) {
        } catch (java.lang.Exception e2) {
            throw new java.lang.RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    private static void a(android.content.Context context, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.b.f[] fVarArr, android.os.Handler handler, com.anythink.expressad.exoplayer.b.g gVar2, int i, java.util.ArrayList<com.anythink.expressad.exoplayer.y> arrayList) {
        int i2;
        int i3;
        arrayList.add(new com.anythink.expressad.exoplayer.b.o(context, com.anythink.expressad.exoplayer.f.c.a, gVar, handler, gVar2, com.anythink.expressad.exoplayer.b.c.a(context), fVarArr));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.opus.LibopusAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                } catch (java.lang.ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    try {
                        i3 = i2 + 1;
                        try {
                            arrayList.add(i2, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                        } catch (java.lang.ClassNotFoundException unused2) {
                            i2 = i3;
                            i3 = i2;
                            arrayList.add(i3, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                        }
                    } catch (java.lang.ClassNotFoundException unused3) {
                    }
                    arrayList.add(i3, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                }
            } catch (java.lang.Exception e2) {
                throw new java.lang.RuntimeException("Error instantiating Opus extension", e2);
            }
        } catch (java.lang.ClassNotFoundException unused4) {
        }
        try {
            i3 = i2 + 1;
            arrayList.add(i2, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
            try {
                arrayList.add(i3, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
            } catch (java.lang.ClassNotFoundException unused5) {
            } catch (java.lang.Exception e3) {
                throw new java.lang.RuntimeException("Error instantiating FFmpeg extension", e3);
            }
        } catch (java.lang.Exception e4) {
            throw new java.lang.RuntimeException("Error instantiating FLAC extension", e4);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.g.f fVar, android.os.Looper looper, java.util.ArrayList<com.anythink.expressad.exoplayer.y> arrayList) {
        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, looper));
    }

    private static com.anythink.expressad.exoplayer.b.f[] b() {
        return new com.anythink.expressad.exoplayer.b.f[0];
    }

    @Override // com.anythink.expressad.exoplayer.ab
    public final com.anythink.expressad.exoplayer.y[] a(android.os.Handler handler, com.anythink.expressad.exoplayer.l.h hVar, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.g.f fVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar2) {
        int i;
        int i2;
        com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar3 = gVar2 == null ? this.h : gVar2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.Context context = this.g;
        long j = this.j;
        int i3 = this.i;
        arrayList.add(new com.anythink.expressad.exoplayer.l.e(context, com.anythink.expressad.exoplayer.f.c.a, j, gVar3, handler, hVar, 50));
        if (i3 != 0) {
            int size = arrayList.size();
            if (i3 == 2) {
                size--;
            }
            try {
                arrayList.add(size, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.vp9.LibvpxVideoRenderer").getConstructor(java.lang.Boolean.TYPE, java.lang.Long.TYPE, android.os.Handler.class, com.anythink.expressad.exoplayer.l.h.class, java.lang.Integer.TYPE).newInstance(java.lang.Boolean.TRUE, java.lang.Long.valueOf(j), handler, hVar, 50));
            } catch (java.lang.ClassNotFoundException unused) {
            } catch (java.lang.Exception e2) {
                throw new java.lang.RuntimeException("Error instantiating VP9 extension", e2);
            }
        }
        android.content.Context context2 = this.g;
        com.anythink.expressad.exoplayer.b.f[] fVarArr = new com.anythink.expressad.exoplayer.b.f[0];
        int i4 = this.i;
        arrayList.add(new com.anythink.expressad.exoplayer.b.o(context2, com.anythink.expressad.exoplayer.f.c.a, gVar3, handler, gVar, com.anythink.expressad.exoplayer.b.c.a(context2), fVarArr));
        if (i4 != 0) {
            int size2 = arrayList.size();
            if (i4 == 2) {
                size2--;
            }
            try {
                try {
                    i = size2 + 1;
                    try {
                        arrayList.add(size2, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.opus.LibopusAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                    } catch (java.lang.ClassNotFoundException unused2) {
                        size2 = i;
                        i = size2;
                        try {
                            i2 = i + 1;
                            try {
                                arrayList.add(i, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                            } catch (java.lang.ClassNotFoundException unused3) {
                                i = i2;
                                i2 = i;
                                arrayList.add(i2, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                                arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, handler.getLooper()));
                                return (com.anythink.expressad.exoplayer.y[]) arrayList.toArray(new com.anythink.expressad.exoplayer.y[arrayList.size()]);
                            }
                        } catch (java.lang.ClassNotFoundException unused4) {
                        }
                        arrayList.add(i2, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, handler.getLooper()));
                        return (com.anythink.expressad.exoplayer.y[]) arrayList.toArray(new com.anythink.expressad.exoplayer.y[arrayList.size()]);
                    }
                } catch (java.lang.Exception e3) {
                    throw new java.lang.RuntimeException("Error instantiating Opus extension", e3);
                }
            } catch (java.lang.ClassNotFoundException unused5) {
            }
            try {
                i2 = i + 1;
                arrayList.add(i, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                try {
                    arrayList.add(i2, (com.anythink.expressad.exoplayer.y) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                } catch (java.lang.ClassNotFoundException unused6) {
                } catch (java.lang.Exception e4) {
                    throw new java.lang.RuntimeException("Error instantiating FFmpeg extension", e4);
                }
            } catch (java.lang.Exception e5) {
                throw new java.lang.RuntimeException("Error instantiating FLAC extension", e5);
            }
        }
        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, handler.getLooper()));
        return (com.anythink.expressad.exoplayer.y[]) arrayList.toArray(new com.anythink.expressad.exoplayer.y[arrayList.size()]);
    }
}
