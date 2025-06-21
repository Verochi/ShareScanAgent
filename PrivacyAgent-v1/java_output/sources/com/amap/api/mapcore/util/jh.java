package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jh {
    private java.lang.StringBuilder a = new java.lang.StringBuilder();

    public final com.amap.api.mapcore.util.je a(java.lang.String str, android.content.Context context, com.amap.api.mapcore.util.hj hjVar) {
        com.amap.api.mapcore.util.je jeVar = new com.amap.api.mapcore.util.je("");
        jeVar.setErrorCode(7);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                this.a.append("json is error ".concat(java.lang.String.valueOf(str)));
            }
            java.lang.String string = jSONObject.getString("status");
            java.lang.String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                this.a.append("auth fail:".concat(java.lang.String.valueOf(string2)));
            }
        } catch (java.lang.Throwable th) {
            this.a.append("json exception error:" + th.getMessage());
            com.amap.api.mapcore.util.it.a(th, "MapParser", "paseAuthFailurJson");
        }
        try {
            java.lang.StringBuilder sb = this.a;
            sb.append("#SHA1AndPackage#");
            sb.append(com.amap.api.mapcore.util.ev.e(context));
            java.lang.String str2 = hjVar.b.get("gsid").get(0);
            if (!android.text.TextUtils.isEmpty(str2)) {
                java.lang.StringBuilder sb2 = this.a;
                sb2.append(" #gsid#");
                sb2.append(str2);
            }
            java.lang.String str3 = hjVar.c;
            if (!android.text.TextUtils.isEmpty(str3)) {
                this.a.append(" #csid#".concat(java.lang.String.valueOf(str3)));
            }
        } catch (java.lang.Throwable unused) {
        }
        jeVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            java.lang.StringBuilder sb3 = this.a;
            sb3.delete(0, sb3.length());
        }
        return jeVar;
    }

    public final com.amap.api.mapcore.util.je a(byte[] bArr) {
        com.amap.api.mapcore.util.je jeVar;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.nio.ByteBuffer byteBuffer = null;
        try {
            jeVar = new com.amap.api.mapcore.util.je("");
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.mapcore.util.je jeVar2 = new com.amap.api.mapcore.util.je("");
                jeVar2.setErrorCode(5);
                this.a.append("parser data error:" + th.getMessage());
                jeVar2.setLocationDetail(this.a.toString());
                jeVar = jeVar2;
            } finally {
                if (0 != 0) {
                    byteBuffer.clear();
                }
            }
        }
        if (bArr == null) {
            jeVar.setErrorCode(5);
            this.a.append("byte[] is null");
            jeVar.setLocationDetail(this.a.toString());
            java.lang.StringBuilder sb = this.a;
            sb.delete(0, sb.length());
            return jeVar;
        }
        java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
        if (wrap.get() == 0) {
            jeVar.b(java.lang.String.valueOf((int) wrap.getShort()));
            wrap.clear();
            wrap.clear();
            return jeVar;
        }
        jeVar.setLongitude(com.amap.api.mapcore.util.ix.a(wrap.getInt() / 1000000.0d));
        jeVar.setLatitude(com.amap.api.mapcore.util.ix.a(wrap.getInt() / 1000000.0d));
        jeVar.setAccuracy(wrap.getShort());
        jeVar.c(java.lang.String.valueOf((int) wrap.get()));
        jeVar.d(java.lang.String.valueOf((int) wrap.get()));
        if (wrap.get() == 1) {
            byte[] bArr2 = new byte[wrap.get() & 255];
            wrap.get(bArr2);
            try {
                jeVar.setCountry(new java.lang.String(bArr2, "UTF-8"));
            } catch (java.lang.Throwable unused) {
            }
            byte[] bArr3 = new byte[wrap.get() & 255];
            wrap.get(bArr3);
            try {
                str = new java.lang.String(bArr3, "UTF-8");
                try {
                    jeVar.setProvince(str);
                } catch (java.lang.Throwable unused2) {
                }
            } catch (java.lang.Throwable unused3) {
                str = "";
            }
            byte[] bArr4 = new byte[wrap.get() & 255];
            wrap.get(bArr4);
            try {
                str2 = new java.lang.String(bArr4, "UTF-8");
                try {
                    jeVar.setCity(str2);
                } catch (java.lang.Throwable unused4) {
                }
            } catch (java.lang.Throwable unused5) {
                str2 = "";
            }
            byte[] bArr5 = new byte[wrap.get() & 255];
            wrap.get(bArr5);
            try {
                str3 = new java.lang.String(bArr5, "UTF-8");
                try {
                    jeVar.setDistrict(str3);
                } catch (java.lang.Throwable unused6) {
                }
            } catch (java.lang.Throwable unused7) {
                str3 = "";
            }
            byte[] bArr6 = new byte[wrap.get() & 255];
            wrap.get(bArr6);
            try {
                str4 = new java.lang.String(bArr6, "UTF-8");
                try {
                    jeVar.setStreet(str4);
                    jeVar.setRoad(str4);
                } catch (java.lang.Throwable unused8) {
                }
            } catch (java.lang.Throwable unused9) {
                str4 = "";
            }
            byte[] bArr7 = new byte[wrap.get() & 255];
            wrap.get(bArr7);
            try {
                jeVar.setNumber(new java.lang.String(bArr7, "UTF-8"));
            } catch (java.lang.Throwable unused10) {
            }
            byte[] bArr8 = new byte[wrap.get() & 255];
            wrap.get(bArr8);
            try {
                str5 = new java.lang.String(bArr8, "UTF-8");
                try {
                    jeVar.setPoiName(str5);
                } catch (java.lang.Throwable unused11) {
                }
            } catch (java.lang.Throwable unused12) {
                str5 = "";
            }
            byte[] bArr9 = new byte[wrap.get() & 255];
            wrap.get(bArr9);
            try {
                jeVar.setAoiName(new java.lang.String(bArr9, "UTF-8"));
            } catch (java.lang.Throwable unused13) {
            }
            byte[] bArr10 = new byte[wrap.get() & 255];
            wrap.get(bArr10);
            try {
                str6 = new java.lang.String(bArr10, "UTF-8");
                try {
                    jeVar.setAdCode(str6);
                } catch (java.lang.Throwable unused14) {
                }
            } catch (java.lang.Throwable unused15) {
                str6 = "";
            }
            byte[] bArr11 = new byte[wrap.get() & 255];
            wrap.get(bArr11);
            try {
                jeVar.setCityCode(new java.lang.String(bArr11, "UTF-8"));
            } catch (java.lang.Throwable unused16) {
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            if (!android.text.TextUtils.isEmpty(str)) {
                sb2.append(str);
                sb2.append(" ");
            }
            if (!android.text.TextUtils.isEmpty(str2) && (!str.contains("市") || !str.equals(str2))) {
                sb2.append(str2);
                sb2.append(" ");
            }
            if (!android.text.TextUtils.isEmpty(str3)) {
                sb2.append(str3);
                sb2.append(" ");
            }
            if (!android.text.TextUtils.isEmpty(str4)) {
                sb2.append(str4);
                sb2.append(" ");
            }
            if (!android.text.TextUtils.isEmpty(str5)) {
                if (!android.text.TextUtils.isEmpty(str6)) {
                    sb2.append("靠近");
                }
                sb2.append(str5);
                sb2.append(" ");
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("citycode", jeVar.getCityCode());
            bundle.putString("desc", sb2.toString());
            bundle.putString("adcode", jeVar.getAdCode());
            jeVar.setExtras(bundle);
            jeVar.e(sb2.toString());
            java.lang.String adCode = jeVar.getAdCode();
            jeVar.setAddress((adCode == null || adCode.trim().length() <= 0) ? sb2.toString() : sb2.toString().replace(" ", ""));
        }
        wrap.get(new byte[wrap.get() & 255]);
        if (wrap.get() == 1) {
            wrap.getInt();
            wrap.getInt();
            wrap.getShort();
        }
        if (wrap.get() == 1) {
            byte[] bArr12 = new byte[wrap.get() & 255];
            wrap.get(bArr12);
            try {
                jeVar.setBuildingId(new java.lang.String(bArr12, "UTF-8"));
            } catch (java.lang.Throwable unused17) {
            }
            byte[] bArr13 = new byte[wrap.get() & 255];
            wrap.get(bArr13);
            try {
                jeVar.setFloor(new java.lang.String(bArr13, "UTF-8"));
            } catch (java.lang.Throwable unused18) {
            }
        }
        if (wrap.get() == 1) {
            wrap.get();
            wrap.getInt();
            wrap.get();
        }
        if (wrap.get() == 1) {
            jeVar.setTime(wrap.getLong());
        }
        byte[] bArr14 = new byte[wrap.getShort()];
        wrap.get(bArr14);
        try {
            jeVar.a(new java.lang.String(bArr14, "UTF-8"));
        } catch (java.lang.Throwable unused19) {
        }
        wrap.clear();
        if (this.a.length() > 0) {
            java.lang.StringBuilder sb3 = this.a;
            sb3.delete(0, sb3.length());
        }
        return jeVar;
    }
}
