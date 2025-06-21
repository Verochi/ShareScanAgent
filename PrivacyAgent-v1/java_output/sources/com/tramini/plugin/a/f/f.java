package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public class f {

    /* renamed from: com.tramini.plugin.a.f.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String[] c;
        final /* synthetic */ int d;
        final /* synthetic */ java.util.concurrent.ExecutorService e;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, int i, java.util.concurrent.ExecutorService executorService) {
            this.a = str;
            this.b = str2;
            this.c = strArr;
            this.d = i;
            this.e = executorService;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(this.a, 34).matcher(new com.tramini.plugin.a.h.a.a(this.b));
                if (matcher.find()) {
                    this.c[0] = matcher.group(this.d);
                }
            } catch (java.lang.Throwable unused) {
            }
            try {
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    public static class a {
        public static final int a = -1;
        public static final int b = 0;
        public static final int c = 1;
        public int d;
        public java.lang.Object e;

        public static com.tramini.plugin.a.f.f.a a() {
            com.tramini.plugin.a.f.f.a aVar = new com.tramini.plugin.a.f.f.a();
            aVar.d = 0;
            return aVar;
        }

        public static com.tramini.plugin.a.f.f.a a(java.lang.Object obj) {
            com.tramini.plugin.a.f.f.a aVar = new com.tramini.plugin.a.f.f.a();
            aVar.d = 1;
            aVar.e = obj;
            return aVar;
        }

        public static com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
            com.tramini.plugin.a.f.f.a aVar = new com.tramini.plugin.a.f.f.a();
            aVar.d = -1;
            aVar.e = obj;
            return aVar;
        }
    }

    public static class b {
        private static java.lang.String a(java.lang.String str) {
            return com.tramini.plugin.a.f.f.b(str, "(src|SRC)=(\"|')(.*?)(\"|')", 3);
        }

        public static java.lang.String a(java.lang.String str, java.lang.String str2) {
            for (java.lang.String str3 : str2.split(",")) {
                str = com.tramini.plugin.a.f.f.c(str, str3.replaceAll("#01;", ","));
            }
            return !android.text.TextUtils.isEmpty(str) ? str : "";
        }

        private static java.lang.String b(java.lang.String str, java.lang.String str2) {
            return com.tramini.plugin.a.f.f.c(str, str2 + ".*?\\>(.*?)(</span>|</div>)");
        }

        private static java.lang.String c(java.lang.String str, java.lang.String str2) {
            return com.tramini.plugin.a.f.f.b(str, "<(img|IMG).*?" + str2 + "(.*?)(/>|></img>|>)", 2);
        }

        private static java.lang.String d(java.lang.String str, java.lang.String str2) {
            return com.tramini.plugin.a.f.f.b(str, "(" + str2 + ")(http.*?)(" + str2 + ")", 2);
        }

        private static java.lang.String e(java.lang.String str, java.lang.String str2) {
            return com.tramini.plugin.a.f.f.b(str, str2 + "=(\"|')(.*?)(\"|')", 2);
        }

        private static java.lang.String f(java.lang.String str, java.lang.String str2) {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(str2, 34).matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        }

        private static java.lang.String g(java.lang.String str, java.lang.String str2) {
            return com.tramini.plugin.a.f.f.c(str, "'" + str2 + "'\\s*:\\s*'(.*?)'");
        }
    }

    public interface c {
        boolean a(java.lang.Object obj);

        com.tramini.plugin.a.f.f.a b(java.lang.Object obj);
    }

    public static class d {
        public static final java.lang.String a = "<!\\[CDATA\\[(.*?)\\]\\]>";

        private static java.lang.String a(java.lang.String str) {
            return com.tramini.plugin.a.f.f.c(str, a);
        }

        public static java.lang.String a(java.lang.String str, java.lang.String str2) {
            for (java.lang.String str3 : str2.split(",")) {
                if (str3.contains("#")) {
                    java.lang.String[] split = str3.split("#");
                    java.lang.String str4 = split[0];
                    str = com.tramini.plugin.a.f.f.c(str, ".*<" + str4 + ".*?>(.*?" + split[1] + ".*?)</" + str4 + ">");
                } else {
                    str = com.tramini.plugin.a.f.f.c(str, "<" + str3 + ".*?>(.*?)</" + str3 + ">");
                }
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String c = com.tramini.plugin.a.f.f.c(str, a);
            return !android.text.TextUtils.isEmpty(c) ? c : str;
        }

        private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            return com.tramini.plugin.a.f.f.c(str, ".*<" + str2 + ".*?>(.*?" + str3 + ".*?)</" + str2 + ">");
        }

        public static java.lang.String b(java.lang.String str, java.lang.String str2) {
            try {
                java.lang.String c = com.tramini.plugin.a.f.f.c(str, "<" + str2 + ">(.*?)</" + str2 + ">");
                if (android.text.TextUtils.isEmpty(c)) {
                    return "";
                }
                java.lang.String[] split = c.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                return java.lang.String.valueOf(java.lang.Integer.parseInt(split[2].substring(0, 2)) + (java.lang.Integer.parseInt(split[1].substring(0, 2)) * 60) + (java.lang.Integer.parseInt(split[0].substring(0, 2)) * 60 * 60));
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }

        private static java.lang.String c(java.lang.String str, java.lang.String str2) {
            return com.tramini.plugin.a.f.f.c(str, "<" + str2 + ".*?>(.*?)</" + str2 + ">");
        }

        private static java.lang.String d(java.lang.String str, java.lang.String str2) {
            java.lang.String c = com.tramini.plugin.a.f.f.c(str, str2 + "=\"(.*?)\"");
            return !android.text.TextUtils.isEmpty(c) ? c.replace("\"", "") : "";
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str) {
        try {
            return obj.getClass().getMethod(str, new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.StringBuffer stringBuffer, com.tramini.plugin.a.f.f.c cVar) {
        java.lang.Object obj2;
        java.lang.Object a2;
        java.lang.Object a3;
        if (cVar != null && obj != null && obj.getClass().getName().startsWith(str)) {
            stringBuffer.append(obj.getClass().getName() + ",");
            try {
                java.util.ArrayList<java.lang.reflect.Field> arrayList = new java.util.ArrayList();
                for (java.lang.Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                    arrayList.addAll(java.util.Arrays.asList(cls.getDeclaredFields()));
                }
                if (arrayList.size() != 0) {
                    for (java.lang.reflect.Field field : arrayList) {
                        field.setAccessible(true);
                        java.lang.Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            if (cVar.a(obj3)) {
                                com.tramini.plugin.a.f.f.a b2 = cVar.b(obj3);
                                int i = b2.d;
                                if (i == 0) {
                                    continue;
                                } else {
                                    if (i == 1) {
                                        return b2.e;
                                    }
                                    if (i == -1 && (obj2 = b2.e) != null && !stringBuffer.toString().contains(obj2.getClass().getName()) && (a2 = a(obj2, str, stringBuffer, cVar)) != null) {
                                        return a2;
                                    }
                                }
                            } else if (!stringBuffer.toString().contains(obj3.getClass().getName()) && (a3 = a(obj3, str, stringBuffer, cVar)) != null) {
                                return a3;
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Object invoke = java.lang.Class.forName(str).getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field[] declaredFields = invoke.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (java.lang.reflect.Field field : declaredFields) {
                    field.setAccessible(true);
                    if (field.get(invoke) instanceof java.util.Map) {
                        java.util.Map map = (java.util.Map) field.get(invoke);
                        if (map == null) {
                            return null;
                        }
                        java.lang.Object obj = map.get(str2);
                        return obj instanceof java.lang.ref.WeakReference ? ((java.lang.ref.WeakReference) obj).get() : map.get(str2);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(str) ? "" : android.net.Uri.parse(str).getQueryParameter("id");
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static void a(java.lang.Class cls, java.util.List<java.lang.reflect.Field> list) {
        if (cls != null) {
            try {
                if (cls.getName().equals(java.lang.Object.class.getName())) {
                    return;
                }
                java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    list.addAll(java.util.Arrays.asList(declaredFields));
                }
                a(cls.getSuperclass(), list);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static java.lang.Object b(java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.Object b(java.lang.String str, java.lang.String str2) {
        try {
            return java.lang.Class.forName(str).getMethod(str2, new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String queryParameter = android.net.Uri.parse(str).getQueryParameter("adurl");
            return android.text.TextUtils.isEmpty(queryParameter) ? "" : a(queryParameter);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.lang.String str, java.lang.String str2, int i) {
        java.util.concurrent.ExecutorService newFixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(2);
        java.lang.String[] strArr = new java.lang.String[1];
        newFixedThreadPool.submit(new com.tramini.plugin.a.f.f.AnonymousClass1(str2, str, strArr, i, newFixedThreadPool));
        try {
            synchronized (newFixedThreadPool) {
                newFixedThreadPool.wait(500L);
            }
            newFixedThreadPool.shutdown();
            java.lang.String str3 = strArr[0];
            return str3 != null ? str3 : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static void b(java.lang.Class cls, java.util.List<java.lang.reflect.Method> list) {
        if (cls != null) {
            try {
                if (cls.getName().equals(java.lang.Object.class.getName())) {
                    return;
                }
                java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
                if (declaredMethods != null && declaredMethods.length > 0) {
                    list.addAll(java.util.Arrays.asList(declaredMethods));
                }
                b(cls.getSuperclass(), list);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static java.lang.String c(java.lang.String str) {
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(new java.io.StringReader("unicodedString=".concat(java.lang.String.valueOf(str))));
        } catch (java.io.IOException unused) {
        }
        return properties.getProperty("unicodedString");
    }

    public static /* synthetic */ java.lang.String c(java.lang.String str, java.lang.String str2) {
        return b(str, str2, 1);
    }

    public static java.lang.String d(java.lang.String str) {
        try {
            return java.net.URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static java.lang.String d(java.lang.String str, java.lang.String str2) {
        return b(str, str2, 1);
    }
}
