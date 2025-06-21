package com.jd.ad.sdk.jad_ny;

@androidx.annotation.RequiresApi(19)
/* loaded from: classes23.dex */
public class jad_na implements com.jd.ad.sdk.jad_ny.jad_ly {
    public static final android.graphics.Bitmap.Config[] jad_dq;
    public static final android.graphics.Bitmap.Config[] jad_er;
    public static final android.graphics.Bitmap.Config[] jad_fs;
    public static final android.graphics.Bitmap.Config[] jad_hu;
    public static final android.graphics.Bitmap.Config[] jad_jt;
    public final com.jd.ad.sdk.jad_ny.jad_na.jad_cp jad_an = new com.jd.ad.sdk.jad_ny.jad_na.jad_cp();
    public final com.jd.ad.sdk.jad_ny.jad_hu<com.jd.ad.sdk.jad_ny.jad_na.jad_bo, android.graphics.Bitmap> jad_bo = new com.jd.ad.sdk.jad_ny.jad_hu<>();
    public final java.util.Map<android.graphics.Bitmap.Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> jad_cp = new java.util.HashMap();

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            jad_an = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_an[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                jad_an[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class jad_bo implements com.jd.ad.sdk.jad_ny.jad_mz {
        public final com.jd.ad.sdk.jad_ny.jad_na.jad_cp jad_an;
        public int jad_bo;
        public android.graphics.Bitmap.Config jad_cp;

        public jad_bo(com.jd.ad.sdk.jad_ny.jad_na.jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.jd.ad.sdk.jad_ny.jad_na.jad_bo)) {
                return false;
            }
            com.jd.ad.sdk.jad_ny.jad_na.jad_bo jad_boVar = (com.jd.ad.sdk.jad_ny.jad_na.jad_bo) obj;
            return this.jad_bo == jad_boVar.jad_bo && com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_cp, jad_boVar.jad_cp);
        }

