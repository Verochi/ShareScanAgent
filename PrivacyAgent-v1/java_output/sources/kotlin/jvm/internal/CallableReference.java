package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public abstract class CallableReference implements kotlin.reflect.KCallable, java.io.Serializable {

    @kotlin.SinceKotlin(version = "1.1")
    public static final java.lang.Object NO_RECEIVER = kotlin.jvm.internal.CallableReference.NoReceiver.INSTANCE;

    @kotlin.SinceKotlin(version = "1.4")
    private final boolean isTopLevel;

    @kotlin.SinceKotlin(version = "1.4")
    private final java.lang.String name;

    @kotlin.SinceKotlin(version = "1.4")
    private final java.lang.Class owner;

    @kotlin.SinceKotlin(version = "1.1")
    protected final java.lang.Object receiver;
    private transient kotlin.reflect.KCallable reflected;

    @kotlin.SinceKotlin(version = "1.4")
    private final java.lang.String signature;

    @kotlin.SinceKotlin(version = "1.2")
    public static class NoReceiver implements java.io.Serializable {
        private static final kotlin.jvm.internal.CallableReference.NoReceiver INSTANCE = new kotlin.jvm.internal.CallableReference.NoReceiver();

        private NoReceiver() {
        }

        private java.lang.Object readResolve() throws java.io.ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @kotlin.SinceKotlin(version = "1.1")
    public CallableReference(java.lang.Object obj) {
        this(obj, null, null, null, false);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public CallableReference(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // kotlin.reflect.KCallable
    public java.lang.Object call(java.lang.Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.KCallable
    public java.lang.Object callBy(java.util.Map map) {
        return getReflected().callBy(map);
    }

    @kotlin.SinceKotlin(version = "1.1")
    public kotlin.reflect.KCallable compute() {
        kotlin.reflect.KCallable kCallable = this.reflected;
        if (kCallable != null) {
            return kCallable;
        }
        kotlin.reflect.KCallable computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    public abstract kotlin.reflect.KCallable computeReflected();

    @Override // kotlin.reflect.KAnnotatedElement
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @kotlin.SinceKotlin(version = "1.1")
    public java.lang.Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.KCallable
    public java.lang.String getName() {
        return this.name;
    }

    public kotlin.reflect.KDeclarationContainer getOwner() {
        java.lang.Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? kotlin.jvm.internal.Reflection.getOrCreateKotlinPackage(cls) : kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.reflect.KCallable
    public java.util.List<kotlin.reflect.KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @kotlin.SinceKotlin(version = "1.1")
    public kotlin.reflect.KCallable getReflected() {
        kotlin.reflect.KCallable compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new kotlin.jvm.KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KCallable
    public kotlin.reflect.KType getReturnType() {
        return getReflected().getReturnType();
    }

    public java.lang.String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.KCallable
    @kotlin.SinceKotlin(version = "1.1")
    public java.util.List<kotlin.reflect.KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    @kotlin.SinceKotlin(version = "1.1")
    public kotlin.reflect.KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    @kotlin.SinceKotlin(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    @kotlin.SinceKotlin(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    @kotlin.SinceKotlin(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    @kotlin.SinceKotlin(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
