package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public class Caller {
    private static final java.lang.String TAG = "SA.Caller";
    private final java.lang.Object[] mMethodArgs;
    private final java.lang.String mMethodName;
    private final java.lang.Class<?> mMethodResultType;
    private final java.lang.Class<?> mTargetClass;
    private final java.lang.reflect.Method mTargetMethod;

    public Caller(java.lang.Class<?> cls, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?> cls2) throws java.lang.NoSuchMethodException {
        this.mMethodName = str;
        this.mMethodArgs = objArr;
        this.mMethodResultType = cls2;
        java.lang.reflect.Method pickMethod = pickMethod(cls);
        this.mTargetMethod = pickMethod;
        if (pickMethod != null) {
            this.mTargetClass = pickMethod.getDeclaringClass();
            pickMethod.setAccessible(true);
            return;
        }
        throw new java.lang.NoSuchMethodException("Method " + cls.getName() + "." + str + " doesn't exit");
    }

    private static java.lang.Class<?> assignableArgType(java.lang.Class<?> cls) {
        return cls == java.lang.Byte.class ? java.lang.Byte.TYPE : cls == java.lang.Short.class ? java.lang.Short.TYPE : cls == java.lang.Integer.class ? java.lang.Integer.TYPE : cls == java.lang.Long.class ? java.lang.Long.TYPE : cls == java.lang.Float.class ? java.lang.Float.TYPE : cls == java.lang.Double.class ? java.lang.Double.TYPE : cls == java.lang.Boolean.class ? java.lang.Boolean.TYPE : cls == java.lang.Character.class ? java.lang.Character.TYPE : cls;
    }

    private java.lang.reflect.Method pickMethod(java.lang.Class<?> cls) {
        java.lang.Class[] clsArr = new java.lang.Class[this.mMethodArgs.length];
        int i = 0;
        while (true) {
            java.lang.Object[] objArr = this.mMethodArgs;
            if (i >= objArr.length) {
                break;
            }
            clsArr[i] = objArr[i].getClass();
            i++;
        }
        for (java.lang.reflect.Method method : cls.getMethods()) {
            java.lang.String name = method.getName();
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.mMethodName) && parameterTypes.length == this.mMethodArgs.length && assignableArgType(this.mMethodResultType).isAssignableFrom(assignableArgType(method.getReturnType()))) {
                boolean z = true;
                for (int i2 = 0; i2 < parameterTypes.length && z; i2++) {
                    z = assignableArgType(parameterTypes[i2]).isAssignableFrom(assignableArgType(clsArr[i2]));
                }
                if (z) {
                    return method;
                }
            }
        }
        return null;
    }

    public java.lang.Object applyMethod(android.view.View view) {
        return applyMethodWithArguments(view, this.mMethodArgs);
    }

    public java.lang.Object applyMethodWithArguments(android.view.View view, java.lang.Object[] objArr) {
        if (!this.mTargetClass.isAssignableFrom(view.getClass())) {
            return null;
        }
        try {
            return this.mTargetMethod.invoke(view, objArr);
        } catch (java.lang.IllegalAccessException e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " appears not to be public", e);
            return null;
        } catch (java.lang.IllegalArgumentException e2) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " called with arguments of the wrong type", e2);
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " threw an exception", e3);
            return null;
        }
    }

    public boolean argsAreApplicable(java.lang.Object[] objArr) {
        java.lang.Class<?>[] parameterTypes = this.mTargetMethod.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Class<?> assignableArgType = assignableArgType(parameterTypes[i]);
            java.lang.Object obj = objArr[i];
            if (obj == null) {
                if (assignableArgType == java.lang.Byte.TYPE || assignableArgType == java.lang.Short.TYPE || assignableArgType == java.lang.Integer.TYPE || assignableArgType == java.lang.Long.TYPE || assignableArgType == java.lang.Float.TYPE || assignableArgType == java.lang.Double.TYPE || assignableArgType == java.lang.Boolean.TYPE || assignableArgType == java.lang.Character.TYPE) {
                    return false;
                }
            } else if (!assignableArgType.isAssignableFrom(assignableArgType(obj.getClass()))) {
                return false;
            }
        }
        return true;
    }

    public java.lang.Object[] getArgs() {
        return this.mMethodArgs;
    }

    public java.lang.String toString() {
        return "[Caller " + this.mMethodName + "(" + this.mMethodArgs + ")]";
    }
}
