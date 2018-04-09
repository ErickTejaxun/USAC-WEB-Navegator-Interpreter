
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace java
{
    class Program
    {
        static void Main(string[] args)
        {

            Process process = new Process();
            String direccion = "C:\\ProgramData\\Oracle\\Java\\javapath\\java1";
            String argumentos = "";
            int contador = 0;
            foreach(String arg in args)
            {
                //Console.WriteLine("Argumento " + arg);
                if (contador == 1)
                {
                    if (arg.Equals("USAC-WEB.jar"))
                    {
                        //Console.WriteLine("es igual");
                        argumentos = argumentos + " " + "C:\\Users\\USAC-WEB.jar";
                    }
                    else 
                    {
                        //Console.WriteLine("No es igual");
                        argumentos = argumentos + " " + arg;
                    }
                }
                else 
                {
                    argumentos = argumentos + " " + arg;
                }
                contador++;
            }
            process.StartInfo.FileName = direccion;   
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.RedirectStandardOutput = true;
            process.StartInfo.Arguments = argumentos;
                
            process.Start();

            // Synchronously read the standard output of the spawned process. 
            StreamReader reader = process.StandardOutput;
            string output = reader.ReadToEnd();

            // Write the redirected output to this application's window.
            Console.WriteLine(output);

            process.WaitForExit();
            process.Close();
                                

        }
    }
}
