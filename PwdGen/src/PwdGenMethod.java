import java.util.Random;
import java.util.Scanner;

public class PwdGenMethod {

	
	Random random = new Random();
	public static String optPwdGen;
	
	String[] upperCase = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	String[] lowerCase = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "v", "w", "x", "y", "z" };
	String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	String[] simbols = { "$", "#", "&", "/", "(", ")", "=", "?", "¡", "¿", "°", "|", "[", "[", "]" };
	String ambiguousString = "iILl1oO0";
	String[][] menu = { { "-SIZE:", "16" }, // Values by default to generate password where contains  
			{ "-U", "true" }, 				//size 16, Capital Letter, Small letter, Numbers
			{ "-L", "true" }, 
			{ "-N", "true" }, 
			{ "-SM", "false" },
			{ "-A", "false" }, 
			{ "-E:", "" }, 
			{ "-C", "false" },
			{ "-T:", "1" } };

/**
 * This method checks user options and build the string with preferences of this
 */
	public void optGenPwd() {
		// > java PwdGen –Size:16 –U –L –N –SM –A –E:[]{}@ –T:3 -C
		// default size 16, Capital Letter, Small letter, Numbers
		if (optPwdGen.contains("-?")) {
			System.out.println("Ejemplo: –SIZE:16 –U –L –N –SM –A –E:[]{}@ –T:3 -C ");
			System.out.println("-SIZE: Tamaño de la contraseña");
			System.out.println("-U: Incluir letras en mayúsculas");
			System.out.println("-L: Incluir letras en minúsculas");
			System.out.println("-N: Incluir números");
			System.out.println("-SM: Incluir simbolos");
			System.out.println("-A: Excluye los caracteres antiguos");
			System.out.println("-E: Excluir los simbolos suministrados");
			System.out.println("-C: Copia de la Contraseña");
			System.out.println("-T: Generar Contraseñas");
			System.out.println("");
			System.out.println();
		}

		// it Checks if there are any value different to default
		if (optPwdGen.contains(menu[1][0]) || optPwdGen.contains(menu[2][0])) {
			menu[1][1] = "false";
			menu[2][1] = "false";
			menu[3][1] = "false";
		}
		
		// it Checks the size of password
		if (optPwdGen.contains(menu[0][0]))// -SIZE: Tamaño de la contraseña
		{
			String searchString = menu[0][0];
			String cadTemp = "";
			int startIndex = optPwdGen.indexOf(searchString);
			cadTemp = optPwdGen.substring(startIndex);
			int endIndex = cadTemp.indexOf(" ");
			if (endIndex == -1)
				endIndex = cadTemp.length();

			startIndex = menu[0][0].length();
			cadTemp = cadTemp.substring(startIndex, endIndex);

			menu[0][1] = cadTemp;
		}
		
		if (optPwdGen.contains(menu[1][0]))// -U: Include capital letter
			menu[1][1] = "true";
		if (optPwdGen.contains(menu[2][0]))// -L: Include small letter
			menu[2][1] = "true";
		if (optPwdGen.contains(menu[3][0]))// -N: Include numbers
			menu[3][1] = "true";
		if (optPwdGen.contains(menu[4][0]))// -S: Include symbols
			menu[4][1] = "true";
		if (optPwdGen.contains(menu[5][0]))// -A: Exclude ambiguous characters
											
			menu[5][1] = "true";
		if (optPwdGen.contains(menu[6][0]))// -E: Exclude  symbols enter
											
		{
			String searchString = menu[6][0];
			String cadTemp = "";
			int startIndex = optPwdGen.indexOf(searchString);
			cadTemp = optPwdGen.substring(startIndex);
			int endIndex = cadTemp.indexOf(" ");
			if (endIndex == -1)
				endIndex = cadTemp.length();
			startIndex = menu[6][0].length();
			cadTemp = cadTemp.substring(startIndex, endIndex);

			menu[6][1] = cadTemp;
		}

		if (optPwdGen.contains(menu[7][0]))// -C: copy passwords
			menu[7][1] = "true";
		if (optPwdGen.contains(menu[8][0]))// -T: Generate passwords
		{
			String searchString = menu[8][0];
			String stringTemp = "";
			int startIndex = optPwdGen.indexOf(searchString);
			stringTemp = optPwdGen.substring(startIndex);
			int endIndex = stringTemp.indexOf(" ");
			if (endIndex == -1)
				endIndex = stringTemp.length();
			startIndex = menu[6][0].length();
			stringTemp = stringTemp.substring(startIndex, endIndex);

			menu[8][1] = stringTemp;
		}

	}

	/**
	 * 
	 * @param opt : it is configuration of  password that user prefer 
	 * @return
	 */
	public String generatorPassword(String[][] opt) {

		int sizePwd = Integer.parseInt(opt[0][1]);
		int cont = 0;
		String password = "";
		while (cont < sizePwd) {

			switch (random.nextInt(5)) {
			case 1:
				if (opt[1][1] == "true")// UpperCase
				{
					String capitalLetter = upperCase[random.nextInt(25)];
					if (!opt[6][1].contains(capitalLetter) && opt[5][1] == "false")// Whitout characters
																						
					{
						password = password + capitalLetter;
						cont++;
					}
					if (!opt[6][1].contains(capitalLetter) && opt[5][1] == "true")// Whitout ambiguous
																						
					{
						if (!ambiguousString.contains(capitalLetter)) {
							password = password + capitalLetter;
							cont++;
						}
					}

				}
				break;
			case 2:
				if (opt[2][1] == "true")// lowerCase
				{
					String letraMinus = lowerCase[random.nextInt(25)];
					if (!opt[6][1].contains(letraMinus) && opt[5][1] == "false")// Whitout characters
																							
					{
						password = password + letraMinus;
						cont++;
					}
					if (!opt[6][1].contains(letraMinus) && opt[5][1] == "true")// Whitout ambiguous
																							
					{
						if (!ambiguousString.contains(letraMinus)) {
							password = password + letraMinus;
							cont++;
						}
					}
				}
				break;
			case 3:
				if (opt[3][1] == "true")// numbers
				{
					String nro = numbers[random.nextInt(9)];
					if (!opt[6][1].contains(nro) && opt[5][1] == "false")// Whitout characters
																					
					{
						password = password + nro;
						cont++;
					}
					if (!opt[6][1].contains(nro) && opt[5][1] == "true")//  Whitout ambiguous
																					
					{
						if (!ambiguousString.contains(nro)) {
							password = password + nro;
							cont++;
						}
					}
				}
				break;
			case 4:
				if (opt[4][1] == "true")// simbols
				{
					String simb = simbols[random.nextInt(14)];
					if (!opt[6][1].contains(simb) && opt[5][1] == "false")// Whitout characters
																					 
					{
						password = password + simb;
						cont++;
					}
					if (!opt[6][1].contains(simb) && opt[5][1] == "true")// Whitout ambiguous
																					
					{
						if (!ambiguousString.contains(simb)) {
							password = password + simb;
							cont++;
						}
					}
				}
				break;
			default:
				break;
			}

		}
		return password;

	}

}
