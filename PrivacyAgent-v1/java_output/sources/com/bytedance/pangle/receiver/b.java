package com.bytedance.pangle.receiver;

/* loaded from: classes12.dex */
public final class b {
    private static final com.bytedance.pangle.receiver.b.c a;

    public static class a implements com.bytedance.pangle.receiver.b.c {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static java.lang.Object a(android.content.Context context, java.lang.String str) {
            return a(b(context), str);
        }

        private static java.lang.Object a(java.lang.Object obj, java.lang.String str) {
            if (obj == null) {
                return null;
            }
            try {
                return com.bytedance.pangle.util.FieldUtils.readField(obj, str);
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        private static java.lang.Object b(android.content.Context context) {
            java.lang.reflect.Field field;
            java.lang.Object readField;
            try {
                java.lang.reflect.Field field2 = com.bytedance.pangle.util.FieldUtils.getField(java.lang.Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = com.bytedance.pangle.util.FieldUtils.getField(java.lang.Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = com.bytedance.pangle.util.FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return com.bytedance.pangle.util.FieldUtils.readField(field2, readField);
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(android.content.Context context) {
            java.lang.Object b = b(context);
            java.lang.Object a = a(b, "mWhiteList");
            if (!(a instanceof java.lang.String[])) {
                if (b == null) {
                    return false;
                }
                com.bytedance.pangle.util.FieldUtils.writeField(b, "mResourceConfig", (java.lang.Object) null);
                return false;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(context.getPackageName());
            java.util.Collections.addAll(arrayList, (java.lang.String[]) a);
            com.bytedance.pangle.util.FieldUtils.writeField(b, "mWhiteList", arrayList.toArray(new java.lang.String[arrayList.size()]));
            return true;
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b, reason: collision with other inner class name */
    public static class C0271b extends com.bytedance.pangle.receiver.b.e {
        private C0271b() {
            super((byte) 0);
        }

        public /* synthetic */ C0271b(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(android.content.Context context) {
            return false;
        }
    }

    public interface c {
        boolean a(android.content.Context context);
    }

    public static class d extends com.bytedance.pangle.receiver.b.a {
        private d() {
            super((byte) 0);
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(android.content.Context context) {
            java.lang.Object a = com.bytedance.pangle.receiver.b.a.a(context, "mWhiteList");
            if (!(a instanceof java.util.List)) {
                return false;
            }
            ((java.util.List) a).add(context.getPackageName());
            return true;
        }
    }

    public static class e extends com.bytedance.pangle.receiver.b.a {
        private e() {
            super((byte) 0);
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(android.content.Context context) {
            java.lang.Object a = com.bytedance.pangle.receiver.b.a.a(context, "mWhiteListMap");
            if (!(a instanceof java.util.Map)) {
                return false;
            }
            java.util.Map map = (java.util.Map) a;
            java.util.List list = (java.util.List) map.get(0);
            if (list == null) {
                list = new java.util.ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }
    }

    static {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 24) {
            a = new com.bytedance.pangle.receiver.b.a((byte) 0);
            return;
        }
        if (i < 26) {
            a = new com.bytedance.pangle.receiver.b.d((byte) 0);
        } else if (i < 28) {
            a = new com.bytedance.pangle.receiver.b.e((byte) 0);
        } else {
            a = new com.bytedance.pangle.receiver.b.C0271b((byte) 0);
        }
    }

    public static void a(android.app.Application application) {
        if (application != null) {
            try {
                if (android.text.TextUtils.equals(android.os.Build.BRAND.toLowerCase(), com.igexin.assist.util.AssistUtils.BRAND_HW)) {
                    a.a(application.getBaseContext());
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
