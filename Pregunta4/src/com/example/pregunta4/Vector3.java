package com.example.pregunta4;

class Vector3 {
    float x, y, z;
    
    public Vector3() {
        x = y = z = 0;
    }
   
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
    
    public Vector3 mas(Vector3 v2) {
        return (new Vector3(this.x + v2.x, this.y + v2.y, this.z + v2.z));
    }

    
    public Vector3 menos(Vector3 v2) {
        return (new Vector3(this.x - v2.x, this.y - v2.y, this.z - v2.z));
    }
  
    public Vector3 producto_vectorial(Vector3 v2) {
        Vector3 r = new Vector3();
        r.x = (this.y * v2.z) - (this.z * v2.y);
        r.y = (this.z * v2.x) - (this.x * v2.z);
        r.z = (this.x * v2.y) - (this.y * v2.x);
        return r;
    }
    
    public float producto_escalar(Vector3 v2) {
        return (this.x * v2.x) + (this.y * v2.y) + (this.z * v2.z);
    }
   
    public float longitud() {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

 
    public void normaliza() {
        float longitud = longitud();
        if (longitud > 0 ) {
            x = x / longitud;
            y = y / longitud;
            z = z / longitud;
        }
    }
  
    public static Vector3 normal(Vector3 v1, Vector3 v2, Vector3 v3) {
        Vector3 u = new Vector3(); 
        Vector3 v = new Vector3(); 
        Vector3 n = new Vector3(); 
        u = v2.menos(v1);
        v = v3.menos(v1);
        n = u.producto_vectorial(v);
        n.normaliza();
        return n;
    }
    @Override
    public String toString() {
        return "Vector3 [x=" + x + ", y=" + y + ", z=" + z + "]";
    }
}