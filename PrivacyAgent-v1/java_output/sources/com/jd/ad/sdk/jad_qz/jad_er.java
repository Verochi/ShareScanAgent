package com.jd.ad.sdk.jad_qz;

/* loaded from: classes23.dex */
public class jad_er {
    public static final com.jd.ad.sdk.jad_qz.jad_er jad_cp = new com.jd.ad.sdk.jad_qz.jad_er("COMPOSITION");
    public final java.util.List<java.lang.String> jad_an;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_qz.jad_fs jad_bo;

    public jad_er(com.jd.ad.sdk.jad_qz.jad_er jad_erVar) {
        this.jad_an = new java.util.ArrayList(jad_erVar.jad_an);
        this.jad_bo = jad_erVar.jad_bo;
    }

    public jad_er(java.lang.String... strArr) {
        this.jad_an = java.util.Arrays.asList(strArr);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.jd.ad.sdk.jad_qz.jad_er jad_an(com.jd.ad.sdk.jad_qz.jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_qz.jad_er jad_erVar = new com.jd.ad.sdk.jad_qz.jad_er(this);
        jad_erVar.jad_bo = jad_fsVar;
        return jad_erVar;
    }

    @androidx.annotation.CheckResult
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.jd.ad.sdk.jad_qz.jad_er jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_qz.jad_er jad_erVar = new com.jd.ad.sdk.jad_qz.jad_er(this);
        jad_erVar.jad_an.add(str);
        return jad_erVar;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean jad_an(java.lang.String str, int i) {
        if (i >= this.jad_an.size()) {
            return false;
        }
        boolean z = i == this.jad_an.size() - 1;
        java.lang.String str2 = this.jad_an.get(i);
        if (!str2.equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH)) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if (!z) {
                if (i != this.jad_an.size() - 2) {
                    return false;
                }
                java.util.List<java.lang.String> list = this.jad_an;
                if (!list.get(list.size() - 1).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH)) {
                    return false;
                }
            }
            return z2;
        }
        if (!(!z && this.jad_an.get(i + 1).equals(str))) {
            if (z) {
                return true;
            }
            int i2 = i + 1;
            if (i2 < this.jad_an.size() - 1) {
                return false;
            }
            return this.jad_an.get(i2).equals(str);
        }
        if (i != this.jad_an.size() - 2) {
            if (i != this.jad_an.size() - 3) {
                return false;
            }
            java.util.List<java.lang.String> list2 = this.jad_an;
            if (!list2.get(list2.size() - 1).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH)) {
                return false;
            }
        }
        return true;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public int jad_bo(java.lang.String str, int i) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (this.jad_an.get(i).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH)) {
            return (i != this.jad_an.size() - 1 && this.jad_an.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean jad_cp(java.lang.String str, int i) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i >= this.jad_an.size()) {
            return false;
        }
        return this.jad_an.get(i).equals(str) || this.jad_an.get(i).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH) || this.jad_an.get(i).equals("*");
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean jad_dq(java.lang.String str, int i) {
        return "__container".equals(str) || i < this.jad_an.size() - 1 || this.jad_an.get(i).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("KeyPath{keys=");
        jad_an.append(this.jad_an);
        jad_an.append(",resolved=");
        jad_an.append(this.jad_bo != null);
        jad_an.append('}');
        return jad_an.toString();
    }
}
