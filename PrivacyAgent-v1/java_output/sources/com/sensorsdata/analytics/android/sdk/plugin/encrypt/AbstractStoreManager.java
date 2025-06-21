package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

/* loaded from: classes19.dex */
public abstract class AbstractStoreManager {
    private static final java.lang.String TAG = "SA.AbstractStoreManager";
    private java.lang.String mMaxPluginType;
    private com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin mMaxPriorityPlugin;
    protected boolean mDefaultState = true;
    private final java.util.List<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> mStorePluginList = new java.util.ArrayList();
    private final com.sensorsdata.analytics.android.sdk.plugin.encrypt.AbstractStoreManager.LruCacheData mLruCacheSPData = new com.sensorsdata.analytics.android.sdk.plugin.encrypt.AbstractStoreManager.LruCacheData(10);
    private final java.util.concurrent.locks.Lock mLock = new java.util.concurrent.locks.ReentrantLock(true);
    private final java.util.Set<java.lang.String> mStoreTypes = new java.util.HashSet();

    public class LruCacheData {
        private android.util.LruCache<java.lang.String, java.lang.Object> mCacheSPData;

        public LruCacheData(int i) {
            this.mCacheSPData = new android.util.LruCache<>(i);
        }

        public java.lang.Object get(java.lang.String str) {
            return this.mCacheSPData.get(com.sensorsdata.analytics.android.sdk.plugin.encrypt.AbstractStoreManager.this.mMaxPluginType + str);
        }

        public void put(java.lang.String str, java.lang.Object obj) {
            this.mCacheSPData.put(com.sensorsdata.analytics.android.sdk.plugin.encrypt.AbstractStoreManager.this.mMaxPluginType + str, obj);
        }

        public void remove(java.lang.String str) {
            this.mCacheSPData.remove(com.sensorsdata.analytics.android.sdk.plugin.encrypt.AbstractStoreManager.this.mMaxPluginType + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T getValue(java.lang.String str, java.lang.String str2, T t) {
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin;
        java.lang.String str3;
        storePlugin = this.mMaxPriorityPlugin;
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
            if (next instanceof com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) {
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin defaultStorePlugin = (com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) next;
                if (defaultStorePlugin.storeKeys() != null && defaultStorePlugin.storeKeys().contains(str)) {
                    storePlugin = next;
                    break;
                }
            }
        }
        str2.hashCode();
        switch (str2) {
            case "String":
                str3 = storePlugin.getString(storePlugin.type() + str);
                break;
            case "Integer":
                str3 = storePlugin.getInteger(storePlugin.type() + str);
                break;
            case "Bool":
                str3 = storePlugin.getBool(storePlugin.type() + str);
                break;
            case "Long":
                str3 = storePlugin.getLong(storePlugin.type() + str);
                break;
            case "Float":
                str3 = storePlugin.getFloat(storePlugin.type() + str);
                break;
            default:
                str3 = null;
                break;
        }
        return str3 == null ? t : str3;
    }

    private void removeUselessValue(java.lang.String str) {
        for (com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin : this.mStorePluginList) {
            if (storePlugin != this.mMaxPriorityPlugin) {
                storePlugin.remove(storePlugin.type() + str);
            }
        }
    }

    private void storeKeys(java.lang.String str, java.lang.Object obj, java.lang.String str2) {
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin;
        storePlugin = this.mMaxPriorityPlugin;
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
            if (next instanceof com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) {
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin defaultStorePlugin = (com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) next;
                if (defaultStorePlugin.storeKeys() != null && defaultStorePlugin.storeKeys().contains(str)) {
                    storePlugin = next;
                    break;
                }
            }
        }
        str2.hashCode();
        switch (str2) {
            case "String":
                storePlugin.setString(storePlugin.type() + str, (java.lang.String) obj);
                break;
            case "Integer":
                storePlugin.setInteger(storePlugin.type() + str, ((java.lang.Integer) obj).intValue());
                break;
            case "Bool":
                storePlugin.setBool(storePlugin.type() + str, ((java.lang.Boolean) obj).booleanValue());
                break;
            case "Long":
                storePlugin.setLong(storePlugin.type() + str, ((java.lang.Long) obj).longValue());
                break;
            case "Float":
                storePlugin.setFloat(storePlugin.type() + str, ((java.lang.Float) obj).floatValue());
                break;
        }
    }

