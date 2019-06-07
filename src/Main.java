import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int N=36678;
        System.out.println("N: "+N);
        int M=210;
        System.out.println("M: "+M);
        int T=203;
        System.out.println("T: "+T);
        HashSet<String> A=new HashSet<String>();
        A.add("a");
        A.add("b");
        A.add("c");
        A.add("d");
        A.add("e");
        A.add("f");
        A.add("g");
        A.add("h");

        HashSet<String> B=new HashSet<>();
        B.add("a");
        B.add("b");
        B.add("f");
        B.add("g");
        B.add("h");

        System.out.println("A size: "+A.size());
        System.out.println("A: "+A);
        System.out.println("B size: "+B.size());
        System.out.println("B: "+B);
        System.out.println();
        System.out.println("Build bijection from A to {1,2,...,n}");
        Iterator iterator=A.iterator();
        for(int u=1;u<=A.size();u++){
            System.out.println(iterator.next()+"<->"+u);
        }
        CalculationWorkOnCombinatoricAlgorithms algorithms=new CalculationWorkOnCombinatoricAlgorithms(N,M,T,A);
        System.out.println("-----------------------------------------");
        System.out.println("N in FactorialNumberSystem: "+algorithms.decimalToFactorialNumeralSystem(N));
        String p1=algorithms.generatePermutationByIndex();
        System.out.println("Permutation by index "+N+" : "+p1);
        System.out.println();
        String p2=algorithms.getNextLexographicPermutation(p1);
        System.out.println("p2: "+p2);
        System.out.println();
        String p3=algorithms.getNextLexographicPermutation(p2);
        System.out.println("p3: "+p3);
        System.out.println();
        String p4=algorithms.getNextLexographicPermutation(p3);
        System.out.println("p4: "+p4);
        System.out.println();
        System.out.println("Index of p4: "+algorithms.getIndexOfPermutation(p4));
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Using method minimal change: ");
        algorithms.minimalPermutationMethod(p1,4);
        System.out.println();
        System.out.println("-----------------------------------------");
        String subset=algorithms.generateSubsetByLexograpicNumber();
        System.out.println("Subset by lexographic number: "+subset);
        System.out.println();
        System.out.println("B: "+B);
        System.out.println("Lexographic number of B: "+algorithms.getLexographicNumber(B));
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println(T+" code Gray: "+algorithms.generate8bitCodeGray());
        System.out.println();
        System.out.println((T+1)+" code Gray: "+algorithms.generate8bitCodeGray(T+1));
        System.out.println();
        System.out.println((T+2)+" code Gray: "+algorithms.generate8bitCodeGray(T+2));
        System.out.println();
        System.out.println((T+3)+" code Gray: "+algorithms.generate8bitCodeGray(T+3));
        System.out.println();
        System.out.println("-----------------------------------------");
        String subset1=algorithms.getNextLexographicPermutation(subset);
        System.out.println("Next permutation of subset: "+subset1);
        System.out.println();
        String subset2=algorithms.getNextLexographicPermutation(subset1);
        System.out.println("Next permutation of subset: "+subset2);
        System.out.println();
        String subset3=algorithms.getNextLexographicPermutation(subset2);
        System.out.println("Next permutation of subset: "+subset3);
        System.out.println();
        algorithms.geretareAllWordsLessThanN(A,4);
        System.out.println();
        algorithms.generateRandomWordLessThanN(A,4);
    }
}
