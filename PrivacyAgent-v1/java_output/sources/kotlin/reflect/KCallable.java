package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J%\u0010$\u001a\u00028\u00002\u0016\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010'0&\"\u0004\u0018\u00010'H&¢\u0006\u0002\u0010(J#\u0010)\u001a\u00028\u00002\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010'0*H&¢\u0006\u0002\u0010+R\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "isSuspend", "isSuspend$annotations", "name", "", "getName", "()Ljava/lang/String;", com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS, "", "Lkotlin/reflect/KParameter;", "getParameters", "()Ljava/util/List;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", androidx.core.app.NotificationCompat.CATEGORY_CALL, "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public interface KCallable<R> extends kotlin.reflect.KAnnotatedElement {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void getTypeParameters$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void getVisibility$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isAbstract$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.3")
        public static /* synthetic */ void isSuspend$annotations() {
        }
    }

    R call(@org.jetbrains.annotations.NotNull java.lang.Object... args);

    R callBy(@org.jetbrains.annotations.NotNull java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> args);

    @org.jetbrains.annotations.NotNull
    java.lang.String getName();

    @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.reflect.KParameter> getParameters();

    @org.jetbrains.annotations.NotNull
    kotlin.reflect.KType getReturnType();

    @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.reflect.KTypeParameter> getTypeParameters();

    @org.jetbrains.annotations.Nullable
    kotlin.reflect.KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
