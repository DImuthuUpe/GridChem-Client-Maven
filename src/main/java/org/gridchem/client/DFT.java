package org.gridchem.client;
/*Copyright (c) 2004,University of Illinois at Urbana-Champaign.  All rights reserved.

Developed by:
Chemistry and Computational Biology Group

NCSA, University of Illinois at Urbana-Champaign

http://ncsa.uiuc.edu/GridChem

Permission is hereby granted, free of charge, to any person 
obtaining a copy of this software and associated documentation
files (the "Software") to deal with the Software without
restriction, including without limitation the rights to use, 
copy, modify, merge, publish, distribute, sublicense, and/or 
sell copies of the Software, and to permit persons to whom 
the Software is furnished to do so, subject to the following 
conditions:
1. Redistributions of source code must retain the above copyright notice, 
   this list of conditions and the following disclaimers.
2. Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimers in the documentation
   and/or other materials provided with the distribution.
3. Neither the names of Chemistry and Computational Biology Group , NCSA, 
   University of Illinois at Urbana-Champaign, nor the names of its contributors 
   may be used to endorse or promote products derived from this Software without 
   specific prior written permission.
    
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  
IN NO EVENT SHALL THE CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
DEALINGS WITH THE SOFTWARE.

*/


/* The following code was generated by JFlex 1.4.1 on 1/26/05 10:10 PM */

/* Density Functional Methods (DFT) Keywords
   Last Update: 6/26/2001 
   http://www.gaussian.com/00000432.htm
*/


import org.gridchem.client.*;
import org.gridchem.client.common.Settings;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 1/26/05 10:10 PM from the specification file
 * <tt>D:/CCG/CCG_CUP_FLEX/dft.flex</tt>
 */
