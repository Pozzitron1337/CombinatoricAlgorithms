import java.util.*;
import java.util.regex.*;

public class CalculationWorkOnCombinatoricAlgorithms {
    private int N;
    private int M;
    private int T;
    private int order;
    private HashSet<String> set;

    CalculationWorkOnCombinatoricAlgorithms(int N, int M, int T,HashSet<String> set){
        this.N=N;
        this.M=M;
        this.T=T;
        this.set=set;
        this.order=set.size();
    }

    public int factorial(int n){
        if(n<0)
            throw new IllegalArgumentException("value n="+n+" is negative");
        int result=1;
        for(int i=1;i<=n;i++){
            result=result*i;
        }
        return result;
    }

    public int decimalToFactorialNumeralSystem(int decimalNumber){
        String result="";
        if(decimalNumber==1){
            return 1;
        }
        if(decimalNumber==0)
            return 0;
        if(decimalNumber<0){
            result+="-";
        }
        ArrayList<Integer> factorials=new ArrayList<Integer>();
        factorials.add(1);
        int n=0;
        while(factorials.get(n)<decimalNumber){
            factorials.add(factorials.get(n)*(n+1));
            n++;
        }
        //this.factorials=factorials;
        int q=decimalNumber;
        if(q==factorials.get(n)){
            result+="1";
            for(int i=1;i<n;i++)
                result+="0";
            return Integer.parseInt(result);
        }
        for(int i=n-1;i>0;i--){
            result+=q/(factorials.get(i));
            q%=(factorials.get(i));
        }
        return Integer.parseInt(result);
    }

    public String generatePermutationByIndex(){
        if(N<0)
            throw new NullPointerException("N is negative");
        int index=N;
        int factorialNumber= decimalToFactorialNumeralSystem(index);
        //System.out.println("Fact num: "+factorialNumber);
        int n=order;
        int permutation[]=new int[n];
        int permutationTemp[]=new int[n];
        permutation[0]=1;
        for(int k=1;k<n;k++){
            permutationTemp[0]=(factorialNumber%10)+1;
            factorialNumber/=10;
            for(int j=1;j<=k;j++){
                if(permutation[j-1]<permutationTemp[0]){
                    permutationTemp[j]=permutation[j-1];
                }
                else {
                    permutationTemp[j] = permutation[j - 1] + 1;
                }
            }
            for(int i=0;i<n;i++){
                permutation[i]=permutationTemp[i];
            }
            /*for(int i=0;i<=k;i++){
                System.out.print(permutation[i]+" ");
            }*/
            //System.out.println();
        }

        return Arrays.toString(permutation);//.replaceAll("[\\[, \\]]", "");//removes symbols {'[',']',',',' '}
    }

    public String generatePermutationByIndex(int index,int ord){
        if(index<0)
            throw new NullPointerException("N is negative");
        int factorialNumber= decimalToFactorialNumeralSystem(index);
        //System.out.println("Fact num: "+factorialNumber);
        int n=ord;
        int permutation[]=new int[n];
        int permutationTemp[]=new int[n];
        permutation[0]=1;
        for(int k=1;k<n;k++){
            permutationTemp[0]=(factorialNumber%10)+1;
            factorialNumber/=10;
            for(int j=1;j<=k;j++){
                if(permutation[j-1]<permutationTemp[0]){
                    permutationTemp[j]=permutation[j-1];
                }
                else {
                    permutationTemp[j] = permutation[j - 1] + 1;
                }
            }
            for(int i=0;i<n;i++){
                permutation[i]=permutationTemp[i];
            }

        }
        return Arrays.toString(permutation);//.replaceAll("[\\[, \\]]", "");//removes symbols {'[',']',',',' '}
    }

