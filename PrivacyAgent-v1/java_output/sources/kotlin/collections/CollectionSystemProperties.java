package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/collections/CollectionSystemProperties;", "", "()V", "brittleContainsOptimizationEnabled", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CollectionSystemProperties {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.CollectionSystemProperties INSTANCE = new kotlin.collections.CollectionSystemProperties();

    @kotlin.jvm.JvmField
    public static final boolean brittleContainsOptimizationEnabled;

    static {
        java.lang.String property = java.lang.System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        brittleContainsOptimizationEnabled = property != null ? java.lang.Boolean.parseBoolean(property) : false;
    }
}
