package makererrormap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import marker.JumpMarker;

public class CreateFactoryMethodTable implements ProductTable{

	private Composite container;
	private TabFolder tabfolder;
	private GridData gd = new GridData();

	final String MicroStructure[] = {"Inheritance", "Aggregation", "SubInstance"};
	final String Lole[] = {"Micro-Structure＼Class","Creator","Product","Concrete Creator","Concrete Product"};
	String[][] TableData = {
			{" "," ","〇","〇"},
			{"〇","　","　","　"},
			{"　","　","〇","　"},
	};

	public CreateFactoryMethodTable(Composite container,TabFolder tabfolder) {

		this.tabfolder = tabfolder;
		this.container = container;
		gd.heightHint = 200;
		gd.widthHint = 650;
		gd.horizontalSpan = 2;

	}


	Table newSampleTable() {

		TableViewer viewer = new TableViewer(container,SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
		return viewer.getTable();

	}

	public Table getWidget() {
		// TODO 自動生成されたメソッド・スタブ
		Table table;// = new Table(tabfolder,SWT.NONE);
		TableViewer viewer = new TableViewer(tabfolder,SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);

		table = viewer.getTable();
		table.setLayoutData(gd);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		for(int i = 0; i < Lole.length; i++)
		{
			TableColumn col = new TableColumn(table,SWT.LEFT);
			col.setText(Lole[i]);
			col.setWidth(125);
		}

		for(int i = 1; i <= MicroStructure.length; i++)
		{
			TableItem item = new TableItem(table,SWT.NONE);
			item.setText(0, MicroStructure[i-1]);
			for(int j = 1; j <= 4; j++)
			{
				item.setText(j,TableData[i - 1][j - 1]);
			}
		}

		table.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {

				Point point = new Point(e.x, e.y);
				Table table = (Table) e.getSource();
				TableItem item = table.getItem(point);


				if(item == null) {
					System.out.println("null");
					return;
				}
				for(int columNum = 0; columNum < table.getColumnCount();columNum++) {
					//Columnの位置をforで求める
					if(item.getBounds(columNum).contains(point)) {

						JumpMarker jump = new JumpMarker();
						jump.getMarker(item.getText(0),Lole[columNum]);
						System.out.println("列:" + columNum);
						System.out.println(item.getText(columNum));
						break;

					}
				}
			}
		});

		return table;
	}

//	protected void createEditor(Table table2, TableItem item, int column) {
//		// TODO 自動生成されたメソッド・スタブ
//		final Text text = new Text(table, SWT.NONE);
//		text.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				item.setText(column, text.getText());
//				text.dispose();
//			}
//		});
//		text.addTraverseListener(new TraverseListener() {
//			@Override
//			public void keyTraversed(TraverseEvent e) {
//				switch (e.detail) {
//				case SWT.TRAVERSE_RETURN:
//					item.setText(column, text.getText());
//					text.dispose();
//					break;
//				case SWT.TRAVERSE_ESCAPE:
//					text.dispose();
//					e.doit = false;
//					break;
//				}
//			}
//		});
//
//		TableEditor editor = new TableEditor(table);
//		editor.horizontalAlignment = SWT.LEFT;
//		editor.grabHorizontal = true;
//		editor.minimumWidth = 64;
//		editor.grabVertical = true;
//		editor.setEditor(text, item, column);
//
//		text.setText(item.getText(column));
//		text.selectAll();
//		text.setFocus();
//	}



}
