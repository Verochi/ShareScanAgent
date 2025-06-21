package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class EngineKeyFactory {
    public com.bumptech.glide.load.engine.EngineKey buildKey(java.lang.Object obj, com.bumptech.glide.load.Key key, int i, int i2, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, java.lang.Class<?> cls, java.lang.Class<?> cls2, com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.engine.EngineKey(obj, key, i, i2, map, cls, cls2, options);
    }
}
