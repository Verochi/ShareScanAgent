package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0013\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010\u0002H¦\u0002J\b\u0010B\u001a\u00020CH&J\u0012\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u0002H'R\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001e\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\nR\u001c\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R(\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000-8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u000e\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0004\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010+R \u00103\u001a\b\u0012\u0004\u0012\u0002040-8&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000e\u001a\u0004\b6\u00100R \u00107\u001a\b\u0012\u0004\u0012\u0002080-8&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u000e\u001a\u0004\b:\u00100R\u001c\u0010;\u001a\u0004\u0018\u00010<8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lkotlin/reflect/KClass;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "", "getSealedSubclasses$annotations", "getSealedSubclasses", "()Ljava/util/List;", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "isInstance", "value", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public interface KClass<T> extends kotlin.reflect.KDeclarationContainer, kotlin.reflect.KAnnotatedElement, kotlin.reflect.KClassifier {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @kotlin.SinceKotlin(version = "1.3")
        public static /* synthetic */ void getSealedSubclasses$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void getSupertypes$annotations() {
        }

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
        public static /* synthetic */ void isCompanion$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isData$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.4")
        public static /* synthetic */ void isFun$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isInner$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void isSealed$annotations() {
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        public static /* synthetic */ void isValue$annotations() {
        }
    }

    boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other);

    @org.jetbrains.annotations.NotNull
    java.util.Collection<kotlin.reflect.KFunction<T>> getConstructors();

    @Override // kotlin.reflect.KDeclarationContainer
    @org.jetbrains.annotations.NotNull
    java.util.Collection<kotlin.reflect.KCallable<?>> getMembers();

    @org.jetbrains.annotations.NotNull
    java.util.Collection<kotlin.reflect.KClass<?>> getNestedClasses();

    @org.jetbrains.annotations.Nullable
    T getObjectInstance();

    @org.jetbrains.annotations.Nullable
    java.lang.String getQualifiedName();

    @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.reflect.KClass<? extends T>> getSealedSubclasses();

    @org.jetbrains.annotations.Nullable
    java.lang.String getSimpleName();

    @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.reflect.KType> getSupertypes();

    @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.reflect.KTypeParameter> getTypeParameters();

    @org.jetbrains.annotations.Nullable
    kotlin.reflect.KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isFun();

    boolean isInner();

    @kotlin.SinceKotlin(version = "1.1")
    boolean isInstance(@org.jetbrains.annotations.Nullable java.lang.Object value);

    boolean isOpen();

    boolean isSealed();

    boolean isValue();
}
