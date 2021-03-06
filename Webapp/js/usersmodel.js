/**
 * usersmodel.js
 */

var UsersModel = (function() {
	// クラス定義、コンストラクタ
	function UsersModel(data) {
		// フィールド定義
		var self = this;
		self.id = ko.observable(data.UserID);
		self.lastname = ko.observable(data.UserNameLast);
		self.firstname = ko.observable(data.UserNameFirst);
		self.name = ko.computed(function() {
			return this.firstname() + " " + this.lastname();
		}, this);
		self.update = ko.observable(data.UpdateDate);
		self.valid = ko.observable(data.IsValid);
		self.unit = ko.observable(" ");
	}

	UsersModel.prototype.setunit = function(u) {
		this.unit(u);
	};


	return UsersModel;
})();
