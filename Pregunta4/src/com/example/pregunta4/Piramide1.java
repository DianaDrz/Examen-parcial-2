package com.example.pregunta4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Piramide1 {

	private float vertices[] = new float[] {

			-1, -1,  1,
			1, -1,  1, 
			0,  1,  0, 
			0,  1,  0, 

			0,  1, 0, 
			0,  1, 0, 
			1, -1, -1,
			-1, -1, -1, 

			-1, -1, -1, 
			-1, -1,  1, 
			0,  1,  0, 
			0,  1, 0, 

			1, -1, 1,
			1, -1, -1, 
			0,  1, 0, 
			0,  1,  0,

			-1, -1, -1, 
			1, -1, -1, 
			1, -1,  1, 
			-1, -1,  1, 
	};
	byte maxColor= (byte)255;
	private byte colores[] = new byte[] {
			// Frente-lila
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			(byte) 250, (byte) 249, (byte) 9, maxColor,
			
		
	}; 
	private short indices[] = new short[] {
			0,  1,  2,  0,  2,  3, 
			4,  5,  6,  4,  6,  7, 
			8,  9, 10,  8, 10, 11, 
			12, 13, 14, 12, 14, 15, 
			16, 17, 18, 16, 18, 19, 

	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;
	public Piramide1() {
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length* 4);
		bufByte.order(ByteOrder.nativeOrder()); 
		bufVertices= bufByte.asFloatBuffer(); 
		bufVertices.put(vertices);
		bufVertices.rewind(); 
		bufColores= ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); 
		bufByte = ByteBuffer.allocateDirect(indices.length* 2);
		bufByte.order(ByteOrder.nativeOrder()); 
		bufIndices= bufByte.asShortBuffer(); 
		bufIndices.put(indices);
		bufIndices.rewind(); 
	}
	public void dibuja(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}

}
