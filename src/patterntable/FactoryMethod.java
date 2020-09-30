package patterntable;

public class FactoryMethod extends Support{
	private final int num = 5;
	private String[][] errormap = new String[5][];
	private final String role[] = {"Micro-Structure�_Class","Creator","ConcreteCreator","Product","ConcreteProduct"};


	public FactoryMethod() {
		super();
	}
	@Override
	protected boolean resolve(String pattern) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		if	(pattern.equals("Factory Method")) 	return true;
		else									return false;
	}

	@Override
	protected String[][] done() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		String[][] tmp = {
				{"����1","�Z","�Z","�@","�@"},
				{"����2","�Z","�Z","�~","�Z"},
				{"����3","�Z","�Z","�@","�@"},
				{"����4","�@","�@","�Z","�Z"},
		};

		errormap[0] = role;
		//�G���[���̓ǂݍ��݂��{���͂���
		for(int y = 1; y < num; y++) {
				errormap[y] = tmp[y -1];
		}

		return errormap;
	}

}
