package com.badlogic.gdx.assets;

/* loaded from: classes12.dex */
public class AssetManager implements com.badlogic.gdx.utils.Disposable {
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer>> a;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Class> b;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.utils.Array<java.lang.String>> c;
    public final com.badlogic.gdx.utils.ObjectSet<java.lang.String> d;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.loaders.AssetLoader>> e;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> f;
    public final com.badlogic.gdx.utils.async.AsyncExecutor g;
    public final java.util.Stack<com.badlogic.gdx.assets.AssetLoadingTask> h;
    public com.badlogic.gdx.assets.AssetErrorListener i;
    public int j;
    public int k;
    public int l;
    public final com.badlogic.gdx.assets.loaders.FileHandleResolver m;
    public com.badlogic.gdx.utils.Logger n;

    public AssetManager() {
        this(new com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver());
    }

    public AssetManager(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        this(fileHandleResolver, true);
    }

    public AssetManager(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver, boolean z) {
        this.a = new com.badlogic.gdx.utils.ObjectMap<>();
        this.b = new com.badlogic.gdx.utils.ObjectMap<>();
        this.c = new com.badlogic.gdx.utils.ObjectMap<>();
        this.d = new com.badlogic.gdx.utils.ObjectSet<>();
        this.e = new com.badlogic.gdx.utils.ObjectMap<>();
        this.f = new com.badlogic.gdx.utils.Array<>();
        this.h = new java.util.Stack<>();
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.n = new com.badlogic.gdx.utils.Logger("AssetManager", 0);
        this.m = fileHandleResolver;
        if (z) {
            setLoader(com.badlogic.gdx.graphics.g2d.BitmapFont.class, new com.badlogic.gdx.assets.loaders.BitmapFontLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.graphics.Pixmap.class, new com.badlogic.gdx.assets.loaders.PixmapLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.graphics.g2d.TextureAtlas.class, new com.badlogic.gdx.assets.loaders.TextureAtlasLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.graphics.Texture.class, new com.badlogic.gdx.assets.loaders.TextureLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.scenes.scene2d.ui.Skin.class, new com.badlogic.gdx.assets.loaders.SkinLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.graphics.g2d.ParticleEffect.class, new com.badlogic.gdx.assets.loaders.ParticleEffectLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.graphics.g2d.PolygonRegion.class, new com.badlogic.gdx.graphics.g2d.PolygonRegionLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.utils.I18NBundle.class, new com.badlogic.gdx.assets.loaders.I18NBundleLoader(fileHandleResolver));
            setLoader(com.badlogic.gdx.graphics.glutils.ShaderProgram.class, new com.badlogic.gdx.assets.loaders.ShaderProgramLoader(fileHandleResolver));
        }
        this.g = new com.badlogic.gdx.utils.async.AsyncExecutor(1);
    }

