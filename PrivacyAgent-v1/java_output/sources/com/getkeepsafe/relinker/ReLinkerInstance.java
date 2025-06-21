package com.getkeepsafe.relinker;

/* loaded from: classes22.dex */
public class ReLinkerInstance {
    protected boolean force;
    protected final com.getkeepsafe.relinker.ReLinker.LibraryInstaller libraryInstaller;
    protected final com.getkeepsafe.relinker.ReLinker.LibraryLoader libraryLoader;
    protected final java.util.Set<java.lang.String> loadedLibraries;
    protected com.getkeepsafe.relinker.ReLinker.Logger logger;
    protected boolean recursive;

    /* renamed from: com.getkeepsafe.relinker.ReLinkerInstance$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;
        public final /* synthetic */ com.getkeepsafe.relinker.ReLinker.LoadListener v;

        public AnonymousClass1(android.content.Context context, java.lang.String str, java.lang.String str2, com.getkeepsafe.relinker.ReLinker.LoadListener loadListener) {
            this.n = context;
            this.t = str;
            this.u = str2;
            this.v = loadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.getkeepsafe.relinker.ReLinkerInstance.this.b(this.n, this.t, this.u);
                this.v.success();
            } catch (com.getkeepsafe.relinker.MissingLibraryException e) {
                this.v.failure(e);
            } catch (java.lang.UnsatisfiedLinkError e2) {
                this.v.failure(e2);
            }
        }
    }

    /* renamed from: com.getkeepsafe.relinker.ReLinkerInstance$2, reason: invalid class name */
    public class AnonymousClass2 implements java.io.FilenameFilter {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.startsWith(this.a);
        }
    }

    public ReLinkerInstance() {
        this(new com.getkeepsafe.relinker.SystemLibraryLoader(), new com.getkeepsafe.relinker.ApkLibraryInstaller());
    }

    public ReLinkerInstance(com.getkeepsafe.relinker.ReLinker.LibraryLoader libraryLoader, com.getkeepsafe.relinker.ReLinker.LibraryInstaller libraryInstaller) {
        this.loadedLibraries = new java.util.HashSet();
        if (libraryLoader == null) {
            throw new java.lang.IllegalArgumentException("Cannot pass null library loader");
        }
        if (libraryInstaller == null) {
            throw new java.lang.IllegalArgumentException("Cannot pass null library installer");
        }
        this.libraryLoader = libraryLoader;
        this.libraryInstaller = libraryInstaller;
    }

    public final void b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (this.loadedLibraries.contains(str) && !this.force) {
            log("%s already loaded previously!", str);
            return;
        }
        try {
            this.libraryLoader.loadLibrary(str);
            this.loadedLibraries.add(str);
            log("%s (%s) was loaded normally!", str, str2);
        } catch (java.lang.UnsatisfiedLinkError e) {
            log("Loading the library normally failed: %s", android.util.Log.getStackTraceString(e));
            log("%s (%s) was not loaded normally, re-linking...", str, str2);
            java.io.File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
            if (!workaroundLibFile.exists() || this.force) {
                if (this.force) {
                    log("Forcing a re-link of %s (%s)...", str, str2);
                }
                cleanupOldLibFiles(context, str, str2);
                this.libraryInstaller.installLibrary(context, this.libraryLoader.supportedAbis(), this.libraryLoader.mapLibraryName(str), workaroundLibFile, this);
            }
            try {
                if (this.recursive) {
                    com.getkeepsafe.relinker.elf.ElfParser elfParser = null;
                    try {
                        com.getkeepsafe.relinker.elf.ElfParser elfParser2 = new com.getkeepsafe.relinker.elf.ElfParser(workaroundLibFile);
                        try {
                            java.util.List<java.lang.String> parseNeededDependencies = elfParser2.parseNeededDependencies();
                            elfParser2.close();
                            java.util.Iterator<java.lang.String> it = parseNeededDependencies.iterator();
                            while (it.hasNext()) {
                                loadLibrary(context, this.libraryLoader.unmapLibraryName(it.next()));
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            elfParser = elfParser2;
                            elfParser.close();
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                }
            } catch (java.io.IOException unused) {
            }
            this.libraryLoader.loadPath(workaroundLibFile.getAbsolutePath());
            this.loadedLibraries.add(str);
            log("%s (%s) was re-linked!", str, str2);
        }
    }

    public void cleanupOldLibFiles(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.io.File workaroundLibDir = getWorkaroundLibDir(context);
        java.io.File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
        java.io.File[] listFiles = workaroundLibDir.listFiles(new com.getkeepsafe.relinker.ReLinkerInstance.AnonymousClass2(this.libraryLoader.mapLibraryName(str)));
        if (listFiles == null) {
            return;
        }
        for (java.io.File file : listFiles) {
            if (this.force || !file.getAbsolutePath().equals(workaroundLibFile.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public com.getkeepsafe.relinker.ReLinkerInstance force() {
        this.force = true;
        return this;
    }

    public java.io.File getWorkaroundLibDir(android.content.Context context) {
        return context.getDir("lib", 0);
    }

    public java.io.File getWorkaroundLibFile(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String mapLibraryName = this.libraryLoader.mapLibraryName(str);
        if (com.getkeepsafe.relinker.TextUtils.a(str2)) {
            return new java.io.File(getWorkaroundLibDir(context), mapLibraryName);
        }
        return new java.io.File(getWorkaroundLibDir(context), mapLibraryName + "." + str2);
    }

    public void loadLibrary(android.content.Context context, java.lang.String str) {
        loadLibrary(context, str, null, null);
    }

    public void loadLibrary(android.content.Context context, java.lang.String str, com.getkeepsafe.relinker.ReLinker.LoadListener loadListener) {
        loadLibrary(context, str, null, loadListener);
    }

    public void loadLibrary(android.content.Context context, java.lang.String str, java.lang.String str2) {
        loadLibrary(context, str, str2, null);
    }

    public void loadLibrary(android.content.Context context, java.lang.String str, java.lang.String str2, com.getkeepsafe.relinker.ReLinker.LoadListener loadListener) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Given context is null");
        }
        if (com.getkeepsafe.relinker.TextUtils.a(str)) {
            throw new java.lang.IllegalArgumentException("Given library is either null or empty");
        }
        log("Beginning load of %s...", str);
        if (loadListener == null) {
            b(context, str, str2);
        } else {
            new java.lang.Thread(new com.getkeepsafe.relinker.ReLinkerInstance.AnonymousClass1(context, str, str2, loadListener)).start();
        }
    }

    public com.getkeepsafe.relinker.ReLinkerInstance log(com.getkeepsafe.relinker.ReLinker.Logger logger) {
        this.logger = logger;
        return this;
    }

    public void log(java.lang.String str) {
        com.getkeepsafe.relinker.ReLinker.Logger logger = this.logger;
        if (logger != null) {
            logger.log(str);
        }
    }

    public void log(java.lang.String str, java.lang.Object... objArr) {
        log(java.lang.String.format(java.util.Locale.US, str, objArr));
    }

    public com.getkeepsafe.relinker.ReLinkerInstance recursively() {
        this.recursive = true;
        return this;
    }
}
