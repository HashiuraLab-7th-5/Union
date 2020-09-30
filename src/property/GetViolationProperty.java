package property;

public class GetViolationProperty extends Property{

	private static GetSenderProperty singleton = new GetSenderProperty();
	private final String file = "ErrorCode_Violation";

	public static Property getInstance() {
		return singleton;
	}

	public GetViolationProperty() {
		fileName = this.file;
	}

	@Override
	void next(PropertyContext context) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		context.changeState(GetSendeeProperty.getInstance());
	}

}
