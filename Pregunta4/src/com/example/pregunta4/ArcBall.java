package com.example.pregunta4;

public class ArcBall {
    private static final float Epsilon = 1.0e-5f;
    Vector3 U;
    Vector3 V;
    float ajustaAncho, ajustaAlto;
    class Punto2f {
        public float x, y;
        public Punto2f(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
    public ArcBall(float w, float h) {
        U = new Vector3();
        V = new Vector3();
        ajusta(w, h);
    }
    public void ajusta(float w, float h) {
        if (!((w > 1.0f) && (h > 1.0f)))
            System.out.println("ERROR");
        ajustaAncho = 2.0f / (w - 1.0f);
        ajustaAlto = 2.0f / (h - 1.0f);
    }
    public void obtieneVector(Vector3 vector, float x, float y) {
        Punto2f temp = new Punto2f(x, y);
        temp.x = (temp.x * ajustaAncho) - 1.0f;
        temp.y = 1.0f - (temp.y * ajustaAlto);
        float longitud2 = (temp.x * temp.x) + (temp.y * temp.y);
        if (longitud2 > 1.0f) {
            float norma = (float) (1.0 / Math.sqrt(longitud2));
            vector.x = temp.x * norma;
            vector.y = temp.y * norma;
            vector.z = 0.0f;
        } else { 
            vector.x = temp.x;
            vector.y = temp.y;
            vector.z = (float) Math.sqrt(1.0f - longitud2);
        }
    }
    public void primerPunto(float x, float y) {
        obtieneVector(U, x, y);
    }
    public Cuaternion segundoPunto(float x, float y) {
        Cuaternion q = new Cuaternion();
        obtieneVector(V, x, y);
        if (q != null) {
            Vector3 Normal = U.producto_vectorial(V);
            if (Normal.longitud() > Epsilon) { 
                q.x = Normal.x;
                q.y = Normal.y;
                q.z = Normal.z;
                q.w = U.producto_escalar(V);
            } else { 
                q.x = q.y = q.z = q.w = 0.0f;
            }
        }
        return q;
    }
}