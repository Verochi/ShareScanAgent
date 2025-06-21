package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class d implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher {
    private static final java.lang.String j = "com.aliyun.svideosdk.common.impl.d";
    private long e;
    private android.os.HandlerThread h;
    private android.os.Handler i;
    private com.aliyun.svideosdk.common.impl.d.c a = new com.aliyun.svideosdk.common.impl.d.c();
    private java.util.HashMap<java.lang.String, com.aliyun.svideosdk.common.impl.h> b = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, com.aliyun.svideosdk.common.impl.f> c = new java.util.HashMap<>();
    private java.util.LinkedHashMap<java.lang.Long, com.aliyun.svideosdk.common.impl.d.C0086d> d = new java.util.LinkedHashMap<>();
    private long f = 0;
    private long g = 0;

    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.common.MediaType.values().length];
            b = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.values().length];
            a = iArr2;
            try {
                iArr2[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public class b extends android.os.Handler {
        public b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            getLooper().quitSafely();
            com.aliyun.svideosdk.common.impl.d.this.i = null;
        }
    }

    public static class c {
        private int a;
        private java.util.List<java.lang.Integer> b = new java.util.ArrayList();

        public synchronized int a() {
            int intValue;
            if (this.b.size() == 0) {
                intValue = this.a;
                this.a = intValue + 1;
                this.b.add(java.lang.Integer.valueOf(intValue));
            } else {
                intValue = this.b.remove(0).intValue();
            }
            return intValue;
        }
    }

    /* renamed from: com.aliyun.svideosdk.common.impl.d$d, reason: collision with other inner class name */
    public class C0086d {
        java.lang.String a;
        com.aliyun.svideosdk.common.struct.common.MediaType b;
        long c;

        public C0086d(com.aliyun.svideosdk.common.impl.d dVar, java.lang.String str, com.aliyun.svideosdk.common.struct.common.MediaType mediaType) {
            this.a = str;
            this.b = mediaType;
        }

        public long a() {
            return this.c;
        }

        public void a(long j) {
        }

        public void b(long j) {
            this.c = j;
        }

        public void c(long j) {
        }
    }

    public class e {
        com.aliyun.svideosdk.common.impl.a a;
        java.util.Map<java.lang.Long, java.util.List<java.lang.Long>> b = new java.util.HashMap();

        public e(com.aliyun.svideosdk.common.impl.d dVar, com.aliyun.svideosdk.common.impl.a aVar) {
            this.a = aVar;
        }
    }

    public d() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ThumbnailIOThread");
        this.h = handlerThread;
        this.i = null;
        handlerThread.setPriority(1);
        this.h.start();
        this.i = new com.aliyun.svideosdk.common.impl.d.b(this.h.getLooper());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.aliyun.svideosdk.common.impl.a aVar) {
        int g;
        int f;
        int i;
        float f2;
        float f3;
        float f4;
        float f5;
        int i2;
        int i3;
        int i4;
        com.aliyun.svideosdk.common.impl.a aVar2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        com.aliyun.svideosdk.common.impl.a aVar3;
        int i10;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this);
        sb.append(" Call setCropInfo");
        com.aliyun.svideosdk.common.impl.e a2 = aVar.a();
        int d = a2.d();
        int c2 = a2.c();
        a2.b();
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode j2 = a2.j();
        int i11 = a2.i();
        if (i11 != 0) {
            if (i11 != 90) {
                if (i11 != 180) {
                    if (i11 != 270) {
                        f = 0;
                        i = 0;
                        f2 = i * 1.0f;
                        f3 = f;
                        f4 = d;
                        f5 = c2;
                        if (f2 / f3 == (f4 * 1.0f) / f5) {
                            if (i11 == 90 || i11 == 270) {
                                i8 = 0;
                                i9 = 0;
                                aVar3 = aVar;
                                i10 = f;
                            } else {
                                i8 = 0;
                                i9 = 0;
                                aVar3 = aVar;
                                i10 = i;
                                i = f;
                            }
                            aVar3.a(i11, i8, i9, i10, i);
                            return;
                        }
                        if (com.aliyun.svideosdk.common.impl.d.a.a[j2.ordinal()] != 2) {
                            i3 = f;
                        } else {
                            if ((f3 * 1.0f) / f5 <= f2 / f4) {
                                i2 = (int) (((d * f) * 1.0f) / f5);
                                i3 = f;
                                i4 = (i - i2) / 2;
                                int i12 = (f - i3) / 2;
                                if (i11 != 0 || i11 == 180) {
                                    aVar2 = aVar;
                                    i5 = i4;
                                    i6 = i2;
                                    i7 = i3;
                                } else {
                                    aVar2 = aVar;
                                    i5 = i12;
                                    i12 = i4;
                                    i6 = i3;
                                    i7 = i2;
                                }
                                aVar2.a(i11, i5, i12, i6, i7);
                                return;
                            }
                            i3 = (int) (((c2 * i) * 1.0f) / f4);
                        }
                        i2 = i;
                        i4 = (i - i2) / 2;
                        int i122 = (f - i3) / 2;
                        if (i11 != 0) {
                        }
                        aVar2 = aVar;
                        i5 = i4;
                        i6 = i2;
                        i7 = i3;
                        aVar2.a(i11, i5, i122, i6, i7);
                        return;
                    }
                }
            }
            g = a2.f();
            f = a2.g();
            i = g;
            f2 = i * 1.0f;
            f3 = f;
            f4 = d;
            f5 = c2;
            if (f2 / f3 == (f4 * 1.0f) / f5) {
            }
        }
        g = a2.g();
        f = a2.f();
        i = g;
        f2 = i * 1.0f;
        f3 = f;
        f4 = d;
        f5 = c2;
        if (f2 / f3 == (f4 * 1.0f) / f5) {
        }
    }

    public long a(long j2) {
        long j3 = this.g - this.f;
        return j2 > j3 ? j3 : j2;
    }

    public java.util.Map<java.lang.String, com.aliyun.svideosdk.common.impl.d.e> a(long[] jArr) {
        com.aliyun.svideosdk.common.impl.d.C0086d c0086d;
        java.util.HashMap hashMap = new java.util.HashMap();
        if (this.d.size() == 0) {
            return hashMap;
        }
        for (long j2 : jArr) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Long, com.aliyun.svideosdk.common.impl.d.C0086d>> it = this.d.entrySet().iterator();
            long j3 = 0;
            while (it.hasNext()) {
                long longValue = it.next().getKey().longValue();
                if (j2 <= longValue) {
                    break;
                }
                j3 = longValue;
            }
            if (j3 >= 0 && (c0086d = this.d.get(java.lang.Long.valueOf(j3))) != null) {
                long j4 = j2 - j3;
                java.lang.String str = c0086d.a;
                com.aliyun.svideosdk.common.impl.d.e eVar = (com.aliyun.svideosdk.common.impl.d.e) hashMap.get(str);
                int i = com.aliyun.svideosdk.common.impl.d.a.b[c0086d.b.ordinal()];
                if (i == 1) {
                    if (eVar == null) {
                        eVar = new com.aliyun.svideosdk.common.impl.d.e(this, this.c.get(str));
                        hashMap.put(str, eVar);
                    }
                    java.util.List<java.lang.Long> list = eVar.b.get(java.lang.Long.valueOf(j3));
                    if (list == null) {
                        list = new java.util.ArrayList<>();
                        eVar.b.put(java.lang.Long.valueOf(j3), list);
                    }
                    list.add(java.lang.Long.valueOf(j4 * 1000));
                } else if (i == 2) {
                    if (eVar == null) {
                        com.aliyun.svideosdk.common.impl.d.e eVar2 = new com.aliyun.svideosdk.common.impl.d.e(this, this.b.get(str));
                        hashMap.put(str, eVar2);
                        eVar = eVar2;
                    }
                    java.util.List<java.lang.Long> list2 = eVar.b.get(java.lang.Long.valueOf(j3));
                    if (list2 == null) {
                        list2 = new java.util.ArrayList<>();
                        eVar.b.put(java.lang.Long.valueOf(j3), list2);
                    }
                    list2.add(java.lang.Long.valueOf((j4 + c0086d.a()) * 1000));
                }
            }
        }
        return hashMap;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int addImageSource(java.lang.String str, long j2, long j3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -20003002;
        }
        if (!new java.io.File(str).exists()) {
            return -20003002;
        }
        com.aliyun.svideosdk.common.impl.f fVar = this.c.get(str);
        long j4 = this.e;
        if (fVar == null) {
            com.aliyun.svideosdk.common.impl.f fVar2 = new com.aliyun.svideosdk.common.impl.f(this.h.getLooper());
            com.aliyun.svideosdk.common.impl.e a2 = fVar2.a();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            a2.a(str);
            a2.d(options.outWidth);
            a2.c(options.outHeight);
            a2.a(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE);
            this.c.put(str, fVar2);
        }
        if (j3 > j2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Invalid overlapDuration:");
            sb.append(j3);
            j3 = j2;
        }
        long j5 = this.e;
        if (j5 == 0) {
            this.e = j5 + j2;
            this.g = j2;
        } else {
            long a3 = a(j3);
            if (a3 == j2) {
                return 0;
            }
            this.e += j2 - a3;
            this.g = j2;
            this.f = a3;
        }
        this.d.put(java.lang.Long.valueOf(j4), new com.aliyun.svideosdk.common.impl.d.C0086d(this, str, com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE));
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1 A[Catch: all -> 0x012e, TRY_LEAVE, TryCatch #6 {, blocks: (B:3:0x0001, B:9:0x000c, B:13:0x0019, B:20:0x005f, B:21:0x00a7, B:23:0x00b1, B:26:0x00bd, B:28:0x00c9, B:29:0x00ee, B:52:0x012a, B:53:0x012d, B:40:0x00a0, B:45:0x0122), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd A[Catch: all -> 0x012e, TRY_ENTER, TryCatch #6 {, blocks: (B:3:0x0001, B:9:0x000c, B:13:0x0019, B:20:0x005f, B:21:0x00a7, B:23:0x00b1, B:26:0x00bd, B:28:0x00c9, B:29:0x00ee, B:52:0x012a, B:53:0x012d, B:40:0x00a0, B:45:0x0122), top: B:2:0x0001 }] */
    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int addVideoSource(java.lang.String str) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        int i2;
        int i3;
        long j2;
        if (android.text.TextUtils.isEmpty(str)) {
            return -20003002;
        }
        if (!new java.io.File(str).exists()) {
            return -20003002;
        }
        java.lang.String mimeType = com.aliyun.common.utils.FileUtils.getMimeType(str);
        android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Throwable th) {
            th = th;
            mediaMetadataRetriever = mediaMetadataRetriever2;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            i = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            i2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            i3 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            j2 = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9) + "000");
            mediaMetadataRetriever.release();
        } catch (java.lang.Exception unused2) {
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
            nativeParser.init(str);
            try {
                int parseInt = java.lang.Integer.parseInt(nativeParser.getValue(6));
                int parseInt2 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                int parseInt3 = java.lang.Integer.parseInt(nativeParser.getValue(14));
                long parseLong = java.lang.Long.parseLong(nativeParser.getValue(3));
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                i = parseInt;
                i2 = parseInt2;
                i3 = parseInt3;
                j2 = parseLong;
                if (!mimeType.contains("gif")) {
                }
            } catch (java.lang.Exception unused3) {
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                return -20003002;
            } finally {
                nativeParser.release();
                nativeParser.dispose();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        if (!mimeType.contains("gif")) {
            return addImageSource(str, j2 / 1000, 0L);
        }
        com.aliyun.svideosdk.common.impl.h hVar = this.b.get(str);
        long j3 = this.e;
        if (hVar == null) {
            com.aliyun.svideosdk.common.impl.h hVar2 = new com.aliyun.svideosdk.common.impl.h(this.h.getLooper());
            com.aliyun.svideosdk.common.impl.e a2 = hVar2.a();
            a2.a(str);
            a2.e(i3);
            a2.d(i);
            a2.c(i2);
            a2.a(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
            this.b.put(str, hVar2);
        }
        com.aliyun.svideosdk.common.impl.d.C0086d c0086d = new com.aliyun.svideosdk.common.impl.d.C0086d(this, str, com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
        long j4 = j2 / 1000;
        c0086d.b(0L);
        c0086d.a(j4);
        c0086d.c(j4);
        this.e += j4;
        this.d.put(java.lang.Long.valueOf(j3), c0086d);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf A[Catch: all -> 0x01c7, TryCatch #1 {, blocks: (B:4:0x0007, B:10:0x0012, B:14:0x001f, B:16:0x002b, B:19:0x0039, B:26:0x0085, B:28:0x00cf, B:29:0x00f4, B:44:0x0128, B:46:0x012e, B:47:0x014c, B:49:0x0155, B:54:0x0160, B:55:0x0184, B:58:0x0174, B:59:0x018f, B:84:0x01c3, B:85:0x01c6, B:72:0x00c6, B:77:0x01bb, B:69:0x009a), top: B:3:0x0007, inners: #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int addVideoSource(java.lang.String str, long j2, long j3, long j4) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        int i2;
        int i3;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9 = j4;
        synchronized (this) {
            if (android.text.TextUtils.isEmpty(str)) {
                return -20003002;
            }
            if (!new java.io.File(str).exists()) {
                return -20003002;
            }
            if (com.aliyun.common.utils.FileUtils.getMimeType(str).contains("gif")) {
                return addImageSource(str, j3 - j2, j4);
            }
            com.aliyun.svideosdk.common.impl.h hVar = this.b.get(str);
            long j10 = this.e;
            android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                } catch (java.lang.Throwable th) {
                    th = th;
                    mediaMetadataRetriever = null;
                }
            } catch (java.lang.Exception unused) {
            }
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                i2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                i3 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                j5 = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9) + "000");
                mediaMetadataRetriever.release();
            } catch (java.lang.Exception unused2) {
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                nativeParser.init(str);
                try {
                    int parseInt = java.lang.Integer.parseInt(nativeParser.getValue(6));
                    int parseInt2 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                    int parseInt3 = java.lang.Integer.parseInt(nativeParser.getValue(14));
                    long parseLong = java.lang.Long.parseLong(nativeParser.getValue(3));
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever2.release();
                    }
                    i = parseInt;
                    i2 = parseInt2;
                    i3 = parseInt3;
                    j5 = parseLong;
                    if (hVar == null) {
                    }
                    com.aliyun.svideosdk.common.impl.d.C0086d c0086d = new com.aliyun.svideosdk.common.impl.d.C0086d(this, str, com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
                    j6 = j5 / 1000;
                    hVar.a().b(j6);
                    if (j3 <= j6) {
                        j7 = j3;
                        if (j2 >= 0) {
                        }
                        if (j7 <= j6) {
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Invalid time interval [");
                        sb.append(j8);
                        sb.append(",");
                        sb.append(j7);
                        sb.append("]");
                        return -20003002;
                    }
                    j7 = j6;
                    if (j2 >= 0) {
                    }
                    if (j7 <= j6) {
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Invalid time interval [");
                    sb2.append(j8);
                    sb2.append(",");
                    sb2.append(j7);
                    sb2.append("]");
                    return -20003002;
                } catch (java.lang.Exception unused3) {
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever2.release();
                    }
                    return -20003002;
                } finally {
                    nativeParser.release();
                    nativeParser.dispose();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
            if (hVar == null) {
                hVar = new com.aliyun.svideosdk.common.impl.h(this.h.getLooper());
                com.aliyun.svideosdk.common.impl.e a2 = hVar.a();
                a2.a(str);
                a2.e(i3);
                a2.d(i);
                a2.c(i2);
                a2.a(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
                this.b.put(str, hVar);
            }
            com.aliyun.svideosdk.common.impl.d.C0086d c0086d2 = new com.aliyun.svideosdk.common.impl.d.C0086d(this, str, com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
            j6 = j5 / 1000;
            hVar.a().b(j6);
            if (j3 <= j6 && j3 != 0) {
                j7 = j3;
                j8 = j2 >= 0 ? 0L : j2;
                if (j7 <= j6 || j8 < 0 || j7 <= j8) {
                    java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
                    sb22.append("Invalid time interval [");
                    sb22.append(j8);
                    sb22.append(",");
                    sb22.append(j7);
                    sb22.append("]");
                    return -20003002;
                }
                long j11 = j7 - j8;
                if (j9 > j11) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("Invalid overlapDuration:overlapDuration ");
                    sb3.append(j9);
                    sb3.append(", endTime ");
                    sb3.append(j7);
                    sb3.append(", startTime ");
                    sb3.append(j8);
                    j9 = j11;
                }
                if (this.e > 0) {
                    long a3 = a(j9);
                    long j12 = j8 + a3;
                    if (j12 >= j7) {
                        return 0;
                    }
                    c0086d2.b(j12);
                    c0086d2.a(j7);
                    long j13 = j11 - a3;
                    c0086d2.c(j13);
                    this.e += j13;
                    this.g = j13;
                    this.f = a3;
                } else {
                    c0086d2.b(j8);
                    c0086d2.a(j7);
                    c0086d2.c(j11);
                    this.e += j11;
                    this.g = j11;
                }
                this.d.put(java.lang.Long.valueOf(j10), c0086d2);
                return 0;
            }
            j7 = j6;
            if (j2 >= 0) {
            }
            if (j7 <= j6) {
            }
            java.lang.StringBuilder sb222 = new java.lang.StringBuilder();
            sb222.append("Invalid time interval [");
            sb222.append(j8);
            sb222.append(",");
            sb222.append(j7);
            sb222.append("]");
            return -20003002;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00be, code lost:
    
        if (r3 == null) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:15:0x0044->B:27:?, LOOP_END, SYNTHETIC] */
    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int fromConfigJson(java.lang.String str) {
        java.lang.String path;
        long out;
        long overlapDuration;
        long j2;
        java.lang.String str2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this);
        sb.append(" Call fromConfigJson:");
        sb.append(str);
        com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl projectJSONSupportImpl = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
        if (android.text.TextUtils.isEmpty(str)) {
            return -20003002;
        }
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(new java.io.File(str), projectJSONSupportImpl);
        if (readProject == null) {
            return -20003002;
        }
        int i = 0;
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : readProject.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            com.aliyun.svideosdk.common.struct.effect.TransitionBase transition = videoTrackClip.getTransition();
            int type = videoTrackClip.getType();
            long j3 = 0;
            if (type == 0) {
                java.lang.String mimeType = com.aliyun.common.utils.FileUtils.getMimeType(videoTrackClip.getSource().getPath());
                if (java.lang.Boolean.valueOf(mimeType == null ? videoTrackClip.getSource().getPath().endsWith("gif") : mimeType.contains("gif")).booleanValue()) {
                    path = videoTrackClip.getSource().getPath();
                    out = (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f);
                } else {
                    java.lang.String path2 = videoTrackClip.getSource().getPath();
                    long in = (long) (videoTrackClip.getIn() * 1000.0f);
                    long out2 = (long) (videoTrackClip.getOut() * 1000.0f);
                    if (transition != null) {
                        j3 = transition.getOverlapDuration() / 1000;
                    }
                    i = addVideoSource(path2, in, out2, j3);
                    if (i != 0) {
                    }
                }
            } else if (type == 1) {
                path = videoTrackClip.getSource().getPath();
                out = (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f);
                if (transition == null) {
                    str2 = path;
                    overlapDuration = 0;
                    j2 = out;
                }
                overlapDuration = transition.getOverlapDuration() / 1000;
                j2 = out;
                str2 = path;
            } else if (i != 0) {
                return i;
            }
            i = addImageSource(str2, j2, overlapDuration);
            if (i != 0) {
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized long getTotalDuration() {
        return this.e;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized void release() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this);
        sb.append(" Call release");
        for (java.util.Map.Entry<java.lang.String, com.aliyun.svideosdk.common.impl.h> entry : this.b.entrySet()) {
            if (entry.getValue().c()) {
                entry.getValue().g();
            }
            entry.getValue().d();
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.aliyun.svideosdk.common.impl.f>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().d();
        }
        android.os.Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public int requestThumbnailImage(int i, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion) {
        long[] jArr = new long[i];
        long j2 = this.e / i;
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = (i2 * j2) + (j2 / 2);
        }
        return requestThumbnailImage(jArr, onThumbnailCompletion);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int requestThumbnailImage(long[] jArr, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion) {
        int a2 = this.a.a();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.aliyun.svideosdk.common.impl.d.e>> it = a(jArr).entrySet().iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.common.impl.d.e value = it.next().getValue();
            com.aliyun.svideosdk.common.impl.a aVar = value.a;
            if (aVar != null) {
                aVar.a(jArr);
                if (!value.a.b()) {
                    a(value.a);
                    com.aliyun.svideosdk.common.impl.a aVar2 = value.a;
                    if (aVar2.a(aVar2.a().e()) != 0) {
                        return -20007006;
                    }
                }
                if (!value.a.c()) {
                    value.a.e();
                }
                for (java.util.Map.Entry<java.lang.Long, java.util.List<java.lang.Long>> entry : value.b.entrySet()) {
                    value.a.a(entry.getKey().longValue() * 1000, entry.getValue(), onThumbnailCompletion, this.d.get(entry.getKey()).a() * 1000);
                }
            }
        }
        return a2;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public int setFastMode(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this);
        sb.append(" Call setFastMode fastMode:");
        sb.append(z);
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.aliyun.svideosdk.common.impl.h>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            int a2 = it.next().getValue().a(z);
            if (a2 != 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("setFastMode failed,error code:");
                sb2.append(a2);
                return a2;
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int setParameters(int i, int i2, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode cropMode, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode, int i3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this);
        sb.append(" Call setParameters");
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.aliyun.svideosdk.common.impl.h>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.common.impl.h value = it.next().getValue();
            int a2 = value.a(i, i2);
            if (a2 != 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Invalid width[");
                sb2.append(i);
                sb2.append("] or height[");
                sb2.append(i2);
                sb2.append("]!");
                return a2;
            }
            value.a().a(cropMode);
            value.a().a(videoDisplayMode);
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.aliyun.svideosdk.common.impl.f>> it2 = this.c.entrySet().iterator();
        while (it2.hasNext()) {
            com.aliyun.svideosdk.common.impl.f value2 = it2.next().getValue();
            int a3 = value2.a(i, i2);
            if (a3 != 0) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("Invalid width[");
                sb3.append(i);
                sb3.append("] or height[");
                sb3.append(i2);
                sb3.append("]!");
                return a3;
            }
            value2.a().a(cropMode);
            value2.a().a(videoDisplayMode);
        }
        return 0;
    }
}
