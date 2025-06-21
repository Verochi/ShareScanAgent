package com.airbnb.lottie.model;

/* loaded from: classes.dex */
public class KeyPath {
    public static final com.airbnb.lottie.model.KeyPath COMPOSITION = new com.airbnb.lottie.model.KeyPath("COMPOSITION");
    public final java.util.List<java.lang.String> a;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.KeyPathElement b;

    public KeyPath(com.airbnb.lottie.model.KeyPath keyPath) {
        this.a = new java.util.ArrayList(keyPath.a);
        this.b = keyPath.b;
    }

    public KeyPath(java.lang.String... strArr) {
        this.a = java.util.Arrays.asList(strArr);
    }

    public final boolean a() {
        return this.a.get(r0.size() - 1).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH);
    }

    @androidx.annotation.CheckResult
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.airbnb.lottie.model.KeyPath addKey(java.lang.String str) {
        com.airbnb.lottie.model.KeyPath keyPath = new com.airbnb.lottie.model.KeyPath(this);
        keyPath.a.add(str);
        return keyPath;
    }

    public final boolean b(java.lang.String str) {
        return "__container".equals(str);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean fullyResolvesTo(java.lang.String str, int i) {
        if (i >= this.a.size()) {
            return false;
        }
        boolean z = i == this.a.size() - 1;
        java.lang.String str2 = this.a.get(i);
        if (!str2.equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH)) {
            return (z || (i == this.a.size() + (-2) && a())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.a.get(i + 1).equals(str)) {
            return i == this.a.size() + (-2) || (i == this.a.size() + (-3) && a());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.a.size() - 1) {
            return false;
        }
        return this.a.get(i2).equals(str);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.airbnb.lottie.model.KeyPathElement getResolvedElement() {
        return this.b;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public int incrementDepthBy(java.lang.String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (this.a.get(i).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH)) {
            return (i != this.a.size() - 1 && this.a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public java.lang.String keysToString() {
        return this.a.toString();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean matches(java.lang.String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.a.size()) {
            return false;
        }
        return this.a.get(i).equals(str) || this.a.get(i).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH) || this.a.get(i).equals("*");
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean propagateToChildren(java.lang.String str, int i) {
        return "__container".equals(str) || i < this.a.size() - 1 || this.a.get(i).equals(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public com.airbnb.lottie.model.KeyPath resolve(com.airbnb.lottie.model.KeyPathElement keyPathElement) {
        com.airbnb.lottie.model.KeyPath keyPath = new com.airbnb.lottie.model.KeyPath(this);
        keyPath.b = keyPathElement;
        return keyPath;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }
}
