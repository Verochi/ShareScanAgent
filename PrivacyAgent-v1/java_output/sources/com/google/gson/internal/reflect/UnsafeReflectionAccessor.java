package com.google.gson.internal.reflect;

/* loaded from: classes22.dex */
final class UnsafeReflectionAccessor extends com.google.gson.internal.reflect.ReflectionAccessor {
    private static java.lang.Class unsafeClass;
    private final java.lang.Object theUnsafe = getUnsafeInstance();
    private final java.lang.reflect.Field overrideField = getOverrideField();

    private static java.lang.reflect.Field getOverrideField() {
        try {
            return java.lang.reflect.AccessibleObject.class.getDeclaredField("override");
        } catch (java.lang.NoSuchFieldException unused) {
            return null;
        }
    }

    private static java.lang.Object getUnsafeInstance() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("sun.misc.Unsafe");
            unsafeClass = cls;
            java.lang.reflect.Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(java.lang.reflect.AccessibleObject accessibleObject) {
        if (makeAccessibleWithUnsafe(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (java.lang.SecurityException e) {
            throw new com.google.gson.JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }

    public boolean makeAccessibleWithUnsafe(java.lang.reflect.AccessibleObject accessibleObject) {
        if (this.theUnsafe != null && this.overrideField != null) {
            try {
                unsafeClass.getMethod("putBoolean", java.lang.Object.class, java.lang.Long.TYPE, java.lang.Boolean.TYPE).invoke(this.theUnsafe, accessibleObject, java.lang.Long.valueOf(((java.lang.Long) unsafeClass.getMethod("objectFieldOffset", java.lang.reflect.Field.class).invoke(this.theUnsafe, this.overrideField)).longValue()), java.lang.Boolean.TRUE);
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }
}
