import java.util.Scanner;
public class main{
    public static void main(String[] args){

        int[][] arr ={
                    {1,2,3},
                    {4,5,6},
                    {7,8,9},
                  };

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]+"|");
            }
            System.out.print("\n");
        }

        boolean[][] check = new boolean[3][3];
        int[][] char_o = new int[3][3];
        int[][] char_x = new int[3][3];
        boolean exit = false;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                check[i][j] = false;
            }
        }


        int last=0;
        int draw;
        int first_input,second_input;
        Scanner input = new Scanner(System.in);
        
        do{
                draw=0;
            do{
            System.out.print("Enter X between 1 and 9 -- ");
            first_input = input.nextInt();
            }
            while(first_input<1 || first_input>9);

            
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(arr[i][j]==first_input){
                        arr[i][j] = 88;
                        check[i][j] = true;
                        char_x[i][j] = 88;
                    }
                }
            }

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                   if(check[i][j]==true){

                    if(char_x[i][j]==88){
                        System.out.print((char)arr[i][j]+"|");
                    }
                    else if(char_o[i][j]==79){
                        System.out.print((char)arr[i][j]+"|");
                    }
                    else{
                        System.out.print(arr[i][j]+"|");
                    }
                 }
                 else{
                        System.out.print(arr[i][j]+"|");
                    }
            }
                System.out.print("\n");
       }

            boolean diagonal_1 = is_diagonal(arr);
            boolean sec_diagonal_1 = secondary_diagonal(arr);
            boolean row_1 = is_row(arr);
            boolean col_1 = is_col(arr);

            if(diagonal_1==true || sec_diagonal_1==true || row_1==true || col_1==true){
                System.out.print("Player one won!");
                break;
            }

            
    /*Draw logic */       for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(arr[i][j]==88 || arr[i][j]==79){
                        draw++;
                    }
                }
            }

            if(draw==9)
            {
                exit=true;
                System.out.print("Game over ");
                break;
            }

            do{
            System.out.print("Enter O between 1 and 9 -- ");
            second_input = input.nextInt();
            }
            while(second_input<1 || second_input>9);

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(arr[i][j]==second_input){
                        arr[i][j] = 79;
                        check[i][j] = true;
                        char_o[i][j] = 79;
                    }
                }
            }

            boolean diagonal_2 = is_diagonal(arr);
            boolean sec_diagonal_2 = secondary_diagonal(arr);
            boolean row_2 = is_row(arr);
            boolean col_2 = is_col(arr);

            if(diagonal_2==true || sec_diagonal_2==true || row_2==true || col_2==true){
                System.out.print("Player two won!");
                break;
            }

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                   if(check[i][j]==true){

                    if(char_o[i][j]==79){
                        System.out.print((char)arr[i][j]+"|");
                    }
                    else if(char_x[i][j]==88){
                        System.out.print((char)arr[i][j]+"|");
                    }
                    else{
                        System.out.print(arr[i][j]+"|");
                    }
                    
                 }
                  else{
                        System.out.print(arr[i][j]+"|");
                    }
            }
                System.out.print("\n");
       }

            if(diagonal_1==true ||sec_diagonal_1==true ||row_1==true
    
              || col_1==true || col_2==true ||diagonal_2==true ||sec_diagonal_2==true ||row_2==true
            ){
                last=5;
            }
        
        
    }
        while (last != 5 && !exit);

}

public static boolean is_diagonal(int[][] arr){

    int one=0;
    int two=0;

    for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                 if(i==j && arr[i][j]==88){
                    one++;
                 }

                 else if(i==j && arr[i][j]==79){
                    two++;
                 }
            }
        }

        if(one==3 || two==3){
            return true;
        }
        else{
            return false;
        }
}

public static boolean secondary_diagonal(int[][] arr){

    int one=0;
    int two=0;

    for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                 if(i+j==2 && arr[i][j]==88){
                    one++;
                 }

                 else if(i+j==2 && arr[i][j]==79){
                    two++;
                 }
            }
        }

        if(one==3 || two==3){
            return true;
        }
        else{
            return false;
        }
   }

public static boolean is_col(int[][] arr){
    int one;
    int two;
    boolean found_1=false;
    boolean found_2=false;

    for(int i=0;i<3;i++){
        one=0;
        two=0;
        for(int j=0;j<3;j++){
            if(arr[j][i]==88){
                one++;
            }
            else if(arr[j][i]==79){
                two++;
            }
        }

        if(one==3){
            found_1=true;
            break;
        }
        else if(two==3){
            found_2=true;
            break;
        }
    }

    if(found_1 || found_2){
        return true;
    }
    else{
        return false;
    }
}

public static boolean is_row(int[][] arr){
    int one,two;
    boolean found_1=false;
    boolean found_2=false;
    boolean outer_1=false;
    boolean outer_2=false;

    for(int i=0;i<3;i++){
        one=0;
        two=0;
        for(int j=0;j<3;j++){
        if(arr[i][j]==88){
            one++;
            if(one==3){
                found_1=true;
                break;
            }
        }

        else if(arr[i][j]==79){
            two++;
            if(two==3){
                found_2=true;
                break;
            }
        }

        if(found_1){
            outer_1=true;
            break;
        }
        else if(found_2){
            outer_2=true;
            break;
        }
    }
}


    if(outer_1 || outer_2){
        return true;
    }
    else{
        return false;
    }
    
   }

}




