package com.alimm.tanx.ui.image.glide.provider;

/* loaded from: classes.dex */
public class DataLoadProviderRegistry {
    private static final com.alimm.tanx.ui.image.glide.util.MultiClassKey GET_KEY = new com.alimm.tanx.ui.image.glide.util.MultiClassKey();
    private final java.util.Map<com.alimm.tanx.ui.image.glide.util.MultiClassKey, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<?, ?>> providers = new java.util.HashMap();

    public <T, Z> com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> get(java.lang.Class<T> cls, java.lang.Class<Z> cls2) {
        com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> dataLoadProvider;
        com.alimm.tanx.ui.image.glide.util.MultiClassKey multiClassKey = GET_KEY;
        synchronized (multiClassKey) {
            multiClassKey.set(cls, cls2);
            dataLoadProvider = (com.alimm.tanx.ui.image.glide.provider.DataLoadProvider) this.providers.get(multiClassKey);
        }
        return dataLoadProvider == null ? com.alimm.tanx.ui.image.glide.provider.EmptyDataLoadProvider.get() : dataLoadProvider;
    }

    public <T, Z> void register(java.lang.Class<T> cls, java.lang.Class<Z> cls2, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> dataLoadProvider) {
        this.providers.put(new com.alimm.tanx.ui.image.glide.util.MultiClassKey(cls, cls2), dataLoadProvider);
    }
}
