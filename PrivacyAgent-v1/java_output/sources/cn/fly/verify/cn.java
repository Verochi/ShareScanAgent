package cn.fly.verify;

/* loaded from: classes.dex */
public class cn implements cn.fly.verify.cw<cn.fly.verify.cn> {
    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.cn cnVar, java.lang.Class<cn.fly.verify.cn> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4;
        java.lang.Object obj5;
        java.lang.Object obj6;
        java.lang.Object obj7;
        java.lang.Object obj8;
        java.lang.Object obj9;
        java.lang.Object obj10;
        java.lang.Object obj11;
        java.lang.Object obj12;
        if ("andOperation".equals(str) && objArr.length == 2) {
            java.lang.Object obj13 = objArr[0];
            if (obj13 != null && (obj13 instanceof java.lang.Integer) && (obj12 = objArr[1]) != null && (obj12 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(((java.lang.Integer) obj13).intValue() & ((java.lang.Integer) objArr[1]).intValue());
            } else if (obj13 != null && (obj13 instanceof java.lang.Long) && (obj11 = objArr[1]) != null && (obj11 instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(((java.lang.Long) obj13).longValue() & ((java.lang.Long) objArr[1]).longValue());
            }
        } else if ("orOperation".equals(str) && objArr.length == 2) {
            java.lang.Object obj14 = objArr[0];
            if (obj14 != null && (obj14 instanceof java.lang.Integer) && (obj10 = objArr[1]) != null && (obj10 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(((java.lang.Integer) obj14).intValue() | ((java.lang.Integer) objArr[1]).intValue());
            } else if (obj14 != null && (obj14 instanceof java.lang.Long) && (obj9 = objArr[1]) != null && (obj9 instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(((java.lang.Long) obj14).longValue() | ((java.lang.Long) objArr[1]).longValue());
            }
        } else if ("rMoveOperation".equals(str) && objArr.length == 2) {
            java.lang.Object obj15 = objArr[0];
            if (obj15 != null && (obj15 instanceof java.lang.Integer) && (obj8 = objArr[1]) != null && (obj8 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(((java.lang.Integer) obj15).intValue() >> ((java.lang.Integer) objArr[1]).intValue());
            } else if (obj15 != null && (obj15 instanceof java.lang.Long) && (obj7 = objArr[1]) != null && (obj7 instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(((java.lang.Long) obj15).longValue() >> ((int) ((java.lang.Long) objArr[1]).longValue()));
            }
        } else if ("rrrMoveOperation".equals(str) && objArr.length == 2) {
            java.lang.Object obj16 = objArr[0];
            if (obj16 != null && (obj16 instanceof java.lang.Integer) && (obj6 = objArr[1]) != null && (obj6 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(((java.lang.Integer) obj16).intValue() >>> ((java.lang.Integer) objArr[1]).intValue());
            } else if (obj16 != null && (obj16 instanceof java.lang.Long) && (obj5 = objArr[1]) != null && (obj5 instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(((java.lang.Long) obj16).longValue() >>> ((int) ((java.lang.Long) objArr[1]).longValue()));
            }
        } else if ("lMoveOperation".equals(str) && objArr.length == 2) {
            java.lang.Object obj17 = objArr[0];
            if (obj17 != null && (obj17 instanceof java.lang.Integer) && (obj4 = objArr[1]) != null && (obj4 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(((java.lang.Integer) obj17).intValue() << ((java.lang.Integer) objArr[1]).intValue());
            } else if (obj17 != null && (obj17 instanceof java.lang.Long) && (obj3 = objArr[1]) != null && (obj3 instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(((java.lang.Long) obj17).longValue() << ((int) ((java.lang.Long) objArr[1]).longValue()));
            }
        } else if ("xOperation".equals(str) && objArr.length == 1) {
            java.lang.Object obj18 = objArr[0];
            if (obj18 != null && (obj18 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(~((java.lang.Integer) obj18).intValue());
            } else if (obj18 != null && (obj18 instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(~((java.lang.Long) obj18).longValue());
            }
        } else {
            if (!"xorOperation".equals(str) || objArr.length != 2) {
                return false;
            }
            java.lang.Object obj19 = objArr[0];
            if (obj19 != null && (obj19 instanceof java.lang.Integer) && (obj2 = objArr[1]) != null && (obj2 instanceof java.lang.Integer)) {
                objArr2[0] = java.lang.Integer.valueOf(((java.lang.Integer) obj19).intValue() ^ ((java.lang.Integer) objArr[1]).intValue());
            } else if (obj19 != null && (obj19 instanceof java.lang.Long) && (obj = objArr[1]) != null && (obj instanceof java.lang.Long)) {
                objArr2[0] = java.lang.Long.valueOf(((java.lang.Long) obj19).longValue() ^ ((java.lang.Long) objArr[1]).longValue());
            }
        }
        return true;
    }
}
