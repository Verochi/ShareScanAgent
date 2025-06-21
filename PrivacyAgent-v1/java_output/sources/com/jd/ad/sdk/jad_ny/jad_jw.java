package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public final class jad_jw implements com.jd.ad.sdk.jad_ny.jad_bo {
    public final com.jd.ad.sdk.jad_ny.jad_hu<com.jd.ad.sdk.jad_ny.jad_jw.jad_an, java.lang.Object> jad_an = new com.jd.ad.sdk.jad_ny.jad_hu<>();
    public final com.jd.ad.sdk.jad_ny.jad_jw.jad_bo jad_bo = new com.jd.ad.sdk.jad_ny.jad_jw.jad_bo();
    public final java.util.Map<java.lang.Class<?>, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> jad_cp = new java.util.HashMap();
    public final java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_ny.jad_an<?>> jad_dq = new java.util.HashMap();
    public final int jad_er;
    public int jad_fs;

    public static final class jad_an implements com.jd.ad.sdk.jad_ny.jad_mz {
        public final com.jd.ad.sdk.jad_ny.jad_jw.jad_bo jad_an;
        public int jad_bo;
        public java.lang.Class<?> jad_cp;

        public jad_an(com.jd.ad.sdk.jad_ny.jad_jw.jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.jd.ad.sdk.jad_ny.jad_jw.jad_an)) {
                return false;
            }
            com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_anVar = (com.jd.ad.sdk.jad_ny.jad_jw.jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp;
        }

        public int hashCode() {
            int i = this.jad_bo * 31;
            java.lang.Class<?> cls = this.jad_cp;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_ny.jad_mz
        public void jad_an() {
            com.jd.ad.sdk.jad_ny.jad_jw.jad_bo jad_boVar = this.jad_an;
            if (jad_boVar.jad_an.size() < 20) {
                jad_boVar.jad_an.offer(this);
            }
        }

        public java.lang.String toString() {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Key{size=");
            jad_an.append(this.jad_bo);
            jad_an.append("array=");
            jad_an.append(this.jad_cp);
            jad_an.append('}');
            return jad_an.toString();
        }
    }

    public static final class jad_bo extends com.jd.ad.sdk.jad_ny.jad_dq<com.jd.ad.sdk.jad_ny.jad_jw.jad_an> {
        public com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_an(int i, java.lang.Class<?> cls) {
            com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_bo = jad_bo();
            jad_bo.jad_bo = i;
            jad_bo.jad_cp = cls;
            return jad_bo;
        }

        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_an() {
            return new com.jd.ad.sdk.jad_ny.jad_jw.jad_an(this);
        }
    }

    public jad_jw(int i) {
        this.jad_er = i;
    }

    public final <T> com.jd.ad.sdk.jad_ny.jad_an<T> jad_an(java.lang.Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_anVar = (com.jd.ad.sdk.jad_ny.jad_an) this.jad_dq.get(cls);
        if (jad_anVar == null) {
            if (cls.equals(int[].class)) {
                jad_anVar = new com.jd.ad.sdk.jad_ny.jad_iv();
            } else {
                if (!cls.equals(byte[].class)) {
                    java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("No array pool found for: ");
                    jad_an2.append(cls.getSimpleName());
                    throw new java.lang.IllegalArgumentException(jad_an2.toString());
                }
                jad_anVar = new com.jd.ad.sdk.jad_ny.jad_jt();
            }
            this.jad_dq.put(cls, jad_anVar);
        }
        return jad_anVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> T jad_an(int i, java.lang.Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_anVar;
        boolean z;
        java.lang.Integer ceilingKey = jad_bo((java.lang.Class<?>) cls).ceilingKey(java.lang.Integer.valueOf(i));
        boolean z2 = false;
        if (ceilingKey != null) {
            int i2 = this.jad_fs;
            if (i2 != 0 && this.jad_er / i2 < 2) {
                z = false;
                if (!z || ceilingKey.intValue() <= i * 8) {
                    z2 = true;
                }
            }
            z = true;
            if (!z) {
            }
            z2 = true;
        }
        if (z2) {
            jad_anVar = this.jad_bo.jad_an(ceilingKey.intValue(), cls);
        } else {
            com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_bo2 = this.jad_bo.jad_bo();
            jad_bo2.jad_bo = i;
            jad_bo2.jad_cp = cls;
            jad_anVar = jad_bo2;
        }
        return (T) jad_an(jad_anVar, cls);
    }

    public final <T> T jad_an(com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_anVar, java.lang.Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_an2 = jad_an((java.lang.Class) cls);
        T t = (T) this.jad_an.jad_an(jad_anVar);
        if (t != null) {
            this.jad_fs -= jad_an2.jad_bo() * jad_an2.jad_an(t);
            jad_cp(jad_an2.jad_an(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (android.util.Log.isLoggable(jad_an2.jad_an(), 2)) {
            java.lang.String jad_an3 = jad_an2.jad_an();
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Allocated ");
            jad_an4.append(jad_anVar.jad_bo);
            jad_an4.append(" bytes");
            com.jd.ad.sdk.logger.Logger.v(jad_an3, jad_an4.toString());
        }
        return jad_an2.newArray(jad_anVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized void jad_an() {
        jad_bo(0);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized void jad_an(int i) {
        try {
            if (i >= 40) {
                synchronized (this) {
                    jad_bo(0);
                }
            } else if (i >= 20 || i == 15) {
                jad_bo(this.jad_er / 2);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> void jad_an(T t) {
        java.lang.Class<?> cls = t.getClass();
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_an2 = jad_an((java.lang.Class) cls);
        int jad_an3 = jad_an2.jad_an(t);
        int jad_bo2 = jad_an2.jad_bo() * jad_an3;
        int i = 1;
        if (jad_bo2 <= this.jad_er / 2) {
            com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_an4 = this.jad_bo.jad_an(jad_an3, cls);
            this.jad_an.jad_an(jad_an4, t);
            java.util.NavigableMap<java.lang.Integer, java.lang.Integer> jad_bo3 = jad_bo(cls);
            java.lang.Integer num = jad_bo3.get(java.lang.Integer.valueOf(jad_an4.jad_bo));
            java.lang.Integer valueOf = java.lang.Integer.valueOf(jad_an4.jad_bo);
            if (num != null) {
                i = 1 + num.intValue();
            }
            jad_bo3.put(valueOf, java.lang.Integer.valueOf(i));
            this.jad_fs += jad_bo2;
            jad_bo(this.jad_er);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> T jad_bo(int i, java.lang.Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_jw.jad_an jad_bo2;
        jad_bo2 = this.jad_bo.jad_bo();
        jad_bo2.jad_bo = i;
        jad_bo2.jad_cp = cls;
        return (T) jad_an(jad_bo2, cls);
    }

    public final java.util.NavigableMap<java.lang.Integer, java.lang.Integer> jad_bo(java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> navigableMap = this.jad_cp.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        this.jad_cp.put(cls, treeMap);
        return treeMap;
    }

    public final void jad_bo(int i) {
        while (this.jad_fs > i) {
            java.lang.Object jad_an2 = this.jad_an.jad_an();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_an2);
            com.jd.ad.sdk.jad_ny.jad_an jad_an3 = jad_an((java.lang.Class) jad_an2.getClass());
            this.jad_fs -= jad_an3.jad_bo() * jad_an3.jad_an(jad_an2);
            jad_cp(jad_an3.jad_an(jad_an2), jad_an2.getClass());
            if (android.util.Log.isLoggable(jad_an3.jad_an(), 2)) {
                java.lang.String jad_an4 = jad_an3.jad_an();
                java.lang.StringBuilder jad_an5 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("evicted: ");
                jad_an5.append(jad_an3.jad_an(jad_an2));
                com.jd.ad.sdk.logger.Logger.v(jad_an4, jad_an5.toString());
            }
        }
    }

    public final void jad_cp(int i, java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> jad_bo2 = jad_bo(cls);
        java.lang.Integer num = jad_bo2.get(java.lang.Integer.valueOf(i));
        if (num == null) {
            throw new java.lang.NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        int intValue = num.intValue();
        java.lang.Integer valueOf = java.lang.Integer.valueOf(i);
        if (intValue == 1) {
            jad_bo2.remove(valueOf);
        } else {
            jad_bo2.put(valueOf, java.lang.Integer.valueOf(num.intValue() - 1));
        }
    }
}