    public String getNextLexographicPermutation(String permutation){
       // System.out.println(permutation);
        int p[]=new int [order];
        Pattern pattern=Pattern.compile("([^\\[, \\]]+)");
        Matcher matcher=pattern.matcher(permutation);
        boolean match=matcher.find();
        int length=0;
        for (int i=0;match;i++) {
            p[i]=Integer.parseInt(matcher.group(1));
            match=matcher.find();
            length++;
        }

        if(length!=order){
            int t[]=new int[length];
            for(int i=0;i<length;i++){
                t[i]=p[i];
            }
            p=new int [length];
            for(int i=0;i<length;i++){
                p[i]=t[i];
            }
        }

        for(int i=length-1;i>0;i--){
            if(p[i]<p[i-1]){
                continue;
            }
            else{
                int minindex=length-1;
                for(int j=length-1;j>i-1;j--){
                    if(p[i-1]<p[j]){
                        minindex=j;
                        break;
                    }
                    else{
                        continue;
                    }
                }
                int temp=p[i-1];
                p[i-1]=p[minindex];
                p[minindex]=temp;
                //break;
                for(int k=length-1;k>i;k--){
                    temp=p[k];
                    p[k]=p[i];
                    p[i]=temp;
                    i++;
                }
                break;
            }

        }
        return Arrays.toString(p);
    }

    public int getIndexOfPermutation(String permutation){
        //System.out.println(permutation);
        int p[]=new int [order];
        Pattern pattern=Pattern.compile("([^\\[, \\]]+)");
        Matcher matcher=pattern.matcher(permutation);
        boolean match=matcher.find();
        int length=0;
        for (int i=0;match;i++) {
            p[i]=Integer.parseInt(matcher.group(1));
            match=matcher.find();
            length++;
        }
        //System.out.println("Lenght of Set: "+length);
        if(length!=order){
            int t[]=new int [length];
            for(int i=0;i<length;i++){
                t[i]=p[i];
            }
            p=new int [length];
            for(int i=0;i<length;i++)
                p[i]=t[i];
        }
        int result=0;
        for(int i=0;i<length;i++){
            result+=(p[i]-1)*factorial(length-1-i);
            for(int j=i+1;j<length;j++){
                if(p[j]>p[i])
                    p[j]--;
            }
        }
        return result;
    }

    public int getIndexOfPermutation(HashSet<String> permutation){
        String permutation_set=permutation.toString();
        int p[]=new int [order];
        Pattern pattern=Pattern.compile("([^\\[, \\]]+)");
        Matcher matcher=pattern.matcher(permutation_set);
        boolean match=matcher.find();
        int length=0;
        int a='a';
        for (int i=0;match;i++) {
            p[i]=matcher.group(1).charAt(0)-a+1;
            match=matcher.find();
            length++;
        }
        //System.out.println("Lenght of Set: "+length);
        if(length!=order){
            int t[]=new int [length];
            for(int i=0;i<length;i++){
                t[i]=p[i];
            }
            p=new int [length];
            for(int i=0;i<length;i++)
                p[i]=t[i];
        }
        int result=0;
        for(int i=0;i<length;i++){
            result+=(p[i]-1)*factorial(length-1-i);
            for(int j=i+1;j<length;j++){
                if(p[j]>p[i])
                    p[j]--;
            }
        }
        return result;
    }

    public void minimalPermutationMethod(String permutation,int repeats){
        int t[]=new int [order];
        Pattern pattern=Pattern.compile("([^\\[, \\]]+)");
        Matcher matcher=pattern.matcher(permutation);
        boolean match=matcher.find();
        for (int i=0;match;i++) {
            t[i]=Integer.parseInt(matcher.group(1));
            match=matcher.find();
        }
        int p[]=new int[order+2];
        int pi[]=new int [order+2];
        int d[]=new int [order+2];
        for (int i=1;i<=order;i++){
            p[i]=i;
            pi[i]=i;
            d[i]=-1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int f=1;f<=order;f++){
            map.put(f,t[f-1]);
        }
        d[1]=0;
        int m=order+1;
        pi[order+1]=m;
        pi[0]=m;

        int c=repeats;
        while(c!=0){
            System.out.println((repeats-c)+" permutation of pi:");
            for(int j=1;j<=order;j++){
                System.out.print(pi[j]+" ");
            }

            System.out.println();
            for(int j=1;j<=order;j++){
                System.out.print(map.get(pi[j])+" ");
            }
            System.out.println();
            System.out.println();
            m=order;
            while (pi[p[m]+d[m]]>m){
                d[m]=-d[m];
                m--;
            }
            int temp=pi[p[m]];
            pi[p[m]]=pi[p[m]+d[m]];
            pi[p[m]+d[m]]=temp;

            temp=p[pi[p[m]]];
            p[pi[p[m]]]=p[m];
            p[m]=temp;

            c--;
        }
    }