        public int hashCode() {
            int i = this.jad_bo * 31;
            android.graphics.Bitmap.Config config = this.jad_cp;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_ny.jad_mz
        public void jad_an() {
            com.jd.ad.sdk.jad_ny.jad_na.jad_cp jad_cpVar = this.jad_an;
            if (jad_cpVar.jad_an.size() < 20) {
                jad_cpVar.jad_an.offer(this);
            }
        }

        public java.lang.String toString() {
            return com.jd.ad.sdk.jad_ny.jad_na.jad_an(this.jad_bo, this.jad_cp);
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class jad_cp extends com.jd.ad.sdk.jad_ny.jad_dq<com.jd.ad.sdk.jad_ny.jad_na.jad_bo> {
        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public com.jd.ad.sdk.jad_ny.jad_na.jad_bo jad_an() {
            return new com.jd.ad.sdk.jad_ny.jad_na.jad_bo(this);
        }

        public com.jd.ad.sdk.jad_ny.jad_na.jad_bo jad_an(int i, android.graphics.Bitmap.Config config) {
            com.jd.ad.sdk.jad_ny.jad_na.jad_bo jad_bo = jad_bo();
            jad_bo.jad_bo = i;
            jad_bo.jad_cp = config;
            return jad_bo;
        }
    }

    static {
        android.graphics.Bitmap.Config config;
        android.graphics.Bitmap.Config[] configArr = {android.graphics.Bitmap.Config.ARGB_8888, null};
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            configArr = (android.graphics.Bitmap.Config[]) java.util.Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = android.graphics.Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        jad_dq = configArr;
        jad_er = configArr;
        jad_fs = new android.graphics.Bitmap.Config[]{android.graphics.Bitmap.Config.RGB_565};
        jad_jt = new android.graphics.Bitmap.Config[]{android.graphics.Bitmap.Config.ARGB_4444};
        jad_hu = new android.graphics.Bitmap.Config[]{android.graphics.Bitmap.Config.ALPHA_8};
    }

    public static java.lang.String jad_an(int i, android.graphics.Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public static android.graphics.Bitmap.Config[] jad_an(android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap.Config config2;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            config2 = android.graphics.Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                return jad_er;
            }
        }
        int i = com.jd.ad.sdk.jad_ny.jad_na.jad_an.jad_an[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new android.graphics.Bitmap.Config[]{config} : jad_hu : jad_jt : jad_fs : jad_dq;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    @androidx.annotation.Nullable
    public android.graphics.Bitmap jad_an() {
        android.graphics.Bitmap jad_an2 = this.jad_bo.jad_an();
        if (jad_an2 != null) {
            jad_an(java.lang.Integer.valueOf(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(jad_an2)), jad_an2);
        }
        return jad_an2;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    @androidx.annotation.Nullable
    public android.graphics.Bitmap jad_an(int i, int i2, android.graphics.Bitmap.Config config) {
        int jad_an2 = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(config) * i * i2;
        com.jd.ad.sdk.jad_ny.jad_na.jad_bo jad_bo2 = this.jad_an.jad_bo();
        jad_bo2.jad_bo = jad_an2;
        jad_bo2.jad_cp = config;
        android.graphics.Bitmap.Config[] jad_an3 = jad_an(config);
        int length = jad_an3.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            android.graphics.Bitmap.Config config2 = jad_an3[i3];
            java.lang.Integer ceilingKey = jad_bo(config2).ceilingKey(java.lang.Integer.valueOf(jad_an2));
            if (ceilingKey == null || ceilingKey.intValue() > jad_an2 * 8) {
                i3++;
            } else if (ceilingKey.intValue() != jad_an2 || (config2 != null ? !config2.equals(config) : config != null)) {
                com.jd.ad.sdk.jad_ny.jad_na.jad_cp jad_cpVar = this.jad_an;
                if (jad_cpVar.jad_an.size() < 20) {
                    jad_cpVar.jad_an.offer(jad_bo2);
                }
                jad_bo2 = this.jad_an.jad_an(ceilingKey.intValue(), config2);
            }
        }
        android.graphics.Bitmap jad_an4 = this.jad_bo.jad_an(jad_bo2);
        if (jad_an4 != null) {
            jad_an(java.lang.Integer.valueOf(jad_bo2.jad_bo), jad_an4);
            jad_an4.reconfigure(i, i2, config);
        }
        return jad_an4;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public void jad_an(android.graphics.Bitmap bitmap) {
        com.jd.ad.sdk.jad_ny.jad_na.jad_bo jad_an2 = this.jad_an.jad_an(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap), bitmap.getConfig());
        this.jad_bo.jad_an(jad_an2, bitmap);
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> jad_bo2 = jad_bo(bitmap.getConfig());
        java.lang.Integer num = jad_bo2.get(java.lang.Integer.valueOf(jad_an2.jad_bo));
        jad_bo2.put(java.lang.Integer.valueOf(jad_an2.jad_bo), java.lang.Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final void jad_an(java.lang.Integer num, android.graphics.Bitmap bitmap) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> jad_bo2 = jad_bo(bitmap.getConfig());
        java.lang.Integer num2 = jad_bo2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                jad_bo2.remove(num);
                return;
            } else {
                jad_bo2.put(num, java.lang.Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new java.lang.NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + jad_bo(bitmap) + ", this: " + this);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public java.lang.String jad_bo(int i, int i2, android.graphics.Bitmap.Config config) {
        return jad_an(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(config) * i * i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public java.lang.String jad_bo(android.graphics.Bitmap bitmap) {
        return jad_an(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap), bitmap.getConfig());
    }

    public final java.util.NavigableMap<java.lang.Integer, java.lang.Integer> jad_bo(android.graphics.Bitmap.Config config) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> navigableMap = this.jad_cp.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        this.jad_cp.put(config, treeMap);
        return treeMap;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public int jad_cp(android.graphics.Bitmap bitmap) {
        return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("SizeConfigStrategy{groupedMap=");
        jad_an2.append(this.jad_bo);
        jad_an2.append(", sortedSizes=(");
        for (java.util.Map.Entry<android.graphics.Bitmap.Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> entry : this.jad_cp.entrySet()) {
            jad_an2.append(entry.getKey());
            jad_an2.append('[');
            jad_an2.append(entry.getValue());
            jad_an2.append("], ");
        }
        if (!this.jad_cp.isEmpty()) {
            jad_an2.replace(jad_an2.length() - 2, jad_an2.length(), "");
        }
        jad_an2.append(")}");
        return jad_an2.toString();
    }
}
