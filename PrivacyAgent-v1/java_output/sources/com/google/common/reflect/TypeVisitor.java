package com.google.common.reflect;

/* loaded from: classes22.dex */
abstract class TypeVisitor {
    public final java.util.Set<java.lang.reflect.Type> a = com.google.common.collect.Sets.newHashSet();

    public final void a(java.lang.reflect.Type... typeArr) {
        for (java.lang.reflect.Type type : typeArr) {
            if (type != null && this.a.add(type)) {
                try {
                    if (type instanceof java.lang.reflect.TypeVariable) {
                        e((java.lang.reflect.TypeVariable) type);
                    } else if (type instanceof java.lang.reflect.WildcardType) {
                        f((java.lang.reflect.WildcardType) type);
                    } else if (type instanceof java.lang.reflect.ParameterizedType) {
                        d((java.lang.reflect.ParameterizedType) type);
                    } else if (type instanceof java.lang.Class) {
                        b((java.lang.Class) type);
                    } else {
                        if (!(type instanceof java.lang.reflect.GenericArrayType)) {
                            throw new java.lang.AssertionError("Unknown type: " + type);
                        }
                        c((java.lang.reflect.GenericArrayType) type);
                    }
                } catch (java.lang.Throwable th) {
                    this.a.remove(type);
                    throw th;
                }
            }
        }
    }

    public void b(java.lang.Class<?> cls) {
    }

    public void c(java.lang.reflect.GenericArrayType genericArrayType) {
    }

    public void d(java.lang.reflect.ParameterizedType parameterizedType) {
    }

    public void e(java.lang.reflect.TypeVariable<?> typeVariable) {
    }

    public void f(java.lang.reflect.WildcardType wildcardType) {
    }
}