    public String generateSubsetByLexograpicNumber(){
        int M=this.M;
        String M_bin=Integer.toBinaryString(M);
        ArrayList<String> result=new ArrayList<String>();
        Iterator it=set.iterator();
        for(int j=0;j<M_bin.length();j++){
            if(M_bin.charAt(j)=='1')
                result.add(Integer.toString(j+1));
            else
                it.next();
        }
        return result.toString();
    }

    public String generateSubsetByLexograpicNumber(int m){
        int M=m;
        String M_bin=Integer.toBinaryString(M);
        ArrayList<String> result=new ArrayList<String>();
        Iterator it=set.iterator();
        for(int j=0;j<M_bin.length();j++){
            if(M_bin.charAt(j)=='1')
                result.add(Integer.toString(j+1));
            else
                it.next();
        }
        return result.toString();
    }

    public String getLexographicNumber(HashSet<String> subset){
        String result="0b";
        Iterator subset_iterator=subset.iterator();
        Iterator set_iterator=set.iterator();
        String s=(String) set_iterator.next();
        String r=(String) subset_iterator.next();
        int o=order;
        while(o!=1){

            if(s==r){
                result+="1";
                s=(String) set_iterator.next();
                if(subset_iterator.hasNext())
                    r=(String) subset_iterator.next();
            }
            else {
                result+="0";
                s=(String) set_iterator.next();
            }
            o--;

        }
        if(s==r)
            result+="1";
        else
            result+="0";
        return result;
    }

    public String generate8bitCodeGray(){
        int t=T;
        String bin_t=Integer.toBinaryString(t);
        String result="";
        result+=bin_t.charAt(0);
        for(int i=1;i<bin_t.length();i++){
            int left_operand=Character.getNumericValue(bin_t.charAt(i-1));
            int right_operand=Character.getNumericValue(bin_t.charAt(i));
            result+=left_operand^right_operand;
        }
        return result;
    }

    public String generate8bitCodeGray(int t){
        String bin_t=Integer.toBinaryString(t);
        //System.out.println(bin_t);
        String result="";
        result+=bin_t.charAt(0);
        for(int i=1;i<bin_t.length();i++){
            int left_operand=Character.getNumericValue(bin_t.charAt(i-1));
            int right_operand=Character.getNumericValue(bin_t.charAt(i));
            result+=left_operand^right_operand;
        }
        return result;
    }

    public void generateAllWordByLength(HashSet<String> alphabet,int length){
        if(length<1){
            throw new NullPointerException("Unvalid lenght: "+length);
        }
        HashMap<Integer,String> map=new HashMap<>();
        Iterator<String> it=alphabet.iterator();
        for(int i=0;it.hasNext();i++){
            map.put(i,it.next());
        }
        int p[]=new int[length];
        int alphabet_size=alphabet.size();
        int c=(int)Math.pow(alphabet_size,length);
        while(c!=0) {
            if(p[length-1]==alphabet_size){
                p[length-1]%=alphabet_size;
                for(int j=length-2;j>=0;j--) {
                    p[j]++;
                    if (p[j] == alphabet_size){
                        p[j] %= alphabet_size;
                    }
                    else{
                        break;
                    }
                }
                continue;
            }
            else{
                for(int i=0;i<length;i++){
                    System.out.print(map.get(p[i])+" ");
                }
                System.out.println();
            }
            c--;
            p[length-1]++;
        }
    }

    public void geretareAllWordsLessThanN(HashSet<String> alphabet,int length){
        for(int i=1;i<=length;i++){
            generateAllWordByLength(alphabet,i);
        }
    }

    public void generateRandowWord(HashSet<String> alphabet,int length){
        if(length<1){
            throw new NullPointerException("Unvalid lenght: "+length);
        }
        HashMap<Integer,String> map=new HashMap<>();
        Iterator<String> it=alphabet.iterator();
        for(int i=0;it.hasNext();i++){
            map.put(i,it.next());
        }
        int alphabet_size=alphabet.size();
        int p[]=new int[length];
        for(int i=0;i<length;i++){
            p[i]= (int) (Math.random() * alphabet_size);
        }
        for(int j=0;j<length;j++){
            System.out.print(map.get(p[j])+" ");
        }
        System.out.println();
    }

    public void generateRandomWordLessThanN(HashSet<String> alphabet,int length){
        int r=1+(int)(Math.random()*length);
        generateRandowWord(alphabet,r);
    }
}
