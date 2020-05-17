package Fake_comments;

import java.util.Random;

public class Fake_comment {

	public static void main(String[] args)
	{
		Random rand_coments=new Random();
		int  n = rand_coments.nextInt(10)+ 5;
		 System.out.println("Списък от доволните хора на нашият продукт: ");
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
	  town[0]="гр.Пловдив";
	  town[1]="гр.София";
	  town[2]="гр.Смолян";
	  town[3]="гр.Плевен";
	  town[4]="гр.Бургас";
	  town[5]="гр.Варна";
	  town[6]="гр.Русе";
	  town[7]="гр.Сливен";
	  town[8]="гр.Пазарджик";
	  town[9]="гр.Монтана";
	  town[10]="гр.Димитровград";
	  System.out.println(town[index]);

  }
  public static void Names()
  { 
	  String[] name=new String[11];
	  Random random = new Random();
	  int index = random.nextInt(name.length);
	  name[0]="Емилия Стефанова, ";
	  name[1]="Георги Тодоров, ";
	  name[2]="Севделин Милев, ";
	  name[3]="Маргарита Кетева, ";
	  name[4]="София Сердова, ";
	  name[5]="Левент Стойчев, ";
	  name[6]="Петър Иванов, ";
	  name[7]="Мария Илиева, ";
	  name[8]="Мария Петкова, ";
	  name[9]="Светла Ясенова, ";
	  name[10]="Феодор Саиберов, ";
	  System.out.println(name[index]); 
  }
  public static void Products()
  { 
	  String[] name=new String[8];
	  Random random = new Random();
	  int index = random.nextInt(name.length);
	  name[0]="Уникален продукт!";
	  name[1]="Много ми хареса този продукт! \nТрябва да си го купите! ";
	  name[2]="Заслужават си парите за този продукт ";
	  name[3]="Забележителен продукт! Ще го препоръчам на леля ми.";
	  name[4]="Доволен от продукта! Трябва си \nкупя още един задължително!";
	  name[5]="Добре че срещнах този сайт за да намеря \nтолкова прекрасен продукт! \nУникален е!";
	  name[6]="Невероятен продукт! Заслужава си \nпоследната стотина за този продукт!";
	  name[7]="Не знаех че има толкова уникално \nполезен прокукт! Купете си го!";
	  System.out.println(name[index]); 
  }
}
