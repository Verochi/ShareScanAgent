package androidx.lifecycle;

@java.lang.Deprecated
/* loaded from: classes.dex */
final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static androidx.lifecycle.ClassesInfoCache sInstance = new androidx.lifecycle.ClassesInfoCache();
    private final java.util.Map<java.lang.Class<?>, androidx.lifecycle.ClassesInfoCache.CallbackInfo> mCallbackMap = new java.util.HashMap();
    private final java.util.Map<java.lang.Class<?>, java.lang.Boolean> mHasLifecycleMethods = new java.util.HashMap();

    @java.lang.Deprecated
    public static class CallbackInfo {
        final java.util.Map<androidx.lifecycle.Lifecycle.Event, java.util.List<androidx.lifecycle.ClassesInfoCache.MethodReference>> mEventToHandlers = new java.util.HashMap();
        final java.util.Map<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> mHandlerToEvent;

        public CallbackInfo(java.util.Map<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> map) {
            this.mHandlerToEvent = map;
            for (java.util.Map.Entry<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> entry : map.entrySet()) {
                androidx.lifecycle.Lifecycle.Event value = entry.getValue();
                java.util.List<androidx.lifecycle.ClassesInfoCache.MethodReference> list = this.mEventToHandlers.get(value);
                if (list == null) {
                    list = new java.util.ArrayList<>();
                    this.mEventToHandlers.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void invokeMethodsForEvent(java.util.List<androidx.lifecycle.ClassesInfoCache.MethodReference> list, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event, java.lang.Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).invokeCallback(lifecycleOwner, event, obj);
                }
            }
        }

        public void invokeCallbacks(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event, java.lang.Object obj) {
            invokeMethodsForEvent(this.mEventToHandlers.get(event), lifecycleOwner, event, obj);
            invokeMethodsForEvent(this.mEventToHandlers.get(androidx.lifecycle.Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    @java.lang.Deprecated
    public static final class MethodReference {
        final int mCallType;
        final java.lang.reflect.Method mMethod;

        public MethodReference(int i, java.lang.reflect.Method method) {
            this.mCallType = i;
            this.mMethod = method;
            method.setAccessible(true);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.lifecycle.ClassesInfoCache.MethodReference)) {
                return false;
            }
            androidx.lifecycle.ClassesInfoCache.MethodReference methodReference = (androidx.lifecycle.ClassesInfoCache.MethodReference) obj;
            return this.mCallType == methodReference.mCallType && this.mMethod.getName().equals(methodReference.mMethod.getName());
        }

        public int hashCode() {
            return (this.mCallType * 31) + this.mMethod.getName().hashCode();
        }

        public void invokeCallback(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event, java.lang.Object obj) {
            try {
                int i = this.mCallType;
                if (i == 0) {
                    this.mMethod.invoke(obj, new java.lang.Object[0]);
                } else if (i == 1) {
                    this.mMethod.invoke(obj, lifecycleOwner);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.mMethod.invoke(obj, lifecycleOwner, event);
                }
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException(e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw new java.lang.RuntimeException("Failed to call observer method", e2.getCause());
            }
        }
    }

    private androidx.lifecycle.ClassesInfoCache.CallbackInfo createInfo(java.lang.Class<?> cls, @androidx.annotation.Nullable java.lang.reflect.Method[] methodArr) {
        int i;
        androidx.lifecycle.ClassesInfoCache.CallbackInfo info;
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        java.util.HashMap hashMap = new java.util.HashMap();
        if (superclass != null && (info = getInfo(superclass)) != null) {
            hashMap.putAll(info.mHandlerToEvent);
        }
        for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
            for (java.util.Map.Entry<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> entry : getInfo(cls2).mHandlerToEvent.entrySet()) {
                verifyAndPutHandler(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = getDeclaredMethods(cls);
        }
        boolean z = false;
        for (java.lang.reflect.Method method : methodArr) {
            androidx.lifecycle.OnLifecycleEvent onLifecycleEvent = (androidx.lifecycle.OnLifecycleEvent) method.getAnnotation(androidx.lifecycle.OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(androidx.lifecycle.LifecycleOwner.class)) {
                        throw new java.lang.IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                androidx.lifecycle.Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(androidx.lifecycle.Lifecycle.Event.class)) {
                        throw new java.lang.IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != androidx.lifecycle.Lifecycle.Event.ON_ANY) {
                        throw new java.lang.IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new java.lang.IllegalArgumentException("cannot have more than 2 params");
                }
                verifyAndPutHandler(hashMap, new androidx.lifecycle.ClassesInfoCache.MethodReference(i, method), value, cls);
                z = true;
            }
        }
        androidx.lifecycle.ClassesInfoCache.CallbackInfo callbackInfo = new androidx.lifecycle.ClassesInfoCache.CallbackInfo(hashMap);
        this.mCallbackMap.put(cls, callbackInfo);
        this.mHasLifecycleMethods.put(cls, java.lang.Boolean.valueOf(z));
        return callbackInfo;
    }

    private java.lang.reflect.Method[] getDeclaredMethods(java.lang.Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (java.lang.NoClassDefFoundError e) {
            throw new java.lang.IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private void verifyAndPutHandler(java.util.Map<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> map, androidx.lifecycle.ClassesInfoCache.MethodReference methodReference, androidx.lifecycle.Lifecycle.Event event, java.lang.Class<?> cls) {
        androidx.lifecycle.Lifecycle.Event event2 = map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("Method " + methodReference.mMethod.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    public androidx.lifecycle.ClassesInfoCache.CallbackInfo getInfo(java.lang.Class<?> cls) {
        androidx.lifecycle.ClassesInfoCache.CallbackInfo callbackInfo = this.mCallbackMap.get(cls);
        return callbackInfo != null ? callbackInfo : createInfo(cls, null);
    }

    public boolean hasLifecycleMethods(java.lang.Class<?> cls) {
        java.lang.Boolean bool = this.mHasLifecycleMethods.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        java.lang.reflect.Method[] declaredMethods = getDeclaredMethods(cls);
        for (java.lang.reflect.Method method : declaredMethods) {
            if (((androidx.lifecycle.OnLifecycleEvent) method.getAnnotation(androidx.lifecycle.OnLifecycleEvent.class)) != null) {
                createInfo(cls, declaredMethods);
                return true;
            }
        }
        this.mHasLifecycleMethods.put(cls, java.lang.Boolean.FALSE);
        return false;
    }
}
