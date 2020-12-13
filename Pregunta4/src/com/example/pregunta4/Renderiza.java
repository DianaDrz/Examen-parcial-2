package com.example.pregunta4;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderiza extends GLSurfaceView implements GLSurfaceView.Renderer {
    private Cubo cubo;
    private Cubo1 cubo1;
    private Rectangulo1 rectangulo1;
    private Rectangulo2 rectangulo2;
    private Piramide piramide;
    private Piramide1 piramide1;
    Esfera esfera;


    private int ancho, alto;
    private ArcBall arcBall = new ArcBall(540.0f, 380.0f);
    private float[] MatrizRotacion = new float[16];
    private float[] B = new float[16];
    
    public Renderiza(Context contexto) {
        super(contexto);
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        cubo = new Cubo();
        cubo1= new Cubo1();
        rectangulo1 = new Rectangulo1();
        rectangulo2 = new Rectangulo2();
        piramide = new Piramide();
        piramide1 = new Piramide1();
        esfera = new Esfera(0.5f, 48, 48);        
        Matriz4.identidad(B);
        gl.glDisable(GL10.GL_DITHER);
        gl.glShadeModel(GL10.GL_FLAT);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glClearDepthf(1.0f);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glClearColor(0, 0, 0, 0);
        
        
    }

    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity(); 
       
        gl.glPushMatrix();
        gl.glMultMatrixf(MatrizRotacion, 0); 
        gl.glScalef(0.3f, 0.2f, 0.3f);
        gl.glTranslatef(0, -12, 0);
        gl.glTranslatef(0, 0.05f, 0);
        rectangulo2.dibuja(gl);
        gl.glTranslatef(0, 0.1f, 0);
        rectangulo1.dibuja(gl);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glScalef(0.2f, 0.2f, 0.2f);
        gl.glMultMatrixf(MatrizRotacion, 0);
        gl.glScalef(6f, 6f, 6f);
        gl.glTranslatef(0, 0f, 0);
        piramide.dibuja(gl);
        gl.glScalef(0.8f, 0.9f, 0.8f);
        gl.glTranslatef(0, 0.9f, 0);
        piramide.dibuja(gl);
        gl.glScalef(0.6f, 0.7f, 0.6f);
        gl.glTranslatef(0, 1.3f, 0);
        piramide.dibuja(gl);
        
        gl.glScalef(0.4f, 0.4f, 0.4f);
        gl.glTranslatef(0, 3.6f, 0);
        piramide1.dibuja(gl);
        gl.glScalef(1f, -1f, 1f);
        gl.glTranslatef(0, 0.6f, 0);
        piramide1.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
        gl.glMultMatrixf(MatrizRotacion, 0);
        gl.glScalef(0.5f, 0.6f, 0.5f);
        gl.glTranslatef(1, -4.2f, 1);
        cubo1.dibuja(gl);
        gl.glPopMatrix();
        
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(1.3f, 1.9f, 1);
		esfera.dibuja(gl,240/255f, 198/255f, 40/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(-1.3f, 1.3f, 1f);
		esfera.dibuja(gl,205/255f, 84/255f, 201/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(-1.3f, 1.9f, -1.3f);
		esfera.dibuja(gl,54/255f, 184/255f, 199/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(1.3f, 1.3f, -1.3f);
		esfera.dibuja(gl,30/255f, 195/255f, 120/255f,0);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(1.6f, -0.9f, 1.6f);
		esfera.dibuja(gl,93/255f, 93/255f, 205/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(-1.6f, -0.9f, -1.6f);
		esfera.dibuja(gl,29/255f, 202/255f, 223/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(-2.2f, -2.3f, 2.2f);
		esfera.dibuja(gl,237/255f, 235/255f, 115/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glMultMatrixf(MatrizRotacion, 0);
		gl.glTranslatef(2.2f, -2.3f, -2.2f);
		esfera.dibuja(gl,229/255f, 62/255f, 12/255f,0);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
        gl.glMultMatrixf(MatrizRotacion, 0); 
        gl.glScalef(0.4f,1.5f, 0.4f);
        gl.glTranslatef(0, -1.7f, 0);
        cubo.dibuja(gl);
        gl.glPopMatrix();
        gl.glFlush();
    }



    public void onSurfaceChanged(GL10 gl, int w, int h) {
        ancho = w;
        alto = h;
        gl.glViewport(0, 0, ancho, alto);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        if (w <= h)
            gl.glOrthof(-2, 2, -2 * (float) h / (float) w, 2 * (float) h / (float) w, -10, 10);
        else
            gl.glOrthof(-2 * (float) w / (float) h, 2 * (float) w / (float) h, -2, 2, -10, 10);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        Matriz4.identidad(MatrizRotacion);
        arcBall.ajusta(ancho, alto);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /* B = MatrizRotacion */
                Matriz4.copia(B, MatrizRotacion);
                arcBall.primerPunto(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                Cuaternion q = arcBall.segundoPunto(x, y);
                Cuaternion.rota(MatrizRotacion, q);
                Matriz4.multiplica(MatrizRotacion, MatrizRotacion, B);
                requestRender();
        }
        return true;
    }
}