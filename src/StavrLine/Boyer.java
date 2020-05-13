package StavrLine;

public class Boyer {
    static int NO_OF_CHARS = 256;

    static int max (int a, int b) { return (a > b)? a: b; }
    static void badCharHeuristic( char []str, int size,int badchar[])
    {
        int i;


        for (i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;


        for (i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    static void boyer(  char pat[],char txt[])
    {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

        badCharHeuristic(pat, m, badchar);

        int s = 0;

        while(s <= (n - m))
        {
            int j = m-1;
            while(j >= 0 && pat[j] == txt[s+j])
                j--;
            if (j < 0)
            {
                System.out.println("Pattern found at index " + s);
                s += (s+m < n)? m-badchar[txt[s+m]] : 1;

            }

            else
                s += max(1, j - badchar[txt[s+j]]);
        }
    }
}
