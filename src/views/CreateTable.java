package views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;

public class CreateTable extends Creator{

	Composite container;
	TabFolder tabfolder;

	public CreateTable(Composite container,TabFolder tabfolder) {
		this.container = container;
		this.tabfolder = tabfolder;
	}

	@Override
	public ProductTable createProduct() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return new CreateErrorMap(container,tabfolder);
	}

}
