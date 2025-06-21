package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public abstract class NativeBase {
    private static final java.lang.String CREATE_OVERLAY = "createOverlay";
    private static final int STACK_NUMBER = 3;
    private static final java.lang.String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    protected boolean useRunnable = true;
    protected volatile boolean destroy = false;
    java.util.ArrayList<com.autonavi.base.amap.mapcore.NativeBase.Method> methodMap = new java.util.ArrayList<>();
    java.util.ArrayList<java.lang.Runnable> runnableArrayList = new java.util.ArrayList<>();

    public static class Method {
        private boolean baseClass;
        private java.lang.Class<?>[] clazz;
        private java.lang.String methodName;
        private java.lang.Object object;
        private java.lang.Object[] param;

        public Method(java.lang.Object obj, java.lang.String str, boolean z, java.lang.Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new java.lang.Class[objArr.length];
                        if ((com.autonavi.base.amap.mapcore.NativeBase.CREATE_OVERLAY.equals(str) || com.autonavi.base.amap.mapcore.NativeBase.UPDATE_OPTIONS.equals(str)) ? true : z) {
                            for (int i = 0; i < objArr.length; i++) {
                                if (i == 1) {
                                    this.clazz[i] = objArr[i].getClass().getSuperclass();
                                } else {
                                    this.clazz[i] = objArr[i].getClass();
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < objArr.length; i2++) {
                                this.clazz[i2] = objArr[i2].getClass();
                            }
                        }
                        this.param = new java.lang.Object[objArr.length];
                        for (int i3 = 0; i3 < objArr.length; i3++) {
                            this.param[i3] = objArr[i3];
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public synchronized void callAllFunction() {
        java.lang.reflect.Method declaredMethod;
        if (isReady() && !this.destroy) {
            if (this.mCalledFuntion) {
                return;
            }
            try {
                this.mCalledFuntion = true;
                if (this.useRunnable) {
                    while (this.runnableArrayList.size() > 0 && !this.destroy) {
                        java.lang.Runnable runnable = this.runnableArrayList.get(0);
                        if (runnable != null) {
                            runnable.run();
                        }
                        this.runnableArrayList.remove(0);
                    }
                    return;
                }
                java.util.Iterator<com.autonavi.base.amap.mapcore.NativeBase.Method> it = this.methodMap.iterator();
                while (it.hasNext()) {
                    com.autonavi.base.amap.mapcore.NativeBase.Method next = it.next();
                    if (this.destroy) {
                        break;
                    }
                    if (next.object != null && (declaredMethod = next.object.getClass().getDeclaredMethod(next.methodName, next.clazz)) != null) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(next.object, next.param);
                    }
                }
                this.methodMap.clear();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    public void finalize() throws java.lang.Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    public abstract void finalizeNative();

    public abstract long getNative();

    public boolean isReady() {
        return getNative() != 0;
    }

    public synchronized void storeUncallFunction(java.lang.Object obj, java.lang.Object obj2, java.lang.Object... objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new com.autonavi.base.amap.mapcore.NativeBase.Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((java.lang.Runnable) obj2);
                }
            }
            this.mCalledFuntion = false;
        } catch (java.lang.Throwable unused) {
        }
    }

    public synchronized void storeUncallFunctionArray(java.lang.Object obj, java.lang.Object obj2, java.lang.Object[] objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new com.autonavi.base.amap.mapcore.NativeBase.Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((java.lang.Runnable) obj2);
                }
            }
            this.mCalledFuntion = false;
        } catch (java.lang.Throwable unused) {
        }
    }

    public void validate() {
        com.autonavi.base.amap.mapcore.annotations.ParameterIsClass parameterIsClass;
        java.lang.Class<?>[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods == null) {
            return;
        }
        for (java.lang.reflect.Method method : methods) {
            if (method.isAnnotationPresent(com.autonavi.base.amap.mapcore.annotations.ParameterIsClass.class) && (parameterIsClass = (com.autonavi.base.amap.mapcore.annotations.ParameterIsClass) method.getAnnotation(com.autonavi.base.amap.mapcore.annotations.ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                for (java.lang.Class<?> cls : parameterTypes) {
                    if (!(cls instanceof java.lang.Object)) {
                        throw new java.lang.RuntimeException("函数：" + method + " 参数不是对象类型");
                    }
                }
            }
        }
    }
}
