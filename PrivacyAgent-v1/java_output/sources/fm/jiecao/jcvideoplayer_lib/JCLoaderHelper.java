package fm.jiecao.jcvideoplayer_lib;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0003¨\u0006\n"}, d2 = {"Lfm/jiecao/jcvideoplayer_lib/JCLoaderHelper;", "", "", "soPath", "", "fixSoLinkError", "path", "a", "<init>", "()V", "MJVideoModule_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes9.dex */
public final class JCLoaderHelper {

    @org.jetbrains.annotations.NotNull
    public static final fm.jiecao.jcvideoplayer_lib.JCLoaderHelper INSTANCE = new fm.jiecao.jcvideoplayer_lib.JCLoaderHelper();

    @kotlin.jvm.JvmStatic
    public static final void a(java.lang.String path) {
        java.io.File file;
        java.lang.ClassLoader classLoader = com.moji.tool.AppDelegate.getAppContext().getApplicationContext().getClassLoader();
        if (!(classLoader instanceof dalvik.system.BaseDexClassLoader)) {
            com.moji.tool.log.MJLogger.w("JCLoaderHelper", "Not BaseDexClassLoader:" + classLoader.getClass().getName());
            return;
        }
        java.lang.reflect.Field declaredField = dalvik.system.BaseDexClassLoader.class.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        java.lang.Object obj = declaredField.get(classLoader);
        java.lang.reflect.Field declaredField2 = java.lang.Class.forName("dalvik.system.DexPathList").getDeclaredField("nativeLibraryDirectories");
        declaredField2.setAccessible(true);
        java.lang.Object obj2 = declaredField2.get(obj);
        if (obj2 == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<java.io.File>");
        }
        java.io.File[] fileArr = (java.io.File[]) obj2;
        int length = fileArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                file = null;
                break;
            }
            file = fileArr[i];
            if (kotlin.jvm.internal.Intrinsics.areEqual(file.getAbsolutePath(), path)) {
                break;
            } else {
                i++;
            }
        }
        if (file != null) {
            com.moji.tool.log.MJLogger.d("JCLoaderHelper", "Path already there");
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, fileArr);
        arrayList.add(new java.io.File(path));
        java.lang.Object[] array = arrayList.toArray(new java.io.File[0]);
        if (array == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        declaredField2.set(obj, (java.io.File[]) array);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[Catch: Exception -> 0x002d, TRY_LEAVE, TryCatch #0 {Exception -> 0x002d, blocks: (B:6:0x000c, B:8:0x0017, B:14:0x0024), top: B:5:0x000c }] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void fixSoLinkError(@org.jetbrains.annotations.NotNull java.lang.String soPath) {
        boolean z;
        boolean isBlank;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(soPath, "soPath");
        if (android.os.Build.VERSION.SDK_INT != 22) {
            return;
        }
        try {
            java.lang.String dirPath = new java.io.File(soPath).getParent();
            if (dirPath != null) {
                isBlank = kotlin.text.StringsKt__StringsJVMKt.isBlank(dirPath);
                if (!isBlank) {
                    z = false;
                    if (z) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dirPath, "dirPath");
                        a(dirPath);
                        return;
                    }
                    return;
                }
            }
            z = true;
            if (z) {
            }
        } catch (java.lang.Exception e) {
            com.moji.tool.log.MJLogger.e(fm.jiecao.jcvideoplayer_lib.JCMediaManager.TAG, "Add native dir failed", e);
            com.moji.tool.log.MJLogger.postCatchedException(e);
        }
    }
}
