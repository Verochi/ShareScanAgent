package com.google.android.gms.dynamite;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class DynamiteModule {

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("DynamiteModule.class")
    public static java.lang.Boolean b = null;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("DynamiteModule.class")
    public static com.google.android.gms.dynamite.zzk c = null;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("DynamiteModule.class")
    public static com.google.android.gms.dynamite.zzm d = null;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("DynamiteModule.class")
    public static java.lang.String e = null;

    @javax.annotation.concurrent.GuardedBy("DynamiteModule.class")
    public static int f = -1;
    public final android.content.Context a;
    public static final java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule.zza> g = new java.lang.ThreadLocal<>();
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb h = new com.google.android.gms.dynamite.zzb();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy PREFER_REMOTE = new com.google.android.gms.dynamite.zza();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy PREFER_LOCAL = new com.google.android.gms.dynamite.zzd();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new com.google.android.gms.dynamite.zzc();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.google.android.gms.dynamite.zzf();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.google.android.gms.dynamite.zze();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new com.google.android.gms.dynamite.zzh();
    public static final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy i = new com.google.android.gms.dynamite.zzg();

    @com.google.android.gms.common.util.DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @androidx.annotation.RecentlyNullable
        @javax.annotation.concurrent.GuardedBy("DynamiteLoaderClassLoader.class")
        public static java.lang.ClassLoader sClassLoader;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static class LoadingException extends java.lang.Exception {
        private LoadingException(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ LoadingException(java.lang.String str, com.google.android.gms.dynamite.zzb zzbVar) {
            this(str);
        }

        private LoadingException(java.lang.String str, java.lang.Throwable th) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(java.lang.String str, java.lang.Throwable th, com.google.android.gms.dynamite.zzb zzbVar) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public static class zza {
            public int zza = 0;
            public int zzb = 0;
            public int zzc = 0;
        }

        public interface zzb {
            int zza(android.content.Context context, java.lang.String str);

            int zza(android.content.Context context, java.lang.String str, boolean z) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException;
        }

        com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zza(android.content.Context context, java.lang.String str, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb zzbVar) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException;
    }

    public static class zza {
        public android.database.Cursor a;

        public zza() {
        }

        public /* synthetic */ zza(com.google.android.gms.dynamite.zzb zzbVar) {
            this();
        }
    }

    public static class zzb implements com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb {
        public final int a;
        public final int b = 0;

        public zzb(int i, int i2) {
            this.a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int zza(android.content.Context context, java.lang.String str) {
            return this.a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int zza(android.content.Context context, java.lang.String str, boolean z) {
            return 0;
        }
    }

    public DynamiteModule(android.content.Context context) {
        this.a = (android.content.Context) com.google.android.gms.common.internal.Preconditions.checkNotNull(context);
    }

    public static com.google.android.gms.dynamite.DynamiteModule a(android.content.Context context, java.lang.String str) {
        java.lang.String valueOf = java.lang.String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        }
        return new com.google.android.gms.dynamite.DynamiteModule(context.getApplicationContext());
    }

    public static com.google.android.gms.dynamite.DynamiteModule b(android.content.Context context, java.lang.String str, int i2) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        java.lang.Boolean bool;
        com.google.android.gms.dynamic.IObjectWrapper zzb2;
        try {
            synchronized (com.google.android.gms.dynamite.DynamiteModule.class) {
                bool = b;
            }
            if (bool == null) {
                throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zzb) null);
            }
            if (bool.booleanValue()) {
                return h(context, str, i2);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 51);
            sb.append("Selected remote version of ");
            sb.append(str);
            sb.append(", version >= ");
            sb.append(i2);
            com.google.android.gms.dynamite.zzk c2 = c(context);
            if (c2 == null) {
                throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zzb) null);
            }
            int zzb3 = c2.zzb();
            if (zzb3 >= 3) {
                com.google.android.gms.dynamite.DynamiteModule.zza zzaVar = g.get();
                if (zzaVar == null) {
                    throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No cached result cursor holder", (com.google.android.gms.dynamite.zzb) null);
                }
                zzb2 = c2.zza(com.google.android.gms.dynamic.ObjectWrapper.wrap(context), str, i2, com.google.android.gms.dynamic.ObjectWrapper.wrap(zzaVar.a));
            } else {
                zzb2 = zzb3 == 2 ? c2.zzb(com.google.android.gms.dynamic.ObjectWrapper.wrap(context), str, i2) : c2.zza(com.google.android.gms.dynamic.ObjectWrapper.wrap(context), str, i2);
            }
            if (com.google.android.gms.dynamic.ObjectWrapper.unwrap(zzb2) != null) {
                return new com.google.android.gms.dynamite.DynamiteModule((android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(zzb2));
            }
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.zzb) null);
        } catch (android.os.RemoteException e2) {
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to load remote module.", e2, null);
        } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException e3) {
            throw e3;
        } catch (java.lang.Throwable th) {
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to load remote module.", th, null);
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.gms.dynamite.zzk c(android.content.Context context) {
        com.google.android.gms.dynamite.zzk zzjVar;
        synchronized (com.google.android.gms.dynamite.DynamiteModule.class) {
            com.google.android.gms.dynamite.zzk zzkVar = c;
            if (zzkVar != null) {
                return zzkVar;
            }
            try {
                android.os.IBinder iBinder = (android.os.IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzjVar = null;
                } else {
                    android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzjVar = queryLocalInterface instanceof com.google.android.gms.dynamite.zzk ? (com.google.android.gms.dynamite.zzk) queryLocalInterface : new com.google.android.gms.dynamite.zzj(iBinder);
                }
                if (zzjVar != null) {
                    c = zzjVar;
                    return zzjVar;
                }
            } catch (java.lang.Exception e2) {
                java.lang.String valueOf = java.lang.String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                }
            }
            return null;
        }
    }

    public static java.lang.Boolean d() {
        java.lang.Boolean valueOf;
        synchronized (com.google.android.gms.dynamite.DynamiteModule.class) {
            valueOf = java.lang.Boolean.valueOf(f >= 2);
        }
        return valueOf;
    }

    @javax.annotation.concurrent.GuardedBy("DynamiteModule.class")
    public static void e(java.lang.ClassLoader classLoader) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        com.google.android.gms.dynamite.zzm zzlVar;
        try {
            android.os.IBinder iBinder = (android.os.IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzlVar = queryLocalInterface instanceof com.google.android.gms.dynamite.zzm ? (com.google.android.gms.dynamite.zzm) queryLocalInterface : new com.google.android.gms.dynamite.zzl(iBinder);
            }
            d = zzlVar;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e2) {
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    public static boolean f(android.database.Cursor cursor) {
        com.google.android.gms.dynamite.DynamiteModule.zza zzaVar = g.get();
        if (zzaVar == null || zzaVar.a != null) {
            return false;
        }
        zzaVar.a = cursor;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        if (f(r5) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(android.content.Context context, java.lang.String str, boolean z) {
        com.google.android.gms.dynamite.zzk c2 = c(context);
        if (c2 == null) {
            return 0;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                int zzb2 = c2.zzb();
                if (zzb2 < 3) {
                    return zzb2 == 2 ? c2.zzb(com.google.android.gms.dynamic.ObjectWrapper.wrap(context), str, z) : c2.zza(com.google.android.gms.dynamic.ObjectWrapper.wrap(context), str, z);
                }
                android.database.Cursor cursor2 = (android.database.Cursor) com.google.android.gms.dynamic.ObjectWrapper.unwrap(c2.zzc(com.google.android.gms.dynamic.ObjectWrapper.wrap(context), str, z));
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            int i2 = cursor2.getInt(0);
                            if (i2 > 0) {
                            }
                            cursor = cursor2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i2;
                        }
                    } catch (android.os.RemoteException e2) {
                        e = e2;
                        cursor = cursor2;
                        java.lang.String valueOf = java.lang.String.valueOf(e.getMessage());
                        if (valueOf.length() != 0) {
                            "Failed to retrieve remote module version: ".concat(valueOf);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return 0;
            } catch (android.os.RemoteException e3) {
                e = e3;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int getLocalVersion(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        try {
            java.lang.ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            java.lang.Class<?> loadClass = classLoader.loadClass(sb.toString());
            java.lang.reflect.Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            java.lang.reflect.Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (com.google.android.gms.common.internal.Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            java.lang.String valueOf = java.lang.String.valueOf(declaredField.get(null));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(valueOf.length() + 51 + java.lang.String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            return 0;
        } catch (java.lang.ClassNotFoundException unused) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            return 0;
        } catch (java.lang.Exception e2) {
            java.lang.String valueOf2 = java.lang.String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf2);
            }
            return 0;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int getRemoteVersion(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        return zza(context, str, false);
    }

    public static com.google.android.gms.dynamite.DynamiteModule h(android.content.Context context, java.lang.String str, int i2) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException, android.os.RemoteException {
        com.google.android.gms.dynamite.zzm zzmVar;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        synchronized (com.google.android.gms.dynamite.DynamiteModule.class) {
            zzmVar = d;
        }
        if (zzmVar == null) {
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zzb) null);
        }
        com.google.android.gms.dynamite.DynamiteModule.zza zzaVar = g.get();
        if (zzaVar == null || zzaVar.a == null) {
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No result cursor", (com.google.android.gms.dynamite.zzb) null);
        }
        android.content.Context applicationContext = context.getApplicationContext();
        android.database.Cursor cursor = zzaVar.a;
        com.google.android.gms.dynamic.ObjectWrapper.wrap(null);
        android.content.Context context2 = (android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(d().booleanValue() ? zzmVar.zzb(com.google.android.gms.dynamic.ObjectWrapper.wrap(applicationContext), str, i2, com.google.android.gms.dynamic.ObjectWrapper.wrap(cursor)) : zzmVar.zza(com.google.android.gms.dynamic.ObjectWrapper.wrap(applicationContext), str, i2, com.google.android.gms.dynamic.ObjectWrapper.wrap(cursor)));
        if (context2 != null) {
            return new com.google.android.gms.dynamite.DynamiteModule(context2);
        }
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to get module context", (com.google.android.gms.dynamite.zzb) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        if (f(r8) != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int i(android.content.Context context, java.lang.String str, boolean z) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        try {
            android.content.ContentResolver contentResolver = context.getContentResolver();
            java.lang.String str2 = z ? "api_force_staging" : "api";
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str2.length() + 42 + java.lang.String.valueOf(str).length());
            sb.append("content://com.google.android.gms.chimera/");
            sb.append(str2);
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(str);
            android.database.Cursor query = contentResolver.query(android.net.Uri.parse(sb.toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(0);
                        if (i2 > 0) {
                            synchronized (com.google.android.gms.dynamite.DynamiteModule.class) {
                                e = query.getString(2);
                                int columnIndex = query.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f = query.getInt(columnIndex);
                                }
                            }
                        }
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return i2;
                    }
                } catch (java.lang.Exception e2) {
                    cursor = query;
                    e = e2;
                    try {
                        if (e instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException) {
                            throw e;
                        }
                        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("V2 version check failed", e, null);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    cursor2 = query;
                    th = th2;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to connect to dynamite module ContentResolver.", (com.google.android.gms.dynamite.zzb) null);
        } catch (java.lang.Exception e3) {
            e = e3;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.dynamite.DynamiteModule load(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull com.google.android.gms.dynamite.DynamiteModule.VersionPolicy versionPolicy, @androidx.annotation.RecentlyNonNull java.lang.String str) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule.zza> threadLocal = g;
        com.google.android.gms.dynamite.DynamiteModule.zza zzaVar = threadLocal.get();
        com.google.android.gms.dynamite.DynamiteModule.zza zzaVar2 = new com.google.android.gms.dynamite.DynamiteModule.zza(null);
        threadLocal.set(zzaVar2);
        try {
            com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zza2 = versionPolicy.zza(context, str, h);
            int i2 = zza2.zza;
            int i3 = zza2.zzb;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 68 + java.lang.String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(i3);
            int i4 = zza2.zzc;
            if (i4 == 0 || ((i4 == -1 && zza2.zza == 0) || (i4 == 1 && zza2.zzb == 0))) {
                int i5 = zza2.zza;
                int i6 = zza2.zzb;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException(sb2.toString(), (com.google.android.gms.dynamite.zzb) null);
            }
            if (i4 == -1) {
                com.google.android.gms.dynamite.DynamiteModule a = a(context, str);
                android.database.Cursor cursor = zzaVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(zzaVar);
                return a;
            }
            if (i4 != 1) {
                int i7 = zza2.zzc;
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i7);
                throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException(sb3.toString(), (com.google.android.gms.dynamite.zzb) null);
            }
            try {
                com.google.android.gms.dynamite.DynamiteModule b2 = b(context, str, zza2.zzb);
                android.database.Cursor cursor2 = zzaVar2.a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                threadLocal.set(zzaVar);
                return b2;
            } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException e2) {
                java.lang.String valueOf = java.lang.String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load remote module: ".concat(valueOf);
                }
                int i8 = zza2.zza;
                if (i8 == 0 || versionPolicy.zza(context, str, new com.google.android.gms.dynamite.DynamiteModule.zzb(i8, 0)).zzc != -1) {
                    throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Remote load failed. No local fallback found.", e2, null);
                }
                com.google.android.gms.dynamite.DynamiteModule a2 = a(context, str);
                android.database.Cursor cursor3 = zzaVar2.a;
                if (cursor3 != null) {
                    cursor3.close();
                }
                g.set(zzaVar);
                return a2;
            }
        } catch (java.lang.Throwable th) {
            android.database.Cursor cursor4 = zzaVar2.a;
            if (cursor4 != null) {
                cursor4.close();
            }
            g.set(zzaVar);
            throw th;
        }
    }

    @androidx.annotation.RecentlyNonNull
    public static int zza(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull boolean z) {
        java.lang.reflect.Field declaredField;
        try {
            synchronized (com.google.android.gms.dynamite.DynamiteModule.class) {
                java.lang.Boolean bool = b;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException e2) {
                        java.lang.String valueOf = java.lang.String.valueOf(e2);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        bool = java.lang.Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        java.lang.ClassLoader classLoader = (java.lang.ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == java.lang.ClassLoader.getSystemClassLoader()) {
                                bool = java.lang.Boolean.FALSE;
                            } else {
                                try {
                                    e(classLoader);
                                } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException unused) {
                                }
                                bool = java.lang.Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, java.lang.ClassLoader.getSystemClassLoader());
                            bool = java.lang.Boolean.FALSE;
                        } else {
                            try {
                                int i2 = i(context, str, z);
                                java.lang.String str2 = e;
                                if (str2 != null && !str2.isEmpty()) {
                                    java.lang.ClassLoader delegateLastClassLoader = android.os.Build.VERSION.SDK_INT >= 29 ? new dalvik.system.DelegateLastClassLoader((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(e), java.lang.ClassLoader.getSystemClassLoader()) : new com.google.android.gms.dynamite.zzi((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(e), java.lang.ClassLoader.getSystemClassLoader());
                                    e(delegateLastClassLoader);
                                    declaredField.set(null, delegateLastClassLoader);
                                    b = java.lang.Boolean.TRUE;
                                    return i2;
                                }
                                return i2;
                            } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException unused2) {
                                declaredField.set(null, java.lang.ClassLoader.getSystemClassLoader());
                                bool = java.lang.Boolean.FALSE;
                            }
                        }
                        b = bool;
                    }
                }
                if (!bool.booleanValue()) {
                    return g(context, str, z);
                }
                try {
                    return i(context, str, z);
                } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException e3) {
                    java.lang.String valueOf2 = java.lang.String.valueOf(e3.getMessage());
                    if (valueOf2.length() == 0) {
                        return 0;
                    }
                    "Failed to retrieve remote module version: ".concat(valueOf2);
                    return 0;
                }
            }
        } catch (java.lang.Throwable th) {
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw th;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final android.content.Context getModuleContext() {
        return this.a;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final android.os.IBinder instantiate(@androidx.annotation.RecentlyNonNull java.lang.String str) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        try {
            return (android.os.IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException e2) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new java.lang.String("Failed to instantiate module class: "), e2, null);
        }
    }
}
