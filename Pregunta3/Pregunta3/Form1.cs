using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;



namespace Pregunta3
{
    public partial class Form1 : Form
    {
        Bitmap bmp;
        int cR, cG, cB;
        public Form1()
        {
            InitializeComponent();
        }

        private void Button1_Click_1(object sender, EventArgs e)
        {
            // Carga una imagen y la muestra desde un PictureBox
            openFileDialog1.Filter = "Archivos JPG |*.jpg|Archivos BMP|*.bmp|Todos los archivos|*.*";
            openFileDialog1.ShowDialog();
            bmp = new Bitmap(openFileDialog1.FileName);
            pictureBox1.Image = bmp;
        }

        private void Button2_Click_1(object sender, EventArgs e)
        {
            Bitmap bmp1 = new Bitmap(pictureBox1.Image);
            Bitmap bmp2 = new Bitmap(bmp.Width, bmp.Height);
            Color c = new Color();
            int ciR, ciG, ciB;
            for (int i = 0; i < bmp.Width - 5; i = i + 5)
            {
                for (int j = 0; j < bmp.Height - 5; j = j + 5)
                {
                    ciR = 0;
                    ciG = 0;
                    ciB = 0;
                    for (int im = i; im < i + 5; im++)
                    {
                        for (int jm = j; jm < j + 5; jm++)
                        {
                            c = bmp1.GetPixel(i, j);
                            ciR = ciR + c.R;
                            ciG = ciG + c.G;
                            ciB = ciB + c.B;
                        }
                    }

                    ciR = ciR / 25;
                    ciG = ciG / 25;
                    ciB = ciB / 25;

                    if ((ciR >= 1 && ciR <= 71) && (ciG >= 24 && ciG <= 134) && (ciB >= 34 && ciB <= 141))
                    {
                        for (int x = i; x < i + 5; x++)
                        {
                            for (int y = j; y < j + 5; y++)
                            {
                                bmp2.SetPixel(x, y, Color.FromArgb(018, 141, 033));
                            }
                        }
                    }
                    else
                    {
                        for (int x = i; x < i + 5; x++)
                        {
                            for (int y = j; y < j + 5; y++)
                            {
                                c = bmp1.GetPixel(x, y);
                                bmp2.SetPixel(x, y, Color.FromArgb(c.R, c.G, c.B));
                            }
                        }
                    }
                    pictureBox1.Image = bmp2;
                }
            }
            
        }

        private void Button3_Click_1(object sender, EventArgs e)
        {
           
        }

        private void Button4_Click_1(object sender, EventArgs e)
        {
            
        }
    }
}

