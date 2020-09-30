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
		// TODO 自動生成されたメソッド・スタブ
		context.changeState(GetViolationProperty.getInstance());
	}

}
