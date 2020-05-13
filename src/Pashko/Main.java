package Pashko;

import java.util.*;

public class Main {
    private static final boolean no1Max = false;

    private static final double no1AreaLength = 1;
    private static final double[] no1AreaCenter = {0, 0};
    private static final double[][] no1AreaPoints = {{no1AreaCenter[0]+ no1AreaLength /2, no1AreaCenter[1]}, {no1AreaCenter[0]- no1AreaLength /2, no1AreaCenter[1]},
            {no1AreaCenter[0], no1AreaCenter[1]+ no1AreaLength /2}, {no1AreaCenter[0], no1AreaCenter[1]- no1AreaLength /2}};

    private static final int Nno1Random = 1000000;

    private static final int Nno1GeneticRound = 100;
    private static final int Nno1GeneticInitialization = 100000;
    private static final int Nno1GeneticSelection = 1000;
    private static final int Nno1GeneticCrossover = 500;
    private static final int Nno1GeneticCrossoverTop = 500;
    private static final int Nno1GeneticMutation = 500;
    private static final int Nno1GeneticMutationBot = 500;
    private static final double Nno1GeneticE = 0.00001;


    private static final int no2Versh = 6;
    private static final int[][] no2Graph = new int[][] {{1, 2, 7}, {1, 3, 9}, {1, 6, 14}, {2, 3, 10}, {2, 4, 15}, {3, 4, 11}, {3, 6, 2}, {4, 5, 6}, {5, 6, 9},
            {2, 1, 7}, {3, 1, 9}, {6, 1, 14}, {3, 2, 10}, {4, 2, 15}, {4, 3, 11}, {6, 3, 2}, {5, 4, 6}, {6, 5, 9}};

    private static final int no2AntPop= 1000;
    private static final int no2AntA = 10;
    private static final int no2AntB = 1;
    private static final int no2AntK = 10;
    private static final double no2AntP = 0.1;

    public static void main(String[] args){
        //no1();
        no2();
    }

    public static void no1(){
        double[] resRandom = no1Random(no1Max);
        double[] resGenetic = no1Genetic(no1Max);
        System.out.println(resRandom[0]);
        System.out.println(resRandom[1]);
        System.out.println(resRandom[2]);
        System.out.println();
        System.out.println(resGenetic[0]);
        System.out.println(resGenetic[1]);
        System.out.println(resGenetic[2]);
    }

    private static double no1func(double x1, double x2){
        return Math.pow(x1, 3)+Math.pow(x2, 3);
    }

    private static boolean no1area(double x1, double x2){
        int i = 0;
        for(double[] point: no1AreaPoints) if( Math.pow(x1-point[0], 2) + Math.pow(x2-point[1], 2) <= Math.pow(no1AreaLength /2, 2)) if(++i>1) return true;
        return false;
    }

    public static double[] no1Random(boolean max){
        double x1, x2, y, x1r= no1AreaCenter[0], x2r= no1AreaCenter[1], yr=no1func(x1r, x2r);
        for(int i = 0; i < Nno1Random; i++){
            x1 = (Math.random()* no1AreaLength)+ no1AreaCenter[0]- no1AreaLength /2;
            x2 = (Math.random()* no1AreaLength)+ no1AreaCenter[1]- no1AreaLength /2;
            if(no1area(x1, x2)){
                y = no1func(x1, x2);
                if(max && y>yr || (!max) && y<yr){
                    x1r = x1;
                    x2r = x2;
                    yr = y;
                }
            }
        }
        return new double[] {x1r, x2r, yr};
    }

    public static double[] no1Genetic(boolean max){
        List<double[]> selectus = new ArrayList<>();
        double x1, x2, y;
        for(int i = 0; i < Nno1GeneticInitialization; i++){
            x1 = (Math.random()* no1AreaLength)+ no1AreaCenter[0]- no1AreaLength /2;
            x2 = (Math.random()* no1AreaLength)+ no1AreaCenter[1]- no1AreaLength /2;
            if(no1area(x1, x2)){
                y = no1func(x1, x2);
                selectus.add(new double[] {x1, x2, y});
            }
        }
        selectus.sort((doubles, t1) -> (max ? (doubles[2] - t1[2]) : (t1[2] - doubles[2]))>0?1:((max ? (doubles[2] - t1[2]) : (t1[2] - doubles[2]))<0?-1:0));
        double round = 0;
        double[] topEl;
        do{
            topEl = selectus.get(selectus.size()-1);
            double selectionSize = selectus.size();
            double selection1;
            double selection2;
            int selectionInd;
            while(selectionSize>Nno1GeneticSelection){
                selection1 = Math.random();
                selection2 = 0;
                selectionInd = 0;
                while(selection2<selection1){
                    selectionInd++;
                    selection2 += (2.0/selectionSize)*(1 - ((double)(selectionInd-1))/(selectionSize-1));
                }
                selectus.remove(selectionInd);
                selectionSize = selectus.size();
            }
            int crossoverInd1, crossoverInd2;
            for(int i = 0; i < Nno1GeneticCrossover; i++){
                crossoverInd1 = Nno1GeneticSelection - 1 -(int)(Math.random()*Nno1GeneticCrossoverTop);
                crossoverInd2 = crossoverInd1+(int)(Math.random()*(Nno1GeneticCrossoverTop-1)+1);
                if(crossoverInd2>=Nno1GeneticSelection) crossoverInd2 = crossoverInd2 - Nno1GeneticCrossoverTop;

                if(no1area(selectus.get(crossoverInd1)[0], selectus.get(crossoverInd2)[1])){
                    selectus.add(new double[] {selectus.get(crossoverInd1)[0], selectus.get(crossoverInd2)[1], no1func(selectus.get(crossoverInd1)[0], selectus.get(crossoverInd2)[1])});
                }
            }
            int mutationInd;
            for(int i = 0; i < Nno1GeneticMutation; i++){
                mutationInd = (int)(Math.random()*Nno1GeneticMutationBot);
                if(no1area(selectus.get(mutationInd)[1], selectus.get(mutationInd)[0])){
                    selectus.add(new double[] {selectus.get(mutationInd)[1], selectus.get(mutationInd)[0], no1func(selectus.get(mutationInd)[1], selectus.get(mutationInd)[0])});
                }
            }
            selectus.sort((doubles, t1) -> (max ? (doubles[2] - t1[2]) : (t1[2] - doubles[2]))>0?1:((max ? (doubles[2] - t1[2]) : (t1[2] - doubles[2]))<0?-1:0));
        } while ((max && selectus.get(selectus.size()-1)[2]-topEl[2]>Nno1GeneticE || (!max) && topEl[2]-selectus.get(selectus.size()-1)[2]>Nno1GeneticE) || round++<Nno1GeneticRound);
        return selectus.get(selectus.size()-1);
    }

