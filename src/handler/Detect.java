package handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import marker.CreateMarker;
import marker.DeleteMarker;
import views.View;




public class Detect implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("execute");

		/*
		 * 検出のプログラムをここに書いてほしい
		 * ディレクトリが取得したい場合は↓を使ってください。
		 * Textフィールドに表示されてるディレクトリがStringで取得できます
		 * View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union.ErrorView");
		 * String directory = view.getDirectory();
		 *
		 * 選択されたパターンがとりたい時は↓
		 * String patternname = view.getPattern();
		 */

		//SWTの更新
		update();

		return null;
	}

	private void update() {

		try {
			// 確認用
			View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union.ErrorView");
			System.out.println(view.getDirectory());

			view.columsDispone();			// Tableの中身削除
			System.out.println("コラムの削除");
			view.updateTable();				// Tableの更新
			System.out.println("テーブル更新");
			DeleteMarker.deleteMarker();	// マーカーの付与
			System.out.println("マーカーの削除");
			CreateMarker.createMarker();	// マーカーの削除
			System.out.println("マーカーの追加");


		} catch (PartInitException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
