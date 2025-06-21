package androidx.core.provider;

/* loaded from: classes.dex */
class FontRequestWorker {
    static final androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> sTypefaceCache = new androidx.collection.LruCache<>(16);
    private static final java.util.concurrent.ExecutorService DEFAULT_EXECUTOR_SERVICE = androidx.core.provider.RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    static final java.lang.Object LOCK = new java.lang.Object();

    @androidx.annotation.GuardedBy("LOCK")
    static final androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>>> PENDING_REPLIES = new androidx.collection.SimpleArrayMap<>();

    /* renamed from: androidx.core.provider.FontRequestWorker$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<androidx.core.provider.FontRequestWorker.TypefaceResult> {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$id;
        final /* synthetic */ androidx.core.provider.FontRequest val$request;
        final /* synthetic */ int val$style;

        public AnonymousClass1(java.lang.String str, android.content.Context context, androidx.core.provider.FontRequest fontRequest, int i) {
            this.val$id = str;
            this.val$context = context;
            this.val$request = fontRequest;
            this.val$style = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public androidx.core.provider.FontRequestWorker.TypefaceResult call() {
            return androidx.core.provider.FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult> {
        final /* synthetic */ androidx.core.provider.CallbackWithHandler val$callback;

        public AnonymousClass2(androidx.core.provider.CallbackWithHandler callbackWithHandler) {
            this.val$callback = callbackWithHandler;
        }

        @Override // androidx.core.util.Consumer
        public void accept(androidx.core.provider.FontRequestWorker.TypefaceResult typefaceResult) {
            this.val$callback.onTypefaceResult(typefaceResult);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.Callable<androidx.core.provider.FontRequestWorker.TypefaceResult> {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$id;
        final /* synthetic */ androidx.core.provider.FontRequest val$request;
        final /* synthetic */ int val$style;

        public AnonymousClass3(java.lang.String str, android.content.Context context, androidx.core.provider.FontRequest fontRequest, int i) {
            this.val$id = str;
            this.val$context = context;
            this.val$request = fontRequest;
            this.val$style = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public androidx.core.provider.FontRequestWorker.TypefaceResult call() {
            return androidx.core.provider.FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult> {
        final /* synthetic */ java.lang.String val$id;

        public AnonymousClass4(java.lang.String str) {
            this.val$id = str;
        }

        @Override // androidx.core.util.Consumer
        public void accept(androidx.core.provider.FontRequestWorker.TypefaceResult typefaceResult) {
            synchronized (androidx.core.provider.FontRequestWorker.LOCK) {
                androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>>> simpleArrayMap = androidx.core.provider.FontRequestWorker.PENDING_REPLIES;
                java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>> arrayList = simpleArrayMap.get(this.val$id);
                if (arrayList == null) {
                    return;
                }
                simpleArrayMap.remove(this.val$id);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).accept(typefaceResult);
                }
            }
        }
    }

    public static final class TypefaceResult {
        final int mResult;
        final android.graphics.Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public TypefaceResult(@androidx.annotation.NonNull android.graphics.Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public boolean isSuccess() {
            return this.mResult == 0;
        }
    }

    private FontRequestWorker() {
    }

    private static java.lang.String createCacheId(@androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, int i) {
        return fontRequest.getId() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i = 1;
        if (fontFamilyResult.getStatusCode() != 0) {
            return fontFamilyResult.getStatusCode() != 1 ? -3 : -2;
        }
        androidx.core.provider.FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
        if (fonts != null && fonts.length != 0) {
            i = 0;
            for (androidx.core.provider.FontsContractCompat.FontInfo fontInfo : fonts) {
                int resultCode = fontInfo.getResultCode();
                if (resultCode != 0) {
                    if (resultCode < 0) {
                        return -3;
                    }
                    return resultCode;
                }
            }
        }
        return i;
    }

    @androidx.annotation.NonNull
    public static androidx.core.provider.FontRequestWorker.TypefaceResult getFontSync(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, int i) {
        androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> lruCache = sTypefaceCache;
        android.graphics.Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new androidx.core.provider.FontRequestWorker.TypefaceResult(typeface);
        }
        try {
            androidx.core.provider.FontsContractCompat.FontFamilyResult fontFamilyResult = androidx.core.provider.FontProvider.getFontFamilyResult(context, fontRequest, null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new androidx.core.provider.FontRequestWorker.TypefaceResult(fontFamilyResultStatus);
            }
            android.graphics.Typeface createFromFontInfo = androidx.core.graphics.TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i);
            if (createFromFontInfo == null) {
                return new androidx.core.provider.FontRequestWorker.TypefaceResult(-3);
            }
            lruCache.put(str, createFromFontInfo);
            return new androidx.core.provider.FontRequestWorker.TypefaceResult(createFromFontInfo);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return new androidx.core.provider.FontRequestWorker.TypefaceResult(-1);
        }
    }

    public static android.graphics.Typeface requestFontAsync(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, int i, @androidx.annotation.Nullable java.util.concurrent.Executor executor, @androidx.annotation.NonNull androidx.core.provider.CallbackWithHandler callbackWithHandler) {
        java.lang.String createCacheId = createCacheId(fontRequest, i);
        android.graphics.Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new androidx.core.provider.FontRequestWorker.TypefaceResult(typeface));
            return typeface;
        }
        androidx.core.provider.FontRequestWorker.AnonymousClass2 anonymousClass2 = new androidx.core.provider.FontRequestWorker.AnonymousClass2(callbackWithHandler);
        synchronized (LOCK) {
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>>> simpleArrayMap = PENDING_REPLIES;
            java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>> arrayList = simpleArrayMap.get(createCacheId);
            if (arrayList != null) {
                arrayList.add(anonymousClass2);
                return null;
            }
            java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker.TypefaceResult>> arrayList2 = new java.util.ArrayList<>();
            arrayList2.add(anonymousClass2);
            simpleArrayMap.put(createCacheId, arrayList2);
            androidx.core.provider.FontRequestWorker.AnonymousClass3 anonymousClass3 = new androidx.core.provider.FontRequestWorker.AnonymousClass3(createCacheId, context, fontRequest, i);
            if (executor == null) {
                executor = DEFAULT_EXECUTOR_SERVICE;
            }
            androidx.core.provider.RequestExecutor.execute(executor, anonymousClass3, new androidx.core.provider.FontRequestWorker.AnonymousClass4(createCacheId));
            return null;
        }
    }

    public static android.graphics.Typeface requestFontSync(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, @androidx.annotation.NonNull androidx.core.provider.CallbackWithHandler callbackWithHandler, int i, int i2) {
        java.lang.String createCacheId = createCacheId(fontRequest, i);
        android.graphics.Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new androidx.core.provider.FontRequestWorker.TypefaceResult(typeface));
            return typeface;
        }
        if (i2 == -1) {
            androidx.core.provider.FontRequestWorker.TypefaceResult fontSync = getFontSync(createCacheId, context, fontRequest, i);
            callbackWithHandler.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        try {
            androidx.core.provider.FontRequestWorker.TypefaceResult typefaceResult = (androidx.core.provider.FontRequestWorker.TypefaceResult) androidx.core.provider.RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new androidx.core.provider.FontRequestWorker.AnonymousClass1(createCacheId, context, fontRequest, i), i2);
            callbackWithHandler.onTypefaceResult(typefaceResult);
            return typefaceResult.mTypeface;
        } catch (java.lang.InterruptedException unused) {
            callbackWithHandler.onTypefaceResult(new androidx.core.provider.FontRequestWorker.TypefaceResult(-3));
            return null;
        }
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}
