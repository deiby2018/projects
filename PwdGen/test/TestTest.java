import static org.junit.Assert.*;

import org.junit.Test;

public class TestTest {
	PwdGenMethod var2 = new PwdGenMethod();

	@Test
	public void testKeyWithUpperCase() {

		String opt = "-U";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("With UpperCase :");
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z]*"));

	}

	@Test
	public void testKeyWithUpperAndNumberCase() {

		String opt = "-U -N";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("With Upper And Number Case :");
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z|0-9]*"));

	}

	@Test
	public void testKeyWithLowerAndNumberCase() {

		String opt = "-L -N";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("With Lower And Number Case:");
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[a-z|0-9]*"));

	}

	@Test
	public void testKeyDefault() {

		String opt = "";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("Password Default:");
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z|a-z|0-9]*"));

	}

	@Test
	public void testKeyDefaultSize_10() {

		String opt = "-SIZE:10";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("Default Size 10:");
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z|a-z|0-9]*"));
		assertEquals(true, pwd.length() == 10);
	}

	@Test
	public void testKeyWithOutAmbiguousSize_12() {

		String opt = "-SIZE:12 -A";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("WithOut Ambiguous simbols and  Size:12");
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z|a-z|0-9]*"));
		assertFalse(pwd.matches("[iILl1oO0]*"));
		assertEquals(true, pwd.length() == 12);
	}

	@Test
	public void testKeyTwoPasswordSize_5() {

		String opt = "-SIZE:5 -T:2";
		int numPwdGlobal = 0;
		var2.optPwdGen = opt;

		var2.optGenPwd();
		String pwd[] = new String[Integer.parseInt(var2.menu[8][1])];
		System.out.println();
		System.out.println("Two passwords and size 5:");
		
		for (int i = 0; i < Integer.parseInt(var2.menu[8][1]); i++) {
			pwd[i] = var2.generatorPassword(var2.menu);

			assertEquals(true, pwd[i].matches("[A-Z|a-z|0-9]*"));
			assertEquals(true, pwd[i].length() == 5);
			System.out.println(pwd[i]);
			numPwdGlobal++;
		}
		assertEquals(true, numPwdGlobal == 2);
	}

	@Test
	public void testKeySimbolAndSize_13() {

		String opt = "-SIZE:13 -SM";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("With symbols and size 13:");
		System.out.println(pwd);
		assertEquals(true,
				pwd.contains("$") || pwd.contains("#") || pwd.contains("&") || pwd.contains("(") || pwd.contains(")")
						|| pwd.contains("=") || pwd.contains("?") || pwd.contains("¡") || pwd.contains("¿")
						|| pwd.contains("°") || pwd.contains("|") || pwd.contains("[") || pwd.contains("]"));
		assertEquals(true, pwd.length() == 13);
	}

	@Test
	public void testKeyExcludeSimbol() {

		String opt = "-SM -E:$#&(";
		String pwd = "";
		var2.optPwdGen = opt;

		var2.optGenPwd();
		pwd = var2.generatorPassword(var2.menu);
		System.out.println();
		System.out.println("Exclude symbols -E:$#&( :");
		System.out.println(pwd);
		assertFalse(pwd.contains("$") || pwd.contains("#") || pwd.contains("&") || pwd.contains("("));
		assertEquals(true, pwd.length() == 16);
	}

}
