package StavrLine;

public class Turbo {

    static int NO_OF_CHARS = 256;

    static void computeTransFun(char[] pat,
                                int M, int TF[][])
    {
        int i, lps = 0, x;


        for (x = 0; x < NO_OF_CHARS; x++)
        {
            TF[0][x] = 0;
        }
        TF[0][pat[0]] = 1;

        for (i = 1; i < M; i++)
        {
            for (x = 0; x < NO_OF_CHARS; x++)
            {
                TF[i][x] = TF[lps][x];
            }

            TF[i][pat[i]] = i + 1;


            if (i < M)
            {
                lps = TF[lps][pat[i]];
            }
        }
    }


    static void turbo(char pat[], char txt[])
    {
        int M = pat.length;
        int N = txt.length;

        int[][] TF = new int[M + 1][NO_OF_CHARS];

        computeTransFun(pat, M, TF);

        // process text over FA.
        int i, j = 0;
        for (i = 0; i < N; i++)
        {
            j = TF[j][txt[i]];
            if (j == M)
            {
                System.out.println("Pattern found at index " +
                        (i - M + 1));
            }
        }
    }





}