    public final void a(com.badlogic.gdx.assets.AssetDescriptor assetDescriptor) {
        com.badlogic.gdx.assets.loaders.AssetLoader loader = getLoader(assetDescriptor.type, assetDescriptor.fileName);
        if (loader != null) {
            this.h.push(new com.badlogic.gdx.assets.AssetLoadingTask(this, assetDescriptor, loader, this.g));
            this.l++;
        } else {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No loader for type: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(assetDescriptor.type));
        }
    }

    public <T> void addAsset(java.lang.String str, java.lang.Class<T> cls, T t) {
        this.b.put(str, cls);
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(cls);
        if (objectMap == null) {
            objectMap = new com.badlogic.gdx.utils.ObjectMap<>();
            this.a.put(cls, objectMap);
        }
        objectMap.put(str, new com.badlogic.gdx.assets.RefCountedContainer(t));
    }

    public final void b(java.lang.Throwable th) {
        this.n.error("Error loading asset.", th);
        if (this.h.isEmpty()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException(th);
        }
        com.badlogic.gdx.assets.AssetLoadingTask pop = this.h.pop();
        com.badlogic.gdx.assets.AssetDescriptor assetDescriptor = pop.b;
        if (pop.g && pop.h != null) {
            java.util.Iterator<com.badlogic.gdx.assets.AssetDescriptor> it = pop.h.iterator();
            while (it.hasNext()) {
                unload(it.next().fileName);
            }
        }
        this.h.clear();
        com.badlogic.gdx.assets.AssetErrorListener assetErrorListener = this.i;
        if (assetErrorListener == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException(th);
        }
        assetErrorListener.error(assetDescriptor, th);
    }

    public final void c(java.lang.String str) {
        com.badlogic.gdx.utils.Array<java.lang.String> array = this.c.get(str);
        if (array == null) {
            return;
        }
        java.util.Iterator<java.lang.String> it = array.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            this.a.get(this.b.get(next)).get(next).incRefCount();
            c(next);
        }
    }

    public synchronized void clear() {
        this.f.clear();
        while (!update()) {
        }
        com.badlogic.gdx.utils.ObjectIntMap objectIntMap = new com.badlogic.gdx.utils.ObjectIntMap();
        while (this.b.size > 0) {
            objectIntMap.clear();
            com.badlogic.gdx.utils.Array<java.lang.String> array = this.b.keys().toArray();
            java.util.Iterator<java.lang.String> it = array.iterator();
            while (it.hasNext()) {
                objectIntMap.put(it.next(), 0);
            }
            java.util.Iterator<java.lang.String> it2 = array.iterator();
            while (it2.hasNext()) {
                com.badlogic.gdx.utils.Array<java.lang.String> array2 = this.c.get(it2.next());
                if (array2 != null) {
                    java.util.Iterator<java.lang.String> it3 = array2.iterator();
                    while (it3.hasNext()) {
                        java.lang.String next = it3.next();
                        objectIntMap.put(next, objectIntMap.get(next, 0) + 1);
                    }
                }
            }
            java.util.Iterator<java.lang.String> it4 = array.iterator();
            while (it4.hasNext()) {
                java.lang.String next2 = it4.next();
                if (objectIntMap.get(next2, 0) == 0) {
                    unload(next2);
                }
            }
        }
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f.clear();
        this.h.clear();
    }

    public synchronized <T> boolean containsAsset(T t) {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(t.getClass());
        if (objectMap == null) {
            return false;
        }
        com.badlogic.gdx.utils.ObjectMap.Keys<java.lang.String> it = objectMap.keys().iterator();
        while (it.hasNext()) {
            java.lang.Object object = objectMap.get(it.next()).getObject(java.lang.Object.class);
            if (object == t || t.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void d(java.lang.String str, com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array) {
        com.badlogic.gdx.utils.ObjectSet<java.lang.String> objectSet = this.d;
        java.util.Iterator<com.badlogic.gdx.assets.AssetDescriptor> it = array.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.assets.AssetDescriptor next = it.next();
            if (!objectSet.contains(next.fileName)) {
                objectSet.add(next.fileName);
                e(str, next);
            }
        }
        objectSet.clear();
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public synchronized void dispose() {
        this.n.debug("Disposing.");
        clear();
        this.g.dispose();
    }

    public final synchronized void e(java.lang.String str, com.badlogic.gdx.assets.AssetDescriptor assetDescriptor) {
        com.badlogic.gdx.utils.Array<java.lang.String> array = this.c.get(str);
        if (array == null) {
            array = new com.badlogic.gdx.utils.Array<>();
            this.c.put(str, array);
        }
        array.add(assetDescriptor.fileName);
        if (isLoaded(assetDescriptor.fileName)) {
            this.n.debug("Dependency already loaded: " + assetDescriptor);
            this.a.get(this.b.get(assetDescriptor.fileName)).get(assetDescriptor.fileName).incRefCount();
            c(assetDescriptor.fileName);
        } else {
            this.n.info("Loading dependency: " + assetDescriptor);
            a(assetDescriptor);
        }
    }

    public final void f() {
        com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback loadedCallback;
        com.badlogic.gdx.assets.AssetDescriptor removeIndex = this.f.removeIndex(0);
        if (!isLoaded(removeIndex.fileName)) {
            this.n.info("Loading: " + removeIndex);
            a(removeIndex);
            return;
        }
        this.n.debug("Already loaded: " + removeIndex);
        this.a.get(this.b.get(removeIndex.fileName)).get(removeIndex.fileName).incRefCount();
        c(removeIndex.fileName);
        com.badlogic.gdx.assets.AssetLoaderParameters assetLoaderParameters = removeIndex.params;
        if (assetLoaderParameters != null && (loadedCallback = assetLoaderParameters.loadedCallback) != null) {
            loadedCallback.finishedLoading(this, removeIndex.fileName, removeIndex.type);
        }
        this.j++;
    }

    public void finishLoading() {
        this.n.debug("Waiting for loading to complete...");
        while (!update()) {
            com.badlogic.gdx.utils.async.ThreadUtils.yield();
        }
        this.n.debug("Loading complete.");
    }

    public void finishLoadingAsset(java.lang.String str) {
        this.n.debug("Waiting for asset to be loaded: " + str);
        while (!isLoaded(str)) {
            update();
            com.badlogic.gdx.utils.async.ThreadUtils.yield();
        }
        this.n.debug("Asset loaded: " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g() {
        boolean z;
        com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback loadedCallback;
        com.badlogic.gdx.assets.AssetLoadingTask peek = this.h.peek();
        try {
        } catch (java.lang.RuntimeException e) {
            peek.m = true;
            taskFailed(peek.b, e);
        }
        if (!peek.m) {
            if (!peek.update()) {
                z = false;
                if (z) {
                    return false;
                }
                if (this.h.size() == 1) {
                    this.j++;
                    this.l = 0;
                }
                this.h.pop();
                if (peek.m) {
                    return true;
                }
                com.badlogic.gdx.assets.AssetDescriptor assetDescriptor = peek.b;
                addAsset(assetDescriptor.fileName, assetDescriptor.type, peek.a());
                com.badlogic.gdx.assets.AssetDescriptor assetDescriptor2 = peek.b;
                com.badlogic.gdx.assets.AssetLoaderParameters assetLoaderParameters = assetDescriptor2.params;
                if (assetLoaderParameters != null && (loadedCallback = assetLoaderParameters.loadedCallback) != null) {
                    loadedCallback.finishedLoading(this, assetDescriptor2.fileName, assetDescriptor2.type);
                }
                long nanoTime = com.badlogic.gdx.utils.TimeUtils.nanoTime();
                this.n.debug("Loaded: " + ((nanoTime - peek.e) / 1000000.0f) + "ms " + peek.b);
                return true;
            }
        }
        z = true;
        if (z) {
        }
    }

    public synchronized <T> T get(com.badlogic.gdx.assets.AssetDescriptor<T> assetDescriptor) {
        return (T) get(assetDescriptor.fileName, assetDescriptor.type);
    }

    public synchronized <T> T get(java.lang.String str) {
        T t;
        java.lang.Class<T> cls = this.b.get(str);
        if (cls == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(cls);
        if (objectMap == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        com.badlogic.gdx.assets.RefCountedContainer refCountedContainer = objectMap.get(str);
        if (refCountedContainer == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        t = (T) refCountedContainer.getObject(cls);
        if (t == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        return t;
    }

    public synchronized <T> T get(java.lang.String str, java.lang.Class<T> cls) {
        T t;
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(cls);
        if (objectMap == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        com.badlogic.gdx.assets.RefCountedContainer refCountedContainer = objectMap.get(str);
        if (refCountedContainer == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        t = (T) refCountedContainer.getObject(cls);
        if (t == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized <T> com.badlogic.gdx.utils.Array<T> getAll(java.lang.Class<T> cls, com.badlogic.gdx.utils.Array<T> array) {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(cls);
        if (objectMap != null) {
            com.badlogic.gdx.utils.ObjectMap.Entries<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> it = objectMap.entries().iterator();
            while (it.hasNext()) {
                array.add(((com.badlogic.gdx.assets.RefCountedContainer) it.next().value).getObject(cls));
            }
        }
        return array;
    }

    public synchronized <T> java.lang.String getAssetFileName(T t) {
        com.badlogic.gdx.utils.ObjectMap.Keys<java.lang.Class> it = this.a.keys().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(it.next());
            com.badlogic.gdx.utils.ObjectMap.Keys<java.lang.String> it2 = objectMap.keys().iterator();
            while (it2.hasNext()) {
                java.lang.String next = it2.next();
                java.lang.Object object = objectMap.get(next).getObject(java.lang.Object.class);
                if (object == t || t.equals(object)) {
                    return next;
                }
            }
        }
        return null;
    }

    public synchronized com.badlogic.gdx.utils.Array<java.lang.String> getAssetNames() {
        return this.b.keys().toArray();
    }

    public synchronized java.lang.Class getAssetType(java.lang.String str) {
        return this.b.get(str);
    }

    public synchronized com.badlogic.gdx.utils.Array<java.lang.String> getDependencies(java.lang.String str) {
        return this.c.get(str);
    }

    public synchronized java.lang.String getDiagnostics() {
        java.lang.StringBuffer stringBuffer;
        stringBuffer = new java.lang.StringBuffer();
        com.badlogic.gdx.utils.ObjectMap.Keys<java.lang.String> it = this.b.keys().iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            stringBuffer.append(next);
            stringBuffer.append(", ");
            java.lang.Class cls = this.b.get(next);
            com.badlogic.gdx.assets.RefCountedContainer refCountedContainer = this.a.get(cls).get(next);
            com.badlogic.gdx.utils.Array<java.lang.String> array = this.c.get(next);
            stringBuffer.append(com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls));
            stringBuffer.append(", refs: ");
            stringBuffer.append(refCountedContainer.getRefCount());
            if (array != null) {
                stringBuffer.append(", deps: [");
                java.util.Iterator<java.lang.String> it2 = array.iterator();
                while (it2.hasNext()) {
                    stringBuffer.append(it2.next());
                    stringBuffer.append(",");
                }
                stringBuffer.append("]");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public com.badlogic.gdx.assets.loaders.FileHandleResolver getFileHandleResolver() {
        return this.m;
    }

    public synchronized int getLoadedAssets() {
        return this.b.size;
    }

    public <T> com.badlogic.gdx.assets.loaders.AssetLoader getLoader(java.lang.Class<T> cls) {
        return getLoader(cls, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> com.badlogic.gdx.assets.loaders.AssetLoader getLoader(java.lang.Class<T> cls, java.lang.String str) {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.loaders.AssetLoader> objectMap = this.e.get(cls);
        com.badlogic.gdx.assets.loaders.AssetLoader assetLoader = null;
        if (objectMap != null && objectMap.size >= 1) {
            if (str == null) {
                return objectMap.get("");
            }
            com.badlogic.gdx.utils.ObjectMap.Entries<java.lang.String, com.badlogic.gdx.assets.loaders.AssetLoader> it = objectMap.entries().iterator();
            int i = -1;
            while (it.hasNext()) {
                com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
                if (((java.lang.String) next.key).length() > i && str.endsWith((java.lang.String) next.key)) {
                    assetLoader = (com.badlogic.gdx.assets.loaders.AssetLoader) next.value;
                    i = ((java.lang.String) next.key).length();
                }
            }
        }
        return assetLoader;
    }

    public com.badlogic.gdx.utils.Logger getLogger() {
        return this.n;
    }

    public synchronized float getProgress() {
        if (this.k == 0) {
            return 1.0f;
        }
        float f = this.j;
        if (this.l > 0) {
            f += (r2 - this.h.size()) / this.l;
        }
        return java.lang.Math.min(1.0f, f / this.k);
    }

    public synchronized int getQueuedAssets() {
        return this.f.size + this.h.size();
    }

    public synchronized int getReferenceCount(java.lang.String str) {
        java.lang.Class cls;
        cls = this.b.get(str);
        if (cls == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        return this.a.get(cls).get(str).getRefCount();
    }

    public synchronized boolean isLoaded(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return this.b.containsKey(str);
    }

    public synchronized boolean isLoaded(java.lang.String str, java.lang.Class cls) {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.RefCountedContainer> objectMap = this.a.get(cls);
        if (objectMap == null) {
            return false;
        }
        com.badlogic.gdx.assets.RefCountedContainer refCountedContainer = objectMap.get(str);
        if (refCountedContainer == null) {
            return false;
        }
        return refCountedContainer.getObject(cls) != null;
    }

    public synchronized void load(com.badlogic.gdx.assets.AssetDescriptor assetDescriptor) {
        load(assetDescriptor.fileName, assetDescriptor.type, assetDescriptor.params);
    }

    public synchronized <T> void load(java.lang.String str, java.lang.Class<T> cls) {
        load(str, cls, null);
    }

    public synchronized <T> void load(java.lang.String str, java.lang.Class<T> cls, com.badlogic.gdx.assets.AssetLoaderParameters<T> assetLoaderParameters) {
        if (getLoader(cls, str) == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No loader for type: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls));
        }
        if (this.f.size == 0) {
            this.j = 0;
            this.k = 0;
            this.l = 0;
        }
        int i = 0;
        while (true) {
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = this.f;
            if (i < array.size) {
                com.badlogic.gdx.assets.AssetDescriptor assetDescriptor = array.get(i);
                if (assetDescriptor.fileName.equals(str) && !assetDescriptor.type.equals(cls)) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls) + ", found: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(assetDescriptor.type) + ")");
                }
                i++;
            } else {
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    com.badlogic.gdx.assets.AssetDescriptor assetDescriptor2 = this.h.get(i2).b;
                    if (assetDescriptor2.fileName.equals(str) && !assetDescriptor2.type.equals(cls)) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls) + ", found: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(assetDescriptor2.type) + ")");
                    }
                }
                java.lang.Class cls2 = this.b.get(str);
                if (cls2 != null && !cls2.equals(cls)) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls) + ", found: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls2) + ")");
                }
                this.k++;
                com.badlogic.gdx.assets.AssetDescriptor assetDescriptor3 = new com.badlogic.gdx.assets.AssetDescriptor(str, cls, assetLoaderParameters);
                this.f.add(assetDescriptor3);
                this.n.debug("Queued: " + assetDescriptor3);
            }
        }
    }

    public synchronized void setErrorListener(com.badlogic.gdx.assets.AssetErrorListener assetErrorListener) {
        this.i = assetErrorListener;
    }

    public synchronized <T, P extends com.badlogic.gdx.assets.AssetLoaderParameters<T>> void setLoader(java.lang.Class<T> cls, com.badlogic.gdx.assets.loaders.AssetLoader<T, P> assetLoader) {
        setLoader(cls, null, assetLoader);
    }

    public synchronized <T, P extends com.badlogic.gdx.assets.AssetLoaderParameters<T>> void setLoader(java.lang.Class<T> cls, java.lang.String str, com.badlogic.gdx.assets.loaders.AssetLoader<T, P> assetLoader) {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("type cannot be null.");
        }
        if (assetLoader == null) {
            throw new java.lang.IllegalArgumentException("loader cannot be null.");
        }
        this.n.debug("Loader set: " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls) + " -> " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(assetLoader.getClass()));
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.loaders.AssetLoader> objectMap = this.e.get(cls);
        if (objectMap == null) {
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.loaders.AssetLoader>> objectMap2 = this.e;
            com.badlogic.gdx.utils.ObjectMap<java.lang.String, com.badlogic.gdx.assets.loaders.AssetLoader> objectMap3 = new com.badlogic.gdx.utils.ObjectMap<>();
            objectMap2.put(cls, objectMap3);
            objectMap = objectMap3;
        }
        if (str == null) {
            str = "";
        }
        objectMap.put(str, assetLoader);
    }

    public void setLogger(com.badlogic.gdx.utils.Logger logger) {
        this.n = logger;
    }

    public synchronized void setReferenceCount(java.lang.String str, int i) {
        java.lang.Class cls = this.b.get(str);
        if (cls == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        this.a.get(cls).get(str).setRefCount(i);
    }

    public void taskFailed(com.badlogic.gdx.assets.AssetDescriptor assetDescriptor, java.lang.RuntimeException runtimeException) {
        throw runtimeException;
    }

    public synchronized void unload(java.lang.String str) {
        if (this.h.size() > 0) {
            com.badlogic.gdx.assets.AssetLoadingTask firstElement = this.h.firstElement();
            if (firstElement.b.fileName.equals(str)) {
                firstElement.m = true;
                this.n.debug("Unload (from tasks): " + str);
                return;
            }
        }
        int i = 0;
        while (true) {
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = this.f;
            if (i >= array.size) {
                i = -1;
                break;
            } else if (array.get(i).fileName.equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.k--;
            this.f.removeIndex(i);
            this.n.debug("Unload (from queue): " + str);
            return;
        }
        java.lang.Class cls = this.b.get(str);
        if (cls == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Asset not loaded: " + str);
        }
        com.badlogic.gdx.assets.RefCountedContainer refCountedContainer = this.a.get(cls).get(str);
        refCountedContainer.decRefCount();
        if (refCountedContainer.getRefCount() <= 0) {
            this.n.debug("Unload (dispose): " + str);
            if (refCountedContainer.getObject(java.lang.Object.class) instanceof com.badlogic.gdx.utils.Disposable) {
                ((com.badlogic.gdx.utils.Disposable) refCountedContainer.getObject(java.lang.Object.class)).dispose();
            }
            this.b.remove(str);
            this.a.get(cls).remove(str);
        } else {
            this.n.debug("Unload (decrement): " + str);
        }
        com.badlogic.gdx.utils.Array<java.lang.String> array2 = this.c.get(str);
        if (array2 != null) {
            java.util.Iterator<java.lang.String> it = array2.iterator();
            while (it.hasNext()) {
                java.lang.String next = it.next();
                if (isLoaded(next)) {
                    unload(next);
                }
            }
        }
        if (refCountedContainer.getRefCount() <= 0) {
            this.c.remove(str);
        }
    }

    public synchronized boolean update() {
        boolean z = false;
        try {
            if (this.h.size() == 0) {
                while (this.f.size != 0 && this.h.size() == 0) {
                    f();
                }
                if (this.h.size() == 0) {
                    return true;
                }
            }
            if (g() && this.f.size == 0) {
                if (this.h.size() == 0) {
                    z = true;
                }
            }
            return z;
        } catch (java.lang.Throwable th) {
            b(th);
            return this.f.size == 0;
        }
    }

    public boolean update(int i) {
        boolean update;
        long millis = com.badlogic.gdx.utils.TimeUtils.millis() + i;
        while (true) {
            update = update();
            if (update || com.badlogic.gdx.utils.TimeUtils.millis() > millis) {
                break;
            }
            com.badlogic.gdx.utils.async.ThreadUtils.yield();
        }
        return update;
    }
}
