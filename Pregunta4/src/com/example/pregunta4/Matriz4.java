package com.example.pregunta4;

public class Matriz4 {
    public static void identidad(float[] r) {
        r[0] = 1;
        r[4] = 0;
        r[8] = 0;
        r[12] = 0;
        r[1] = 0;
        r[5] = 1;
        r[9] = 0;
        r[13] = 0;
        r[2] = 0;
        r[6] = 0;
        r[10] = 1;
        r[14] = 0;
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] = 1;
    }

    public static void traslacion(float[] matriz, float tx, float ty, float tz) {
        float[] r = new float[16];
        r[0] = 1;
        r[4] = 0;
        r[8] = 0;
        r[12] = tx;
        r[1] = 0;
        r[5] = 1;
        r[9] = 0;
        r[13] = ty;
        r[2] = 0;
        r[6] = 0;
        r[10] = 1;
        r[14] = tz;
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] = 1;
        multiplica(matriz, matriz, r);
    }

    public static void escalacion(float[] matriz, float sx, float sy, float sz) {
        float[] r = new float[16];
        r[0] = sx;
        r[4] = 0;
        r[8] = 0;
        r[12] = 0;
        r[1] = 0;
        r[5] = sy;
        r[9] = 0;
        r[13] = 0;
        r[2] = 0;
        r[6] = 0;
        r[10] = sz;
        r[14] = 0;
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] = 1;
        multiplica(matriz, matriz, r);
    }

    public static void rotacionX(float[] matriz, float theta) {
        float[] r = new float[16];
        double angulo = theta * Math.PI / 180;
        float c = (float) Math.cos(angulo);
        float s = (float) Math.sin(angulo);
        r[0] = 1;
        r[4] = 0;
        r[8] = 0;
        r[12] = 0;
        r[1] = 0;
        r[5] = c;
        r[9] = -s;
        r[13] = 0;
        r[2] = 0;
        r[6] = s;
        r[10] = c;
        r[14] = 0;
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] = 1;
        multiplica(matriz, matriz, r);
    }

    public static void rotacionY(float[] matriz, float theta) {
        float[] r = new float[16];
        double angulo = theta * Math.PI / 180;
        float c = (float) Math.cos(angulo);
        float s = (float) Math.sin(angulo);
        r[0] = c;
        r[4] = 0;
        r[8] = s;
        r[12] = 0;
        r[1] = 0;
        r[5] = 1;
        r[9] = 0;
        r[13] = 0;
        r[2] = -s;
        r[6] = 0;
        r[10] = c;
        r[14] = 0;
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] = 1;
        multiplica(matriz, matriz, r);
    }

    public static void rotacionZ(float[] matriz, float theta) {
        float[] r = new float[16];
        double angulo = theta * Math.PI / 180;
        float c = (float) Math.cos(angulo);
        float s = (float) Math.sin(angulo);
        r[0] = c;
        r[4] = -s;
        r[8] = 0;
        r[12] = 0;
        r[1] = s;
        r[5] = c;
        r[9] = 0;
        r[13] = 0;
        r[2] = 0;
        r[6] = 0;
        r[10] = 1;
        r[14] = 0;
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] = 1;
        multiplica(matriz, matriz, r);
    }

    public static void ortho(float[] r, float izq, float der, float abj, float arr, float cerca, float lejos) {
        r[0] = 2 / (der - izq);
        r[4] = 0;
        r[8] = 0;
        r[12] =-(der + izq) / (der - izq);
        r[1] = 0;
        r[5] = 2 / (arr - abj);
        r[9] = 0;
        r[13] =-(arr + abj) / (arr - abj);
        r[2] = 0;
        r[6] = 0;
        r[10] = -2 / (lejos - cerca);
        r[14] = -(lejos + cerca) / (lejos - cerca);
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] =1;
    }

    public static void frustum(float[] r, float izq, float der, float abj, float arr, float cerca, float lejos) {
        r[0] = 2 * cerca / (der - izq);
        r[4] = 0;
        r[8] = (der + izq) / (der - izq);
        r[12] = 0;
        r[1] = 0;
        r[5] = 2 * cerca / (arr - abj);
        r[9] = (arr + abj) / (arr - abj);
        r[13] = 0;
        r[2] = 0;
        r[6] = 0;
        r[10] = -(lejos + cerca) / (lejos - cerca);
        r[14] = -2 * lejos * cerca / (lejos - cerca);
        r[3] = 0;
        r[7] = 0;
        r[11] =-1;
        r[15] = 0;
    }

    public static void perspective(float[] r, float fovy, float aspecto, float cerca, float lejos) {double ang = fovy * 0.5 * (Math.PI / 180);
        float f = Math.abs(Math.sin(ang)) < 1e-8 ? 0 : 1 / (float) Math.tan(ang);
        r[0] = f / aspecto;
        r[4] = 0;
        r[8] = 0;
        r[12] =0;
        r[1] = 0;
        r[5] = f;
        r[9] = 0;
        r[13] =0;
        r[2] = 0;
        r[6] = 0;
        r[10] = -(lejos + cerca) / (lejos - cerca);
        r[14] = -2.0f * lejos * cerca / (lejos - cerca);
        r[3] = 0;
        r[7] = 0;
        r[11] = -1.0f;
        r[15] =0;
    }

    public static void lookAt(float[] r, float vistaX, float vistaY, float vistaZ, float centroX, float centroY, float centroZ, float arribaX, float arribaY, float arribaZ) {
        Vector3 vista = new Vector3(vistaX, vistaY, vistaZ);
        Vector3 centro = new Vector3(centroX, centroY, centroZ);
        Vector3 arriba = new Vector3(arribaX, arribaY, arribaZ);
        Vector3 n = vista.menos(centro);
        n.normaliza();
        Vector3 v = arriba;
        Vector3 u = v.producto_vectorial(n);
        u.normaliza();
        v = n.producto_vectorial(u);
        r[0] = u.getX();
        r[4] = u.getY();
        r[8] = u.getZ();
        r[12] = -(vistaX * u.getX() + vistaY * u.getY() + vistaZ * u.getZ());
        r[1] = v.getX();
        r[5] = v.getY();
        r[9] = v.getZ();
        r[13] = -(vistaX * v.getX() + vistaY * v.getY() + vistaZ * v.getZ());
        r[2] = n.getX();
        r[6] = n.getY();
        r[10] = n.getZ();
        r[14] = -(vistaX * n.getX() + vistaY * n.getY() + vistaZ * n.getZ());
        r[3] = 0;
        r[7] = 0;
        r[11] = 0;
        r[15] =1;
    }

    public static void multiplica(float[] c, float[] a, float[] b) {
        float[] r = new float[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float s = 0;
                for (int k = 0; k < 4; k++)
                    s = s + a[i + k * 4] * b[k + j * 4];
                r[i + j * 4] = s;
            }
        }
        for (int i = 0; i < 16; i++)
            c[i] = r[i];
    }

    public static void multiplicaMV(float c[], float a[], float b[]) {
        float r[] = new float[3];

        r[0] = a[0] * b[0] + a[4] * b[1] + a[8] * b[2] + a[12];
        r[1] = a[1] * b[0] + a[5] * b[1] + a[9] * b[2] + a[13];
        r[2] = a[2] * b[0] + a[6] * b[1] + a[10] * b[2] + a[14];
        for (int i = 0; i < 3; i++)
            c[i] = r[i];
    }

    public static void transpuesta(float r[], float m[]) {
        int i = 0;
        for (int j = 0; j < 4; j++)
            for (int k = 0; k < 4; k++) {
                r[j + k * 4] = m[i];
                i++;
            }
    }


    public static void invierte(float b[], float a[]) {

        float s0 = a[0] * a[5] - a[1] * a[4];
        float s1 = a[0] * a[9] - a[1] * a[8];
        float s2 = a[0] * a[13] - a[1] * a[12];
        float s3 = a[4] * a[9] - a[5] * a[8];
        float s4 = a[4] * a[13] - a[5] * a[12];
        float s5 = a[8] * a[13] - a[9] * a[12];
        float c5 = a[10] * a[15] - a[11] * a[14];
        float c4 = a[6] * a[15] - a[7] * a[14];
        float c3 = a[6] * a[11] - a[7] * a[10];
        float c2 = a[2] * a[15] - a[3] * a[14];
        float c1 = a[2] * a[11] - a[3] * a[10];
        float c0 = a[2] * a[7] - a[3] * a[6];

        float invdet = 1.0f / (s0 * c5 - s1 * c4 + s2 * c3 + s3 * c2 - s4 * c1 + s5 * c0);
        b[0] = (a[5] * c5 - a[9] * c4 + a[13] * c3) * invdet;
        b[4] = (-a[4] * c5 + a[8] * c4 - a[12] * c3) * invdet;
        b[8] = (a[7] * s5 - a[11] * s4 + a[15] * s3) * invdet;
        b[12] = (-a[6] * s5 + a[10] * s4 - a[14] * s3) * invdet;
        b[1] = (-a[1] * c5 + a[9] * c2 - a[13] * c1) * invdet;
        b[5] = (a[0] * c5 - a[8] * c2 + a[12] * c1) * invdet;
        b[9] = (-a[3] * s5 + a[11] * s2 - a[15] * s1) * invdet;
        b[13] = (a[2] * s5 - a[10] * s2 + a[14] * s1) * invdet;
        b[2] = (a[1] * c4 - a[5] * c2 + a[13] * c0) * invdet;
        b[6] = (-a[0] * c4 + a[4] * c2 - a[12] * c0) * invdet;
        b[10] = (a[3] * s4 - a[7] * s2 + a[15] * s0) * invdet;
        b[14] = (-a[2] * s4 + a[6] * s2 - a[14] * s0) * invdet;
        b[3] = (-a[1] * c3 + a[5] * c1 - a[9] * c0) * invdet;
        b[7] = (a[0] * c3 - a[4] * c1 + a[8] * c0) * invdet;
        b[11] = (-a[3] * s3 + a[7] * s1 - a[11] * s0) * invdet;
        b[15] = (a[2] * s3 - a[6] * s1 + a[10] * s0) * invdet;
    }

    public static void copia(float b[], float a[]) {
        for (int i = 0; i < 16; i++)
            b[i] = a[i];
    }
}