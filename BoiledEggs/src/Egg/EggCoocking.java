package Egg;

import java.util.ArrayList;
import java.util.Scanner;

public class EggCoocking {
	ArrayList<Egg> eggs= new ArrayList<Egg>();
	public EggCoocking(ArrayList<Egg> eggs) {
		super();
		this.eggs = eggs;
	}

	public EggCoocking() {
	}

	public ArrayList<Egg> getEggs() {
		return eggs;
	}

	public void setEggs(ArrayList<Egg> eggs) {
		this.eggs = eggs;
	}
	
	public void receipEggs()
	{
		System.out.println("������ �� ����� � ������, � �����, � ��� �� ������ � � ��������.");
		Scanner sc = new Scanner(System.in);
		Scanner time = new Scanner(System.in);
		int t;
	     int k ;
	     Container c = null;
		do {
		System.out.print("����� ���� ������ �� ������: ");
		k=sc.nextInt();
		} while(k<0);
	     if(k>0 && k<=6)
	     {
	    	c=Container.Джезве;
	     }else if (k>7 && k<=12)
	     {
	    	 c=Container.Канче;
	     }else if(k>12)
	     {
	    	c=Container.Тенджера;
	     }
	     System.out.println("����� ������ ��� � :"+c);
	     System.out.println(); 
	     System.out.println("  ������� se ������������� "
	     		+ "\n  � �� ������� ��� ������� ����, ����,"
	     		+ "\n  �� ������ �� �� ������. �� ���� ����� "
	     		+ "\n  �� �������� ���������� �� ��������.");
	     System.out.println();
	    
	     do {
	 		System.out.print("����� �����  ������ �� ������: ");
	 		t=sc.nextInt();
	 	 } while(t<0);
	     if(t>0 && t<=3)
	     {
	    	System.out.println("������ ��, ����� �������� � "+c+" �� ����� ������ ���� "+t+" ���, ����� �� �� ����� , ����� ������� � ������� �� �� �����");
	     }else if (t>3 && t<=5)
	     {
	    	 System.out.println("������ ��, ����� �������� � "+c+" �� ����� ������ ���� "+t+" ���, ����� ,�������  �� e ���e� � ������� �����");
	     }else if(t>5)
	     {
	    	 System.out.println("������ ��, ����� �������� � "+c+" �� ����� ������ ���� "+t+" ���, � ������� � ������� �� �� ������");
	     }
	  
	}
    
  }