public class DFT {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int AU = 5;
  public static final int IGNOREALL = 6;
  public static final int FLOATVAL = 1;
  public static final int NNNN = 4;
  public static final int YYINITIAL = 0;
  public static final int INTVAL = 2;
  public static final int MMMM = 3;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    39,  0,  0,  0,  0,  0,  0,  0,  8,  0,  0,  3,  0,  3,  4,  1, 
     2,  9,  2, 29, 32, 26, 22, 34, 28, 19,  0,  0,  0, 33,  0,  0, 
     0, 14, 17, 36, 25,  5, 11, 21, 10, 30,  0,  0, 15, 20, 24, 31, 
    16, 37, 35, 12,  7, 38, 23, 18, 13, 27,  0,  0,  0,  0,  0,  0, 
     0, 14, 17, 36, 25,  5, 11, 21, 10, 30,  0,  0, 15, 20, 24, 31, 
    16, 37, 35, 12,  7, 38, 23, 18, 13, 27,  0,  0,  6,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\4\1\1\2\3\1\1\2\6\1\1\3\1\1"+
    "\1\4\1\1\1\5\2\1\1\0\1\6\3\0\1\2"+
    "\2\0\1\2\13\0\1\7\14\0\3\2\4\0\1\6"+
    "\12\0\1\7\17\0\1\2\22\0\1\10\1\0\1\11"+
    "\3\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\170\0\240\0\310\0\360\0\u0118"+
    "\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208\0\u0230\0\u0258"+
    "\0\u0280\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\u0348\0\u0370\0\u0370"+
    "\0\u0398\0\u0398\0\u03c0\0\u03c0\0\u03e8\0\u0140\0\u0410\0\u0438"+
    "\0\u0460\0\u0488\0\u04b0\0\u04d8\0\u0500\0\u0118\0\u0528\0\u0550"+
    "\0\u0578\0\u05a0\0\u05c8\0\u05f0\0\u0618\0\u0640\0\u0668\0\u0690"+
    "\0\u0320\0\u06b8\0\u06e0\0\u0708\0\u0730\0\u0758\0\u0780\0\u07a8"+
    "\0\u07d0\0\u07f8\0\u0820\0\u0848\0\u0870\0\u0898\0\u08c0\0\u08e8"+
    "\0\u0910\0\u0938\0\u0960\0\u0988\0\u09b0\0\u09d8\0\u09d8\0\u0a00"+
    "\0\u0a28\0\u0a50\0\u0a78\0\u0aa0\0\u0ac8\0\u0af0\0\u0b18\0\u0b40"+
    "\0\u0b68\0\u0b68\0\u0b90\0\u0bb8\0\u0be0\0\u0c08\0\u0c30\0\u0c58"+
    "\0\u0c80\0\u0ca8\0\u0cd0\0\u0cf8\0\u0d20\0\u0d48\0\u0d70\0\u0d98"+
    "\0\u0ac8\0\u0dc0\0\u0de8\0\u0e10\0\u0e38\0\u0e60\0\u0e88\0\u0eb0"+
    "\0\u0ed8\0\u0f00\0\u0f28\0\u0f50\0\u0f78\0\u0fa0\0\u0fc8\0\u0ff0"+
    "\0\u1018\0\u1040\0\u1068\0\u0118\0\u1090\0\u0118\0\u10b8\0\u10e0"+
    "\0\u1108";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\10\1\11\1\12\2\10\1\12\2\10\1\11\1\13"+
    "\1\10\1\14\1\15\1\10\1\16\1\17\1\20\1\10"+
    "\1\11\1\21\1\22\1\11\1\23\2\10\1\11\1\10"+
    "\2\11\1\24\1\10\1\11\1\10\1\11\7\10\1\25"+
    "\1\26\2\10\1\26\2\10\1\25\11\10\1\25\2\10"+
    "\1\25\3\10\1\25\1\10\2\25\2\10\1\25\1\10"+
    "\1\25\7\10\1\27\1\30\2\10\1\30\2\10\1\27"+
    "\11\10\1\27\2\10\1\27\3\10\1\27\1\10\2\27"+
    "\2\10\1\27\1\10\1\27\7\10\1\31\1\32\2\10"+
    "\1\32\2\10\1\31\11\10\1\31\2\10\1\31\3\10"+
    "\1\31\1\10\2\31\2\10\1\31\1\10\1\31\7\10"+
    "\1\33\1\34\2\10\1\34\2\10\1\33\11\10\1\33"+
    "\2\10\1\33\3\10\1\33\1\10\2\33\2\10\1\33"+
    "\1\10\1\33\23\10\1\35\101\10\52\0\1\36\1\0"+
    "\1\37\4\0\1\36\11\0\1\36\2\0\1\36\3\0"+
    "\1\36\1\0\2\36\2\0\1\36\1\0\1\36\7\0"+
    "\1\36\6\0\1\36\11\0\1\36\2\0\1\36\3\0"+
    "\1\36\1\0\2\36\2\0\1\36\1\0\1\36\20\0"+
    "\1\40\43\0\1\41\34\0\1\42\21\0\1\43\45\0"+
    "\1\44\16\0\1\45\33\0\1\46\2\0\1\47\11\0"+
    "\1\50\24\0\1\51\1\52\10\0\1\50\11\0\1\53"+
    "\32\0\1\54\52\0\1\55\46\0\1\56\55\0\1\57"+
    "\6\0\1\60\12\0\1\61\1\0\1\62\4\0\1\61"+
    "\11\0\1\61\2\0\1\61\3\0\1\61\1\0\2\61"+
    "\2\0\1\61\1\0\1\61\7\0\1\61\6\0\1\61"+
    "\11\0\1\61\2\0\1\61\3\0\1\61\1\0\2\61"+
    "\2\0\1\61\1\0\1\61\7\0\1\27\6\0\1\27"+
    "\11\0\1\27\2\0\1\27\3\0\1\27\1\0\2\27"+
    "\2\0\1\27\1\0\1\27\7\0\1\31\6\0\1\31"+
    "\11\0\1\31\2\0\1\31\3\0\1\31\1\0\2\31"+
    "\2\0\1\31\1\0\1\31\7\0\1\33\6\0\1\33"+
    "\11\0\1\33\2\0\1\33\3\0\1\33\1\0\2\33"+
    "\2\0\1\33\1\0\1\33\11\0\1\63\45\0\1\37"+
    "\2\0\2\64\2\0\1\37\11\0\1\37\2\0\1\37"+
    "\2\0\1\64\1\37\1\0\2\37\2\0\1\37\1\0"+
    "\1\37\21\0\1\46\4\0\1\46\44\0\1\65\44\0"+
    "\1\66\53\0\1\67\61\0\1\70\36\0\1\46\52\0"+
    "\1\71\52\0\1\46\40\0\1\72\1\0\1\73\44\0"+
    "\1\74\50\0\1\75\1\76\51\0\1\77\53\0\1\100"+
    "\51\0\1\101\26\0\1\102\60\0\1\103\31\0\1\62"+
    "\2\0\2\104\2\0\1\62\11\0\1\62\2\0\1\62"+
    "\2\0\1\104\1\62\1\0\2\62\2\0\1\62\1\0"+
    "\1\62\53\0\1\105\3\0\1\106\1\107\2\0\1\107"+
    "\2\0\1\106\11\0\1\106\2\0\1\106\3\0\1\106"+
    "\1\0\2\106\2\0\1\106\1\0\1\106\26\0\1\110"+
    "\67\0\1\111\26\0\1\112\45\0\1\46\42\0\1\46"+
    "\50\0\1\75\60\0\1\50\54\0\1\113\52\0\1\45"+
    "\36\0\1\47\11\0\1\50\24\0\1\114\47\0\1\115"+
    "\70\0\1\46\25\0\1\116\30\0\1\117\16\0\1\120"+
    "\41\0\1\121\1\122\2\0\1\122\2\0\1\121\11\0"+
    "\1\121\2\0\1\121\3\0\1\121\1\0\2\121\2\0"+
    "\1\121\1\0\1\121\11\0\1\123\45\0\1\106\6\0"+
    "\1\106\11\0\1\106\2\0\1\106\3\0\1\106\1\0"+
    "\2\106\2\0\1\106\1\0\1\106\24\0\1\124\37\0"+
    "\1\125\17\0\1\126\15\0\1\127\14\0\1\70\66\0"+
    "\1\130\36\0\1\131\46\0\1\75\55\0\1\132\35\0"+
    "\1\133\66\0\1\134\17\0\1\121\6\0\1\121\11\0"+
    "\1\121\2\0\1\121\3\0\1\121\1\0\2\121\2\0"+
    "\1\121\1\0\1\121\54\0\1\135\5\0\1\136\100\0"+
    "\1\137\25\0\1\140\77\0\1\46\15\0\1\141\57\0"+
    "\1\47\70\0\1\142\42\0\1\143\12\0\1\144\64\0"+
    "\1\145\72\0\1\146\33\0\1\147\34\0\1\150\73\0"+
    "\1\151\41\0\1\152\57\0\1\153\22\0\1\154\73\0"+
    "\1\155\22\0\1\156\73\0\1\157\42\0\1\160\23\0"+
    "\1\161\70\0\1\162\3\0\1\162\7\0\1\162\14\0"+
    "\1\163\60\0\1\156\36\0\1\46\53\0\1\156\75\0"+
    "\1\164\33\0\1\165\63\0\1\166\13\0\1\167\105\0"+
    "\1\170\47\0\1\46\42\0\1\171\42\0\1\46\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4400];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\7\0\1\11\25\1\1\0\1\1\3\0\1\1\2\0"+
    "\1\11\13\0\1\1\14\0\3\1\4\0\1\1\12\0"+
    "\1\1\17\0\1\1\22\0\1\11\1\0\1\11\3\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
  public static boolean DEBUG = false;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public DFT(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public DFT(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { if (Settings.DEBUG) System.out.println(yytext());
          }
        case 10: break;
        case 7: 
          { if (Settings.DEBUG) System.out.println(yytext());
	   yybegin(YYINITIAL);
          }
        case 11: break;
        case 8: 
          { if (Settings.DEBUG) System.out.println(yytext());
	    yybegin(INTVAL);
          }
        case 12: break;
        case 6: 
          { if (Settings.DEBUG) System.out.println(yytext());
	   yybegin(AU);
          }
        case 13: break;
        case 9: 
          { yybegin(MMMM); 
	       if (Settings.DEBUG) System.out.println(yytext());
          }
        case 14: break;
        case 3: 
          { if (Settings.DEBUG) System.out.println(yytext());
	 yybegin(YYINITIAL);
          }
        case 15: break;
        case 5: 
          { yybegin(YYINITIAL);
	 if (Settings.DEBUG) System.out.println(yytext());
          }
        case 16: break;
        case 4: 
          { yybegin(NNNN);
	 if (Settings.DEBUG) System.out.println(yytext());
          }
        case 17: break;
        case 1: 
          { 
          }
        case 18: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java DFT <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        DFT scanner = null;
        try {
          scanner = new DFT( new java.io.FileReader(argv[i]) );
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
