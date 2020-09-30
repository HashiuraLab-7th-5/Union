package patterntable;

public class CompositeTable extends Support{
	private final int num = 5;
	private String[][] errormap = new String[5][];
	private final String role[] = {"Micro-Structure＼Class","Leaf","Component","Composite"};

	public CompositeTable() {
		super();
	}

	@Override
	protected boolean resolve(String pattern) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("CompositeTable");
		if	(pattern.equals("Composite")) 	return true;
		else								return false;
	}

	@Override
	protected String[][] done() {
		// TODO 自動生成されたメソッド・スタブ

		String[][] tmp = {
				{"特徴1","〇","〇","〇","　"},
				{"特徴2"," ","〇","×","〇"},
				{"特徴3","×","×","　","　"},
				{"特徴4","　","〇","　","×"},
		};
		errormap[0] = role;
		//エラー情報の読み込みが本当はある
		for(int y = 1; y < num; y++) {
				errormap[y] = tmp[y -1];
		}
		return errormap;
	}
}
