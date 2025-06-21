package com.jd.ad.sdk.jad_uh;

/* loaded from: classes23.dex */
public class jad_bo {
    public final java.util.Map<java.lang.String, java.lang.Object> jad_an = new java.util.HashMap();
    public final java.util.concurrent.locks.ReadWriteLock jad_bo = new java.util.concurrent.locks.ReentrantReadWriteLock();
    public com.jd.ad.sdk.jad_uh.jad_dq jad_cp;

    public static final class jad_an {
        public static final com.jd.ad.sdk.jad_uh.jad_bo jad_an = new com.jd.ad.sdk.jad_uh.jad_bo();
    }

    public final <T> T jad_an(java.lang.Class<T> cls, java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            java.lang.String valueOf = java.lang.String.valueOf(obj);
            if (android.text.TextUtils.isEmpty(valueOf)) {
                return null;
            }
            if (cls == java.lang.String.class) {
                obj = (T) valueOf;
            } else if (cls == java.lang.Integer.TYPE) {
                obj = (T) java.lang.Integer.valueOf(valueOf);
            } else if (cls == java.lang.Long.TYPE) {
                obj = (T) java.lang.Long.valueOf(valueOf);
            } else if (cls == java.lang.Float.TYPE) {
                obj = (T) java.lang.Float.valueOf(valueOf);
            } else if (cls == java.lang.Boolean.TYPE) {
                obj = (T) java.lang.Boolean.valueOf(valueOf);
            } else if (cls == java.lang.Double.TYPE) {
                obj = (T) java.lang.Double.valueOf(valueOf);
            }
            return (T) obj;
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    public <T> T jad_an(java.lang.String str, java.lang.Class<T> cls) {
        T t;
        this.jad_bo.readLock().lock();
        try {
            try {
                if (this.jad_an.containsKey(str)) {
                    t = (T) jad_an(cls, this.jad_an.get(str));
                } else {
                    if (this.jad_cp == null) {
                        this.jad_cp = com.jd.ad.sdk.jad_uh.jad_dq.jad_an("jadyunsdk");
                    }
                    t = (T) jad_an(cls, com.jd.ad.sdk.jad_uh.jad_cp.jad_an(this.jad_cp, str, (java.lang.Class<?>) cls));
                }
                return t;
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                this.jad_bo.readLock().unlock();
                return null;
            }
        } finally {
            this.jad_bo.readLock().unlock();
        }
    }

    public void jad_an(java.lang.String str, java.lang.Object obj) {
        if (this.jad_cp == null) {
            this.jad_cp = com.jd.ad.sdk.jad_uh.jad_dq.jad_an("jadyunsdk");
        }
        this.jad_bo.writeLock().lock();
        try {
            if (this.jad_an.containsKey(str)) {
                java.lang.Object obj2 = this.jad_an.get(str);
                if (obj2 != null && !obj2.equals(obj) && com.jd.ad.sdk.jad_uh.jad_cp.jad_an(this.jad_cp, str, obj)) {
                    this.jad_an.put(str, obj);
                }
            } else if (com.jd.ad.sdk.jad_uh.jad_cp.jad_an(this.jad_cp, str, obj)) {
                this.jad_an.put(str, obj);
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_SAVE_CACHE_OTHER_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            this.jad_bo.writeLock().unlock();
        }
    }

    public void jad_an(java.lang.String... strArr) {
        if (this.jad_cp == null) {
            return;
        }
        this.jad_bo.writeLock().lock();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str : strArr) {
                if (this.jad_an.containsKey(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() != 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    this.jad_cp.jad_an.edit().remove((java.lang.String) arrayList.get(i)).apply();
                    this.jad_an.remove(arrayList.get(i));
                }
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DELETE_CACHE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            this.jad_bo.writeLock().unlock();
        }
    }

    public boolean jad_an(java.lang.String str, boolean z) {
        if (this.jad_an.containsKey(str)) {
            return true;
        }
        if (z) {
            return false;
        }
        return this.jad_cp.jad_an.contains(str);
    }
}
