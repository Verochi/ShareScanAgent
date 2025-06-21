package com.jd.ad.sdk.jad_uh;

/* loaded from: classes23.dex */
public final class jad_an {
    public final java.util.Map<java.lang.String, java.lang.Object> jad_an = new java.util.HashMap();
    public final java.util.concurrent.locks.ReadWriteLock jad_bo = new java.util.concurrent.locks.ReentrantReadWriteLock();

    /* renamed from: com.jd.ad.sdk.jad_uh.jad_an$jad_an, reason: collision with other inner class name */
    public class RunnableC0412jad_an implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String jad_an;
        public final /* synthetic */ java.lang.Object jad_bo;

        public RunnableC0412jad_an(com.jd.ad.sdk.jad_uh.jad_an jad_anVar, java.lang.String str, java.lang.Object obj) {
            this.jad_an = str;
            this.jad_bo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_uh.jad_cp.jad_an((com.jd.ad.sdk.jad_uh.jad_dq) null, this.jad_an, this.jad_bo);
        }
    }

    public static final class jad_bo {
        public static final com.jd.ad.sdk.jad_uh.jad_an jad_an = new com.jd.ad.sdk.jad_uh.jad_an();
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

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T jad_an(java.lang.String str, java.lang.Class<T> cls) {
        this.jad_bo.readLock().lock();
        T t = null;
        try {
            t = com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) ? com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(str, (java.lang.Class) cls) : this.jad_an.containsKey(str) ? jad_an(cls, this.jad_an.get(str)) : jad_an(cls, com.jd.ad.sdk.jad_uh.jad_cp.jad_an((com.jd.ad.sdk.jad_uh.jad_dq) null, str, (java.lang.Class<?>) cls));
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            this.jad_bo.readLock().unlock();
        }
        return t;
    }

    public java.lang.String jad_an(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String str2 = (java.lang.String) com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an(str, java.lang.String.class);
            if (android.text.TextUtils.isEmpty(str2)) {
                return "";
            }
            java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(str2);
            return android.text.TextUtils.isEmpty(jb) ? "" : jb;
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while gfcd: ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an.toString(), new java.lang.Object[0]);
            return "";
        }
    }

    public void jad_an(java.lang.String str, java.lang.Object obj) {
        this.jad_bo.writeLock().lock();
        try {
            if (com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(str, obj);
            } else {
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_uh.jad_an.RunnableC0412jad_an(this, str, obj));
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_SAVE_CACHE_OTHER_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            this.jad_bo.writeLock().unlock();
        }
    }

    public void jad_an(java.lang.String str, java.lang.String str2) {
        byte[] bytes;
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                java.lang.String ja = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(str2);
                if (!android.text.TextUtils.isEmpty(ja) && (bytes = ja.getBytes(java.nio.charset.StandardCharsets.UTF_8)) != null && bytes.length > 0) {
                    com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an(str, (java.lang.Object) new java.lang.String(bytes));
                }
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while s2ce: ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an.toString(), new java.lang.Object[0]);
        }
    }

    public boolean jad_an(java.lang.String str, boolean z) {
        try {
            return z ? this.jad_an.containsKey(str) : com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) ? com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(str, z) : com.jd.ad.sdk.jad_uh.jad_cp.jad_an(str);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public java.lang.Object jad_bo(java.lang.String str) {
        java.lang.Object obj;
        this.jad_bo.readLock().lock();
        try {
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            this.jad_bo.readLock().unlock();
            throw th;
        }
        if (this.jad_an.containsKey(str)) {
            obj = this.jad_an.get(str);
            this.jad_bo.readLock().unlock();
            return obj;
        }
        obj = null;
        this.jad_bo.readLock().unlock();
        return obj;
    }

    public synchronized void jad_bo(java.lang.String str, java.lang.Object obj) {
        try {
            if (this.jad_an.containsKey(str)) {
                java.lang.Object obj2 = this.jad_an.get(str);
                if (obj2 != null && !obj2.equals(obj)) {
                    this.jad_an.put(str, obj);
                }
            } else {
                this.jad_an.put(str, obj);
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while mem: ", e.getMessage());
        }
    }

    public int jad_cp(java.lang.String str) {
        java.lang.Object jad_bo2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo(str);
        if (jad_bo2 == null || !(jad_bo2 instanceof java.lang.Integer)) {
            return -1;
        }
        return ((java.lang.Integer) jad_bo2).intValue();
    }

    public java.lang.String jad_dq(java.lang.String str) {
        java.lang.Object jad_bo2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo(str);
        return (jad_bo2 == null || !(jad_bo2 instanceof java.lang.String)) ? "" : (java.lang.String) jad_bo2;
    }
}
