package Fake_comments;

import java.util.Random;

public class Fake_comment {

	public static void main(String[] args)
	{
		Random rand_coments=new Random();
		int  n = rand_coments.nextInt(10)+ 5;
		 System.out.println("������ �� ��������� ���� �� ������ �������: ");
		 System.out.println("...................................................");
		for (int i = 0; i <n; i++)
		{
			
			Names();
			Products();
		    System.out.print("\t\t\t\t");Town();
		    System.out.println("...................................................");
		}
	}
  public static void Town()
  { 
	  String[] town=new String[11];
	  Random random = new Random();
	  int index = random.nextInt(town.length);
	  town[0]="��.�������";
	  town[1]="��.�����";
	  town[2]="��.������";
	  town[3]="��.������";
	  town[4]="��.������";
	  town[5]="��.�����";
	  town[6]="��.����";
	  town[7]="��.������";
	  town[8]="��.���������";
	  town[9]="��.�������";
	  town[10]="��.������������";
	  System.out.println(town[index]);

  }
  public static void Names()
  { 
	  String[] name=new String[11];
	  Random random = new Random();
	  int index = random.nextInt(name.length);
	  name[0]="������ ���������, ";
	  name[1]="������ �������, ";
	  name[2]="�������� �����, ";
	  name[3]="��������� ������, ";
	  name[4]="����� �������, ";
	  name[5]="������ �������, ";
	  name[6]="����� ������, ";
	  name[7]="����� ������, ";
	  name[8]="����� �������, ";
	  name[9]="������ �������, ";
	  name[10]="������ ��������, ";
	  System.out.println(name[index]); 
  }
  public static void Products()
  { 
	  String[] name=new String[8];
	  Random random = new Random();
	  int index = random.nextInt(name.length);
	  name[0]="�������� �������!";
	  name[1]="����� �� ������ ���� �������! \n������ �� �� �� ������! ";
	  name[2]="���������� �� ������ �� ���� ������� ";
	  name[3]="������������� �������! �� �� ���������� �� ���� ��.";
	  name[4]="������� �� ��������! ������ �� \n���� ��� ���� ������������!";
	  name[5]="����� �� ������� ���� ���� �� �� ������ \n������� ��������� �������! \n�������� �!";
	  name[6]="���������� �������! ��������� �� \n���������� ������� �� ���� �������!";
	  name[7]="�� ����� �� ��� ������� �������� \n������� �������! ������ �� ��!";
	  System.out.println(name[index]); 
  }
}
