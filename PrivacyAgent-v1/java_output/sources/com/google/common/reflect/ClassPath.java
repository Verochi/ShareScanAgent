package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ClassPath {
    public static final java.util.logging.Logger b = java.util.logging.Logger.getLogger(com.google.common.reflect.ClassPath.class.getName());
    public static final com.google.common.base.Predicate<com.google.common.reflect.ClassPath.ClassInfo> c = new com.google.common.reflect.ClassPath.AnonymousClass1();
    public static final com.google.common.base.Splitter d = com.google.common.base.Splitter.on(" ").omitEmptyStrings();
    public final com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ResourceInfo> a;

    /* renamed from: com.google.common.reflect.ClassPath$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Predicate<com.google.common.reflect.ClassPath.ClassInfo> {
        @Override // com.google.common.base.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(com.google.common.reflect.ClassPath.ClassInfo classInfo) {
            return classInfo.c.indexOf(36) == -1;
        }
    }

    @com.google.common.annotations.Beta
    public static final class ClassInfo extends com.google.common.reflect.ClassPath.ResourceInfo {
        public final java.lang.String c;

        public ClassInfo(java.lang.String str, java.lang.ClassLoader classLoader) {
            super(str, classLoader);
            this.c = com.google.common.reflect.ClassPath.c(str);
        }

        public java.lang.String getName() {
            return this.c;
        }

        public java.lang.String getPackageName() {
            return com.google.common.reflect.Reflection.getPackageName(this.c);
        }

        public java.lang.String getSimpleName() {
            int lastIndexOf = this.c.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return com.google.common.base.CharMatcher.digit().trimLeadingFrom(this.c.substring(lastIndexOf + 1));
            }
            java.lang.String packageName = getPackageName();
            return packageName.isEmpty() ? this.c : this.c.substring(packageName.length() + 1);
        }

        public java.lang.Class<?> load() {
            try {
                return this.b.loadClass(this.c);
            } catch (java.lang.ClassNotFoundException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public java.lang.String toString() {
            return this.c;
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class DefaultScanner extends com.google.common.reflect.ClassPath.Scanner {
        public final com.google.common.collect.SetMultimap<java.lang.ClassLoader, java.lang.String> b = com.google.common.collect.MultimapBuilder.hashKeys().linkedHashSetValues().build();

        public com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ResourceInfo> getResources() {
            com.google.common.collect.ImmutableSet.Builder builder = com.google.common.collect.ImmutableSet.builder();
            for (java.util.Map.Entry<java.lang.ClassLoader, java.lang.String> entry : this.b.entries()) {
                builder.add((com.google.common.collect.ImmutableSet.Builder) com.google.common.reflect.ClassPath.ResourceInfo.a(entry.getValue(), entry.getKey()));
            }
            return builder.build();
        }

        @Override // com.google.common.reflect.ClassPath.Scanner
        public void h(java.lang.ClassLoader classLoader, java.io.File file) throws java.io.IOException {
            java.util.HashSet hashSet = new java.util.HashSet();
            hashSet.add(file.getCanonicalFile());
            l(file, classLoader, "", hashSet);
        }

        @Override // com.google.common.reflect.ClassPath.Scanner
        public void k(java.lang.ClassLoader classLoader, java.util.jar.JarFile jarFile) {
            java.util.Enumeration<java.util.jar.JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                java.util.jar.JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    this.b.get((com.google.common.collect.SetMultimap<java.lang.ClassLoader, java.lang.String>) classLoader).add(nextElement.getName());
                }
            }
        }

        public final void l(java.io.File file, java.lang.ClassLoader classLoader, java.lang.String str, java.util.Set<java.io.File> set) throws java.io.IOException {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.google.common.reflect.ClassPath.b.warning("Cannot read directory " + file);
                return;
            }
            for (java.io.File file2 : listFiles) {
                java.lang.String name = file2.getName();
                if (file2.isDirectory()) {
                    java.io.File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        l(canonicalFile, classLoader, str + name + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, set);
                        set.remove(canonicalFile);
                    }
                } else {
                    java.lang.String str2 = str + name;
                    if (!str2.equals("META-INF/MANIFEST.MF")) {
                        this.b.get((com.google.common.collect.SetMultimap<java.lang.ClassLoader, java.lang.String>) classLoader).add(str2);
                    }
                }
            }
        }
    }

    @com.google.common.annotations.Beta
    public static class ResourceInfo {
        public final java.lang.String a;
        public final java.lang.ClassLoader b;

        public ResourceInfo(java.lang.String str, java.lang.ClassLoader classLoader) {
            this.a = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
            this.b = (java.lang.ClassLoader) com.google.common.base.Preconditions.checkNotNull(classLoader);
        }

        public static com.google.common.reflect.ClassPath.ResourceInfo a(java.lang.String str, java.lang.ClassLoader classLoader) {
            return str.endsWith(".class") ? new com.google.common.reflect.ClassPath.ClassInfo(str, classLoader) : new com.google.common.reflect.ClassPath.ResourceInfo(str, classLoader);
        }

        public final com.google.common.io.ByteSource asByteSource() {
            return com.google.common.io.Resources.asByteSource(url());
        }

        public final com.google.common.io.CharSource asCharSource(java.nio.charset.Charset charset) {
            return com.google.common.io.Resources.asCharSource(url(), charset);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.google.common.reflect.ClassPath.ResourceInfo)) {
                return false;
            }
            com.google.common.reflect.ClassPath.ResourceInfo resourceInfo = (com.google.common.reflect.ClassPath.ResourceInfo) obj;
            return this.a.equals(resourceInfo.a) && this.b == resourceInfo.b;
        }

        public final java.lang.String getResourceName() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public java.lang.String toString() {
            return this.a;
        }

        public final java.net.URL url() {
            java.net.URL resource = this.b.getResource(this.a);
            if (resource != null) {
                return resource;
            }
            throw new java.util.NoSuchElementException(this.a);
        }
    }

    public static abstract class Scanner {
        public final java.util.Set<java.io.File> a = com.google.common.collect.Sets.newHashSet();

        public static com.google.common.collect.ImmutableList<java.net.URL> a(java.lang.ClassLoader classLoader) {
            return classLoader instanceof java.net.URLClassLoader ? com.google.common.collect.ImmutableList.copyOf(((java.net.URLClassLoader) classLoader).getURLs()) : classLoader.equals(java.lang.ClassLoader.getSystemClassLoader()) ? e() : com.google.common.collect.ImmutableList.of();
        }

        @com.google.common.annotations.VisibleForTesting
        public static com.google.common.collect.ImmutableMap<java.io.File, java.lang.ClassLoader> b(java.lang.ClassLoader classLoader) {
            java.util.LinkedHashMap newLinkedHashMap = com.google.common.collect.Maps.newLinkedHashMap();
            java.lang.ClassLoader parent = classLoader.getParent();
            if (parent != null) {
                newLinkedHashMap.putAll(b(parent));
            }
            com.google.common.collect.UnmodifiableIterator<java.net.URL> it = a(classLoader).iterator();
            while (it.hasNext()) {
                java.net.URL next = it.next();
                if (next.getProtocol().equals("file")) {
                    java.io.File d = com.google.common.reflect.ClassPath.d(next);
                    if (!newLinkedHashMap.containsKey(d)) {
                        newLinkedHashMap.put(d, classLoader);
                    }
                }
            }
            return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) newLinkedHashMap);
        }

        @com.google.common.annotations.VisibleForTesting
        public static java.net.URL c(java.io.File file, java.lang.String str) throws java.net.MalformedURLException {
            return new java.net.URL(file.toURI().toURL(), str);
        }

        @com.google.common.annotations.VisibleForTesting
        public static com.google.common.collect.ImmutableSet<java.io.File> d(java.io.File file, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.jar.Manifest manifest) {
            if (manifest == null) {
                return com.google.common.collect.ImmutableSet.of();
            }
            com.google.common.collect.ImmutableSet.Builder builder = com.google.common.collect.ImmutableSet.builder();
            java.lang.String value = manifest.getMainAttributes().getValue(java.util.jar.Attributes.Name.CLASS_PATH.toString());
            if (value != null) {
                for (java.lang.String str : com.google.common.reflect.ClassPath.d.split(value)) {
                    try {
                        java.net.URL c = c(file, str);
                        if (c.getProtocol().equals("file")) {
                            builder.add((com.google.common.collect.ImmutableSet.Builder) com.google.common.reflect.ClassPath.d(c));
                        }
                    } catch (java.net.MalformedURLException unused) {
                        com.google.common.reflect.ClassPath.b.warning("Invalid Class-Path entry: " + str);
                    }
                }
            }
            return builder.build();
        }

        @com.google.common.annotations.VisibleForTesting
        public static com.google.common.collect.ImmutableList<java.net.URL> e() {
            com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
            for (java.lang.String str : com.google.common.base.Splitter.on(com.google.common.base.StandardSystemProperty.PATH_SEPARATOR.value()).split(com.google.common.base.StandardSystemProperty.JAVA_CLASS_PATH.value())) {
                try {
                    try {
                        builder.add((com.google.common.collect.ImmutableList.Builder) new java.io.File(str).toURI().toURL());
                    } catch (java.lang.SecurityException unused) {
                        builder.add((com.google.common.collect.ImmutableList.Builder) new java.net.URL("file", (java.lang.String) null, new java.io.File(str).getAbsolutePath()));
                    }
                } catch (java.net.MalformedURLException e) {
                    com.google.common.reflect.ClassPath.b.log(java.util.logging.Level.WARNING, "malformed classpath entry: " + str, (java.lang.Throwable) e);
                }
            }
            return builder.build();
        }

        @com.google.common.annotations.VisibleForTesting
        public final void f(java.io.File file, java.lang.ClassLoader classLoader) throws java.io.IOException {
            if (this.a.add(file.getCanonicalFile())) {
                i(file, classLoader);
            }
        }

        public final void g(java.lang.ClassLoader classLoader) throws java.io.IOException {
            com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<java.io.File, java.lang.ClassLoader>> it = b(classLoader).entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<java.io.File, java.lang.ClassLoader> next = it.next();
                f(next.getKey(), next.getValue());
            }
        }

        public abstract void h(java.lang.ClassLoader classLoader, java.io.File file) throws java.io.IOException;

        public final void i(java.io.File file, java.lang.ClassLoader classLoader) throws java.io.IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        h(classLoader, file);
                    } else {
                        j(file, classLoader);
                    }
                }
            } catch (java.lang.SecurityException e) {
                com.google.common.reflect.ClassPath.b.warning("Cannot access " + file + ": " + e);
            }
        }

        public final void j(java.io.File file, java.lang.ClassLoader classLoader) throws java.io.IOException {
            try {
                java.util.jar.JarFile jarFile = new java.util.jar.JarFile(file);
                try {
                    com.google.common.collect.UnmodifiableIterator<java.io.File> it = d(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        f(it.next(), classLoader);
                    }
                    k(classLoader, jarFile);
                } finally {
                    try {
                        jarFile.close();
                    } catch (java.io.IOException unused) {
                    }
                }
            } catch (java.io.IOException unused2) {
            }
        }

        public abstract void k(java.lang.ClassLoader classLoader, java.util.jar.JarFile jarFile) throws java.io.IOException;
    }

    public ClassPath(com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ResourceInfo> immutableSet) {
        this.a = immutableSet;
    }

    @com.google.common.annotations.VisibleForTesting
    public static java.lang.String c(java.lang.String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    @com.google.common.annotations.VisibleForTesting
    public static java.io.File d(java.net.URL url) {
        com.google.common.base.Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new java.io.File(url.toURI());
        } catch (java.net.URISyntaxException unused) {
            return new java.io.File(url.getPath());
        }
    }

    public static com.google.common.reflect.ClassPath from(java.lang.ClassLoader classLoader) throws java.io.IOException {
        com.google.common.reflect.ClassPath.DefaultScanner defaultScanner = new com.google.common.reflect.ClassPath.DefaultScanner();
        defaultScanner.g(classLoader);
        return new com.google.common.reflect.ClassPath(defaultScanner.getResources());
    }

    public com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ClassInfo> getAllClasses() {
        return com.google.common.collect.FluentIterable.from(this.a).filter(com.google.common.reflect.ClassPath.ClassInfo.class).toSet();
    }

    public com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ResourceInfo> getResources() {
        return this.a;
    }

    public com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ClassInfo> getTopLevelClasses() {
        return com.google.common.collect.FluentIterable.from(this.a).filter(com.google.common.reflect.ClassPath.ClassInfo.class).filter(c).toSet();
    }

    public com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ClassInfo> getTopLevelClasses(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        com.google.common.collect.ImmutableSet.Builder builder = com.google.common.collect.ImmutableSet.builder();
        com.google.common.collect.UnmodifiableIterator<com.google.common.reflect.ClassPath.ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            com.google.common.reflect.ClassPath.ClassInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                builder.add((com.google.common.collect.ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }

    public com.google.common.collect.ImmutableSet<com.google.common.reflect.ClassPath.ClassInfo> getTopLevelClassesRecursive(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        java.lang.String str2 = str + '.';
        com.google.common.collect.ImmutableSet.Builder builder = com.google.common.collect.ImmutableSet.builder();
        com.google.common.collect.UnmodifiableIterator<com.google.common.reflect.ClassPath.ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            com.google.common.reflect.ClassPath.ClassInfo next = it.next();
            if (next.getName().startsWith(str2)) {
                builder.add((com.google.common.collect.ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }
}
