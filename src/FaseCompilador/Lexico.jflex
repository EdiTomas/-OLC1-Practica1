package FaseCompilador;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

%%

//--------------------------------Codigo Java-------------------------------------------------------------

%{
    // codigo java
    String texto = "";
    public PintarPalabras pintar = new PintarPalabras();
    public static ArrayList<ErrorLexico> listaError = new ArrayList();
  
%}


//------>   Directivas
%cupsym sym
%class Lexico
%state    COMENTARIO   COMEMTARIOMULTILINEAL STRING 
%cup
%public
%line
%column
%char
%full
%8bit
%unicode
%ignorecase




//--------------------Expresiones regulares Numeros---------------------------------------
       letra = [a-zA-ZñÑ]+      
       entero = [0-9]+
       decimal =[0-9]+ "." [0-9]*
       ID = {letra}({letra} |"_"| {entero})*
       space = [\t|\f|" "|\r|\n]
       enter = [\ \n]  

%%

<YYINITIAL> {


//------------------------------------------------------------------------------------------------
    "Archivo"                 { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.archivo ,yyline, yycolumn,yytext());
                              }
//------------------------------------------------------------------------------------------------

    "leerArchivo"             { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.leerarchivo ,yyline, yycolumn,yytext());
                              }
//------------------------------------------------------------------------------------------------


    "Numerico"                 { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.numero ,yyline, yycolumn,yytext());
                               }
//------------------------------------------------------------------------------------------------
    "Sumar"                    { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.suma ,yyline, yycolumn,yytext());
                               }
//------------------------------------------------------------------------------------------------
    "Contar"                   { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.contar ,yyline, yycolumn,yytext());
                               }

//------------------------------------------------------------------------------------------------
    "Promedio"                 { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.promedio ,yyline, yycolumn,yytext());
                               }

//------------------------------------------------------------------------------------------------
    "ContarSi"                 { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.contarsi ,yyline, yycolumn,yytext());
                               }

//------------------------------------------------------------------------------------------------
    "Cadena"                   { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.cadena ,yyline, yycolumn,yytext());
                               }

//------------------------------------------------------------------------------------------------
    "ObtenerSi"                { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.obtenersi ,yyline, yycolumn,yytext());
                               }
//------------------------------------------------------------------------------------------------
    "Imprimir"                 { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.imprimir ,yyline, yycolumn,yytext());
                               }

//------------------------------------------------------------------------------------------------
    "Graficar"                 { 
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.graficar ,yyline, yycolumn,yytext());
                               }

//----------------------------------------------------------------------------------------------------------------------------
    "("                       { 
                                return new Symbol(sym.pa_open ,yyline, yycolumn,yytext());
                              } 
//----------------------------------------------------------------------------------------------------------------------------
    ")"                       { 
                                return new Symbol(sym.pa_close ,yyline, yycolumn,yytext());
                              }

//----------------------------------------------------------------------------------------------------------------------------
    ","                       { 
                                return new Symbol(sym.coma ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    ";"                       {
                                 return new Symbol(sym.puntoycoma ,yyline, yycolumn,yytext());
                              }

//----------------------------------------------------------------------------------------------------------------------------
    "+"                       {  
                                 return new Symbol(sym.mas ,yyline, yycolumn,yytext());
                              } 
//----------------------------------------------------------------------------------------------------------------------------
    "-"                       {  
                                 return new Symbol(sym.menos ,yyline, yycolumn,yytext());
                              }

//----------------------------------------------------------------------------------------------------------------------------
    "<"                      { 
                                 pintar.pintarAzul(yychar,yylength()); 
                                 return new Symbol(sym.menor ,yyline, yycolumn,yytext());
                             }
//----------------------------------------------------------------------------------------------------------------------------   
    ">"                      {     
                                 pintar.pintarAzul(yychar,yylength());
                                 return new Symbol(sym.mayor ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------   
    "=="                      {  
                                 return new Symbol(sym.equals ,yyline, yycolumn,yytext());
                              } 
 
//----------------------------------------------------------------------------------------------------------------------------
    "="                       { 
                                 return new Symbol(sym.eqa ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    "!="                      {
                                 return new Symbol(sym.diferente ,yyline, yycolumn,yytext());
                              } 
//----------------------------------------------------------------------------------------------------------------------------
    "<="                      { 
                                 return new Symbol(sym.menorigual ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    ">="                      {  
                                 return new Symbol(sym.mayorigual ,yyline, yycolumn,yytext());
                              }
// ------------ RETORNAR EXPRESIONES REGULARES-------------------------------------------
 
 {ID}      {    
                return new Symbol(sym.id ,yyline, yycolumn,yytext());
           }
//--------------------------------------------------------------------------------------------------------------------------- 
{entero}   {   
                 return new Symbol(sym.entero ,yyline, yycolumn,yytext());  
           }

//---------------------------------------------------------------------------------------------------------------------------
 {decimal} {    
                   return new Symbol(sym.decimal ,yyline, yycolumn,yytext()); 
           }

//--------------------------------------INICIALIZAN LOS ESTADOS-------------------------------------------------------------------------------------

 "//"  {yybegin(COMENTARIO);}
\"  {  yybegin(STRING);    
      pintar.pintarVerde(yychar,yylength());
     }  
"/*" {yybegin(COMEMTARIOMULTILINEAL);}
 
   
//--------------------------------------SE IGNORAN LOS ESPACIOS-------------------------------------------------------------------------------------

 {space} {/*Se ignora*/}
 {enter} {/*Se ignora*/}

 //-----------------------------------CUALQUIER OTRO ERROR---------------------------------------------------------------
/* Cualquier otro error siempre se separa el punto con la llave para que no de error de compilacion. */

.

{
    ErrorLexico e = new ErrorLexico("Error lexico",yytext(),yyline, yycolumn,"El caracter no pertenece al lenguaje");
     listaError.add(e);
     System.err.println("Error lexicografico: "+yytext()+ " Linea:"+(yyline+1)+" Columna:"+(yycolumn+1));
}


}// fin del YYINITIAL


//-------------------------------ESTADOS--------------------------------------------------------
<COMENTARIO>{
[\n]  {  yybegin(YYINITIAL);}
[^\n] {  /*Se ignora */}
}

<COMEMTARIOMULTILINEAL>
{
    "*"+"/"      {yybegin(YYINITIAL);}
    [^*\n]*      { /*Se ignora*/ }
    "*"+[^*/\n]* {/*Se ignora*/ }
    [\n]         {/*Se ignora*/ }  
}


<STRING>{
 [\"]  {  
            pintar.pintarVerde(yychar,yylength());
            String temporal=texto; 
            texto =""; 
            yybegin(YYINITIAL);
              return new Symbol(sym.texto,yyline, yycolumn,temporal);           }
 [^\"]  {     
            texto+=yytext();
            pintar.pintarVerde(yychar,yylength());
               
        }
}





