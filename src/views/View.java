package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import makererrormap.ErrorMapMaker;
import makererrormap.ErrorMessageMaker;
import patterntable.CompositeTable;
import patterntable.FactoryMethod;
import patterntable.Support;

public class View extends ViewPart {
//	Table ErrorMap;
	Table ErrorMessage;
	Text label;
	Button button;
	Combo combo;
	Text text;
	TabFolder tabFolder;
	String path;
	//CreateErrorMap cTable;
	CreateErrorMessage cMessage;
	CreateDirectoryButton cButton;
	CreateComboBox cCombo;
	CreateTabFolder cTabFolder;


	Composite container;

	Support fm;
	Support composite;

	public View() {
		// TODO 自動生成されたコンストラクター・スタブ
		System.out.println("Viewのコンストラクタから");
		fm = new FactoryMethod();
		composite = new CompositeTable();

		composite.setNext(fm);
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO 自動生成されたメソッド・スタブ
		container = new Composite(parent,SWT.NONE);
		container.setLayout(new GridLayout(2,true));

		//タブフォルダー
		cTabFolder = new CreateTabFolder(container);
		tabFolder = cTabFolder.gteTabFolder();

		//cTable = new CreateErrorMap(container);
		cMessage = new CreateErrorMessage(container);
		//CreateTextField cText = new CreateTextField(container);
		cButton = new CreateDirectoryButton(container);
		cCombo = new CreateComboBox(container);


		ErrorMessage = cMessage.getTable();
		combo = cCombo.getCombo();
		button = cButton.getDirectoryButton();
		text = cButton.getText();
	}

	public void updateTable() {
		ErrorMapUpdate();
		ErrorMessageUpdate();
	}

	private void ErrorMapUpdate() {

		ErrorMapMaker.makeErrorMap(container, tabFolder);

	}

	private void ErrorMessageUpdate() {

		//データベースからなんかしら読み取って
		ErrorMessageMaker.makeErrorMessage(ErrorMessage);
	}

	//TableのColumをすべて消す
	public void columsDispone() {

		ErrorMapDispone();
		ErrorMessageDispone();

	}

	private void ErrorMapDispone() {

		//タブを全て消す
		TabItem[] ts = tabFolder.getItems();

		for(int i = 0; i < ts.length; i++)
		{
			ts[i].dispose();
		}

	}

	private void ErrorMessageDispone() {
		ErrorMessage.setRedraw(false);

		ErrorMessage.removeAll();

		ErrorMessage.setRedraw(true);
	}

	//comboから選択されているものを取得
	public String getPattern() {
		return combo.getText();
	}

	public String getDirectory() {
		return text.getText();
	}

	@Override
	public void setFocus() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
