package property;

import java.io.File;
import java.io.IOException;

public class GetSendeeProperty extends Property{

	private static GetSendeeProperty singleton = new GetSendeeProperty();
	private final String file = "ErrorCode_Sendee";

	public static Property getInstance() {
		return singleton;
	}

	public GetSendeeProperty() {
		fileName = this.file;
	}

	@Override
	void next(PropertyContext context) {
		// TODO 自動生成されたメソッド・スタブ
		context.changeState(GetSenderProperty.getInstance());
	}

}
