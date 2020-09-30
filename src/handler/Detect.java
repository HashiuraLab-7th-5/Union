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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
	}

	@Override
	public void dispose() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		System.out.println("execute");

		/*
		 * ���o�̃v���O�����������ɏ����Ăق���
		 * �f�B���N�g�����擾�������ꍇ�́����g���Ă��������B
		 * Text�t�B�[���h�ɕ\������Ă�f�B���N�g����String�Ŏ擾�ł��܂�
		 * View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union.ErrorView");
		 * String directory = view.getDirectory();
		 *
		 * �I�����ꂽ�p�^�[�����Ƃ肽�����́�
		 * String patternname = view.getPattern();
		 */

		//SWT�̍X�V
		update();

		return null;
	}

	private void update() {

		try {
			// �m�F�p
			View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union.ErrorView");
			System.out.println(view.getDirectory());

			view.columsDispone();			// Table�̒��g�폜
			System.out.println("�R�����̍폜");
			view.updateTable();				// Table�̍X�V
			System.out.println("�e�[�u���X�V");
			DeleteMarker.deleteMarker();	// �}�[�J�[�̕t�^
			System.out.println("�}�[�J�[�̍폜");
			CreateMarker.createMarker();	// �}�[�J�[�̍폜
			System.out.println("�}�[�J�[�̒ǉ�");


		} catch (PartInitException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

	}

	@Override
	public boolean isEnabled() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
