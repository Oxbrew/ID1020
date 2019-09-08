class Filtermain {
	public static void main(String[] args) {
		Bracketfilter bf = new Bracketfilter();

		System.out.println(Bracketfilter("(([{}]))"));
		System.out.println(Bracketfilter("{}"));
		System.out.println(Bracketfilter("(({}]))"));
		System.out.println(Bracketfilter(""));
	}
}
