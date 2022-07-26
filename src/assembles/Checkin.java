package assembles;

import java.util.Random;

public class Checkin {

	int rnd;
	int rnd2;
	char rnd3;
	char rnd4;
	char rnd5;
	char rnd6;
	String rndstr1;
	String rndstr2;
	String rndstr3;
	String rndstr4;
	String rndstr5;
	String rndstr6;
	String rndstrs;

	public String Songjang() {
		rnd = new Random().nextInt(99) + 100;
		rnd2 = new Random().nextInt(89) + 10;
		rnd3 = (char) (new Random().nextInt(26) + 65);
		rnd4 = (char) (new Random().nextInt(26) + 65);
		rnd5 = (char) (new Random().nextInt(26) + 65);
		rnd6 = (char) (new Random().nextInt(26) + 65);

		rndstr1 = Integer.toString(rnd);
		rndstr2 = Integer.toString(rnd2);
		rndstr3 = String.valueOf(rnd3);
		rndstr4 = String.valueOf(rnd4);
		rndstr5 = String.valueOf(rnd5);
		rndstr6 = String.valueOf(rnd6);

		rndstrs = rndstr1 + rndstr3 + rndstr4 + rndstr2 + rndstr5 + rndstr6;

		return rndstrs;
	}

}
