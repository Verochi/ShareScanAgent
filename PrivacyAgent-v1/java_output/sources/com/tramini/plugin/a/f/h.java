package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class h extends com.tramini.plugin.a.f.f {

    /* renamed from: com.tramini.plugin.a.f.h$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tramini.plugin.a.f.f.c {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final boolean a(java.lang.Object obj) {
            return obj instanceof java.util.Map;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
            java.lang.Object obj2;
            java.util.Map map = (java.util.Map) obj;
            if (map == null || map.size() == 0) {
                return com.tramini.plugin.a.f.f.a.a();
            }
            if (map.containsKey(this.a) && (obj2 = map.get(this.a)) != null) {
                return obj2.getClass().getName().contains(this.b) ? com.tramini.plugin.a.f.f.a.a(obj2) : com.tramini.plugin.a.f.f.a.b(obj2);
            }
            return com.tramini.plugin.a.f.f.a.a();
        }
    }

    /* renamed from: com.tramini.plugin.a.f.h$2, reason: invalid class name */
    public class AnonymousClass2 implements com.tramini.plugin.a.f.f.c {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final boolean a(java.lang.Object obj) {
            return obj instanceof java.util.Map;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
            java.lang.Object value;
            java.util.Map map = (java.util.Map) obj;
            if (map == null || map.size() == 0) {
                return com.tramini.plugin.a.f.f.a.a();
            }
            java.util.Iterator it = map.entrySet().iterator();
            if (it.hasNext() && (value = ((java.util.Map.Entry) it.next()).getValue()) != null) {
                return value.getClass().getSimpleName().contains(this.a) ? com.tramini.plugin.a.f.f.a.a(value) : com.tramini.plugin.a.f.f.a.b(value);
            }
            return com.tramini.plugin.a.f.f.a.a();
        }
    }

    /* renamed from: com.tramini.plugin.a.f.h$3, reason: invalid class name */
    public class AnonymousClass3 implements com.tramini.plugin.a.f.f.c {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final boolean a(java.lang.Object obj) {
            return obj.getClass().getName().startsWith(this.a);
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
            try {
                java.lang.String str = this.b;
                return (str == null || !str.contains(obj.getClass().getName())) ? com.tramini.plugin.a.f.f.a.b(obj) : com.tramini.plugin.a.f.f.a.a(obj);
            } catch (java.lang.Throwable unused) {
                return com.tramini.plugin.a.f.f.a.a();
            }
        }
    }

    /* renamed from: com.tramini.plugin.a.f.h$4, reason: invalid class name */
    public class AnonymousClass4 implements com.tramini.plugin.a.f.f.c {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.StringBuffer c;
        final /* synthetic */ java.lang.String d;

        /* renamed from: com.tramini.plugin.a.f.h$4$1, reason: invalid class name */
        public class AnonymousClass1 implements com.tramini.plugin.a.f.f.c {
            public AnonymousClass1() {
            }

            @Override // com.tramini.plugin.a.f.f.c
            public final boolean a(java.lang.Object obj) {
                return obj.getClass().getName().startsWith(com.tramini.plugin.a.f.h.AnonymousClass4.this.b);
            }

            @Override // com.tramini.plugin.a.f.f.c
            public final com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
                java.lang.String str = com.tramini.plugin.a.f.h.AnonymousClass4.this.d;
                return (str == null || !str.contains(obj.getClass().getName())) ? com.tramini.plugin.a.f.f.a.b(obj) : com.tramini.plugin.a.f.f.a.a(obj);
            }
        }

        public AnonymousClass4(java.lang.String str, java.lang.String str2, java.lang.StringBuffer stringBuffer, java.lang.String str3) {
            this.a = str;
            this.b = str2;
            this.c = stringBuffer;
            this.d = str3;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final boolean a(java.lang.Object obj) {
            return obj instanceof java.util.Map;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
            java.util.Map map;
            java.lang.Object obj2;
            try {
                map = (java.util.Map) obj;
            } catch (java.lang.Throwable unused) {
            }
            if (map != null && map.size() > 0) {
                if (map.containsKey(this.a) && (obj2 = map.get(this.a)) != null) {
                    java.lang.Object a = com.tramini.plugin.a.f.f.a(obj2, this.b, this.c, new com.tramini.plugin.a.f.h.AnonymousClass4.AnonymousClass1());
                    if (a != null) {
                        return com.tramini.plugin.a.f.f.a.a(a);
                    }
                    return com.tramini.plugin.a.f.f.a.a();
                }
                return com.tramini.plugin.a.f.f.a.a();
            }
            return com.tramini.plugin.a.f.f.a.a();
        }
    }

    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray) {
        try {
            java.lang.Object a = com.tramini.plugin.a.f.f.a(obj, str, new java.lang.StringBuffer(), new com.tramini.plugin.a.f.h.AnonymousClass1(str5, str2));
            java.lang.Object a2 = a == null ? null : com.tramini.plugin.a.f.f.a(a, str, new java.lang.StringBuffer(), new com.tramini.plugin.a.f.h.AnonymousClass2(str3));
            if (a2 == null) {
                return null;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.Object a3 = com.tramini.plugin.a.f.f.a(a2, str4, stringBuffer, new com.tramini.plugin.a.f.h.AnonymousClass3(str4, str6));
            if (a3 == null) {
                a3 = com.tramini.plugin.a.f.f.a(a2, str4, new java.lang.StringBuffer(), new com.tramini.plugin.a.f.h.AnonymousClass4(str5, str4, stringBuffer, str6));
            }
            if (a3 == null) {
                return null;
            }
            return a(a3, str7, str8, jSONObject, jSONArray);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray) {
        java.lang.Object obj2;
        java.lang.Object obj3;
        try {
            java.lang.String[] split = str2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (split.length != 2) {
                return null;
            }
            try {
                java.util.List list = (java.util.List) com.tramini.plugin.a.f.f.b(obj, str);
                obj2 = null;
                for (int i = 0; i < list.size() && (obj2 = list.get(i)) == null; i++) {
                    try {
                    } catch (java.lang.Exception unused) {
                    }
                }
            } catch (java.lang.Exception unused2) {
                obj2 = null;
            }
            java.lang.Object a = com.tramini.plugin.a.f.f.a(com.tramini.plugin.a.f.f.b(obj2, split[0]), split[1]);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                java.lang.String optString = jSONArray.optString(i2);
                java.lang.String optString2 = jSONObject.optString(optString);
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    try {
                        java.lang.String str3 = (java.lang.String) com.tramini.plugin.a.f.f.b(obj, optString2);
                        if (android.text.TextUtils.isEmpty(str3)) {
                            java.lang.String str4 = (java.lang.String) com.tramini.plugin.a.f.f.b(obj2, optString2);
                            if (!android.text.TextUtils.isEmpty(str4)) {
                                jSONObject2.put(optString, str4);
                            } else if (a instanceof java.lang.String) {
                                java.lang.String obj4 = a.toString();
                                org.json.JSONArray jSONArray2 = new org.json.JSONArray(optString2);
                                int i3 = 0;
                                boolean z = false;
                                while (i3 < jSONArray2.length()) {
                                    java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(jSONArray2.optString(i3)).matcher(obj4);
                                    while (true) {
                                        if (!matcher.find()) {
                                            obj3 = a;
                                            break;
                                        }
                                        java.lang.String group = matcher.group();
                                        int indexOf = group.indexOf(">");
                                        int indexOf2 = group.indexOf("<");
                                        obj3 = a;
                                        if (indexOf != -1 && indexOf2 != -1) {
                                            try {
                                                java.lang.String substring = group.substring(indexOf + 1, indexOf2);
                                                if (!android.text.TextUtils.isEmpty(substring)) {
                                                    jSONObject2.put(optString, substring);
                                                    z = true;
                                                    break;
                                                }
                                            } catch (java.lang.Throwable unused3) {
                                            }
                                        }
                                        a = obj3;
                                    }
                                    if (!z) {
                                        i3++;
                                        a = obj3;
                                    }
                                }
                            }
                        } else {
                            jSONObject2.put(optString, str3);
                        }
                    } catch (java.lang.Throwable unused4) {
                    }
                    obj3 = a;
                    i2++;
                    a = obj3;
                }
                obj3 = a;
                i2++;
                a = obj3;
            }
            if (jSONObject2.length() <= 0) {
                return null;
            }
            com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
            aVar.a = jSONObject2;
            return aVar;
        } catch (java.lang.Throwable unused5) {
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str) {
        int i;
        int i2;
        java.lang.String[] strArr;
        java.lang.String optString = jSONObject.optString("pre1");
        java.lang.String optString2 = jSONObject.optString("pre2");
        java.lang.String optString3 = jSONObject.optString("clna");
        java.lang.String optString4 = jSONObject.optString("mena");
        java.lang.String optString5 = jSONObject.optString("adaptna");
        java.lang.String optString6 = jSONObject.optString("ctrlna");
        java.lang.String optString7 = jSONObject.optString("in_na");
        java.lang.String optString8 = jSONObject.optString("objna_arr");
        java.lang.String optString9 = jSONObject.optString("obj2na");
        java.lang.String optString10 = jSONObject.optString(com.baidu.mobads.sdk.internal.a.f);
        java.lang.Object d = d(optString7, str);
        java.lang.String str2 = d instanceof java.lang.String ? (java.lang.String) d : null;
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        java.lang.String[] split = optString3.split(",");
        int length = split.length;
        int i3 = 0;
        while (i3 < length) {
            java.lang.Object b = com.tramini.plugin.a.f.f.b(split[i3], optString4);
            if (b != null) {
                i = i3;
                i2 = length;
                strArr = split;
                com.tramini.plugin.a.d.a a = a(b, optString, optString6, optString5, optString2, str2, optString8, optString9, optString10, jSONObject, cVar.e);
                if (a != null) {
                    return a;
                }
            } else {
                i = i3;
                i2 = length;
                strArr = split;
            }
            i3 = i + 1;
            length = i2;
            split = strArr;
        }
        return null;
    }

    private static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.Object a = com.tramini.plugin.a.f.f.a(obj, str, stringBuffer, new com.tramini.plugin.a.f.h.AnonymousClass3(str, str3));
        return a != null ? a : com.tramini.plugin.a.f.f.a(obj, str, new java.lang.StringBuffer(), new com.tramini.plugin.a.f.h.AnonymousClass4(str2, str, stringBuffer, str3));
    }

    private static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.Object a = com.tramini.plugin.a.f.f.a(obj, str, new java.lang.StringBuffer(), new com.tramini.plugin.a.f.h.AnonymousClass1(str2, str3));
        if (a == null) {
            return null;
        }
        return com.tramini.plugin.a.f.f.a(a, str, new java.lang.StringBuffer(), new com.tramini.plugin.a.f.h.AnonymousClass2(str4));
    }

    private static java.lang.Object d(java.lang.String str, java.lang.String str2) {
        java.util.Map map;
        try {
            java.lang.Object invoke = java.lang.Class.forName(str).getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field[] declaredFields = invoke.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (java.lang.reflect.Field field : declaredFields) {
                    field.setAccessible(true);
                    if ((field.get(invoke) instanceof java.util.Map) && (map = (java.util.Map) field.get(invoke)) != null && map.containsKey(str2)) {
                        return map.get(str2);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }
}
