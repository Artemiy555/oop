package Lab3Voloh.src.main.java.lexer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Main {
    static List<String> keywords = Arrays.asList(

            "auto", "if", "unsigned", "break", "inline", "void", "case", "int", "volatile", "char", "long", "while",
            "const", "register", "_Alignas", "continue", "restrict", "_Alignof", "default", "return", "_Atomic", "do",
            "short", "_Bool", "double", "signed", "_Complex", "else", "sizeof", "_Generic", "enum", "static",
            "_Imaginary", "extern", "struct", "_Noreturn", "float", "switch", "_Static_assert", "for", "typedef",
            "_Thread_local", "goto", "union","float");

    private static final String INPUT = "*\n" +
            "   GRAPHICS DEMO FOR Borland C++ 3.0\n" +
            "   Copyright (c) 1987,88,91 Borland International. All rights reserved.\n" +
            "   From the command line, use:\n" +
            "\t\tbcc bgidemo graphics.lib\n" +
            "*/\n" +
            "\n" +
            "#ifdef __TINY__\n" +
            "#error BGIDEMO will not run in the tiny model.\n" +
            "#endif\n" +
            "\n" +
            "#include <dos.h>\n" +
            "#include <math.h>\n" +
            "#include <conio.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "#include <stdarg.h>\n" +
            "\n" +
            "#include <graphics.h>\n" +
            "\n" +
            "#define ESC\t0x1b\t\t\t/* Define the escape key\t*/\n" +
            "#define TRUE\t1\t\t\t/* Define some handy constants\t*/\n" +
            "#define FALSE\t0\t\t\t/* Define some handy constants\t*/\n" +
            "#define PI\t3.14159 \t\t/* Define a value for PI\t*/\n" +
            "#define ON\t1\t\t\t/* Define some handy constants\t*/\n" +
            "#define OFF\t0\t\t\t/* Define some handy constants\t*/\n" +
            "\n" +
            "#define NFONTS 11\n" +
            "\n" +
            "char *Fonts[NFONTS] = {\n" +
            "  \"DefaultFont\",   \"TriplexFont\",   \"SmallFont\",\n" +
            "  \"SansSerifFont\", \"GothicFont\", \"ScriptFont\", \"SimplexFont\", \"TriplexScriptFont\",\n" +
            "  \"ComplexFont\", \"EuropeanFont\", \"BoldFont\"\n" +
            "};\n" +
            "\n" +
            "char *LineStyles[] = {\n" +
            "  \"SolidLn\",  \"DottedLn\",  \"CenterLn\",  \"DashedLn\",  \"UserBitLn\"\n" +
            "};\n" +
            "\n" +
            "char *FillStyles[] = {\n" +
            "  \"EmptyFill\",  \"SolidFill\",      \"LineFill\",      \"LtSlashFill\",\n" +
            "  \"SlashFill\",  \"BkSlashFill\",    \"LtBkSlashFill\", \"HatchFill\",\n" +
            "  \"XHatchFill\", \"InterleaveFill\", \"WideDotFill\",   \"CloseDotFill\"\n" +
            "};\n" +
            "\n" +
            "char *TextDirect[] = {\n" +
            "  \"HorizDir\",  \"VertDir\"\n" +
            "};\n" +
            "\n" +
            "char *HorizJust[] = {\n" +
            "  \"LeftText\",   \"CenterText\",   \"RightText\"\n" +
            "};\n" +
            "\n" +
            "char *VertJust[] = {\n" +
            "  \"BottomText\",  \"CenterText\",  \"TopText\"\n" +
            "};\n" +
            "\n" +
            "struct PTS {\n" +
            "  int x, y;\n" +
            "};\t/* Structure to hold vertex points\t*/\n" +
            "\n" +
            "int    GraphDriver;\t\t/* The Graphics device driver\t\t*/\n" +
            "int    GraphMode;\t\t/* The Graphics mode value\t\t*/\n" +
            "double AspectRatio;\t\t/* Aspect ratio of a pixel on the screen*/\n" +
            "int    MaxX, MaxY;\t\t/* The maximum resolution of the screen */\n" +
            "int    MaxColors;\t\t/* The maximum # of colors available\t*/\n" +
            "int    ErrorCode;\t\t/* Reports any graphics errors\t\t*/\n" +
            "struct palettetype palette;\t\t/* Used to read palette info\t*/\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tФункции prototypes\t\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void Initialize(void);\n" +
            "void ReportStatus(void);\n" +
            "void TextDump(void);\n" +
            "void Bar3DDemo(void);\n" +
            "void RandomBars(void);\n" +
            "void TextDemo(void);\n" +
            "void ColorDemo(void);\n" +
            "void ArcDemo(void);\n" +
            "void CircleDemo(void);\n" +
            "void PieDemo(void);\n" +
            "void BarDemo(void);\n" +
            "void LineRelDemo(void);\n" +
            "void PutPixelDemo(void);\n" +
            "void PutImageDemo(void);\n" +
            "void LineToDemo(void);\n" +
            "void LineStyleDemo(void);\n" +
            "void CRTModeDemo(void);\n" +
            "void UserLineStyleDemo(void);\n" +
            "void FillStyleDemo(void);\n" +
            "void FillPatternDemo(void);\n" +
            "void PaletteDemo(void);\n" +
            "void PolyDemo(void);\n" +
            "void SayGoodbye(void);\n" +
            "void Pause(void);\n" +
            "void MainWindow(char *header);\n" +
            "void StatusLine(char *msg);\n" +
            "void DrawBorder(void);\n" +
            "void changetextstyle(int font, int direction, int charsize);\n" +
            "int  gprintf(int *xloc, int *yloc, char *fmt, ... );\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tBegin Text function\t\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "int Text()\n" +
            "{\n" +
            "\n" +
            "  Initialize(); \t\t/* Set system into Graphics mode\t*/\n" +
            "  ReportStatus();\t\t/* Report results of the initialization */\n" +
            "\n" +
            "  ColorDemo();\t\t\t/* Begin actual demonstration\t\t*/\n" +
            "  if( GraphDriver==EGA || GraphDriver==EGALO || GraphDriver==VGA )\n" +
            "    PaletteDemo();\n" +
            "  PutPixelDemo();\n" +
            "  PutImageDemo();\n" +
            "  Bar3DDemo();\n" +
            "  BarDemo();\n" +
            "  RandomBars();\n" +
            "  ArcDemo();\n" +
            "  CircleDemo();\n" +
            "  PieDemo();\n" +
            "  LineRelDemo();\n" +
            "  LineToDemo();\n" +
            "  LineStyleDemo();\n" +
            "  UserLineStyleDemo();\n" +
            "  TextDump();\n" +
            "  TextDemo();\n" +
            "  CRTModeDemo();\n" +
            "  FillStyleDemo();\n" +
            "  FillPatternDemo();\n" +
            "  PolyDemo();\n" +
            "  SayGoodbye(); \t\t/* Give user the closing screen \t*/\n" +
            "\n" +
            "  closegraph(); \t\t/* Return the system to text mode\t*/\n" +
            "  return(0);\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tINITIALIZE: Initializes the graphics system and reports \t*/\n" +
            "/*\tany errors which occured.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void Initialize(void)\n" +
            "{\n" +
            "  int xasp, yasp;\t\t\t/* Used to read the aspect ratio*/\n" +
            "\n" +
            "  GraphDriver = DETECT; \t\t/* Request auto-detection\t*/\n" +
            "  initgraph( &GraphDriver, &GraphMode, \"\" );\n" +
            "  ErrorCode = graphresult();\t\t/* Read result of initialization*/\n" +
            "  if( ErrorCode != grOk ){\t\t/* Error occured during init\t*/\n" +
            "    printf(\" Graphics System Error: %s\\n\", grapherrormsg( ErrorCode ) );\n" +
            "    exit( 1 );\n" +
            "  }\n" +
            "\n" +
            "  getpalette( &palette );\t\t/* Read the palette from board\t*/\n" +
            "  MaxColors = getmaxcolor() + 1;\t/* Read maximum number of colors*/\n" +
            "\n" +
            "  MaxX = getmaxx();\n" +
            "  MaxY = getmaxy();\t\t\t/* Read size of screen\t\t*/\n" +
            "\n" +
            "  getaspectratio( &xasp, &yasp );\t/* read the hardware aspect\t*/\n" +
            "  AspectRatio = (double)xasp / (double)yasp; /* Get correction factor\t*/\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tREPORTSTATUS: Report the current configuration of the system\t*/\n" +
            "/*\tafter the auto-detect initialization.\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void ReportStatus(void)\n" +
            "{\n" +
            "  struct viewporttype\t  viewinfo;\t/* Params for inquiry procedures*/\n" +
            "  struct linesettingstype lineinfo;\n" +
            "  struct fillsettingstype fillinfo;\n" +
            "  struct textsettingstype textinfo;\n" +
            "  struct palettetype\t  palette;\n" +
            "\n" +
            "  char *driver, *mode;\t\t\t/* Strings for driver and mode\t*/\n" +
            "  int x, y;\n" +
            "\n" +
            "  getviewsettings( &viewinfo );\n" +
            "  getlinesettings( &lineinfo );\n" +
            "  getfillsettings( &fillinfo );\n" +
            "  gettextsettings( &textinfo );\n" +
            "  getpalette( &palette );\n" +
            "\n" +
            "  x = 10;\n" +
            "  y = 4;\n" +
            "\n" +
            "  MainWindow( \"Status report after InitGraph\" );\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  driver = getdrivername();\n" +
            "  mode = getmodename(GraphMode);\t/* get current setting\t\t*/\n" +
            "\n" +
            "  gprintf( &x, &y, \"Graphics device    : %-20s (%d)\", driver, GraphDriver );\n" +
            "  gprintf( &x, &y, \"Graphics mode      : %-20s (%d)\", mode, GraphMode );\n" +
            "  gprintf( &x, &y, \"Screen resolution  : ( 0, 0, %d, %d )\", getmaxx(), getmaxy() );\n" +
            "\n" +
            "  gprintf( &x, &y, \"Current view port  : ( %d, %d, %d, %d )\",\n" +
            "  viewinfo.left, viewinfo.top, viewinfo.right, viewinfo.bottom );\n" +
            "  gprintf( &x, &y, \"Clipping           : %s\", viewinfo.clip ? \"ON\" : \"OFF\" );\n" +
            "\n" +
            "  gprintf( &x, &y, \"Current position   : ( %d, %d )\", getx(), gety() );\n" +
            "  gprintf( &x, &y, \"Colors available   : %d\", MaxColors );\n" +
            "  gprintf( &x, &y, \"Current color      : %d\", getcolor() );\n" +
            "\n" +
            "  gprintf( &x, &y, \"Line style         : %s\", LineStyles[ lineinfo.linestyle ] );\n" +
            "  gprintf( &x, &y, \"Line thickness     : %d\", lineinfo.thickness );\n" +
            "\n" +
            "  gprintf( &x, &y, \"Current fill style : %s\", FillStyles[ fillinfo.pattern ] );\n" +
            "  gprintf( &x, &y, \"Current fill color : %d\", fillinfo.color );\n" +
            "\n" +
            "  gprintf( &x, &y, \"Current font       : %s\", Fonts[ textinfo.font ] );\n" +
            "  gprintf( &x, &y, \"Text direction     : %s\", TextDirect[ textinfo.direction ] );\n" +
            "  gprintf( &x, &y, \"Character size     : %d\", textinfo.charsize );\n" +
            "  gprintf( &x, &y, \"Horizontal justify : %s\", HorizJust[ textinfo.horiz ] );\n" +
            "  gprintf( &x, &y, \"Vertical justify   : %s\", VertJust[ textinfo.vert ] );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Pause for user to read screen*/\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tTEXTDUMP: Display the all the characters in each of the \t*/\n" +
            "/*\tavailable fonts.\t\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void TextDump()\n" +
            "{\n" +
            "  static int CGASizes[]  = {\n" +
            "    1, 3, 7, 3, 3, 2, 2, 2, 2, 2, 2  };\n" +
            "  static int NormSizes[] = {\n" +
            "    1, 4, 7, 4, 4, 2, 2, 2, 2, 2, 2  };\n" +
            "\n" +
            "  char buffer[80];\n" +
            "  int font, ch, wwidth, lwidth, size;\n" +
            "  struct viewporttype vp;\n" +
            "\n" +
            "  for( font=0 ; font<NFONTS ; ++font ){\t/* For each available font\t*/\n" +
            "    sprintf( buffer, \"%s Character Set\", Fonts[font] );\n" +
            "    MainWindow( buffer );\t\t/* Display fontname as banner\t*/\n" +
            "    getviewsettings( &vp );\t\t/* read current viewport\t*/\n" +
            "\n" +
            "    settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "    moveto( 2, 3 );\n" +
            "\n" +
            "    buffer[1] = '\\0';                   /* Terminate string             */\n" +
            "    wwidth = vp.right - vp.left;\t/* Determine the window width\t*/\n" +
            "    lwidth = textwidth( \"H\" );          /* Get average letter width     */\n" +
            "\n" +
            "    if( font == DEFAULT_FONT ){\n" +
            "      changetextstyle( font, HORIZ_DIR, 1 );\n" +
            "      ch = 0;\n" +
            "      while( ch < 256 ){\t\t/* For each possible character\t*/\n" +
            "\tbuffer[0] = ch; \t\t/* Put character into a string\t*/\n" +
            "\touttext( buffer );\t\t/* send string to screen\t*/\n" +
            "\tif( (getx() + lwidth) > wwidth )\n" +
            "\t  moveto( 2, gety() + textheight(\"H\") + 3 );\n" +
            "\t++ch;\t\t\t\t/* Goto the next character\t*/\n" +
            "      }\n" +
            "    }\n" +
            "    else{\n" +
            "\n" +
            "      size = (MaxY < 200) ? CGASizes[font] : NormSizes[font];\n" +
            "      changetextstyle( font, HORIZ_DIR, size );\n" +
            "\n" +
            "      ch = '!';                         /* Begin at 1st printable       */\n" +
            "      while( ch < 256 ){\t\t/* For each printable character */\n" +
            "\tbuffer[0] = ch; \t\t/* Put character into a string\t*/\n" +
            "\touttext( buffer );\t\t/* send string to screen\t*/\n" +
            "\tif( (lwidth+getx()) > wwidth )\t/* Are we still in window?\t*/\n" +
            "\t  moveto( 2, gety()+textheight(\"H\")+3 );\n" +
            "\t++ch;\t\t\t\t/* Goto the next character\t*/\n" +
            "      }\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "    Pause();\t\t\t\t/* Pause until user acks\t*/\n" +
            "\n" +
            "  }\t\t\t\t\t/* End of FONT loop\t\t*/\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tBAR3DDEMO: Display a 3-D bar chart on the screen.\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void Bar3DDemo(void)\n" +
            "{\n" +
            "  static int barheight[] = {\n" +
            "    1, 3, 5, 4, 3, 2, 1, 5, 4, 2, 3   };\n" +
            "  struct viewporttype vp;\n" +
            "  int xstep, ystep;\n" +
            "  int i, j, h, color, bheight;\n" +
            "  char buffer[10];\n" +
            "\n" +
            "  MainWindow( \"Bar 3-D / Rectangle Demonstration\" );\n" +
            "\n" +
            "  h = 3 * textheight( \"H\" );\n" +
            "  getviewsettings( &vp );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  changetextstyle( TRIPLEX_FONT, HORIZ_DIR, 4 );\n" +
            "  outtextxy( MaxX/2, 6, \"These are 3-D Bars\" );\n" +
            "  changetextstyle( DEFAULT_FONT, HORIZ_DIR, 1 );\n" +
            "  setviewport( vp.left+50, vp.top+40, vp.right-50, vp.bottom-10, 1 );\n" +
            "  getviewsettings( &vp );\n" +
            "\n" +
            "  line( h, h, h, vp.bottom-vp.top-h );\n" +
            "  line( h, (vp.bottom-vp.top)-h, (vp.right-vp.left)-h, (vp.bottom-vp.top)-h );\n" +
            "  xstep = ((vp.right-vp.left) - (2*h)) / 10;\n" +
            "  ystep = ((vp.bottom-vp.top) - (2*h)) / 5;\n" +
            "  j = (vp.bottom-vp.top) - h;\n" +
            "  settextjustify( CENTER_TEXT, CENTER_TEXT );\n" +
            "\n" +
            "  for( i=0 ; i<6 ; ++i ){\n" +
            "    line( h/2, j, h, j );\n" +
            "    itoa( i, buffer, 10 );\n" +
            "    outtextxy( 0, j, buffer );\n" +
            "    j -= ystep;\n" +
            "  }\n" +
            "\n" +
            "  j = h;\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  for( i=0 ; i<11 ; ++i ){\n" +
            "    color = random( MaxColors );\n" +
            "    setfillstyle( i+1, color );\n" +
            "    line( j, (vp.bottom-vp.top)-h, j, (vp.bottom-vp.top-3)-(h/2) );\n" +
            "    itoa( i, buffer, 10 );\n" +
            "    outtextxy( j, (vp.bottom-vp.top)-(h/2), buffer );\n" +
            "    if( i != 10 ){\n" +
            "      bheight = (vp.bottom-vp.top) - h - 1;\n" +
            "      bar3d( j, (vp.bottom-vp.top-h)-(barheight[i]*ystep), j+xstep, bheight, 15, 1 );\n" +
            "    }\n" +
            "    j += xstep;\n" +
            "  }\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Pause for user's response    */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tRANDOMBARS: Display random bars \t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void RandomBars(void)\n" +
            "{\n" +
            "  int color;\n" +
            "\n" +
            "  MainWindow( \"Random Bars\" );\n" +
            "  StatusLine( \"Esc aborts or press a key...\" ); /* Put msg at bottom of screen   */\n" +
            "  while( !kbhit() ){\t\t\t/* Until user enters a key...\t*/\n" +
            "    color = random( MaxColors-1 )+1;\n" +
            "    setcolor( color );\n" +
            "    setfillstyle( random(11)+1, color );\n" +
            "    bar3d( random( getmaxx() ), random( getmaxy() ),\n" +
            "\t   random( getmaxx() ), random( getmaxy() ), 0, OFF);\n" +
            "  }\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Pause for user's response    */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tTEXTDEMO: Show each font in several sizes to the user.\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void TextDemo(void)\n" +
            "{\n" +
            "  int charsize[] = {\n" +
            "    1, 3, 7, 3, 4, 2, 2, 2, 2, 2, 2   };\n" +
            "  int font, size;\n" +
            "  int h, x, y, i;\n" +
            "  struct viewporttype vp;\n" +
            "  char buffer[80];\n" +
            "\n" +
            "  for( font=0 ; font<NFONTS ; ++font ){\t/* For each of the avail. fonts\t*/\n" +
            "\n" +
            "    sprintf( buffer, \"%s Demonstration\", Fonts[font] );\n" +
            "    MainWindow( buffer );\n" +
            "    getviewsettings( &vp );\n" +
            "\n" +
            "    changetextstyle( font, VERT_DIR, charsize[font] );\n" +
            "    settextjustify( CENTER_TEXT, BOTTOM_TEXT );\n" +
            "    outtextxy( 2*textwidth(\"M\"), vp.bottom - 2*textheight(\"M\"), \"Vertical\" );\n" +
            "\n" +
            "    changetextstyle( font, HORIZ_DIR, charsize[font] );\n" +
            "    settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "    outtextxy( 2*textwidth(\"M\"), 2, \"Horizontal\" );\n" +
            "\n" +
            "    settextjustify( CENTER_TEXT, CENTER_TEXT );\n" +
            "    x = (vp.right - vp.left) / 2;\n" +
            "    y = textheight( \"H\" );\n" +
            "\n" +
            "    for( i=1 ; i<5 ; ++i ){\t\t/* For each of the sizes */\n" +
            "      size = (font == SMALL_FONT) ? i+3 : i;\n" +
            "      changetextstyle( font, HORIZ_DIR, size );\n" +
            "      h = textheight( \"H\" );\n" +
            "      y += h;\n" +
            "      sprintf( buffer, \"Size %d\", size );\n" +
            "      outtextxy( x, y, buffer );\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "    if( font != DEFAULT_FONT ){ \t/* Show user declared font size */\n" +
            "      y += h / 2;\t\t\t/* Move down the screen \t*/\n" +
            "      settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "      setusercharsize( 5, 6, 3, 2 );\n" +
            "      changetextstyle( font, HORIZ_DIR, USER_CHAR_SIZE );\n" +
            "      outtextxy( (vp.right-vp.left)/2, y, \"User Defined Size\" );\n" +
            "    }\n" +
            "\n" +
            "    Pause();\t\t\t\t/* Pause to let user look\t*/\n" +
            "\n" +
            "  }\t\t\t\t\t/* End of FONT loop\t\t*/\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tCOLORDEMO: Display the current color palette on the screen.\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void ColorDemo(void)\n" +
            "{\n" +
            "  struct viewporttype vp;\n" +
            "  int color, height, width;\n" +
            "  int x, y, i, j;\n" +
            "  char cnum[5];\n" +
            "\n" +
            "  MainWindow( \"Color Demonstration\" );  /* Show demonstration name      */\n" +
            "\n" +
            "  color = 1;\n" +
            "  getviewsettings( &vp );\t\t/* Get the current window size\t*/\n" +
            "  width  = 2 * ( (vp.right+1) / 16 );\t   /* Get box dimensions\t   */\n" +
            "  height = 2 * ( (vp.bottom-10) / 10 );\n" +
            "\n" +
            "  x = width / 2;\n" +
            "  y = height / 2;\t/* Leave 1/2 box border \t*/\n" +
            "\n" +
            "  for( j=0 ; j<3 ; ++j ){\t\t/* Row loop\t\t\t*/\n" +
            "\n" +
            "    for( i=0 ; i<5 ; ++i ){\t\t/* Column loop\t\t\t*/\n" +
            "\n" +
            "      setfillstyle(SOLID_FILL, color);\t/* Set to solid fill in color\t*/\n" +
            "      setcolor( color );\t\t/* Set the same border color\t*/\n" +
            "\n" +
            "      bar( x, y, x+width, y+height );\t/* Draw the rectangle\t\t*/\n" +
            "      rectangle( x, y, x+width, y+height );  /* outline the rectangle\t*/\n" +
            "\n" +
            "      if( color == BLACK ){\t\t/* If box was black...\t\t*/\n" +
            "\tsetcolor( WHITE );\t\t/* Set drawing color to white\t*/\n" +
            "\trectangle( x, y, x+width, y+height );  /* Outline black in white*/\n" +
            "      }\n" +
            "\n" +
            "      itoa( color, cnum, 10 );\t\t/* Convert # to ASCII\t\t*/\n" +
            "      outtextxy( x+(width/2), y+height+4, cnum );  /* Show color #\t*/\n" +
            "\n" +
            "      color = ++color % MaxColors;\t/* Advance to the next color\t*/\n" +
            "      x += (width / 2) * 3;\t\t/* move the column base \t*/\n" +
            "    }\t\t\t\t/* End of Column loop\t\t*/\n" +
            "\n" +
            "    y += (height / 2) * 3;\t\t/* move the row base\t\t*/\n" +
            "    x = width / 2;\t\t\t/* reset column base\t\t*/\n" +
            "  }\t\t\t\t\t/* End of Row loop\t\t*/\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Pause for user's response    */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tARCDEMO: Display a random pattern of arcs on the screen */\n" +
            "/*\tuntil the user says enough.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void ArcDemo(void)\n" +
            "{\n" +
            "  int mradius;\t\t\t\t/* Maximum radius allowed\t*/\n" +
            "  int eangle;\t\t\t\t/* Random end angle of Arc\t*/\n" +
            "  struct arccoordstype ai;\t\t/* Used to read Arc Cord info\t*/\n" +
            "\n" +
            "  MainWindow( \"Arc Demonstration\" );\n" +
            "  StatusLine( \"ESC Aborts - Press a Key to stop\" );\n" +
            "\n" +
            "  mradius = MaxY / 10;\t\t\t/* Determine the maximum radius */\n" +
            "\n" +
            "  while( !kbhit() ){\t\t\t/* Repeat until a key is hit\t*/\n" +
            "    setcolor( random( MaxColors - 1 ) + 1 );\t/* Randomly select a color\t*/\n" +
            "    eangle = random( 358 ) + 1; \t/* Select an end angle\t\t*/\n" +
            "    arc( random(MaxX), random(MaxY), random(eangle), eangle, mradius );\n" +
            "    getarccoords( &ai );\t\t/* Read Cord data\t\t*/\n" +
            "    line( ai.x, ai.y, ai.xstart, ai.ystart ); /* line from start to center */\n" +
            "    line( ai.x, ai.y,\tai.xend,   ai.yend ); /* line from end to center   */\n" +
            "  }\t\t\t\t\t/* End of WHILE not KBHIT\t*/\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tCIRCLEDEMO: Display a random pattern of circles on the screen\t*/\n" +
            "/*\tuntil the user says enough.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void CircleDemo(void)\n" +
            "{\n" +
            "  int mradius;\t\t\t\t/* Maximum radius allowed\t*/\n" +
            "\n" +
            "  MainWindow( \"Circle Demonstration\" );\n" +
            "  StatusLine( \"ESC Aborts - Press a Key to stop\" );\n" +
            "\n" +
            "  mradius = MaxY / 10;\t\t\t/* Determine the maximum radius */\n" +
            "\n" +
            "  while( !kbhit() ){\t\t\t/* Repeat until a key is hit\t*/\n" +
            "    setcolor( random( MaxColors - 1 ) + 1 );\t/* Randomly select a color\t*/\n" +
            "    circle( random(MaxX), random(MaxY), random(mradius) );\n" +
            "  }\t\t\t\t\t/* End of WHILE not KBHIT\t*/\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tPIEDEMO: Display a pie chart on the screen.\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "#define adjasp( y )\t((int)(AspectRatio * (double)(y)))\n" +
            "#define torad( d )\t(( (double)(d) * PI ) / 180.0 )\n" +
            "\n" +
            "void PieDemo(void)\n" +
            "{\n" +
            "  struct viewporttype vp;\n" +
            "  int xcenter, ycenter, radius, lradius;\n" +
            "  int x, y;\n" +
            "  double radians, piesize;\n" +
            "\n" +
            "  MainWindow( \"Pie Chart Demonstration\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\t\t/* Get the current viewport\t*/\n" +
            "  xcenter = (vp.right - vp.left) / 2;\t/* Center the Pie horizontally\t*/\n" +
            "  ycenter = (vp.bottom - vp.top) / 2+20;/* Center the Pie vertically\t*/\n" +
            "  radius  = (vp.bottom - vp.top) / 3;\t/* It will cover 2/3rds screen\t*/\n" +
            "  piesize = (vp.bottom - vp.top) / 4.0; /* Optimum height ratio of pie\t*/\n" +
            "\n" +
            "  while( (AspectRatio*radius) < piesize ) ++radius;\n" +
            "\n" +
            "  lradius = radius + ( radius / 5 );\t/* Labels placed 20% farther\t*/\n" +
            "\n" +
            "  changetextstyle( TRIPLEX_FONT, HORIZ_DIR, 4 );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  outtextxy( MaxX/2, 6, \"This is a Pie Chart\" );\n" +
            "  changetextstyle( TRIPLEX_FONT, HORIZ_DIR, 1 );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  setfillstyle( SOLID_FILL, RED );\n" +
            "  pieslice( xcenter+10, ycenter-adjasp(10), 0, 90, radius );\n" +
            "  radians = torad( 45 );\n" +
            "  x = xcenter + (int)( cos( radians ) * (double)lradius );\n" +
            "  y = ycenter - (int)( sin( radians ) * (double)lradius * AspectRatio );\n" +
            "  settextjustify( LEFT_TEXT, BOTTOM_TEXT );\n" +
            "  outtextxy( x, y, \"25 %\" );\n" +
            "\n" +
            "  setfillstyle( WIDE_DOT_FILL, GREEN );\n" +
            "  pieslice( xcenter, ycenter, 90, 135, radius );\n" +
            "  radians = torad( 113 );\n" +
            "  x = xcenter + (int)( cos( radians ) * (double)lradius );\n" +
            "  y = ycenter - (int)( sin( radians ) * (double)lradius * AspectRatio );\n" +
            "  settextjustify( RIGHT_TEXT, BOTTOM_TEXT );\n" +
            "  outtextxy( x, y, \"12.5 %\" );\n" +
            "\n" +
            "  setfillstyle( INTERLEAVE_FILL, YELLOW );\n" +
            "  settextjustify( RIGHT_TEXT, CENTER_TEXT );\n" +
            "  pieslice( xcenter-10, ycenter, 135, 225, radius );\n" +
            "  radians = torad( 180 );\n" +
            "  x = xcenter + (int)( cos( radians ) * (double)lradius );\n" +
            "  y = ycenter - (int)( sin( radians ) * (double)lradius * AspectRatio );\n" +
            "  settextjustify( RIGHT_TEXT, CENTER_TEXT );\n" +
            "  outtextxy( x, y, \"25 %\" );\n" +
            "\n" +
            "  setfillstyle( HATCH_FILL, BLUE );\n" +
            "  pieslice( xcenter, ycenter, 225, 360, radius );\n" +
            "  radians = torad( 293 );\n" +
            "  x = xcenter + (int)( cos( radians ) * (double)lradius );\n" +
            "  y = ycenter - (int)( sin( radians ) * (double)lradius * AspectRatio );\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "  outtextxy( x, y, \"37.5 %\" );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Pause for user's response    */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tBARDEMO: Draw a 2-D bar chart using Bar and Rectangle.\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void BarDemo(void)\n" +
            "{\n" +
            "  int barheight[] = {\n" +
            "    1, 3, 5, 2, 4   };\n" +
            "  int styles[]\t  = {\n" +
            "    1, 3, 10, 5, 9, 1\t};\n" +
            "  int xstep, ystep;\n" +
            "  int sheight, swidth;\n" +
            "  int i, j, h;\n" +
            "  struct viewporttype vp;\n" +
            "  char buffer[40];\n" +
            "\n" +
            "  MainWindow( \"Bar / Rectangle demonstration\" );\n" +
            "  h = 3 * textheight( \"H\" );\n" +
            "  getviewsettings( &vp );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  changetextstyle( TRIPLEX_FONT, HORIZ_DIR, 4 );\n" +
            "  outtextxy( MaxX /2, 6, \"These are 2-D Bars\" );\n" +
            "  changetextstyle( DEFAULT_FONT, HORIZ_DIR, 1 );\n" +
            "  setviewport( vp.left+50, vp.top+30, vp.right-50, vp.bottom-10, 1 );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  sheight = vp.bottom - vp.top;\n" +
            "  swidth  = vp.right  - vp.left;\n" +
            "\n" +
            "  line( h, h, h, sheight-h );\n" +
            "  line( h, sheight-h, sheight-h, sheight-h );\n" +
            "  ystep = (sheight - (2*h) ) / 5;\n" +
            "  xstep = (swidth  - (2*h) ) / 5;\n" +
            "  j = sheight - h;\n" +
            "  settextjustify( CENTER_TEXT, CENTER_TEXT );\n" +
            "\n" +
            "  for( i=0 ; i<6 ; ++i ){\n" +
            "    line( h/2, j, h, j );\n" +
            "    itoa( i, buffer, 10 );\n" +
            "    outtextxy( 0, j, buffer );\n" +
            "    j -= ystep;\n" +
            "  }\n" +
            "\n" +
            "  j = h;\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  for( i=0 ; i<6 ; ++i ){\n" +
            "    setfillstyle( styles[i], random(MaxColors) );\n" +
            "    line( j, sheight - h, j, sheight- 3 - (h/2) );\n" +
            "    itoa( i, buffer, 10 );\n" +
            "    outtextxy( j, sheight - (h/2), buffer );\n" +
            "    if( i != 5 ){\n" +
            "      bar( j, (sheight-h)-(barheight[i] * ystep), j+xstep, sheight-h-1 );\n" +
            "      rectangle( j, (sheight-h)-(barheight[i] * ystep), j+xstep, sheight-h);\n" +
            "    }\n" +
            "    j += xstep;\n" +
            "  }\n" +
            "\n" +
            "  Pause();\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tLINERELDEMO: Display pattern using moverel and linerel cmds.\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void LineRelDemo(void)\n" +
            "{\n" +
            "  struct viewporttype vp;\n" +
            "  int h, w, dx, dy, cx, cy;\n" +
            "  struct PTS outs[7];\n" +
            "\n" +
            "\n" +
            "  MainWindow( \"MoveRel / LineRel Demonstration\" );\n" +
            "  StatusLine( \"Press any key to continue, ESC to Abort\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  cx = (vp.right  - vp.left) / 2;\t/* Center of the screen coords\t*/\n" +
            "  cy = (vp.bottom - vp.top ) / 2;\n" +
            "\n" +
            "  h  = (vp.bottom - vp.top ) / 8;\n" +
            "  w  = (vp.right  - vp.left) / 9;\n" +
            "\n" +
            "  dx = 2 * w;\n" +
            "  dy = 2 * h;\n" +
            "\n" +
            "  setcolor( BLACK );\n" +
            "\n" +
            "  setfillstyle( SOLID_FILL, BLUE );\n" +
            "  bar( 0, 0, vp.right-vp.left, vp.bottom-vp.top );\t/* Draw backgnd */\n" +
            "\n" +
            "  outs[0].x = cx -  dx;\n" +
            "  outs[0].y = cy -  dy;\n" +
            "  outs[1].x = cx - (dx-w);\n" +
            "  outs[1].y = cy - (dy+h);\n" +
            "  outs[2].x = cx +  dx;\n" +
            "  outs[2].y = cy - (dy+h);\n" +
            "  outs[3].x = cx +  dx;\n" +
            "  outs[3].y = cy +  dy;\n" +
            "  outs[4].x = cx + (dx-w);\n" +
            "  outs[4].y = cy + (dy+h);\n" +
            "  outs[5].x = cx -  dx;\n" +
            "  outs[5].y = cy + (dy+h);\n" +
            "  outs[6].x = cx -  dx;\n" +
            "  outs[6].y = cy -  dy;\n" +
            "\n" +
            "  setfillstyle( SOLID_FILL, WHITE );\n" +
            "  fillpoly( 7, (int far *)outs );\n" +
            "\n" +
            "  outs[0].x = cx - (w/2);\n" +
            "  outs[0].y = cy + h;\n" +
            "  outs[1].x = cx + (w/2);\n" +
            "  outs[1].y = cy + h;\n" +
            "  outs[2].x = cx + (w/2);\n" +
            "  outs[2].y = cy - h;\n" +
            "  outs[3].x = cx - (w/2);\n" +
            "  outs[3].y = cy - h;\n" +
            "  outs[4].x = cx - (w/2);\n" +
            "  outs[4].y = cy + h;\n" +
            "\n" +
            "  setfillstyle( SOLID_FILL, BLUE );\n" +
            "  fillpoly( 5, (int far *)outs );\n" +
            "\n" +
            "  /*\tDraw a Tesseract object on the screen using the LineRel and\t*/\n" +
            "  /*\tMoveRel drawing commands.\t\t\t\t\t*/\n" +
            "\n" +
            "  moveto( cx-dx, cy-dy );\n" +
            "  linerel(  w, -h );\n" +
            "  linerel(  3*w,\t0 );\n" +
            "  linerel(   0,  5*h );\n" +
            "  linerel( -w,\th );\n" +
            "  linerel( -3*w,\t0 );\n" +
            "  linerel(   0, -5*h );\n" +
            "\n" +
            "  moverel( w, -h );\n" +
            "  linerel(   0,  5*h );\n" +
            "  linerel( w+(w/2), 0 );\n" +
            "  linerel(   0, -3*h );\n" +
            "  linerel( w/2,   -h );\n" +
            "  linerel( 0, 5*h );\n" +
            "\n" +
            "  moverel(  0, -5*h );\n" +
            "  linerel( -(w+(w/2)), 0 );\n" +
            "  linerel( 0, 3*h );\n" +
            "  linerel( -w/2, h );\n" +
            "\n" +
            "  moverel( w/2, -h );\n" +
            "  linerel( w, 0 );\n" +
            "\n" +
            "  moverel( 0, -2*h );\n" +
            "  linerel( -w, 0 );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tPUTPIXELDEMO: Display a pattern of random dots on the screen\t*/\n" +
            "/*\tand pick them back up again.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void PutPixelDemo(void)\n" +
            "{\n" +
            "  int seed = 1958;\n" +
            "  int i, x, y, h, w, color;\n" +
            "  struct viewporttype vp;\n" +
            "\n" +
            "  MainWindow( \"PutPixel / GetPixel Demonstration\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  h = vp.bottom - vp.top;\n" +
            "  w = vp.right\t- vp.left;\n" +
            "\n" +
            "  srand( seed );\t\t\t/* Restart random # function\t*/\n" +
            "\n" +
            "  for( i=0 ; i<5000 ; ++i ){\t\t/* Put 5000 pixels on screen\t*/\n" +
            "    x = 1 + random( w - 1 );\t\t/* Generate a random location\t*/\n" +
            "    y = 1 + random( h - 1 );\n" +
            "    color = random( MaxColors );\n" +
            "    putpixel( x, y, color );\n" +
            "  }\n" +
            "\n" +
            "  srand( seed );\t\t\t/* Restart Random # at same #\t*/\n" +
            "\n" +
            "  for( i=0 ; i<5000 ; ++i ){\t\t/* Take the 5000 pixels off\t*/\n" +
            "    x = 1 + random( w - 1 );\t\t/* Generate a random location\t*/\n" +
            "    y = 1 + random( h - 1 );\n" +
            "    color = getpixel( x, y );\t\t/* Read the color pixel \t*/\n" +
            "    if( color == random( MaxColors ) )\t/* Used to keep RANDOM in sync\t*/\n" +
            "      putpixel( x, y, 0 );\t\t/* Write pixel to BLACK \t*/\n" +
            "  }\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*   PUTIMAGEDEMO\t\t\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "void PutImageDemo(void)\n" +
            "{\n" +
            "  static int r\t    = 20;\n" +
            "  static int StartX = 100;\n" +
            "  static int StartY = 50;\n" +
            "\n" +
            "  struct viewporttype vp;\n" +
            "  int PauseTime, x, y, ulx, uly, lrx, lry, size, i, width, height, step;\n" +
            "  void *Saucer;\n" +
            "\n" +
            "  MainWindow(\"GetImage / PutImage Demonstration\");\n" +
            "  getviewsettings( &vp );\n" +
            "\n" +
            "  /* Draw Saucer */\n" +
            "  setfillstyle( SOLID_FILL, getmaxcolor() );\n" +
            "  fillellipse(StartX, StartY, r, (r/3)+2);\n" +
            "  ellipse(StartX, StartY-4, 190, 357, r, r/3);\n" +
            "\n" +
            "  line(StartX+7, StartY-6, StartX+10, StartY-12);\n" +
            "  circle(StartX+10, StartY-12, 2);\n" +
            "  line(StartX-7, StartY-6, StartX-10, StartY-12);\n" +
            "  circle(StartX-10, StartY-12, 2);\n" +
            "\n" +
            "\n" +
            "  /* Read saucer image */\n" +
            "  ulx = StartX-(r+1);\n" +
            "  uly = StartY-14;\n" +
            "  lrx = StartX+(r+1);\n" +
            "  lry = StartY+(r/3)+3;\n" +
            "  width = lrx - ulx + 1;\n" +
            "  height = lry - uly + 1;\n" +
            "  size = imagesize(ulx, uly, lrx, lry);\n" +
            "\n" +
            "  Saucer = malloc( size );\n" +
            "  getimage(ulx, uly, lrx, lry, Saucer);\n" +
            "  putimage(ulx, uly, Saucer, XOR_PUT);\n" +
            "\n" +
            "/* Plot some \"stars\"  */\n" +
            "  for ( i=0 ; i<1000; ++i )\n" +
            "    putpixel(random(MaxX), random(MaxY), random( MaxColors-1 )+1);\n" +
            "  x = MaxX / 2;\n" +
            "  y = MaxY / 2;\n" +
            "  PauseTime = 70;\n" +
            "\n" +
            "  /* until a key is hit */\n" +
            "  while ( !kbhit() ) {\n" +
            "\n" +
            "    /* Draw the Saucer */\n" +
            "    putimage(x, y, Saucer, XOR_PUT);\t\t     /*  draw image  */\n" +
            "    delay(PauseTime);\n" +
            "    putimage(x, y, Saucer, XOR_PUT);\t\t     /* erase image  */\n" +
            "\n" +
            "    /* Move Saucer */\n" +
            "\n" +
            "    step = random( 2*r );\n" +
            "    if ((step/2) % 2 != 0 )\n" +
            "      step = -1 * step;\n" +
            "    x = x + step;\n" +
            "    step = random( r );\n" +
            "    if ((step/2) % 2 != 0 )\n" +
            "      step = -1 * step;\n" +
            "    y = y + step;\n" +
            "\n" +
            "    if (vp.left + x + width - 1 > vp.right)\n" +
            "      x = vp.right-vp.left-width + 1;\n" +
            "    else\n" +
            "      if (x < 0)\n" +
            "\tx = 0;\n" +
            "    if (vp.top + y + height - 1 > vp.bottom)\n" +
            "      y = vp.bottom-vp.top-height + 1;\n" +
            "    else\n" +
            "      if (y < 0)\n" +
            "\ty = 0;\n" +
            "  }\n" +
            "  free( Saucer );\n" +
            "  Pause();\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tLINETODEMO: Display a pattern using moveto and lineto commands. */\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "#define MAXPTS\t15\n" +
            "\n" +
            "void LineToDemo(void)\n" +
            "{\n" +
            "  struct viewporttype vp;\n" +
            "  struct PTS points[MAXPTS];\n" +
            "  int i, j, h, w, xcenter, ycenter;\n" +
            "  int radius, angle, step;\n" +
            "  double  rads;\n" +
            "\n" +
            "  MainWindow( \"MoveTo / LineTo Demonstration\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  h = vp.bottom - vp.top;\n" +
            "  w = vp.right\t- vp.left;\n" +
            "\n" +
            "  xcenter = w / 2;\t\t\t/* Determine the center of circle */\n" +
            "  ycenter = h / 2;\n" +
            "  radius  = (h - 30) / (AspectRatio * 2);\n" +
            "  step\t  = 360 / MAXPTS;\t\t/* Determine # of increments\t*/\n" +
            "\n" +
            "  angle = 0;\t\t\t\t/* Begin at zero degrees\t*/\n" +
            "  for( i=0 ; i<MAXPTS ; ++i ){\t\t/* Determine circle intercepts\t*/\n" +
            "    rads = (double)angle * PI / 180.0;\t/* Convert angle to radians\t*/\n" +
            "    points[i].x = xcenter + (int)( cos(rads) * radius );\n" +
            "    points[i].y = ycenter - (int)( sin(rads) * radius * AspectRatio );\n" +
            "    angle += step;\t\t\t/* Move to next increment\t*/\n" +
            "  }\n" +
            "\n" +
            "  circle( xcenter, ycenter, radius );\t/* Draw bounding circle \t*/\n" +
            "\n" +
            "  for( i=0 ; i<MAXPTS ; ++i ){\t\t/* Draw the cords to the circle */\n" +
            "    for( j=i ; j<MAXPTS ; ++j ){\t/* For each remaining intersect */\n" +
            "      moveto(points[i].x, points[i].y); /* Move to beginning of cord\t*/\n" +
            "      lineto(points[j].x, points[j].y); /* Draw the cord\t\t*/\n" +
            "    }\n" +
            "  }\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tLINESTYLEDEMO: Display a pattern using all of the standard\t*/\n" +
            "/*\tline styles that are available. \t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void LineStyleDemo(void)\n" +
            "{\n" +
            "  int style, step;\n" +
            "  int x, y, w;\n" +
            "  struct viewporttype vp;\n" +
            "  char buffer[40];\n" +
            "\n" +
            "  MainWindow( \"Pre-defined line styles\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  w = vp.right\t- vp.left;\n" +
            "\n" +
            "  x = 35;\n" +
            "  y = 10;\n" +
            "  step = w / 11;\n" +
            "\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "  outtextxy( x, y, \"Normal Width\" );\n" +
            "\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  for( style=0 ; style<4 ; ++style ){\n" +
            "    setlinestyle( style, 0, NORM_WIDTH );\n" +
            "    line( x, y+20, x, vp.bottom-40 );\n" +
            "    itoa( style, buffer, 10 );\n" +
            "    outtextxy( x, vp.bottom-30, buffer );\n" +
            "    x += step;\n" +
            "  }\n" +
            "\n" +
            "  x += 2 * step;\n" +
            "\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "  outtextxy( x, y, \"Thick Width\" );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  for( style=0 ; style<4 ; ++style ){\n" +
            "    setlinestyle( style, 0, THICK_WIDTH );\n" +
            "    line( x, y+20, x, vp.bottom-40 );\n" +
            "    itoa( style, buffer, 10 );\n" +
            "    outtextxy( x, vp.bottom-30, buffer );\n" +
            "    x += step;\n" +
            "  }\n" +
            "\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tCRTMODEDEMO: Demonstrate the effects of the change mode \t*/\n" +
            "/*\tcommands on the current screen. \t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void CRTModeDemo(void)\n" +
            "{\n" +
            "  struct viewporttype vp;\n" +
            "  int mode;\n" +
            "\n" +
            "  MainWindow( \"SetGraphMode / RestoreCRTMode demo\" );\n" +
            "  getviewsettings( &vp );\n" +
            "  mode = getgraphmode();\n" +
            "  settextjustify( CENTER_TEXT, CENTER_TEXT );\n" +
            "\n" +
            "  outtextxy( (vp.right-vp.left)/2, (vp.bottom-vp.top)/2,\n" +
            "  \"Now you are in graphics mode...\" );\n" +
            "  StatusLine( \"Press any key for text mode...\" );\n" +
            "  getch();\n" +
            "\n" +
            "  restorecrtmode();\n" +
            "  printf( \"Now you are in text mode.\\n\\n\" );\n" +
            "  printf( \"Press any key to go back to graphics...\" );\n" +
            "  getch();\n" +
            "\n" +
            "  setgraphmode( mode );\n" +
            "  MainWindow( \"SetGraphMode / RestoreCRTMode demo\" );\n" +
            "  settextjustify( CENTER_TEXT, CENTER_TEXT );\n" +
            "  outtextxy( (vp.right-vp.left)/2, (vp.bottom-vp.top)/2,\n" +
            "  \"Back in Graphics Mode...\" );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tUSERLINESTYLEDEMO: Display line styles showing the user \t*/\n" +
            "/*\tdefined line style functions.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void UserLineStyleDemo(void)\n" +
            "{\n" +
            "  int x, y, i, h, flag;\n" +
            "  unsigned int style;\n" +
            "  struct viewporttype vp;\n" +
            "\n" +
            "  MainWindow( \"User defined line styles\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  h = vp.bottom - vp.top;\n" +
            "\n" +
            "  x = 4;\n" +
            "  y = 10;\n" +
            "  style = 0;\n" +
            "  i = 0;\n" +
            "\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  flag = TRUE;\t\t\t\t/* Set the bits in this pass\t*/\n" +
            "\n" +
            "  while( x < vp.right-2 ){\t\t/* Draw lines across the screen */\n" +
            "\n" +
            "    if( flag )\t\t\t\t/* If flag, set bits... \t*/\n" +
            "      style = style | (1 << i); \t/*    Set the Ith bit in word\t*/\n" +
            "    else\t\t\t\t/* If no flag, clear bits\t*/\n" +
            "    style = style & !(0x8000 >> i);\t/*    Clear the Ith bit in word */\n" +
            "\n" +
            "    setlinestyle( USERBIT_LINE, style, NORM_WIDTH );\n" +
            "    line( x, y, x, h-y );\t\t/* Draw the new line pattern\t*/\n" +
            "\n" +
            "    x += 5;\t\t\t\t/* Move the X location of line\t*/\n" +
            "    i = ++i % 16;\t\t\t/* Advance to next bit pattern\t*/\n" +
            "\n" +
            "    if( style == 0xffff ){\t\t/* Are all bits set?\t\t*/\n" +
            "      flag = FALSE;\t\t\t/*   begin removing bits\t*/\n" +
            "      i = 0;\t\t\t\t/* Start with whole pattern\t*/\n" +
            "    }\n" +
            "    else{\t\t\t\t/* Bits not all set...\t\t*/\n" +
            "      if( style == 0 )\t\t\t/* Are all bits clear?\t\t*/\n" +
            "\tflag = TRUE;\t\t\t/*   begin setting bits \t*/\n" +
            "    }\n" +
            "  }\n" +
            "\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tFILLSTYLEDEMO: Display the standard fill patterns available.\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void FillStyleDemo(void)\n" +
            "{\n" +
            "  int h, w, style;\n" +
            "  int i, j, x, y;\n" +
            "  struct viewporttype vp;\n" +
            "  char buffer[40];\n" +
            "\n" +
            "  MainWindow( \"Pre-defined Fill Styles\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  w = 2 * ((vp.right  +  1) / 13);\n" +
            "  h = 2 * ((vp.bottom - 10) / 10);\n" +
            "\n" +
            "  x = w / 2;\n" +
            "  y = h / 2;\t\t/* Leave 1/2 blk margin \t*/\n" +
            "  style = 0;\n" +
            "\n" +
            "  for( j=0 ; j<3 ; ++j ){\t\t/* Three rows of boxes\t\t*/\n" +
            "    for( i=0 ; i<4 ; ++i ){\t\t/* Four column of boxes \t*/\n" +
            "      setfillstyle(style, MaxColors-1); /* Set the fill style and WHITE */\n" +
            "      bar( x, y, x+w, y+h );\t\t/* Draw the actual box\t\t*/\n" +
            "      rectangle( x, y, x+w, y+h );\t/* Outline the box\t\t*/\n" +
            "      itoa( style, buffer, 10 );\t/* Convert style 3 to ASCII\t*/\n" +
            "      outtextxy( x+(w / 2), y+h+4, buffer );\n" +
            "      ++style;\t\t\t\t/* Go on to next style #\t*/\n" +
            "      x += (w / 2) * 3; \t\t/* Go to next column\t\t*/\n" +
            "    }\t\t\t\t/* End of coulmn loop\t\t*/\n" +
            "    x = w / 2;\t\t\t\t/* Put base back to 1st column\t*/\n" +
            "    y += (h / 2) * 3;\t\t\t/* Advance to next row\t\t*/\n" +
            "  }\t\t\t\t\t/* End of Row loop\t\t*/\n" +
            "\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tFILLPATTERNDEMO: Demonstrate how to use the user definable\t*/\n" +
            "/*\tfill patterns.\t\t\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void FillPatternDemo(void)\n" +
            "{\n" +
            "  int style;\n" +
            "  int h, w;\n" +
            "  int x, y, i, j;\n" +
            "  char buffer[40];\n" +
            "  struct viewporttype vp;\n" +
            "  static char patterns[][8] = {\n" +
            "    { 0xAA, 0x55, 0xAA, 0x55, 0xAA, 0x55, 0xAA, 0x55 },\n" +
            "    { 0x33, 0x33, 0xCC, 0xCC, 0x33, 0x33, 0xCC, 0xCC },\n" +
            "    { 0xF0, 0xF0, 0xF0, 0xF0, 0x0F, 0x0F, 0x0F, 0x0F },\n" +
            "    { 0x00, 0x10, 0x28, 0x44, 0x28, 0x10, 0x00, 0x00 },\n" +
            "    { 0x00, 0x70, 0x20, 0x27, 0x24, 0x24, 0x07, 0x00 },\n" +
            "    { 0x00, 0x00, 0x00, 0x18, 0x18, 0x00, 0x00, 0x00 },\n" +
            "    { 0x00, 0x00, 0x3C, 0x3C, 0x3C, 0x3C, 0x00, 0x00 },\n" +
            "    { 0x00, 0x7E, 0x7E, 0x7E, 0x7E, 0x7E, 0x7E, 0x00 },\n" +
            "    { 0x00, 0x00, 0x22, 0x08, 0x00, 0x22, 0x1C, 0x00 },\n" +
            "    { 0xFF, 0x7E, 0x3C, 0x18, 0x18, 0x3C, 0x7E, 0xFF },\n" +
            "    { 0x00, 0x10, 0x10, 0x7C, 0x10, 0x10, 0x00, 0x00 },\n" +
            "    { 0x00, 0x42, 0x24, 0x18, 0x18, 0x24, 0x42, 0x00 }\n" +
            "  };\n" +
            "\n" +
            "  MainWindow( \"User Defined Fill Styles\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  w = 2 * ((vp.right  +  1) / 13);\n" +
            "  h = 2 * ((vp.bottom - 10) / 10);\n" +
            "\n" +
            "  x = w / 2;\n" +
            "  y = h / 2;\t\t/* Leave 1/2 blk margin \t*/\n" +
            "  style = 0;\n" +
            "\n" +
            "  for( j=0 ; j<3 ; ++j ){\t\t/* Three rows of boxes\t\t*/\n" +
            "    for( i=0 ; i<4 ; ++i ){\t\t/* Four column of boxes \t*/\n" +
            "      setfillpattern( &patterns[style][0], MaxColors-1 );\n" +
            "      bar( x, y, x+w, y+h );\t\t/* Draw the actual box\t\t*/\n" +
            "      rectangle( x, y, x+w, y+h );\t/* Outline the box\t\t*/\n" +
            "      itoa( style, buffer, 10 );\t/* Convert style 3 to ASCII\t*/\n" +
            "      outtextxy( x+(w / 2), y+h+4, buffer );\n" +
            "      ++style;\t\t\t\t/* Go on to next style #\t*/\n" +
            "      x += (w / 2) * 3; \t\t/* Go to next column\t\t*/\n" +
            "    }\t\t\t\t/* End of coulmn loop\t\t*/\n" +
            "    x = w / 2;\t\t\t\t/* Put base back to 1st column\t*/\n" +
            "    y += (h / 2) * 3;\t\t\t/* Advance to next row\t\t*/\n" +
            "  }\t\t\t\t\t/* End of Row loop\t\t*/\n" +
            "\n" +
            "  settextjustify( LEFT_TEXT, TOP_TEXT );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tPOLYDEMO: Display a random pattern of polygons on the screen\t*/\n" +
            "/*\tuntil the user says enough.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void PaletteDemo(void)\n" +
            "{\n" +
            "  int i, j, x, y, color;\n" +
            "  struct viewporttype vp;\n" +
            "  int height, width;\n" +
            "\n" +
            "  MainWindow( \"Palette Demonstration\" );\n" +
            "  StatusLine( \"Press any key to continue, ESC to Abort\" );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  width  = (vp.right - vp.left) / 15;\t/* get width of the box \t*/\n" +
            "  height = (vp.bottom - vp.top) / 10;\t/* Get the height of the box\t*/\n" +
            "\n" +
            "  x = y = 0;\t\t\t\t/* Start in upper corner\t*/\n" +
            "  color = 1;\t\t\t\t/* Begin at 1st color\t\t*/\n" +
            "\n" +
            "  for( j=0 ; j<10 ; ++j ){\t\t/* For 10 rows of boxes \t*/\n" +
            "    for( i=0 ; i<15 ; ++i ){\t\t/* For 15 columns of boxes\t*/\n" +
            "      setfillstyle( SOLID_FILL, color++ );\t/* Set the color of box */\n" +
            "      bar( x, y, x+width, y+height );\t\t/* Draw the box \t*/\n" +
            "      x += width + 1;\t\t\t\t/* Advance to next col\t*/\n" +
            "      color = 1 + (color % (MaxColors - 2));\t/* Set new color\t*/\n" +
            "    }\t\t\t\t/* End of COLUMN loop\t\t*/\n" +
            "    x = 0;\t\t\t\t/* Goto 1st column\t\t*/\n" +
            "    y += height + 1;\t\t\t/* Goto next row\t\t*/\n" +
            "  }\t\t\t\t\t/* End of ROW loop\t\t*/\n" +
            "\n" +
            "  while( !kbhit() ){\t\t\t/* Until user enters a key...\t*/\n" +
            "    setpalette( 1+random(MaxColors - 2), random( 65 ) );\n" +
            "  }\n" +
            "\n" +
            "  setallpalette( &palette );\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tPOLYDEMO: Display a random pattern of polygons on the screen\t*/\n" +
            "/*\tuntil the user says enough.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "#define MaxPts\t\t6\t\t/* Maximum # of pts in polygon\t*/\n" +
            "\n" +
            "void PolyDemo(void)\n" +
            "{\n" +
            "  struct PTS poly[ MaxPts ];\t\t/* Space to hold datapoints\t*/\n" +
            "  int color;\t\t\t\t/* Current drawing color\t*/\n" +
            "  int i;\n" +
            "\n" +
            "  MainWindow( \"DrawPoly / FillPoly Demonstration\" );\n" +
            "  StatusLine( \"ESC Aborts - Press a Key to stop\" );\n" +
            "\n" +
            "  while( !kbhit() ){\t\t\t/* Repeat until a key is hit\t*/\n" +
            "\n" +
            "    color = 1 + random( MaxColors-1 );\t/* Get a random color # (no blk)*/\n" +
            "    setfillstyle( random(10), color );\t/* Set a random line style\t*/\n" +
            "    setcolor( color );\t\t\t/* Set the desired color\t*/\n" +
            "\n" +
            "    for( i=0 ; i<(MaxPts-1) ; i++ ){\t/* Determine a random polygon\t*/\n" +
            "      poly[i].x = random( MaxX );\t/* Set the x coord of point\t*/\n" +
            "      poly[i].y = random( MaxY );\t/* Set the y coord of point\t*/\n" +
            "    }\n" +
            "\n" +
            "    poly[i].x = poly[0].x;\t\t/* last point = first point\t*/\n" +
            "    poly[i].y = poly[1].y;\n" +
            "\n" +
            "    fillpoly( MaxPts, (int far *)poly );    /* Draw the actual polygon\t    */\n" +
            "  }\t\t\t\t\t/* End of WHILE not KBHIT\t*/\n" +
            "\n" +
            "  Pause();\t\t\t\t/* Wait for user's response     */\n" +
            "\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tSAYGOODBYE: Give a closing screen to the user before leaving.\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void SayGoodbye(void)\n" +
            "{\n" +
            "  struct viewporttype viewinfo; \t/* Structure to read viewport\t*/\n" +
            "  int h, w;\n" +
            "\n" +
            "  MainWindow( \"== Finale ==\" );\n" +
            "\n" +
            "  getviewsettings( &viewinfo ); \t/* Read viewport settings\t*/\n" +
            "  changetextstyle( TRIPLEX_FONT, HORIZ_DIR, 4 );\n" +
            "  settextjustify( CENTER_TEXT, CENTER_TEXT );\n" +
            "\n" +
            "  h = viewinfo.bottom - viewinfo.top;\n" +
            "  w = viewinfo.right  - viewinfo.left;\n" +
            "  outtextxy( w/2, h/2, \"That's all, folks!\" );\n" +
            "\n" +
            "  StatusLine( \"Press any key to EXIT\" );\n" +
            "  getch();\n" +
            "\n" +
            "  cleardevice();\t\t\t/* Clear the graphics screen\t*/\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tPAUSE: Pause until the user enters a keystroke. If the\t\t*/\n" +
            "/*\tkey is an ESC, then exit program, else simply return.\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void Pause(void)\n" +
            "{\n" +
            "  static char msg[] = \"Esc aborts or press a key...\";\n" +
            "  int c;\n" +
            "\n" +
            "  StatusLine( msg );\t\t\t/* Put msg at bottom of screen\t*/\n" +
            "\n" +
            "  c = getch();\t\t\t\t/* Read a character from kbd\t*/\n" +
            "\n" +
            "  if( ESC == c ){\t\t\t/* Does user wish to leave?\t*/\n" +
            "    closegraph();\t\t\t/* Change to text mode\t\t*/\n" +
            "    exit( 1 );\t\t\t\t/* Return to OS \t\t*/\n" +
            "  }\n" +
            "\n" +
            "  if( 0 == c ){ \t\t\t/* Did use hit a non-ASCII key? */\n" +
            "    c = getch();\t\t\t/* Read scan code for keyboard\t*/\n" +
            "  }\n" +
            "\n" +
            "  cleardevice();\t\t\t/* Clear the screen\t\t*/\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tMAINWINDOW: Establish the Text window for the demo and set\t*/\n" +
            "/*\ta viewport for the demo code.\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void MainWindow( char *header )\n" +
            "{\n" +
            "  int height;\n" +
            "\n" +
            "  cleardevice();\t\t\t/* Clear graphics screen\t*/\n" +
            "  setcolor( MaxColors - 1 );\t\t/* Set current color to white\t*/\n" +
            "  setviewport( 0, 0, MaxX, MaxY, 1 );\t/* Open port to full screen\t*/\n" +
            "\n" +
            "  height = textheight( \"H\" );           /* Get basic text height        */\n" +
            "\n" +
            "  changetextstyle( DEFAULT_FONT, HORIZ_DIR, 1 );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  outtextxy( MaxX/2, 2, header );\n" +
            "  setviewport( 0, height+4, MaxX, MaxY-(height+4), 1 );\n" +
            "  DrawBorder();\n" +
            "  setviewport( 1, height+5, MaxX-1, MaxY-(height+5), 1 );\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tSTATUSLINE: Display a status line at the bottom of the screen.\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void StatusLine( char *msg )\n" +
            "{\n" +
            "  int height;\n" +
            "\n" +
            "  setviewport( 0, 0, MaxX, MaxY, 1 );\t/* Open port to full screen\t*/\n" +
            "  setcolor( MaxColors - 1 );\t\t/* Set current color to white\t*/\n" +
            "\n" +
            "  changetextstyle( DEFAULT_FONT, HORIZ_DIR, 1 );\n" +
            "  settextjustify( CENTER_TEXT, TOP_TEXT );\n" +
            "  setlinestyle( SOLID_LINE, 0, NORM_WIDTH );\n" +
            "  setfillstyle( EMPTY_FILL, 0 );\n" +
            "\n" +
            "  height = textheight( \"H\" );           /* Detemine current height      */\n" +
            "  bar( 0, MaxY-(height+4), MaxX, MaxY );\n" +
            "  rectangle( 0, MaxY-(height+4), MaxX, MaxY );\n" +
            "  outtextxy( MaxX/2, MaxY-(height+2), msg );\n" +
            "  setviewport( 1, height+5, MaxX-1, MaxY-(height+5), 1 );\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tDRAWBORDER: Draw a solid single line around the current \t*/\n" +
            "/*\tviewport.\t\t\t\t\t\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void DrawBorder(void)\n" +
            "{\n" +
            "  struct viewporttype vp;\n" +
            "\n" +
            "  setcolor( MaxColors - 1 );\t\t/* Set current color to white\t*/\n" +
            "\n" +
            "  setlinestyle( SOLID_LINE, 0, NORM_WIDTH );\n" +
            "\n" +
            "  getviewsettings( &vp );\n" +
            "  rectangle( 0, 0, vp.right-vp.left, vp.bottom-vp.top );\n" +
            "\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tCHANGETEXTSTYLE: similar to settextstyle, but checks for\t*/\n" +
            "/*\terrors that might occur whil loading the font file.\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "void changetextstyle(int font, int direction, int charsize)\n" +
            "{\n" +
            "  int ErrorCode;\n" +
            "\n" +
            "  graphresult();\t\t\t/* clear error code\t\t*/\n" +
            "  settextstyle(font, direction, charsize);\n" +
            "  ErrorCode = graphresult();\t\t/* check result \t\t*/\n" +
            "  if( ErrorCode != grOk ){\t\t/* if error occured\t\t*/\n" +
            "    closegraph();\n" +
            "    printf(\" Graphics System Error: %s\\n\", grapherrormsg( ErrorCode ) );\n" +
            "    exit( 1 );\n" +
            "  }\n" +
            "}\n" +
            "\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "/*\tGPRINTF: Used like PRINTF except the output is sent to the\t*/\n" +
            "/*\tscreen in graphics mode at the specified co-ordinate.\t\t*/\n" +
            "/*\t\t\t\t\t\t\t\t\t*/\n" +
            "\n" +
            "int gprintf( int *xloc, int *yloc, char *fmt, ... )\n" +
            "{\n" +
            "  va_list  argptr;\t\t\t/* Argument list pointer\t*/\n" +
            "  char str[140];\t\t\t/* Buffer to build sting into\t*/\n" +
            "  int cnt;\t\t\t\t/* Result of SPRINTF for return */\n" +
            "\n" +
            "  va_start( argptr, fmt );\t\t/* Initialize va_ functions\t*/\n" +
            "\n" +
            "  cnt = vsprintf( str, fmt, argptr );\t/* prints string to buffer\t*/\n" +
            "  outtextxy( *xloc, *yloc, str );\t/* Send string in graphics mode */\n" +
            "  *yloc += textheight( \"H\" ) + 2;       /* Advance to next line         */\n" +
            "\n" +
            "  va_end( argptr );\t\t\t/* Close va_ functions\t\t*/\n" +
            "\n" +
            "  return( cnt );\t\t\t/* Return the conversion count\t*/\n" +
            "\n" +
            "}";

    public static void main(String[] args) {
        try(InputStream inputStream = new ByteArrayInputStream(INPUT.getBytes(StandardCharsets.UTF_8));
            Stream<String> s = new BufferedReader(new InputStreamReader(inputStream)).lines();
        ){
            processStream(s);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        if (args.length == 0 || Objects.equals(args[0], "-")) {
//            s = new BufferedReader(new InputStreamReader(System.in)).lines();
//        } else {
//            Path p = Paths.get(args[0]);
//            if (!Files.isRegularFile(p)) {
//                System.err.println(p + " is not a valid file!");
//                System.exit(1);
//            }
//            try {
//                s = Files.lines(p);
//            } catch (IOException e) {
//                System.err.println("Failed to open " + p);
//                System.exit(2);
//            }
//        }

    }

    private static void processStream(Stream<String> s) {
        Stream<String> lines = Prepreprocessor.preprocess(s);
        Stream<Pretokenizer.Token> tokens = new Pretokenizer(lines).getTokens();
        tokens.forEach(token ->
            System.out.println(token.type.name() + " :: \"" + token.value + "\"")
        );
    }
}