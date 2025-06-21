package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fc {
    private static int a = 5000;
    private static int b = 330000;
    private static int c = 600000;
    private static int d = 330000;
    private static java.util.Vector<java.lang.String> e = new java.util.Vector<>();

    static {
        try {
            for (java.lang.ClassLoader classLoader : d()) {
                java.util.Enumeration<java.net.URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    java.io.InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            org.xmlpull.v1.XmlPullParser newPullParser = org.xmlpull.v1.XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals(com.vivo.push.PushClientConstants.TAG_CLASS_NAME)) {
                                        java.lang.String nextText = newPullParser.nextText();
                                        try {
                                            java.lang.Class.forName(nextText);
                                        } catch (java.lang.ClassNotFoundException unused) {
                                            java.lang.System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: ".concat(java.lang.String.valueOf(nextText)));
                                        }
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        a = a(newPullParser, a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        b = a(newPullParser, b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        e.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } finally {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
    }

    private fc() {
    }

    private static int a(org.xmlpull.v1.XmlPullParser xmlPullParser, int i) {
        try {
            return java.lang.Integer.parseInt(xmlPullParser.nextText());
        } catch (java.lang.NumberFormatException e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public static java.lang.String a() {
        return "3.1.0";
    }

    public static int b() {
        return b;
    }

    public static int c() {
        return c;
    }

    private static java.lang.ClassLoader[] d() {
        java.lang.ClassLoader[] classLoaderArr = {com.xiaomi.push.fc.class.getClassLoader(), java.lang.Thread.currentThread().getContextClassLoader()};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < 2; i++) {
            java.lang.ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (java.lang.ClassLoader[]) arrayList.toArray(new java.lang.ClassLoader[arrayList.size()]);
    }
}
