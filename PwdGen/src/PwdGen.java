import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PwdGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PwdGenMethod var = new PwdGenMethod();

		if (args.length == 0) {
			var.optPwdGen = " ";
		} else {

			for (int i = 0; i < args.length; i++) {
				var.optPwdGen = var.optPwdGen + args[i] + " ";

			}
		}

		var.optGenPwd();

		int numbersPassword = Integer.parseInt(var.menu[8][1]);
		String passwords[] = new String[numbersPassword];
		boolean pwdDifferent = false;

		while (!pwdDifferent) {
			for (int i = 0; i < numbersPassword; i++) {
				passwords[i] = var.generatorPassword(var.menu);
			}
			if (numbersPassword < 2)
				break;
			for (int i = 0; i < numbersPassword; i++) {
				for (int j = 0; j < numbersPassword; j++) {
					if (i != j)
						if (passwords[i] == passwords[j] && i != j) {
							pwdDifferent = false;
							break;
						}
					if (passwords[i] != passwords[j] && i != j) {
						pwdDifferent = true;
					}
				}
			}
		}
		for (int i = 0; i < passwords.length; i++) {
			System.out.println(passwords[i]);

			StringSelection selection = new StringSelection(passwords[i]);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
		}

	}
}
