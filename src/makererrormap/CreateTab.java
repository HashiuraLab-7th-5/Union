package makererrormap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;

public class CreateTab {

	Creator tablecreator;
	TabFolder tabFolder;
	GridData gd = new GridData();


	public CreateTab(Composite container,TabFolder tabFolder) {

		this.tabFolder = tabFolder;
		tablecreator = new CreateTable(container,tabFolder);

		gd.heightHint = 200;
		gd.widthHint = 650;
	}


	public void createTab() {

		TabItem item = new TabItem(tabFolder,SWT.NONE);

		ProductTable tablemap = tablecreator.createProduct();
		Table errormap = tablemap.getWidget();
		item.setText("ƒ^ƒu");
		item.setControl(errormap);

	}
}
