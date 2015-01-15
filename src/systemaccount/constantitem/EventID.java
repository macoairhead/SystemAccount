package systemaccount.constantitem;

public enum EventID implements EnumValue {
		Joined(100), //入社
		Changes(105),  //異動
		Resigned(109),  //退職
		Grant(200),  //権限を与える
		Revoke(209),  //権限を削除する
		Renaming(103),  //名称変更
		New(300),  //新設
		Disuse(309);//廃止

		//イベントID
		private int value;

		//コンストラクタ
		private EventID(int v){
			this.value = v;
		}

		@Override
		public int getIDValue() {
			// TODO 自動生成されたメソッド・スタブ
			return this.value;
		}

}
