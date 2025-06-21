package s.h.e.l.l;

@android.annotation.SuppressLint({"Override"})
@android.annotation.TargetApi(28)
/* loaded from: classes.dex */
public final class A extends android.app.AppComponentFactory {
    private java.lang.String packageName = "com.moji.mjweather";
    private java.lang.String orignAppName = "com.moji.mjweather.MJApplication";
    private java.lang.String orignName = "androidx.core.app.CoreComponentFactory";
    private android.app.AppComponentFactory orignACF = null;
    private boolean supportInstantiateClassLoader = false;
    private android.app.AppComponentFactory acf = null;

    public static native java.lang.ClassLoader al(java.lang.ClassLoader classLoader, android.content.pm.ApplicationInfo applicationInfo, java.lang.String str, java.lang.String str2);

    private android.content.pm.ApplicationInfo ga() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e3) {
                    }
                }
            } catch (java.lang.Exception e4) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                android.app.ActivityThread currentActivityThread = android.app.ActivityThread.currentActivityThread();
                java.lang.reflect.Field declaredField = currentActivityThread.getClass().getDeclaredField("mBoundApplication");
                declaredField.setAccessible(true);
                java.lang.Object obj5 = declaredField.get(currentActivityThread);
                java.lang.reflect.Field declaredField2 = obj5.getClass().getDeclaredField("info");
                declaredField2.setAccessible(true);
                return ((android.app.LoadedApk) declaredField2.get(obj5)).getApplicationInfo();
            } catch (java.lang.Throwable th2) {
                obj = obj2;
                th = th2;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e7) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e8) {
                    throw th;
                }
            }
            android.app.ActivityThread currentActivityThread2 = android.app.ActivityThread.currentActivityThread();
            java.lang.reflect.Field declaredField3 = currentActivityThread2.getClass().getDeclaredField("mBoundApplication");
            declaredField3.setAccessible(true);
            java.lang.Object obj52 = declaredField3.get(currentActivityThread2);
            java.lang.reflect.Field declaredField22 = obj52.getClass().getDeclaredField("info");
            declaredField22.setAccessible(true);
            return ((android.app.LoadedApk) declaredField22.get(obj52)).getApplicationInfo();
        } catch (java.lang.Exception e9) {
            return null;
        }
    }

    private void ls(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            java.io.File file = new java.io.File(applicationInfo.dataDir, "files");
            if (!file.exists()) {
                file.mkdirs();
            }
            s.h.e.l.l.S.p = file.getAbsolutePath();
            s.h.e.l.l.S.f = applicationInfo.sourceDir;
            if (s.h.e.l.l.S.la) {
                s.h.e.l.l.S.l(null);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized android.app.AppComponentFactory getACF(java.lang.ClassLoader classLoader) {
        if (this.acf == null && this.orignName != null && !this.orignName.equals("")) {
            try {
                this.acf = (android.app.AppComponentFactory) classLoader.loadClass(this.orignName).newInstance();
            } catch (java.lang.Exception e) {
            }
        }
        return this.acf;
    }

    @Override // android.app.AppComponentFactory
    public android.app.Activity instantiateActivity(java.lang.ClassLoader classLoader, java.lang.String str, android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        if (s.h.e.l.l.S.l) {
            android.app.AppComponentFactory acf = getACF(classLoader);
            this.acf = acf;
            if (acf != null) {
                return this.acf.instantiateActivity(classLoader, str, intent);
            }
        }
        return super.instantiateActivity(classLoader, str, intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    @Override // android.app.AppComponentFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.app.Application instantiateApplication(java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            java.lang.Object obj4 = new java.lang.Object();
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e2) {
                }
            }
            if (obj4 != null) {
                try {
                    obj4.hashCode();
                } catch (java.lang.Exception e3) {
                }
            }
        } catch (java.lang.Exception e4) {
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e5) {
                }
            }
            if (0 != 0) {
                try {
                    obj3.hashCode();
                } catch (java.lang.Exception e6) {
                }
            }
            if (!str.equals("s.h.e.l.l.S")) {
            }
            return super.instantiateApplication(classLoader, str);
        } catch (java.lang.Throwable th2) {
            obj = obj2;
            th = th2;
            if (obj != null) {
                try {
                    obj.hashCode();
                } catch (java.lang.Exception e7) {
                }
            }
            if (0 == 0) {
                throw th;
            }
            try {
                obj3.hashCode();
                throw th;
            } catch (java.lang.Exception e8) {
                throw th;
            }
        }
        if (!str.equals("s.h.e.l.l.S")) {
            if (!this.supportInstantiateClassLoader) {
                android.content.pm.ApplicationInfo ga = ga();
                ls(ga);
                classLoader = s.h.e.l.l.N.al(classLoader, ga, this.packageName, this.orignAppName);
                ga.className = this.orignAppName;
            }
            str = this.orignAppName;
        } else if (s.h.e.l.l.S.l) {
            android.app.AppComponentFactory acf = getACF(classLoader);
            this.acf = acf;
            if (acf != null) {
                return this.acf.instantiateApplication(classLoader, str);
            }
        }
        return super.instantiateApplication(classLoader, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a A[Catch: Throwable -> 0x0063, TRY_LEAVE, TryCatch #7 {Throwable -> 0x0063, blocks: (B:9:0x0016, B:11:0x001a), top: B:8:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036 A[Catch: Throwable -> 0x0074, TryCatch #9 {Throwable -> 0x0074, blocks: (B:14:0x0028, B:15:0x0032, B:17:0x0036, B:19:0x0040), top: B:13:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    @Override // android.app.AppComponentFactory
    @android.annotation.TargetApi(29)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.ClassLoader instantiateClassLoader(java.lang.ClassLoader classLoader, android.content.pm.ApplicationInfo applicationInfo) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.ClassLoader classLoader2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (this.supportInstantiateClassLoader) {
                }
                if (s.h.e.l.l.S.l) {
                }
                return super.instantiateClassLoader(classLoader2, applicationInfo);
            } catch (java.lang.Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            if (this.supportInstantiateClassLoader) {
                s.h.e.l.l.S.gST();
                ls(applicationInfo);
                classLoader2 = s.h.e.l.l.N.al(classLoader, applicationInfo, this.packageName, this.orignAppName);
                try {
                    applicationInfo.className = this.orignAppName;
                    this.supportInstantiateClassLoader = true;
                    s.h.e.l.l.S.gET();
                } catch (java.lang.Throwable th3) {
                }
            } else {
                classLoader2 = classLoader;
            }
            if (s.h.e.l.l.S.l) {
                this.acf = getACF(classLoader2);
                if (this.acf != null) {
                    return this.acf.instantiateClassLoader(classLoader2, applicationInfo);
                }
            }
        } catch (java.lang.Throwable th4) {
            classLoader2 = classLoader;
        }
        return super.instantiateClassLoader(classLoader2, applicationInfo);
    }

    @Override // android.app.AppComponentFactory
    public android.content.ContentProvider instantiateProvider(java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        if (s.h.e.l.l.S.l) {
            android.app.AppComponentFactory acf = getACF(classLoader);
            this.acf = acf;
            if (acf != null) {
                return this.acf.instantiateProvider(classLoader, str);
            }
        }
        return super.instantiateProvider(classLoader, str);
    }

    @Override // android.app.AppComponentFactory
    public android.content.BroadcastReceiver instantiateReceiver(java.lang.ClassLoader classLoader, java.lang.String str, android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        if (s.h.e.l.l.S.l) {
            android.app.AppComponentFactory acf = getACF(classLoader);
            this.acf = acf;
            if (acf != null) {
                return this.acf.instantiateReceiver(classLoader, str, intent);
            }
        }
        return super.instantiateReceiver(classLoader, str, intent);
    }

    @Override // android.app.AppComponentFactory
    public android.app.Service instantiateService(java.lang.ClassLoader classLoader, java.lang.String str, android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        if (s.h.e.l.l.S.l) {
            android.app.AppComponentFactory acf = getACF(classLoader);
            this.acf = acf;
            if (acf != null) {
                return this.acf.instantiateService(classLoader, str, intent);
            }
        }
        return super.instantiateService(classLoader, str, intent);
    }
}
