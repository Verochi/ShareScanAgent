package com.google.gson.internal.reflect;

/* loaded from: classes22.dex */
final class PreJava9ReflectionAccessor extends com.google.gson.internal.reflect.ReflectionAccessor {
    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(java.lang.reflect.AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
