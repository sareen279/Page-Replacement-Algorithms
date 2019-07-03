import java.util.*;

public class fifo1
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of frames");
		int f = s.nextInt();
		System.out.println("Enter the number of pages");
		int p = s.nextInt();
		int p1[] = new int[p];
		int f1[] = new int[f];
		int hit = 0,fault = 0,ind = 0;
		boolean flagf = true;
		System.out.println("Enter the pages -");
		for(int i = 0;i < p;i++)
			p1[i] = s.nextInt();
		for(int i = 0;i < f;i++)
			f1[i] = -1;
		for(int i = 0;i < p;i++)
		{
			flagf = true;
			for(int j = 0;j < f;j++)
			{
				if(p1[i] == f1[j])
				{
					hit++;
					flagf = false;
					break;
				}
			}
			if(flagf)
			{
				fault++;
				f1[ind] = p1[i];
				ind++;
				if(ind == f)
					ind = 0;
			}
			for(int j = 0;j < f;j++)
				System.out.print(f1[j]);
			System.out.println("\n");
		}
		System.out.println("Hits - " + hit + " faults - " + fault);
	}
}