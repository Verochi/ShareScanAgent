package com.alipay.apmobilesecuritysdk.common;

/* loaded from: classes.dex */
public final class a {
    public static boolean a(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(com.alipay.apmobilesecuritysdk.e.h.e(context));
        return a(arrayList) || a(new com.alipay.apmobilesecuritysdk.common.RushTimeUtil$1());
    }

    public static boolean a(java.util.List<java.lang.String> list) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        int random = ((int) (java.lang.Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        try {
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                java.lang.String[] split = it.next().split("&");
                if (split != null && split.length == 2) {
                    java.util.Date date = new java.util.Date();
                    java.util.Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    java.util.Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    java.util.Calendar calendar = java.util.Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    java.util.Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }
}
