package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class MultiModelLoaderFactory {
    private static final com.bumptech.glide.load.model.MultiModelLoaderFactory.Factory DEFAULT_FACTORY = new com.bumptech.glide.load.model.MultiModelLoaderFactory.Factory();
    private static final com.bumptech.glide.load.model.ModelLoader<java.lang.Object, java.lang.Object> EMPTY_MODEL_LOADER = new com.bumptech.glide.load.model.MultiModelLoaderFactory.EmptyModelLoader();
    private final java.util.Set<com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?>> alreadyUsedEntries;
    private final java.util.List<com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?>> entries;
    private final com.bumptech.glide.load.model.MultiModelLoaderFactory.Factory factory;
    private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> throwableListPool;

    public static class EmptyModelLoader implements com.bumptech.glide.load.model.ModelLoader<java.lang.Object, java.lang.Object> {
        @Override // com.bumptech.glide.load.model.ModelLoader
        @androidx.annotation.Nullable
        public com.bumptech.glide.load.model.ModelLoader.LoadData<java.lang.Object> buildLoadData(@androidx.annotation.NonNull java.lang.Object obj, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(@androidx.annotation.NonNull java.lang.Object obj) {
            return false;
        }
    }

    public static class Entry<Model, Data> {
        final java.lang.Class<Data> dataClass;
        final com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> factory;
        private final java.lang.Class<Model> modelClass;

        public Entry(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.modelClass = cls;
            this.dataClass = cls2;
            this.factory = modelLoaderFactory;
        }

        public boolean handles(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            return this.modelClass.isAssignableFrom(cls);
        }

        public boolean handles(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2) {
            return handles(cls) && this.dataClass.isAssignableFrom(cls2);
        }
    }

    public static class Factory {
        @androidx.annotation.NonNull
        public <Model, Data> com.bumptech.glide.load.model.MultiModelLoader<Model, Data> build(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.model.ModelLoader<Model, Data>> list, @androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
            return new com.bumptech.glide.load.model.MultiModelLoader<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this(pool, DEFAULT_FACTORY);
    }

    @androidx.annotation.VisibleForTesting
    public MultiModelLoaderFactory(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool, @androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory.Factory factory) {
        this.entries = new java.util.ArrayList();
        this.alreadyUsedEntries = new java.util.HashSet();
        this.throwableListPool = pool;
        this.factory = factory;
    }

    private <Model, Data> void add(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> entry = new com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<>(cls, cls2, modelLoaderFactory);
        java.util.List<com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?>> list = this.entries;
        list.add(z ? list.size() : 0, entry);
    }

    @androidx.annotation.NonNull
    private <Model, Data> com.bumptech.glide.load.model.ModelLoader<Model, Data> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> entry) {
        return (com.bumptech.glide.load.model.ModelLoader) com.bumptech.glide.util.Preconditions.checkNotNull(entry.factory.build(this));
    }

    @androidx.annotation.NonNull
    private static <Model, Data> com.bumptech.glide.load.model.ModelLoader<Model, Data> emptyModelLoader() {
        return (com.bumptech.glide.load.model.ModelLoader<Model, Data>) EMPTY_MODEL_LOADER;
    }

    @androidx.annotation.NonNull
    private <Model, Data> com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data> getFactory(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> entry) {
        return (com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data>) entry.factory;
    }

    public synchronized <Model, Data> void append(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        add(cls, cls2, modelLoaderFactory, true);
    }

    @androidx.annotation.NonNull
    public synchronized <Model, Data> com.bumptech.glide.load.model.ModelLoader<Model, Data> build(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            boolean z = false;
            for (com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> entry : this.entries) {
                if (this.alreadyUsedEntries.contains(entry)) {
                    z = true;
                } else if (entry.handles(cls, cls2)) {
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                return this.factory.build(arrayList, this.throwableListPool);
            }
            if (arrayList.size() == 1) {
                return (com.bumptech.glide.load.model.ModelLoader) arrayList.get(0);
            }
            if (!z) {
                throw new com.bumptech.glide.Registry.NoModelLoaderAvailableException((java.lang.Class<?>) cls, (java.lang.Class<?>) cls2);
            }
            return emptyModelLoader();
        } catch (java.lang.Throwable th) {
            this.alreadyUsedEntries.clear();
            throw th;
        }
    }

    @androidx.annotation.NonNull
    public synchronized <Model> java.util.List<com.bumptech.glide.load.model.ModelLoader<Model, ?>> build(@androidx.annotation.NonNull java.lang.Class<Model> cls) {
        java.util.ArrayList arrayList;
        try {
            arrayList = new java.util.ArrayList();
            for (com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> entry : this.entries) {
                if (!this.alreadyUsedEntries.contains(entry) && entry.handles(cls)) {
                    this.alreadyUsedEntries.add(entry);
                    arrayList.add(build(entry));
                    this.alreadyUsedEntries.remove(entry);
                }
            }
        } catch (java.lang.Throwable th) {
            this.alreadyUsedEntries.clear();
            throw th;
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public synchronized java.util.List<java.lang.Class<?>> getDataClasses(@androidx.annotation.NonNull java.lang.Class<?> cls) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        for (com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> entry : this.entries) {
            if (!arrayList.contains(entry.dataClass) && entry.handles(cls)) {
                arrayList.add(entry.dataClass);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> void prepend(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        add(cls, cls2, modelLoaderFactory, false);
    }

    @androidx.annotation.NonNull
    public synchronized <Model, Data> java.util.List<com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data>> remove(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?>> it = this.entries.iterator();
        while (it.hasNext()) {
            com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry<?, ?> next = it.next();
            if (next.handles(cls, cls2)) {
                it.remove();
                arrayList.add(getFactory(next));
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public synchronized <Model, Data> java.util.List<com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data>> replace(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        java.util.List<com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data>> remove;
        remove = remove(cls, cls2);
        append(cls, cls2, modelLoaderFactory);
        return remove;
    }
}
