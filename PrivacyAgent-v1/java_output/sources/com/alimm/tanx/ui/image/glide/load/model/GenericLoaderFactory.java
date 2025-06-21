package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class GenericLoaderFactory {
    private static final com.alimm.tanx.ui.image.glide.load.model.ModelLoader NULL_MODEL_LOADER = new com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory.AnonymousClass1();
    private final android.content.Context context;
    private final java.util.Map<java.lang.Class, java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory>> modelClassToResourceFactories = new java.util.HashMap();
    private final java.util.Map<java.lang.Class, java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoader>> cachedModelLoaders = new java.util.HashMap();

    /* renamed from: com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
        public com.alimm.tanx.ui.image.glide.load.data.DataFetcher getResourceFetcher(java.lang.Object obj, int i, int i2) {
            throw new java.lang.NoSuchMethodError("This should never be called!");
        }

        public java.lang.String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public GenericLoaderFactory(android.content.Context context) {
        this.context = context.getApplicationContext();
    }

    private <T, Y> void cacheModelLoader(java.lang.Class<T> cls, java.lang.Class<Y> cls2, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> modelLoader) {
        java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoader> map = this.cachedModelLoaders.get(cls);
        if (map == null) {
            map = new java.util.HashMap<>();
            this.cachedModelLoaders.put(cls, map);
        }
        map.put(cls2, modelLoader);
    }

    private <T, Y> void cacheNullLoader(java.lang.Class<T> cls, java.lang.Class<Y> cls2) {
        cacheModelLoader(cls, cls2, NULL_MODEL_LOADER);
    }

    private <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> getCachedLoader(java.lang.Class<T> cls, java.lang.Class<Y> cls2) {
        java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoader> map = this.cachedModelLoaders.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> getFactory(java.lang.Class<T> cls, java.lang.Class<Y> cls2) {
        java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory> map;
        java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory> map2 = this.modelClassToResourceFactories.get(cls);
        com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory modelLoaderFactory = map2 != null ? map2.get(cls2) : null;
        if (modelLoaderFactory == null) {
            for (java.lang.Class cls3 : this.modelClassToResourceFactories.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.modelClassToResourceFactories.get(cls3)) != null && (modelLoaderFactory = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return modelLoaderFactory;
    }

    public synchronized <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> buildModelLoader(java.lang.Class<T> cls, java.lang.Class<Y> cls2) {
        com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> cachedLoader = getCachedLoader(cls, cls2);
        if (cachedLoader != null) {
            if (NULL_MODEL_LOADER.equals(cachedLoader)) {
                return null;
            }
            return cachedLoader;
        }
        com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> factory = getFactory(cls, cls2);
        if (factory != null) {
            cachedLoader = factory.build(this.context, this);
            cacheModelLoader(cls, cls2, cachedLoader);
        } else {
            cacheNullLoader(cls, cls2);
        }
        return cachedLoader;
    }

    @java.lang.Deprecated
    public synchronized <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> buildModelLoader(java.lang.Class<T> cls, java.lang.Class<Y> cls2, android.content.Context context) {
        return buildModelLoader(cls, cls2);
    }

    public synchronized <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> register(java.lang.Class<T> cls, java.lang.Class<Y> cls2, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> modelLoaderFactory) {
        com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> put;
        this.cachedModelLoaders.clear();
        java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory> map = this.modelClassToResourceFactories.get(cls);
        if (map == null) {
            map = new java.util.HashMap<>();
            this.modelClassToResourceFactories.put(cls, map);
        }
        put = map.put(cls2, modelLoaderFactory);
        if (put != null) {
            java.util.Iterator<java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory>> it = this.modelClassToResourceFactories.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().containsValue(put)) {
                    put = null;
                    break;
                }
            }
        }
        return put;
    }

    public synchronized <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> unregister(java.lang.Class<T> cls, java.lang.Class<Y> cls2) {
        java.util.Map<java.lang.Class, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory> map;
        this.cachedModelLoaders.clear();
        map = this.modelClassToResourceFactories.get(cls);
        return map != null ? map.remove(cls2) : null;
    }
}
