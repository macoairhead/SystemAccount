/**
 * unitmodel.js
 */

var UnitModel = (function() {
	// クラス定義、コンストラクタ
	function UnitModel(data) {
		// フィールド定義
		var self = this;
		self.id = ko.observable(data.UnitID);
		self.name = ko.observable(data.UnitName);
		self.update = ko.observable(data.UpdateDate);
		self.valid = ko.observable(data.IsValid);
}
	return UnitModel;
})();
