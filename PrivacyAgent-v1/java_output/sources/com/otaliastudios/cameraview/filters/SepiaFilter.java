package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class SepiaFilter extends com.otaliastudios.cameraview.filter.BaseFilter {
    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nmat3 matrix;\nvarying vec2 vTextureCoord;\nvoid main() {\n  matrix[0][0]=0.3930664;\n  matrix[0][1]=0.3491211;\n  matrix[0][2]=0.27197266;\n  matrix[1][0]=0.76904297;\n  matrix[1][1]=0.68603516;\n  matrix[1][2]=0.53564453;\n  matrix[2][0]=0.18896484;\n  matrix[2][1]=0.16796875;\n  matrix[2][2]=0.13085938;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  vec3 new_color = min(matrix * color.rgb, 1.0);\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }
}
