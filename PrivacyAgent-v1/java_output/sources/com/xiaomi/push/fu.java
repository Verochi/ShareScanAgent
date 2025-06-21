package com.xiaomi.push;

/* loaded from: classes19.dex */
public class fu {
    private static com.xiaomi.push.fu b;
    public java.util.Map<java.lang.String, java.lang.Object> a = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, java.lang.Object> c = new java.util.concurrent.ConcurrentHashMap();

    private fu() {
        b();
    }

    public static synchronized com.xiaomi.push.fu a() {
        com.xiaomi.push.fu fuVar;
        synchronized (com.xiaomi.push.fu.class) {
            if (b == null) {
                b = new com.xiaomi.push.fu();
            }
            fuVar = b;
        }
        return fuVar;
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    private void b() {
        java.io.InputStream inputStream;
        java.util.Map<java.lang.String, java.lang.Object> map;
        java.lang.Object obj;
        java.util.Map<java.lang.String, java.lang.Object> map2;
        java.lang.Object obj2;
        try {
            java.lang.ClassLoader[] classLoaderArr = {com.xiaomi.push.fu.class.getClassLoader(), java.lang.Thread.currentThread().getContextClassLoader()};
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < 2; i++) {
                java.lang.ClassLoader classLoader = classLoaderArr[i];
                if (classLoader != null) {
                    arrayList.add(classLoader);
                }
            }
            for (java.lang.ClassLoader classLoader2 : (java.lang.ClassLoader[]) arrayList.toArray(new java.lang.ClassLoader[arrayList.size()])) {
                java.util.Enumeration<java.net.URL> resources = classLoader2.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    try {
                        inputStream = resources.nextElement().openStream();
                        try {
                            org.xmlpull.v1.XmlPullParser newPullParser = org.xmlpull.v1.XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals("iqProvider")) {
                                        newPullParser.next();
                                        newPullParser.next();
                                        java.lang.String nextText = newPullParser.nextText();
                                        newPullParser.next();
                                        newPullParser.next();
                                        java.lang.String nextText2 = newPullParser.nextText();
                                        newPullParser.next();
                                        newPullParser.next();
                                        java.lang.String nextText3 = newPullParser.nextText();
                                        java.lang.String b2 = b(nextText, nextText2);
                                        if (!this.c.containsKey(b2)) {
                                            try {
                                                java.lang.Class<?> cls = java.lang.Class.forName(nextText3);
                                                if (com.xiaomi.push.fs.class.isAssignableFrom(cls)) {
                                                    map2 = this.c;
                                                    obj2 = cls.newInstance();
                                                } else if (com.xiaomi.push.fl.class.isAssignableFrom(cls)) {
                                                    map2 = this.c;
                                                    obj2 = cls;
                                                }
                                                map2.put(b2, obj2);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                e = e;
                                                e.printStackTrace();
                                                eventType = newPullParser.next();
                                            }
                                        }
                                    } else if (newPullParser.getName().equals("extensionProvider")) {
                                        newPullParser.next();
                                        newPullParser.next();
                                        java.lang.String nextText4 = newPullParser.nextText();
                                        newPullParser.next();
                                        newPullParser.next();
                                        java.lang.String nextText5 = newPullParser.nextText();
                                        newPullParser.next();
                                        newPullParser.next();
                                        java.lang.String nextText6 = newPullParser.nextText();
                                        java.lang.String b3 = b(nextText4, nextText5);
                                        if (!this.a.containsKey(b3)) {
                                            try {
                                                java.lang.Class<?> cls2 = java.lang.Class.forName(nextText6);
                                                if (com.xiaomi.push.ft.class.isAssignableFrom(cls2)) {
                                                    map = this.a;
                                                    obj = cls2.newInstance();
                                                } else if (com.xiaomi.push.fo.class.isAssignableFrom(cls2)) {
                                                    map = this.a;
                                                    obj = cls2;
                                                }
                                                map.put(b3, obj);
                                            } catch (java.lang.ClassNotFoundException e2) {
                                                e = e2;
                                                e.printStackTrace();
                                                eventType = newPullParser.next();
                                            }
                                        }
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                            inputStream.close();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception unused) {
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                }
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
    }

    public final java.lang.Object a(java.lang.String str, java.lang.String str2) {
        return this.a.get(b(str, str2));
    }
}
