package com.badlogic.gdx.assets;

/* loaded from: classes12.dex */
class AssetLoadingTask implements com.badlogic.gdx.utils.async.AsyncTask<java.lang.Void> {
    public com.badlogic.gdx.assets.AssetManager a;
    public final com.badlogic.gdx.assets.AssetDescriptor b;
    public final com.badlogic.gdx.assets.loaders.AssetLoader c;
    public final com.badlogic.gdx.utils.async.AsyncExecutor d;
    public final long e;
    public volatile com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> h;
    public volatile boolean f = false;
    public volatile boolean g = false;
    public volatile com.badlogic.gdx.utils.async.AsyncResult<java.lang.Void> i = null;
    public volatile com.badlogic.gdx.utils.async.AsyncResult<java.lang.Void> j = null;
    public volatile java.lang.Object k = null;
    public int l = 0;
    public volatile boolean m = false;

    public AssetLoadingTask(com.badlogic.gdx.assets.AssetManager assetManager, com.badlogic.gdx.assets.AssetDescriptor assetDescriptor, com.badlogic.gdx.assets.loaders.AssetLoader assetLoader, com.badlogic.gdx.utils.async.AsyncExecutor asyncExecutor) {
        this.a = assetManager;
        this.b = assetDescriptor;
        this.c = assetLoader;
        this.d = asyncExecutor;
        this.e = assetManager.n.getLevel() == 3 ? com.badlogic.gdx.utils.TimeUtils.nanoTime() : 0L;
    }

    public java.lang.Object a() {
        return this.k;
    }

    public final void b() {
        com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader asynchronousAssetLoader = (com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader) this.c;
        if (!this.g) {
            if (this.i == null) {
                this.i = this.d.submit(this);
                return;
            }
            if (this.i.isDone()) {
                try {
                    this.i.get();
                    this.g = true;
                    if (this.f) {
                        com.badlogic.gdx.assets.AssetManager assetManager = this.a;
                        com.badlogic.gdx.assets.AssetDescriptor assetDescriptor = this.b;
                        this.k = asynchronousAssetLoader.loadSync(assetManager, assetDescriptor.fileName, e(this.c, assetDescriptor), this.b.params);
                        return;
                    }
                    return;
                } catch (java.lang.Exception e) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.fileName, e);
                }
            }
            return;
        }
        if (this.j == null && !this.f) {
            this.j = this.d.submit(this);
            return;
        }
        if (this.f) {
            com.badlogic.gdx.assets.AssetManager assetManager2 = this.a;
            com.badlogic.gdx.assets.AssetDescriptor assetDescriptor2 = this.b;
            this.k = asynchronousAssetLoader.loadSync(assetManager2, assetDescriptor2.fileName, e(this.c, assetDescriptor2), this.b.params);
        } else if (this.j.isDone()) {
            try {
                this.j.get();
                com.badlogic.gdx.assets.AssetManager assetManager3 = this.a;
                com.badlogic.gdx.assets.AssetDescriptor assetDescriptor3 = this.b;
                this.k = asynchronousAssetLoader.loadSync(assetManager3, assetDescriptor3.fileName, e(this.c, assetDescriptor3), this.b.params);
            } catch (java.lang.Exception e2) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't load asset: " + this.b.fileName, e2);
            }
        }
    }

    public final void c() {
        com.badlogic.gdx.assets.loaders.SynchronousAssetLoader synchronousAssetLoader = (com.badlogic.gdx.assets.loaders.SynchronousAssetLoader) this.c;
        if (this.g) {
            com.badlogic.gdx.assets.AssetManager assetManager = this.a;
            com.badlogic.gdx.assets.AssetDescriptor assetDescriptor = this.b;
            this.k = synchronousAssetLoader.load(assetManager, assetDescriptor.fileName, e(this.c, assetDescriptor), this.b.params);
            return;
        }
        this.g = true;
        com.badlogic.gdx.assets.AssetDescriptor assetDescriptor2 = this.b;
        this.h = synchronousAssetLoader.getDependencies(assetDescriptor2.fileName, e(this.c, assetDescriptor2), this.b.params);
        if (this.h != null) {
            d(this.h);
            this.a.d(this.b.fileName, this.h);
        } else {
            com.badlogic.gdx.assets.AssetManager assetManager2 = this.a;
            com.badlogic.gdx.assets.AssetDescriptor assetDescriptor3 = this.b;
            this.k = synchronousAssetLoader.load(assetManager2, assetDescriptor3.fileName, e(this.c, assetDescriptor3), this.b.params);
        }
    }

    @Override // com.badlogic.gdx.utils.async.AsyncTask
    public java.lang.Void call() throws java.lang.Exception {
        com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader asynchronousAssetLoader = (com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader) this.c;
        if (this.g) {
            com.badlogic.gdx.assets.AssetManager assetManager = this.a;
            com.badlogic.gdx.assets.AssetDescriptor assetDescriptor = this.b;
            asynchronousAssetLoader.loadAsync(assetManager, assetDescriptor.fileName, e(this.c, assetDescriptor), this.b.params);
            return null;
        }
        com.badlogic.gdx.assets.AssetDescriptor assetDescriptor2 = this.b;
        this.h = asynchronousAssetLoader.getDependencies(assetDescriptor2.fileName, e(this.c, assetDescriptor2), this.b.params);
        if (this.h != null) {
            d(this.h);
            this.a.d(this.b.fileName, this.h);
            return null;
        }
        com.badlogic.gdx.assets.AssetManager assetManager2 = this.a;
        com.badlogic.gdx.assets.AssetDescriptor assetDescriptor3 = this.b;
        asynchronousAssetLoader.loadAsync(assetManager2, assetDescriptor3.fileName, e(this.c, assetDescriptor3), this.b.params);
        this.f = true;
        return null;
    }

    public final void d(com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array) {
        boolean z = array.ordered;
        array.ordered = true;
        for (int i = 0; i < array.size; i++) {
            java.lang.String str = array.get(i).fileName;
            java.lang.reflect.GenericDeclaration genericDeclaration = array.get(i).type;
            for (int i2 = array.size - 1; i2 > i; i2--) {
                if (genericDeclaration == array.get(i2).type && str.equals(array.get(i2).fileName)) {
                    array.removeIndex(i2);
                }
            }
        }
        array.ordered = z;
    }

    public final com.badlogic.gdx.files.FileHandle e(com.badlogic.gdx.assets.loaders.AssetLoader assetLoader, com.badlogic.gdx.assets.AssetDescriptor assetDescriptor) {
        if (assetDescriptor.file == null) {
            assetDescriptor.file = assetLoader.resolve(assetDescriptor.fileName);
        }
        return assetDescriptor.file;
    }

    public boolean update() {
        this.l++;
        if (this.c instanceof com.badlogic.gdx.assets.loaders.SynchronousAssetLoader) {
            c();
        } else {
            b();
        }
        return this.k != null;
    }
}
