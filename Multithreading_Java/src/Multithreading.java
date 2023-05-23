import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class Multithreading {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of threads");
        int n = sc.nextInt();
        int start = 1;
        int end = 1000000000/n;
        for (int i = 1; i <= n; i++) {
            File file = new File("C:\\Users\\bhara\\IdeaProjects\\Multithreading_Java\\"+i+".txt");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
            Thread thr = new Thread(new Run(start, end, i));
            thr.start();
            try {
                thr.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            start=end+1;
            end=(i+1)*1000000000/n;


        }
    }
}

class Run implements Runnable
        {
            int start;
            int end;
            int fileID;
            public Run(int start,int end, int fileID)
            {
                this.start=start;
                this.end=end;
                this.fileID=fileID;

            }

            @Override
            public void run() {
                long startTime=System.currentTimeMillis();
                for (int i=start;i<=end;i++)
                {
                    System.out.println(i);
                }
                long stopTime=System.currentTimeMillis();
                long diffTime=stopTime-startTime;
                System.out.println("This is the time required to run the program");
                System.out.println(diffTime);
            }
        }
