import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] cod={"p1","p2","p3"};
        String[] desc={"parafusos","cravos","tachas"};
        int[] prezo={3,4,5};

        Scanner scan=new Scanner(System.in);
        File newText=new File(System.getProperty("user.dir")+"/src/main/java/text5.txt");

        RandomAccessFile readAndWrite=new RandomAccessFile(newText,"rw"); //if true añadir
       // RandomAccessFile leer=new RandomAccessFile(newText);

        for (int i = 0; i < cod.length; i++) {
            try {
                readAndWrite.writeChars(autoRellenita(cod[i],3 ));
                readAndWrite.writeChars(autoRellenita(desc[i],10 ));
                readAndWrite.writeInt(prezo[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("?? buscar ??");
        int busca=scan.nextInt();
        scan.nextLine();

        Character c;
        readAndWrite.seek((busca-1)*30);
        for (int j = 0; j < 3; j++) {
            c=readAndWrite.readChar();
            if (c!='*'){
                System.out.print(c);
            }
        }
        System.out.println();
        for (int j = 0; j < 10; j++) {
            c=readAndWrite.readChar();
            if (c!='*'){
                System.out.print(c);
            }
        }
        System.out.println();
        System.out.println(readAndWrite.readInt());
    }















    public static String autoRellenita(String text,int n){
        String newText="";
        for (int i = 0; i < (n-text.length()); i++) {
            newText+="*";
        }
        if (text.length()>n){
            System.out.println("texto demasiado largo");
            newText="";
            for (int i = 0; i < (n); i++) {
                newText+="*";
            }
            return newText;
        }else {
            return newText+=text;
        }
    }
}
