package FaseCompilador2;
import FaseCompilador.ErrorLexico;
import static FaseCompilador.Lexico.listaError;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

%%
//--------------------------------Codigo Java-------------------------------------------------------------
%{
    // codigo java
    String txt = "";
%}
//------>   Directivas
%cupsym  sym
%class scanner
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
      // letra = [a-zA-ZñÑ]+      
       entero = [0-9]+
       decimal =[0-9]+ "." [0-9]*
      // ID = {letra}({letra} |"_"| {entero})*
       space = [\t|\f|" "|\r|\n]
       enter = [\ \n]  

%%

<YYINITIAL> {
//------------------------------PALABRAS RESERVADAS----------------------------------------------------
  

    "Claves"                  { 
                                 return new Symbol(sym.clave ,yyline, yycolumn,yytext());
                              }
//------------------------------------------------------------------------------------------------
    "Registros"               { 
                                 return new Symbol(sym.registro ,yyline, yycolumn,yytext());
                              }

//----------------------------------------------------------------------------------------------------------------------------
    "{"                       {
                                return new Symbol(sym.llaveabierta ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    "}"                       { 
                                return new Symbol(sym.llavecerrada ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    "["                       { 
                                return new Symbol(sym.CorcheteAbierto ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    "]"                       { 
                                return new Symbol(sym.CorcheteCerrado ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    ","                       { 
                                return new Symbol(sym.coma ,yyline, yycolumn,yytext());
                              }
//----------------------------------------------------------------------------------------------------------------------------
    "="                       { 
                                 return new Symbol(sym.eqa ,yyline, yycolumn,yytext());
                              }

//----------------------------------------------------------------------------------------------------------------------------
    "+"                       {  
                                 return new Symbol(sym.mas ,yyline, yycolumn,yytext());
                              } 
//----------------------------------------------------------------------------------------------------------------------------
    "-"                       {  
                                 return new Symbol(sym.menos ,yyline, yycolumn,yytext());
                              }
// ------------ RETORNAR EXPRESIONES REGULARES-------------------------------------------
 

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
\"  {yybegin(STRING);}  
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
     System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+" Columna:"+(yycolumn+1));
}


} // fin del YYINITIAL


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
            String temporal=txt; 
            txt =""; 
            yybegin(YYINITIAL);
              return new Symbol(sym.txt,yyline, yycolumn,temporal);           }
 [^\"]  {     
            txt+=yytext();
               
        }
}

