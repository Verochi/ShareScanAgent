package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieComposition {
    public java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.model.layer.Layer>> c;
    public java.util.Map<java.lang.String, com.airbnb.lottie.LottieImageAsset> d;
    public java.util.Map<java.lang.String, com.airbnb.lottie.model.Font> e;
    public java.util.List<com.airbnb.lottie.model.Marker> f;
    public androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> g;
    public androidx.collection.LongSparseArray<com.airbnb.lottie.model.layer.Layer> h;
    public java.util.List<com.airbnb.lottie.model.layer.Layer> i;
    public android.graphics.Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public final com.airbnb.lottie.PerformanceTracker a = new com.airbnb.lottie.PerformanceTracker();
    public final java.util.HashSet<java.lang.String> b = new java.util.HashSet<>();
    public int o = 0;

    @java.lang.Deprecated
    public static class Factory {

        public static final class ListenerAdapter implements com.airbnb.lottie.LottieListener<com.airbnb.lottie.LottieComposition>, com.airbnb.lottie.Cancellable {
            public final com.airbnb.lottie.OnCompositionLoadedListener a;
            public boolean b;

            public ListenerAdapter(com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener) {
                this.b = false;
                this.a = onCompositionLoadedListener;
            }

            public /* synthetic */ ListenerAdapter(com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener, com.airbnb.lottie.LottieComposition.AnonymousClass1 anonymousClass1) {
                this(onCompositionLoadedListener);
            }

            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(com.airbnb.lottie.LottieComposition lottieComposition) {
                if (this.b) {
                    return;
                }
                this.a.onCompositionLoaded(lottieComposition);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.b = true;
            }
        }

        @java.lang.Deprecated
        public static com.airbnb.lottie.Cancellable fromAssetFileName(android.content.Context context, java.lang.String str, com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener) {
            com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter listenerAdapter = new com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter(onCompositionLoadedListener, null);
            com.airbnb.lottie.LottieCompositionFactory.fromAsset(context, str).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.WorkerThread
        @java.lang.Deprecated
        public static com.airbnb.lottie.LottieComposition fromFileSync(android.content.Context context, java.lang.String str) {
            return com.airbnb.lottie.LottieCompositionFactory.fromAssetSync(context, str).getValue();
        }

        @java.lang.Deprecated
        public static com.airbnb.lottie.Cancellable fromInputStream(java.io.InputStream inputStream, com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener) {
            com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter listenerAdapter = new com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter(onCompositionLoadedListener, null);
            com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.WorkerThread
        @java.lang.Deprecated
        public static com.airbnb.lottie.LottieComposition fromInputStreamSync(java.io.InputStream inputStream) {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @androidx.annotation.Nullable
        @androidx.annotation.WorkerThread
        @java.lang.Deprecated
        public static com.airbnb.lottie.LottieComposition fromInputStreamSync(java.io.InputStream inputStream, boolean z) {
            if (z) {
                com.airbnb.lottie.utils.Logger.warning("Lottie now auto-closes input stream!");
            }
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @java.lang.Deprecated
        public static com.airbnb.lottie.Cancellable fromJsonReader(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener) {
            com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter listenerAdapter = new com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter(onCompositionLoadedListener, null);
            com.airbnb.lottie.LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @java.lang.Deprecated
        public static com.airbnb.lottie.Cancellable fromJsonString(java.lang.String str, com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener) {
            com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter listenerAdapter = new com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter(onCompositionLoadedListener, null);
            com.airbnb.lottie.LottieCompositionFactory.fromJsonString(str, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.WorkerThread
        @java.lang.Deprecated
        public static com.airbnb.lottie.LottieComposition fromJsonSync(android.content.res.Resources resources, org.json.JSONObject jSONObject) {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue();
        }

        @androidx.annotation.Nullable
        @androidx.annotation.WorkerThread
        @java.lang.Deprecated
        public static com.airbnb.lottie.LottieComposition fromJsonSync(com.airbnb.lottie.parser.moshi.JsonReader jsonReader) {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue();
        }

        @androidx.annotation.Nullable
        @androidx.annotation.WorkerThread
        @java.lang.Deprecated
        public static com.airbnb.lottie.LottieComposition fromJsonSync(java.lang.String str) {
            return com.airbnb.lottie.LottieCompositionFactory.fromJsonStringSync(str, null).getValue();
        }

        @java.lang.Deprecated
        public static com.airbnb.lottie.Cancellable fromRawFile(android.content.Context context, @androidx.annotation.RawRes int i, com.airbnb.lottie.OnCompositionLoadedListener onCompositionLoadedListener) {
            com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter listenerAdapter = new com.airbnb.lottie.LottieComposition.Factory.ListenerAdapter(onCompositionLoadedListener, null);
            com.airbnb.lottie.LottieCompositionFactory.fromRawRes(context, i).addListener(listenerAdapter);
            return listenerAdapter;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void addWarning(java.lang.String str) {
        com.airbnb.lottie.utils.Logger.warning(str);
        this.b.add(str);
    }

    public android.graphics.Rect getBounds() {
        return this.j;
    }

    public androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> getCharacters() {
        return this.g;
    }

    public float getDuration() {
        return (long) ((getDurationFrames() / this.m) * 1000.0f);
    }

    public float getDurationFrames() {
        return this.l - this.k;
    }

    public float getEndFrame() {
        return this.l;
    }

    public java.util.Map<java.lang.String, com.airbnb.lottie.model.Font> getFonts() {
        return this.e;
    }

    public float getFrameRate() {
        return this.m;
    }

    public java.util.Map<java.lang.String, com.airbnb.lottie.LottieImageAsset> getImages() {
        return this.d;
    }

    public java.util.List<com.airbnb.lottie.model.layer.Layer> getLayers() {
        return this.i;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.Marker getMarker(java.lang.String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            com.airbnb.lottie.model.Marker marker = this.f.get(i);
            if (marker.matchesName(str)) {
                return marker;
            }
        }
        return null;
    }

    public java.util.List<com.airbnb.lottie.model.Marker> getMarkers() {
        return this.f;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public int getMaskAndMatteCount() {
        return this.o;
    }

    public com.airbnb.lottie.PerformanceTracker getPerformanceTracker() {
        return this.a;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public java.util.List<com.airbnb.lottie.model.layer.Layer> getPrecomps(java.lang.String str) {
        return this.c.get(str);
    }

    public float getStartFrame() {
        return this.k;
    }

    public java.util.ArrayList<java.lang.String> getWarnings() {
        java.util.HashSet<java.lang.String> hashSet = this.b;
        return new java.util.ArrayList<>(java.util.Arrays.asList(hashSet.toArray(new java.lang.String[hashSet.size()])));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean hasDashPattern() {
        return this.n;
    }

    public boolean hasImages() {
        return !this.d.isEmpty();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void incrementMatteOrMaskCount(int i) {
        this.o += i;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void init(android.graphics.Rect rect, float f, float f2, float f3, java.util.List<com.airbnb.lottie.model.layer.Layer> list, androidx.collection.LongSparseArray<com.airbnb.lottie.model.layer.Layer> longSparseArray, java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.model.layer.Layer>> map, java.util.Map<java.lang.String, com.airbnb.lottie.LottieImageAsset> map2, androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> sparseArrayCompat, java.util.Map<java.lang.String, com.airbnb.lottie.model.Font> map3, java.util.List<com.airbnb.lottie.model.Marker> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = longSparseArray;
        this.c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.airbnb.lottie.model.layer.Layer layerModelForId(long j) {
        return this.h.get(j);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void setHasDashPattern(boolean z) {
        this.n = z;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.a.a(z);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("LottieComposition:\n");
        java.util.Iterator<com.airbnb.lottie.model.layer.Layer> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString("\t"));
        }
        return sb.toString();
    }
}
