package makererrormap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;

import database.SQLiteSample;

public class ErrorMapMaker {

	private ErrorMapMaker() {

	}

	public static void makeErrorMap(Composite container,TabFolder tabFolder) {

		ArrayList<Map<String,String>> tableData = new ArrayList<Map<String,String>>();
		SQLiteSample sql = new SQLiteSample();
		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();

		String tableName = "union_test"; //����Aggregation�e�[�u��;

		//SQLite���猟�o���ʂ��Ƃ��Ă���
		try {
			sql.conectSample();
			tableData = sql.getTable(tableName);

		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

		//ErrorMap�ւ̃f�[�^�ǉ�
		CreateTab tab = new CreateTab(container,tabFolder);
		tab.createTab();


	}
}
