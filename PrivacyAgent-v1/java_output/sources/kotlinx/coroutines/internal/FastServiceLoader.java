package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J3\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "loadMainDispatcherFactory$kotlinx_coroutines_core", "()Ljava/util/List;", "loadMainDispatcherFactory", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Class;", "service", "Ljava/lang/ClassLoader;", "loader", "loadProviders$kotlinx_coroutines_core", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "loadProviders", "b", "", "name", "a", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/net/URL;", "url", "c", "Ljava/io/BufferedReader;", "r", "d", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class FastServiceLoader {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.FastServiceLoader INSTANCE = new kotlinx.coroutines.internal.FastServiceLoader();

    public final <S> S a(java.lang.String name, java.lang.ClassLoader loader, java.lang.Class<S> service) {
        java.lang.Class<?> cls = java.lang.Class.forName(name, false, loader);
        if (service.isAssignableFrom(cls)) {
            return service.cast(cls.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
        }
        throw new java.lang.IllegalArgumentException(("Expected service of class " + service + ", but found " + cls).toString());
    }

    public final <S> java.util.List<S> b(java.lang.Class<S> service, java.lang.ClassLoader loader) {
        try {
            return loadProviders$kotlinx_coroutines_core(service, loader);
        } catch (java.lang.Throwable unused) {
            return kotlin.collections.CollectionsKt___CollectionsKt.toList(java.util.ServiceLoader.load(service, loader));
        }
    }

    public final java.util.List<java.lang.String> c(java.net.URL url) {
        java.io.BufferedReader bufferedReader;
        java.lang.String substringAfter$default;
        java.lang.String substringBefore$default;
        java.lang.String substringAfter$default2;
        java.lang.String url2 = url.toString();
        if (!kotlin.text.StringsKt__StringsJVMKt.startsWith$default(url2, "jar", false, 2, null)) {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(url.openStream()));
            try {
                java.util.List<java.lang.String> d = INSTANCE.d(bufferedReader);
                kotlin.io.CloseableKt.closeFinally(bufferedReader, null);
                return d;
            } catch (java.lang.Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        substringAfter$default = kotlin.text.StringsKt__StringsKt.substringAfter$default(url2, "jar:file:", (java.lang.String) null, 2, (java.lang.Object) null);
        substringBefore$default = kotlin.text.StringsKt__StringsKt.substringBefore$default(substringAfter$default, '!', (java.lang.String) null, 2, (java.lang.Object) null);
        substringAfter$default2 = kotlin.text.StringsKt__StringsKt.substringAfter$default(url2, "!/", (java.lang.String) null, 2, (java.lang.Object) null);
        java.util.jar.JarFile jarFile = new java.util.jar.JarFile(substringBefore$default, false);
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(jarFile.getInputStream(new java.util.zip.ZipEntry(substringAfter$default2)), "UTF-8"));
            try {
                java.util.List<java.lang.String> d2 = INSTANCE.d(bufferedReader);
                kotlin.io.CloseableKt.closeFinally(bufferedReader, null);
                jarFile.close();
                return d2;
            } finally {
            }
        } catch (java.lang.Throwable th2) {
            try {
                throw th2;
            } catch (java.lang.Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (java.lang.Throwable th4) {
                    kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(th2, th4);
                    throw th2;
                }
            }
        }
    }

    public final java.util.List<java.lang.String> d(java.io.BufferedReader r) {
        java.lang.String substringBefore$default;
        java.lang.CharSequence trim;
        boolean z;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        while (true) {
            java.lang.String readLine = r.readLine();
            if (readLine == null) {
                return kotlin.collections.CollectionsKt___CollectionsKt.toList(linkedHashSet);
            }
            substringBefore$default = kotlin.text.StringsKt__StringsKt.substringBefore$default(readLine, "#", (java.lang.String) null, 2, (java.lang.Object) null);
            if (substringBefore$default == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            trim = kotlin.text.StringsKt__StringsKt.trim(substringBefore$default);
            java.lang.String obj = trim.toString();
            int i = 0;
            while (true) {
                if (i >= obj.length()) {
                    z = true;
                    break;
                }
                char charAt = obj.charAt(i);
                if (!(charAt == '.' || java.lang.Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal service provider class name: ", obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.internal.MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        kotlinx.coroutines.internal.MainDispatcherFactory mainDispatcherFactory;
        if (!kotlinx.coroutines.internal.FastServiceLoaderKt.getANDROID_DETECTED()) {
            return b(kotlinx.coroutines.internal.MainDispatcherFactory.class, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader());
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            kotlinx.coroutines.internal.MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (kotlinx.coroutines.internal.MainDispatcherFactory) kotlinx.coroutines.internal.MainDispatcherFactory.class.cast(java.lang.Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
            } catch (java.lang.ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (kotlinx.coroutines.internal.MainDispatcherFactory) kotlinx.coroutines.internal.MainDispatcherFactory.class.cast(java.lang.Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
            } catch (java.lang.ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (java.lang.Throwable unused3) {
            return b(kotlinx.coroutines.internal.MainDispatcherFactory.class, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader());
        }
    }

    @org.jetbrains.annotations.NotNull
    public final <S> java.util.List<S> loadProviders$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull java.lang.Class<S> service, @org.jetbrains.annotations.NotNull java.lang.ClassLoader loader) {
        java.util.Set set;
        java.util.ArrayList list = java.util.Collections.list(loader.getResources(kotlin.jvm.internal.Intrinsics.stringPlus("META-INF/services/", service.getName())));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(list, "java.util.Collections.list(this)");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, INSTANCE.c((java.net.URL) it.next()));
        }
        set = kotlin.collections.CollectionsKt___CollectionsKt.toSet(arrayList);
        if (!(!set.isEmpty())) {
            throw new java.lang.IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10));
        java.util.Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(INSTANCE.a((java.lang.String) it2.next(), loader, service));
        }
        return arrayList2;
    }
}
