package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieCompositionFactory {
    public static final java.util.Map<java.lang.String, com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition>> a = new java.util.HashMap();
    public static final byte[] b = {80, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 3, 4};

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ android.content.Context n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;

        public AnonymousClass1(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.n = context;
            this.t = str;
            this.u = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fetchSync = com.airbnb.lottie.L.networkFetcher(this.n).fetchSync(this.t, this.u);
            if (this.u != null && fetchSync.getValue() != null) {
                com.airbnb.lottie.model.LottieCompositionCache.getInstance().put(this.u, fetchSync.getValue());
            }
            return fetchSync;
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$10, reason: invalid class name */
    public class AnonymousClass10 implements com.airbnb.lottie.LottieListener<com.airbnb.lottie.LottieComposition> {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass10(java.lang.String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieCompositionFactory.a.remove(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$11, reason: invalid class name */
    public class AnonymousClass11 implements com.airbnb.lottie.LottieListener<java.lang.Throwable> {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass11(java.lang.String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(java.lang.Throwable th) {
            com.airbnb.lottie.LottieCompositionFactory.a.remove(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ android.content.Context n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;

        public AnonymousClass2(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.n = context;
            this.t = str;
            this.u = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieCompositionFactory.fromAssetSync(this.n, this.t, this.u);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ java.lang.ref.WeakReference n;
        public final /* synthetic */ android.content.Context t;
        public final /* synthetic */ int u;
        public final /* synthetic */ java.lang.String v;

        public AnonymousClass3(java.lang.ref.WeakReference weakReference, android.content.Context context, int i, java.lang.String str) {
            this.n = weakReference;
            this.t = context;
            this.u = i;
            this.v = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            android.content.Context context = (android.content.Context) this.n.get();
            if (context == null) {
                context = this.t;
            }
            return com.airbnb.lottie.LottieCompositionFactory.fromRawResSync(context, this.u, this.v);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$4, reason: invalid class name */
    public class AnonymousClass4 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ java.io.InputStream n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass4(java.io.InputStream inputStream, java.lang.String str) {
            this.n = inputStream;
            this.t = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(this.n, this.t);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$5, reason: invalid class name */
    public class AnonymousClass5 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ org.json.JSONObject n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass5(org.json.JSONObject jSONObject, java.lang.String str) {
            this.n = jSONObject;
            this.t = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonSync(this.n, this.t);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$6, reason: invalid class name */
    public class AnonymousClass6 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass6(java.lang.String str, java.lang.String str2) {
            this.n = str;
            this.t = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonStringSync(this.n, this.t);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$7, reason: invalid class name */
    public class AnonymousClass7 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ com.airbnb.lottie.parser.moshi.JsonReader n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass7(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, java.lang.String str) {
            this.n = jsonReader;
            this.t = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonReaderSync(this.n, this.t);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$8, reason: invalid class name */
    public class AnonymousClass8 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ java.util.zip.ZipInputStream n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass8(java.util.zip.ZipInputStream zipInputStream, java.lang.String str) {
            this.n = zipInputStream;
            this.t = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSync(this.n, this.t);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieCompositionFactory$9, reason: invalid class name */
    public class AnonymousClass9 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ com.airbnb.lottie.LottieComposition n;

        public AnonymousClass9(com.airbnb.lottie.LottieComposition lottieComposition) {
            this.n = lottieComposition;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return new com.airbnb.lottie.LottieResult<>(this.n);
        }
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> b(@androidx.annotation.Nullable java.lang.String str, java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> callable) {
        com.airbnb.lottie.LottieComposition lottieComposition = str == null ? null : com.airbnb.lottie.model.LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new com.airbnb.lottie.LottieTask<>(new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass9(lottieComposition));
        }
        if (str != null) {
            java.util.Map<java.lang.String, com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> lottieTask = new com.airbnb.lottie.LottieTask<>(callable);
        if (str != null) {
            lottieTask.addListener(new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass10(str));
            lottieTask.addFailureListener(new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass11(str));
            a.put(str, lottieTask);
        }
        return lottieTask;
    }

    @androidx.annotation.Nullable
    public static com.airbnb.lottie.LottieImageAsset c(com.airbnb.lottie.LottieComposition lottieComposition, java.lang.String str) {
        for (com.airbnb.lottie.LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static void clearCache(android.content.Context context) {
        a.clear();
        com.airbnb.lottie.model.LottieCompositionCache.getInstance().clear();
        com.airbnb.lottie.L.networkCache(context).clear();
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> d(java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str, boolean z) {
        try {
            return fromJsonReaderSync(com.airbnb.lottie.parser.moshi.JsonReader.of(okio.Okio.buffer(okio.Okio.source(inputStream))), str);
        } finally {
            if (z) {
                com.airbnb.lottie.utils.Utils.closeQuietly(inputStream);
            }
        }
    }

    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> e(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, @androidx.annotation.Nullable java.lang.String str, boolean z) {
        try {
            try {
                com.airbnb.lottie.LottieComposition parse = com.airbnb.lottie.parser.LottieCompositionMoshiParser.parse(jsonReader);
                if (str != null) {
                    com.airbnb.lottie.model.LottieCompositionCache.getInstance().put(str, parse);
                }
                com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> lottieResult = new com.airbnb.lottie.LottieResult<>(parse);
                if (z) {
                    com.airbnb.lottie.utils.Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (java.lang.Exception e) {
                com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> lottieResult2 = new com.airbnb.lottie.LottieResult<>(e);
                if (z) {
                    com.airbnb.lottie.utils.Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
        } catch (java.lang.Throwable th) {
            if (z) {
                com.airbnb.lottie.utils.Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> f(java.util.zip.ZipInputStream zipInputStream, @androidx.annotation.Nullable java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                java.lang.String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = e(com.airbnb.lottie.parser.moshi.JsonReader.of(okio.Okio.buffer(okio.Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[r1.length - 1], android.graphics.BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new com.airbnb.lottie.LottieResult<>((java.lang.Throwable) new java.lang.IllegalArgumentException("Unable to parse composition"));
            }
            for (java.util.Map.Entry entry : hashMap.entrySet()) {
                com.airbnb.lottie.LottieImageAsset c = c(lottieComposition, (java.lang.String) entry.getKey());
                if (c != null) {
                    c.setBitmap(com.airbnb.lottie.utils.Utils.resizeBitmapIfNeeded((android.graphics.Bitmap) entry.getValue(), c.getWidth(), c.getHeight()));
                }
            }
            for (java.util.Map.Entry<java.lang.String, com.airbnb.lottie.LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new com.airbnb.lottie.LottieResult<>((java.lang.Throwable) new java.lang.IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            if (str != null) {
                com.airbnb.lottie.model.LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new com.airbnb.lottie.LottieResult<>(lottieComposition);
        } catch (java.io.IOException e) {
            return new com.airbnb.lottie.LottieResult<>((java.lang.Throwable) e);
        }
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromAsset(android.content.Context context, java.lang.String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromAsset(android.content.Context context, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return b(str2, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass2(context.getApplicationContext(), str, str2));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromAssetSync(android.content.Context context, java.lang.String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromAssetSync(android.content.Context context, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return fromJsonInputStreamSync(context.getAssets().open(str), str2);
            }
            return fromZipStreamSync(new java.util.zip.ZipInputStream(context.getAssets().open(str)), str2);
        } catch (java.io.IOException e) {
            return new com.airbnb.lottie.LottieResult<>((java.lang.Throwable) e);
        }
    }

    @java.lang.Deprecated
    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromJson(org.json.JSONObject jSONObject, @androidx.annotation.Nullable java.lang.String str) {
        return b(str, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass5(jSONObject, str));
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromJsonInputStream(java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str) {
        return b(str, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass4(inputStream, str));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromJsonInputStreamSync(java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str) {
        return d(inputStream, str, true);
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromJsonReader(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, @androidx.annotation.Nullable java.lang.String str) {
        return b(str, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass7(jsonReader, str));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromJsonReaderSync(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, @androidx.annotation.Nullable java.lang.String str) {
        return e(jsonReader, str, true);
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromJsonString(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return b(str2, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass6(str, str2));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromJsonStringSync(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return fromJsonReaderSync(com.airbnb.lottie.parser.moshi.JsonReader.of(okio.Okio.buffer(okio.Okio.source(new java.io.ByteArrayInputStream(str.getBytes())))), str2);
    }

    @androidx.annotation.WorkerThread
    @java.lang.Deprecated
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromJsonSync(org.json.JSONObject jSONObject, @androidx.annotation.Nullable java.lang.String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromRawRes(android.content.Context context, @androidx.annotation.RawRes int i) {
        return fromRawRes(context, i, i(context, i));
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromRawRes(android.content.Context context, @androidx.annotation.RawRes int i, @androidx.annotation.Nullable java.lang.String str) {
        return b(str, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass3(new java.lang.ref.WeakReference(context), context.getApplicationContext(), i, str));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromRawResSync(android.content.Context context, @androidx.annotation.RawRes int i) {
        return fromRawResSync(context, i, i(context, i));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromRawResSync(android.content.Context context, @androidx.annotation.RawRes int i, @androidx.annotation.Nullable java.lang.String str) {
        try {
            okio.BufferedSource buffer = okio.Okio.buffer(okio.Okio.source(context.getResources().openRawResource(i)));
            return h(buffer).booleanValue() ? fromZipStreamSync(new java.util.zip.ZipInputStream(buffer.inputStream()), str) : fromJsonInputStreamSync(buffer.inputStream(), str);
        } catch (android.content.res.Resources.NotFoundException e) {
            return new com.airbnb.lottie.LottieResult<>((java.lang.Throwable) e);
        }
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromUrl(android.content.Context context, java.lang.String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromUrl(android.content.Context context, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return b(str2, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass1(context, str, str2));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromUrlSync(android.content.Context context, java.lang.String str) {
        return fromUrlSync(context, str, str);
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromUrlSync(android.content.Context context, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fetchSync = com.airbnb.lottie.L.networkFetcher(context).fetchSync(str, str2);
        if (str2 != null && fetchSync.getValue() != null) {
            com.airbnb.lottie.model.LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> fromZipStream(java.util.zip.ZipInputStream zipInputStream, @androidx.annotation.Nullable java.lang.String str) {
        return b(str, new com.airbnb.lottie.LottieCompositionFactory.AnonymousClass8(zipInputStream, str));
    }

    @androidx.annotation.WorkerThread
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromZipStreamSync(java.util.zip.ZipInputStream zipInputStream, @androidx.annotation.Nullable java.lang.String str) {
        try {
            return f(zipInputStream, str);
        } finally {
            com.airbnb.lottie.utils.Utils.closeQuietly(zipInputStream);
        }
    }

    public static boolean g(android.content.Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static java.lang.Boolean h(okio.BufferedSource bufferedSource) {
        try {
            okio.BufferedSource peek = bufferedSource.peek();
            for (byte b2 : b) {
                if (peek.readByte() != b2) {
                    return java.lang.Boolean.FALSE;
                }
            }
            peek.close();
            return java.lang.Boolean.TRUE;
        } catch (java.lang.Exception e) {
            com.airbnb.lottie.utils.Logger.error("Failed to check zip file header", e);
            return java.lang.Boolean.FALSE;
        }
    }

    public static java.lang.String i(android.content.Context context, @androidx.annotation.RawRes int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("rawRes");
        sb.append(g(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    public static void setMaxCacheSize(int i) {
        com.airbnb.lottie.model.LottieCompositionCache.getInstance().resize(i);
    }
}
