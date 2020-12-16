using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pregunta3
{
    struct bdcolores
    {
        public int ciR, ciG, ciB;
     
        public bdcolores(int ciR, int ciG, int ciB)
        {
            this.ciR = ciR;
            this.ciG = ciG;
            this.ciB = ciB;

        }
        public String verificarda(int ciR, int ciG, int ciB)
        { 
            String tipo = " ";
            int[,] agua = { { 0, 14, 29 }, { 1, 20, 34 }, { 0, 19, 33 }, { 0, 53, 86 }, { 1, 75, 116 }, { 4, 72, 111 }, { 10, 68, 110 }, { 3, 96, 147 },{ 3, 59, 95 }, { 19, 77, 111 }, { 9, 50, 50 }, { 35, 52, 90 }, { 35, 60, 75 }, { 30, 50, 71 }, { 16, 41, 98 },{ 10, 30, 50 }, { 10, 30, 50 }, { 20, 50, 60 }, { 10, 40, 70 }, { 10, 45, 55 }, { 10, 39, 55 }, { 9, 55, 70 }, { 20, 70, 80 }, { 9, 34, 50 } };
            int[,] tierra = { { 118, 140, 162 },{ 134, 150, 165},{100, 133, 163 },{ 160, 140, 86 }, { 165, 147, 893 }, { 158, 136, 89 }, { 125, 113, 76 }, { 149, 117, 71 }, { 139, 122, 85 }, { 116, 99, 61 }, { 199, 173, 139 }, { 115, 110, 95 }, { 140, 130, 115 }, { 168, 157, 138 }, { 165, 170, 165 }, { 148, 128, 105 }, { 133, 130, 125 }, { 210, 195, 175 },  { 85, 85, 75 }, { 95, 90, 81 }, { 179, 147, 129 },  { 160, 145, 120 } };
            int[,] vegetacion = { { 28, 92, 134 }, { 11, 84, 134 }, { 104, 125, 37 },{ 58, 56, 44 }, { 48, 55, 53 }, { 50, 50, 43 }, { 63, 63, 47 }, { 56, 60, 63 }, { 35, 60, 50 }, { 15, 30, 30 }, { 34, 34, 40 }, { 40, 70, 58 }, { 30, 45, 40 }, { 9, 35, 35 }, { 85, 75, 58 }, { 50, 75, 65 }, { 35, 60, 35 }, { 30, 60, 35 }, { 36, 73, 41 }, { 58, 94, 58 } };

            for (int i = 0; i < agua.GetLength(0); i++)
                if (((agua[i, 0] - 10 < ciR) && (ciR < agua[i, 0] + 10)) && ((agua[i, 1] - 10 < ciG) && (ciG < agua[i, 1] + 10)) && ((agua[i, 2] - 10 < ciB) && (ciB < agua[i, 2] + 10)))
                {
                    tipo = "agua";

                }
            for (int j = 0; j < tierra.GetLength(0); j++)
                if (((tierra[j, 0] - 10 < ciR) && (ciR < tierra[j, 0] + 10)) && ((tierra[j, 1] - 10 < ciG) && (ciG < tierra[j, 1] + 10)) && ((tierra[j, 2] - 10 < ciB) && (ciB < tierra[j, 2] + 10)))
                {
                    tipo = "tierra";
                }
            for (int k = 0; k < vegetacion.GetLength(0); k++)
                if (((vegetacion[k, 0] - 10 < ciR) && (ciR < vegetacion[k, 0] + 10)) && ((vegetacion[k, 1] - 10 < ciG) && (ciG < vegetacion[k, 1] + 10)) && ((vegetacion[k, 2] - 10 < ciB) && (ciB < vegetacion[k, 2] + 10)))
                {
                    tipo = "vegetacion";
                }
          
            return tipo;
        }
    }
}
