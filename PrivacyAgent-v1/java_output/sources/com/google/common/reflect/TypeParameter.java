package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public abstract class TypeParameter<T> extends com.google.common.reflect.TypeCapture<T> {
    public final java.lang.reflect.TypeVariable<?> n;

    public TypeParameter() {
        java.lang.reflect.Type capture = capture();
        com.google.common.base.Preconditions.checkArgument(capture instanceof java.lang.reflect.TypeVariable, "%s should be a type variable.", capture);
        this.n = (java.lang.reflect.TypeVariable) capture;
    }

    public final boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof com.google.common.reflect.TypeParameter) {
            return this.n.equals(((com.google.common.reflect.TypeParameter) obj).n);
        }
        return false;
    }

    public final int hashCode() {
        return this.n.hashCode();
    }

    public java.lang.String toString() {
        return this.n.toString();
    }
}
