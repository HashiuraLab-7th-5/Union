package property;

public class GetSenderProperty extends Property{

	private static GetSenderProperty singleton = new GetSenderProperty();
	private final String file = "ErrorCode_Sender";

	public static Property getInstance() {
		return singleton;
	}

	public GetSenderProperty() {
		fileName = this.file;
	}

	@Override
	void next(PropertyContext context) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		context.changeState(GetViolationProperty.getInstance());
	}

}
