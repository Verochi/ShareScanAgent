package com.sensorsdata.analytics.android.sdk.data.persistent;

@android.annotation.SuppressLint({"CommitPrefEdits"})
/* loaded from: classes19.dex */
public abstract class PersistentIdentity<T> {
    private static final java.lang.String TAG = "SA.PersistentIdentity";
    private T item;
    private final java.lang.String persistentKey;
    private final com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager saStoreManager = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance();
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer serializer;

    public interface PersistentSerializer<T> {
        T create();

        T load(java.lang.String str);

        java.lang.String save(T t);
    }

    public PersistentIdentity(java.lang.String str, com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer<T> persistentSerializer) {
        this.serializer = persistentSerializer;
        this.persistentKey = str;
    }

    public void commit(T t) {
        if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isDisableSDK()) {
            return;
        }
        this.item = t;
        synchronized (this.saStoreManager) {
            if (this.item == null) {
                this.item = (T) this.serializer.create();
            }
            this.saStoreManager.setString(this.persistentKey, this.serializer.save(this.item));
        }
    }

    public T get() {
        if (this.item == null) {
            synchronized (this.saStoreManager) {
                java.lang.String string = this.saStoreManager.getString(this.persistentKey, null);
                if (string == null) {
                    T t = (T) this.serializer.create();
                    this.item = t;
                    commit(t);
                } else {
                    this.item = (T) this.serializer.load(string);
                }
            }
        }
        return this.item;
    }

    public boolean isExists() {
        try {
            return this.saStoreManager.isExists(this.persistentKey);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public void remove() {
        synchronized (this.saStoreManager) {
            this.saStoreManager.remove(this.persistentKey);
        }
    }
}
