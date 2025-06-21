package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Frustum {
    public static final com.badlogic.gdx.math.Vector3 a;
    protected static final com.badlogic.gdx.math.Vector3[] clipSpacePlanePoints;
    protected static final float[] clipSpacePlanePointsArray;
    public final com.badlogic.gdx.math.Plane[] planes = new com.badlogic.gdx.math.Plane[6];
    public final com.badlogic.gdx.math.Vector3[] planePoints = {new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3()};
    protected final float[] planePointsArray = new float[24];

    static {
        int i = 0;
        com.badlogic.gdx.math.Vector3[] vector3Arr = {new com.badlogic.gdx.math.Vector3(-1.0f, -1.0f, -1.0f), new com.badlogic.gdx.math.Vector3(1.0f, -1.0f, -1.0f), new com.badlogic.gdx.math.Vector3(1.0f, 1.0f, -1.0f), new com.badlogic.gdx.math.Vector3(-1.0f, 1.0f, -1.0f), new com.badlogic.gdx.math.Vector3(-1.0f, -1.0f, 1.0f), new com.badlogic.gdx.math.Vector3(1.0f, -1.0f, 1.0f), new com.badlogic.gdx.math.Vector3(1.0f, 1.0f, 1.0f), new com.badlogic.gdx.math.Vector3(-1.0f, 1.0f, 1.0f)};
        clipSpacePlanePoints = vector3Arr;
        clipSpacePlanePointsArray = new float[24];
        int length = vector3Arr.length;
        int i2 = 0;
        while (i < length) {
            com.badlogic.gdx.math.Vector3 vector3 = vector3Arr[i];
            float[] fArr = clipSpacePlanePointsArray;
            int i3 = i2 + 1;
            fArr[i2] = vector3.x;
            int i4 = i3 + 1;
            fArr[i3] = vector3.y;
            fArr[i4] = vector3.z;
            i++;
            i2 = i4 + 1;
        }
        a = new com.badlogic.gdx.math.Vector3();
    }

    public Frustum() {
        for (int i = 0; i < 6; i++) {
            this.planes[i] = new com.badlogic.gdx.math.Plane(new com.badlogic.gdx.math.Vector3(), 0.0f);
        }
    }

    public boolean boundsInFrustum(float f, float f2, float f3, float f4, float f5, float f6) {
        int length = this.planes.length;
        for (int i = 0; i < length; i++) {
            float f7 = f + f4;
            float f8 = f2 + f5;
            float f9 = f3 + f6;
            com.badlogic.gdx.math.Plane.PlaneSide testPoint = this.planes[i].testPoint(f7, f8, f9);
            com.badlogic.gdx.math.Plane.PlaneSide planeSide = com.badlogic.gdx.math.Plane.PlaneSide.Back;
            if (testPoint == planeSide) {
                float f10 = f3 - f6;
                if (this.planes[i].testPoint(f7, f8, f10) != planeSide) {
                    continue;
                } else {
                    float f11 = f2 - f5;
                    if (this.planes[i].testPoint(f7, f11, f9) == planeSide && this.planes[i].testPoint(f7, f11, f10) == planeSide) {
                        float f12 = f - f4;
                        if (this.planes[i].testPoint(f12, f8, f9) == planeSide && this.planes[i].testPoint(f12, f8, f10) == planeSide && this.planes[i].testPoint(f12, f11, f9) == planeSide && this.planes[i].testPoint(f12, f11, f10) == planeSide) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean boundsInFrustum(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        return boundsInFrustum(vector3.x, vector3.y, vector3.z, vector32.x / 2.0f, vector32.y / 2.0f, vector32.z / 2.0f);
    }

    public boolean boundsInFrustum(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        int length = this.planes.length;
        for (int i = 0; i < length; i++) {
            com.badlogic.gdx.math.Plane plane = this.planes[i];
            com.badlogic.gdx.math.Vector3 vector3 = a;
            com.badlogic.gdx.math.Plane.PlaneSide testPoint = plane.testPoint(boundingBox.getCorner000(vector3));
            com.badlogic.gdx.math.Plane.PlaneSide planeSide = com.badlogic.gdx.math.Plane.PlaneSide.Back;
            if (testPoint == planeSide && this.planes[i].testPoint(boundingBox.getCorner001(vector3)) == planeSide && this.planes[i].testPoint(boundingBox.getCorner010(vector3)) == planeSide && this.planes[i].testPoint(boundingBox.getCorner011(vector3)) == planeSide && this.planes[i].testPoint(boundingBox.getCorner100(vector3)) == planeSide && this.planes[i].testPoint(boundingBox.getCorner101(vector3)) == planeSide && this.planes[i].testPoint(boundingBox.getCorner110(vector3)) == planeSide && this.planes[i].testPoint(boundingBox.getCorner111(vector3)) == planeSide) {
                return false;
            }
        }
        return true;
    }

    public boolean pointInFrustum(float f, float f2, float f3) {
        int i = 0;
        while (true) {
            com.badlogic.gdx.math.Plane[] planeArr = this.planes;
            if (i >= planeArr.length) {
                return true;
            }
            if (planeArr[i].testPoint(f, f2, f3) == com.badlogic.gdx.math.Plane.PlaneSide.Back) {
                return false;
            }
            i++;
        }
    }

    public boolean pointInFrustum(com.badlogic.gdx.math.Vector3 vector3) {
        int i = 0;
        while (true) {
            com.badlogic.gdx.math.Plane[] planeArr = this.planes;
            if (i >= planeArr.length) {
                return true;
            }
            if (planeArr[i].testPoint(vector3) == com.badlogic.gdx.math.Plane.PlaneSide.Back) {
                return false;
            }
            i++;
        }
    }

    public boolean sphereInFrustum(float f, float f2, float f3, float f4) {
        for (int i = 0; i < 6; i++) {
            com.badlogic.gdx.math.Plane plane = this.planes[i];
            com.badlogic.gdx.math.Vector3 vector3 = plane.normal;
            if ((vector3.x * f) + (vector3.y * f2) + (vector3.z * f3) < (-f4) - plane.d) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustum(com.badlogic.gdx.math.Vector3 vector3, float f) {
        for (int i = 0; i < 6; i++) {
            com.badlogic.gdx.math.Plane plane = this.planes[i];
            com.badlogic.gdx.math.Vector3 vector32 = plane.normal;
            if ((vector32.x * vector3.x) + (vector32.y * vector3.y) + (vector32.z * vector3.z) < (-f) - plane.d) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustumWithoutNearFar(float f, float f2, float f3, float f4) {
        for (int i = 2; i < 6; i++) {
            com.badlogic.gdx.math.Plane plane = this.planes[i];
            com.badlogic.gdx.math.Vector3 vector3 = plane.normal;
            if ((vector3.x * f) + (vector3.y * f2) + (vector3.z * f3) < (-f4) - plane.d) {
                return false;
            }
        }
        return true;
    }

    public boolean sphereInFrustumWithoutNearFar(com.badlogic.gdx.math.Vector3 vector3, float f) {
        for (int i = 2; i < 6; i++) {
            com.badlogic.gdx.math.Plane plane = this.planes[i];
            com.badlogic.gdx.math.Vector3 vector32 = plane.normal;
            if ((vector32.x * vector3.x) + (vector32.y * vector3.y) + (vector32.z * vector3.z) < (-f) - plane.d) {
                return false;
            }
        }
        return true;
    }

    public void update(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = clipSpacePlanePointsArray;
        java.lang.System.arraycopy(fArr, 0, this.planePointsArray, 0, fArr.length);
        com.badlogic.gdx.math.Matrix4.prj(matrix4.val, this.planePointsArray, 0, 8, 3);
        int i = 0;
        int i2 = 0;
        while (i < 8) {
            com.badlogic.gdx.math.Vector3 vector3 = this.planePoints[i];
            float[] fArr2 = this.planePointsArray;
            int i3 = i2 + 1;
            vector3.x = fArr2[i2];
            int i4 = i3 + 1;
            vector3.y = fArr2[i3];
            vector3.z = fArr2[i4];
            i++;
            i2 = i4 + 1;
        }
        com.badlogic.gdx.math.Plane plane = this.planes[0];
        com.badlogic.gdx.math.Vector3[] vector3Arr = this.planePoints;
        plane.set(vector3Arr[1], vector3Arr[0], vector3Arr[2]);
        com.badlogic.gdx.math.Plane plane2 = this.planes[1];
        com.badlogic.gdx.math.Vector3[] vector3Arr2 = this.planePoints;
        plane2.set(vector3Arr2[4], vector3Arr2[5], vector3Arr2[7]);
        com.badlogic.gdx.math.Plane plane3 = this.planes[2];
        com.badlogic.gdx.math.Vector3[] vector3Arr3 = this.planePoints;
        plane3.set(vector3Arr3[0], vector3Arr3[4], vector3Arr3[3]);
        com.badlogic.gdx.math.Plane plane4 = this.planes[3];
        com.badlogic.gdx.math.Vector3[] vector3Arr4 = this.planePoints;
        plane4.set(vector3Arr4[5], vector3Arr4[1], vector3Arr4[6]);
        com.badlogic.gdx.math.Plane plane5 = this.planes[4];
        com.badlogic.gdx.math.Vector3[] vector3Arr5 = this.planePoints;
        plane5.set(vector3Arr5[2], vector3Arr5[3], vector3Arr5[6]);
        com.badlogic.gdx.math.Plane plane6 = this.planes[5];
        com.badlogic.gdx.math.Vector3[] vector3Arr6 = this.planePoints;
        plane6.set(vector3Arr6[4], vector3Arr6[0], vector3Arr6[1]);
    }
}
