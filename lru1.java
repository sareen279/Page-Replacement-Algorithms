import java.util.*;

public class lru1
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of frames");
		int f = s.nextInt();
		System.out.println("Enter the length of pages");
		int p = s.nextInt();
		int p1[] = new int[p];
		int f1[] = new int[f];
		int sol[][] = new int[p][f];
		int i,j,k,cnt,fault = 0,hit = 0,ind = 0,pos = 0;
		boolean flagf,isFull = false,flag = true;
		System.out.println("Enter the pages");
		for(i = 0;i < p;i++)
		{
			p1[i] = s.nextInt();
		}
		for(i = 0;i < f;i++)
		{
			f1[i] = -1;
		}
		for(i = 0;i < p;i++)
		{
			flagf = true;
			for(j = 0;j < f;j++)
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
				if(isFull)
				{
					cnt = p;
					pos = 0;
					for(j = 0;j < f;j++)
					{
						for(k = (i-1);k >= 0;k--)
						{
							flag = true;
							if(f1[j] == p1[k])
							{
								if(k < cnt)
								{
									cnt = k;
									pos = j;
								}
								flag = false;
								break;
							}
						}
						if(flag == true)
						{
							pos = j;
							cnt = p;
							break;
						}
					}
					f1[pos] = p1[i];
				}
				else
				{
					f1[ind] = p1[i];
					ind++;
					if(ind == f)
					{
						ind = 0;
						isFull = true;
					}
				}
			}
			for(j = 0;j < f;j++)
			{
				System.out.print(f1[j]);
			}
			System.out.println("\n");
		}
		System.out.println("Hits - " + hit + " Faults - " + fault);
	}
}