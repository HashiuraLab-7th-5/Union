package patterntable;

public class CompositeTable extends Support{
	private final int num = 5;
	private String[][] errormap = new String[5][];
	private final String role[] = {"Micro-Structure�_Class","Leaf","Component","Composite"};

	public CompositeTable() {
		super();
	}

	@Override
	protected boolean resolve(String pattern) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		System.out.println("CompositeTable");
		if	(pattern.equals("Composite")) 	return true;
		else								return false;
	}

	@Override
	protected String[][] done() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

		String[][] tmp = {
				{"����1","�Z","�Z","�Z","�@"},
				{"����2"," ","�Z","�~","�Z"},
				{"����3","�~","�~","�@","�@"},
				{"����4","�@","�Z","�@","�~"},
		};
		errormap[0] = role;
		//�G���[���̓ǂݍ��݂��{���͂���
		for(int y = 1; y < num; y++) {
				errormap[y] = tmp[y -1];
		}
		return errormap;
	}
}
