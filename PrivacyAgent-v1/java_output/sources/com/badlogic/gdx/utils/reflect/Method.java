package com.badlogic.gdx.utils.reflect;

/* loaded from: classes12.dex */
public final class Method {
    public final java.lang.reflect.Method a;

    public Method(java.lang.reflect.Method method) {
        this.a = method;
    }

    public com.badlogic.gdx.utils.reflect.Annotation getDeclaredAnnotation(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        java.lang.annotation.Annotation[] declaredAnnotations = this.a.getDeclaredAnnotations();
        if (declaredAnnotations == null) {
            return null;
        }
        for (java.lang.annotation.Annotation annotation : declaredAnnotations) {
            if (annotation.annotationType().equals(cls)) {
                return new com.badlogic.gdx.utils.reflect.Annotation(annotation);
            }
        }
        return null;
    }

    public com.badlogic.gdx.utils.reflect.Annotation[] getDeclaredAnnotations() {
        java.lang.annotation.Annotation[] declaredAnnotations = this.a.getDeclaredAnnotations();
        com.badlogic.gdx.utils.reflect.Annotation[] annotationArr = new com.badlogic.gdx.utils.reflect.Annotation[declaredAnnotations.length];
        for (int i = 0; i < declaredAnnotations.length; i++) {
            annotationArr[i] = new com.badlogic.gdx.utils.reflect.Annotation(declaredAnnotations[i]);
        }
        return annotationArr;
    }

    public java.lang.Class getDeclaringClass() {
        return this.a.getDeclaringClass();
    }

    public java.lang.String getName() {
        return this.a.getName();
    }

    public java.lang.Class[] getParameterTypes() {
        return this.a.getParameterTypes();
    }

    public java.lang.Class getReturnType() {
        return this.a.getReturnType();
    }

    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object... objArr) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return this.a.invoke(obj, objArr);
        } catch (java.lang.IllegalAccessException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Illegal access to method: " + getName(), e);
        } catch (java.lang.IllegalArgumentException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Illegal argument(s) supplied to method: " + getName(), e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Exception occurred in method: " + getName(), e3);
        }
    }

    public boolean isAbstract() {
        return java.lang.reflect.Modifier.isAbstract(this.a.getModifiers());
    }

    public boolean isAccessible() {
        return this.a.isAccessible();
    }

    public boolean isAnnotationPresent(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public boolean isDefaultAccess() {
        return (isPrivate() || isProtected() || isPublic()) ? false : true;
    }

    public boolean isFinal() {
        return java.lang.reflect.Modifier.isFinal(this.a.getModifiers());
    }

    public boolean isNative() {
        return java.lang.reflect.Modifier.isNative(this.a.getModifiers());
    }

    public boolean isPrivate() {
        return java.lang.reflect.Modifier.isPrivate(this.a.getModifiers());
    }

    public boolean isProtected() {
        return java.lang.reflect.Modifier.isProtected(this.a.getModifiers());
    }

    public boolean isPublic() {
        return java.lang.reflect.Modifier.isPublic(this.a.getModifiers());
    }

    public boolean isStatic() {
        return java.lang.reflect.Modifier.isStatic(this.a.getModifiers());
    }

    public boolean isVarArgs() {
        return this.a.isVarArgs();
    }

    public void setAccessible(boolean z) {
        this.a.setAccessible(z);
    }
}