    public boolean getBool(java.lang.String str, boolean z) {
        boolean booleanValue;
        this.mLock.lock();
        try {
            java.lang.Boolean bool = (java.lang.Boolean) this.mLruCacheSPData.get(str);
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else {
                if (!this.mDefaultState) {
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                        java.lang.Boolean bool2 = next.getBool(next.type() + str);
                        if (bool2 != null) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                this.mMaxPriorityPlugin.setBool(this.mMaxPluginType + str, bool2.booleanValue());
                            }
                            this.mLruCacheSPData.put(str, bool2);
                            bool = bool2;
                        } else {
                            bool = bool2;
                        }
                    }
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                    return z;
                }
                booleanValue = ((java.lang.Boolean) getValue(str, "Bool", java.lang.Boolean.valueOf(z))).booleanValue();
            }
            return booleanValue;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "get data failed,key = " + str, e);
            return z;
        } finally {
            this.mLock.unlock();
        }
    }

    public float getFloat(java.lang.String str, float f) {
        float floatValue;
        this.mLock.lock();
        try {
            java.lang.Float f2 = (java.lang.Float) this.mLruCacheSPData.get(str);
            if (f2 != null) {
                floatValue = f2.floatValue();
            } else {
                if (!this.mDefaultState) {
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                        java.lang.Float f3 = next.getFloat(next.type() + str);
                        if (f3 != null) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                this.mMaxPriorityPlugin.setFloat(this.mMaxPluginType + str, f3.floatValue());
                            }
                            this.mLruCacheSPData.put(str, f3);
                            f2 = f3;
                        } else {
                            f2 = f3;
                        }
                    }
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                    return f;
                }
                floatValue = ((java.lang.Float) getValue(str, "Float", java.lang.Float.valueOf(f))).floatValue();
            }
            return floatValue;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "get data failed,key = " + str, e);
            return f;
        } finally {
            this.mLock.unlock();
        }
    }

    public int getInteger(java.lang.String str, int i) {
        int intValue;
        this.mLock.lock();
        try {
            java.lang.Integer num = (java.lang.Integer) this.mLruCacheSPData.get(str);
            if (num != null) {
                intValue = num.intValue();
            } else {
                if (!this.mDefaultState) {
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                        java.lang.Integer integer = next.getInteger(next.type() + str);
                        if (integer != null) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                this.mMaxPriorityPlugin.setInteger(this.mMaxPluginType + str, integer.intValue());
                            }
                            this.mLruCacheSPData.put(str, integer);
                            num = integer;
                        } else {
                            num = integer;
                        }
                    }
                    if (num != null) {
                        i = num.intValue();
                    }
                    return i;
                }
                intValue = ((java.lang.Integer) getValue(str, "Integer", java.lang.Integer.valueOf(i))).intValue();
            }
            return intValue;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "get data failed,key = " + str, e);
            return i;
        } finally {
            this.mLock.unlock();
        }
    }

    public java.lang.Long getLong(java.lang.String str, long j) {
        this.mLock.lock();
        try {
            try {
                java.lang.Long l = (java.lang.Long) this.mLruCacheSPData.get(str);
                if (l == null) {
                    if (!this.mDefaultState) {
                        java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                            java.lang.Long l2 = next.getLong(next.type() + str);
                            if (l2 != null) {
                                if (next != this.mMaxPriorityPlugin) {
                                    next.remove(next.type() + str);
                                    this.mMaxPriorityPlugin.setLong(this.mMaxPluginType + str, l2.longValue());
                                }
                                this.mLruCacheSPData.put(str, l2);
                                l = l2;
                            } else {
                                l = l2;
                            }
                        }
                        return java.lang.Long.valueOf(l == null ? j : l.longValue());
                    }
                    l = (java.lang.Long) getValue(str, "Long", java.lang.Long.valueOf(j));
                }
                return l;
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "get data failed,key = " + str, e);
                this.mLock.unlock();
                return java.lang.Long.valueOf(j);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        this.mLock.lock();
        try {
            java.lang.String str3 = (java.lang.String) this.mLruCacheSPData.get(str);
            if (str3 == null) {
                if (!this.mDefaultState) {
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                        java.lang.String string = next.getString(next.type() + str);
                        if (android.text.TextUtils.isEmpty(string)) {
                            str3 = string;
                        } else {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                this.mMaxPriorityPlugin.setString(this.mMaxPluginType + str, string);
                            }
                            this.mLruCacheSPData.put(str, string);
                            str3 = string;
                        }
                    }
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return str2;
                }
                str3 = (java.lang.String) getValue(str, "String", str2);
            }
            return str3;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "get data failed,key = " + str, e);
            return str2;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean isExists(java.lang.String str) {
        this.mLock.lock();
        try {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "isExists failed,key = " + str, e);
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            for (com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin : this.mStorePluginList) {
                if (storePlugin.isExists(storePlugin.type() + str)) {
                    this.mLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean isRegisterPlugin(android.content.Context context, java.lang.String str) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (!new java.io.File("data/data/" + context.getPackageName() + "/shared_prefs", str + ".xml").exists()) {
            return false;
        }
        if (com.sensorsdata.analytics.android.sdk.util.SASpUtils.getSharedPreferences(context, str, 0).getAll().size() == 0) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "delete sp: " + str);
            return !r1.delete();
        }
        return true;
    }

    public void registerPlugin(com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin) {
        if (storePlugin == null) {
            return;
        }
        java.lang.String type = storePlugin.type();
        if (android.text.TextUtils.isEmpty(type)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "PluginType is null");
            return;
        }
        if (this.mStoreTypes.contains(type)) {
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                if (android.text.TextUtils.equals(type, next.type())) {
                    this.mStorePluginList.remove(next);
                    break;
                }
            }
        } else {
            this.mStoreTypes.add(type);
        }
        this.mStorePluginList.add(0, storePlugin);
        this.mMaxPriorityPlugin = storePlugin;
        this.mMaxPluginType = storePlugin.type();
    }

    public void remove(java.lang.String str) {
        this.mLock.lock();
        try {
            try {
                if (this.mDefaultState) {
                    com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin = this.mMaxPriorityPlugin;
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin next = it.next();
                        if ((next instanceof com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) && ((com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) next).storeKeys() != null && ((com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin) next).storeKeys().contains(str)) {
                            storePlugin = next;
                            break;
                        }
                    }
                    storePlugin.remove(storePlugin.type() + str);
                } else {
                    for (com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin2 : this.mStorePluginList) {
                        storePlugin2.remove(storePlugin2.type() + str);
                    }
                }
                this.mLruCacheSPData.remove(str);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remove failed,key = " + str, e);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setBool(java.lang.String str, boolean z) {
        this.mLock.lock();
        try {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "save data failed,key = " + str + "value = " + z, e);
            }
            if (this.mDefaultState) {
                storeKeys(str, java.lang.Boolean.valueOf(z), "Bool");
                return;
            }
            removeUselessValue(str);
            this.mMaxPriorityPlugin.setBool(this.mMaxPluginType + str, z);
            this.mLruCacheSPData.put(str, java.lang.Boolean.valueOf(z));
        } finally {
            this.mLock.unlock();
        }
    }

    public void setFloat(java.lang.String str, float f) {
        this.mLock.lock();
        try {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "save data failed,key = " + str + "value = " + f, e);
            }
            if (this.mDefaultState) {
                storeKeys(str, java.lang.Float.valueOf(f), "Float");
                return;
            }
            removeUselessValue(str);
            this.mMaxPriorityPlugin.setFloat(this.mMaxPluginType + str, f);
            this.mLruCacheSPData.put(str, java.lang.Float.valueOf(f));
        } finally {
            this.mLock.unlock();
        }
    }

    public void setInteger(java.lang.String str, int i) {
        this.mLock.lock();
        try {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "save data failed,key = " + str + "value = " + i, e);
            }
            if (this.mDefaultState) {
                storeKeys(str, java.lang.Integer.valueOf(i), "Integer");
                return;
            }
            removeUselessValue(str);
            this.mMaxPriorityPlugin.setInteger(this.mMaxPluginType + str, i);
            this.mLruCacheSPData.put(str, java.lang.Integer.valueOf(i));
        } finally {
            this.mLock.unlock();
        }
    }

    public void setLong(java.lang.String str, long j) {
        this.mLock.lock();
        try {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "save data failed,key = " + str + "value = " + j, e);
            }
            if (this.mDefaultState) {
                storeKeys(str, java.lang.Long.valueOf(j), "Long");
                return;
            }
            removeUselessValue(str);
            this.mMaxPriorityPlugin.setLong(this.mMaxPluginType + str, j);
            this.mLruCacheSPData.put(str, java.lang.Long.valueOf(j));
        } finally {
            this.mLock.unlock();
        }
    }

    public void setString(java.lang.String str, java.lang.String str2) {
        this.mLock.lock();
        try {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "save data failed,key = " + str + "value = " + str2, e);
            }
            if (this.mDefaultState) {
                storeKeys(str, str2, "String");
                return;
            }
            if (str2 == null) {
                for (com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin : this.mStorePluginList) {
                    storePlugin.remove(storePlugin.type() + str);
                }
                this.mLruCacheSPData.remove(str);
            } else {
                removeUselessValue(str);
                this.mMaxPriorityPlugin.setString(this.mMaxPluginType + str, str2);
                this.mLruCacheSPData.put(str, str2);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void upgrade() {
        this.mLock.lock();
        try {
            try {
                for (int size = this.mStorePluginList.size() - 1; size >= 0; size--) {
                    com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin = this.mStorePluginList.get(size);
                    int i = size - 1;
                    com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin2 = i >= 0 ? this.mStorePluginList.get(i) : null;
                    if (storePlugin2 != null) {
                        storePlugin2.upgrade(storePlugin);
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "upgrade failed", e);
            }
        } finally {
            this.mLock.unlock();
        }
    }
}