    public static void no2(){
        System.out.println(no2Ant(1, 4));
    }

    public static int no2Dijkstra(int st, int fn){
        int[] metki = new int[no2Versh];
        for(int i = 1; i <= no2Versh; i++){
            if(i==st) metki[i-1] = 0;
            else metki[i-1] = -1;
        }
        Set<Integer> visited = new HashSet<>();
        int targetMetka;
        int target;
        while(visited.size()!= no2Versh){
            targetMetka = -1;
            target = -1;
            for(int i = 1; i <= no2Versh; i++){
                if(!visited.contains(i) && metki[i-1]>=0 && (metki[i-1]<targetMetka || targetMetka<0)) {
                    target = i;
                    targetMetka = metki[i-1];
                }
            }
            for(int[] rule: no2Graph){
                if(rule[0]==target && !visited.contains(rule[1]) && (metki[rule[1]-1]>(targetMetka+rule[2]) || metki[rule[1]-1]<0)){
                    metki[rule[1]-1] = targetMetka+rule[2];
                }
            }
            visited.add(target);
        }
        return metki[fn-1];
    }

    public static int no2Ant(int st, int fn){
        List<List<Integer>> pop = new ArrayList<>();
        List<List<Integer>> fin = new ArrayList<>();
        List<Integer> newbie;
        double rand1;
        double rand2;
        double sum;
        double[] pheromone = new double[no2Graph.length];
        for(int i =0; i < no2AntPop; i++){
            newbie = new ArrayList<>();
            newbie.add(0);
            newbie.add(st);
            pop.add(newbie);

            for(List<Integer> ant: pop){
                rand1 = Math.random();
                rand2 = 0;
                sum = 0;
                for(int j = 0; j < no2Graph.length; j++){
                    if(no2Graph[j][0]==ant.get(ant.size()-1) && ant.lastIndexOf(no2Graph[j][1])<1 ){
                        sum += Math.pow(pheromone[j], no2AntA) + 1.0/(Math.pow(no2Graph[j][2], no2AntB));
                    }
                }
                rand1 *= sum;
                int j;
                for(j = 0; rand2 < rand1; j++){
                    if(no2Graph[j][0]==ant.get(ant.size()-1) && ant.lastIndexOf(no2Graph[j][1])<1 ){
                        rand2 += Math.pow(pheromone[j], no2AntA) + 1.0/Math.pow(no2Graph[j][2], no2AntB);
                    }
                }
                if(j==-1) j++;
                ant.add(no2Graph[j-1][1]);
                ant.set(0, ant.get(0)+no2Graph[j-1][2]);
            }

            for(int j = 0; j < pheromone.length; j++){
                pheromone[j] = pheromone[j]*(1-no2AntP);
            }

            int len;
            int prev;
            for(List<Integer> ant: pop){
                if(ant.get(ant.size()-1)==fn){
                    len = ant.get(0);
                    prev = ant.get(1);
                    ant.remove(0);
                    ant.remove(0);
                    for(int node: ant){
                        for(int j = 0; j < no2Graph.length; j++){
                            if(no2Graph[j][0]==prev && no2Graph[j][1]==node){
                                pheromone[j] += ((double)no2AntK)/len;
                            }
                        }
                        prev = node;
                    }
                    fin.add(ant);
                }
            }
            pop.removeAll(fin);
            fin.clear();
        }

        int point = st;
        int finlen = 0;
        double finpheromon;
        int finpheromonind = 0;
        while(point != fn){
            finpheromon = 0;
            for(int i = 0; i < no2Graph.length; i++){
                if(no2Graph[i][0]==point && finpheromon<pheromone[i]){
                    finpheromon = pheromone[i];
                    finpheromonind = i;
                }
            }
            point = no2Graph[finpheromonind][1];
            finlen += no2Graph[finpheromonind][2];
        }
        return finlen;
    }
}
