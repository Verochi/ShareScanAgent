package com.badlogic.gdx.utils.reflect;

/* loaded from: classes12.dex */
public final class Constructor {
    public final java.lang.reflect.Constructor a;

    public Constructor(java.lang.reflect.Constructor constructor) {
        this.a = constructor;
    }

    public java.lang.Class getDeclaringClass() {
        return this.a.getDeclaringClass();
    }

    public java.lang.Class[] getParameterTypes() {
        return this.a.getParameterTypes();
    }

    public boolean isAccessible() {
        return this.a.isAccessible();
    }

    public java.lang.Object newInstance(java.lang.Object... objArr) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return this.a.newInstance(objArr);
        } catch (java.lang.IllegalAccessException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Could not instantiate instance of class: " + getDeclaringClass().getName(), e);
        } catch (java.lang.IllegalArgumentException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Illegal argument(s) supplied to constructor for class: " + getDeclaringClass().getName(), e2);
        } catch (java.lang.InstantiationException e3) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Could not instantiate instance of class: " + getDeclaringClass().getName(), e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Exception occurred in constructor for class: " + getDeclaringClass().getName(), e4);
        }
    }

    public void setAccessible(boolean z) {
        this.a.setAccessible(z);
    }
}
