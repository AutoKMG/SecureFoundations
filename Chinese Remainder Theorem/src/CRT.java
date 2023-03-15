import java.util.ArrayList;
import java.util.Scanner;

public class CRT {

    static public long chineseRemainderTheorem(ArrayList<ModItem> items){
        long bigM = 1;
        long finalA = 0;
        long answerX = 0;
        for(ModItem modItem : items){
            bigM *= modItem.m;
        }
        for(ModItem modItem : items){
            modItem.bigM = bigM / modItem.m;
        }
        for (ModItem modItem : items){
            long inverse = modItem.gcdExtended(modItem.bigM,modItem.m)[1];
            if(inverse < 0){
                modItem.mInverse = inverse + modItem.m;
            }  else {
                modItem.mInverse = inverse;
            }
        }
        for (ModItem modItem : items){
            finalA += modItem.a * modItem.bigM * modItem.mInverse;
        }
        answerX = finalA % bigM;
        return answerX;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ModItem> items = new ArrayList<ModItem>();
        System.out.print("How many equations you are going to enter?: \n");
        int equationsNum = scanner.nextInt();
        System.out.println("Please start adding the data of these equations");
        for (int i = 0; i<equationsNum;i++){
            System.out.println((i+1) + " Equation");
            System.out.print("a: ");
            long a = scanner.nextLong();
            System.out.print("m: ");
            long m = scanner.nextLong();
            items.add(new ModItem(a,m));
        }

        System.out.println(chineseRemainderTheorem(items));;
    }
}
