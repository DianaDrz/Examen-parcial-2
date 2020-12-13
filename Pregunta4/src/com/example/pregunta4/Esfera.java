package com.example.pregunta4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Esfera {

	int segmentosH; 
	int segmentosV; 
	private short indices[];
	private FloatBuffer bufVertices;
	private FloatBuffer bufNormales;
	private ShortBuffer bufIndices;

	public Esfera(float radio, int segmentosH, int segmentosV) {
		this.segmentosH = segmentosH;
		this.segmentosV = segmentosV;
		float[] vertices = new float[segmentosH * segmentosV * 4 * 3];
		float[] normales = new float[segmentosH * segmentosV * 4 * 3];
		indices = new short[segmentosH * segmentosV * 6]; 
		int i = 0;
		float inc_phi = 360f / segmentosH;
		for (float phi = 0; phi < 360; phi += inc_phi) {
			float sp = (float) Math.sin(Math.toRadians(phi));
			float cp = (float) Math.cos(Math.toRadians(phi));
			float sp1 = (float) Math.sin(Math.toRadians(phi + inc_phi));
			float cp1 = (float) Math.cos(Math.toRadians(phi + inc_phi));
			float inc_theta = 180f / segmentosV; 
			for (float theta = 0; theta < 180; theta += inc_theta) {
				float st = (float) Math.sin(Math.toRadians(theta));
				float ct = (float) Math.cos(Math.toRadians(theta));
				float st1 = (float) Math.sin(Math.toRadians(theta + inc_theta));
				float ct1 = (float) Math.cos(Math.toRadians(theta + inc_theta));
				vertices[i] = radio * st * sp;
				vertices[i + 1] = radio * ct;
				vertices[i + 2] = radio * st * cp;
				vertices[i + 3] = radio * st1 * sp;
				vertices[i + 4] = radio * ct1;
				vertices[i + 5] = radio * st1 * cp;
				vertices[i + 6] = radio * st1 * sp1;
				vertices[i + 7] = radio * ct1;
				vertices[i + 8] = radio * st1 * cp1;
				vertices[i + 9] = radio * st * sp1;
				vertices[i + 10] = radio * ct;
				vertices[i + 11] = radio * st * cp1;
				normales[i] = st * sp;
				normales[i + 1] = ct;
				normales[i + 2] = st * cp;
				normales[i + 3] = st1 * sp;
				normales[i + 4] = ct1;
				normales[i + 5] = st1 * cp;
				normales[i + 6] = st1 * sp1;
				normales[i + 7] = ct1;
				normales[i + 8] = st1 * cp1;
				normales[i + 9] = st * sp1;
				normales[i + 10] = ct;
				normales[i + 11] = st * cp1;
				i = i + 12;
			}
		}
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder());
		bufVertices = bufByte.asFloatBuffer();
		bufVertices.put(vertices).rewind();

		bufByte = ByteBuffer.allocateDirect(normales.length * 4);
		bufByte.order(ByteOrder.nativeOrder());
		bufNormales = bufByte.asFloatBuffer();
		bufNormales.put(normales).rewind();
		for (int k = 0, j = 0; k < segmentosH * segmentosV * 6; k += 6, j += 4) {
			indices[k] = (short) j;
			indices[k + 1] = (short) (j + 1);
			indices[k + 2] = (short) (j + 2);
			indices[k + 3] = (short) j;
			indices[k + 4] = (short) (j + 2);
			indices[k + 5] = (short) (j + 3);
		}

		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder());
		bufIndices = bufByte.asShortBuffer();
		bufIndices.put(indices).rewind();
	}

	public void dibuja(GL10 gl,float r,float v,float a,float d) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		gl.glNormalPointer(GL10.GL_FLOAT, 0, bufNormales);
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glColor4f(r, v, a, d);
	}
}